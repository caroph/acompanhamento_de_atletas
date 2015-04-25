
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
										<i class="fa  fa-info-circle"></i>
										<span>Ficha de atendimento</span>
									</div>
									<div class="box-icons">
										<a class="collapse-link">
											<i class="fa fa-chevron-up"></i>
										</a>
										<a class="expand-link">
											<i class="fa fa-expand"></i>
										</a>
										<a class="close-link">
											<i class="fa fa-times"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<!-- CONTEÚDO -->
									<div class="row clearfix"> 
										<div class="col-sm-12">
											<h3>Ficha de Atendimento</h3>
										</div>
										<div class="col-sm-12">
											<div class="col-sm-6 text-left">
												<h6>
													<b>Última Consulta - <fmt:formatDate value="${fichaAtendimento.dtAtendimento}" pattern="dd/MM/yyyy - HH:mm"/></b>
												</h6>
											</div>
											<div class="col-sm-6 text-right">
												<a href="#"	style="margin-right: 5px;">Histórico de Atendimentos</a>|<a	href="#" style="margin-left: 5px;">Novo Atendimento</a>
											</div>
										</div>
										<div class="col-md-12" style="margin: 0px 0px 0px 0px;"><hr/></div>
										<h4 class="text-center" style="margin: 0px 0px 0px 0px;">IDENTIFICAÇÃO</h4>
										<div class="col-md-12">	<hr /></div>
										<form class="form-horizontal" role="form" action="#">
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
															<input type="text" readonly class="form-control" id="cb" value="${fichaAtendimento.avaliacaoAntropometrica.cbd}"/>
														</div>
														<div class="col-md-1 text-left">
															<label for="cbe" class="control-label">CBE:</label>
														</div>
														<div class="col-md-3 text-left">
															<input type="text" readonly class="form-control" id="cbe" value="${fichaAtendimento.avaliacaoAntropometrica.cbe}"/>
														</div>
													</div>
													<div class="col-md-7">
														<div class="col-md-3 text-left">
															<label for="pesoUsual" class="control-label">Peso (usual/passado)</label>
														</div>
														<div class="col-md-2 text-left">
															<input type="text" readonly class="form-control" id="pesoUsual" value="${fichaAtendimento.avaliacaoAntropometrica.pesoUsual}"/>
														</div>
														<div class="col-md-3 text-left">
															<label for="gorduraUsual" class="control-label">Porcentagem de gordura corporal (usual/passado):</label>
														</div>
														<div class="col-md-2 text-left">
															<input type="text" readonly class="form-control" id="gorduraUsual" value="${fichaAtendimento.avaliacaoAntropometrica.porcentagemGorduraUsual}"/>
														</div>
													</div>
												</div>
												<div class="col-md-12" style="margin:10px 0px 10px 0px;">
													<div class="col-md-5">
														<div class="col-md-1 text-left">
															<label for="ccd" class="control-label">CCD:</label>
														</div>
														<div class="col-md-3 text-left">
															<input type="text" readonly class="form-control" id="ccd" value="${fichaAtendimento.avaliacaoAntropometrica.ccd}"/>
														</div>
														<div class="col-md-1 text-left">
															<label for="cce" class="control-label">CCE:</label>
														</div>
														<div class="col-md-3 text-left">
															<input type="text" readonly class="form-control" id="cce" value="${fichaAtendimento.avaliacaoAntropometrica.cce}"/>
														</div>
													</div>
													<div class="col-md-7">
														<div class="col-md-3 text-left">
															<label for="pesoIdeal" class="control-label">Peso "ideal" (objetivo):</label>
														</div>
														<div class="col-md-2 text-left">
															<input type="text" readonly class="form-control" id="pesoIdeal" value="${fichaAtendimento.avaliacaoAntropometrica.pesoIdeal}"/>
														</div>
														<div class="col-md-3 text-left">
															<label for="gorduraIdeal" class="control-label">Porcentagem de gordura "ideal" (objetivo):</label>
														</div>
														<div class="col-md-2 text-left">
															<input type="text" readonly class="form-control" id="gorduraIdeal" value="${fichaAtendimento.avaliacaoAntropometrica.porcentagemGorduraIdeal}"/>
														</div>
													</div>
												</div>
												
												<div class="col-md-12" style="margin:10px 0px 10px 0px;">
													<div class="col-md-5">
														<div class="col-md-2 text-left">
															<label for="cintura" class="control-label">Cintura:</label>
														</div>
														<div class="col-md-2 text-left">
															<input type="text" readonly class="form-control" id="cintura" value="${fichaAtendimento.avaliacaoAntropometrica.cintura}"/>
														</div>
														<div class="col-md-2 text-left">
															<label for="peitoral" class="control-label">Peitoral:</label>
														</div>
														<div class="col-md-2 text-left">
															<input type="text" readonly class="form-control" id="peitoral" value="${fichaAtendimento.avaliacaoAntropometrica.peitoral}"/>
														</div>
													</div>
													<div class="col-md-7">
														<div class="col-md-3 text-left">
															<label for="pesoAtual" class="control-label">Peso atual:</label>
														</div>
														<div class="col-md-2 text-left">
															<input type="text" readonly class="form-control" id="pesoAtual" value="${fichaAtendimento.avaliacaoAntropometrica.pesoAtual}"/>
														</div>
														<div class="col-md-3 text-left">
															<label for="gordura" class="control-label">Porcentagem de gordura corporal atual:</label>
														</div>
														<div class="col-md-2">
															<input type="text" readonly class="form-control" id="gordura" value="${fichaAtendimento.avaliacaoAntropometrica.porcentagemGorduraAtual}"/>
														</div>
													</div>
												</div>
												<div class="col-md-12" style="margin:10px 0px 25px 0px;">
													<div class="col-md-5">
														<div class="col-md-2 text-left">
															<label for="altura" class="control-label">Altura:</label>
														</div>
														<div class="col-md-2">
															<input type="text" readonly class="form-control" id="altura" value="${fichaAtendimento.avaliacaoAntropometrica.altura}"/>
														</div>
														<div class="col-md-2 text-left">
															<label for="pregas" class="control-label">Pregas:</label>
														</div>
														<div class="col-md-2 text-left">
															<input type="text" readonly class="form-control" id="pregas" value="${fichaAtendimento.avaliacaoAntropometrica.pregas}"/>
														</div>
													</div>		
													<div class="col-md-7">
													</div>											
												</div>
												<div class="col-md-12 text-right" style="margin:10px 0px 0px 0px;">
													<a href="#" style="margin-right: 5px;">Histórico de Avaliações</a>|<a href="#" style="margin-left: 5px;">Nova Avaliação Antropométrica</a>
												</div>									
											</div>
											<div class="col-md-12"><hr/></div>	
											<h4 id="objetivoConsulta" style="margin: 0px 0px 0px 0px;" class="text-center">OBJETIVO PRINCIPAL DA CONSULTA</h4>
											<div class="col-md-12"><hr/></div>	
											<div id="exibeObjetivoConsulta" style="display: none;">
												<div class="form-group">
													<label for="hma" class="col-sm-4 control-label">HMA:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="hma"/>
													</div>
												</div>
												<div class="form-group">
													<label for="acompanhamento" class="col-sm-4 control-label">Já procurou acompanhamento nutricional antes:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="acompanhamento"/>
													</div>
												</div>
												<div class="form-group">
													<label for="qtoTempo" class="col-sm-4 control-label">Quanto tempo:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="qtoTempo"/>
													</div>
												</div>
												<div class="form-group">
													<label for="hmf" class="col-sm-4 control-label">HMF:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="hmf"/>
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-4 control-label"></label>
													<div class="col-sm-8 form-inline">
														<div class="checkbox">
															 <label><input type="checkbox" /> Obesidade</label>
														</div>
														<div class="checkbox">
															 <label><input type="checkbox" /> Diabetes</label>
														</div>
														<div class="checkbox">
															 <label><input type="checkbox" /> Has</label>
														</div>
														<div class="checkbox">
															 <label><input type="checkbox" /> Doença Cardíaca</label>
														</div>
														<div class="checkbox">
															 <label><input type="checkbox" /> Colesterol</label>
														</div>
														<div class="checkbox">
															 <label><input type="checkbox" /> Gastrite</label>
														</div>
														<div class="checkbox">
															 <label><input type="checkbox" /> Azia</label>
														</div>
														<div class="checkbox">
															 <label><input type="checkbox" /> Dor abdominal</label>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label for="habitoIntestinal" class="col-sm-4 control-label">Hábito Intestinal:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="habitoIntestinal"/>
													</div>
												</div>
												<div class="form-group">
													<label for="examesRecentes" class="col-sm-4 control-label">Exames Recentes: (glicemia, LDL e etc):</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="examesRecentes"/>
													</div>
												</div>
												<div class="form-group">
													<label for="medicamentos" class="col-sm-4 control-label">Medicamentos:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="medicamentos"/>
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
														<input type="text" class="form-control" id="tipo"/>
													</div>
												</div>
												<div class="form-group">
													<label for="frequencia" class="col-sm-4 control-label">Frequência:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="frequencia"/>
													</div>
												</div>
												<div class="form-group">
													<label for="intensidade" class="col-sm-4 control-label">Intensidade:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="intensidade"/>
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
														<input type="text" class="form-control" id="intolerancia"/>
													</div>
												</div>
												<div class="form-group">
													<label for="alimentosGosta" class="col-sm-4 control-label">Alimentos que mais gosta?</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="alimentosGosta"/>
													</div>
												</div>
												<div class="form-group">
													<label for="AlimentosNaoGosta" class="col-sm-4 control-label">Alimentos que não gosta?</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="AlimentosNaoGosta"/>
													</div>
												</div>
												<div class="form-group">
													<label for="apetite" class="col-sm-4 control-label">Como é o seu apetite?</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="apetite"/>
													</div>
												</div>
												<div class="form-group">
													<label for="horariosFome" class="col-sm-4 control-label">Horários em que sente mais fome e quais alimentos você procura nestes momentos?</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="horariosFome"/>
													</div>
												</div>
												<div class="form-group">
													<label for="localRefeicao" class="col-sm-4 control-label">Locais que são feitas as refeições? Quem cozinha em casa?</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="localRefeicao"/>
													</div>
												</div>
												<div class="form-group">
													<label for="oleo" class="col-sm-4 control-label">Óleo por mês:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="oleo"/>
													</div>
												</div>
												<div class="form-group">
													<label for="acucar" class="col-sm-4 control-label">Açucar por mês:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="acucar"/>
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
															<td><input class="form-control" type="text"></td>
															<td>Refrigerante</td>
															<td><input class="form-control" type="text"></td>
														</tr>
														<tr>
															<td>Fritura</td>
															<td><input class="form-control" type="text"></td>
															<td>Bolac,choc, bolo</td>
															<td><input class="form-control" type="text"></td>
														</tr>
														<tr>
															<td>Frutas</td>
															<td><input class="form-control" type="text"></td>
															<td>Leite/Iogurte</td>
															<td><input class="form-control" type="text"></td>
														</tr>
														<tr>
															<td>Verd/salada/leg</td>
															<td><input class="form-control" type="text"></td>
															<td>Leguminosas</td>
															<td><input class="form-control" type="text"></td>
														</tr>
														<tr>
															<td>Carnes</td>
															<td><input class="form-control" type="text"></td>
															<td>Bebida alcoolica</td>
															<td><input class="form-control" type="text"></td>
														</tr>
													</tbody>
												</table>
												<div class="form-group">
													<label for="agua" class="col-sm-4 control-label">Consumo de liquidos: quantidade de Água por dia:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="agua"/>
													</div>
												</div>
												<div class="form-group">
													<label for="liquidos" class="col-sm-4 control-label">Outros líquidos:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="liquidos"/>
													</div>
												</div>
												<div class="form-group">
													<label for="suplemento" class="col-sm-4 control-label">Uso de suplemento vitamínico/alimentar:</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="suplemento"/>
													</div>
												</div>
												<div class="form-group">
													<label for="suplementoTempo" class="col-sm-4 control-label">Qual? Qual hoário? E quantas vezes no dia/semana?</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="suplementoTempo"/>
													</div>
												</div>
											</div>
											<hr/>
											<h4 id="recordatorioAlimentar" style="margin: 0px 0px 0px 0px;" class="text-center">RECORDATÁRIO ALIMENTAR 24H</h4>
											<div class="col-md-12"><hr/></div>
											<div id="exibeRecordatorio" style="display: none;">
												<div class="col-sm-12" style="margin: 0px 0px 20px 0px">
													<textarea class="form-control ckeditor" id="recordatorioAlim" name="recordatorioAlim"></textarea>
												</div>
											</div>
											<hr/>
											<h4 style="margin: 0px 0px 0px 0px;" class="text-center">CONDUTA NUTRICIONAL</h4>
											<div class="col-sm-12" style="margin: 20px 0px 20px 0px">
												<textarea class="form-control ckeditor" id="condutaNutricional" name="condutaNutricional"></textarea>
											</div>
											<br/>
											<br/>
											<div class="form-group">
												<div class="col-sm-offset-2 col-sm-10 text-right">
													<button type="submit" class="btn btn-primary">Salvar</button>
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
