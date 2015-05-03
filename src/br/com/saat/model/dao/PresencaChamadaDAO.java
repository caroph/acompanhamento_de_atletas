package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		
		stmtScript = con.prepareStatement("INSERT INTO presencachamada (idChamada, idAtleta, estadoPresenca, "
				+ "justificativa) VALUES (?, ?, ?, ?)");
		
		stmtScript.setInt(1, idChamada);
		stmtScript.setInt(2, idAtleta);
		stmtScript.setInt(3, estadoPresenca);
		stmtScript.setString(4, justificativa);
		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			return true;
		}
		return false;
	}

	public boolean salvarPresencaChamada(PresencaChamada presenca) throws SQLException {
		int rows = 0;
		
		stmtScript = con.prepareStatement("INSERT INTO presencachamada (idChamada, idAtleta, estadoPresenca, "
				+ "nrQuadra, justificativa) VALUES (?, ?, ?, ?, ?)");
		
		stmtScript.setInt(1, presenca.getIdChamada());
		stmtScript.setInt(2, presenca.getIdAtleta());
		stmtScript.setInt(3, presenca.getEstadoPresenca());
		stmtScript.setInt(4, presenca.getNrQuadra());
		stmtScript.setString(5, presenca.getJustificativa());
		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			return true;
		}
		return false;
	}
}
