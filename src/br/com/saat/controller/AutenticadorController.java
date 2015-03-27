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
import br.com.saat.model.negocio.CookieNegocio;
import br.com.saat.model.negocio.UsuarioNegocio;


@WebServlet(urlPatterns = {"/Autenticador"})
public class AutenticadorController extends Controller {
	private static final long serialVersionUID = 1L;
      
    public AutenticadorController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session;
		
		//Descobrindo ação desejada
		String action = request.getParameter("action");
		//Criando sessão
		session = request.getSession();
		
		///Login
		if("login".equals(action)){
			Criptografia crip = new Criptografia();
			
			//Pegar parâmetros
			String email = request.getParameter("email");
            String senha = crip.criptografa(request.getParameter("senha"));
            boolean lembrar = "true".equals(request.getParameter("lembrar"));
            
            Usuario usuario = new Usuario();
            UsuarioNegocio negocio = new UsuarioNegocio();
            
            try {
            	//Autenticar usuário
				usuario = negocio.autenticar(email, senha);
				
				//Chamar a classe pai para verificar o usuário autenticado
	        	super.doPost(request, response, usuario, lembrar, true);
			} catch (Exception e) {
				request.setAttribute("msg", e.getMessage());  
				RequestDispatcher rs = getServletContext().getRequestDispatcher(String.format("%s/Index.jsp", Constants.VIEW));
	            rs.forward(request, response);
			}
		}else if("logout".equals(action)){
			//Logout
            session.invalidate();
            
            //Destruir cookie
            Cookie novoCookie = CookieNegocio.addCookie(Constants.COOKIE_NAME, null, 0, null);
            if(novoCookie != null){
				//Adicionar cookie à navegação
				response.addCookie(novoCookie);
			}
            
            RequestDispatcher rs = getServletContext().getRequestDispatcher(String.format("%s/Index.jsp", Constants.VIEW));
            rs.forward(request, response);
            
		}else{
			//Esqueci minha senha
			String msg;
			String emailSenha = request.getParameter("emailSenha");
			UsuarioNegocio negocio = new UsuarioNegocio();
			
			if(emailSenha != null && !"".equals(emailSenha)){
				try {
					msg = negocio.esqueciSenha(emailSenha);
				} catch (Exception e) {
					msg = e.getMessage();
				}
			}else{
				msg = "Por favor, informe o seu email corretamente!";
			}
			request.setAttribute("msg", msg);
			RequestDispatcher rs = getServletContext().getRequestDispatcher(String.format("%s/Index.jsp", Constants.VIEW));
            rs.forward(request, response);
		}
	}
	
}
