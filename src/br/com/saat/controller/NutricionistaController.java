package br.com.saat.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import br.com.saat.model.AvaliacaoAntropometrica;
import br.com.saat.model.FichaDeAtendimento;
import br.com.saat.model.Usuario;
import br.com.saat.model.negocio.AtletaNegocio;
import br.com.saat.model.negocio.FichaDeAtendimentoNegocio;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

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
		
		if("jspPaginaInicialNutricionista".equals(action)){
			String msg = "";
			String msgSucesso = "";
			ArrayList<ArrayList<String>> listaUltimosAtendimentos = null;
			try{
				//busca os ultimos atendimentos
				FichaDeAtendimentoNegocio fichaNegocio = new FichaDeAtendimentoNegocio();
				listaUltimosAtendimentos = fichaNegocio.buscarUltimosAtendimentos(usuarioLogado.getIdPessoa());
			}catch(Exception ex){
				msg = ex.getMessage();
			}			
			
			request.setAttribute("msgAlerta", msg);
			request.setAttribute("msgSucesso", msgSucesso);
			request.setAttribute("listaUltimosAtendimentos", listaUltimosAtendimentos);
			retorno = String.format("%s/NutricionistaPrincipal.jsp", Constants.VIEW);
			
		}else if("jspBuscarAtletas".equals(action)){
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
				
				//Verifica se abre a página jsp em modo de edição ou inserção
				if(request.getParameter("idFichaDeAtendimento").equals("0")){
					// inserção
					ficha = fichaNegocio.buscarUltimaFicha(idAtleta);
					ficha.setIdFichaDeAtendimento(0);
				}else{
					if(!request.getParameter("idFichaDeAtendimento").equals("")){
						ficha = fichaNegocio.buscarPorId(Integer.parseInt(request.getParameter("idFichaDeAtendimento")));
					}else
						msg = "idFichaDeAtendimento Inválido!";
				}
				
				AtletaNegocio atletaNegocio = new AtletaNegocio();
				atleta = atletaNegocio.buscarAtleta(idAtleta);
				strIdade = atleta.getStrIdade();			
					
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
		
		}else if("novaFichaDeAtendimento".equals(action)){
			String msg = "";
			String msgSucesso = "";
			String strIdade = "";
			FichaDeAtendimento ficha = new FichaDeAtendimento();
			Atleta atleta = null;		
			
			try{				
				ficha.setIdFichaDeAtendimento(Integer.parseInt(request.getParameter("idFichaDeAtendimento")));
				ficha.setIdAtleta(Integer.parseInt(request.getParameter("idAtleta")));
				ficha.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
				ficha.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
				ficha.setHMA(request.getParameter("hma"));
				ficha.setAcompanhamentoAnterior(request.getParameter("acompanhamentoAnterior"));
				ficha.setDuracaoAcompanhamentoAnterior(request.getParameter("duracaoAcompanhamentoAnterior"));
				ficha.setHMF(request.getParameter("hmf"));
				ficha.setFlObesidade(request.getParameter("flObesidade") != null? true : false);
				ficha.setFlDiabetes(request.getParameter("flDiabetes") != null? true : false);
				ficha.setFlHas(request.getParameter("flHas") != null? true : false);
				ficha.setFlDoencaCardiaca(request.getParameter("flDoencaCardiaca") != null? true : false);
				ficha.setFlColesterol(request.getParameter("flColesterol") != null? true : false);
				ficha.setFlGastrite(request.getParameter("flGastrite") != null? true : false);
				ficha.setFlAzia(request.getParameter("flAzia") != null? true : false);
				ficha.setFlDorAbdominal(request.getParameter("flDorAbdominal") != null? true : false);
				ficha.setHabitoIntestinal(request.getParameter("habitoIntestinal"));
				ficha.setExamesRecentes(request.getParameter("examesRecentes"));
				ficha.setMedicamentos(request.getParameter("medicamentos"));
				ficha.setTpPraticaAtividadeFisica(request.getParameter("tpPraticaAtividadeFisica"));
				ficha.setFrequenciaAtividadeFisica(request.getParameter("frequenciaAtividadeFisica"));
				ficha.setIntensidadeAtividadeFisica(request.getParameter("intensidadeAtividadeFisica"));
				ficha.setIntoleranciaAlergiaAlimentar(request.getParameter("intoleranciaAlergiaAlimentar"));
				ficha.setAlimentosGosta(request.getParameter("alimentosGosta"));
				ficha.setAlimentosNaoGosta(request.getParameter("alimentosNaoGosta"));
				ficha.setApetite(request.getParameter("apetite"));
				ficha.setHrFomeEAlimentos(request.getParameter("hrFomeEAlimentos"));
				ficha.setLocalDeRefeicaoEQuemCozinha(request.getParameter("localDeRefeicaoEQuemCozinha"));
				ficha.setOleoPorMes(request.getParameter("oleoPorMes"));
				ficha.setAcucarPorMes(request.getParameter("acucarPorMes"));
				ficha.setFsAmilacidos(request.getParameter("fsAmilacidos"));
				ficha.setFsFritura(request.getParameter("fsFritura"));
				ficha.setFsFrutas(request.getParameter("fsFrutas"));
				ficha.setFsVerdSaladaLeg(request.getParameter("fsVerdSaladaLeg"));
				ficha.setFsCarnes(request.getParameter("fsCarnes"));
				ficha.setFsRefrigerante(request.getParameter("fsRefrigerante"));
				ficha.setFsBolachaChocBolo(request.getParameter("fsBolachaChocBolo"));
				ficha.setFsLeiteIogurte(request.getParameter("fsLeiteIogurte"));
				ficha.setFsLeguminosas(request.getParameter("fsLeguminosas"));
				ficha.setFsBebidaAlcoolica(request.getParameter("fsBebidaAlcoolica"));
				ficha.setConsumoLiquidos(request.getParameter("consumoLiquidos"));
				ficha.setAguaPorDia(request.getParameter("aguaPorDia"));
				ficha.setOutrosLiquidos(request.getParameter("outrosLiquidos"));
				ficha.setSuplementoVitaminicoAlimentar(request.getParameter("suplementoVitaminicoAlimentar"));
				ficha.setSuplementoVitaminicoAlimentarInformacoes(request.getParameter("suplementoVitaminicoAlimentarInformacoes"));
				ficha.setRecordatorioAlimentar(request.getParameter("recordatorioAlimentar"));
				ficha.setCondutaNutricional(request.getParameter("condutaNutricional"));
				
				AvaliacaoAntropometrica avaliacao = new AvaliacaoAntropometrica();
				avaliacao.setPesoUsual(Float.parseFloat(request.getParameter("pesoUsual").equals("")?"0":request.getParameter("pesoUsual")));					
				avaliacao.setPorcentagemGorduraUsual(Float.parseFloat(request.getParameter("gorduraUsual").equals("")?"0":request.getParameter("gorduraUsual")));
				avaliacao.setPesoIdeal(Float.parseFloat(request.getParameter("pesoIdeal").equals("")?"0":request.getParameter("pesoIdeal")));
				avaliacao.setPorcentagemGorduraIdeal(Float.parseFloat(request.getParameter("gorduraIdeal").equals("")?"0":request.getParameter("gorduraIdeal")));
				avaliacao.setPesoAtual(Float.parseFloat(request.getParameter("pesoAtual").equals("")?"0":request.getParameter("pesoAtual")));
				avaliacao.setPorcentagemGorduraAtual(Float.parseFloat(request.getParameter("gorduraAtual").equals("")?"0":request.getParameter("gorduraAtual")));
				avaliacao.setAltura(Float.parseFloat(request.getParameter("altura").equals("")?"0":request.getParameter("altura")));
				avaliacao.setCcd(Float.parseFloat(request.getParameter("ccd").equals("")?"0":request.getParameter("ccd")));
				avaliacao.setCce(Float.parseFloat(request.getParameter("cce").equals("")?"0":request.getParameter("cce")));
				avaliacao.setCbd(Float.parseFloat(request.getParameter("cbd").equals("")?"0":request.getParameter("cbd")));
				avaliacao.setCbe(Float.parseFloat(request.getParameter("cbe").equals("")?"0":request.getParameter("cbe")));
				avaliacao.setPregas(Float.parseFloat(request.getParameter("pregas").equals("")?"0":request.getParameter("pregas")));
				avaliacao.setCintura(Float.parseFloat(request.getParameter("cintura").equals("")?"0":request.getParameter("cintura")));
				avaliacao.setPeitoral(Float.parseFloat(request.getParameter("peitoral").equals("")?"0":request.getParameter("peitoral")));
				
				ficha.setAvaliacaoAntropometrica(avaliacao);	
				
				FichaDeAtendimentoNegocio fichaNegocio = new FichaDeAtendimentoNegocio();
				if(ficha.getIdFichaDeAtendimento() > 0){
					if(fichaNegocio.alterar(ficha)){
						msgSucesso = "Edição realizada com sucesso!";
						ficha = fichaNegocio.buscarUltimaFicha(ficha.getIdAtleta());
					}
				}else{
					ficha.setIdFichaDeAtendimento(fichaNegocio.inserir(ficha));
					if(ficha.getIdFichaDeAtendimento() > 0){
						msgSucesso = "Ficha de atendimento cadastrada com sucesso!";
						ficha.setDtAtendimento(new Date(System.currentTimeMillis()));
					}
				}
								
			}catch(Exception ex){
				msg = ex.getMessage();
			}
			
			try {
				//busca o atleta e calcula a idade
				int idAtleta = Integer.parseInt(request.getParameter("idAtleta"));
				AtletaNegocio atletaNegocio = new AtletaNegocio();
				atleta = atletaNegocio.buscarAtleta(idAtleta);
				strIdade = atleta.getStrIdade();
			} catch (Exception ex) {
				msg = ex.getMessage();
				
			}	
			
			request.setAttribute("msgAlerta", msg);
			request.setAttribute("msgSucesso", msgSucesso);
			request.setAttribute("fichaAtendimento", ficha);
			request.setAttribute("atleta", atleta);
			request.setAttribute("strIdade", strIdade);
			retorno = String.format("%s/NutricionistaFichaDeAtendimento.jsp", Constants.VIEW);			
		}else if("jspHistoricoAtendimento".equals(action)){
			String msg = "";
			String msgSucesso = "";
			int idAtleta = 0;
			Atleta atleta = null;
			HashMap<Integer, Date> listaAtendimentos = null;
			
			try{
				String id = request.getParameter("idAtleta");
				if(request.getParameter("idAtleta").equals("")){
					msg = "idAtleta inválido!";
				}else{
					idAtleta = Integer.parseInt(request.getParameter("idAtleta"));
					AtletaNegocio atletaNegocio = new AtletaNegocio();
					FichaDeAtendimentoNegocio fichaNegocio = new FichaDeAtendimentoNegocio();
					
					atleta = atletaNegocio.buscarAtleta(idAtleta);
					listaAtendimentos = fichaNegocio.buscarHistoricoAtendimento(idAtleta);
					
					//OBSERVAÇÕES ATIVAS/HISTORICO TAMBÉM DEVEM SER PUXADOS POR AQUI FUTURAMENTE(QUANDO FOREM IMPLEMENTADOS)!!! 
				}
			}catch(Exception ex){
				msg = ex.getMessage();
			}
			
			request.setAttribute("msgErro", msg);
			request.setAttribute("msgSucesso", msgSucesso);
			request.setAttribute("listaAtendimentos", listaAtendimentos);
			request.setAttribute("atleta", atleta);
			retorno = String.format("%s/NutricionistaHistoricoDeAtendimentos.jsp", Constants.VIEW);	
			
			
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
