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
import br.com.saat.model.Perfis;
import br.com.saat.model.Usuario;
import br.com.saat.model.negocio.UsuarioNegocio;

@WebServlet("/SecretariaController")
public class SecretariaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	RequestDispatcher requestDispatcher;
	UsuarioNegocio usuarioNegocio;
       
    public SecretariaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		if(usuario == null || usuario.getPerfil() != Perfis.Secretaria.getValor()){
			session.invalidate();
            requestDispatcher = getServletContext().getRequestDispatcher(String.format("%s/Index.jsp", Constants.VIEW));
		}
		requestDispatcher.forward(request, response);
	}

}
