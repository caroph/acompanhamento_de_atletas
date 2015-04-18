package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.DiaTreino;

public class DiaTreinoDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	
	public DiaTreinoDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public DiaTreinoDAO(Connection con) throws Exception{
        this.con = con;        
    }

	public boolean inserir(DiaTreino dia) throws SQLException {
		boolean retorno = false;
		int rows = 0;
		
		stmtScript = con.prepareStatement("INSERT INTO diaTreino (idTpEquipe, idDiaSemana, hrInicio, hrFim)"
				+ "VALUES (?, ?, ?, ?)");
		
		stmtScript.setInt(1, dia.getIdTpEquipe());
		stmtScript.setInt(2, dia.getIdDiaSemana());
		stmtScript.setTime(3, new java.sql.Time(dia.hrInicio.getTime()));
		stmtScript.setTime(4, new java.sql.Time(dia.hrFim.getTime()));
		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			retorno = true;
		}	
		
		return retorno;
	}
	
	public List<DiaTreino> buscaDiasTreinos() throws SQLException{
		List<DiaTreino> lista = new ArrayList<DiaTreino>();
		
		stmtScript = con.prepareStatement("SELECT idDiaTreino, idTpEquipe, idDiaSemana, hrInicio, hrFim "
				+ "FROM diaTreino t "
				+ "WHERE t.flCadastroAtivo = 1 "
				+ "ORDER BY idDiaSemana, hrInicio, hrFim ");
		
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			DiaTreino dia = new DiaTreino();
			dia.setIdDiaTreino(rs.getInt("idDiaTreino"));
			dia.setIdTpEquipe(rs.getInt("idTpEquipe"));
			dia.setIdDiaDaSemana(rs.getInt("idDiaSemana"));
			dia.setHrInicio(rs.getTime("hrInicio"));
			dia.setHrFim(rs.getTime("hrFim"));
			lista.add(dia);
		}
		return lista;
	}
	
	public boolean desativar(DiaTreino dia) throws SQLException {
		boolean retorno = false;
		int rows = 0;
		
		stmtScript = con.prepareStatement("UPDATE diaTreino SET flCadastroAtivo = 0 WHERE idDiaTreino = ?");
		
		stmtScript.setInt(1, dia.getIdDiaTreino());
		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			retorno = true;
		}	
		
		return retorno;
	}

	public List<DiaTreino> carregaDiasTreino(int idTpEquipe) throws SQLException {
		List<DiaTreino> lista = new ArrayList<DiaTreino>();
		
		stmtScript = con.prepareStatement("SELECT idDiaTreino, idDiaSemana, hrInicio, hrFim "
				+ "FROM diaTreino t "
				+ "WHERE t.flCadastroAtivo = 1 AND idTpEquipe = ? "
				+ "ORDER BY idDiaSemana, hrInicio, hrFim ");
		
		stmtScript.setInt(1, idTpEquipe);
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			DiaTreino dia = new DiaTreino();
			dia.setIdDiaTreino(rs.getInt("idDiaTreino"));
			dia.setIdDiaDaSemana(rs.getInt("idDiaSemana"));
			dia.setHrInicio(rs.getTime("hrInicio"));
			dia.setHrFim(rs.getTime("hrFim"));
			lista.add(dia);
		}
		return lista;
	}

	public boolean inserirDiaTreinoAtleta(String idDia, int idAtleta) throws SQLException {
		boolean retorno = false;
		int rows = 0;
		
		stmtScript = con.prepareStatement("INSERT INTO diaTreinoAtleta (idDiaTreino, idAtleta)"
				+ "VALUES (?, ?)");
		
		stmtScript.setInt(1, Integer.parseInt(idDia));
		stmtScript.setInt(2, idAtleta);
		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			retorno = true;
		}	
		
		return retorno;
	}

	public boolean excluirDiasTreinoAtleta(int idAtleta) throws SQLException {
		boolean retorno = false;
		int rows = 0;
		
		stmtScript = con.prepareStatement("DELETE FROM diatreinoatleta WHERE idAtleta = ?");
		
		stmtScript.setInt(1, idAtleta);
		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			retorno = true;
		}	
		
		return retorno;
	}

	public DiaTreino buscarDiaTreino(int semana, int idAtleta, Date hr) throws SQLException {
		stmtScript = con.prepareStatement("SELECT d.* FROM diatreino d "
				+ "JOIN diatreinoatleta a on d.idDiaTreino = a.idDiaTreino "
				+ "WHERE d.idDiaSemana = ?"
				+ " AND a.idAtleta = ?"
				+ " AND hrInicio <= ?"
				+ " AND hrFim >= ?");
		
		stmtScript.setInt(1, semana);
		stmtScript.setInt(2, idAtleta);
		stmtScript.setTime(3, new java.sql.Time(hr.getTime()));
		stmtScript.setTime(4, new java.sql.Time(hr.getTime()));
		
		ResultSet rs = stmtScript.executeQuery();
		
		DiaTreino dia = new DiaTreino();
		if(rs.next()){			
			dia.setIdDiaTreino(rs.getInt("idDiaTreino"));
			dia.setIdDiaDaSemana(rs.getInt("idDiaSemana"));
			dia.setHrInicio(rs.getTime("hrInicio"));
			dia.setHrFim(rs.getTime("hrFim"));
		}
		return dia;
	}
}
