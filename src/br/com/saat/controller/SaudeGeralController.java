package br.com.saat.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import br.com.saat.model.Prontuario;
import br.com.saat.model.Usuario;
import br.com.saat.model.negocio.AtletaNegocio;
import br.com.saat.model.negocio.ProntuarioNegocio;

@WebServlet("/SaudeGeralController")
public class SaudeGeralController extends Controller {
	private static final long serialVersionUID = 1L;
       
    public SaudeGeralController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		String servletRetorno = "/SaudeGeralController";
		
		//Verifica autenticação usuário
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(usuarioLogado == null || (usuarioLogado.getPerfil() != Perfis.Fisioterapeuta.getValor() && usuarioLogado.getPerfil() != Perfis.Psicologa.getValor())){
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
			retorno = String.format("%s/SaudeGeralBuscaAtleta.jsp", Constants.VIEW);
			servletRetorno = "/SaudeGeralController?action=jspBuscarAtletas";
			
		}else if ("novoAtendimento".equals(action)){
			//inserir Novo Atendimento
			boolean exception = false;
			String msgSucesso = "";
			String msg = "";
			int idProntuario = 0;
			
			Atleta atleta = new Atleta();
			Usuario usuario = new Usuario();
			
			String dt = request.getParameter("dtAtendimento");			
			String hr = request.getParameter("hrAtendimento");
			Date dtAtendimento = null; 
            Date hrAtendimento = null;
            
            try{
            	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
            	dtAtendimento = (Date)formatter.parse(dt);
            	
            	formatter = new SimpleDateFormat("HH:mm");  
            	hrAtendimento = (Date)formatter.parse(hr);
            	
            	atleta.setIdPessoa(Integer.parseInt(request.getParameter("idAtletaAtend")));
    			usuario.setIdPessoa(usuarioLogado.getIdPessoa());
    			idProntuario = Integer.parseInt(request.getParameter("idProntuario"));
            }catch(Exception ex){
            	msg = "Ocorreu algum erro no sistema! Favor tentar novamente.";
            	exception = true;
            }
            
            if(!exception){
            	Prontuario prontuario = new Prontuario();
    			ProntuarioNegocio negocio = new ProntuarioNegocio();
    			
    			prontuario.setDtAtendimento(dtAtendimento);
    			prontuario.setHrAtendimento(hrAtendimento);
    			prontuario.setAnotacao(request.getParameter("anotacao"));
    			prontuario.setAtleta(atleta);
    			prontuario.setUsuario(usuario);
    			
				
				try {
					if( !"".equals(idProntuario) && !"0".equals(idProntuario)){
						prontuario.setIdProntuario(idProntuario);
					}
					
					//Valida dados prontuário
					List<Object> listaValidacao = negocio.validaDados(prontuario);
					boolean valida = (boolean) listaValidacao.get(0);
					
					if(valida){
						if(prontuario.getIdProntuario() == 0){
							//Inserir prontuário
							if(negocio.inserir(prontuario)){
								msgSucesso = "Atendimento cadastrado com sucesso!";
							}
						}else{
							//Alterar
							if(negocio.alterar(prontuario)){
								msgSucesso = "Atendimento alterado com sucesso!";
							}
						}
					}else{
						msg = (String) listaValidacao.get(1);
					}
				} catch (Exception ex) {
					msg = ex.getMessage(); 
				}
				
				
				AtletaNegocio atletaNegocio = new AtletaNegocio();
				List<Atleta> lista = new ArrayList<Atleta>();				
				try{
					lista = atletaNegocio.buscarAtletas(1);
				}catch(Exception ex){
					request.setAttribute("msgErro", ex.getMessage());
				}
				
				if("".equals(msgSucesso)){
					request.setAttribute("msgErro", msg);
				}else{
					request.setAttribute("msgSucesso", msgSucesso);
				}
				
				request.setAttribute("listaAtletas", lista);
				retorno = String.format("%s/SaudeGeralBuscaAtleta.jsp", Constants.VIEW);
				servletRetorno = "/SaudeGeralController?action=jspBuscarAtletas";
            }
		}else if ("jspHistorico".equals(action)){
			boolean exception = false;
			int idAtleta = 0;
			int idUsuario = 0;
			String nomeAtleta = "";
			
			try{
				idAtleta = Integer.parseInt(request.getParameter("idAtleta"));
				idUsuario = usuarioLogado.getIdPessoa();
				nomeAtleta = request.getParameter("nome");
            }catch(Exception ex){
            	request.setAttribute("msgErro", "Ocorreu algum erro no sistema! Favor tentar novamente.");
            	exception = true;
            }
			
			if(!exception){
				ProntuarioNegocio negocio = new ProntuarioNegocio();
				try{
					List<Prontuario> lista = negocio.buscaHistorico(idAtleta, idUsuario);
					if(!lista.isEmpty()){
						request.setAttribute("listaProntuario", lista);
					}else{
						request.setAttribute("msgAlerta", "Nenhum histórico disponível para esse atleta.");
					}
				}catch(Exception ex){
					request.setAttribute("msgErro", ex.getMessage());
				}
				request.setAttribute("nomeAtleta", nomeAtleta);
				request.setAttribute("idAtleta", idAtleta);
			}
			
			retorno = String.format("%s/SaudeGeralHistorico.jsp", Constants.VIEW);
			servletRetorno = "/SaudeGeralController?action=jspHistorico&idAtleta=" + 
					request.getParameter("idAtleta")+ "&nome=" + nomeAtleta;
			
		}else if("excluirAtendimento".equals(action)){
			boolean exception = false;
			int idProntuario = 0; 
			int idAtleta = 0;
			int idUsuario = 0;
			String nomeAtleta = "";
			
			try{
				idProntuario = Integer.parseInt(request.getParameter("idProntuario"));
				idAtleta = Integer.parseInt(request.getParameter("idAtleta"));
				idUsuario = usuarioLogado.getIdPessoa();
				nomeAtleta = request.getParameter("nome");
            }catch(Exception ex){
            	request.setAttribute("msgErro", "Ocorreu algum erro no sistema! Favor tentar novamente.");
            	exception = true;
            }
			
			if(!exception){
				ProntuarioNegocio negocio = new ProntuarioNegocio();
				try{
	                if(negocio.excluir(idProntuario)){
	                	request.setAttribute("msgSucesso", "Atendimento excluido com sucesso!");  
	                	try{
	    					List<Prontuario> lista = negocio.buscaHistorico(idAtleta, idUsuario);
	    					if(!lista.isEmpty()){
	    						request.setAttribute("listaProntuario", lista);
	    					}else{
	    						request.setAttribute("msgAlerta", "Nenhum histórico disponível para esse atleta.");
	    					}
	    				}catch(Exception ex){
	    					request.setAttribute("msgErro", ex.getMessage());
	    				}
	    				request.setAttribute("nomeAtleta", nomeAtleta);
	    				request.setAttribute("idAtleta", idAtleta);
	                }else{
	                	request.setAttribute("msgErro", "Ocorreu algum erro no sistema! Favor tentar novamente.");
	                	}
	            }catch(Exception ex){
	            	request.setAttribute("msgErro", ex.getMessage());                   
	            }
			}
			retorno = String.format("%s/SaudeGeralHistorico.jsp", Constants.VIEW);
			servletRetorno = "/SaudeGeralController?action=jspHistorico";
			
		}else{
			//Página Principal
			int idUsuario = usuarioLogado.idPessoa;
			
			ProntuarioNegocio negocio = new ProntuarioNegocio();
			
			try{
				List<Prontuario> lista = negocio.buscaUltimosAtend(idUsuario);
				if(!lista.isEmpty()){
					request.setAttribute("listaAtendimento", lista);
				}else{
					request.setAttribute("msgAlerta", "Nenhum atendimento registrado.");
				}
			}catch(Exception ex){
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			retorno = String.format("%s/SaudeGeralPrincipal.jsp", Constants.VIEW);
		}
		
		if(retorno != null){
			session.setAttribute("pagina", servletRetorno);
			rd = getServletContext().getRequestDispatcher(retorno);
			rd.forward(request, response);
		}
	}
}
