package br.com.saat.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import br.com.saat.core.Constants;
import br.com.saat.enumeradores.Perfis;
import br.com.saat.model.Atleta;
import br.com.saat.model.FichaDeAtendimento;
import br.com.saat.model.Usuario;
import br.com.saat.model.negocio.AtletaNegocio;
import br.com.saat.model.negocio.FichaDeAtendimentoNegocio;

@WebServlet("/NutricionistaController")
public class NutricionistaController extends Controller {
	private static final long serialVersionUID = 1L;
       
    public NutricionistaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		String servletRetorno = String.format("%s/NutricionistaPrincipal.jsp", Constants.VIEW);
		
		//Verifica autenticação usuário
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(usuarioLogado == null || usuarioLogado.getPerfil() != Perfis.Nutricionista.getValor()){
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
			retorno = String.format("%s/NutricionistaBuscaAtleta.jsp", Constants.VIEW);
			servletRetorno = "/NutricionistaController?action=jspBuscarAtletas";
		}else if("jspFichaDeAtendimento".equals(action)){
			String msg = "";
			String msgSucesso = "";
			String strIdade = "";
			FichaDeAtendimento ficha =  null;
			Atleta atleta = null;
			
			
			try{
				int idAtleta = Integer.parseInt(request.getParameter("idAtleta"));
				FichaDeAtendimentoNegocio fichaNegocio = new FichaDeAtendimentoNegocio();
				ficha = fichaNegocio.buscarUltimaFicha(idAtleta);
				AtletaNegocio atletaNegocio = new AtletaNegocio();
				atleta = atletaNegocio.buscarAtleta(idAtleta);
				
				if(atleta != null){
					Date dataNasc = atleta.getDtNascimento();
					Date dataAtual = new Date(System.currentTimeMillis());

					int idadeAnos = dataAtual.getYear() - dataNasc.getYear();
					int idadeMeses = 0;
					if(dataAtual.getMonth() > dataNasc.getMonth()){
						idadeMeses = dataAtual.getMonth() - dataNasc.getMonth();
					}
					if(dataAtual.getMonth() < dataNasc.getMonth()){
						idadeAnos--;
						idadeMeses = (12 - dataNasc.getMonth()) + dataAtual.getMonth();
					}else{
						if(dataAtual.getDate() < dataNasc.getDate()){
							idadeAnos--;
							idadeMeses = 11;
						}						
					}
					
					strIdade = idadeAnos>0? (idadeAnos==1? "1 Ano" : idadeAnos + " Anos"):"";
					strIdade += idadeAnos>0&&idadeMeses>0? " e ":"";
					strIdade += idadeMeses>0? (idadeMeses==1? "1 Mês" : idadeMeses + " Meses") : "";
				}
					
			}catch(ParseException ex){
				msg = ex.getMessage();
			}catch(Exception ex){
				msg = ex.getMessage();
			}
			
			request.setAttribute("msgAlerta", msg);
			request.setAttribute("msgSucesso", msgSucesso);
			request.setAttribute("fichaAtendimento", ficha);
			request.setAttribute("atleta", atleta);
			request.setAttribute("strIdade", strIdade);
			retorno = String.format("%s/NutricionistaFichaDeAtendimento.jsp", Constants.VIEW);
		
		}else{
			retorno = String.format("%s/NutricionistaPrincipal.jsp", Constants.VIEW);
			servletRetorno = retorno;
		}
		
		if(retorno != null){
			session.setAttribute("pagina", servletRetorno);
			rd = getServletContext().getRequestDispatcher(retorno);
			rd.forward(request, response);
		}
	}

}
