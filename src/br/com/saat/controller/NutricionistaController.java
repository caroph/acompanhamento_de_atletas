package br.com.saat.controller;

import java.io.IOException;
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
			
			//Verifica se abre a página jsp em modo de edição ou inserção
			if(request.getParameter("idFichaDeAtendimento").equals("0"))
				ficha.setIdFichaDeAtendimento(0); // seta o id para 0 -> edição
			
			request.setAttribute("msgAlerta", msg);
			request.setAttribute("msgSucesso", msgSucesso);
			request.setAttribute("fichaAtendimento", ficha);
			request.setAttribute("atleta", atleta);
			request.setAttribute("strIdade", strIdade);
			retorno = String.format("%s/NutricionistaFichaDeAtendimento.jsp", Constants.VIEW);
		
		}else if("novaFichaDeAtendimento".equals(action)){
			String msg = "";
			String msgSucesso = "";
			FichaDeAtendimento ficha = new FichaDeAtendimento();
			
			try{
				ficha.setIdFichaDeAtendimento(Integer.parseInt(request.getParameter("idFichaDeAtendimento")));
				ficha.setIdAtleta(Integer.parseInt(request.getParameter("idAtleta")));
				ficha.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
				ficha.setDtAtendimento(new Date(System.currentTimeMillis()));
				ficha.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
				ficha.setHMA(request.getParameter("hma"));
				ficha.setAcompanhamentoAnterior(request.getParameter("acompanhamentoAnterior"));
				ficha.setDuracaoAcompanhamentoAnterior(request.getParameter("duracaoAcompanhamentoAnterior"));
				ficha.setHMF(request.getParameter("hmf"));
				ficha.setFlObesidade(Boolean.parseBoolean(request.getParameter("flObesidade")));
				ficha.setFlDiabetes(Boolean.parseBoolean(request.getParameter("flDiabetes")));
				ficha.setFlHas(Boolean.parseBoolean(request.getParameter("flHas")));
				ficha.setFlDoencaCardiaca(Boolean.parseBoolean(request.getParameter("flDoencaCardiaca")));
				ficha.setFlColesterol(Boolean.parseBoolean(request.getParameter("flColesterol")));
				ficha.setFlGastrite(Boolean.parseBoolean(request.getParameter("flGastrite")));
				ficha.setFlAzia(Boolean.parseBoolean(request.getParameter("flAzia")));
				ficha.setFlDorAbdominal(Boolean.parseBoolean(request.getParameter("flDorAbdominal")));
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
				
				FichaDeAtendimentoNegocio fichaNegocio = new FichaDeAtendimentoNegocio();
				if(ficha.getIdFichaDeAtendimento() > 0){
					if(fichaNegocio.alterar(ficha))
						msgSucesso = "Edição realizada com sucesso!";
				}else{
					ficha.setIdFichaDeAtendimento(fichaNegocio.inserir(ficha));
					if(ficha.getIdFichaDeAtendimento() > 0)
						msgSucesso = "Ficha de atendimento cadastrada com sucesso!";
				}
			}catch(Exception ex){
				msg = ex.getMessage();
			}
			
			request.setAttribute("msgAlerta", msg);
			request.setAttribute("msgSucesso", msgSucesso);
			request.setAttribute("fichaAtendimento", ficha);
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
