package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.Usuario;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	
	public UsuarioDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public UsuarioDAO(Connection con) throws Exception{
        this.con = con;        
    }
	
	public List<Usuario> autenticar(String email) throws SQLException{
		List<Usuario> lista = new ArrayList<Usuario>();

			stmtScript = con.prepareStatement("SELECT idUsuario, nome, email, perfil, senha "
					+ "FROM usuario WHERE email LIKE ? AND flCadastroAtivo = 1");
	        
	        stmtScript.setString(1, email);
	        
	        ResultSet rs = stmtScript.executeQuery();
	        while(rs.next()){
	        	Usuario usuario = new Usuario();
	            usuario.setIdPessoa(rs.getInt("idUsuario"));
	            usuario.setNome(rs.getString("nome"));
	            usuario.setEmail(rs.getString("email"));
	            usuario.setPerfil(rs.getInt("perfil"));
	            usuario.setSenha(rs.getString("senha"));
	            lista.add(usuario);
	        }
	        return lista;
	    }

	public Usuario buscarUsuCookie(int idUsuario) throws SQLException {
		stmtScript = con.prepareStatement("SELECT idUsuario, nome, perfil "
				+ "FROM usuario WHERE idUsuario = ? AND flCadastroAtivo = 1");
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
	
	public boolean alterarSenha(Usuario usuario, String senhaNova) throws SQLException{
		boolean retorno = false;
		int rows;
		
		stmtScript = con.prepareStatement("UPDATE usuario SET senha = ? WHERE idUsuario = ?");
		
		stmtScript.setString(1, senhaNova);
		stmtScript.setInt(2, usuario.getIdPessoa());
		
		rows = stmtScript.executeUpdate();
		
		if(rows > 0){
			retorno = true;
		}
		
		return retorno;
	}

	public boolean esqueciSenha(String emailSenha, String novaSenha) throws SQLException {
		boolean retorno = false;
		int rows;
		
		stmtScript = con.prepareStatement("SELECT idUsuario FROM usuario WHERE email = ? AND flCadastroAtivo = 1");
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

	public boolean inserir(Usuario usuario) throws SQLException {
		int rows = 0;
		
		stmtScript = con.prepareStatement("INSERT INTO usuario (nome, email, telefone, celular, senha, perfil, cref) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)");
		
		stmtScript.setString(1, usuario.getNome());
		stmtScript.setString(2, usuario.getEmail());
		stmtScript.setString(3, usuario.getTelefone());
		stmtScript.setString(4, usuario.getCelular());
		stmtScript.setString(5, usuario.getSenha());
		stmtScript.setInt(6, usuario.getPerfil());
		stmtScript.setString(7, usuario.getCREF());
		
		rows = stmtScript.executeUpdate();
		
		if(rows > 0){
			return true;
		}		
		return false;
	}
	
	public boolean buscarEmail(String email, int idUsuario) throws SQLException{	
		if(idUsuario == 0){
			stmtScript = con.prepareStatement("SELECT email FROM usuario WHERE email LIKE ? AND flCadastroAtivo = 1");
			stmtScript.setString(1, email);
		}
		else{
			stmtScript = con.prepareStatement("SELECT email FROM usuario WHERE email LIKE ? and idUsuario != ? AND "
					+ "flCadastroAtivo = 1");
			stmtScript.setString(1, email);
			stmtScript.setInt(2, idUsuario);
		}
				
		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
			return true;
		}		
		return false;
	}

	public List<Usuario> buscarUsuarios() throws SQLException {
		List<Usuario> lista = new ArrayList<Usuario>();
		stmtScript = con.prepareStatement("SELECT idUsuario, nome, email, telefone, celular, perfil, cref FROM usuario WHERE "
				+ "flCadastroAtivo = 1");		
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			Usuario usuario = new Usuario();
			usuario.setIdPessoa(rs.getInt("idUsuario"));
			usuario.setNome(rs.getString("nome"));
			usuario.setEmail(rs.getString("email"));
			usuario.setTelefone(rs.getString("telefone"));
			usuario.setCelular(rs.getString("celular"));
			usuario.setPerfil(rs.getInt("perfil"));
			usuario.setCREF(rs.getString("cref"));
			lista.add(usuario);
		}	
		return lista;
	}

	public boolean desativar(Usuario usuario) throws SQLException {
		int rows = 0;
		
		stmtScript = con.prepareStatement("UPDATE usuario SET flCadastroAtivo = 0 WHERE idUsuario = ?");
		stmtScript.setInt(1, usuario.getIdPessoa());
		
		rows = stmtScript.executeUpdate();
		
		if(rows > 0){
			return true;
		}		
		return false;
	}

	public Usuario buscarUsuario(int idUsuario) throws SQLException {
		stmtScript = con.prepareStatement("SELECT idUsuario, nome, email, telefone, celular, perfil, cref FROM usuario "
				+ "WHERE idUsuario = ?");
		stmtScript.setInt(1, idUsuario);

		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
			Usuario usuario = new Usuario();
			usuario.setIdPessoa(rs.getInt("idUsuario"));
			usuario.setNome(rs.getString("nome"));
			usuario.setEmail(rs.getString("email"));
			usuario.setTelefone(rs.getString("telefone"));
			usuario.setCelular(rs.getString("celular"));
			usuario.setPerfil(rs.getInt("perfil"));
			usuario.setCREF(rs.getString("cref"));
			return usuario;
		}
		
		return null;
	}

	public boolean alterar(Usuario usuario) throws SQLException {
		int rows = 0;
		
		stmtScript = con.prepareStatement("UPDATE usuario SET nome = ?, email = ?, telefone = ?, celular = ?, perfil = ?"
				+ ", cref = ? WHERE idUsuario = ?");
		
		stmtScript.setString(1, usuario.getNome());
		stmtScript.setString(2, usuario.getEmail());
		stmtScript.setString(3, usuario.getTelefone());
		stmtScript.setString(4, usuario.getCelular());
		stmtScript.setInt(5, usuario.getPerfil());
		stmtScript.setString(6, usuario.getCREF());
		stmtScript.setInt(7, usuario.getIdPessoa());
		
		rows = stmtScript.executeUpdate();
		
		if(rows > 0){
			return true;
		}		
		return false;
	}

//	public boolean buscarSenha(String senhaAtual, int idUsuario) throws SQLException {
//		stmtScript = con.prepareStatement("SELECT senha FROM usuario WHERE idUsuario = ?");
//		stmtScript.setInt(1, idUsuario);
//			
//		ResultSet rs = stmtScript.executeQuery();
//		
//		if(rs.next()){
//			if(rs.getString("senha").equals(senhaAtual)){
//				return true;
//			}
//			return false;
//		}		
//		return false;
//	}
	
	public List<Integer> buscarIdUsuarios(int compartilhar) throws SQLException {
		List<Integer> lista = new ArrayList<Integer>();
		if(compartilhar == 1){
			stmtScript = con.prepareStatement("SELECT idUsuario FROM usuario WHERE (perfil = 5 OR perfil = 6) "
				+ "AND flCadastroAtivo = 1");
		}else{
			stmtScript = con.prepareStatement("SELECT idUsuario FROM usuario WHERE perfil != 1 "
					+ "AND flCadastroAtivo = 1");
		}
			
		ResultSet rs = stmtScript.executeQuery();
		while(rs.next()){
			lista.add(rs.getInt(1));
		}
		return lista;
	}

	public String buscarSenha(int idUsuario) throws SQLException {
		String retorno = "";
		
		stmtScript = con.prepareStatement("SELECT senha FROM usuario WHERE idUsuario = ?");
		stmtScript.setInt(1, idUsuario);
			
		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
			retorno = rs.getString("senha");
		}		
		return retorno;
	}
}
