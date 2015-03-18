	package br.com.saat.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.saat.core.Constants;
import br.com.saat.model.Usuario;
import br.com.saat.model.negocio.CookieNegocio;
import br.com.saat.model.negocio.UsuarioNegocio;


@WebServlet("/Autenticador")
public class AutenticadorController extends Controller {
	private static final long serialVersionUID = 1L;
	UsuarioNegocio usuarioNegocio;
	Usuario usuario;
	Cookie novoCookie;
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
		
		//Cookie cookie [] = request.getCookies();  
		
		if(action.equals("login")){
			String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            boolean lembrar = "true".equals(request.getParameter("lembrar"));
            
            usuario = new Usuario();
            usuarioNegocio = new UsuarioNegocio();
            usuario = usuarioNegocio.autenticar(email, senha);
		
            if(usuario != null){
            	if(lembrar){
            		String uuid = UUID.randomUUID().toString();
            		novoCookie = CookieNegocio.addCookie(Constants.COOKIE_NAME, uuid, Constants.COOKIE_AGE); // Extends age.
            	}else{
            		novoCookie = CookieNegocio.removeCookie(Constants.COOKIE_NAME);
            	}
            	response.addCookie(novoCookie);
            }
            
            //Chama a classe pai para verificar o usuário autenticado
            super.doPost(request, response, usuario, lembrar);
		}else{
            session.invalidate();
            requestDispatcher = getServletContext().getRequestDispatcher(String.format("%s/Index.jsp", Constants.VIEW));
            requestDispatcher.forward(request, response);
		}
	}
	
}
