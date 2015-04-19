package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.Atleta;
import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.Prontuario;

public class ProntuarioDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	
	public ProntuarioDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public ProntuarioDAO(Connection con) throws Exception{
        this.con = con;        
    }

	public boolean inserir(Prontuario prontuario) throws SQLException {
		boolean retorno = false;
		int rows = 0;
		
		stmtScript = con.prepareStatement("INSERT INTO prontuario (idAtleta, idUsuario, dtAtendimento, hrAtendimento, anotacao)"
				+ "VALUES (?, ?, ?, ?, ?)");
		
		stmtScript.setInt(1, prontuario.getAtleta().getIdPessoa());
		stmtScript.setInt(2, prontuario.getUsuario().getIdPessoa());
		stmtScript.setDate(3, new java.sql.Date(prontuario.getDtAtendimento().getTime()));
		stmtScript.setTime(4, new java.sql.Time(prontuario.getHrAtendimento().getTime()));
		stmtScript.setString(5, prontuario.getAnotacao());
		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			retorno = true;
		}	
		
		return retorno;
	}

	public List<Prontuario> buscaHistorico(int idAtleta, int idUsuario) throws SQLException {
		List<Prontuario> lista = new ArrayList<Prontuario>();
		
		stmtScript = con.prepareStatement("SELECT idProntuario, dtAtendimento, hrAtendimento, anotacao "
		+ "FROM prontuario "
		+ "WHERE idAtleta = ? "
		+ "	AND idUsuario = ? "
		+ "ORDER BY dtAtendimento DESC, hrAtendimento DESC ");
		
		stmtScript.setInt(1, idAtleta);
		stmtScript.setInt(2, idUsuario);
		
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			Prontuario prontuario = new Prontuario();
			prontuario.setIdProntuario(rs.getInt(1));
			prontuario.setDtAtendimento(rs.getDate(2));
			prontuario.setHrAtendimento(rs.getTime(3));
			prontuario.setAnotacao(rs.getString(4));
			lista.add(prontuario);
		}
		return lista;
	}

	public List<Prontuario> buscaUltimosAtend(int idUsuario) throws SQLException {
		List<Prontuario> lista = new ArrayList<Prontuario>();
		
		stmtScript = con.prepareStatement("SELECT idProntuario, p.idAtleta, nome, dtAtendimento, hrAtendimento, anotacao "
		+ "FROM prontuario p "
		+ "		INNER JOIN atleta a "
		+ "			ON p.idAtleta = a.idAtleta "
		+ "WHERE idUsuario = ? "
		+ "ORDER BY dtAtendimento DESC, hrAtendimento DESC ");
		
		stmtScript.setInt(1, idUsuario);
		
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			Prontuario prontuario = new Prontuario();
			Atleta atleta = new Atleta();
			
			prontuario.setIdProntuario(rs.getInt(1));
			prontuario.setDtAtendimento(rs.getDate(4));
			prontuario.setHrAtendimento(rs.getTime(5));
			prontuario.setAnotacao(rs.getString(6));
			prontuario.setAtleta(atleta);
			
			atleta.setIdPessoa(rs.getInt(2));
			atleta.setNome(rs.getString(3));
			
			lista.add(prontuario);
		}
		return lista;
	}

	public boolean excluir(int idProntuario) throws SQLException {
		boolean retorno = false;
		int rows = 0;
		
		stmtScript = con.prepareStatement("DELETE FROM prontuario WHERE idProntuario = ?");
		stmtScript.setInt(1, idProntuario);		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			retorno = true;
		}	
		return retorno;
	}

//	public boolean excluirDiasTreinoAtleta(int idAtleta) throws SQLException {
//		boolean retorno = false;
//		int rows = 0;
//		
//		stmtScript = con.prepareStatement("DELETE FROM diatreinoatleta WHERE idAtleta = ?");
//		
//		stmtScript.setInt(1, idAtleta);
//		
//		rows = stmtScript.executeUpdate();
//		
//		if(rows>0){
//			retorno = true;
//		}	
//		
//		return retorno;
//	}
//
//	public DiaTreino buscarDiaTreino(int semana, int idAtleta, Date hr) throws SQLException {
//		stmtScript = con.prepareStatement("SELECT d.* FROM diatreino d "
//				+ "JOIN diatreinoatleta a on d.idDiaTreino = a.idDiaTreino "
//				+ "WHERE d.idDiaSemana = ?"
//				+ " AND a.idAtleta = ?"
//				+ " AND hrInicio < ?"
//				+ " AND hrFim > ?");
//		
//		stmtScript.setInt(1, semana);
//		stmtScript.setInt(2, idAtleta);
//		stmtScript.setTime(3, new java.sql.Time(hr.getTime()));
//		stmtScript.setTime(4, new java.sql.Time(hr.getTime()));
//		
//		ResultSet rs = stmtScript.executeQuery();
//		
//		DiaTreino dia = new DiaTreino();
//		if(rs.next()){			
//			dia.setIdDiaTreino(rs.getInt("idDiaTreino"));
//			dia.setIdDiaDaSemana(rs.getInt("idDiaSemana"));
//			dia.setHrInicio(rs.getTime("hrInicio"));
//			dia.setHrFim(rs.getTime("hrFim"));
//		}
//		return dia;
//	}
}
