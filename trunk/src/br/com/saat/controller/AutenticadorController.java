package br.com.saat.controller;

import java.io.IOException;

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
import br.com.saat.model.negocio.UsuarioNegocio;

@WebServlet("/Autenticador")
public class AutenticadorController extends Controller {
	private static final long serialVersionUID = 1L;
	UsuarioNegocio usuarioNegocio;
	HttpSession session;
	RequestDispatcher requestDispatcher;
      
    public AutenticadorController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		session = request.getSession();
		
		Cookie cookie [] = request.getCookies();  
		
		if(action.equals("login")){
			String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            
            Usuario usuario = new Usuario();
            usuarioNegocio = new UsuarioNegocio();
            usuario = usuarioNegocio.autenticar(email, senha);
            
            //Chama a classe pai para verificar o usuário autenticado
            super.doPost(request, response, usuario);
		
            if(usuario != null){
	            String lembrar = request.getParameter("lembrar");
	            if(lembrar.equals("lembrar")){
					Cookie cookieLogin = new Cookie("login", request.getParameter("email"));  
					cookieLogin.setMaxAge(60*60*24*365);
					response.addCookie(cookieLogin);   
				}
            }
		}else{
            session.invalidate();
            requestDispatcher = getServletContext().getRequestDispatcher(String.format("%s/Index.jsp", Constants.VIEW));
            requestDispatcher.forward(request, response);
		}
	}

}
