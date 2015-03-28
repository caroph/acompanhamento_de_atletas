package br.com.saat.model.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.saat.core.Constants;
import br.com.saat.core.Criptografia;
import br.com.saat.core.JavaMailApp;
import br.com.saat.model.Perfis;
import br.com.saat.model.Usuario;
import br.com.saat.model.dao.UsuarioDAO;

public class UsuarioNegocio {
	public UsuarioNegocio() {
	}

	public Usuario autenticar(String email, String senha) throws Exception {
		try {
			UsuarioDAO dao = new UsuarioDAO();
			Usuario usuario = new Usuario();

			usuario = dao.autenticar(email, senha);
			return usuario;
		} catch (Exception ex) {
			throw new Exception("Erro! Ocorreu algum erro ao tentar autenticar o usuário.");
		}
	}

	public String retornoLogin(Usuario usuario) {
		int perfil = usuario.getPerfil();
		if (perfil == Perfis.Secretaria.getValor())
			return String.format("%s/SecretariaPrincipal.jsp", Constants.VIEW);
		else if (perfil == Perfis.Fisioterapeuta.getValor())
			return String
					.format("%s/FisioterapiaPrincipal.jsp", Constants.VIEW);
		else if (perfil == Perfis.Psicologa.getValor())
			return String.format("%s/PsicologiaPrincipal.jsp", Constants.VIEW);
		else if (perfil == Perfis.Nutricionista.getValor())
			return String.format("%s/NutricionistaPrincipal.jsp",
					Constants.VIEW);
		else if (perfil == Perfis.Tecnico.getValor())
			return String.format("%s/TecnicoAtleta.jsp", Constants.VIEW);
		else if (perfil == Perfis.PreparadorFisico.getValor())
			return String.format("%s/TecnicoAtleta.jsp", Constants.VIEW);
		else
			return String.format("%s/Index.jsp", Constants.VIEW);
	}

	public Usuario buscarUsuCookie(int idUsuario) throws Exception{
		try {
			UsuarioDAO dao = new UsuarioDAO();
			Usuario usuario = new Usuario();

			usuario = dao.buscarUsuCookie(idUsuario);
			return usuario;

		} catch (Exception ex) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar cookie de usuário!");
		}
	}

	public String esqueciSenha(String emailSenha) throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		Criptografia crip = new Criptografia();
		Random gerador = new Random();
		String novaSenha = Integer.toString(gerador.nextInt());
		String novaSenhaCrip = crip.criptografa(novaSenha);
		String retorno = "";

		try {
			if (dao.esqueciSenha(emailSenha, novaSenhaCrip)) {
				try {
					JavaMailApp email = new JavaMailApp();
					email.enviaEmail(emailSenha, novaSenha, 1);
					retorno = "Em instantes você receberá um email com sua nova senha!";
				} catch (Exception e) {
					retorno = "Ocorreu algum erro ao enviar o email! Favor tentar novamente.";
				}
			} else {
				retorno = "Email inválido! Favor informe novamente.";
			}
		} catch (SQLException e) {
			throw new Exception("Ocorreu algum erro no banco de dados! Favor tentar novamente.");
		}
		return retorno;
	}
	
	public List<Object> validaDados(Usuario usuario){
		List<Object> lista = new ArrayList<Object>();
		
		if((usuario.getPerfil() == Perfis.PreparadorFisico.getValor() || usuario.getPerfil() == Perfis.Tecnico.getValor())
				&& usuario.getCREF().equals("")){
			lista.add(false);
			lista.add("O campo 'CREF' é obrigatório!");
		}else if(usuario.getEmail().equals("")){
			lista.add(false);
			lista.add("O campo 'Email' é obrigatório!");
		}else if(usuario.getNome().equals("")){
			lista.add(false);
			lista.add("O campo 'Nome' é obrigatório!");
		}else {
			lista.add(true);
		}
		
		
		
		return lista;
	}
	
	public boolean inserir(Usuario usuario) throws Exception{
		Criptografia crip = new Criptografia();
		Random gerador = new Random();
		String novaSenha = Integer.toString(gerador.nextInt());
		String novaSenhaCrip = crip.criptografa(novaSenha);
		
		usuario.setSenha(novaSenhaCrip);
		
		try {
			UsuarioDAO dao = new UsuarioDAO();
			if (dao.inserir(usuario)) {
//				try {
//					JavaMailApp email = new JavaMailApp();
//					email.enviaEmail(usuario.getEmail(), novaSenha, 1);
//				} catch (Exception e) {
//					throw new Exception("Erro! Ocorreu algum erro ao enviar senha ao usuario");
//				}
				return true;
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao inserir o usuario");
		}

		return false;
	}
}
