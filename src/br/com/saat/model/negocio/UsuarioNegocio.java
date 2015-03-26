package br.com.saat.model.negocio;

import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;

import br.com.saat.core.Constants;
import br.com.saat.core.Criptografia;
import br.com.saat.core.JavaMailApp;
import br.com.saat.model.Perfis;
import br.com.saat.model.Usuario;
import br.com.saat.model.dao.UsuarioDAO;

public class UsuarioNegocio {
	public UsuarioNegocio(){}
	
	public Usuario autenticar(String email, String senha) throws Exception, SQLException{
			UsuarioDAO dao = new UsuarioDAO();
			Usuario usuario = new Usuario();
			
			usuario = dao.autenticar(email, senha);
			return usuario;
	}
	
	public String retornoLogin(Usuario usuario){
		int perfil = usuario.getPerfil();
		if(perfil == Perfis.Secretaria.getValor())
			return String.format("%s/SecretariaPrincipal.jsp", Constants.VIEW);
		else if(perfil == Perfis.Fisioterapeuta.getValor())
			return String.format("%s/FisioterapiaPrincipal.jsp", Constants.VIEW);
		else if(perfil == Perfis.Psicologa.getValor())
			return String.format("%s/PsicologiaPrincipal.jsp", Constants.VIEW);
		else if(perfil == Perfis.Nutricionista.getValor())
			return String.format("%s/NutricionistaPrincipal.jsp", Constants.VIEW);
		else if(perfil == Perfis.Tecnico.getValor())
			return String.format("%s/TecnicoAtleta.jsp", Constants.VIEW);
		else if(perfil == Perfis.PreparadorFisico.getValor())
			return String.format("%s/TecnicoAtleta.jsp", Constants.VIEW);
		else
//      Isso não funciona, pois não vai acessar a Servlet via requestDispatcher;
//			return "Autenticador?action=logout";
			return String.format("%s/Index.jsp", Constants.VIEW);
	}
	
	public Usuario buscarUsuCookie(int idUsuario){
		try{
			UsuarioDAO dao = new UsuarioDAO();
			Usuario usuario = new Usuario();
			
			usuario = dao.buscarUsuCookie(idUsuario);
			return usuario;
			
		}catch(Exception ex){
			return null;
		}
	}

	public String esqueciSenha(String emailSenha) throws Exception {
		// TODO Auto-generated method stub
		UsuarioDAO dao = new UsuarioDAO();
		Criptografia crip = new Criptografia();
		Random gerador = new Random();
		String novaSenha = Integer.toString(gerador.nextInt());
		String novaSenhaCrip = crip.criptografa(novaSenha);
		String retorno = "";
		
		try {
			if(dao.esqueciSenha(emailSenha, novaSenhaCrip)){
				try{
					JavaMailApp email = new JavaMailApp();
					email.enviaEmail(emailSenha, novaSenha, 1);
					retorno = "Em instantes você receberá um email com sua nova senha!";
				} catch(Exception e){
					throw new Exception("Ocorreu algum erro ao enviar o email! Favor tentar novamente.");
					//e.printStackTrace();
					//retorno = "Ocorreu algum erro ao enviar o email! Favor tentar novamente.";	
				}
			}else{
				throw new Exception("Email inválido! Favor informe novamente.");
				//retorno = "Email inválido! Favor informe novamente.";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exception("Ocorreu algum erro no banco de dados! Favor tentar novamente.");
			//e.printStackTrace();
			//retorno = "Ocorreu algum erro no banco de dados! Favor tentar novamente.";
		}
		return retorno;
	}
}
