package br.com.saat.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.saat.core.Constants;
import br.com.saat.enumeradores.Perfis;
import br.com.saat.model.Usuario;

/**
 * Servlet implementation class AvaliacaoController
 */
@WebServlet("/AvaliacaoController")
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
		
		String retorno = null;
		String action = request.getParameter("action");
		
		if ("jspAtividade".equals(action)) {
			retorno = String.format("%s/TecnicoBuscaAtividade.jsp", Constants.VIEW);
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
