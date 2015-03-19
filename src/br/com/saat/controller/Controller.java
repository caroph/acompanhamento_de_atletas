package br.com.saat.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.saat.core.Constants;
import br.com.saat.model.Usuario;
import br.com.saat.model.negocio.CookieNegocio;
import br.com.saat.model.negocio.UsuarioNegocio;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	Cookie novoCookie;
	RequestDispatcher requestDispatcher;
	UsuarioNegocio usuarioNegocio;

    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response, Usuario usuario, boolean lembrar) throws ServletException, IOException {
		usuarioNegocio = new UsuarioNegocio();
		session = request.getSession();
		String retorno;
		
		//Usuário inválido
		if(usuario == null){
			//Destroir sessão
			session.invalidate();
			//Redirecionar para página de login
			retorno = String.format("%s/Index.jsp", Constants.VIEW);
			//Setar mensagem de erro
			request.setAttribute("msg", "Email ou senha inválidos!"); 
		//Usuário válido
		}else{
			//Criar sessão de usuário logado
			session.setAttribute("usuarioLogado", usuario);
			//Pegar página para redirecionamento
			retorno = usuarioNegocio.retornoLogin(usuario.getPerfil());
			
			//Criar cookie se a opção "Lembrar" estiver habilitada
			if(lembrar){
				//Criar código de cookie
        		String uuid = UUID.randomUUID().toString();
        		//Adicionar cookie
        		novoCookie = CookieNegocio.addCookie(Constants.COOKIE_NAME, uuid, Constants.COOKIE_AGE, usuario.getIdPessoa()); // Extends age.
        		///PENSAR se gravo novo registro ou atualizo value
			}else{
        		//Adiciona cookie vazio
        		novoCookie = CookieNegocio.addCookie(Constants.COOKIE_NAME, null, 0, usuario.getIdPessoa());
        	}
			
			//Cookie válido
			if(novoCookie != null){
				//Adicionar cookie à navegação
				response.addCookie(novoCookie);
			}
		}
		requestDispatcher = getServletContext().getRequestDispatcher(retorno);
		requestDispatcher.forward(request, response);
	}

}
