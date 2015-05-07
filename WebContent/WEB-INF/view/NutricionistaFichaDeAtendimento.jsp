
	<%@include file='/layout/head.jsp'%>
	
	<body>
	
	<%@include file='/layout/header.jsp'%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
			
	<div id="main" class="container-fluid">
		<div class="row">
			<%@include file='/layout/navigationNutricionista.jsp'%>
			<!--Start Content-->
			<div id="content" class="col-xs-12 col-sm-10">
				<div id="ajax-content">
					<%@include file="Mensagem.jsp"%>
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<div class="box-name">
										<i class="fa  fa-list-alt"></i>
										<c:choose>
											<c:when test="${fichaAtendimento.idFichaDeAtendimento > 0}">
												<span>Ficha de atendimento</span>
											</c:when>
											<c:otherwise>
												<span>Nova ficha de atendimento</span>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="box-icons">
										<a class="expand-link">
											<i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<!-- CONTEÚDO -->
									<div class="row clearfix"> 
										<div class="col-sm-12">
											<c:choose>
												<c:when test="${fichaAtendimento.idFichaDeAtendimento > 0}">
													<div class="col-sm-8 text-left">
														<h6>
															<b>Atendimento realizado em <fmt:formatDate value="${fichaAtendimento.dtAtendimento}" pattern="dd/MM/yyyy - HH:mm"/></b>
														</h6>						
													</div>
													<div class="col-sm-4 text-right">
														<a href="NutricionistaController?action=jspHistoricoAtendimento&idAtleta=${fichaAtendimento.idAtleta}"	style="margin-right: 5px;">Histórico de Atendimentos</a>|<a	href="NutricionistaController?action=jspFichaDeAtendimento&idAtleta=${fichaAtendimento.idAtleta}&idFichaDeAtendimento=0" style="margin-left: 5px;">Novo Atendimento</a>
													</div>													
												</c:when>
												<c:otherwise>
													<c:if test="${fichaAtendimento.dtAtendimento != null}"> 
														<div class="col-sm-8 text-left">
															<h6>
																<b>Formulário preenchido com os dados do último atendimento, realizado em <fmt:formatDate value="${fichaAtendimento.dtAtendimento}" pattern="dd/MM/yyyy - HH:mm"/></b>
															</h6>
														</div>
														<div class="col-sm-4 text-right">
																<a href="NutricionistaController?action=jspHistoricoAtendimento&idAtleta=${fichaAtendimento.idAtleta}"	style="margin-right: 5px;">Histórico de Atendimentos</a>
														</div>
													</c:if>													
												</c:otherwise>
											</c:choose>
										</div>
										<div class="col-md-12" style="margin: 0px 0px 0px 0px;"><hr/></div>
										<h4 class="text-center" style="margin: 0px 0px 0px 0px;">IDENTIFICAÇÃO</h4>
										<div class="col-md-12">	<hr /></div>
										<form class="form-horizontal" role="form" action="NutricionistaController?action=novaFichaDeAtendimento" method="post">
											<c:choose>
												<c:when test="${fichaAtendimento.idFichaDeAtendimento > 0}">
													<input type="hidden" name="idFichaDeAtendimento" value="${fichaAtendimento.idFichaDeAtendimento}">
												</c:when>
												<c:otherwise>
													<input type="hidden" name="idFichaDeAtendimento" value="0">
												</c:otherwise>											
											</c:choose>
											<input type="hidden" name="idAtleta" value="${atleta.idPessoa}">
											<input type="hidden" name="idUsuario" value="${usuarioLogado.idPessoa}">										
											<input type="hidden" name="idAvaliacaoAntropometrica" value="${fichaAtendimento.avaliacaoAntropometrica.idAvaliacaoAntropometrica}">
											<div class="col-md-12" style="margin:10px 0px 10px 0px;">
												<div class="col-md-6">
													<div class="col-md-2 text-left">
														<label for="nome" class="control-label text-left">Nome:</label>
													</div>
													<div class="col-md-10">
														<input type="text" readonly class="form-control" id="nome" value="${atleta.nome}" />
													</div>
												</div>
												<div class="col-md-6">
													<div class="col-md-2 text-left">
														<label for="email" class="control-label text-right">Email:</label>
													</div>
													<div class="col-md-10">
														<input type="text" readonly class="form-control" id="email" value="${atleta.email}"/>
													</div>
												</div>
											</div>
											<div class="col-md-12" style="margin:10px 0px 10px 0px;">
												<div class="col-md-6">
													<div class="col-md-4 text-left">
														<label for="dataNasc" class="control-label">Data de Nascimento:</label>
													</div>
													<div class="col-md-3 text-left">
														<input type="date" readonly class="form-control" id="dataNasc" value="${atleta.dtNascimento}"/>
													</div>
												</div>
												<div class="col-md-6">
													<div class="col-md-2 text-left">
														<label for="telefone" class="control-label">Telefone:</label>
													</div>
													<div class="col-md-4 text-left">
														<input type="text" readonly class="form-control" id="telefone" value="${atleta.endereco.telefone}"/>
													</div>
												</div>
											</div>
											<div class="col-md-12" style="margin:10px 0px 20px 0px;">
												<div class="col-md-6">
													<div class="col-md-4 text-left">
														<label for="idade" class="control-label">Idade(Anos e Meses)</label>
													</div>
													<div class="col-md-5">
														<input type="text" readonly class="form-control" id="idade" value="${strIdade}"/>
													</div>
												</div>
												<div class="col-md-5">
												</div>
											</div>
											<div class="col-md-12"><hr/></div>		
											<h4 id="dadosAntropometricos" class="text-center" style="margin: 0px 0px 0px 0px;">DADOS ANTROPOMÉTRICOS</h4>
											<div class="col-md-12" style="margin: 0px 0px 0px 0px;"><hr/></div>
											<div  id="exibeDadosAntropometricos" class="col-md-12">	
												<div class="col-md-12" style="margin:10px 0px 10px 0px;">
													<div class="col-md-5">
														<div class="col-md-1 text-left">
															<label for="cbd" class="control-label">CBD:</label>
														</div>
														<div class="col-md-3 text-left">
															<input type="text" class="form-control text-center" id="cbd" name="cbd" value="${fichaAtendimento.avaliacaoAntropometrica.cbd > 0 ? fichaAtendimento.avaliacaoAntropometrica.cbd : 0.00}"/>
														</div>
														<div class="col-md-1 text-left">
															<label for="cbe" class="control-label">CBE:</label>
														</div>
														<div class="col-md-3 text-left">
															<input type="text" class="form-control text-center" id="cbe"name="cbe" value="${fichaAtendimento.avaliacaoAntropometrica.cbe > 0 ? fichaAtendimento.avaliacaoAntropometrica.cbe : 0.00}"/>
														</div>
													</div>
													<div class="col-md-7">
														<div class="col-md-3 text-left">
															<label for="pesoUsual" class="control-label">Peso (usual/passado)</label>
														</div>
														<div class="col-md-2 text-left">
															<input type="text" class="form-control text-center" id="pesoUsual" name="pesoUsual" value="${fichaAtendimento.avaliacaoAntropometrica.pesoUsual > 0 ? fichaAtendimento.avaliacaoAntropometrica.pesoUsual : 0.00}"/>
														</div>
														<div class="col-md-3 text-left">
															<label for="gorduraUsual" class="control-label">Porcentagem de gordura corporal (usual/passado):</label>
														</div>
														<div class="col-md-2 text-left">
															<input type="text" class="form-control text-center" id="gorduraUsual"name="gorduraUsual" value="${fichaAtendimento.avaliacaoAntropometrica.porcentagemGorduraUsual > 0 ? fichaAtendimento.avaliacaoAntropometrica.porcentagemGorduraUsual : 0.00}"/>
														</div>
													</div>
												</div>
												<div class="col-md-12" style="margin:10px 0px 10px 0px;">
													<div class="col-md-5">
														<div class="col-md-1 text-left">
															<label for="ccd" class="control-label">CCD:</label>
														</div>
														<div class="col-md-3 text-left">
															<input type="text" class="form-control text-center" id="ccd" name="ccd" value="${fichaAtendimento.avaliacaoAntropometrica.ccd > 0 ? fichaAtendimento.avaliacaoAntropometrica.ccd : 0.00}"/>
														</div>
														<div class="col-md-1 text-left">
															<label for="cce" class="control-label">CCE:</label>
														</div>
														<div class="col-md-3 text-left">
															<input type="text" class="form-control text-center" id="cce" name="cce" value="${fichaAtendimento.avaliacaoAntropometrica.cce > 0 ? fichaAtendimento.avaliacaoAntropometrica.cce : 0.00}"/>
														</div>
													</div>
													<div class="col-md-7">
														<div class="col-md-3 text-left">
															<label for="pesoIdeal" class="control-label">Peso "ideal" (objetivo):</label>
														</div>
														<div class="col-md-2 text-left">
															<input type="text" class="form-control text-center" id="pesoIdeal" name="pesoIdeal" value="${fichaAtendimento.avaliacaoAntropometrica.pesoIdeal > 0 ? fichaAtendimento.avaliacaoAntropometrica.pesoIdeal : 0.00}"/>
														</div>
														<div class="col-md-3 text-left">
															<label for="gorduraIdeal" class="control-label">Porcentagem de gordura "ideal" (objetivo):</label>
														</div>
														<div class="col-md-2 text-left">
															<input type="text" class="form-control text-center" id="gorduraIdeal" name="gorduraIdeal" value="${fichaAtendimento.avaliacaoAntropometrica.porcentagemGorduraIdeal > 0 ? fichaAtendimento.avaliacaoAntropometrica.porcentagemGorduraIdeal : 0.00}"/>
														</div>
													</div>
												</div>
												
												<div class="col-md-12" style="margin:10px 0px 10px 0px;">
													<div class="col-md-5">
														<div class="col-md-2 text-left">
															<label for="cintura" class="control-label">Cintura:</label>
														</div>
														<div class="col-md-2 text-left">
															<input type="text" class="form-control text-center" id="cintura" name="cintura" value="${fichaAtendimento.avaliacaoAntropometrica.cintura > 0 ? fichaAtendimento.avaliacaoAntropometrica.cintura : 0.00}"/>
														</div>
														<div class="col-md-2 text-left">
															<label for="peitoral" class="control-label">Peitoral:</label>
														</div>
														<div class="col-md-2 text-left">
															<input type="text" class="form-control text-center" id="peitoral" name="peitoral" value="${fichaAtendimento.avaliacaoAntropometrica.peitoral > 0 ? fichaAtendimento.avaliacaoAntropometrica.peitoral : 0.00}"/>
														</div>
													</div>
													<div class="col-md-7">
														<div class="col-md-3 text-left">
															<label for="pesoAtual" class="control-label">Peso atual:</label>
														</div>
														<div class="col-md-2 text-left">
															<input type="text" class="form-control text-center" id="pesoAtual" name="pesoAtual" value="${fichaAtendimento.avaliacaoAntropometrica.pesoAtual > 0 ? fichaAtendimento.avaliacaoAntropometrica.pesoAtual : 0.00}"/>
														</div>
														<div class="col-md-3 text-left">
															<label for="gordura" class="control-label">Porcentagem de gordura corporal atual:</label>
														</div>
														<div class="col-md-2">
															<input type="text" class="form-control text-center" id="gorduraAtual" name="gorduraAtual" value="${fichaAtendimento.avaliacaoAntropometrica.porcentagemGorduraAtual > 0 ? fichaAtendimento.avaliacaoAntropometrica.porcentagemGorduraAtual : 0.00}"/>
														</div>
													</div>
												</div>
												<div class="col-md-12" style="margin:10px 0px 25px 0px;">
													<div class="col-md-5">
														<div class="col-md-2 text-left">
															<label for="altura" class="control-label">Altura:</label>
														</div>
														<div class="col-md-2">
															<input type="text" class="form-control text-center" id="altura" name="altura" value="${fichaAtendimento.avaliacaoAntropometrica.altura > 0 ? fichaAtendimento.avaliacaoAntropometrica.altura : 0.00}"/>
														</div>
														<div class="col-md-2 text-left">
															<label for="pregas" class="control-label">Pregas:</label>
														</div>
														<div class="col-md-2 text-left">
															<input type="text" class="form-control text-center" id="pregas" name="pregas" value="${fichaAtendimento.avaliacaoAntropometrica.pregas > 0 ? fichaAtendimento.avaliacaoAntropometrica.pregas : 0.00}"/>
														</div>
													</div>		
													<div class="col-md-7">
													</div>											
												</div>
											</div>
											<hr/>	
											<h4 id="objetivoConsulta" style="margin: 0px 0px 0px 0px;" class="text-center">OBJETIVO PRINCIPAL DA CONSULTA</h4>
											<div class="col-md-12"><hr/></div>	
											<div id="exibeObjetivoConsulta" style="display: none;">
												<div class="form-group">
													<label for="hma" class="col-sm-4 control-label">HMA:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="hma" value="${fichaAtendimento.HMA}"/>
													</div>
												</div>
												<div class="form-group">
													<label for="acompanhamento" class="col-sm-4 control-label">Já procurou acompanhamento nutricional antes:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="acompanhamentoAnterior" value="${fichaAtendimento.acompanhamentoAnterior}"/>
													</div>
												</div>
												<div class="form-group">
													<label for="qtoTempo" class="col-sm-4 control-label">Quanto tempo:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="duracaoAcompanhamentoAnterior" value="${fichaAtendimento.duracaoAcompanhamentoAnterior}"/>
													</div>
												</div>
												<div class="form-group">
													<label for="hmf" class="col-sm-4 control-label">HMF:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="hmf" value="${fichaAtendimento.HMF}"/>
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-4 control-label"></label>
													<div class="col-sm-8">
														<div class="col-sm-3">
															<label class="col-md-12">
																<c:choose>
																	<c:when test="${fichaAtendimento.flObesidade == true}">
																		<input type="checkbox" name="flObesidade" checked/>
																	</c:when>
																	<c:otherwise>
																 		<input type="checkbox" name="flObesidade"/>
																 	</c:otherwise>
																</c:choose>															 	
																 Obesidade
															</label> 
															<label class="col-md-12"> 
																<c:choose>
																	<c:when test="${fichaAtendimento.flDiabetes == true}">
																		<input type="checkbox" name="flDiabetes" checked/>
																	</c:when>
																	<c:otherwise>
																 		<input type="checkbox" name="flDiabetes"/>
																 	</c:otherwise>
																</c:choose>
																Diabetes
															</label> 
															<label class="col-md-12"> 
																<c:choose>
																	<c:when test="${fichaAtendimento.flHas == true}">
																		<input type="checkbox" name="flHas" checked/>
																	</c:when>
																	<c:otherwise>
																 		<input type="checkbox" name="flHas"/>
																 	</c:otherwise>
																</c:choose>
																Has
															</label>
															<label class="col-md-12"> 
																<c:choose>
																	<c:when test="${fichaAtendimento.flDoencaCardiaca == true}">
																		<input type="checkbox" name="flDoencaCardiaca" checked/>
																	</c:when>
																	<c:otherwise>
																 		<input type="checkbox" name="flDoencaCardiaca"/>
																 	</c:otherwise>
																</c:choose>
																Doença Cardíaca
															</label> 
														</div>
														<div class="col-sm-3">
															<label class="col-md-12">
																<c:choose>
																	<c:when test="${fichaAtendimento.flColesterol == true}">
																		<input type="checkbox" name="flColesterol" checked/>
																	</c:when>
																	<c:otherwise>
																 		<input type="checkbox" name="flColesterol"/>
																 	</c:otherwise>
																</c:choose> 
																Colesterol
															</label> 
															<label class="col-md-12">
																<c:choose>
																	<c:when test="${fichaAtendimento.flGastrite == true}">
																		<input type="checkbox" name="flGastrite" checked/>
																	</c:when>
																	<c:otherwise>
																 		<input type="checkbox" name="flGastrite"/>
																 	</c:otherwise>
																</c:choose> 
																Gastrite
															</label>
															<label class="col-md-12">
																<c:choose>
																	<c:when test="${fichaAtendimento.flAzia == true}">
																		<input type="checkbox" name="flAzia" checked/>
																	</c:when>
																	<c:otherwise>
																 		<input type="checkbox" name="flAzia"/>
																 	</c:otherwise>
																</c:choose> 
																Azia
															</label>
															<label class="col-md-12">
																<c:choose>
																	<c:when test="${fichaAtendimento.flDorAbdominal == true}">
																		<input type="checkbox" name="flDorAbdominal" checked/>
																	</c:when>
																	<c:otherwise>
																 		<input type="checkbox" name="flDorAbdominal"/>
																 	</c:otherwise>
																</c:choose> 
																Dor abdominal
															</label>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label for="habitoIntestinal" class="col-sm-4 control-label">Hábito Intestinal:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="habitoIntestinal" value="${fichaAtendimento.habitoIntestinal}"/>
													</div>
												</div>
												<div class="form-group">
													<label for="examesRecentes" class="col-sm-4 control-label">Exames Recentes: (glicemia, LDL e etc):</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="examesRecentes" value="${fichaAtendimento.examesRecentes}"/>
													</div>
												</div>
												<div class="form-group">
													<label for="medicamentos" class="col-sm-4 control-label">Medicamentos:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="medicamentos" value="${fichaAtendimento.medicamentos}"/>
													</div>
												</div>
											</div>
											<hr/>
											<h4 id="praticaAtividade" style="margin: 0px 0px 0px 0px;" class="text-center">PRÁTICA DE ATIVIDADE FÍSICA/ ESPORTE/ TREINO</h4>
											<div class="col-md-12"><hr/></div>
											<div id="exibePraticaAtividade" style="display: none;">
												<div class="form-group">
													<label for="tipo" class="col-sm-4 control-label">Tipo:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="tpPraticaAtividadeFisica" value="${fichaAtendimento.tpPraticaAtividadeFisica}"/>
													</div>
												</div>
												<div class="form-group">
													<label for="frequencia" class="col-sm-4 control-label">Frequência:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="frequenciaAtividadeFisica" value="${fichaAtendimento.frequenciaAtividadeFisica}"/>
													</div>
												</div>
												<div class="form-group">
													<label for="intensidade" class="col-sm-4 control-label">Intensidade:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="intensidadeAtividadeFisica" value="${fichaAtendimento.intensidadeAtividadeFisica}"/>
													</div>
												</div>
											</div>
											<hr/>
											<h4 id="avaliacaoDietetica" style="margin: 0px 0px 0px 0px;" class="text-center">AVALIAÇÃO DIETÉTICA</h4>
											<div class="col-md-12"><hr/></div>
											<div id="exibeAvaliacaoDietetica" style="display: none;">
												<div class="form-group">
													<label for="intolerancia" class="col-sm-4 control-label">Intolerância ou alergia alimentar?</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="intoleranciaAlergiaAlimentar" value="${fichaAtendimento.intoleranciaAlergiaAlimentar}"/>
													</div>
												</div>
												<div class="form-group">
													<label for="alimentosGosta" class="col-sm-4 control-label">Alimentos que mais gosta?</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="alimentosGosta" value="${fichaAtendimento.alimentosGosta}"/>
													</div>
												</div>
												<div class="form-group">
													<label for="AlimentosNaoGosta" class="col-sm-4 control-label">Alimentos que não gosta?</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="alimentosNaoGosta" value="${fichaAtendimento.alimentosNaoGosta}"/>
													</div>
												</div>
												<div class="form-group">
													<label for="apetite" class="col-sm-4 control-label">Como é o seu apetite?</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="apetite" value="${fichaAtendimento.apetite}"/>
													</div>
												</div>
												<div class="form-group">
													<label for="horariosFome" class="col-sm-4 control-label">Horários em que sente mais fome e quais alimentos você procura nestes momentos?</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="hrFomeEAlimentos" value="${fichaAtendimento.hrFomeEAlimentos}"/>
													</div>
												</div>
												<div class="form-group">
													<label for="localRefeicao" class="col-sm-4 control-label">Locais que são feitas as refeições? Quem cozinha em casa?</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="localDeRefeicaoEQuemCozinha" value="${fichaAtendimento.localDeRefeicaoEQuemCozinha}"/>
													</div>
												</div>
												<div class="form-group">
													<label for="oleo" class="col-sm-4 control-label">Óleo por mês:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="oleoPorMes" value="${fichaAtendimento.oleoPorMes}"/>
													</div>
												</div>
												<div class="form-group">
													<label for="acucar" class="col-sm-4 control-label">Açucar por mês:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="acucarPorMes" value="${fichaAtendimento.acucarPorMes}"/>
													</div>
												</div>
												<table class="table">
													<thead>
														<tr>
															<th class="text-center" width="30%">Alimento</th>
															<th class="text-center" width="20%">Frequência/Semana</th>
															<th class="text-center" width="30%">Alimento</th>
															<th class="text-center" width="20%">Frequência/Semana</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td>Amilácidos</td>
															<td><input class="form-control" type="text" name="fsAmilacidos" value="${fichaAtendimento.fsAmilacidos}"></td>
															<td>Refrigerante</td>
															<td><input class="form-control" type="text" name="fsRefrigerante" value="${fichaAtendimento.fsRefrigerante}"></td>
														</tr>
														<tr>
															<td>Fritura</td>
															<td><input class="form-control" type="text" name="fsFritura" value="${fichaAtendimento.fsFritura}"></td>
															<td>Bolac,choc, bolo</td>
															<td><input class="form-control" type="text" name="fsBolachaChocBolo" value="${fichaAtendimento.fsBolachaChocBolo}"></td>
														</tr>
														<tr>
															<td>Frutas</td>
															<td><input class="form-control" type="text" name="fsFrutas" value="${fichaAtendimento.fsFrutas}"></td>
															<td>Leite/Iogurte</td>
															<td><input class="form-control" type="text" name="fsLeiteIogurte" value="${fichaAtendimento.fsLeiteIogurte}"></td>
														</tr>
														<tr>
															<td>Verd/salada/leg</td>
															<td><input class="form-control" type="text" name="fsVerdSaladaLeg" value="${fichaAtendimento.fsVerdSaladaLeg}"></td>
															<td>Leguminosas</td>
															<td><input class="form-control" type="text" name="fsLeguminosas" value="${fichaAtendimento.fsLeguminosas}"></td>
														</tr>
														<tr>
															<td>Carnes</td>
															<td><input class="form-control" type="text" name="fsCarnes" value="${fichaAtendimento.fsCarnes}"></td>
															<td>Bebida alcoolica</td>
															<td><input class="form-control" type="text" name="fsBebidaAlcoolica" value="${fichaAtendimento.fsBebidaAlcoolica}"></td>
														</tr>
													</tbody>
												</table>
												<div class="form-group">
													<label for="agua" class="col-sm-4 control-label">Consumo de liquidos: quantidade de Água por dia:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="aguaPorDia" value="${fichaAtendimento.aguaPorDia}"/>
													</div>
												</div>
												<div class="form-group">
													<label for="liquidos" class="col-sm-4 control-label">Outros líquidos:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="outrosLiquidos" value="${fichaAtendimento.outrosLiquidos}"/>
													</div>
												</div>
												<div class="form-group">
													<label for="suplemento" class="col-sm-4 control-label">Uso de suplemento vitamínico/alimentar:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="suplementoVitaminicoAlimentar" value="${fichaAtendimento.suplementoVitaminicoAlimentar}"/>
													</div>
												</div>
												<div class="form-group">
													<label for="suplementoTempo" class="col-sm-4 control-label">Qual? Qual hoário? E quantas vezes no dia/semana?</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="suplementoVitaminicoAlimentarInformacoes" value="${fichaAtendimento.suplementoVitaminicoAlimentarInformacoes}"/>
													</div>
												</div>												
											</div>
											<hr/>
											<h4 id="recordatorioAlimentar" style="margin: 0px 0px 0px 0px;" class="text-center">RECORDATÁRIO ALIMENTAR 24H</h4>
											<div class="col-md-12"><hr/></div>
											<div id="exibeRecordatorio" style="display: none;">
												<div class="col-sm-12" style="margin: 0px 0px 20px 0px">
													<textarea class="form-control ckeditor" id="recordatorioAlim" name="recordatorioAlimentar">${fichaAtendimento.recordatorioAlimentar}</textarea>
												</div>
											</div>
											<hr/>
											<h4  id="condutaNutri" style="margin: 0px 0px 0px 0px;" class="text-center">CONDUTA NUTRICIONAL</h4>
											<div id="condutaNutric" style="display: none;">
												<div class="col-sm-12" style="margin: 20px 0px 20px 0px">
													<textarea class="form-control ckeditor" id="condutaNutricional" name="condutaNutricional">${fichaAtendimento.condutaNutricional}</textarea>
												</div>
											</div>
											<br/>
											<br/>
											<div class="form-group">
												<div class="col-sm-offset-2 col-sm-10 text-right">
													<button type="submit" class="btn btn-primary" >Salvar</button>
												</div>
											</div>											
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>		
				</div>
			</div>
			<!--End Content-->
		</div>
	</div>
	
	<%@include file="/layout/footer.jsp"%>

  </body>
</html>
