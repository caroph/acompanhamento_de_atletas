package br.com.saat.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import br.com.saat.enumeradores.Perfis;
import br.com.saat.enumeradores.Presenca;
import br.com.saat.model.Atleta;
import br.com.saat.model.Chamada;
import br.com.saat.model.DiaTreino;
import br.com.saat.model.Usuario;
import br.com.saat.model.negocio.AtletaNegocio;
import br.com.saat.model.negocio.ChamadaNegocio;
import br.com.saat.model.negocio.CookieNegocio;
import br.com.saat.model.negocio.DiaTreinoNegocio;
import br.com.saat.model.negocio.DiasSemanaNegocio;
import br.com.saat.model.negocio.EquipesNegocio;
import br.com.saat.model.negocio.GrauParentescoNegocio;
import br.com.saat.model.negocio.PresencaChamadaNegocio;
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
		String retorno = null;
		
		String action = request.getParameter("action");
		
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(usuarioLogado == null || usuarioLogado.getIdPessoa() == 0){
			//Destroir sessão
			session.invalidate();
			//Setar mensagem de erro
			request.setAttribute("msgErro", "Você não possui permissão de acesso ao sistema!"); 
			retorno = String.format("%s/Index.jsp", Constants.VIEW);
			
		}else if("alterarSenhaUsuario".equals(action)){
			String msg = "";
			String msgSucesso = "";
			String senhaAtual = request.getParameter("senhaAtual");
			String novaSenha = request.getParameter("novaSenha");
			String confirmacaoSenha = request.getParameter("confirmacaoSenha");
			
			UsuarioNegocio negocio = new UsuarioNegocio();
			try {
				msg = negocio.verificarSenha(senhaAtual, novaSenha, confirmacaoSenha, usuarioLogado.getIdPessoa());
				if(msg == null || "".equals(msg)){
					if(negocio.alterarSenha(usuarioLogado, novaSenha, senhaAtual)){
						msgSucesso = "Senha alterada com sucesso!";
					}
				}
			} catch (Exception e) {
				msg = e.getMessage();
			} 
			request.setAttribute("msgErroSenha", msg);
			request.setAttribute("msgSucessoSenha", msgSucesso);
			//retorno = String.format("%s/SecretariaPrincipal.jsp", Constants.VIEW);
			retorno = session.getAttribute("pagina").toString();
						
		}else if("buscarAtletaDetalhes".equals(action)){
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
		    request.setAttribute("msgErro", msg);
			
		}else if("RegistrarPresenca".equals(action)){
			UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
			int perfil = usuarioLogado.getPerfil();
			if(perfil == Perfis.Nutricionista.getValor() || perfil == Perfis.Fisioterapeuta.getValor() ||
					perfil == Perfis.Psicologa.getValor()){
				String msg = "";
				String msgSucesso = "";
				
				int idAtleta = Integer.parseInt(request.getParameter("idAtleta"));
				String data = request.getParameter("dataPresenca");
				String hora = request.getParameter("hrPresenca");
				
				DiaTreinoNegocio diaNegocio = new DiaTreinoNegocio();
				ChamadaNegocio chamadaNegocio = new ChamadaNegocio();
				
				List<Object> listaValidacao = chamadaNegocio.validaDados(data, hora);
				boolean valida = (boolean) listaValidacao.get(0);
				if(valida){
					try {
						DiaTreino diaTreino = diaNegocio.buscarDiaTreino(data, idAtleta, hora);
						if(diaTreino.getIdDiaTreino() != 0){
							Chamada chamada = chamadaNegocio.buscarChamadaPorDia(data, diaTreino.getIdDiaTreino());
							
							if(chamada.getIdChamada() == 0){
								Date dt = new Date();
								DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
								dt = formatter.parse(data);
								chamada = new Chamada(usuarioLogado.getIdPessoa(), 
										diaTreino.getIdDiaTreino(), 0, dt);
								chamada = chamadaNegocio.salvarChamada(chamada);
							}
							PresencaChamadaNegocio pcNegocio = new PresencaChamadaNegocio();
							int presenca = Presenca.Nutricionista.getValor();
							if(perfil == Perfis.Psicologa.getValor())
								presenca = Presenca.Psicologo.getValor();
							else if(perfil == Perfis.Fisioterapeuta.getValor());
								presenca = Presenca.Fisioterapeuta.getValor();
							
							
							if(pcNegocio.salvarPresencaChamada(chamada.getIdChamada(), idAtleta, 
									presenca, null)){
								msgSucesso = "Presença registrada com sucesso!";
							}else{
								msg = "Ocorreu algum erro ao salvar a presença do atleta!";
							}
						}else{
							msg = "O atleta não está em treino neste horário!";
						}
						
					} catch (Exception e) {
						msg = e.getMessage();
					}			
				}else{
					msg = (String) listaValidacao.get(1);
				}
				AtletaNegocio negocio = new AtletaNegocio();
				List<Atleta> lista = new ArrayList<Atleta>();
				try{
					lista = negocio.buscarAtletas(1);
				}catch(Exception ex){
					msg = ex.getMessage();
				}
				
				request.setAttribute("listaAtletas", lista);
				request.setAttribute("msgErro", msg);
				request.setAttribute("msgSucesso", msgSucesso);
				if(perfil == Perfis.Nutricionista.getValor())
					retorno = String.format("%s/NutricionistaBuscaAtleta.jsp", Constants.VIEW);
				else
					retorno = String.format("%s/SaudeGeralBuscaAtleta.jsp", Constants.VIEW);
			}else{
				retorno = usuarioNegocio.retornoLogin(usuarioLogado);
			}
		}
		if(retorno != null){
			requestDispatcher = getServletContext().getRequestDispatcher(retorno);
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response, Usuario usuario, boolean lembrar,
			boolean login) throws ServletException, IOException {
		RequestDispatcher requestDispatcher;
		UsuarioNegocio usuarioNegocio;
		HttpSession session = request.getSession(false);
		String retorno = String.format("%s/Index.jsp", Constants.VIEW);
		
		//Usuário inválido
		if(usuario == null || usuario.getIdPessoa() == 0){
			//Destroir sessão
			session.invalidate();
			//Setar mensagem de erro
			if(login)
				request.setAttribute("msgErro", "Email ou senha inválidos!"); 
			else
				request.setAttribute("msgErro", "Você não possui permissão de acesso ao sistema!"); 
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
				if(novoCookie.getValue() != null){
					//Adicionar cookie à navegação
					response.addCookie(novoCookie);
				}
			}
		}
		if(request.getSession(false) != null)
			session.setAttribute("pagina", retorno);
		requestDispatcher = getServletContext().getRequestDispatcher(retorno);
		requestDispatcher.forward(request, response);
	}

}
