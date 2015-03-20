package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.Usuario;

import java.sql.PreparedStatement;

public class UsuarioDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	
	public UsuarioDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public UsuarioDAO(Connection con) throws Exception{
        this.con = con;        
    }
	
	public Usuario autenticar(String email, String senha) throws SQLException{
//		stmtAutenticar = con.prepareStatement("SELECT idUsuario, nome, email, telefone, celular, senha, "
//				+ "perfil, CREF FROM usuario WHERE email LIKE ? AND senha LIKE ?");
		stmtScript = con.prepareStatement("SELECT idUsuario, nome, email, perfil "
				+ "FROM usuario WHERE email LIKE ? AND senha LIKE ? AND situacao = 1");
        Usuario usuario = new Usuario();
        
        stmtScript.setString(1, email);
        stmtScript.setString(2, senha);
        
        ResultSet rs = stmtScript.executeQuery();
        if(rs.next()){
            usuario.setIdPessoa(rs.getInt("idUsuario"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setPerfil(rs.getInt("perfil"));
        }else{
            return null;
        }
        return usuario;
    }

	public Usuario buscarUsuCookie(int idUsuario) throws SQLException {
		// TODO Auto-generated method stub
		stmtScript = con.prepareStatement("SELECT idUsuario, nome, perfil "
				+ "FROM usuario WHERE idUsuario = ? AND situacao = 1");
        Usuario usuario = new Usuario();
        
        stmtScript.setInt(1, idUsuario);
        
        ResultSet rs = stmtScript.executeQuery();
        if(rs.next()){
            usuario.setIdPessoa(rs.getInt("idUsuario"));
            usuario.setNome(rs.getString("nome"));
            usuario.setPerfil(rs.getInt("perfil"));
        }else{
            return null;
        }
        return usuario;
	}
	
	public boolean alterarSenha(Usuario usuario, String senhaAtual, String senhaNova) throws SQLException{
		boolean retorno = false;
		int rows;
		
		stmtScript = con.prepareStatement("UPDATE usuario SET senha = ? WHERE idUsuario = ? AND senha = ?");
		
		stmtScript.setString(1, senhaNova);
		stmtScript.setInt(2, usuario.getIdPessoa());
		stmtScript.setString(3, senhaAtual);
		
		rows = stmtScript.executeUpdate();
		
		if(rows > 0){
			retorno = true;
		}
		
		return retorno;
	}

	public boolean esqueciSenha(String emailSenha, String novaSenha) throws SQLException {
		// TODO Auto-generated method stub
		boolean retorno = false;
		int rows;
		
		stmtScript = con.prepareStatement("SELECT idUsuario FROM usuario WHERE email = ? AND situacao = 1");
		stmtScript.setString(1, emailSenha);
		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
			stmtScript = con.prepareStatement("UPDATE usuario SET senha = ? WHERE idUsuario = ?");
			
			stmtScript.setString(1, novaSenha);
			stmtScript.setInt(2, rs.getInt("idUsuario"));
			
			rows = stmtScript.executeUpdate();
			if(rows > 0){
				retorno = true;
			}
		}
		
		return retorno;
	}
}
