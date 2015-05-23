
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
														<a class="link-green" href="NutricionistaController?action=jspHistoricoAtendimento&idAtleta=${fichaAtendimento.idAtleta}"	style="margin-right: 5px;"><abbr title="Histórico de atendimentos"><i class="fa fa-large fa-folder-open"></i></abbr></a>
														<a class="link-green" href="NutricionistaController?action=jspFichaDeAtendimento&idAtleta=${fichaAtendimento.idAtleta}&idFichaDeAtendimento=0" style="margin-left: 5px;"><abbr title="Novo atendimento"><i class="fa fa-large fa-plus-circle"></i></abbr></a>
													</div>													
												</c:when>
												<c:otherwise>
													<c:if test="${fichaAtendimento.dtAtendimento != null}"> 
														<div class="col-sm-7 text-left">
															<h6>
																<b>Formulário preenchido com os dados do último atendimento, realizado em <fmt:formatDate value="${fichaAtendimento.dtAtendimento}" pattern="dd/MM/yyyy - HH:mm"/></b>
															</h6>
														</div>
														<div class="col-sm-5 text-right">
																<a class="link-green" href="NutricionistaController?action=jspHistoricoAtendimento&idAtleta=${fichaAtendimento.idAtleta}"	style="margin-right: 5px;"><abbr title="Histórico de atendimentos"><i class="fa fa-large fa-folder-open"></i></abbr></a>
														</div>
													</c:if>													
												</c:otherwise>
											</c:choose>
										</div>
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
											<hr/>
											<h4 class="text-center" style="margin: 0px 0px 0px 0px;">IDENTIFICAÇÃO</h4>
											<hr/>
											<div class="form-group">
												<div class="col-sm-6">
													<label for="nome" class="control-label text-left">Nome:</label>
													<input type="text" readonly class="form-control" id="nome" value="${atleta.nome}" />
												</div>
												<div class="col-sm-6" >
													<label for="email" class="control-label text-right">Email:</label>
													<input type="text" readonly class="form-control" id="email" value="${atleta.email}"/>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-4">
													<label for="dataNasc" class="control-label">Data de Nascimento:</label>
													<input type="date" readonly class="form-control" id="dataNasc" value="${atleta.dtNascimento}"/>
												</div>
												<div class="col-sm-4" >
													<label for="idade" class="control-label">Idade(anos e meses)</label>
													<input type="text" readonly class="form-control" id="idade" value="${strIdade}"/>
												</div>
												<div class="col-sm-4" >
													<label for="telefone" class="control-label">Telefone:</label>
													<input type="text" readonly class="form-control" id="telefone" value="${atleta.endereco.telefone}"/>
												</div>
											</div>
											<hr/>	
											<h4 id="dadosAntropometricos" class="text-center" style="margin: 0px 0px 0px 0px;">DADOS ANTROPOMÉTRICOS</h4>
											<div class="col-md-12"><hr/></div>	
											<div  id="exibeDadosAntropometricos" class="col-md-12" style="display: none;">	
												<div class="form-group">
													<div class="col-sm-3">
														<label for="cbd" class="control-label">CBD:</label>
														<input type="text" class="form-control text-center" id="cbd" name="cbd" value="${fichaAtendimento.avaliacaoAntropometrica.cbd > 0 ? fichaAtendimento.avaliacaoAntropometrica.cbd : 0.00}"/>
													</div>
													<div class="col-sm-3" >
														<label for="cbe" class="control-label">CBE:</label>
														<input type="text" class="form-control text-center" id="cbe"name="cbe" value="${fichaAtendimento.avaliacaoAntropometrica.cbe > 0 ? fichaAtendimento.avaliacaoAntropometrica.cbe : 0.00}"/>
													</div>
													<div class="col-sm-3" >
														<label for="ccd" class="control-label">CCD:</label>
														<input type="text" class="form-control text-center" id="ccd" name="ccd" value="${fichaAtendimento.avaliacaoAntropometrica.ccd > 0 ? fichaAtendimento.avaliacaoAntropometrica.ccd : 0.00}"/>
													</div>
													<div class="col-sm-3" >
														<label for="cce" class="control-label">CCE:</label>
														<input type="text" class="form-control text-center" id="cce" name="cce" value="${fichaAtendimento.avaliacaoAntropometrica.cce > 0 ? fichaAtendimento.avaliacaoAntropometrica.cce : 0.00}"/>
													</div>
												</div>
												<div class="form-group">
													<div class="col-sm-3">
														<label for="cintura" class="control-label">Cintura:</label>
														<input type="text" class="form-control text-center" id="cintura" name="cintura" value="${fichaAtendimento.avaliacaoAntropometrica.cintura > 0 ? fichaAtendimento.avaliacaoAntropometrica.cintura : 0.00}"/>
													</div>
													<div class="col-sm-3" >
														<label for="peitoral" class="control-label">Peitoral:</label>
														<input type="text" class="form-control text-center" id="peitoral" name="peitoral" value="${fichaAtendimento.avaliacaoAntropometrica.peitoral > 0 ? fichaAtendimento.avaliacaoAntropometrica.peitoral : 0.00}"/>
													</div>
													<div class="col-sm-3" >
														<label for="altura" class="control-label">Altura:</label>
														<input type="text" class="form-control text-center" id="altura" name="altura" value="${fichaAtendimento.avaliacaoAntropometrica.altura > 0 ? fichaAtendimento.avaliacaoAntropometrica.altura : 0.00}"/>
													</div>
													<div class="col-sm-3" >
														<label for="pregas" class="control-label">Pregas:</label>
														<input type="text" class="form-control text-center" id="pregas" name="pregas" value="${fichaAtendimento.avaliacaoAntropometrica.pregas > 0 ? fichaAtendimento.avaliacaoAntropometrica.pregas : 0.00}"/>
													</div>
												</div>
												<div class="form-group">
													<div class="col-sm-4">
														<label for="pesoUsual" class="control-label">Peso usual (passado)</label>
														<input type="text" class="form-control text-center" id="pesoUsual" name="pesoUsual" value="${fichaAtendimento.avaliacaoAntropometrica.pesoUsual > 0 ? fichaAtendimento.avaliacaoAntropometrica.pesoUsual : 0.00}"/>
													</div>
													<div class="col-sm-4" >
														<label for="pesoIdeal" class="control-label">Peso ideal (objetivo):</label>
														<input type="text" class="form-control text-center" id="pesoIdeal" name="pesoIdeal" value="${fichaAtendimento.avaliacaoAntropometrica.pesoIdeal > 0 ? fichaAtendimento.avaliacaoAntropometrica.pesoIdeal : 0.00}"/>
													</div>
													<div class="col-sm-4" >
														<label for="pesoAtual" class="control-label">Peso atual:</label>
														<input type="text" class="form-control text-center" id="pesoAtual" name="pesoAtual" value="${fichaAtendimento.avaliacaoAntropometrica.pesoAtual > 0 ? fichaAtendimento.avaliacaoAntropometrica.pesoAtual : 0.00}"/>
													</div>
												</div>
												<div class="form-group">
													<div class="col-sm-4">
														<label for="gorduraUsual" class="">% de gordura corporal (usual/passado):</label>
														<input type="text" class="form-control text-center" id="gorduraUsual"name="gorduraUsual" value="${fichaAtendimento.avaliacaoAntropometrica.porcentagemGorduraUsual > 0 ? fichaAtendimento.avaliacaoAntropometrica.porcentagemGorduraUsual : 0.00}"/>
													</div>
													<div class="col-sm-4" >
														<label for="gorduraIdeal" class="">% de gordura corporal ideal (objetivo):</label>
														<input type="text" class="form-control text-center" id="gorduraIdeal" name="gorduraIdeal" value="${fichaAtendimento.avaliacaoAntropometrica.porcentagemGorduraIdeal > 0 ? fichaAtendimento.avaliacaoAntropometrica.porcentagemGorduraIdeal : 0.00}"/>
													</div>
													<div class="col-sm-4" >
														<label for="gordura" class="">% de gordura corporal atual:</label>
														<input type="text" class="form-control text-center" id="gorduraAtual" name="gorduraAtual" value="${fichaAtendimento.avaliacaoAntropometrica.porcentagemGorduraAtual > 0 ? fichaAtendimento.avaliacaoAntropometrica.porcentagemGorduraAtual : 0.00}"/>
													</div>
												</div>
											</div>
											<hr/>	
											<h4 id="objetivoConsulta" style="margin: 0px 0px 0px 0px;" class="text-center">OBJETIVO PRINCIPAL DA CONSULTA</h4>
											<div class="col-md-12"><hr/></div>	
											<div id="exibeObjetivoConsulta" style="display: none;">
												<div class="form-group">
													<div class="col-sm-6">
														<label for="hma" class="">HMA:</label>
														<input type="text" class="form-control" name="hma" value="${fichaAtendimento.HMA}"/>
													</div>
													<div class="col-sm-6" >
														<label for="hmf" class="">HMF:</label>
														<input type="text" class="form-control" name="hmf" value="${fichaAtendimento.HMF}"/>
													</div>
												</div>
												<div class="form-group">
													<div class="col-sm-6">
														<label for="acompanhamento" class="">Acompanhamento nutricional anterior:</label>
														<input type="text" class="form-control" name="acompanhamentoAnterior" value="${fichaAtendimento.acompanhamentoAnterior}"/>
													</div>
													<div class="col-sm-6" >
														<label for="qtoTempo" class="">Duração:</label>
														<input type="text" class="form-control" name="duracaoAcompanhamentoAnterior" value="${fichaAtendimento.duracaoAcompanhamentoAnterior}"/>
													</div>
												</div>
												<div class="form-group">
													<div class="col-sm-12">
														<label class="col-sm-3">
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
														<label class="col-sm-3"> 
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
														<label class="col-sm-3"> 
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
														<label class="col-sm-3"> 
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
													<div class="col-sm-12">
														<label class="col-sm-3">
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
														<label class="col-sm-3">
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
														<label class="col-sm-3">
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
														<label class="col-sm-3">
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
												<div class="form-group">
													<div class="col-sm-4">
														<label for="habitoIntestinal" class="">Hábito intestinal:</label>
														<input type="text" class="form-control" name="habitoIntestinal" value="${fichaAtendimento.habitoIntestinal}"/>
													</div>
													<div class="col-sm-4" >
														<label for="examesRecentes" class=" ">Exames recentes: (glicemia, LDL e etc):</label>
														<input type="text" class="form-control" name="examesRecentes" value="${fichaAtendimento.examesRecentes}"/>
													</div>
													<div class="col-sm-4" >
														<label for="medicamentos" class="">Medicamentos:</label>
														<input type="text" class="form-control" name="medicamentos" value="${fichaAtendimento.medicamentos}"/>
													</div>
												</div>
											</div>
											<hr/>
											<h4 id="praticaAtividade" style="margin: 0px 0px 0px 0px;" class="text-center">PRÁTICA DE ATIVIDADE FÍSICA/ ESPORTE/ TREINO</h4>
											<div class="col-md-12"><hr/></div>
											<div id="exibePraticaAtividade" style="display: none;">
												<div class="form-group">
													<div class="col-sm-4">
														<label for="tipo" class=>Tipo:</label>
														<input type="text" class="form-control" name="tpPraticaAtividadeFisica" value="${fichaAtendimento.tpPraticaAtividadeFisica}"/>
													</div>
													<div class="col-sm-4" >
														<label for="frequencia" class=" ">Frequência:</label>
														<input type="text" class="form-control" name="frequenciaAtividadeFisica" value="${fichaAtendimento.frequenciaAtividadeFisica}"/>
													</div>
													<div class="col-sm-4" >
														<label for="intensidade" class=" ">Intensidade:</label>
														<input type="text" class="form-control" name="intensidadeAtividadeFisica" value="${fichaAtendimento.intensidadeAtividadeFisica}"/>
													</div>
												</div>
											</div>
											<hr/>
											<h4 id="avaliacaoDietetica" style="margin: 0px 0px 0px 0px;" class="text-center">AVALIAÇÃO DIETÉTICA</h4>
											<div class="col-md-12"><hr/></div>
											<div id="exibeAvaliacaoDietetica" style="display: none;">
												<div class="form-group">
													<div class="col-sm-6">
														<label for="intolerancia" class="">Intolerância ou alergia alimentar:</label>
														<input type="text" class="form-control" name="intoleranciaAlergiaAlimentar" value="${fichaAtendimento.intoleranciaAlergiaAlimentar}"/>
													</div>
													<div class="col-sm-6" >
														<label for="apetite" class=" ">Como é o seu apetite:</label>
														<input type="text" class="form-control" name="apetite" value="${fichaAtendimento.apetite}"/>
													</div>
												</div>
												<div class="form-group">
													<div class="col-sm-6">
														<label for="alimentosGosta" class=" ">Alimentos que mais gosta:</label>
														<input type="text" class="form-control" name="alimentosGosta" value="${fichaAtendimento.alimentosGosta}"/>
													</div>
													<div class="col-sm-6" >
														<label for="AlimentosNaoGosta" class=" ">Alimentos que não gosta:</label>
														<input type="text" class="form-control" name="alimentosNaoGosta" value="${fichaAtendimento.alimentosNaoGosta}"/>
													</div>
												</div>
												<div class="form-group">
													<div class="col-sm-6">
														<label for="oleo" class=" ">Óleo por mês:</label>
														<input type="text" class="form-control" name="oleoPorMes" value="${fichaAtendimento.oleoPorMes}"/>
													</div>
													<div class="col-sm-6" >
														<label for="acucar" class=" ">Açúcar por mês:</label>
														<input type="text" class="form-control" name="acucarPorMes" value="${fichaAtendimento.acucarPorMes}"/>
													</div>
												</div>
												<div class="form-group">
													<div class="col-sm-12">
														<label for="horariosFome" class=" ">Horários em que sente mais fome e alimentos procura:</label>
														<input type="text" class="form-control" name="hrFomeEAlimentos" value="${fichaAtendimento.hrFomeEAlimentos}"/>
													</div>
												</div>
												<div class="form-group">
													<div class="col-sm-12">
														<label for="localRefeicao" class=" ">Locais em que são feitas as refeições e quem cozinha em casa:</label>
														<input type="text" class="form-control" name="localDeRefeicaoEQuemCozinha" value="${fichaAtendimento.localDeRefeicaoEQuemCozinha}"/>
													</div>
												</div>
												<div class="form-group">
													<div class="col-sm-3">
														<label  class="col-sm-12 ">Alimento:</label>
														<label  class="col-sm-12"  style="line-height: 25px;">Amilácidos :</label>
														<label  class="col-sm-12 " style="line-height: 25px;">Fritura :</label>
														<label  class="col-sm-12 " style="line-height: 25px;">Frutas :</label>
														<label  class="col-sm-12 " style="line-height: 25px;">Verd/salada/leg :</label>
														<label  class="col-sm-12 " style="line-height: 25px;">Carnes :</label>
													</div>
													<div class="col-sm-3" >
														<label  class=" ">Frequência/semana:</label>
														<input class="form-control" type="text" name="fsAmilacidos" value="${fichaAtendimento.fsAmilacidos}">
														<input class="form-control" type="text" name="fsFritura" value="${fichaAtendimento.fsFritura}">
														<input class="form-control" type="text" name="fsFrutas" value="${fichaAtendimento.fsFrutas}">
														<input class="form-control" type="text" name="fsVerdSaladaLeg" value="${fichaAtendimento.fsVerdSaladaLeg}">
														<input class="form-control" type="text" name="fsCarnes" value="${fichaAtendimento.fsCarnes}">
													</div>
													<div class="col-sm-3" >
														<label  class="col-sm-12">Alimento:</label>
														<label  class="col-sm-12 " style="line-height: 25px;">Refrigerante :</label>
														<label  class="col-sm-12 " style="line-height: 25px;">Bolac, choc, bolo :</label>
														<label  class="col-sm-12 " style="line-height: 25px;">Leite/iogurte :</label>
														<label  class="col-sm-12 " style="line-height: 25px;">Leguminosas :</label>
														<label  class="col-sm-12 " style="line-height: 25px;">Bebida alcoólica :</label>
													</div>
													<div class="col-sm-3" >
														<label for="acucar" class=" ">Frequência/semana:</label>
														<input class="form-control" type="text" name="fsRefrigerante" value="${fichaAtendimento.fsRefrigerante}">
														<input class="form-control" type="text" name="fsBolachaChocBolo" value="${fichaAtendimento.fsBolachaChocBolo}">
														<input class="form-control" type="text" name="fsLeiteIogurte" value="${fichaAtendimento.fsLeiteIogurte}">
														<input class="form-control" type="text" name="fsLeguminosas" value="${fichaAtendimento.fsLeguminosas}">
														<input class="form-control" type="text" name="fsBebidaAlcoolica" value="${fichaAtendimento.fsBebidaAlcoolica}">
													</div>
												</div>
												<div class="form-group">
													<div class="col-sm-6">
														<label for="agua" class=" ">Quantidade de consumo de água por dia:</label>
														<input type="text" class="form-control" name="aguaPorDia" value="${fichaAtendimento.aguaPorDia}"/>
													</div>
													<div class="col-sm-6" >
														<label for="liquidos" class=" ">Quantidade de consumo de outros líquidos:</label>
														<input type="text" class="form-control" name="outrosLiquidos" value="${fichaAtendimento.outrosLiquidos}"/>
													</div>
												</div>
												<div class="form-group">
													<div class="col-sm-6">
														<label for="suplemento" class=" ">Uso de suplemento vitamínico/alimentar:</label>
														<input type="text" class="form-control" name="suplementoVitaminicoAlimentar" value="${fichaAtendimento.suplementoVitaminicoAlimentar}"/>
													</div>
													<div class="col-sm-6" >
														<label for="suplementoTempo" class=" ">Horário e frequência dia/semana: </label>
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
													<a href="NutricionistaController" class="btn btn-danger" data-confirm="Deseja realmente cancelar esse cadastro?">Cancelar</a>
													<button type="reset" class="btn btn-info" onclick="LimparCampos()">Limpar</button>
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
