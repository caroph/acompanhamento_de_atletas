package br.com.saat.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.saat.core.Constants;
import br.com.saat.enumeradores.Perfis;
import br.com.saat.model.Atleta;
import br.com.saat.model.Usuario;
import br.com.saat.model.negocio.AtletaNegocio;

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
			
		}else if("novoTorneio".equals(action)){
			
		}else if("jspCalendario".equals(action)){
			retorno = String.format("%s/TecnicoCalendarioTorneio.jsp", Constants.VIEW);
		}else if("editarTorneio".equals(action)){
			
		}else if("excluirTorneio".equals(action)){
			
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
