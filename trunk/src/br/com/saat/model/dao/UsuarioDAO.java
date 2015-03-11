package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.Usuario;

import java.sql.PreparedStatement;

public class UsuarioDAO {
	private Connection con;
	private PreparedStatement stmtAutenticar;
	
	public UsuarioDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public UsuarioDAO(Connection con) throws Exception{
        this.con = con;        
    }
	
	public Usuario autenticar(String email, String senha) throws SQLException{
		stmtAutenticar = con.prepareStatement("SELECT idUsuario, nome, email, telefone, celular, senha, "
				+ "perfil, CREF FROM usuario WHERE email LIKE ? AND senha LIKE ?");
        Usuario usuario = new Usuario();
        
        stmtAutenticar.setString(1, email);
        stmtAutenticar.setString(2, senha);
        
        ResultSet rs = stmtAutenticar.executeQuery();
        if(rs.next()){
            usuario.setIdPessoa(rs.getInt("idUsuario"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setTelefone(rs.getString("telefone"));
            usuario.setCelular(rs.getString("celular"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setPerfil(rs.getInt("perfil"));
            usuario.setCREF(rs.getString("CREF"));
        }else{
            return null;
        }
        return usuario;
    }
}
