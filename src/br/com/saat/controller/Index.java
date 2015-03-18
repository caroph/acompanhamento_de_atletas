package br.com.saat.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.saat.core.Constants;
import br.com.saat.model.negocio.CookieNegocio;

/**
 * O Servlet implementation class Index
 */
@WebServlet(urlPatterns = { "/", "/home" })
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Cookie novoCookie;
	RequestDispatcher rd;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//Setar página de retorno
		String retorno = String.format("%s/Index.jsp", Constants.VIEW);
		
		//Pegando cookies disponíveis e verificando se existe algum "usuarioLogado"
		Cookie[] cookies = request.getCookies();
		String uuid = CookieNegocio.getCookieValue(cookies, Constants.COOKIE_NAME);

	    if (uuid != null) {
	    	novoCookie = CookieNegocio.addCookie(Constants.COOKIE_NAME, uuid, Constants.COOKIE_AGE); // Extends age.
	    	retorno = String.format("%s/SecretariaPrincipal.jsp", Constants.VIEW);
        } else {
        	//Cria cookie vazio
        	novoCookie = CookieNegocio.removeCookie(Constants.COOKIE_NAME);
        }
	    response.addCookie(novoCookie);
	    
	    rd = request.getRequestDispatcher(retorno);	    
	    rd.forward(request, response);
	}

}
