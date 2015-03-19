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
import br.com.saat.model.Usuario;
import br.com.saat.model.negocio.CookieNegocio;
import br.com.saat.model.negocio.UsuarioNegocio;

/**
 * O Servlet implementation class Index
 */
@WebServlet(urlPatterns = { "" })
public class Index extends Controller {
	private static final long serialVersionUID = 1L;
	Cookie novoCookie;
	Usuario usuario;
	UsuarioNegocio negocio;
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
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//Pegando cookies disponíveis e verificando se existe algum "usuarioLogado"
		Cookie[] cookies = request.getCookies();
		int idUsuario  = CookieNegocio.getCookieValue(cookies, Constants.COOKIE_NAME);

	    if (idUsuario > 0) {
	    	negocio = new UsuarioNegocio();
	    	usuario = negocio.buscarUsuCookie(idUsuario);
	    	super.doPost(request, response, usuario, true);
	    }else{
	    	rd = request.getRequestDispatcher(String.format("%s/Index.jsp", Constants.VIEW));	    
	    	rd.forward(request, response);
	    }
	}
}
