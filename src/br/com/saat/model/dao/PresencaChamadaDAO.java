package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.saat.model.Atleta;
import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.PresencaChamada;

public class PresencaChamadaDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	
	public PresencaChamadaDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public PresencaChamadaDAO(Connection con) throws Exception{
        this.con = con;        
    }

	public boolean salvarPresencaChamada(int idChamada, int idAtleta,
			int estadoPresenca, String justificativa) throws SQLException {
		int rows = 0;
		
		stmtScript = con.prepareStatement("INSERT INTO presencachamada (idChamada, idAtleta, estadoPresencaT, "
				+ "justificativaT, estadoPresencaF, justificativaF) VALUES (?, ?, ?, ?, ?, ?)");
		
		stmtScript.setInt(1, idChamada);
		stmtScript.setInt(2, idAtleta);
		stmtScript.setInt(3, estadoPresenca);
		stmtScript.setString(4, justificativa);
		stmtScript.setInt(5, estadoPresenca);
		stmtScript.setString(6, justificativa);
		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			return true;
		}
		return false;
	}

	public boolean salvarPresencaChamada(PresencaChamada presenca) throws SQLException {
		int rows = 0;
		
		stmtScript = con.prepareStatement("INSERT INTO presencachamada (idChamada, idAtleta, estadoPresencaT, "
				+ "nrQuadra, justificativaT, estadoPresencaF, justificativaF) VALUES (?, ?, ?, ?, ?, ?, ?)");
		
		stmtScript.setInt(1, presenca.getIdChamada());
		stmtScript.setInt(2, presenca.getIdAtleta());
		stmtScript.setInt(3, presenca.getEstadoPresencaF());
		stmtScript.setInt(4, presenca.getNrQuadra());
		stmtScript.setString(5, presenca.getJustificativaF());
		stmtScript.setInt(6, presenca.getEstadoPresencaT());
		stmtScript.setString(7, presenca.getJustificativaT());
		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			return true;
		}
		return false;
	}

	public List<PresencaChamada> buscarPresencasPorChamada(int idChamada) throws SQLException {
		List<PresencaChamada> lista = new ArrayList<PresencaChamada>();
		
		stmtScript = con.prepareStatement("SELECT pc.idPresencaChamada, pc.idChamada, pc.idAtleta, pc.estadoPresencaT, "
				+ "pc.nrQuadra, a.nome FROM presencachamada pc JOIN atleta a ON pc.idAtleta = a.idAtleta "
				+ "WHERE pc.estadoPresencaT = 1 AND pc.idChamada = " + idChamada);
		
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			PresencaChamada presenca = new PresencaChamada();
			presenca.setIdPresencaChamada(rs.getInt(1));
			presenca.setIdChamada(rs.getInt(2));
			presenca.setIdAtleta(rs.getInt(3));
			presenca.setEstadoPresencaT(rs.getInt(4));
			presenca.setNrQuadra(rs.getInt(5));
			Atleta atleta = new Atleta();
			atleta.setIdPessoa(rs.getInt(3));
			atleta.setNome(rs.getString(6));
			presenca.setAtleta(atleta);
			lista.add(presenca);
		}
		return lista;
	}

	public boolean excluirPresencaChamada(int idChamada) throws SQLException {
		int rows = 0;		
		stmtScript = con.prepareStatement("DELETE FROM presencachamada WHERE idChamada = ?");
		stmtScript.setInt(1, idChamada);
		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			return true;
		}			
		return false;
	}

	public List<Atleta> buscarPresencasPorData(Date dt, int idDiaTreino) throws SQLException {
		List<Atleta> lista = new ArrayList<Atleta>();
		
		stmtScript = con.prepareStatement("SELECT DISTINCT a.idAtleta, a.nome, dta.idDiaTreino "
				+ "FROM atleta a "
				+ "JOIN diatreinoatleta dta on a.idAtleta = dta.idAtleta "
				+ "WHERE dta.idDiaTreino = " + idDiaTreino);
		
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			Atleta atleta = new Atleta();
			atleta.setIdPessoa(rs.getInt(1));
			atleta.setNome(rs.getString(2));
			
			stmtScript = con.prepareStatement("SELECT pc.idPresencaChamada, pc.idChamada, pc.estadoPresencaT, "
					+ "pc.justificativaT, pc.nrQuadra, pc.estadoPresencaF, pc.justificativaF "
					+ "FROM presencachamada pc "
					+ "JOIN chamada c on pc.idChamada = c.idChamada "
					+ "WHERE pc.idAtleta = ? AND c.dtChamada = ? AND c.idDiaTreino = ?");
			stmtScript.setInt(1, atleta.getIdPessoa());
			stmtScript.setDate(2, new java.sql.Date(dt.getTime()));
			stmtScript.setInt(3, idDiaTreino);
			
			ResultSet rsPresenca = stmtScript.executeQuery();
			
			if(rsPresenca.next()){
				PresencaChamada presenca = new PresencaChamada();
				presenca.setIdPresencaChamada(rsPresenca.getInt(1));
				presenca.setIdChamada(rsPresenca.getInt(2));
				presenca.setEstadoPresencaT(rsPresenca.getInt(3));
				presenca.setJustificativaT(rsPresenca.getString(4));
				presenca.setNrQuadra(rsPresenca.getInt(5));
				presenca.setEstadoPresencaF(rsPresenca.getInt(6));
				presenca.setJustificativaF(rsPresenca.getString(7));
				atleta.setPresenca(presenca);
			}				
			
			lista.add(atleta);
		}
		return lista;
	}

	public boolean alterarPresencaChamada(int idPresencaChamada,
			int estadoPresenca, String justificativa, String tpPresenca) throws SQLException {
		int rows = 0;		
		if("T".equals(tpPresenca)){
			stmtScript = con.prepareStatement("UPDATE presencachamada SET estadoPresencaT = ?, justificativaT = ?"
					+ " WHERE idPresencaChamada = ?");
		}else{
			stmtScript = con.prepareStatement("UPDATE presencachamada SET estadoPresencaF = ?, justificativaF = ?"
					+ " WHERE idPresencaChamada = ?");
		}	
		stmtScript.setInt(1, estadoPresenca);
		stmtScript.setString(2, justificativa);
		stmtScript.setInt(3, idPresencaChamada);
		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			return true;
		}			
		return false;
	}
}
