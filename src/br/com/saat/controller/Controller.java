package br.com.saat.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

import net.sf.jasperreports.engine.JasperRunManager;

import com.google.gson.Gson;
import com.sun.xml.internal.bind.v2.model.core.ID;

import br.com.saat.core.Constants;
import br.com.saat.enumeradores.Perfis;
import br.com.saat.enumeradores.Presenca;
import br.com.saat.enumeradores.TpTorneio;
import br.com.saat.model.Atleta;
import br.com.saat.model.Chamada;
import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.DiaTreino;
import br.com.saat.model.Usuario;
import br.com.saat.model.dao.Torneio;
import br.com.saat.model.negocio.AtletaNegocio;
import br.com.saat.model.negocio.CatTorneioNegocio;
import br.com.saat.model.negocio.ChamadaNegocio;
import br.com.saat.model.negocio.CookieNegocio;
import br.com.saat.model.negocio.DiaTreinoNegocio;
import br.com.saat.model.negocio.DiasSemanaNegocio;
import br.com.saat.model.negocio.EquipesNegocio;
import br.com.saat.model.negocio.GpTorneioNegocio;
import br.com.saat.model.negocio.GrauParentescoNegocio;
import br.com.saat.model.negocio.NaipeNegocio;
import br.com.saat.model.negocio.PresencaChamadaNegocio;
import br.com.saat.model.negocio.TorneioNegocio;
import br.com.saat.model.negocio.TpTorneioNegocio;
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
										diaTreino.getIdDiaTreino(), dt);
								chamada = chamadaNegocio.salvarChamada(chamada);
							}
							PresencaChamadaNegocio pcNegocio = new PresencaChamadaNegocio();
							int presenca = Presenca.Nutricionista.getValor();
							if(perfil == Perfis.Psicologa.getValor())
								presenca = Presenca.Psicologo.getValor();
							else if(perfil == Perfis.Fisioterapeuta.getValor());
								presenca = Presenca.Fisioterapeuta.getValor();
							
							int idPresencaChamada = pcNegocio.verificarPresenca(chamada.getIdChamada(), idAtleta);
							if(idPresencaChamada == 0){
								if(pcNegocio.salvarPresencaChamada(chamada.getIdChamada(), idAtleta, 
										presenca, null)){
									msgSucesso = "Presença registrada com sucesso!";
								}else{
									msg = "Ocorreu algum erro ao salvar a presença do atleta!";
								}
							}else{
								msg = "Já existe presença registrada para o atleta neste horário!";
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
		}else if("voltaPaginaInicial".equals(action)){			
			Usuario usuario = (Usuario)session.getAttribute("usuarioLogado");
			
			UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
			
			retorno = usuarioNegocio.retornoLogin(usuario);
			
		}else if("gerarRelatorioTreino".equals(action)){
			int perfil = usuarioLogado.getPerfil();
			if(perfil == Perfis.Secretaria.getValor() || perfil == Perfis.Tecnico.getValor() || 
					perfil == Perfis.PreparadorFisico.getValor()){
				String dtInicial = request.getParameter("dataInicio");
				String dtFinal = request.getParameter("dataFim");
				
				try{
					Connection con = ConnectionFactory.getConnection();
					
					URL jasperURL = getServletContext().getResource("/relatorios/relatorioPresencaTreinos.jasper");
					HashMap params = new HashMap();
					
					Date dt = new Date();
					Date dt2 = new Date();
					DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
					dt = formatter.parse(dtInicial);
					dt2 = formatter.parse(dtFinal);
					String caminhoImg = getServletContext().getResource("/relatorios/brasao_cc.jpg").toString();
					
					params.put("dtInicio", new java.util.Date(dt.getTime()));				
					params.put("dtFim", new java.util.Date(dt2.getTime()));
					params.put("caminhoLogo", caminhoImg);
					
					byte[] bytes = JasperRunManager.runReportToPdf(jasperURL.openStream(), params, con);
					
					if(bytes != null){
						response.setContentType("application/pdf");
						OutputStream ops = response.getOutputStream();
						ops.write(bytes);
					}		
				}
				catch(Exception ex){
					request.setAttribute("msgErro", "Ocorreu algum erro ao gerar o relatório!");
					request.setAttribute("dataAtual", new Date());
					retorno = String.format("%s/RelatorioTreino.jsp", Constants.VIEW);
				}
			}else{
				UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
				retorno = usuarioNegocio.retornoLogin(usuarioLogado);
			}
		} else if ("relResulTorneio".equals(action)) {
			int perfil = usuarioLogado.getPerfil();
			if(perfil == Perfis.Secretaria.getValor() || perfil == Perfis.Tecnico.getValor() || 
					perfil == Perfis.PreparadorFisico.getValor()){
				int idTorneio = 0;
				Connection con = ConnectionFactory.getConnection();
				try{				
					idTorneio = Integer.parseInt(request.getParameter("idTorneio"));
					
					//URL jasperURL = new URL(host+jasper);
					URL jasperURL = getServletContext().getResource("/relatorios/resultadoTorneio.jasper");
					HashMap parms = new HashMap();
					String strSubReport = getServletContext().getRealPath("/relatorios/resultadoAtletaTorneio.jasper").toString();
					String caminhoImg = getServletContext().getResource("/relatorios/brasao_cc.jpg").toString();
					
					parms.put("idTorneio", idTorneio);
					parms.put("SUBREPORT_DIR", strSubReport);
					parms.put("caminhoLogo", caminhoImg);
					
					byte[] bytes = JasperRunManager.runReportToPdf(jasperURL.openStream(), parms, con);
					
					if(bytes != null){
						response.setContentType("application/pdf");
						OutputStream ops = response.getOutputStream();
						ops.write(bytes);
					}				
				}catch(Exception ex){
					try {
						TorneioNegocio negocio = new TorneioNegocio();
						List<Torneio> lista = new ArrayList<Torneio>();
						lista = negocio.buscaTorneiosFinalizados();
						if (lista.isEmpty()) {
							request.setAttribute("msgAlerta", "Nenhum resultado de torneio finalizado disponível!");
						} else {
							request.setAttribute("listaTorneios", lista);
						}
					} catch (Exception e) {
						request.setAttribute("msgAlerta", e.getMessage());
					}
					request.setAttribute("msgErro", "Erro ao gerar relatório! Favor tente novamente.");
					retorno = String.format("%s/RelatorioRelResultTorneio.jsp", Constants.VIEW);
				}
			} else{
				UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
				retorno = usuarioNegocio.retornoLogin(usuarioLogado);
			}
		} else if("detalhesTorneio".equals(action)){
			String msg = "";
			int idTorneio = Integer.parseInt(request.getParameter("idTorneio"));
			Torneio torneio = new Torneio();
			TorneioNegocio negocio = new TorneioNegocio();
			List<Atleta> listaAtleta = new ArrayList<Atleta>();
			
			try{
				torneio = negocio.buscarTorneio(idTorneio);
				listaAtleta = negocio.buscaAtletasPart(idTorneio);
			}catch(Exception ex){
				msg = ex.getMessage();
			}		
			
			List<String> listaNaipe = new NaipeNegocio().listaNaipeString();
			List<String> listaCategoria = new CatTorneioNegocio().listaCatTorneioString();
			List<String> listaTipo = new TpTorneioNegocio().listaTpTorneioString();
			List<String> listaGrupo = new GpTorneioNegocio().listaGpTorneioString();
			
			Map<String, Object> lista = new LinkedHashMap<String, Object>();
			lista.put("torneio", torneio);
			lista.put("listaAtleta", listaAtleta);
			lista.put("naipe", listaNaipe);
			lista.put("categoria", listaCategoria);
			lista.put("tipo", listaTipo);
			lista.put("grupo", listaGrupo);
			
			String json = new Gson().toJson(lista);

		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		    request.setAttribute("msgErro", msg);
		    
		}else if("gerarRelatorioConsultaMedica".equals(action)){
			int perfil = usuarioLogado.getPerfil();
			if(perfil == Perfis.Secretaria.getValor() || perfil == Perfis.Tecnico.getValor() || 
					perfil == Perfis.PreparadorFisico.getValor()){
				String dtInicial = request.getParameter("dataInicio");
				String dtFinal = request.getParameter("dataFim");
				
				try{
					Connection con = ConnectionFactory.getConnection();
					
					URL jasperURL = getServletContext().getResource("/relatorios/relatorioPresencaMedica.jasper");
					HashMap params = new HashMap();
					
					Date dt = new Date();
					Date dt2 = new Date();
					DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
					dt = formatter.parse(dtInicial);
					dt2 = formatter.parse(dtFinal);
					String caminhoImg = getServletContext().getResource("/relatorios/brasao_cc.jpg").toString();
					
					params.put("dtInicial", new java.util.Date(dt.getTime()));				
					params.put("dtFinal", new java.util.Date(dt2.getTime()));
					params.put("caminhoLogo", caminhoImg);
					
					byte[] bytes = JasperRunManager.runReportToPdf(jasperURL.openStream(), params, con);
					
					if(bytes != null){
						response.setContentType("application/pdf");
						OutputStream ops = response.getOutputStream();
						ops.write(bytes);
					}		
				}
				catch(Exception ex){
					request.setAttribute("msgErro", "Ocorreu algum erro ao gerar o relatório!");
					request.setAttribute("dataAtual", new Date());
					retorno = String.format("%s/RelatorioConsultaMedica.jsp", Constants.VIEW);
				}
			}else{
				UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
				retorno = usuarioNegocio.retornoLogin(usuarioLogado);
			}
		} else if ("relFrequenciaTorneio".equals(action)) {
			int perfil = usuarioLogado.getPerfil();
			if(perfil == Perfis.Secretaria.getValor() || perfil == Perfis.Tecnico.getValor() || 
					perfil == Perfis.PreparadorFisico.getValor()){
				int idTorneio = 0;
				Connection con = ConnectionFactory.getConnection();
				try{				
					String dtInicial = request.getParameter("dtInicial");
					String dtFinal = request.getParameter("dtFinal");
					Date dtI = new Date();
					Date dtF = new Date();
					DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
					dtI = formatter.parse(dtInicial);
					dtF = formatter.parse(dtFinal);
					
					int classificacao = Integer.parseInt(request.getParameter("classificacao"));
					String relatorio = "";
					
					switch (classificacao) {
					case 1:
						relatorio = "/relatorios/frequenciaTorneioGeral.jasper";
						break;
					case 2:
						relatorio = "/relatorios/frequenciaTorneioAtleta.jasper";
						break;
					case 3:
						relatorio = "/relatorios/frequenciaTorneioTipo.jasper";
						break;
					}

					URL jasperURL = getServletContext().getResource(relatorio);
					HashMap params = new HashMap();
					
					params.put("dtInicial", new java.util.Date(dtI.getTime()));				
					params.put("dtFinal", new java.util.Date(dtF.getTime()));
					
					byte[] bytes = JasperRunManager.runReportToPdf(jasperURL.openStream(), params, con);
					
					if(bytes != null){
						response.setContentType("application/pdf");
						OutputStream ops = response.getOutputStream();
						ops.write(bytes);
					}				
				}catch(Exception ex){
					request.setAttribute("msgErro", "Erro ao gerar relatório! Favor tente novamente.");
					request.setAttribute("dataAtual", new Date());
					retorno = String.format("%s/RelatorioFreqTorneio.jsp", Constants.VIEW);
				}
			} else{
				UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
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
				if (session == null) {
					session = request.getSession();
				}
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
