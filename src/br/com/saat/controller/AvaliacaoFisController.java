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
import br.com.saat.model.CategoriaAvaliacao;
import br.com.saat.model.Usuario;
import br.com.saat.model.negocio.AtividadeAvaliacaoNegocio;
import br.com.saat.model.negocio.CategoriaAvaliacaoNegocio;
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
				lista = negocio.buscarCategorias();
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
				lista = negocio.buscarCategorias();
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
				lista = negocio.buscarCategorias();
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
