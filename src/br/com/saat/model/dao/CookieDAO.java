package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.saat.model.ConnectionFactory;

public class CookieDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	private boolean retorno = false;
	ResultSet rs;
	
	public CookieDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public CookieDAO(Connection con) throws Exception{
        this.con = con;        
    }
	
	public boolean inserir(String uuii, int idUsuario) throws SQLException{
		stmtScript = con.prepareStatement("INSERT INTO cookie (idUsuario, valueCookie, situacao, dtaGeracao) "
										+ "VALUES (?, ?, 1, getdate())");
		stmtScript.setInt(1, idUsuario);
		stmtScript.setString(2, uuii);
		
		int rows = stmtScript.executeUpdate();
		
		if(rows>0){
			retorno = true;
		}
		return retorno;
	}
	
	public int buscar(String uuii) throws SQLException{
		int idUsuario = 0;
		stmtScript = con.prepareStatement("SELECT idUsuario FROM cookie WHERE valueCookie = ? AND situacao = 1");
		
		stmtScript.setString(1, uuii);
		
		rs = stmtScript.executeQuery();
		
		if(rs.next()){
			idUsuario = rs.getInt("idUsuario");
		}
		return idUsuario;
	}
}
