package br.com.saat.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.saat.core.Constants;
import br.com.saat.model.Usuario;
import br.com.saat.model.negocio.UsuarioNegocio;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	RequestDispatcher requestDispatcher;
	UsuarioNegocio usuarioNegocio;

    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
		usuarioNegocio = new UsuarioNegocio();
		session = request.getSession();
		String retorno;
		if(usuario == null){			
			session.invalidate();
			retorno = String.format("%s/Index.jsp", Constants.VIEW);
			//requestDispatcher = getServletContext().getRequestDispatcher(retorno);
			//requestDispatcher.forward(request, response);
		}else{
			session.setAttribute("usuarioLogado", usuario);
			retorno = usuarioNegocio.retornoLogin(usuario.getPerfil());
		}
		requestDispatcher = getServletContext().getRequestDispatcher(retorno);
		requestDispatcher.forward(request, response);
		
	
	}

}
