package br.com.saat.controller;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.saat.core.Constants;
import br.com.saat.model.DiaTreino;
import br.com.saat.model.DiasSemana;
import br.com.saat.model.Equipes;
import br.com.saat.model.negocio.DiaTreinoNegocio;
import br.com.saat.model.negocio.DiasSemanaNegocio;
import br.com.saat.model.negocio.EquipesNegocio;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@WebServlet("/SecretariaController")
public class SecretariaController extends Controller {
	private static final long serialVersionUID = 1L;
       
    public SecretariaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		//HttpSession session;
		RequestDispatcher rd;
		String retorno = String.format("%s/SecretariaPrincipal.jsp", Constants.VIEW);
		String action = request.getParameter("action");
		
		if("jspNovoAtleta".equals(action)){
		//Carregar página Novo Atleta
			retorno = String.format("%s/SecretariaNovoAtleta.jsp", Constants.VIEW);
			
		}else if("jspNovoDiaTreino".equals(action)){
		//Carregar página Novo dia de treino
			EquipesNegocio negocioEquipe = new EquipesNegocio();
			List<Equipes> listaEquipes = negocioEquipe.listaEquipes();
			
			DiasSemanaNegocio negocioSemana = new DiasSemanaNegocio();
			List<DiasSemana> listaSemana = negocioSemana.listaSemana();
			
			request.setAttribute("listaEquipes", listaEquipes);
			request.setAttribute("listaSemana", listaSemana);
			retorno = String.format("%s/SecretariaNovoDiaTreino.jsp", Constants.VIEW);
			
		}else if("inserirDiaTreino".equals(action)){
		//Inserir novo dia de treino
			DiaTreino dia = new DiaTreino();
			DiaTreinoNegocio negocio = new DiaTreinoNegocio();
			
			String inicio = request.getParameter("hrInicio");
			String fim = request.getParameter("hrFim");			
            Date hrInicio = null;
            Date hrFim = null; 
            try {
            	DateFormat formatter = new SimpleDateFormat("HH:mm");  
            	hrInicio = (Date)formatter.parse(inicio);
            	hrFim = (Date)formatter.parse(fim);

            } catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			dia.setTpEquipe(Integer.parseInt(request.getParameter("tpEquipe")));
			dia.setDiaDaSemana(Integer.parseInt(request.getParameter("diaSemana")));
			dia.setHrInicio(hrInicio);
			dia.setHrFim(hrFim);
			
			List<Object> listaValidacao = negocio.validaDados(dia);
			boolean valida = (boolean) listaValidacao.get(0);
			if(!valida){
				request.setAttribute("msg", listaValidacao.get(1));
			}else{
				try{
                    if(negocio.inserir(dia)){
                    	request.setAttribute("msg", "Dia de Treino salvo com sucesso!");
                    }else{
                    	request.setAttribute("msg", "Ocorreu algum erro no sistema! Favor tentar novamente.");
                    }
                }catch(Exception ex){
                    request.setAttribute("msg", "Ocorreu algum erro no sistema! Favor tentar novamente.");                    
                }
			}
			
			EquipesNegocio negocioEquipe = new EquipesNegocio();
			List<Equipes> listaEquipes = negocioEquipe.listaEquipes();
			
			DiasSemanaNegocio negocioSemana = new DiasSemanaNegocio();
			List<DiasSemana> listaSemana = negocioSemana.listaSemana();
			
			request.setAttribute("listaEquipes", listaEquipes);
			request.setAttribute("listaSemana", listaSemana);
			retorno = String.format("%s/SecretariaNovoDiaTreino.jsp", Constants.VIEW);
		
		}else if("jspBuscaDiaTreino".equals(action)){
		//Carregar página Buscar Dias de Treinos
			DiaTreinoNegocio negocio = new DiaTreinoNegocio();
			List<DiaTreino> lista = negocio.buscaDiasTreino();
			
			request.setAttribute("listaDiasTreinos", lista);
			retorno = String.format("%s/SecretariaBuscaDiaTreino.jsp", Constants.VIEW);
		
		}else if("desativarDiaTreino".equals(action)){
			DiaTreino dia = new DiaTreino(Integer.parseInt(request.getParameter("idDiaTreino")));
			DiaTreinoNegocio negocio = new DiaTreinoNegocio();
		}
		rd = getServletContext().getRequestDispatcher(retorno);
		rd.forward(request, response);
	}

}
