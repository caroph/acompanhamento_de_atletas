package br.com.saat.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.saat.model.Usuario;
import br.com.saat.model.negocio.UsuarioNegocio;

@WebServlet("/Autenticador")
public class AutenticadorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioNegocio usuarioNegocio;
      
    public AutenticadorController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/Index.jsp");
		requestDispatcher.forward(request, response);
		String action = request.getParameter("action");
		
		if(action.equals("login")){
			String email = request.getParameter("login");
            String senha = request.getParameter("senha");
            
            Usuario usuario = new Usuario();
            usuarioNegocio = new UsuarioNegocio();
            usuario = usuarioNegocio.autenticar(email, senha);
            
			RequestDispatcher rd = request.getRequestDispatcher("view/SecretariaAtleta.jsp");
			rd.forward(request, response);
		}
	}

}
