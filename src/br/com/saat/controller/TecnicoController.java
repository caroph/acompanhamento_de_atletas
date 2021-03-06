package br.com.saat.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.saat.core.Constants;
import br.com.saat.enumeradores.CatTorneio;
import br.com.saat.enumeradores.GpTorneio;
import br.com.saat.enumeradores.Mes;
import br.com.saat.enumeradores.Naipe;
import br.com.saat.enumeradores.Perfis;
import br.com.saat.enumeradores.Presenca;
import br.com.saat.enumeradores.ResultadoTorneio;
import br.com.saat.enumeradores.TpTorneio;
import br.com.saat.model.Atleta;
import br.com.saat.model.AvaliacaoDesempenho;
import br.com.saat.model.AvaliacaoFisica;
import br.com.saat.model.Chamada;
import br.com.saat.model.DiaTreino;
import br.com.saat.model.PresencaChamada;
import br.com.saat.model.Torneio;
import br.com.saat.model.Usuario;
import br.com.saat.model.negocio.AtletaNegocio;
import br.com.saat.model.negocio.AvaliacaoFisicaNegocio;
import br.com.saat.model.negocio.CatTorneioNegocio;
import br.com.saat.model.negocio.ChamadaNegocio;
import br.com.saat.model.negocio.DiaTreinoNegocio;
import br.com.saat.model.negocio.GpTorneioNegocio;
import br.com.saat.model.negocio.MesNegocio;
import br.com.saat.model.negocio.NaipeNegocio;
import br.com.saat.model.negocio.ObservacaoNegocio;
import br.com.saat.model.negocio.PresencaChamadaNegocio;
import br.com.saat.model.negocio.ResultadoTorneioNegocio;
import br.com.saat.model.negocio.TorneioNegocio;
import br.com.saat.model.negocio.TpTorneioNegocio;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class TecnicoController
 */
@WebServlet("/TecnicoController")
public class TecnicoController extends Controller {
	private static final long serialVersionUID = 1L;
       
	public TecnicoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		String servletRetorno = "/TecnicoController";
		
		//Verifica autentica��o usuário
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(usuarioLogado == null || (usuarioLogado.getPerfil() != Perfis.Tecnico.getValor() && usuarioLogado.getPerfil() != Perfis.PreparadorFisico.getValor())){
			super.doPost(request, response, usuarioLogado, false, false);
			return;
		}		
		
		ObservacaoNegocio obsNegocio = new ObservacaoNegocio();
		try{
			int notificacao = obsNegocio.buscarObservacoesNotificacao(usuarioLogado.getIdPessoa());
			request.setAttribute("notificacaoObs", notificacao);
		}catch(Exception ex){
			request.setAttribute("msgErro", ex.getMessage());
		}
		
		String retorno = null;
		String action = request.getParameter("action");
		
		if("jspBuscarAtletas".equals(action)){
			//Carregar página Buscar Atleta
			AtletaNegocio negocio = new AtletaNegocio();
			List<Atleta> lista = new ArrayList<Atleta>();
			try{
				lista = negocio.buscarAtletas(1);
			}catch(Exception ex){
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			request.setAttribute("listaAtletas", lista);
			retorno = String.format("%s/TecnicoBuscaAtleta.jsp", Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspBuscarAtletas";
			
		}else if("jspNovoTorneio".equals(action)){
			NaipeNegocio naipeNegocio = new NaipeNegocio();
			List<Naipe> listaNaipe = naipeNegocio.listaNaipe();
			
			CatTorneioNegocio catTorneioNegocio = new CatTorneioNegocio();
			List<CatTorneio> listaCategoria = catTorneioNegocio.listaCatTorneio();
			
			TpTorneioNegocio tpTorneioNegocio = new TpTorneioNegocio();
			List<TpTorneio> listaTipo = tpTorneioNegocio.listaTpTorneio();
			
			GpTorneioNegocio gpTorneioNegocio = new GpTorneioNegocio();
			List<GpTorneio> listaGrupo = gpTorneioNegocio.listaGpTorneio();
			
			AtletaNegocio atletaNegocio = new AtletaNegocio();
			
			try {
				List<Atleta> listaAtleta = atletaNegocio.buscarAtletasAptos();
				request.setAttribute("listaAtletasPart", listaAtleta);
				
			} catch (Exception ex) {
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			request.setAttribute("listaNaipe", listaNaipe);
			request.setAttribute("listaCategoria", listaCategoria);
			request.setAttribute("listaTipo", listaTipo);
			request.setAttribute("listaGrupo", listaGrupo);
			
			retorno = String.format("%s/TecnicoNovoTorneio.jsp",
					Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspNovoTorneio";			
			
		}else if("novoTorneio".equals(action)){
			boolean exception = false;
			int idTorneio = 0;
			String msgSucesso = "";
			String msgErro = "";
			String atletasPart[] = null;
			Torneio torneio = new Torneio();
			Usuario usuario = new Usuario();

			String dtaInicial = request.getParameter("dtInicial");
			String dtaFinal = request.getParameter("dtFinal");
			Date dtInicial = null;
			Date dtFinal = null;

			try {
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				dtInicial = (Date) formatter.parse(dtaInicial);
				dtFinal = (Date) formatter.parse(dtaFinal);
				
				if ("".equals(request.getParameter("idTorneio")) || request.getParameter("idTorneio") == null) {
					idTorneio = 0;
				} else{
					idTorneio = Integer.parseInt(request.getParameter("idTorneio"));
				}
			} catch (Exception ex) {
				msgErro = "Ocorreu algum erro no sistema! Favor tentar novamente.";
				exception = true;
			}
			try {
				torneio.setIdNaipe(Integer.parseInt(request.getParameter("naipe")));
			} catch (Exception ex) {
				msgErro = "Favor selecionar corretamente o campo 'Naipe' !";
				exception = true;
			}
			try {
				torneio.setIdCatTorneio(Integer.parseInt(request.getParameter("categoria")));
			} catch (Exception ex) {
				msgErro = "Favor selecionar corretamente o campo 'Categoria' !";
				exception = true;
			}
			try {
				torneio.setIdTpTorneio(Integer.parseInt(request.getParameter("tipo")));
			} catch (Exception ex) {
				msgErro = "Favor selecionar corretamente o campo 'Tipo' !";
				exception = true;
			}
			try {
				torneio.setIdGpTorneio(Integer.parseInt(request.getParameter("grupo")));
			} catch (Exception ex) {
				msgErro = "Favor selecionar corretamente o campo 'Grupo' !";
				exception = true;
			}

			if (!exception) {
				torneio.setNome(request.getParameter("nome"));
				torneio.setLocal(request.getParameter("local"));
				torneio.setEstado(request.getParameter("estado"));
				torneio.setCidade(request.getParameter("cidade"));
				torneio.setDtInicial(dtInicial);
				torneio.setDtFinal(dtFinal);
				torneio.setDescricao(request.getParameter("descricao"));
				
				atletasPart = request.getParameterValues("atletasPart");
				
				TorneioNegocio negocio = new TorneioNegocio();

				if (!"".equals(idTorneio) && !"0".equals(idTorneio)) {
					torneio.setIdTorneio(idTorneio);
				}
				
				List<Object> listaValidacao = negocio.validaDados(torneio);
				boolean valida = (boolean) listaValidacao.get(0);
				if (!valida) {
					msgErro = (String) listaValidacao.get(1);
				} else {
					try {
						if (torneio.getIdTorneio() == 0) {
							int idNovoTorneio = negocio.inserir(torneio, usuario);
							if (idNovoTorneio > 0){
								if (!"".equals(atletasPart) && atletasPart != null){
									if (negocio.inserirAtletasPart(atletasPart, idNovoTorneio)){
										msgSucesso = "Torneio salvo com sucesso!";
									}
								}else{
									msgSucesso = "Torneio salvo com sucesso!";
								}
							}
						} else {
							if (negocio.editarTorneio(torneio, atletasPart, usuario)) {
								msgSucesso = "Torneio editado com sucesso!";
							}
						}
					} catch (Exception ex) {
						msgErro = ex.getMessage();
					}
				}
			}

			NaipeNegocio naipeNegocio = new NaipeNegocio();
			List<Naipe> listaNaipe = naipeNegocio.listaNaipe();
			
			CatTorneioNegocio catTorneioNegocio = new CatTorneioNegocio();
			List<CatTorneio> listaCategoria = catTorneioNegocio.listaCatTorneio();
			
			TpTorneioNegocio tpTorneioNegocio = new TpTorneioNegocio();
			List<TpTorneio> listaTipo = tpTorneioNegocio.listaTpTorneio();
			
			GpTorneioNegocio gpTorneioNegocio = new GpTorneioNegocio();
			List<GpTorneio> listaGrupo = gpTorneioNegocio.listaGpTorneio();
			
			AtletaNegocio atletaNegocio = new AtletaNegocio();
			
			try {
				List<Atleta> listaAtleta = atletaNegocio.buscarAtletasAptos();
				request.setAttribute("listaAtletasPart", listaAtleta);
				
			} catch (Exception ex) {
				msgErro = ex.getMessage();
			}
			
			request.setAttribute("listaNaipe", listaNaipe);
			request.setAttribute("listaCategoria", listaCategoria);
			request.setAttribute("listaTipo", listaTipo);
			request.setAttribute("listaGrupo", listaGrupo);

			if (("").equals(msgSucesso)) {
				request.setAttribute("msgErro", msgErro);
				request.setAttribute("torneio", torneio);
				retorno = String.format("%s/TecnicoNovoTorneio.jsp",
						Constants.VIEW);
				servletRetorno = "/TecnicoController?action=jspNovoTorneio";
			} else {
				request.setAttribute("msgSucesso", msgSucesso);
				retorno = String.format("%s/TecnicoCalendarioTorneio.jsp",
						Constants.VIEW);
				servletRetorno = "/TecnicoController?action=jspCalendario";
			}
			
		}else if("jspCalendario".equals(action)){
			retorno = String.format("%s/TecnicoCalendarioTorneio.jsp", Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspCalendario";
			
		}else if("editarTorneio".equals(action)){
			int idTorneio = Integer.parseInt(request.getParameter("idTorneio"));
			Torneio torneio = new Torneio();
			TorneioNegocio negocio = new TorneioNegocio();
			
			try {
				torneio = negocio.buscarTorneio(idTorneio);
				request.setAttribute("torneio", torneio);
			} catch (Exception ex) {
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			NaipeNegocio naipeNegocio = new NaipeNegocio();
			List<Naipe> listaNaipe = naipeNegocio.listaNaipe();
			
			CatTorneioNegocio catTorneioNegocio = new CatTorneioNegocio();
			List<CatTorneio> listaCategoria = catTorneioNegocio.listaCatTorneio();
			
			TpTorneioNegocio tpTorneioNegocio = new TpTorneioNegocio();
			List<TpTorneio> listaTipo = tpTorneioNegocio.listaTpTorneio();
			
			GpTorneioNegocio gpTorneioNegocio = new GpTorneioNegocio();
			List<GpTorneio> listaGrupo = gpTorneioNegocio.listaGpTorneio();
			
			AtletaNegocio atletaNegocio = new AtletaNegocio();
			
			try {
				List<Atleta> listaAtleta = atletaNegocio.buscarAtletasAptos();
				List<Integer> atletasSelecionados = atletaNegocio.buscarAtletasSelecionados(idTorneio);
				
				for (Atleta atleta : listaAtleta) {
					if (atletasSelecionados != null && atletasSelecionados.contains(atleta.getIdPessoa())) {
						atleta.setSelecionado(true);
					}
				}
				
				request.setAttribute("listaAtletasPart", listaAtleta);
				
			} catch (Exception ex) {
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			request.setAttribute("listaNaipe", listaNaipe);
			request.setAttribute("listaCategoria", listaCategoria);
			request.setAttribute("listaTipo", listaTipo);
			request.setAttribute("listaGrupo", listaGrupo);
			
			retorno = String.format("%s/TecnicoNovoTorneio.jsp",
					Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspNovoTorneio";
			servletRetorno = "/TecnicoController?action=jspNovoTorneio";
			
		}else if("excluirTorneio".equals(action)){
			String msgErro = "";
			String msgSucesso = "";
			
			Torneio torneio = new Torneio();
			torneio.setIdTorneio(Integer.parseInt(request.getParameter("idTorneio")));
			
			Usuario usuario = new Usuario();

			TorneioNegocio negocio = new TorneioNegocio();
			
			try {
				if (negocio.desativar(torneio, usuario)) {
					msgSucesso = "Torneio exclu�do com sucesso!";
				} else {
					msgErro = "Ocorreu algum erro no sistema! Favor tentar novamente.";
				}
			} catch (Exception ex) {
				msgErro = ex.getMessage();
			}
			
			if(!"".equals(msgSucesso)){
				request.setAttribute("msgSucesso", msgSucesso);
			}else{
				request.setAttribute("msgErro", msgErro);
			}

			retorno = String.format("%s/TecnicoCalendarioTorneio.jsp", Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspCalendario";

		} else if("jspFinalizarTorneio".equals(action)){
			int idTorneio = Integer.parseInt(request.getParameter("idTorneio"));
			String nomeTorneio = request.getParameter("nome");
			
			Torneio torneio = new Torneio();
			TorneioNegocio negocio = new  TorneioNegocio();
			List<Atleta> listaAtletas = null;
			
			try {
				listaAtletas =  negocio.buscaAtletasPart(idTorneio);
				request.setAttribute("listaAtletas", listaAtletas);
			} catch (Exception e) {
				request.setAttribute("msgErro", e.getMessage());
			}
			
			ResultadoTorneioNegocio resultadoTorneio = new ResultadoTorneioNegocio();
			List<ResultadoTorneio> listaResultado = resultadoTorneio.listaResultadoTorneio();
			
			torneio.setIdTorneio(idTorneio);
			torneio.setNome(nomeTorneio);
			torneio.setInscritosClube(listaAtletas.size());
			
			request.setAttribute("torneio", torneio);
			request.setAttribute("listaResultado", listaResultado);
			
			retorno = String.format("%s/TecnicoFinalizarTorneio.jsp", Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspFinalizarTorneio&idTorneio=" +
				request.getParameter("idTorneio") + "&nome=" + request.getParameter("nome");
			
		}else if ("finalizarTorneio".equals(action)){
			boolean exception = false;
			int idTorneio = 0;
			int idDestaque = 0;
			String msgSucesso = "";
			String msgErro = "";
			Torneio torneio = new Torneio();
			TorneioNegocio negocio = new TorneioNegocio();
			List<Atleta> listaAtletasPart = null;
			
			String dtaMkt = request.getParameter("encaminhamentoMkt");
			Date dtMkt = null;
			
			try {
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				dtMkt = (Date) formatter.parse(dtaMkt);
				
				idTorneio = Integer.parseInt(request.getParameter("idTorneio"));
			} catch (Exception ex) {
				msgErro = "Ocorreu algum erro no sistema! Favor tentar novamente.";
				exception = true;
			}
			
			try {
				torneio.setInscritosGeral(Integer.parseInt(request.getParameter("inscritosGeral")));
				torneio.setInscritosClube(Integer.parseInt(request.getParameter("inscritosClube")));
			} catch (Exception ex) {
				msgErro = "Favor preencher o campo 'Total inscritos(geral)' e/ou 'Total inscritos(Clube Curitibano)' corretamente!";
				exception = true;
			}

			try {
				idDestaque = Integer.parseInt(request.getParameter("destaque"));
			} catch (Exception ex) {
				msgErro = "Favor preencher o campo 'Atleta destaque' corretamente!";
				exception = true;
			}
			
			try {
				listaAtletasPart =  negocio.buscaAtletasPart(idTorneio);
			} catch (Exception e) {
				request.setAttribute("msgErro", e.getMessage());
			} 	
			
			if (!exception) {
				Usuario usuario = new Usuario();
				
				Atleta atleta = new Atleta();
				atleta.setIdPessoa(idDestaque);

				torneio.setIdTorneio(idTorneio);
				torneio.setNome(request.getParameter("nome"));
				torneio.setIdDestaque(atleta);
				torneio.setMotivoDestaque(request.getParameter("motivoDestaque"));
				torneio.setFotografo(request.getParameter("fotografo"));
				torneio.setEncaminhamentoMkt(dtMkt);
				
				List<Object> listaValidacao = negocio.validaDadosFinalizar(torneio);
				boolean valida = (boolean) listaValidacao.get(0);
				if (!valida) {
					msgErro = (String) listaValidacao.get(1);
				} else {
					
					for (Atleta atletaPart : listaAtletasPart) {
						String colocao = "colocacao" + atletaPart.idPessoa;
						String observacao = "observacao" + atletaPart.idPessoa;
						
						try {
							atletaPart.setColocacao(Integer.parseInt(request.getParameter(colocao)));
						} catch (Exception e) {
							atletaPart.setColocacao(0);
						}
						atletaPart.setObservacao(request.getParameter(observacao));
					}
					
					listaValidacao = negocio.validaAtletasPart(listaAtletasPart);
					valida = (boolean) listaValidacao.get(0);
					if (!valida) {
						msgErro = (String) listaValidacao.get(1);
					} else {
						try {
							if (negocio.finalizarTorneio(torneio, listaAtletasPart, usuario)) {
								msgSucesso = "Torneio finalizado com sucesso!";
							}
						} catch (Exception ex) {
							msgErro = ex.getMessage();
						}
					}
				}
			}

			if ("".equals(msgSucesso)) {
				request.setAttribute("msgErro", msgErro);
				request.setAttribute("torneio", torneio);
				request.setAttribute("listaAtletas", listaAtletasPart);
				retorno = String.format("%s/TecnicoFinalizarTorneio.jsp", Constants.VIEW);
				servletRetorno = "/TecnicoController?action=jspFinalizarTorneio&idTorneio=" +
					request.getParameter("idTorneio") + "&nome=" + request.getParameter("nome");
			} else {
				request.setAttribute("msgSucesso", msgSucesso);
				retorno = String.format("%s/TecnicoCalendarioTorneio.jsp", Constants.VIEW);
				servletRetorno = "/TecnicoController?action=jspCalendario";
			}
			
		} else if ("editarResultadoTorneio".equals(action)) {
			int idTorneio = Integer.parseInt(request.getParameter("idTorneio"));
			Torneio torneio = new Torneio();
			TorneioNegocio negocio = new TorneioNegocio();
			
			try {
				torneio = negocio.buscarTorneio(idTorneio);
				request.setAttribute("torneio", torneio);
				
				List<Atleta> listaAtleta = negocio.buscaAtletasPart(idTorneio);
				request.setAttribute("listaAtletas", listaAtleta);
				
				ResultadoTorneioNegocio resultadoTorneio = new ResultadoTorneioNegocio();
				List<ResultadoTorneio> listaResultado = resultadoTorneio.listaResultadoTorneio();
				
				request.setAttribute("listaResultado", listaResultado);
			} catch (Exception ex) {
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			retorno = String.format("%s/TecnicoFinalizarTorneio.jsp",
					Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspFinalizarTorneio&idTorneio=" +
				request.getParameter("idTorneio") + "&nome=" + request.getParameter("nome");
		}
		else if("jspChamadaQuadra".equals(action)){
			DiaTreinoNegocio negocio = new DiaTreinoNegocio();
			List<DiaTreino> lista = new ArrayList<DiaTreino>();
			try {
				lista = negocio.buscaDiasTreino(new Date());
			} catch (Exception ex) {
				request.setAttribute("msgErro", ex.getMessage());
			}

			request.setAttribute("dataAtual", new Date());
			request.setAttribute("listaDiasTreinos", lista);
			retorno = String.format("%s/TecnicoChamadaQuadras.jsp", Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspChamadaQuadra";
			
		}else if("CarregarAtletasAutoComplete".equals(action)){
			String busca = request.getParameter("acbusca");
			String diaTreino = request.getParameter("idDiaTreino");
			AtletaNegocio negocio = new AtletaNegocio();
			List<Atleta> listaAtleta = new ArrayList<Atleta>();
			try{
				listaAtleta = negocio.buscarAtletasPorNome(busca, diaTreino);
			}catch(Exception ex){
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			String json = new Gson().toJson(listaAtleta);

		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		    
		}else if("SalvarChamadaQuadra".equals(action)){
			String msgErro = ""; 
			boolean exception = false;
			
			Date dt = new Date();
			String dataChamada = request.getParameter("dataQuadra");
			try{
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
				dt = formatter.parse(dataChamada);
			}catch(Exception ex){
				msgErro = "A data deve ser preenchida corretamente!";
				exception = true;
			}
			int idDiaTreino = 0;
			try{
				idDiaTreino = Integer.parseInt(request.getParameter("diaTreino"));
			}catch(Exception ex){
				msgErro = "O dia de treino deve ser selecionado!";
				exception = true;
			}	
			
			if(!exception){
				ChamadaNegocio negocio = new ChamadaNegocio();
				Chamada chamada = new Chamada();
				try {
					chamada = negocio.buscarChamadaPorDia(dataChamada, idDiaTreino);
				} catch (Exception e) {
					msgErro = e.getMessage();
				}
				
				if(chamada.getIdChamada() == 0){
					chamada.setDtChamada(dt);
					chamada.setIdDiaTreino(idDiaTreino);
					chamada.setIdUsuario(usuarioLogado.getIdPessoa());
					
					try {
						chamada = negocio.salvarChamada(chamada);
					} catch (Exception e) {
						msgErro = e.getMessage();
					}
				}
				
				PresencaChamadaNegocio pcNegocio = new PresencaChamadaNegocio();
				try{
					pcNegocio.excluirPresencaChamada(chamada.getIdChamada());
				}catch(Exception ex){
					msgErro = ex.getMessage();
				}
				
				String objeto = request.getParameter("atletasQuadras");
				try{
					Gson gson = new Gson();
					ArrayList<Map<String, String>> myList = gson.fromJson(objeto,
				            new TypeToken<ArrayList<HashMap<String, String>>>() {
				            }.getType());

				    for (Map<String, String> m : myList) {
				    	PresencaChamada presenca = new PresencaChamada();
				    	presenca.setEstadoPresencaT(Presenca.Presente.getValor());
				    	presenca.setEstadoPresencaF(Presenca.Presente.getValor());
				    	presenca.setIdAtleta(Integer.parseInt(m.get("idAtleta")));
				    	presenca.setIdChamada(chamada.getIdChamada());
				    	String quadra = m.get("idQuadra").split("-")[1];
				    	presenca.setNrQuadra(Integer.parseInt(quadra));
				    	try{
				    		int idPresencaChamada = pcNegocio.verificarPresenca(chamada.getIdChamada(), presenca.getIdAtleta());
				    		if(idPresencaChamada == 0){
				    			pcNegocio.salvarPresencaChamada(presenca);
				    		}else{
				    			presenca.setIdPresencaChamada(idPresencaChamada);
				    			presenca.setJustificativaT("");
				    			pcNegocio.alterarPresencaChamada(presenca, "T");
				    		}
				    	}catch(Exception ex){
				    		msgErro = ex.getMessage();
				    	}
				    }
				   
				}catch(Exception ex){
					msgErro = "Erro";
				}
			}
			
			DiaTreinoNegocio diaTreinoNegocio = new DiaTreinoNegocio();
			List<DiaTreino> lista = new ArrayList<DiaTreino>();
			try {
				lista = diaTreinoNegocio.buscaDiasTreino(new Date());
			} catch (Exception ex) {
				msgErro = ex.getMessage();
			}

			request.setAttribute("dataAtual", new Date());
			if("".equals(msgErro))
				request.setAttribute("msgSucesso", "Presen�a em quadra salva com sucesso!");
			else
				request.setAttribute("msgErro", msgErro);
			request.setAttribute("listaDiasTreinos", lista);
			retorno = String.format("%s/TecnicoChamadaQuadras.jsp", Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspChamadaQuadra";
			
		}else if("carregarChamada".equals(action)){
			boolean exception = false;
			String msgErro = "";
			String diaTreino = request.getParameter("diaTreino");
			String dataChamada = request.getParameter("dataQuadra");
			int idDiaTreino = Integer.parseInt(diaTreino);
			
			if(!"".equals(diaTreino) && !"0".equals(diaTreino) && !"".equals(dataChamada)){
				ChamadaNegocio negocio = new ChamadaNegocio();
				Chamada chamada = new Chamada();
				PresencaChamadaNegocio pcnegocio = new PresencaChamadaNegocio();
				List<PresencaChamada> presenca = new ArrayList<PresencaChamada>();
				
				try {
					chamada = negocio.buscarChamadaPorDia(dataChamada, idDiaTreino);
					presenca = pcnegocio.buscarPresencasPorChamada(chamada.getIdChamada());
				} catch (Exception e) {
					msgErro = e.getMessage();
					exception = true;
				}
					
				if(!exception){
					List<PresencaChamada> presenca1 = new ArrayList<PresencaChamada>();
					List<PresencaChamada> presenca2 = new ArrayList<PresencaChamada>();
					List<PresencaChamada> presenca3 = new ArrayList<PresencaChamada>();
					List<PresencaChamada> presenca4 = new ArrayList<PresencaChamada>();
					List<PresencaChamada> presenca5 = new ArrayList<PresencaChamada>();
					List<PresencaChamada> presenca6 = new ArrayList<PresencaChamada>();
					List<PresencaChamada> presenca7 = new ArrayList<PresencaChamada>();
					List<PresencaChamada> presenca8 = new ArrayList<PresencaChamada>();
					List<PresencaChamada> presenca9 = new ArrayList<PresencaChamada>();
					List<PresencaChamada> presenca10 = new ArrayList<PresencaChamada>();
					List<PresencaChamada> presenca11 = new ArrayList<PresencaChamada>();
					List<PresencaChamada> presenca12 = new ArrayList<PresencaChamada>();
					
					for (PresencaChamada presencaChamada : presenca) {
						switch (presencaChamada.getNrQuadra()) {
						case 1:
							presenca1.add(presencaChamada);
							break;
						case 2:
							presenca2.add(presencaChamada);
							break;
						case 3:
							presenca3.add(presencaChamada);
							break;
						case 4:
							presenca4.add(presencaChamada);
							break;
						case 5:
							presenca5.add(presencaChamada);
							break;
						case 6:
							presenca6.add(presencaChamada);
							break;
						case 7:
							presenca7.add(presencaChamada);
							break;
						case 8:
							presenca8.add(presencaChamada);
							break;
						case 9:
							presenca9.add(presencaChamada);
							break;
						case 10:
							presenca10.add(presencaChamada);
							break;
						case 11:
							presenca11.add(presencaChamada);
							break;
						case 12:
							presenca12.add(presencaChamada);
							break;
						default:
							break;
						}
					}
					
					request.setAttribute("listaPresencaChamada1", presenca1);
					request.setAttribute("listaPresencaChamada2", presenca2);
					request.setAttribute("listaPresencaChamada3", presenca3);
					request.setAttribute("listaPresencaChamada4", presenca4);
					request.setAttribute("listaPresencaChamada5", presenca5);
					request.setAttribute("listaPresencaChamada6", presenca6);
					request.setAttribute("listaPresencaChamada7", presenca7);
					request.setAttribute("listaPresencaChamada8", presenca8);
					request.setAttribute("listaPresencaChamada9", presenca9);
					request.setAttribute("listaPresencaChamada10", presenca10);
					request.setAttribute("listaPresencaChamada11", presenca11);
					request.setAttribute("listaPresencaChamada12", presenca12);
				}
			}			
			
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
			Date dt = new Date();
			try {
				dt = formatter.parse(dataChamada);
			} catch (ParseException e) {
				msgErro = "Erro ao converter data";
			}
			
			DiaTreinoNegocio diaTreinoNegocio = new DiaTreinoNegocio();
			List<DiaTreino> lista = new ArrayList<DiaTreino>();
			try {
				lista = diaTreinoNegocio.buscaDiasTreino(dt);
				for (DiaTreino diat : lista) {
					if(diat.getIdDiaTreino() == idDiaTreino){
						diat.setSelecionado(true);
					}
				}
			} catch (Exception ex) {
				msgErro = ex.getMessage();
			}
			
			request.setAttribute("dataAtual", dt);
			request.setAttribute("msgErro", msgErro);
			request.setAttribute("listaDiasTreinos", lista);
			retorno = String.format("%s/TecnicoChamadaQuadras.jsp", Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspChamadaQuadra";
			
		}else if("jspChamada".equals(action)){
			DiaTreinoNegocio negocio = new DiaTreinoNegocio();
			List<DiaTreino> lista = new ArrayList<DiaTreino>();
			try {
				lista = negocio.buscaDiasTreino(new Date());
			} catch (Exception ex) {
				request.setAttribute("msgErro", ex.getMessage());
			}

			request.setAttribute("dataAtual", new Date());
			request.setAttribute("listaDiasTreinos", lista);
			retorno = String.format("%s/TecnicoChamada.jsp", Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspChamada";

		}else if("CarregarChamadaPresenca".equals(action)){
			String msgErro = "";
			String diaTreino = request.getParameter("diaTreino");
			String diaChamada = request.getParameter("diaChamada");
			int idDiaTreino = Integer.parseInt(diaTreino);
			
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
			Date dt = new Date();
			try {
				dt = formatter.parse(diaChamada);
			} catch (ParseException e) {
				dt = new Date();
			}
			
			List<Atleta> lista = new ArrayList<Atleta>();
			if(!"".equals(diaTreino) && !"0".equals(diaTreino) && !"".equals(diaChamada)){
				PresencaChamadaNegocio negocio = new PresencaChamadaNegocio();				
				try{
					lista = negocio.buscarPresencasPorData(dt, idDiaTreino);
				}catch(Exception e){
					msgErro = e.getMessage();
				}
			}
			
			DiaTreinoNegocio diaTreinoNegocio = new DiaTreinoNegocio();
			List<DiaTreino> listaDiaTreino = new ArrayList<DiaTreino>();
			try {
				listaDiaTreino = diaTreinoNegocio.buscaDiasTreino(dt);
				for (DiaTreino diat : listaDiaTreino) {
					if(diat.getIdDiaTreino() == idDiaTreino){
						diat.setSelecionado(true);
					}
				}
			} catch (Exception ex) {
				msgErro = ex.getMessage();
			}
			
			request.setAttribute("listaDiasTreinos", listaDiaTreino);
			request.setAttribute("dataAtual", dt);
			request.setAttribute("msgErro", msgErro);
			request.setAttribute("listaAtletas", lista);
			retorno = String.format("%s/TecnicoChamada.jsp", Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspChamada";
			
		}else if("editarChamada".equals(action)){
			String msgErro = "";
			String msgSucesso = "";
			boolean exception = false;
			String presencaChamada = request.getParameter("idPresencaJutificativa");
			String estado = request.getParameter("optradio");
			String tpPresenca = request.getParameter("tipoChamada");
			String justificativa = request.getParameter("txtJustificativa");
			String diaChamada = request.getParameter("dtChamada");
			String diaTreino = request.getParameter("idDiaTreino");
			String atleta = request.getParameter("idAtleta");
			int idPresencaChamada = 0;
			int estadoPresenca = 0;
			
			try{
				estadoPresenca = Integer.parseInt(estado);
			}catch(Exception ex){
				msgErro = "Ocorreu algum erro no sistema!";
				exception = true;
			}	
			Date dt = new Date();
			int idDiaTreino = 0;
			
			if(!exception){
				PresencaChamadaNegocio negocio = new PresencaChamadaNegocio();
				ChamadaNegocio chamadaNegocio = new ChamadaNegocio();
				PresencaChamada presenca = new PresencaChamada();
				try{
					DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
					dt = formatter.parse(diaChamada);
					
					int idAtleta = Integer.parseInt(atleta);
					idDiaTreino = Integer.parseInt(diaTreino);
					
					presenca.setIdAtleta(idAtleta);
					if("T".equals(tpPresenca)){
						presenca.setEstadoPresencaT(estadoPresenca);
						presenca.setJustificativaT(justificativa);
					}else{
						presenca.setEstadoPresencaF(estadoPresenca);
						presenca.setJustificativaF(justificativa);
					}
					
					List<Object> listaValidacao = negocio.validaDados(presenca, tpPresenca);
					boolean valida = (boolean) listaValidacao.get(0);
					if (!valida) {
						msgErro = (String) listaValidacao.get(1);
					}else{						
						if("".equals(presencaChamada)){
							Chamada chamada = chamadaNegocio.buscarChamadaPorDia(diaChamada, idDiaTreino);
							if(chamada.getIdChamada() == 0){
								
								chamada = new Chamada(usuarioLogado.getIdPessoa(), idDiaTreino, dt);
								chamada = chamadaNegocio.salvarChamada(chamada);
							}
							
							presenca.setIdChamada(chamada.getIdChamada());
							if(negocio.salvarPresencaChamada(presenca, tpPresenca)){
								msgSucesso = "Presen�a salva com sucesso!";
							}
						}else{
							idPresencaChamada = Integer.parseInt(presencaChamada);
							presenca.setIdPresencaChamada(idPresencaChamada);
							presenca.setNrQuadra(0);
							if(negocio.alterarPresencaChamada(presenca, tpPresenca))
								msgSucesso = "Presen�a salva com sucesso!";
						}
					}
				}catch(Exception ex){
					msgErro = ex.getMessage();
				}
			}
			
			DiaTreinoNegocio diaTreinoNegocio = new DiaTreinoNegocio();
			List<DiaTreino> listaDiaTreino = new ArrayList<DiaTreino>();
			try {
				listaDiaTreino = diaTreinoNegocio.buscaDiasTreino(dt);
				for (DiaTreino diat : listaDiaTreino) {
					if(diat.getIdDiaTreino() == idDiaTreino){
						diat.setSelecionado(true);
					}
				}
			} catch (Exception ex) {
				msgErro = ex.getMessage();
			}
			List<Atleta> lista = new ArrayList<Atleta>();
			if(!"".equals(diaTreino) && !"0".equals(diaTreino) && !"".equals(diaChamada)){
				PresencaChamadaNegocio negocio = new PresencaChamadaNegocio();				
				try{
					lista = negocio.buscarPresencasPorData(dt, idDiaTreino);
				}catch(Exception e){
					msgErro = e.getMessage();
				}
			}
			
			request.setAttribute("listaDiasTreinos", listaDiaTreino);
			request.setAttribute("dataAtual", dt);
			request.setAttribute("msgErro", msgErro);
			request.setAttribute("listaAtletas", lista);
			request.setAttribute("msgSucesso", msgSucesso);
			retorno = String.format("%s/TecnicoChamada.jsp", Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspChamada";
					
		} else if ("jspResulTorneio".equals(action)) {
			TorneioNegocio negocio = new TorneioNegocio();
			List<Torneio> lista = new ArrayList<Torneio>();
			
			try {
				lista = negocio.buscaTorneiosFinalizados();
				if (lista.isEmpty()) {
					request.setAttribute("msgAlerta", "Nenhum resultado de torneio finalizado dispon�vel!");
				} else {
					request.setAttribute("listaTorneios", lista);
				}
			} catch (Exception ex) {
				request.setAttribute("msgErro", ex.getMessage());
			}
			retorno = String.format("%s/RelatorioResultTorneio.jsp", Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspResulTorneio";
			
		} else if("jspRelatorioTreinos".equals(action)){
			
			request.setAttribute("dataAtual", new Date());
			retorno = String.format("%s/RelatorioTreino.jsp", Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspRelatorioTreinos";
			
		}else if("jspRelatorioConsultaMedica".equals(action)){			
			request.setAttribute("dataAtual", new Date());
			retorno = String.format("%s/RelatorioConsultaMedica.jsp", Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspRelatorioConsultaMedica";
			
		} else if("jspFrequenciaTorneio".equals(action)){
			
			request.setAttribute("dataAtual", new Date());
			retorno = String.format("%s/RelatorioFreqTorneio.jsp", Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspFrequenciaTorneio";
			
		}else if("jspAtletaBonificacao".equals(action)){			
			Date date = new Date();
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(date);
		    int ano = cal.get(Calendar.YEAR);
			MesNegocio mesNegocio = new MesNegocio();
			List<Mes> listaMes = mesNegocio.listarMes();
											
			request.setAttribute("listaMes", listaMes);
			request.setAttribute("ano", ano);
			retorno = String.format("%s/TecnicoAtletaBonificacao.jsp", Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspAtletaBonificacao";
			
		}else if("carregarAtletasBonificacao".equals(action)){			
			
			int ano = Integer.parseInt(request.getParameter("ano"));
			int mes = Integer.parseInt(request.getParameter("mes"));
			
			MesNegocio mesNegocio = new MesNegocio();
			List<Mes> listaMes = mesNegocio.listarMes();
			
			AtletaNegocio atletaNegocio = new AtletaNegocio();
			List<Atleta> listaAtletas = new ArrayList<Atleta>();
			
			if(mes != 0){
				try{
					listaAtletas = atletaNegocio.buscarAtletaBonificacao(mes, ano);
				}catch(Exception ex){
					request.setAttribute("msgErro", ex.getMessage());
				}
			}else{
				request.setAttribute("msgErro", "O m�s deve ser selecionado!");
			}
						
			request.setAttribute("listaMes", listaMes);
			request.setAttribute("listaAtletas", listaAtletas);
			request.setAttribute("mesSelecionado", mes);
			request.setAttribute("ano", ano);
			retorno = String.format("%s/TecnicoAtletaBonificacao.jsp", Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspAtletaBonificacao";
			
		}else if("salvarBonificacaoAtleta".equals(action)){
			String msgErro = "";
			boolean exception = false;
			String idAtleta = request.getParameter("idAtleta");
			String mes = request.getParameter("mesBonificacao");
			Integer nrMes = null;
			int nrAno = 0;
			String ano = request.getParameter("anoBonificacao");
			String torneios = request.getParameter("torneios");
			String treinos = request.getParameter("treinos");
			String avaliacoes = request.getParameter("avaliacoes");
			String cbt = request.getParameter("rankCBT");
			String fpt = request.getParameter("rankFPT");
			String itf = request.getParameter("rankITF");
			String observacoes = request.getParameter("observacoes");
			String bonificado = request.getParameter("optBonificado");
			String avaliacaoDesempenho = request.getParameter("idAvaliacaoDesempenho");
			
			AvaliacaoDesempenho bonificacao = new AvaliacaoDesempenho();
			AtletaNegocio negocio = new AtletaNegocio();
			try{
				Atleta atleta = new Atleta();
				atleta.setIdPessoa(Integer.parseInt(idAtleta));
				bonificacao.setAtleta(atleta);
			}catch(Exception ex){
				msgErro = "Ocorreu algum erro ao identificar o atleta!";
				exception = true;
			}
			try{	
				bonificacao.setMes(Integer.parseInt(mes));
				nrMes = Integer.parseInt(mes);
			}catch(Exception ex){
				msgErro = "O m�s deve ser selecionado previamente!";
				exception = true;
			}
			try{
				bonificacao.setAno(Integer.parseInt(ano));
				nrAno = Integer.parseInt(ano);
			}catch(Exception ex){
				msgErro = "O ano deve ser selecionado previamente!";
				exception = true;
			}
			if(!"".equals(cbt)){
				try{
					bonificacao.setRankCBT(Integer.parseInt(cbt));
				}catch(Exception ex){
					msgErro = "Erro ao identificar ranking CBT!";
					exception = true;
				}
			}
			if(!"".equals(fpt)){
				try{
					bonificacao.setRankFPT(Integer.parseInt(fpt));
				}catch(Exception ex){
					msgErro = "Erro ao identificar ranking FPT!";
					exception = true;
				}
			}
			if(!"".equals(itf)){
				try{
					bonificacao.setRankITF(Integer.parseInt(itf));
				}catch(Exception ex){
					msgErro = "Erro ao identificar rank ITF!";
					exception = true;
				}
			}
			if(!exception){
				bonificacao.setObservacoes(observacoes);
				if("on".equals(avaliacoes)){
					bonificacao.setAvaliacoes(true);
				}else{
					bonificacao.setAvaliacoes(false);
				}
				if("on".equals(treinos)){
					bonificacao.setTreinos(true);
				}else{
					bonificacao.setTreinos(false);
				}
				if("on".equals(torneios)){
					bonificacao.setTorneios(true);
				}else{
					bonificacao.setTorneios(false);
				}
				if("1".equals(bonificado)){
					bonificacao.setBonificado(true);
				}else{
					bonificacao.setBonificado(false);
				}
				bonificacao.setUsuario(usuarioLogado);
				
				try{
					if("".equals(avaliacaoDesempenho)){
						if(negocio.salvarBonificacaoAtleta(bonificacao)){
							request.setAttribute("msgSucesso", "Bonifica��o cadastrada com sucesso!");
						}
					}else{
						int idBonificacao = Integer.parseInt(avaliacaoDesempenho);
						bonificacao.setIdAvaliacaoDesempenho(idBonificacao);
						if(negocio.editarBonificacaoAtleta(bonificacao)){
							request.setAttribute("msgSucesso", "Bonifica��o editada com sucesso!");
						}
					}
				}catch(Exception ex){
					msgErro = ex.getMessage();
				}
			}
			
			MesNegocio mesNegocio = new MesNegocio();
			List<Mes> listaMes = mesNegocio.listarMes();
			
			List<Atleta> listaAtletas = new ArrayList<Atleta>();
			
			try{
				if(nrAno == 0){
					Date date = new Date();
				    Calendar cal = Calendar.getInstance();
				    cal.setTime(date);
				    nrAno = cal.get(Calendar.YEAR);
				}
				listaAtletas = negocio.buscarAtletaBonificacao(nrMes, nrAno);
			}catch(Exception ex){
				msgErro = ex.getMessage();
			}
						
			request.setAttribute("listaMes", listaMes);
			request.setAttribute("listaAtletas", listaAtletas);
			request.setAttribute("ano", nrAno);
			request.setAttribute("mesSelecionado", nrMes);
			request.setAttribute("msgErro", msgErro);
			retorno = String.format("%s/TecnicoAtletaBonificacao.jsp", Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspAtletaBonificacao";
			
		} else if("jspRelatorioBonificacao".equals(action)){
			
			Date date = new Date();
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(date);
		    int ano = cal.get(Calendar.YEAR);
		    MesNegocio mesNegocio = new MesNegocio();
			List<Mes> listaMes = mesNegocio.listarMes();
			AtletaNegocio negocio = new AtletaNegocio();
			List<Atleta> listaAtleta = new ArrayList<Atleta>();
			try{
				listaAtleta = negocio.buscarAtletas(1);
			}catch(Exception ex){
				request.setAttribute("msgErro", ex.getMessage());
			}
											
			request.setAttribute("listaAtleta", listaAtleta);					
			request.setAttribute("listaMes", listaMes);
			request.setAttribute("ano", ano);
			
			retorno = String.format("%s/RelatorioBonificacao.jsp", Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspRelatorioBonificacao";
			
		} else if ("jspRelatorioDesempenhoAva".equals(action)) {
			AtletaNegocio negocio = new AtletaNegocio();
			List<Atleta> listaAtleta = new ArrayList<Atleta>();
			try{
				listaAtleta = negocio.buscarAtletas(1);
			}catch(Exception ex){
				request.setAttribute("msgErro", ex.getMessage());
			}
				
			request.setAttribute("dataAtual", new Date());
			request.setAttribute("listaAtleta", listaAtleta);					
			
			retorno = String.format("%s/RelatorioDesempenhoAvalFis.jsp", Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspRelatorioDesempenhoAva";
		} else{
			//Página Principal
			AvaliacaoFisicaNegocio negocio = new AvaliacaoFisicaNegocio();
			
			try{
				List<AvaliacaoFisica> listaAvaliacao = negocio.buscaAvaliacoes();
				if(!listaAvaliacao.isEmpty()){
					request.setAttribute("listaAvaliacao", listaAvaliacao);
				}else{
					request.setAttribute("msgAlerta", "Nenhuma avalia��o f�sica registrada.");
				}
			}catch(Exception ex){
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			retorno = String.format("%s/TecnicoPrincipal.jsp", Constants.VIEW);
		}
		
		if(retorno != null){
			session.setAttribute("pagina", servletRetorno);
			rd = getServletContext().getRequestDispatcher(retorno);
			rd.forward(request, response);
		}
	}

}
