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
import br.com.saat.model.Atleta;
import br.com.saat.model.DiaTreino;
import br.com.saat.model.DiasSemana;
import br.com.saat.model.Endereco;
import br.com.saat.model.Equipes;
import br.com.saat.model.Perfis;
import br.com.saat.model.Responsavel;
import br.com.saat.model.TpEndereco;
import br.com.saat.model.TpPessoa;
import br.com.saat.model.Usuario;
import br.com.saat.model.dao.ResponsavelDAO;
import br.com.saat.model.negocio.AtletaNegocio;
import br.com.saat.model.negocio.DiaTreinoNegocio;
import br.com.saat.model.negocio.DiasSemanaNegocio;
import br.com.saat.model.negocio.EnderecoNegocio;
import br.com.saat.model.negocio.EquipesNegocio;
import br.com.saat.model.negocio.PerfisNegocio;
import br.com.saat.model.negocio.ResponsavelNegocio;
import br.com.saat.model.negocio.UsuarioNegocio;

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
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(usuarioLogado == null || usuarioLogado.getPerfil() != Perfis.Secretaria.getValor()){
			super.doPost(request, response, usuarioLogado, false, false);
			return;
		}
		
		String retorno = String.format("%s/SecretariaPrincipal.jsp", Constants.VIEW);
		String action = request.getParameter("action");
		
		if("jspNovoAtleta".equals(action)){
		//Carregar página Novo Atleta
			retorno = String.format("%s/SecretariaNovoAtleta.jsp", Constants.VIEW);
			
		}else if("inserirAtleta".equals(action)){
			boolean exception = false;
			String escolha;
			String msg = "Ocorreu algum erro no sistema! Favor tentar novamente.";
			String msgSucesso = "";
			String idAtleta;
			int numero = 0;
			
			Atleta atleta = new Atleta();
			AtletaNegocio negocio = new AtletaNegocio();
			EnderecoNegocio endNegocio = new EnderecoNegocio();
			
			String nascimento = request.getParameter("dtNascimento");
			String validade = request.getParameter("dtValidade");			
            Date dtNascimento = null;
            Date dtValidade = null; 
            
            try{
            	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            	dtNascimento = (Date)formatter.parse(nascimento);
            	dtValidade = (Date)formatter.parse(validade);
			}catch(Exception ex){
				msg = "Ocorreu algum erro no sistema! Favor tentar novamente.";
				exception = true;
			}
            try{
            	numero = Integer.parseInt(request.getParameter("numero"));
			}catch(Exception ex){
				msg = "Favor informar corretamente o campo 'Número' do endereço";
				exception = true;
			}
			if(!exception){
				//Dados do Atleta
				idAtleta = request.getParameter("idAtleta");
				atleta.setNome(request.getParameter("nome"));
				atleta.setEmail(request.getParameter("email"));
				atleta.setCelular(request.getParameter("celular"));
				atleta.setNrMatricula(request.getParameter("nrMatricula"));
				atleta.setNrCadCBT(request.getParameter("nrCadCBT"));
				atleta.setNrCadFPT(request.getParameter("nrCadFPT"));
				atleta.setDtNascimento(dtNascimento);
				atleta.setRG(request.getParameter("rg"));
				atleta.setCPF(request.getParameter("cpf"));
				atleta.setEscola(request.getParameter("escola"));
				atleta.setSerie(request.getParameter("serie"));
				atleta.setTurno(request.getParameter("turno"));
				escolha = request.getParameter("acompPsicologico");
				atleta.setAcompPsicologico("sim".equals(escolha)?true:false);
				atleta.setMedicacaoAutorizada(request.getParameter("nmMedicoResponsavel"));
				atleta.setTelMedicoResponsal(request.getParameter("telMedicoResponsavel"));
				atleta.setConvenio(request.getParameter("convenio"));
				escolha = request.getParameter("flAlergias");
				atleta.setFlAlergias("sim".equals(escolha)?true:false);
				atleta.setDsAlergias(request.getParameter("dsAlergias"));
				escolha = request.getParameter("flMedicacao");
				atleta.setFlMedicacao("sim".equals(escolha)?true:false);
				atleta.setDsMedicacao(request.getParameter("dsMedicacao"));
				atleta.setNmContatoEmergencia(request.getParameter("nmContatoEmergencia"));
				atleta.setTelContatoEmergencia(request.getParameter("telContatoEmergencia"));
				atleta.setGrauParentescoContatoEmergencia(request.getParameter("grauParentescoContatoEmergencia"));
				atleta.setDtValidade(dtValidade);
				
				Endereco endereco = new Endereco();
				endereco.setEndereco(request.getParameter("endereco"));
				endereco.setNumero(numero);
				endereco.setComplemento(request.getParameter("complemento"));
				endereco.setBairro(request.getParameter("bairro"));
				endereco.setEstado(request.getParameter("estado"));
				endereco.setTelefone(request.getParameter("telefone"));
				endereco.setTpEndereco(1);
				
				atleta.setEndereco(endereco);
			
				try {
					if( !"".equals(idAtleta) && !"0".equals(idAtleta) ){
						atleta.setIdPessoa(Integer.parseInt(idAtleta));
					}
					//Valida dados atleta
					List<Object> listaValidacao = negocio.validaDados(atleta);
					boolean valida = (boolean) listaValidacao.get(0);
					
					if(valida){
						//Valida dados endereço
						listaValidacao = endNegocio.validar(endereco);
						valida = (boolean) listaValidacao.get(0);
						
						if(valida){
							if(atleta.getIdPessoa() == 0){
								//Inserindo Atleta
								int idNovoAtleta = negocio.inserir(atleta); 
								if(idNovoAtleta > 0){
									//Inserindo endereço
									if(endNegocio.inserir(endereco, idNovoAtleta, TpPessoa.Atleta.getValor())){
										msgSucesso = "Atleta cadastrado com sucesso!";
									}
								}
							}else{
								if(negocio.alterar(atleta)){
									msgSucesso = "Atleta alterado com sucesso!";
								}
							}
						}else{
							msg = (String) listaValidacao.get(1);
						}
					}else{
						msg = (String) listaValidacao.get(1);
					}
				} catch (Exception ex) {
					msg = ex.getMessage(); 
				}
			}

			if("".equals(msgSucesso)){
				request.setAttribute("msg", msg);
				request.setAttribute("atleta", atleta);
			}else{
				request.setAttribute("msgSucesso", msgSucesso);
			}
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
			boolean exception = false;
			String msgSucesso = "";
			String msg = "";
			DiaTreino dia = new DiaTreino();
			DiaTreinoNegocio negocio = new DiaTreinoNegocio();
			
			String inicio = request.getParameter("hrInicio");
			String fim = request.getParameter("hrFim");			
            Date hrInicio = null;
            Date hrFim = null; 
            
            try{
            	DateFormat formatter = new SimpleDateFormat("HH:mm");  
            	hrInicio = (Date)formatter.parse(inicio);
            	hrFim = (Date)formatter.parse(fim);
			}catch(Exception ex){
				msg = "Ocorreu algum erro no sistema! Favor tentar novamente.";
				exception = true;
			}
            
            try{
            	dia.setTpEquipe(Integer.parseInt(request.getParameter("tpEquipe")));
            	dia.setDiaDaSemana(Integer.parseInt(request.getParameter("diaSemana")));
			}catch(Exception ex){
				msg = "Favor selecionar corretamente o Tipo de Equipe e/ou Dia da Semana!";
				exception = true;
			}
            
            if(!exception){
            	dia.setHrInicio(hrInicio);
            	dia.setHrFim(hrFim);
            	
            	List<Object> listaValidacao = negocio.validaDados(dia);
            	boolean valida = (boolean) listaValidacao.get(0);
            	if(!valida){
            		msg = (String) listaValidacao.get(1);
            	}else{
            		try{
            			if(negocio.inserir(dia)){
            				msgSucesso = "Dia de Treino salvo com sucesso!";
            			}else{
            				msg = "Ocorreu algum erro no sistema! Favor tentar novamente.";
            			}
            		}catch(Exception ex){
            			msg = ex.getMessage();                    
            		}
            	}
            }
			
            EquipesNegocio negocioEquipe = new EquipesNegocio();
            List<Equipes> listaEquipes = negocioEquipe.listaEquipes();
            
            DiasSemanaNegocio negocioSemana = new DiasSemanaNegocio();
            List<DiasSemana> listaSemana = negocioSemana.listaSemana();
			
			request.setAttribute("listaEquipes", listaEquipes);
			request.setAttribute("listaSemana", listaSemana);
			
			if(("").equals(msgSucesso)){
				request.setAttribute("msg", msg);
			}else{
				request.setAttribute("msgSucesso", msgSucesso);
			}
			
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
			PerfisNegocio negocio = new PerfisNegocio();
			List<Perfis> lista = negocio.listaPerfis();
			
			request.setAttribute("listaPerfis", lista);
			retorno = String.format("%s/SecretariaNovoUsuario.jsp", Constants.VIEW);
			
		}else if("inserirUsuario".equals(action)){
			//Inserir novo usuário
			boolean exception = false;
			String msg = "";
			String msgSucesso = "";
			Usuario usuario = new Usuario();
			UsuarioNegocio negocio = new UsuarioNegocio();
			
			try{
				String perfil = request.getParameter("perfil");
				usuario.setPerfil(Integer.parseInt(perfil));
			}catch(Exception ex){
				msg = "Favor selecionar corretamente o Perfil do Usuário!";
				exception = true;
			}
			if(!exception){
				//Dados do usuário
				String idUsuario = request.getParameter("idUsuario");
				usuario.setNome(request.getParameter("nome"));
				usuario.setCREF(request.getParameter("cref"));
				usuario.setEmail(request.getParameter("email"));
				usuario.setCelular(request.getParameter("telcelular"));
				usuario.setTelefone(request.getParameter("telresidencial"));
				
				try{
					if(!idUsuario.equals("") && !idUsuario.equals("0")){
						usuario.setIdPessoa(Integer.parseInt(idUsuario));
					}
					//Valida dados do usuário
					List<Object> listaValidacao = negocio.validaDados(usuario);
					boolean valida = (boolean) listaValidacao.get(0);
				
					if(valida){
						if(usuario.getIdPessoa() == 0){
							if(negocio.inserir(usuario)){
		        				msgSucesso = "Usuário cadastrado com sucesso!";
		        			}else{
		        				msg = "Ocorreu algum erro no sistema! Favor tentar novamente.";
		        			}
						}else{
							if(negocio.alterar(usuario)){
		        				msgSucesso = "Usuário alterado com sucesso!";
		        			}else{
		        				msg = "Ocorreu algum erro no sistema! Favor tentar novamente.";
		        			}
						}
					}else{
						msg = (String) listaValidacao.get(1);
					}
				}catch(Exception ex){
					msg = ex.getMessage();  
				}
			}
			
			PerfisNegocio perfisNegocio = new PerfisNegocio();
			List<Perfis> lista = perfisNegocio.listaPerfis();
			
			request.setAttribute("listaPerfis", lista);
			request.setAttribute("msg", msg);
			request.setAttribute("msgSucesso", msgSucesso);
			if(msgSucesso.equals("")){
				request.setAttribute("usuario", usuario);
			}
			retorno = String.format("%s/SecretariaNovoUsuario.jsp", Constants.VIEW);
			
		}else if("jspBuscaUsuario".equals(action)){
			//Carregar página Buscar Usuario
			UsuarioNegocio negocio = new UsuarioNegocio();
			List<Usuario> lista = new ArrayList<Usuario>();
			try{
				lista = negocio.buscarUsuarios();
			}catch(Exception ex){
				request.setAttribute("msg", ex.getMessage());
			}
			
			request.setAttribute("listaUsuarios", lista);
			retorno = String.format("%s/SecretariaBuscaUsuario.jsp", Constants.VIEW);
			
		}else if("editarUsuario".equals(action)){
			int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
			Usuario usuario = new Usuario();
			
			UsuarioNegocio negocio = new UsuarioNegocio();
			
			try{
				usuario = negocio.buscarUsuario(idUsuario);
			}catch(Exception ex){
				request.setAttribute("msg", ex.getMessage());
			}
			
			PerfisNegocio perfisNegocio = new PerfisNegocio();
			List<Perfis> lista = perfisNegocio.listaPerfis();
			
			request.setAttribute("listaPerfis", lista);
			request.setAttribute("usuario", usuario);
			retorno = String.format("%s/SecretariaNovoUsuario.jsp", Constants.VIEW);
			
		}else if("desativarUsuario".equals(action)){
			String msg = "";
			String msgSucesso = "";
			Usuario usuario = new Usuario();
			usuario.setIdPessoa(Integer.parseInt(request.getParameter("idUsuario")));
			
			UsuarioNegocio negocio = new UsuarioNegocio();
			List<Usuario> lista = new ArrayList<Usuario>();
			
			try{
                if(negocio.desativar(usuario)){
                	msgSucesso = "Usuário desativado com sucesso!";
                }else{
                	msg =  "Ocorreu algum erro no sistema! Favor tentar novamente.";
                }
                lista = negocio.buscarUsuarios();
            }catch(Exception ex){
               msg = ex.getMessage();                    
            }			
			
			request.setAttribute("listaUsuarios", lista);
			request.setAttribute("msg", msg);
			request.setAttribute("msgSucesso", msgSucesso);
			retorno = String.format("%s/SecretariaUsuario.jsp", Constants.VIEW);
			
		}else if ("jspNovoResponsavel".equals(action)){
			retorno = String.format("%s/SecretariaNovoResponsavel.jsp", Constants.VIEW);
			
		}else if ("inserirResponsavel".equals(action)){
			String msg = "";
			Responsavel responsavel;
			ResponsavelNegocio responsavelNegocio = new ResponsavelNegocio();
			ArrayList<Endereco> listaEnderecos = new ArrayList<Endereco>();
			Endereco enderecoItem;
			EnderecoNegocio enderecoNegocio = new EnderecoNegocio();
			
			try{
				//dados da pessoa
				String nome = request.getParameter("nome");
				String email = request.getParameter("email");
				String celular = request.getParameter("celular");
	
				//endereco residencial
				String endereco = request.getParameter("endereco");
				int numero = Integer.parseInt(request.getParameter("numero"));
				String complemento = request.getParameter("complemento");
				String bairro = request.getParameter("bairro");
				String estado = request.getParameter("estado");
				String cidade = request.getParameter("cidade");
				String telefone = request.getParameter("telefone");
				
				enderecoItem = new Endereco(endereco, numero, complemento, bairro, estado, cidade, TpEndereco.Residencial.getValor(), telefone);
				List<Object> listaValidacao = enderecoNegocio.validar(enderecoItem);
				
				if(!(boolean)listaValidacao.get(0)){
					msg = (String)listaValidacao.get(1);
				}else{						
					listaEnderecos.add(enderecoItem);
					
					//endereco comercial
					endereco = request.getParameter("enderecoCom");
					numero = Integer.parseInt(request.getParameter("numeroCom"));
					complemento = request.getParameter("complementoCom");
					bairro = request.getParameter("bairroCom");
					estado = request.getParameter("estadoCom");
					cidade = request.getParameter("cidadeCom");
					telefone = request.getParameter("telefoneCom");
					
					enderecoItem = new Endereco(endereco, numero, complemento, bairro, estado, cidade, TpEndereco.Comercial.getValor(), telefone);
					listaValidacao = enderecoNegocio.validar(enderecoItem);
					
					if(!(boolean)listaValidacao.get(0)){
						msg = (String)listaValidacao.get(1);
					}else{
						listaEnderecos.add(enderecoItem);
						responsavel = new Responsavel(0, nome, email, celular, listaEnderecos);
						List<Object>listaValidacaoResponsavel = responsavelNegocio.validar(responsavel);
						
						if(!(boolean)listaValidacaoResponsavel.get(0)){
							msg = (String) listaValidacaoResponsavel.get(1);
						}else{
							try {
								ResponsavelDAO dao = new ResponsavelDAO();
								if(dao.inserir(responsavel))
									msg = "Responsável salvo com sucesso!";
								else
									msg = "Ocorreu algum erro no sistema! Favor tentar novamente.";
							} catch (Exception e) {
								msg = e.getMessage();
							}
						}					
					}
				}
			}catch(NumberFormatException ex){
				msg = "Favor informar corretamente o campo 'Número' dos endereços";
			}catch(ParseException ex){
				msg = "Ocorreu algum erro no sistema! Favor tentar novamente.";
			}
				
			request.setAttribute("msg", msg);
			retorno = String.format("%s/SecretariaNovoResponsavel.jsp", Constants.VIEW);
		}else if("jspBuscaResponsavel".equals(action)){
			ResponsavelNegocio responsavelNegocio = new ResponsavelNegocio();
			ArrayList<Responsavel> listaResponsaveis = null;
			String msg = "";
			
			try{
				listaResponsaveis = responsavelNegocio.buscarTodos();
			}catch(Exception ex){
				msg = ex.getMessage();
			}
			
			request.setAttribute("msg", msg);
			request.setAttribute("listaResponsaveis", listaResponsaveis);
			retorno = String.format("%s/SecretariaBuscaResponsavel.jsp", Constants.VIEW);
		}else if("desativarResponsavel".equals(action)){
			ArrayList<Responsavel> listaResponsaveis = null;
			String msgSucesso = "";
			String msg = "";
			
			try{
				int idResponsavel = Integer.parseInt(request.getParameter("idResponsavel"));
				ResponsavelNegocio responsavelNegocio = new ResponsavelNegocio();
				
				//desativa o responsavel
				if(responsavelNegocio.desativar(idResponsavel)){
					msgSucesso = "Responsável desativado com sucesso!";
				}else{
					msg = "Ocorreu algum erro no sistema! Favor tentar novamente.";
				}
				//busca os responsaveis denovo
				listaResponsaveis = responsavelNegocio.buscarTodos();
				
			}catch(Exception ex){
				msg = "Ocorreu algum erro no sistema! Favor tentar novamente.";
			}
			
			request.setAttribute("msg", msg);
			request.setAttribute("msgSucesso", msgSucesso);
			request.setAttribute("listaResponsaveis", listaResponsaveis);
			retorno = String.format("%s/SecretariaBuscaResponsavel.jsp", Constants.VIEW);
		}
		
		rd = getServletContext().getRequestDispatcher(retorno);
		rd.forward(request, response);
	}

}
