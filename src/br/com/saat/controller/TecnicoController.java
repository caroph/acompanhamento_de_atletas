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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.saat.core.Constants;
import br.com.saat.enumeradores.CatTorneio;
import br.com.saat.enumeradores.GpTorneio;
import br.com.saat.enumeradores.Naipe;
import br.com.saat.enumeradores.Perfis;
import br.com.saat.enumeradores.TpTorneio;
import br.com.saat.model.Atleta;
import br.com.saat.model.Usuario;
import br.com.saat.model.dao.Torneio;
import br.com.saat.model.negocio.AtletaNegocio;
import br.com.saat.model.negocio.CatTorneioNegocio;
import br.com.saat.model.negocio.GpTorneioNegocio;
import br.com.saat.model.negocio.NaipeNegocio;
import br.com.saat.model.negocio.TorneioNegocio;
import br.com.saat.model.negocio.TpTorneioNegocio;

import com.google.gson.Gson;

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
		
		//Verifica autenticação usuário
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(usuarioLogado == null || (usuarioLogado.getPerfil() != Perfis.Tecnico.getValor() && usuarioLogado.getPerfil() != Perfis.PreparadorFisico.getValor())){
			super.doPost(request, response, usuarioLogado, false, false);
			return;
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
				// TODO Auto-generated catch block
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
			String msgSucesso = "";
			String msgErro = "";
			String atletasPart[] = null;
			Torneio torneio = new Torneio();

			String dtaInicial = request.getParameter("dtInicial");
			String dtaFinal = request.getParameter("dtFinal");
			Date dtInicial = null;
			Date dtFinal = null;

			try {
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				dtInicial = (Date) formatter.parse(dtaInicial);
				dtFinal = (Date) formatter.parse(dtaFinal);
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

				List<Object> listaValidacao = negocio.validaDados(torneio);
				boolean valida = (boolean) listaValidacao.get(0);
				if (!valida) {
					msgErro = (String) listaValidacao.get(1);
				} else {
					try {
						int idNovoTorneio = negocio.inserir(torneio);
						if (idNovoTorneio > 0){
							if (!"".equals(atletasPart) && atletasPart != null){
								if (negocio.inserirAtletasPart(atletasPart, idNovoTorneio)){
									msgSucesso = "Torneio salvo com sucesso!";
								}
							}else{
								msgSucesso = "Torneio salvo com sucesso!";
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
				// TODO Auto-generated catch block
				msgErro = ex.getMessage();
			}
			
			request.setAttribute("listaNaipe", listaNaipe);
			request.setAttribute("listaCategoria", listaCategoria);
			request.setAttribute("listaTipo", listaTipo);
			request.setAttribute("listaGrupo", listaGrupo);

			if (("").equals(msgSucesso)) {
				request.setAttribute("msgErro", msgErro);
				request.setAttribute("torneio", torneio);
			} else {
				request.setAttribute("msgSucesso", msgSucesso);
			}

			retorno = String.format("%s/TecnicoNovoTorneio.jsp",
					Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspNovoTorneio";	
			
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
				// TODO Auto-generated catch block
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
				request.setAttribute("listaAtletasPart", listaAtleta);
				
			} catch (Exception ex) {
				// TODO Auto-generated catch block
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			request.setAttribute("listaNaipe", listaNaipe);
			request.setAttribute("listaCategoria", listaCategoria);
			request.setAttribute("listaTipo", listaTipo);
			request.setAttribute("listaGrupo", listaGrupo);
			
			retorno = String.format("%s/TecnicoNovoTorneio.jsp",
					Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspNovoTorneio";
		}else if("excluirTorneio".equals(action)){
			String msgErro = "";
			String msgSucesso = "";
			
			Torneio torneio = new Torneio();
			torneio.setIdTorneio(Integer.parseInt(request.getParameter("idTorneio")));

			TorneioNegocio negocio = new TorneioNegocio();
			
			try {
				if (negocio.desativar(torneio)) {
					msgSucesso = "Torneio excluído com sucesso!";
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
		}else if("detalhesTorneio".equals(action)){
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
		    
		}else if("jspChamadaQuadra".equals(action)){
			retorno = String.format("%s/TecnicoChamadaQuadras.jsp", Constants.VIEW);
			servletRetorno = "/TecnicoController?action=jspChamadaQuadra";
		}else{
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
