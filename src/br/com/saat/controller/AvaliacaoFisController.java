package br.com.saat.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.saat.core.Constants;
import br.com.saat.enumeradores.Perfis;
import br.com.saat.enumeradores.TipoCat;
import br.com.saat.enumeradores.UnidadeDeMedida;
import br.com.saat.model.AtividadeAvaliacao;
import br.com.saat.model.CategoriaAtividade;
import br.com.saat.model.CategoriaAvaliacao;
import br.com.saat.model.Usuario;
import br.com.saat.model.negocio.AtividadeAvaliacaoNegocio;
import br.com.saat.model.negocio.CategoriaAtividadeNegocio;
import br.com.saat.model.negocio.CategoriaAvaliacaoNegocio;
import br.com.saat.model.negocio.ObservacaoNegocio;
import br.com.saat.model.negocio.TipoCatNegocio;
import br.com.saat.model.negocio.UnidadeDeMedidaNegocio;

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
		String servletRetorno = "/AvaliacaoFisController";
		
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
				lista = negocio.buscarAtividades();
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
			servletRetorno = retorno;
			
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
				lista = negocio.buscarAtividades();
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
				lista = negocio.buscarAtividades();
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

		} else if ("jspCategoria".equals(action)) {
			CategoriaAvaliacaoNegocio negocio = new CategoriaAvaliacaoNegocio();
			List<CategoriaAvaliacao> lista = new ArrayList<CategoriaAvaliacao>();
			try{
				lista = negocio.buscarCategorias(0);
				if (lista.isEmpty()) {
					request.setAttribute("msgAlerta", "Nenhuma categoria de avaliação física cadastrada!");
				}
			}catch(Exception ex){
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			TipoCatNegocio tipoCatNegocio = new TipoCatNegocio();
			List<TipoCat> listaTipo = tipoCatNegocio.listaTipoCat();
			
			request.setAttribute("listaTipo", listaTipo);
			request.setAttribute("listaCategorias", lista);
			retorno = String.format("%s/TecnicoBuscaCategoria.jsp", Constants.VIEW);
			servletRetorno = retorno;
			
		} else if ("novaCategoria".equals(action)) {
			boolean exception = false;
			int idadeMin = 0;
			int idadeMax = 0;
			
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

			if (!exception) {
				categoria.setNmCategoria(request.getParameter("nome"));
				categoria.setIdadeMinima(idadeMin);
				categoria.setIdadeMaxima(idadeMax);
				categoria.setSexo(request.getParameter("sexo"));
				
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
				lista = negocio.buscarCategorias(0);
				if (lista.isEmpty()) {
					request.setAttribute("msgAlerta", "Nenhuma categoria de avaliação física cadastrada!");
				}
			}catch(Exception ex){
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			request.setAttribute("listaTipo", listaTipo);
			request.setAttribute("listaCategorias", lista);
			retorno = String.format("%s/TecnicoBuscaCategoria.jsp", Constants.VIEW);
			
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
				lista = negocio.buscarCategorias(0);
				if (lista.isEmpty()) {
					request.setAttribute("msgAlerta", "Nenhuma categoria de avaliação física cadastrada!");
				}
			}catch(Exception ex){
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			TipoCatNegocio tipoCatNegocio = new TipoCatNegocio();
			List<TipoCat> listaTipo = tipoCatNegocio.listaTipoCat();
			
			request.setAttribute("listaTipo", listaTipo);
			request.setAttribute("listaCategorias", lista);
			retorno = String.format("%s/TecnicoBuscaCategoria.jsp", Constants.VIEW);

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
			
		} else if ("jspNovoDadosRef".equals(action)) {
			CategoriaAvaliacaoNegocio negocioCat = new CategoriaAvaliacaoNegocio();
			AtividadeAvaliacaoNegocio negocioAti = new AtividadeAvaliacaoNegocio();

			List<CategoriaAvaliacao> listaCategorias = new ArrayList<CategoriaAvaliacao>();
			List<AtividadeAvaliacao> listaAtividades = new ArrayList<AtividadeAvaliacao>();
			
			try{
				listaCategorias = negocioCat.buscarCategorias(1);
				if (listaCategorias.isEmpty()) {
					request.setAttribute("msgAlerta", "Nenhuma categoria de avaliação física cadastrada!");
				} else {
					try{
						listaAtividades = negocioAti.buscarAtividades();
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
			retorno = String.format("%s/TecnicoNovoDadosRef.jsp", Constants.VIEW);
			
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
				listaAtividades = negocioAti.buscarAtividades();
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
						
						//Média
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
						if (negocio.inserir(categoriaAtividades, categoriasSelecionadas)) {
							msgSucesso = "Dados de referência salvos com sucesso!";
						} else {
							msgErro = "Ocorreu algum erro no sistema! Favor tentar novamente.";
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
			
		} else if ("desativarDadoRef".equals(action)) {
			String msgSucesso = "";
			String msgErro ="";
			String msgAlerta = "";
			CategoriaAtividade catAtiv = new CategoriaAtividade();
			CategoriaAtividadeNegocio negocio = new CategoriaAtividadeNegocio();
			
			try {
				catAtiv.setIdCategoriaAtividade(Integer.parseInt(request.getParameter("idCategoriaAtividade")));
				if (negocio.desativar(catAtiv)) {
					msgSucesso ="Dado de referência excluído com sucesso!";
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
