	package br.com.saat.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.saat.core.Constants;
import br.com.saat.core.Criptografia;
import br.com.saat.model.Usuario;
import br.com.saat.model.negocio.UsuarioNegocio;


@WebServlet(urlPatterns = {"/Autenticador"})
public class AutenticadorController extends Controller {
	private static final long serialVersionUID = 1L;
	UsuarioNegocio usuarioNegocio;
	Usuario usuario;
	Cookie novoCookie;
	HttpSession session;
	RequestDispatcher requestDispatcher;
	Criptografia criptografia;
	
      
    public AutenticadorController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Descobrindo ação desejada
		String action = request.getParameter("action");
		//Criando sessão
		session = request.getSession();
		
		///Login
		if("login".equals(action)){
			criptografia = new Criptografia();
			
			//Pegar parâmetros
			String email = request.getParameter("email");
            String senha = criptografia.criptografa(request.getParameter("senha"));
            boolean lembrar = "true".equals(request.getParameter("lembrar"));
            
            usuario = new Usuario();
            usuarioNegocio = new UsuarioNegocio();
            
            try {
            	//Autenticar usuário
				usuario = usuarioNegocio.autenticar(email, senha);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				request.setAttribute("msg", "Ocorreu algum erro no sistema.  Favor tente novamente!");  
			}
		            
            //Chamar a classe pai para verificar o usuário autenticado
            super.doPost(request, response, usuario, lembrar);
            
        //Logout
		}else{
            session.invalidate();
            requestDispatcher = getServletContext().getRequestDispatcher(String.format("%s/Index.jsp", Constants.VIEW));
            requestDispatcher.forward(request, response);
		}
	}
	
}
