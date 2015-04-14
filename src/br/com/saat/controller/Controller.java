package br.com.saat.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.saat.core.Constants;
import br.com.saat.model.Atleta;
import br.com.saat.model.Usuario;
import br.com.saat.model.negocio.AtletaNegocio;
import br.com.saat.model.negocio.CookieNegocio;
import br.com.saat.model.negocio.DiasSemanaNegocio;
import br.com.saat.model.negocio.EquipesNegocio;
import br.com.saat.model.negocio.GrauParentescoNegocio;
import br.com.saat.model.negocio.UsuarioNegocio;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher requestDispatcher;
		HttpSession session = request.getSession();
		String retorno = String.format("%s/Index.jsp", Constants.VIEW);
		
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(usuarioLogado == null || usuarioLogado.getIdPessoa() == 0){
			//Destroir sessão
			session.invalidate();
			//Setar mensagem de erro
			request.setAttribute("msg", "Você não possui permissão de acesso ao sistema!"); 
			requestDispatcher = getServletContext().getRequestDispatcher(retorno);
			requestDispatcher.forward(request, response);
			
		}else if("buscarAtletaDetalhes".equals(request.getParameter("action"))){
			String msg = "";
			int idAtleta = Integer.parseInt(request.getParameter("idAtleta"));
			Atleta atleta = new Atleta();
			AtletaNegocio negocio = new AtletaNegocio();
			
			try{
				atleta = negocio.buscarAtletaDetalhes(idAtleta);
			}catch(Exception ex){
				msg = ex.getMessage();
			}		
			
			List<String> listaGrauParentesco = new GrauParentescoNegocio().listaGrausString();
			List<String> listaDiaSemana = new DiasSemanaNegocio().listaSemanaString();
			List<String> listaEquipe = new EquipesNegocio().listaEquipeString();
			
			Map<String, Object> lista = new LinkedHashMap<String, Object>();
			lista.put("atleta", atleta);
			lista.put("grauParentesco", listaGrauParentesco);
			lista.put("diaSemana", listaDiaSemana);
			lista.put("equipe", listaEquipe);
			
			String json = new Gson().toJson(lista);

		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		    request.setAttribute("msg", msg);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response, Usuario usuario, boolean lembrar,
			boolean login) throws ServletException, IOException {
		RequestDispatcher requestDispatcher;
		UsuarioNegocio usuarioNegocio;
		HttpSession session = request.getSession();
		String retorno = String.format("%s/Index.jsp", Constants.VIEW);
		
		//Usuário inválido
		if(usuario == null || usuario.getIdPessoa() == 0){
			//Destroir sessão
			session.invalidate();
			//Setar mensagem de erro
			if(login)
				request.setAttribute("msg", "Email ou senha inválidos!"); 
			else
				request.setAttribute("msg", "Você não possui permissão de acesso ao sistema!"); 
		//Usuário válido
		}else{
			//Pegar página para redirecionamento
			usuarioNegocio = new UsuarioNegocio();
			retorno = usuarioNegocio.retornoLogin(usuario);
			
			if(login){
				//Criar sessão de usuário logado
    			session.setAttribute("usuarioLogado", usuario);
    			
				Cookie novoCookie;
				
				//Criar cookie se a opção "Lembrar" estiver habilitada
				if(lembrar){
					//Criar código de cookie
	        		String uuid = UUID.randomUUID().toString();
	        		//Adicionar cookie
	        		novoCookie = CookieNegocio.addCookie(Constants.COOKIE_NAME, uuid, Constants.COOKIE_AGE, usuario); 
				}else{
	        		//Adiciona cookie vazio = Limpar
	        		novoCookie = CookieNegocio.addCookie(Constants.COOKIE_NAME, null, 0, usuario);
	        	}
				
				//Cookie válido
				if(novoCookie != null){
					//Adicionar cookie à navegação
					response.addCookie(novoCookie);
				}
			}
		}
		requestDispatcher = getServletContext().getRequestDispatcher(retorno);
		requestDispatcher.forward(request, response);
	}

}
