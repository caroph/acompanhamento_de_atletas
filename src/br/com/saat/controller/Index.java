package br.com.saat.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.saat.core.Constants;
import br.com.saat.core.Cookies;

/**
 * O Servlet implementation class Index
 */
@WebServlet(urlPatterns = { "/", "/home" })
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Cookies cookies;

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

		cookies = new Cookies();
		String uuid = cookies.getCookieValue(request, Constants.COOKIE_NAME);

	    if (uuid != null) {
	    	cookies.addCookie(response, Constants.COOKIE_NAME, uuid, Constants.COOKIE_AGE); // Extends age.
	    	RequestDispatcher rd = request.getRequestDispatcher(String.format("%s/SecretariaPrincipal.jsp", Constants.VIEW));
    		rd.forward(request, response);
        } else {
        	cookies.removeCookie(response, Constants.COOKIE_NAME);
    		RequestDispatcher rd = request.getRequestDispatcher(String.format("%s/Index.jsp", Constants.VIEW));
    		rd.forward(request, response);
        }
	}

}
