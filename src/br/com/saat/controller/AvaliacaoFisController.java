package br.com.saat.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.saat.core.Constants;
import br.com.saat.enumeradores.Perfis;
import br.com.saat.enumeradores.Sexo;
import br.com.saat.enumeradores.TipoCat;
import br.com.saat.enumeradores.UnidadeDeMedida;
import br.com.saat.model.AtividadeAvaliacao;
import br.com.saat.model.Atleta;
import br.com.saat.model.AvaliacaoFisica;
import br.com.saat.model.AvaliacaoResultado;
import br.com.saat.model.CategoriaAtividade;
import br.com.saat.model.CategoriaAvaliacao;
import br.com.saat.model.Usuario;
import br.com.saat.model.negocio.AtividadeAvaliacaoNegocio;
import br.com.saat.model.negocio.AtletaNegocio;
import br.com.saat.model.negocio.AvaliacaoFisicaNegocio;
import br.com.saat.model.negocio.AvaliacaoResultadoNegocio;
import br.com.saat.model.negocio.CategoriaAtividadeNegocio;
import br.com.saat.model.negocio.CategoriaAvaliacaoNegocio;
import br.com.saat.model.negocio.ObservacaoNegocio;
import br.com.saat.model.negocio.SexoNegocio;
import br.com.saat.model.negocio.TipoCatNegocio;
import br.com.saat.model.negocio.TpCaracteristicaNegocio;
import br.com.saat.model.negocio.UnidadeDeMedidaNegocio;

import com.google.gson.Gson;

/**
 * Servlet implementation class AvaliacaoController
 */
@WebServlet("/AvaliacaoFisController")
public class AvaliacaoFisController extends Controller {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see Controller#Controller()
     */
    public AvaliacaoFisController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		String servletRetorno = "/TecnicoController";
		
		//Verifica autenticação usuário
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
		
		if ("jspAtividade".equals(action)) {
			AtividadeAvaliacaoNegocio negocio = new AtividadeAvaliacaoNegocio();
			List<AtividadeAvaliacao> lista = new ArrayList<AtividadeAvaliacao>();
			try{
				lista = negocio.buscarAtividades(0, 0);
				if (lista.isEmpty()) {
					request.setAttribute("msgAlerta", "Nenhuma atividade de avaliação física cadastrada!");
				}
			}catch(Exception ex){
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			UnidadeDeMedidaNegocio unidadeNegocio = new UnidadeDeMedidaNegocio();
			List<UnidadeDeMedida> listaUnidades = unidadeNegocio.listaUnidadeDeMedida();
			
			request.setAttribute("listaUnidades", listaUnidades);
			request.setAttribute("listaAtividades", lista);
			retorno = String.format("%s/TecnicoBuscaAtividade.jsp", Constants.VIEW);
			servletRetorno = "/AvaliacaoFisController?action=jspAtividade";
			
		} else if ("novaAtividade".equals(action)) {
			boolean exception = false;
			int idUnidade = 0;
			
			AtividadeAvaliacao atividade = new AtividadeAvaliacao();
			AtividadeAvaliacaoNegocio negocio = new AtividadeAvaliacaoNegocio();
			List<AtividadeAvaliacao> lista = new ArrayList<AtividadeAvaliacao>();

			try {
				idUnidade = Integer.parseInt(request.getParameter("unidade"));
			} catch (Exception ex) {
				request.setAttribute("msgErro", "Favor selecionar corretamente a 'Unidade de medida'!");
				exception = true;
			}

			if (!exception) {
				atividade.setCapacidade(request.getParameter("capacidade"));
				atividade.setTeste(request.getParameter("teste"));
				atividade.setIdUnidadeDeMedida(idUnidade);
					
				List<Object> listaValidacao = negocio.validaDados(atividade);
				boolean valida = (boolean) listaValidacao.get(0);
				if (!valida) {
					request.setAttribute("msgErro", (String) listaValidacao.get(1));
				} else {
					try {
						if (negocio.inserir(atividade)) {
							request.setAttribute("msgSucesso", "Atividade salva com sucesso!");
						} else {
							request.setAttribute("msgErro", "Ocorreu algum erro no sistema! Favor tentar novamente.");
						}
					} catch (Exception ex) {
						request.setAttribute("msgErro", ex.getMessage());
					}
				}
			}

			try{
				lista = negocio.buscarAtividades(0, 0);
				if (lista.isEmpty()) {
					request.setAttribute("msgAlerta", "Nenhuma atividade de avaliação física cadastrada!");
				}
			}catch(Exception ex){
				request.setAttribute("msgAlerta", ex.getMessage());
			}
			
			UnidadeDeMedidaNegocio unidadeNegocio = new UnidadeDeMedidaNegocio();
			List<UnidadeDeMedida> listaUnidades = unidadeNegocio.listaUnidadeDeMedida();
			
			request.setAttribute("listaUnidades", listaUnidades);
			request.setAttribute("listaAtividades", lista);
			retorno = String.format("%s/TecnicoBuscaAtividade.jsp", Constants.VIEW);
			servletRetorno = "/AvaliacaoFisController?action=jspAtividade";
			
		} else if ("desativarAtividade".equals(action)) {
			
			AtividadeAvaliacao atividade = new AtividadeAvaliacao();
			AtividadeAvaliacaoNegocio negocio = new AtividadeAvaliacaoNegocio();
			List<AtividadeAvaliacao> lista = new ArrayList<AtividadeAvaliacao>();
			
			try {
				atividade.setIdAtividadeAvaliacao(Integer.parseInt(request.getParameter("idAtividade")));
				if (negocio.desativar(atividade)) {
					request.setAttribute("msgSucesso", "Atividade excluída com sucesso!");
				} else {
					request.setAttribute("msgErro", "Ocorreu algum erro no sistema! Favor tentar novamente.");
				}
			} catch (Exception ex) {
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			try{
				lista = negocio.buscarAtividades(0 ,0);
				if (lista.isEmpty()) {
					request.setAttribute("msgAlerta", "Nenhuma atividade de avaliação física cadastrada!");
				}
			}catch(Exception ex){
				request.setAttribute("msgAlerta", ex.getMessage());
			}
			
			UnidadeDeMedidaNegocio unidadeNegocio = new UnidadeDeMedidaNegocio();
			List<UnidadeDeMedida> listaUnidades = unidadeNegocio.listaUnidadeDeMedida();
			
			request.setAttribute("listaUnidades", listaUnidades);
			request.setAttribute("listaAtividades", lista);
			retorno = String.format("%s/TecnicoBuscaAtividade.jsp", Constants.VIEW);
			servletRetorno = "/AvaliacaoFisController?action=jspAtividade";

		} else if ("jspCategoria".equals(action)) {
			CategoriaAvaliacaoNegocio negocio = new CategoriaAvaliacaoNegocio();
			List<CategoriaAvaliacao> lista = new ArrayList<CategoriaAvaliacao>();
			try{
				lista = negocio.buscarCategorias(0, 0);
				if (lista.isEmpty()) {
					request.setAttribute("msgAlerta", "Nenhuma categoria de avaliação física cadastrada!");
				}
			}catch(Exception ex){
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			TipoCatNegocio tipoCatNegocio = new TipoCatNegocio();
			List<TipoCat> listaTipo = tipoCatNegocio.listaTipoCat();
			
			SexoNegocio sexoNegocio = new SexoNegocio();
			List<Sexo> listaSexo = sexoNegocio.listaSexo();
			
			request.setAttribute("listaTipo", listaTipo);
			request.setAttribute("listaSexo", listaSexo);
			request.setAttribute("listaCategorias", lista);
			retorno = String.format("%s/TecnicoBuscaCategoria.jsp", Constants.VIEW);
			servletRetorno = "/AvaliacaoFisController?action=jspCategoria";
			
		} else if ("novaCategoria".equals(action)) {
			boolean exception = false;
			int idadeMin = 0;
			int idadeMax = 0;
			int sexo = 0;
			
			CategoriaAvaliacao categoria = new CategoriaAvaliacao();
			CategoriaAvaliacaoNegocio negocio = new CategoriaAvaliacaoNegocio();
			List<CategoriaAvaliacao> lista = new ArrayList<CategoriaAvaliacao>();
			List<Integer> tiposSelecionados = new ArrayList<Integer>();
			
			TipoCatNegocio tipoCatNegocio = new TipoCatNegocio();
			List<TipoCat> listaTipo = tipoCatNegocio.listaTipoCat();
			
			try {
				idadeMin = Integer.parseInt(request.getParameter("idadeMin"));
			} catch (Exception ex) {
				request.setAttribute("msgErro", "Favor informar corretamente o campo 'Idade mínima' !");
				exception = true;
			}
			
			try {
				idadeMax = Integer.parseInt(request.getParameter("idadeMax"));
			} catch (Exception ex) {
				request.setAttribute("msgErro", "Favor informar corretamente o campo 'Idade máxima' !");
				exception = true;
			}
			
			try {
				sexo = Integer.parseInt(request.getParameter("sexo"));
			} catch (Exception ex) {
				request.setAttribute("msgErro", "Favor selecionar corretamente o campo 'Sexo' !");
				exception = true;
			}

			if (!exception) {
				categoria.setNmCategoria(request.getParameter("nome"));
				categoria.setIdadeMinima(idadeMin);
				categoria.setIdadeMaxima(idadeMax);
				categoria.setSexo(sexo);
				
				boolean tipo;
				for (TipoCat tipoCat : listaTipo) {
					tipo = Boolean.parseBoolean(request.getParameter(String.valueOf(tipoCat.getValor())));
					if (tipo) {
						tiposSelecionados.add(tipoCat.getValor());
					}
				}
					
				List<Object> listaValidacao = negocio.validaDados(categoria, tiposSelecionados);
				boolean valida = (boolean) listaValidacao.get(0);
				if (!valida) {
					request.setAttribute("msgErro", (String) listaValidacao.get(1));
				} else {
					try {
						if (negocio.inserir(categoria, tiposSelecionados)) {
							request.setAttribute("msgSucesso", "Categoria salva com sucesso!");
						} else {
							request.setAttribute("msgErro", "Ocorreu algum erro no sistema! Favor tentar novamente.");
						}
					} catch (Exception ex) {
						request.setAttribute("msgErro", ex.getMessage());
					}
				}
			}

			try{
				lista = negocio.buscarCategorias(0, 0);
				if (lista.isEmpty()) {
					request.setAttribute("msgAlerta", "Nenhuma categoria de avaliação física cadastrada!");
				}
			}catch(Exception ex){
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			SexoNegocio sexoNegocio = new SexoNegocio();
			List<Sexo> listaSexo = sexoNegocio.listaSexo();
			
			request.setAttribute("listaTipo", listaTipo);
			request.setAttribute("listaSexo", listaSexo);
			request.setAttribute("listaCategorias", lista);
			retorno = String.format("%s/TecnicoBuscaCategoria.jsp", Constants.VIEW);
			servletRetorno = "/AvaliacaoFisController?action=jspCategoria";
			
		} else if ("desativarCategoria".equals(action)) {
			
			CategoriaAvaliacao categoria = new CategoriaAvaliacao();
			CategoriaAvaliacaoNegocio negocio = new CategoriaAvaliacaoNegocio();
			List<CategoriaAvaliacao> lista = new ArrayList<CategoriaAvaliacao>();
			
			try {
				categoria.setIdCategoriaAvaliacao(Integer.parseInt(request.getParameter("idCategoria")));
				if (negocio.desativar(categoria)) {
					request.setAttribute("msgSucesso", "Categoria excluída com sucesso!");
				} else {
					request.setAttribute("msgErro", "Ocorreu algum erro no sistema! Favor tentar novamente.");
				}
			} catch (Exception ex) {
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			try{
				lista = negocio.buscarCategorias(0, 0);
				if (lista.isEmpty()) {
					request.setAttribute("msgAlerta", "Nenhuma categoria de avaliação física cadastrada!");
				}
			}catch(Exception ex){
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			TipoCatNegocio tipoCatNegocio = new TipoCatNegocio();
			List<TipoCat> listaTipo = tipoCatNegocio.listaTipoCat();
			
			SexoNegocio sexoNegocio = new SexoNegocio();
			List<Sexo> listaSexo = sexoNegocio.listaSexo();
			
			request.setAttribute("listaTipo", listaTipo);
			request.setAttribute("listaSexo", listaSexo);
			request.setAttribute("listaCategorias", lista);
			retorno = String.format("%s/TecnicoBuscaCategoria.jsp", Constants.VIEW);
			servletRetorno = "/AvaliacaoFisController?action=jspCategoria";

		} else if ("jspDadosRef".equals(action)) {
			CategoriaAtividadeNegocio negocio = new CategoriaAtividadeNegocio();
			List<CategoriaAtividade> categoriasAtividades = null;
			
			try {
				categoriasAtividades = negocio.buscaCategoriasAtividades();
				if (categoriasAtividades.isEmpty()) {
					request.setAttribute("msgAlerta", "Nenhum dado de referência cadastrado!");
				}
			} catch (Exception e) {
				request.setAttribute("msgErro", e.getMessage());
			}
			
			request.setAttribute("categoriasAtividades", categoriasAtividades);
			retorno = String.format("%s/TecnicoBuscaDadosRef.jsp", Constants.VIEW);
			servletRetorno = "/AvaliacaoFisController?action=jspDadosRef";
			
		} else if ("jspNovoDadosRef".equals(action)) {
			CategoriaAvaliacaoNegocio negocioCat = new CategoriaAvaliacaoNegocio();
			AtividadeAvaliacaoNegocio negocioAti = new AtividadeAvaliacaoNegocio();

			List<CategoriaAvaliacao> listaCategorias = new ArrayList<CategoriaAvaliacao>();
			List<AtividadeAvaliacao> listaAtividades = new ArrayList<AtividadeAvaliacao>();
			
			try{
				listaCategorias = negocioCat.buscarCategorias(1, 0);
				if (listaCategorias.isEmpty()) {
					request.setAttribute("msgAlerta", "Nenhuma categoria de avaliação física cadastrada!");
				} else {
					try{
						listaAtividades = negocioAti.buscarAtividades(0, 0);
						if (listaAtividades.isEmpty()) {
							request.setAttribute("msgAlerta", "Nenhuma atividade de avaliação física cadastrada!");
						}
					}catch(Exception ex){
						request.setAttribute("msgErro", ex.getMessage());
					}
				}
			}catch(Exception ex){
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			request.setAttribute("listaCategorias", listaCategorias);
			request.setAttribute("listaAtividades", listaAtividades);
			request.setAttribute("tipoAcao", 1); //1 Novo
			retorno = String.format("%s/TecnicoNovoDadosRef.jsp", Constants.VIEW);
			servletRetorno = "/AvaliacaoFisController?action=jspNovoDadosRef";
			
		} else if ("inserirDadosRef".equals(action)) {
			boolean exception = false;
			boolean atividadeSelecionada;
			String msgSucesso = "";
			String msgErro ="";
			String msgAlerta = "";
			int idAtividade = 0;
			List<AtividadeAvaliacao> listaAtividades = new ArrayList<AtividadeAvaliacao>();
			List<CategoriaAtividade> categoriaAtividades = new ArrayList<CategoriaAtividade>();
			List<CategoriaAtividade> categoriasAtividades = null;
			
			AtividadeAvaliacaoNegocio negocioAti = new AtividadeAvaliacaoNegocio();
			CategoriaAtividadeNegocio negocio = new CategoriaAtividadeNegocio();
			
			//Busca atividades para poder buscar as selecionadas
			try{
				listaAtividades = negocioAti.buscarAtividades(0, 0);
				if (listaAtividades.isEmpty()) {
					msgAlerta = "Nenhuma atividade de avaliação física cadastrada!";
					exception = true;
				}
			}catch(Exception ex){
				exception = true;
				msgErro = ex.getMessage();
			}
			
			//Se não ocorreu nenhum erro, continua
			if (!exception) {
				//TipoAcao
				String tipoAcao = request.getParameter("tipoAcao");
				
				//Busca categorias selecionadas
				String[] categoriasSelecionadas = request.getParameterValues("categoria");
				
				//Preencher valores de atividades selecionadas
				for (AtividadeAvaliacao atividade : listaAtividades) {
					idAtividade = atividade.getIdAtividadeAvaliacao();
					atividadeSelecionada = Boolean.parseBoolean(request.getParameter(String.valueOf(idAtividade)));
					if (atividadeSelecionada) {
						CategoriaAtividade catAtiv = new CategoriaAtividade();
						AtividadeAvaliacao ativAva = new AtividadeAvaliacao();
						
						//ID Atividade
						ativAva.setIdAtividadeAvaliacao(idAtividade);
						catAtiv.setAtividadeAvaliacao(ativAva);
						
						//Melhorar
						try {
							catAtiv.setMelhorar(Float.parseFloat(request.getParameter("melhorar" + idAtividade)));
						} catch (Exception e) {
							catAtiv.setMelhorar(0);
						}
						
						//MÃ©dia
						try {
							catAtiv.setMedia(Float.parseFloat(request.getParameter("media" + idAtividade)));
						} catch (Exception e) {
							catAtiv.setMedia(0);
						}
						
						//Bom
						try {
							catAtiv.setBom(Float.parseFloat(request.getParameter("bom" + idAtividade)));
						} catch (Exception e) {
							catAtiv.setBom(0);
						}
						
						//Excelente
						try {
							catAtiv.setExcelente(Float.parseFloat(request.getParameter("excelente" + idAtividade)));
						} catch (Exception e) {
							catAtiv.setExcelente(0);
						}
						
						//Adiciona na lista
						categoriaAtividades.add(catAtiv);
					}
				}
				
				//Validar
				List<Object> listaValidacao = negocio.validaDados(categoriaAtividades, categoriasSelecionadas);
				boolean valida = (boolean) listaValidacao.get(0);
				
				//ERRO
				if (!valida) {
					msgErro = (String) listaValidacao.get(1);
				} 
				//INSERIR
				else {
					try {
						if ("1".equals(tipoAcao)) {
							if (negocio.inserir(categoriaAtividades, categoriasSelecionadas)) {
								msgSucesso = "Dados de referência salvos com sucesso!";
							} else {
								msgErro = "Ocorreu algum erro no sistema! Favor tentar novamente.";
							}
						} else {
							if (negocio.editar(categoriaAtividades, categoriasSelecionadas)) {
								msgSucesso = "Dados de referência salvos com sucesso!";
							} else {
								msgErro = "Ocorreu algum erro no sistema! Favor tentar novamente.";
							}
						}
					} catch (Exception ex) {
						msgErro =  ex.getMessage();
					}
				}
			}
			
			// SUCESSO
			if (!"".equals(msgSucesso)) {
				request.setAttribute("msgSucesso", msgSucesso);
			}
			// ERRO
			else {
				request.setAttribute("msgErro", msgErro);
			}
			
			try {
				categoriasAtividades = negocio.buscaCategoriasAtividades();
			} catch (Exception e) {
				msgAlerta = msgAlerta + "<br/>Nenhum dado de referência cadastrado!";
			}

			request.setAttribute("msgAlerta", msgAlerta);
			
			request.setAttribute("categoriasAtividades", categoriasAtividades);
			retorno = String.format("%s/TecnicoBuscaDadosRef.jsp", Constants.VIEW);
			servletRetorno = "/AvaliacaoFisController?action=jspDadosRef";
			
		} else if ("desativarDadoRef".equals(action)) {
			String msgSucesso = "";
			String msgErro ="";
			String msgAlerta = "";
			CategoriaAtividade catAtiv = new CategoriaAtividade();
			CategoriaAvaliacao categoria = new CategoriaAvaliacao();
			CategoriaAtividadeNegocio negocio = new CategoriaAtividadeNegocio();
			
			try {
				categoria.setIdCategoriaAvaliacao(Integer.parseInt(request.getParameter("idCategoriaAvaliacao")));
				catAtiv.setCategoriaAvaliacao(categoria);
				if (negocio.desativar(catAtiv)) {
					msgSucesso ="Dados de referência excluídos com sucesso!";
				} else {
					msgErro = "Ocorreu algum erro no sistema! Favor tentar novamente.";
				}
			} catch (Exception e) {
				msgErro = "Ocorreu algum erro no sistema! Favor tentar novamente.";
			}
			
			// SUCESSO
			if (!"".equals(msgSucesso)) {
				request.setAttribute("msgSucesso", msgSucesso);
			}
			// ERRO
			else {
				request.setAttribute("msgErro", msgErro);
			}
			request.setAttribute("msgAlerta", msgAlerta);
			
			List<CategoriaAtividade> categoriasAtividades = null;
			
			try {
				categoriasAtividades = negocio.buscaCategoriasAtividades();
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("categoriasAtividades", categoriasAtividades);
			retorno = String.format("%s/TecnicoBuscaDadosRef.jsp", Constants.VIEW);
			servletRetorno = "/AvaliacaoFisController?action=jspDadosRef";
			
		} else if ("jspMaisDadosRef".equals(action)) {
			CategoriaAvaliacaoNegocio negocioCat = new CategoriaAvaliacaoNegocio();
			AtividadeAvaliacaoNegocio negocioAti = new AtividadeAvaliacaoNegocio();

			List<CategoriaAvaliacao> listaCategorias = new ArrayList<CategoriaAvaliacao>();
			List<AtividadeAvaliacao> listaAtividades = new ArrayList<AtividadeAvaliacao>();
			
			int idCategoria = 0;
			try{
				idCategoria = Integer.parseInt(request.getParameter("idCategoriaAvaliacao"));
				
				listaCategorias = negocioCat.buscarCategorias(2, idCategoria);
				if (listaCategorias.isEmpty()) {
					request.setAttribute("msgAlerta", "Categoria de avaliação não localizada!");
				} else {
					try{
						listaAtividades = negocioAti.buscarAtividades(1, idCategoria);
						if (listaAtividades.isEmpty()) {
							request.setAttribute("msgAlerta", "Todas as atividades de avaliação física cadastradas já estão vinculadas a essa categoria!");
						}
					}catch(Exception ex){
						request.setAttribute("msgErro", ex.getMessage());
					}
				}
			}catch(Exception ex){
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			request.setAttribute("listaCategorias", listaCategorias);
			request.setAttribute("listaAtividades", listaAtividades);
			request.setAttribute("tipoAcao", 1); //1 Novo
			retorno = String.format("%s/TecnicoNovoDadosRef.jsp", Constants.VIEW);
			servletRetorno = "/AvaliacaoFisController?action=jspMaisDadosRef";
			
		} else if ("buscarDadoRef".equals(action)) {
		
			CategoriaAvaliacaoNegocio negocioCat = new CategoriaAvaliacaoNegocio();
			CategoriaAtividadeNegocio catAtivNegocio = new CategoriaAtividadeNegocio();

			CategoriaAvaliacao categoria = new CategoriaAvaliacao();
			List<CategoriaAtividade> listaCatAtiv = new ArrayList<CategoriaAtividade>();
			
			try{
				categoria.setIdCategoriaAvaliacao(Integer.parseInt(request.getParameter("idCategoria")));
				
				categoria = negocioCat.buscarCategoria(categoria);
				listaCatAtiv = catAtivNegocio.buscarAtividades(categoria);
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			SexoNegocio sexoNegocio = new SexoNegocio();
			List<Sexo> listaSexo = sexoNegocio.listaSexo();
			
			UnidadeDeMedidaNegocio unidadeNegocio = new UnidadeDeMedidaNegocio();
			List<UnidadeDeMedida> listaUnidades = unidadeNegocio.listaUnidadeDeMedida();
			
			Map<String, Object> lista = new LinkedHashMap<String, Object>();
			lista.put("categoria", categoria);
			lista.put("listaSexo", listaSexo);
			lista.put("listaUnidades", listaUnidades);
			lista.put("listaCatAtiv", listaCatAtiv);
		
			String json = new Gson().toJson(lista);
		
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			
		} else if ("editarDadoRef".equals(action)) {
			CategoriaAvaliacaoNegocio negocioCat = new CategoriaAvaliacaoNegocio();
			CategoriaAtividadeNegocio negocioAti = new CategoriaAtividadeNegocio();

			List<CategoriaAvaliacao> listaCategorias = new ArrayList<CategoriaAvaliacao>();
			List<CategoriaAtividade> listaAtividades = new ArrayList<CategoriaAtividade>();
			
			int idCategoria = 0;
			try{
				idCategoria = Integer.parseInt(request.getParameter("idCategoriaAvaliacao"));
				
				listaCategorias = negocioCat.buscarCategorias(2, idCategoria);
				if (listaCategorias.isEmpty()) {
					request.setAttribute("msgAlerta", "Categoria de avaliação não localizada!");
				} else {
					try{
						listaAtividades = negocioAti.buscarAtividadesCat(idCategoria);
					}catch(Exception ex){
						request.setAttribute("msgErro", ex.getMessage());
					}
				}
			}catch(Exception ex){
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			request.setAttribute("listaCategorias", listaCategorias);
			request.setAttribute("listaAtividades", listaAtividades);
			request.setAttribute("tipoAcao", 2); //2 Editar
			retorno = String.format("%s/TecnicoNovoDadosRef.jsp", Constants.VIEW);
			servletRetorno = "/AvaliacaoFisController?action=jspNovoDadosRef";
			
		} else if ("jspNovaAvaliacao".equals(action)) {
			int idAtleta = Integer.parseInt(request.getParameter("idAtleta"));
			
			AvaliacaoResultadoNegocio avaResulNegocio = new AvaliacaoResultadoNegocio();
			List<AvaliacaoResultado> listaAvaResul = new ArrayList<AvaliacaoResultado>();
			
			try {
				listaAvaResul = avaResulNegocio.buscarAtividades(idAtleta);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			TpCaracteristicaNegocio caractNegocio = new TpCaracteristicaNegocio();
			List<String> tpCaracteristica = caractNegocio.listaTpCaracteristicaString();
			
			UnidadeDeMedidaNegocio unidadeNegocio = new UnidadeDeMedidaNegocio();
			List<String> listaUnidades = unidadeNegocio.listaUnidadeDeMedidaString();
			
			Map<String, Object> lista = new LinkedHashMap<String, Object>();
			lista.put("tpCaracteristica", tpCaracteristica);
			lista.put("listaUnidades", listaUnidades);
			lista.put("listaAvaResul", listaAvaResul);
			lista.put("idAvaliacaoFisica", 0);
			
			String json = new Gson().toJson(lista);

		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
			
		} else if ("novaAvaliacao".equals(action)) {
			int idAtleta = 0;
			String idCategoriaAtividade = "";
			int idCaracteristica = 0 ;
			int idAvaliacaoFisica = 0;
			float desempenho = 0;
			boolean exception = false;
			String msgErro = "";
			String msgSucesso = "";
			String msgAlerta = "";
			String dataAva = "";
			Date dtAvaliacao = null;
			
			Atleta atleta = new Atleta();
			AvaliacaoFisica avalFis = new AvaliacaoFisica();
			AvaliacaoResultadoNegocio avaResulNegocio = new AvaliacaoResultadoNegocio();
			List<AvaliacaoResultado> listaAvaResul = new ArrayList<AvaliacaoResultado>();
			List<AvaliacaoResultado> avaliacaoResul = new ArrayList<AvaliacaoResultado>();
			
			try {
				idAvaliacaoFisica = Integer.parseInt(request.getParameter("idAvaliacaoFisica"));
			} catch (Exception ex) {
				msgErro = "Ocorreu algum erro no sistema! Favor tentar novamente.";
				exception = true;
			}
			
			try {
				idCaracteristica = Integer.parseInt(request.getParameter("caracteristica"));
			} catch (Exception ex) {
				msgErro = "Favor selecionar corretamente o campo 'Característica'.";
				exception = true;
			}
			
			try {
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				dataAva = request.getParameter("dtAvaliacao");
				dtAvaliacao = (Date) formatter.parse(dataAva);
			} catch (Exception ex) {
				msgErro = "Favor verificar se o campo 'Data' foi corretamente informado.";
				exception = true;
			}
			
			try {
				idAtleta = Integer.parseInt(request.getParameter("idAtleta"));
				
				listaAvaResul = avaResulNegocio.buscarAtividades(idAtleta);
			} catch (Exception ex) {
				msgErro = "Ocorreu algum erro no sistema! Favor tentar novamente.";
				exception = true;
			}
			
			if (!exception) {
				//Percorrer lista de atividade possiveis, validando qual foi preenchida o desempenho
				for (AvaliacaoResultado avaResult : listaAvaResul) {
					idCategoriaAtividade = request.getParameter("desempenho" + avaResult.getCategoriaAtividade().getIdCategoriaAtividade());
					if (!"".equals(idCategoriaAtividade) && idCategoriaAtividade != null) {
						desempenho = Float.parseFloat(idCategoriaAtividade);
						avaResult.setDesempenho(desempenho);
						avaliacaoResul.add(avaResult);
					}
				}
				
				if (!avaliacaoResul.isEmpty()) {
					
					atleta.setIdPessoa(idAtleta);
					
					avalFis.setAtleta(atleta);
					avalFis.setIdUsuResp(usuarioLogado.getIdPessoa());
					avalFis.setIdTpCaracteristica(idCaracteristica);
					avalFis.setDtAvaliacao(dtAvaliacao);
					avalFis.setObservacaoGeral(request.getParameter("observacaoGeral"));
					
					try {
						if (idAvaliacaoFisica == 0) {
							//Inserir
							idAvaliacaoFisica = avaResulNegocio.inserirResultado(avaliacaoResul, avalFis);
							if (idAvaliacaoFisica > 0) {
								msgSucesso = "Avaliação física inserida com sucesso!";
							} else {
								msgErro = "Ocorreu algum erro ao inserir a avaliação física! Favor tentar novamente.";
							}
						} else{
							//Alterar
							avalFis.setIdAvaliacaoFisica(idAvaliacaoFisica);
							if (avaResulNegocio.editar(avaliacaoResul, avalFis)) {
								msgSucesso = "Avaliação física editada com sucesso!";
							} else {
								msgErro = "Ocorreu algum erro ao editar a avaliação física! Favor tentar novamente.";
							}
						}
						
						//Buscar resultado
						if (!"".equals("msgSucesso")) {
							List<AvaliacaoResultado> resulDesempenho = avaResulNegocio.buscarResulDesempenho(idAvaliacaoFisica);
							if (resulDesempenho.size() <= 0 || resulDesempenho == null) {
								msgAlerta = "Falha ao buscar resultado(s) do(s) desempenho(s) na avaliação física.";
							} else {
								msgAlerta = "Resultado do(s) desempenho(s) na avaliação física:<br/>";
								for (AvaliacaoResultado result : resulDesempenho) {
									msgAlerta += result.getCategoriaAtividade().getAtividadeAvaliacao().getTeste() + " - <b>" + result.getResultado() + "</b></br>";
								}
							}
						}
						
					} catch (Exception e) {
						msgErro = e.getMessage();
					}
					
				} else {
					msgAlerta = "Nenhum valor de desempenho na avaliação física foi informado! Favor tentar novamente.";
				}
			}
			
			if (!msgErro.equals("")) {
				request.setAttribute("msgErro", msgErro);
			} else {
				request.setAttribute("msgSucesso", msgSucesso);
			}
			
			if (!msgAlerta.equals("")) {
				request.setAttribute("msgAlerta", msgAlerta);
			}
			
			//Carregar página Buscar Atleta
			AtletaNegocio negocio = new AtletaNegocio();
			List<Atleta> lista = new ArrayList<Atleta>();
			try{
				lista = negocio.buscarAtletas(1);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			request.setAttribute("listaAtletas", lista);
			retorno = String.format("%s/TecnicoBuscaAtleta.jsp", Constants.VIEW);
		
		} else if ("excluirAvaliacao".equals(action)) {
			int idAvaliacaoFisica = Integer.parseInt(request.getParameter("idAvaliacaoFisica"));
			
			try {
				AvaliacaoResultadoNegocio avalResulNegocio = new AvaliacaoResultadoNegocio();
				AvaliacaoFisicaNegocio avalFisNegocio = new AvaliacaoFisicaNegocio();
				
				if (avalResulNegocio.excluir(idAvaliacaoFisica)) {
					if (avalFisNegocio.excluir(idAvaliacaoFisica)) {
						request.setAttribute("msgSucesso", "Avaliação física excluída com sucesso!");
					} else {
						request.setAttribute("msgErro", "Ocorreu algum erro ao excluir a avalição física! Favor tentar novamente.");
					}
				} else {
					request.setAttribute("msgErro", "Ocorreu algum erro ao excluir os resultados da avalição física! Favor tentar novamente.");
				}
			} catch (Exception e) {
				request.setAttribute("msgErro", e.getMessage());
			}
			
			//Carregar página Buscar Atleta
			AtletaNegocio negocio = new AtletaNegocio();
			List<Atleta> lista = new ArrayList<Atleta>();
			try{
				lista = negocio.buscarAtletas(1);
			}catch(Exception ex){
				request.setAttribute("msgAlerta", ex.getMessage());
			}
			
			request.setAttribute("listaAtletas", lista);
			retorno = String.format("%s/TecnicoBuscaAtleta.jsp", Constants.VIEW);
			
		} else if ("jspHistorico".equals(action)) {
			int idAtleta = Integer.parseInt(request.getParameter("idAtleta"));
			String nomeAtleta = request.getParameter("nome");
			
			List<AvaliacaoFisica> listaAvaliacaoFis = new ArrayList<AvaliacaoFisica>();
			AvaliacaoFisicaNegocio negocio = new AvaliacaoFisicaNegocio();
			
			try {
				listaAvaliacaoFis = negocio.buscaHistorico(idAtleta);
				if (!listaAvaliacaoFis.isEmpty()) {
					request.setAttribute("listaAvaliacaoFis", listaAvaliacaoFis);
					request.setAttribute("nomeAtleta", nomeAtleta);
				} else {
					request.setAttribute("msgAlerta", "Nenhuma avaliação física cadastrada para o atleta " + nomeAtleta + ".");
				}
			} catch (Exception e) {
				request.setAttribute("msgErro", e.getMessage());
			}
			
			retorno = String.format("%s/TecnicoHistoricoAvaliacao.jsp", Constants.VIEW);
			
		} else if ("jspEditarAvaliacaoFis".equals(action)) {
			int idAvaliacaoFis = Integer.parseInt(request.getParameter("idAvaliacaoFis"));
			
			AvaliacaoFisicaNegocio negocio = new AvaliacaoFisicaNegocio();
			AvaliacaoFisica avaliacao = new AvaliacaoFisica();
			
			try {
				avaliacao = negocio.buscaAvaliacao(idAvaliacaoFis);
				
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				avaliacao.setDtAvaliacaoDisplay(formatter.format(avaliacao.getDtAvaliacao()));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			TpCaracteristicaNegocio caractNegocio = new TpCaracteristicaNegocio();
			List<String> tpCaracteristica = caractNegocio.listaTpCaracteristicaString();
			
			UnidadeDeMedidaNegocio unidadeNegocio = new UnidadeDeMedidaNegocio();
			List<String> listaUnidades = unidadeNegocio.listaUnidadeDeMedidaString();
			
			Map<String, Object> lista = new LinkedHashMap<String, Object>();
			lista.put("tpCaracteristica", tpCaracteristica);
			lista.put("listaUnidades", listaUnidades);
			lista.put("avaliacao", avaliacao);
			lista.put("idAvaliacaoFisica", idAvaliacaoFis);
			
			String json = new Gson().toJson(lista);

		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		
		} else{
		//Página Principal
		retorno = String.format("%s/TecnicoPrincipal.jsp", Constants.VIEW);
		
		}
		if(retorno != null){
			session.setAttribute("pagina", servletRetorno);
			rd = getServletContext().getRequestDispatcher(retorno);
			rd.forward(request, response);
		}
	}
}
