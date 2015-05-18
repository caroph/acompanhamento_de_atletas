package br.com.saat.model.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.saat.core.BCrypt;
import br.com.saat.core.Constants;
import br.com.saat.core.JavaMailApp;
import br.com.saat.enumeradores.Perfis;
import br.com.saat.model.Usuario;
import br.com.saat.model.dao.UsuarioDAO;

public class UsuarioNegocio {
	public UsuarioNegocio() {
	}

	public Usuario autenticar(String email, String senha) throws Exception {
		try {
			UsuarioDAO dao = new UsuarioDAO();
			Usuario usuario = new Usuario();

			List<Usuario> lista = dao.autenticar(email);
			boolean achou = false;

			for (Usuario usu : lista) {
			   if (BCrypt.checkpw(senha, usu.getSenha()) && !achou) {
			   	achou = true;
				usuario = usu;
			   }
			}

			return usuario;
		} catch (Exception ex) {
			throw new Exception("Erro! Ocorreu algum erro ao tentar autenticar o usuário.");
		}
	}

	public String retornoLogin(Usuario usuario) {
		int perfil = usuario.getPerfil();
		if (perfil == Perfis.Secretaria.getValor())
			return  "/SecretariaController?action=jspPaginaInicialSecretaria";
		else if (perfil == Perfis.Fisioterapeuta.getValor() || perfil == Perfis.Psicologa.getValor())
			return "/SaudeGeralController";
		else if (perfil == Perfis.Nutricionista.getValor())
			return "/NutricionistaController?action=jspPaginaInicialNutricionista";
		else if (perfil == Perfis.Tecnico.getValor() || perfil == Perfis.PreparadorFisico.getValor())
			return "/TecnicoController";
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
		Random gerador = new Random();
		int senhaRandom = gerador.nextInt();
		while (senhaRandom < 0) {
			senhaRandom = gerador.nextInt();
		}
		String novaSenha = Integer.toString(senhaRandom);
		String novaSenhaCrip = BCrypt.hashpw(novaSenha + Constants.PASS_KEY, BCrypt.gensalt());
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
	
	public List<Object> validaDados(Usuario usuario) throws Exception{
		List<Object> lista = new ArrayList<Object>();
		UsuarioDAO dao = new UsuarioDAO();
		
		try{
			boolean email = dao.buscarEmail(usuario.getEmail(), usuario.getIdPessoa());
			
			if((usuario.getPerfil() == Perfis.PreparadorFisico.getValor() || usuario.getPerfil() == Perfis.Tecnico.getValor())
					&& "".equals(usuario.getCREF())){
				lista.add(false);
				lista.add("O campo 'CREF' é obrigatório!");
			}else if("".equals(usuario.getEmail())){
				lista.add(false);
				lista.add("O campo 'Email' é obrigatório!");
			}else if("".equals(usuario.getNome())){
				lista.add(false);
				lista.add("O campo 'Nome' é obrigatório!");
			}else if(email){
				lista.add(false);
				lista.add("Erro! Existe um usuário com o mesmo email no sistema!");
			}else {
				lista.add(true);
			}
		}catch(Exception ex){
			throw new Exception("Ocorreu algum erro ao buscar usuários com o mesmo email");
		}
		
		if((usuario.getPerfil() != Perfis.PreparadorFisico.getValor() && usuario.getPerfil() != Perfis.Tecnico.getValor())
				&& !("".equals(usuario.getCREF())))
			usuario.setCREF("");
		
		return lista;
	}
	
	public boolean inserir(Usuario usuario) throws Exception{
		Random gerador = new Random();
		int senhaRandom = gerador.nextInt();
		while (senhaRandom < 0) {
			senhaRandom = gerador.nextInt();
		}
		String novaSenha = Integer.toString(senhaRandom);
		String novaSenhaCrip = BCrypt.hashpw(novaSenha + Constants.PASS_KEY, BCrypt.gensalt());
		
		usuario.setSenha(novaSenhaCrip);
		
		try {
			UsuarioDAO dao = new UsuarioDAO();
			if (dao.inserir(usuario)) {
				//Comentado para não ficar enviando email sempre que salvar um usuário.
				try {
					JavaMailApp email = new JavaMailApp();
					email.enviaEmail(usuario.getEmail(), novaSenha, 1);
				} catch (Exception e) {
					throw new Exception("Erro! Ocorreu algum erro ao enviar senha ao usuario");
				}
				return true;
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao inserir o usuario");
		}

		return false;
	}

	public List<Usuario> buscarUsuarios() throws Exception{
		try {
			UsuarioDAO dao = new UsuarioDAO();
			List<Usuario> lista = dao.buscarUsuarios();
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar os usuarios");
		}
	}

	public boolean desativar(Usuario usuario) throws Exception{
		try {
			UsuarioDAO dao = new UsuarioDAO();
			if (dao.desativar(usuario)) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao excluir o usuário!");
		}
		return false;
	}

	public Usuario buscarUsuario(int idUsuario) throws Exception{
		try{
			UsuarioDAO dao = new UsuarioDAO();
			Usuario usuario = dao.buscarUsuario(idUsuario);
			return usuario;
		}catch(Exception ex){
			throw new Exception("Erro! Ocorreu algum erro ao buscar o usuário!");
		}
	}

	public boolean alterar(Usuario usuario) throws Exception {
		try {
			UsuarioDAO dao = new UsuarioDAO();
			if (dao.alterar(usuario)) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao alterar o usuario");
		}
		return false;
	}

	public String verificarSenha(String senhaAtual, String novaSenha,
			String confirmacaoSenha, int idUsuario) throws Exception {
		if("".equals(senhaAtual)){
			return "Preencha a senha atual!";
		}else if("".equals(novaSenha)){
			return "Preencha a nova senha!";
		}else if("".equals(confirmacaoSenha)){
			return "Preencha a confirmação de senha!";
		}else if(!novaSenha.equals(confirmacaoSenha)){
			return "A confirmação deve ser igual a senha!";
		}else{
			try{
				UsuarioDAO dao = new UsuarioDAO();
				String senhaBanco = dao.buscarSenha(idUsuario);
				if(!BCrypt.checkpw(senhaAtual + Constants.PASS_KEY, senhaBanco))
					return "A senha atual não confere!";
			}catch(Exception ex){
				throw new Exception("Ocorreu algum erro ao comparar a senha atual!");
			}
		}
		return null;
	}

	public boolean alterarSenha(Usuario usuario, String senhaNova) throws Exception {
		try {
			UsuarioDAO dao = new UsuarioDAO();
			if (dao.alterarSenha(usuario, BCrypt.hashpw(senhaNova + Constants.PASS_KEY, BCrypt.gensalt()))) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao alterar a senha");
		}
		return false;
	}

	public List<Integer> buscarIdUsuarios(int compartilhar) throws Exception {
		try {
			UsuarioDAO dao = new UsuarioDAO();
			return dao.buscarIdUsuarios(compartilhar);
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar os usuario para compartilhamento!");
		}
	}
}
