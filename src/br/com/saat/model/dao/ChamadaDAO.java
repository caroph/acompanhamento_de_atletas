package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import br.com.saat.model.Chamada;
import br.com.saat.model.ConnectionFactory;

public class ChamadaDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	
	public ChamadaDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public ChamadaDAO(Connection con) throws Exception{
        this.con = con;        
    }
	
	public Chamada buscarChamadaPorData(Date data, int idDiaTreino) throws SQLException{
		stmtScript = con.prepareStatement("SELECT idChamada, idUsuario, idDiaTreino, dtChamada "
				+ "FROM chamada WHERE idDiaTreino = ? AND dtChamada = ?");
		
		stmtScript.setInt(1, idDiaTreino);
		stmtScript.setDate(2, new java.sql.Date(data.getTime()));
		
		ResultSet rs = stmtScript.executeQuery();
		
		Chamada chamada = new Chamada();
		if(rs.next()){		
			chamada.setIdChamada(rs.getInt("idChamada"));
			chamada.setIdUsuario(rs.getInt("idUsuario"));
			chamada.setIdDiaTreino(rs.getInt("idDiaTreino"));
			chamada.setDtChamada(rs.getDate("dtChamada"));
		}
		return chamada;
	}

	public Chamada salvarChamada(Chamada chamada) throws SQLException {
		int rows = 0;
		
		stmtScript = con.prepareStatement("INSERT INTO chamada (idUsuario, idDiaTreino, dtChamada)"
				+ "VALUES (?, ?, ?)");
		
		stmtScript.setInt(1, chamada.getIdUsuario());
		stmtScript.setInt(2, chamada.getIdDiaTreino());
		stmtScript.setDate(3, new java.sql.Date(chamada.getDtChamada().getTime()));
		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			chamada = buscarChamadaPorData(chamada.getDtChamada(), chamada.getIdDiaTreino());
			return chamada;
		}	
		
		return null;
	}
}
