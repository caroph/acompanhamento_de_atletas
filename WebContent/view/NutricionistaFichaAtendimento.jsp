	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationNutricionista.jsp'%>
				<div class="row clearfix">
					<div class="col-md-2 column">
					</div>
					<div class="col-md-8 column">
						<form class="form-horizontal" role="form">			
							<div class="form-group">
								<label for="data" class="col-sm-4 control-label">Data do Atendimento:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="data" />
								</div>
							</div>
							<hr/>
							<h4>IDENTIFICAÇÃO</h4>
							<div class="form-group">
								<label for="nome" class="col-sm-4 control-label">Nome:</label>
								<div class="col-sm-8">
									<input type="text" readonly class="form-control" id="nome" value="Atleta XXX"/>
								</div>
							</div>
							<div class="form-group">
								<label for="dataNasc" class="col-sm-4 control-label">Data de Nascimento:</label>
								<div class="col-sm-8">
									<input type="text" readonly class="form-control" id="dataNasc" value="00/00/0000"/>
								</div>
							</div>
							<div class="form-group">
								<label for="idade" class="col-sm-4 control-label">Idade:</label>
								<div class="col-sm-8">
									<input type="text" readonly class="form-control" id="idade" value="XX Anos"/>
								</div>
							</div>
							<div class="form-group">
								<label for="email" class="col-sm-4 control-label">Email:</label>
								<div class="col-sm-8">
									<input type="text" readonly class="form-control" id="email" value="atleta@atleta.com.br"/>
								</div>
							</div>
							<div class="form-group">
								<label for="telefone" class="col-sm-4 control-label">Telefone:</label>
								<div class="col-sm-8">
									<input type="text" readonly class="form-control" id="telefone" value="(000) 0000-0000"/>
								</div>
							</div>
							<hr/>
							<h4>OBJETIVO PRINCIPAL DA CONSULTA</h4>
							<div class="form-group">
								<label for="hma" class="col-sm-4 control-label">HMA:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="hma"/>
								</div>
							</div>
							<div class="form-group">
								<label for="acompanhamento" class="col-sm-4 control-label">Ja procurou acompanhamento nutricionista antes:</label>
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
							<hr/>
							<h4>PRÁTICA DE ATIVIDADE FÍSICA/ ESPORTE/ TREINO:</h4>
							<div class="form-group">
								<label for="tipo" class="col-sm-4 control-label">Tipo:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="tipo"/>
								</div>
							</div>
							<div class="form-group">
								<label for="frequencia" class="col-sm-4 control-label">Frequencia:</label>
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
							<hr/>
							<h4>AVALIAÇÃO DIETÉTICA:</h4>
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
						</form>
					</div>
					<div class="col-md-2 column">
					</div>
				</div>
			</div>
		</div>
	</div>	
	
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>