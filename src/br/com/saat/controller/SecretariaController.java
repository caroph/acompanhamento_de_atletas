package br.com.saat.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.saat.core.Constants;
import br.com.saat.model.DiaTreino;
import br.com.saat.model.DiasSemana;
import br.com.saat.model.Equipes;
import br.com.saat.model.Perfis;
import br.com.saat.model.Usuario;
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
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		
		//Verifica autenticação usuário
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		if(usuario == null || usuario.getPerfil() != Perfis.Secretaria.getValor()){
			super.doPost(request, response, usuario, false, false);
			return;
		}
		
		String retorno = String.format("%s/SecretariaPrincipal.jsp", Constants.VIEW);
		String action = request.getParameter("action");
		
		if("jspNovoAtleta".equals(action)){
		//Carregar página Novo Atleta
			retorno = String.format("%s/SecretariaNovoAtleta.jsp", Constants.VIEW);
			
		}else if("jspNovoDiaTreino".equals(action)){
		//Carregar página Novo Dia de Treino
			EquipesNegocio negocioEquipe = new EquipesNegocio();
			List<Equipes> listaEquipes = negocioEquipe.listaEquipes();
			
			DiasSemanaNegocio negocioSemana = new DiasSemanaNegocio();
			List<DiasSemana> listaSemana = negocioSemana.listaSemana();
			
			request.setAttribute("listaEquipes", listaEquipes);
			request.setAttribute("listaSemana", listaSemana);
			retorno = String.format("%s/SecretariaNovoDiaTreino.jsp", Constants.VIEW);
			
		}else if("inserirDiaTreino".equals(action)){
		//Inserir novo dia de treino
			String msg = "";
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
            	
            	dia.setTpEquipe(Integer.parseInt(request.getParameter("tpEquipe")));
            	dia.setDiaDaSemana(Integer.parseInt(request.getParameter("diaSemana")));
            	dia.setHrInicio(hrInicio);
            	dia.setHrFim(hrFim);
            	
            	List<Object> listaValidacao = negocio.validaDados(dia);
            	boolean valida = (boolean) listaValidacao.get(0);
            	if(!valida){
            		msg = (String) listaValidacao.get(1);
            	}else{
            		try{
            			if(negocio.inserir(dia)){
            				msg = "Dia de Treino salvo com sucesso!";
            			}else{
            				msg = "Ocorreu algum erro no sistema! Favor tentar novamente.";
            			}
            		}catch(Exception ex){
            			msg = ex.getMessage();                    
            		}
            	}
            } catch (java.text.ParseException e) {
            	msg = "Ocorreu algum erro no sistema! Favor tentar novamente.";
			} 
			
            EquipesNegocio negocioEquipe = new EquipesNegocio();
            List<Equipes> listaEquipes = negocioEquipe.listaEquipes();
            
            DiasSemanaNegocio negocioSemana = new DiasSemanaNegocio();
            List<DiasSemana> listaSemana = negocioSemana.listaSemana();
			
			request.setAttribute("listaEquipes", listaEquipes);
			request.setAttribute("listaSemana", listaSemana);
			
			request.setAttribute("msg", msg);
			
			retorno = String.format("%s/SecretariaNovoDiaTreino.jsp", Constants.VIEW);
		
		}else if("jspBuscaDiaTreino".equals(action)){
		//Carregar página Buscar Dias de Treinos
			DiaTreinoNegocio negocio = new DiaTreinoNegocio();
			List<DiaTreino> lista = new ArrayList<DiaTreino>();
			try{
				lista = negocio.buscaDiasTreino();
			}catch(Exception ex){
				request.setAttribute("msg", ex.getMessage());
			}
			
			request.setAttribute("listaDiasTreinos", lista);
			retorno = String.format("%s/SecretariaBuscaDiaTreino.jsp", Constants.VIEW);
		
		}else if("desativarDiaTreino".equals(action)){
			String msg = "";
			DiaTreino dia = new DiaTreino(Integer.parseInt(request.getParameter("idDiaTreino")));
			DiaTreinoNegocio negocio = new DiaTreinoNegocio();
			List<DiaTreino> lista = new ArrayList<DiaTreino>();
			
			try{
                if(negocio.desativar(dia)){
                	msg = "Dia de Treino desativado com sucesso!";
                }else{
                	msg =  "Ocorreu algum erro no sistema! Favor tentar novamente.";
                }
                lista = negocio.buscaDiasTreino();
            }catch(Exception ex){
               msg = ex.getMessage();                    
            }			
			
			request.setAttribute("listaDiasTreinos", lista);
			request.setAttribute("msg", msg);
			retorno = String.format("%s/SecretariaBuscaDiaTreino.jsp", Constants.VIEW);
			
		}else if("jspNovoUsuario".equals(action)){
		//Carregar página Novo Usuario
			EquipesNegocio negocioEquipe = new EquipesNegocio();
			List<Equipes> listaEquipes = negocioEquipe.listaEquipes();
			
			request.setAttribute("listaEquipes", listaEquipes);
			retorno = String.format("%s/SecretariaNovoUsuario.jsp", Constants.VIEW);
		}
		rd = getServletContext().getRequestDispatcher(retorno);
		rd.forward(request, response);
	}

}
