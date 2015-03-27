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

	public Index() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario;
		UsuarioNegocio negocio;
		RequestDispatcher rd;

		// Pegando cookies disponíveis e verificando se existe algum
		// "usuarioLogado"
		Cookie[] cookies = request.getCookies();
		int idUsuario = CookieNegocio.getCookieValue(cookies,
				Constants.COOKIE_NAME);

		if (idUsuario > 0) {
			negocio = new UsuarioNegocio();
			try {
				usuario = negocio.buscarUsuCookie(idUsuario);
			} catch (Exception ex) {
				usuario = null;
				request.setAttribute("msg", ex.getMessage());
			}
			super.doPost(request, response, usuario, true, false);
		} else {
			rd = getServletContext().getRequestDispatcher(
					String.format("%s/Index.jsp", Constants.VIEW));
			rd.forward(request, response);
		}
	}
}
