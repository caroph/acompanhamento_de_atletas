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
		if(usuario == null){			
			session.invalidate();
			retorno = String.format("%s/Index.jsp", Constants.VIEW);
		}else{
			session.setAttribute("usuarioLogado", usuario);
			retorno = usuarioNegocio.retornoLogin(usuario.getPerfil());
			
			if(lembrar){
        		String uuid = UUID.randomUUID().toString();
        		novoCookie = CookieNegocio.addCookie(Constants.COOKIE_NAME, uuid, Constants.COOKIE_AGE); // Extends age.
        	}else{
        		novoCookie = CookieNegocio.removeCookie(Constants.COOKIE_NAME);
        	}
        	response.addCookie(novoCookie);
		}
		requestDispatcher = getServletContext().getRequestDispatcher(retorno);
		requestDispatcher.forward(request, response);
	}

}
