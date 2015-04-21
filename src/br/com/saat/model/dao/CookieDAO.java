package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.Usuario;

public class CookieDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	
	public CookieDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public CookieDAO(Connection con) throws Exception{
        this.con = con;        
    }
	
	public boolean inserir(String uuii, Usuario usuario) throws SQLException{
		boolean retorno = false;
		
		//Verificar se o usuário já possui registro de cookie
		stmtScript = con.prepareStatement("SELECT idCookie FROM cookie WHERE idUsuario = ?");
		stmtScript.setInt(1, usuario.getIdPessoa());
		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
			stmtScript = con.prepareStatement("UPDATE cookie "
					+ "SET valueCookie = ?, dtaGeracao = now() "
					+ "WHERE idCookie = ?");
			stmtScript.setString(1, uuii);
			stmtScript.setInt(2, rs.getInt("idCookie"));
		}else{
			stmtScript = con.prepareStatement("INSERT INTO cookie (idUsuario, valueCookie) "
					+ "VALUES (?, ?)");
			
			stmtScript.setInt(1, usuario.getIdPessoa());
			stmtScript.setString(2, uuii);
		}
		
		int rows = stmtScript.executeUpdate();
		
		if(rows>0){
			retorno = true;
		}
		return retorno;
	}
	
	public int buscar(String uuii) throws SQLException{
		int idUsuario = 0;
		stmtScript = con.prepareStatement("SELECT idUsuario FROM cookie WHERE valueCookie LIKE ?");
		
		stmtScript.setString(1, uuii);
		
		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
			idUsuario = rs.getInt("idUsuario");
		}
		return idUsuario;
	}
}
