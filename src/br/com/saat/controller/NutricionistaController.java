package br.com.saat.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JasperRunManager;
import br.com.saat.core.Constants;
import br.com.saat.enumeradores.Gravidade;
import br.com.saat.enumeradores.Perfis;
import br.com.saat.enumeradores.Refeicao;
import br.com.saat.model.Atleta;
import br.com.saat.model.AvaliacaoAntropometrica;
import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.Dieta;
import br.com.saat.model.FichaDeAtendimento;
import br.com.saat.model.Observacao;
import br.com.saat.model.Usuario;
import br.com.saat.model.negocio.AtletaNegocio;
import br.com.saat.model.negocio.DietaNegocio;
import br.com.saat.model.negocio.FichaDeAtendimentoNegocio;
import br.com.saat.model.negocio.ObservacaoNegocio;
import br.com.saat.model.negocio.RefeicaoNegocio;
import br.com.saat.model.negocio.UsuarioNegocio;

import com.google.gson.Gson;
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
		String servletRetorno = "/NutricionistaController?action=jspPaginaInicialNutricionista";
		
		//Verifica autenticação usuário
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(usuarioLogado == null || usuarioLogado.getPerfil() != Perfis.Nutricionista.getValor()){
			super.doPost(request, response, usuarioLogado, false, false);
			return;
		}
		
		ObservacaoNegocio obsNegocio = new ObservacaoNegocio();
		try{
			int notificacao = obsNegocio.buscarObservacoesNotificacao(usuarioLogado.getIdPessoa());
			request.setAttribute("notificacaoObs", notificacao);
		}catch(Exception ex){
			request.setAttribute("msgErro", ex.getMessage());
		}
		
		String retorno = null;
		String action = request.getParameter("action");
		
		if("jspPaginaInicialNutricionista".equals(action)){
			String msg = "";
			String msgSucesso = "";
			
			List<FichaDeAtendimento> listaUltimosAtendimentos = new ArrayList<FichaDeAtendimento>();
			try{
				//busca os ultimos atendimentos
				FichaDeAtendimentoNegocio fichaNegocio = new FichaDeAtendimentoNegocio();
				listaUltimosAtendimentos = fichaNegocio.buscarUltimosAtendimentos(usuarioLogado.getIdPessoa());
				if(!listaUltimosAtendimentos.isEmpty()){
					request.setAttribute("listaUltimosAtendimentos", listaUltimosAtendimentos);
				}else{
					request.setAttribute("msgAlerta", "Nenhum atendimento registrado.");
				}
			}catch(Exception ex){
				msg = ex.getMessage();
			}				
			
			request.setAttribute("msgErro", msg);
			request.setAttribute("msgSucesso", msgSucesso);
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
						
			request.setAttribute("msgErro", msg);
			request.setAttribute("msgSucesso", msgSucesso);
			request.setAttribute("fichaAtendimento", ficha);
			request.setAttribute("atleta", atleta);
			request.setAttribute("strIdade", strIdade);
			retorno = String.format("%s/NutricionistaFichaDeAtendimento.jsp", Constants.VIEW);
			servletRetorno = "/NutricionistaController?action=jspFichaDeAtendimento&idAtleta=" + 
				request.getParameter("idAtleta")+"&idFichaDeAtendimento=" + request.getParameter("idFichaDeAtendimento");
		
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
				
				Atleta a = new Atleta();
				a.setIdPessoa(ficha.getIdAtleta());
				String obs = ficha.getCondutaNutricional().replaceAll("\\<.*?>","").replaceAll("\r\n", "");//Jsoup.parse(ficha.getCondutaNutricional()).text();
				Observacao observacao = new Observacao(a, usuarioLogado, obs, 
						Gravidade.Baixa.getValor(), null, false);
				ObservacaoNegocio negocio = new ObservacaoNegocio();
				int idObservacao = negocio.salvarObservacao(observacao);
				observacao.setIdObservacao(idObservacao);
				
				UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
				List<Integer> usuarios = usuarioNegocio.buscarIdUsuarios(1);
				for (int idUsuario : usuarios) {
					negocio.salvarVisualizacaoObservacao(observacao.getIdObservacao(), idUsuario);
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
			
			if("".equals(msgSucesso)){
				request.setAttribute("msgErro", msg);
				request.setAttribute("fichaAtendimento", ficha);
				request.setAttribute("atleta", atleta);
				request.setAttribute("strIdade", strIdade);

				retorno = String.format("%s/NutricionistaFichaDeAtendimento.jsp", Constants.VIEW);		
				servletRetorno = "/NutricionistaController?action=jspFichaDeAtendimento&idAtleta=" + 
				request.getParameter("idAtleta")+"&idFichaDeAtendimento=" + request.getParameter("idFichaDeAtendimento");
		
			} else {
				
				AtletaNegocio negocio = new AtletaNegocio();
				List<Atleta> lista = new ArrayList<Atleta>();
						
				try{
					lista = negocio.buscarAtletas(1);
				}catch(Exception ex){
					request.setAttribute("msgErro", ex.getMessage());
				}
				
				request.setAttribute("msgSucesso", msgSucesso);
				request.setAttribute("listaAtletas", lista);
				retorno = String.format("%s/NutricionistaBuscaAtleta.jsp", Constants.VIEW);
				servletRetorno = "/NutricionistaController?action=jspBuscarAtletas";
			}
			
		}else if("jspHistoricoAtendimento".equals(action)){
			String msg = "";
			String msgSucesso = "";
			int idAtleta = 0;
			Atleta atleta = null;
			HashMap<Integer, Date> listaAtendimentos = null;
			
			try{
				if(request.getParameter("idAtleta").equals("")){
					msg = "idAtleta inválido!";
				}else{
					idAtleta = Integer.parseInt(request.getParameter("idAtleta"));
					AtletaNegocio atletaNegocio = new AtletaNegocio();
					FichaDeAtendimentoNegocio fichaNegocio = new FichaDeAtendimentoNegocio();
					
					atleta = atletaNegocio.buscarAtleta(idAtleta);
					listaAtendimentos = fichaNegocio.buscarHistoricoAtendimento(idAtleta);
					
					if(listaAtendimentos == null || listaAtendimentos.isEmpty()){
						request.setAttribute("msgAlerta", "Nenhum histórico disponível para esse atleta.");
					}
				}
			}catch(Exception ex){
				msg = ex.getMessage();
			}			
			
			request.setAttribute("msgErro", msg);
			request.setAttribute("msgSucesso", msgSucesso);
			request.setAttribute("listaAtendimentos", listaAtendimentos);
			request.setAttribute("atleta", atleta);
			retorno = String.format("%s/NutricionistaHistoricoDeAtendimentos.jsp", Constants.VIEW);	
			servletRetorno = "/NutricionistaController?action=jspHistoricoAtendimento&idAtleta=" + request.getParameter("idAtleta");
			
		}else if("imprimirFichaDeAtendimento".equals(action)){
			int idFicha = 0;
			FichaDeAtendimentoNegocio fichaNegocio = new FichaDeAtendimentoNegocio();
			AtletaNegocio atletaNegocio = new AtletaNegocio();
			FichaDeAtendimento ficha = null;
			Atleta atleta = null;
			try{				
				idFicha = Integer.parseInt(request.getParameter("idFichaDeAtendimento"));
				
				ficha = fichaNegocio.buscarPorId(idFicha);
				atleta = atletaNegocio.buscarAtleta(ficha.getIdAtleta());
				
				Connection con = ConnectionFactory.getConnection();
			
				HashMap parms = new HashMap();
				URL jasperURL = getServletContext().getResource("/relatorios/relatorioImprimirFichaDeAtendimento.jasper");
				String caminhoImg = getServletContext().getResource("/relatorios/brasao_cc.jpg").toString();
				
				parms.put("idFichaDeAtendimento", idFicha);
				parms.put("idadeAnosMeses", atleta.getStrIdade());
				parms.put("telefone", atleta.getEndereco().getTelefone());
				parms.put("caminhoLogo", caminhoImg);
				
				
				byte[] bytes = JasperRunManager.runReportToPdf(jasperURL.openStream(), parms, con);
				
				if(bytes != null){
					response.setContentType("application/pdf");
					OutputStream ops = response.getOutputStream();
					ops.write(bytes);
				}				
				
			}catch(Exception ex){
				HashMap<Integer, Date> listaAtendimentos = null;
				String msg = "";
				try{
					listaAtendimentos = fichaNegocio.buscarHistoricoAtendimento(atleta.getIdPessoa());
				}catch(Exception ex2){
					msg = "Erro: " + ex2.getMessage();
				}
				msg = "Erro ao gerar relatório! " + ex.getMessage();
				request.setAttribute("msgErro", msg);
				request.setAttribute("listaAtendimentos", listaAtendimentos);
				request.setAttribute("atleta", atleta);
				retorno = String.format("%s/NutricionistaHistoricoDeAtendimentos.jsp", Constants.VIEW);
				servletRetorno = "/NutricionistaController?action=jspHistoricoAtendimento";
			}
			
		} else if("jspDieta".equals(action)){ 
			DietaNegocio negocio = new DietaNegocio();
			List<Dieta> listaDieta = new ArrayList<Dieta>();
			Atleta atleta = new Atleta();
			try{
				atleta.setIdPessoa(Integer.parseInt(request.getParameter("idAtleta")));
				
				listaDieta = negocio.buscaDietas(atleta);
				if (listaDieta.isEmpty()) {
					request.setAttribute("msgAlerta", "Nenhuma dieta cadastrada!");
				}
			}catch(Exception ex){
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			RefeicaoNegocio refeicaoNegocio = new RefeicaoNegocio();
			List<Refeicao> listaRefeicao = refeicaoNegocio.listaRefeicao();
			
			request.setAttribute("listaRefeicao", listaRefeicao);
			request.setAttribute("listaDieta", listaDieta);
			request.setAttribute("atleta", atleta);
			retorno = String.format("%s/NutricionistaDieta.jsp", Constants.VIEW);
			servletRetorno = "/NutricionistaController?action=jspBuscarAtletas";
			
		} else if("novaDieta".equals(action)){ 
			int idAtleta = 0;
			int idDieta = 0;
			int idRefeicao = 0 ;
			boolean exception = false;
			String msgErro = "";
			String msgSucesso = "";
			String dataInicio = "";
			String dataFim = "";
			Date dtInicio = null;
			Date dtFim = null;
			
			Atleta atleta = new Atleta();
			Dieta dieta = new Dieta();
			DietaNegocio negocio = new DietaNegocio();
			
			try {
				idAtleta = Integer.parseInt(request.getParameter("idAtleta"));
				idDieta = Integer.parseInt(request.getParameter("idDieta"));
			} catch (Exception ex) {
				msgErro = "Ocorreu algum erro no sistema! Favor tentar novamente.";
				exception = true;
			}
			
			try {
				idRefeicao = Integer.parseInt(request.getParameter("refeicao"));
			} catch (Exception ex) {
				msgErro = "Favor selecionar corretamente o campo 'Refeição'.";
				exception = true;
			}
			
			try {
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				dataInicio = request.getParameter("dtValidadeInicio");
				dataFim = request.getParameter("dtValidadeFim");
				
				if (!"".equals(dataInicio)) {
					dtInicio = (Date) formatter.parse(dataInicio);
				}
				
				if (!"".equals(dataFim)) {
					dtFim = (Date) formatter.parse(dataFim);
				}
				
			} catch (Exception ex) {
				msgErro = "Favor verificar se os campos de 'Período de validade' foram corretamente informados.";
				exception = true;
			}
			
			if (!exception) {
				atleta.setIdPessoa(idAtleta);
				
				dieta.setIdDieta(idDieta);
				dieta.setAtleta(atleta);
				dieta.setUsuario(usuarioLogado);
				dieta.setRefeicao(idRefeicao);
				dieta.setCompeticao(Boolean.parseBoolean(String.valueOf(request.getParameter("competicao"))));
				dieta.setDtValidadeInicio(dtInicio);
				dieta.setDtValidadeFim(dtFim);
				dieta.setDescricao(request.getParameter("descricao"));
				
				List<Object> listaValidacao = negocio.validaDados(dieta);
				boolean valida = (boolean) listaValidacao.get(0);
				if (!valida) {
					msgErro = (String) listaValidacao.get(1);
				} else {
					
					try {
						if (idDieta == 0) {
							//Inserir
							if (negocio.inserir(dieta)){
								msgSucesso = "Dieta inserida com sucesso!";
							} else {
								msgErro = "Ocorreu algum erro ao inserir a dieta! Favor tentar novamente.";
							}
						} else {
							//Editar
							if (negocio.alterar(dieta)) {
								msgSucesso = "Dieta editada com sucesso!";
							} else {
								msgErro = "Ocorreu algum erro ao editar a dieta! Favor tentar novamente.";
							}
						}
					} catch (Exception e) {
						msgErro = e.getMessage();
					}
				}
			}
			
			if (!msgErro.equals("")) {
				request.setAttribute("msgErro", msgErro);
			} else {
				request.setAttribute("msgSucesso", msgSucesso);
			}
			
			//Carregar página de dietas
			List<Dieta> listaDieta = new ArrayList<Dieta>();
			try{
				listaDieta = negocio.buscaDietas(atleta);
				if (listaDieta.isEmpty()) {
					request.setAttribute("msgAlerta", "Nenhuma dieta cadastrada!");
				}
			}catch(Exception ex){
				request.setAttribute("msgAlerta", ex.getMessage());
			}
			
			RefeicaoNegocio refeicaoNegocio = new RefeicaoNegocio();
			List<Refeicao> listaRefeicao = refeicaoNegocio.listaRefeicao();
			
			request.setAttribute("listaRefeicao", listaRefeicao);
			request.setAttribute("listaDieta", listaDieta);
			request.setAttribute("atleta", atleta);
			retorno = String.format("%s/NutricionistaDieta.jsp", Constants.VIEW);
			servletRetorno = "/NutricionistaController?action=jspBuscarAtletas";
			
		} else if("jspEditarDieta".equals(action)){
			Dieta dieta = new Dieta();
			DietaNegocio negocio = new DietaNegocio();
			
			try{
				dieta.setIdDieta(Integer.parseInt(request.getParameter("idDieta")));
				dieta = negocio.buscaDieta(dieta);		
				
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				if (dieta.getDtValidadeInicio() != null && dieta.getDtValidadeFim()!= null) {
					dieta.setDtValidadeInicioDisplay(formatter.format(dieta.getDtValidadeInicio()));
					dieta.setDtValidadeFimDisplay(formatter.format(dieta.getDtValidadeFim()));
				}
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			RefeicaoNegocio refeicaoNegocio = new RefeicaoNegocio();
			List<String> listaRefeicao = refeicaoNegocio.listaRefeicaoString();
			
			Map<String, Object> lista = new LinkedHashMap<String, Object>();
			lista.put("listaRefeicao", listaRefeicao);
			lista.put("dieta", dieta);
		
			String json = new Gson().toJson(lista);
		
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			
		} else if("excluirDieta".equals(action)){ 
			Dieta dieta = new Dieta();
			DietaNegocio negocio = new DietaNegocio();
			
			try {
				dieta.setIdDieta(Integer.parseInt(request.getParameter("idDieta")));
				if (negocio.excluir(dieta)) {
					request.setAttribute("msgSucesso", "Dieta excluída com sucesso!");
				} else {
					request.setAttribute("msgErro", "Ocorreu algum erro no sistema! Favor tentar novamente.");
				}
			} catch (Exception ex) {
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			//Carregar página de dietas
			List<Dieta> listaDieta = new ArrayList<Dieta>();
			Atleta atleta = new Atleta();
			try{
				atleta.setIdPessoa(Integer.parseInt(request.getParameter("idAtleta")));
				listaDieta = negocio.buscaDietas(atleta);
				if (listaDieta.isEmpty()) {
					request.setAttribute("msgAlerta", "Nenhuma dieta cadastrada!");
				}
			}catch(Exception ex){
				request.setAttribute("msgAlerta", ex.getMessage());
			}
			
			RefeicaoNegocio refeicaoNegocio = new RefeicaoNegocio();
			List<Refeicao> listaRefeicao = refeicaoNegocio.listaRefeicao();
			
			request.setAttribute("listaRefeicao", listaRefeicao);
			request.setAttribute("listaDieta", listaDieta);
			request.setAttribute("atleta", atleta);
			retorno = String.format("%s/NutricionistaDieta.jsp", Constants.VIEW);
			servletRetorno = "/NutricionistaController?action=jspBuscarAtletas";
			
		} else if("imprimirDieta".equals(action)){ 
			int idAtleta = 0;
			Connection con = ConnectionFactory.getConnection();
			try{				
				idAtleta = Integer.parseInt(request.getParameter("idAtleta"));
				
				//URL jasperURL = new URL(host+jasper);
				URL jasperURL = getServletContext().getResource("/relatorios/dieta.jasper");
				HashMap parms = new HashMap();
				String caminhoImg = getServletContext().getResource("/relatorios/brasao_cc.jpg").toString();
				
				parms.put("idAtleta", idAtleta);
				parms.put("caminhoLogo", caminhoImg);
				
				byte[] bytes = JasperRunManager.runReportToPdf(jasperURL.openStream(), parms, con);
				
				if(bytes != null){
					response.setContentType("application/pdf");
					OutputStream ops = response.getOutputStream();
					ops.write(bytes);
				}				
			}catch(Exception ex){
				//Carregar página de dietas
				DietaNegocio negocio = new DietaNegocio();
				List<Dieta> listaDieta = new ArrayList<Dieta>();
				Atleta atleta = new Atleta();
				try{
					atleta.setIdPessoa(Integer.parseInt(request.getParameter("idAtleta")));
					listaDieta = negocio.buscaDietas(atleta);
					if (listaDieta.isEmpty()) {
						request.setAttribute("msgAlerta", "Nenhuma dieta cadastrada!");
					}
				}catch(Exception e){
					request.setAttribute("msgAlerta", e.getMessage());
				}
				
				RefeicaoNegocio refeicaoNegocio = new RefeicaoNegocio();
				List<Refeicao> listaRefeicao = refeicaoNegocio.listaRefeicao();
				
				request.setAttribute("listaRefeicao", listaRefeicao);
				request.setAttribute("listaDieta", listaDieta);
				
				request.setAttribute("msgErro", "Erro ao gerar relatório! Favor tente novamente.");
				retorno = String.format("%s/RelatorioResultTorneio.jsp", Constants.VIEW);
			}
		} else if("enviarDieta".equals(action)){ 
			Atleta atleta = new Atleta();
			DietaNegocio negocio = new DietaNegocio();
			
			try {
				atleta.setIdPessoa(Integer.parseInt(request.getParameter("idAtleta")));
				if (negocio.enviar(atleta)) {
					request.setAttribute("msgSucesso", "Dieta encaminhada aos responsáveis com sucesso!");
				} else {
					request.setAttribute("msgErro", "Ocorreu algum erro no sistema! Favor tentar novamente.");
				}
			} catch (Exception ex) {
				request.setAttribute("msgErro", ex.getMessage());
			}
			
			//Carregar página de dietas
			List<Dieta> listaDieta = new ArrayList<Dieta>();
			try{
				listaDieta = negocio.buscaDietas(atleta);
				if (listaDieta.isEmpty()) {
					request.setAttribute("msgAlerta", "Nenhuma dieta cadastrada!");
				}
			}catch(Exception ex){
				request.setAttribute("msgAlerta", ex.getMessage());
			}
			
			RefeicaoNegocio refeicaoNegocio = new RefeicaoNegocio();
			List<Refeicao> listaRefeicao = refeicaoNegocio.listaRefeicao();
			
			request.setAttribute("listaRefeicao", listaRefeicao);
			request.setAttribute("listaDieta", listaDieta);
			request.setAttribute("atleta", atleta);
			retorno = String.format("%s/NutricionistaDieta.jsp", Constants.VIEW);
			servletRetorno = "/NutricionistaController?action=jspBuscarAtletas";
			
		} else{
			retorno = "/NutricionistaController?action=jspPaginaInicialNutricionista";
			servletRetorno = "/NutricionistaController?action=jspPaginaInicialNutricionista";
		}
		
		if(retorno != null){
			session.setAttribute("pagina", servletRetorno);
			rd = getServletContext().getRequestDispatcher(retorno);
			rd.forward(request, response);
		}
	}

}
