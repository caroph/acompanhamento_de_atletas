	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationNutricionista.jsp'%>
				<div class="row clearfix">
					<div class="col-md-12 column">
						<div class="col-md-12">
							<h3>Última Ficha de Atendimento</h3>
						</div>
						<div class="col-md-12">
							<div class="col-md-6 text-left">
								<h6><b>Última Alteração - 02/02/2015 - 16:23</b></h6>
							</div>
							<div class="col-md-6 text-right">
								<a href="#" style="margin-right: 5px;">Histórico de Atendimentos</a>|<a href="#" style="margin-left: 5px;">Novo Atendimento</a>
							</div>
						</div>
						<div class="col-md-12" style="margin: 0px 0px 0px 0px;"><hr/></div>
						<h4 class="text-center" style="margin: 0px 0px 0px 0px;">IDENTIFICAÇÃO</h4>
						<div class="col-md-12">	<hr /></div>
						<form class="form-horizontal" role="form">
							<div class="col-md-12" style="margin:10px 0px 10px 0px;">
								<div class="col-md-6">
									<div class="col-md-2 text-left">
										<label for="nome" class="control-label text-left">Nome:</label>
									</div>
									<div class="col-md-10">
										<input type="text" readonly class="form-control" id="nome" value="Atleta XXX" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="col-md-2 text-left">
										<label for="email" class="control-label text-right">Email:</label>
									</div>
									<div class="col-md-10">
										<input type="text" readonly class="form-control" id="email" value="atleta@atleta.com.br"/>
									</div>
								</div>
							</div>
							<div class="col-md-12" style="margin:10px 0px 10px 0px;">
								<div class="col-md-6">
									<div class="col-md-4 text-left">
										<label for="dataNasc" class="control-label">Data de Nascimento:</label>
									</div>
									<div class="col-md-3 text-left">
										<input type="text" readonly class="form-control" id="dataNasc" value="00/00/0000"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="col-md-2 text-left">
										<label for="telefone" class="control-label">Telefone:</label>
									</div>
									<div class="col-md-4 text-left">
										<input type="text" readonly class="form-control" id="telefone" value="(000) 0000-0000"/>
									</div>
								</div>
							</div>
							<div class="col-md-12" style="margin:10px 0px 20px 0px;">
								<div class="col-md-6">
									<div class="col-md-4 text-left">
										<label for="idade" class="control-label">Idade(Anos e Meses)</label>
									</div>
									<div class="col-md-5">
										<input type="text" readonly class="form-control" id="idade" value="XX Anos e XX Meses"/>
									</div>
								</div>
								<div class="col-md-5">
								</div>
							</div>
							<div class="col-md-12"><hr/></div>		
							<h4 id="dadosAntropometricos" class="text-center" style="margin: 0px 0px 0px 0px;">DADOS ANTROPOMÉTRICOS</h4>
							<div class="col-md-12" style="margin: 0px 0px 0px 0px;"><hr/></div>
							
							<div class="col-md-12"><!--id="exideDadosAntropometricos"-->					
								<div class="col-md-12" style="margin:10px 0px 10px 0px;">
									<div class="col-md-6">
										<div class="col-md-8 text-left">
											<label for="pesoUsual" class="control-label">Peso usual e % de gordura usual/passado:</label>
										</div>
										<div class="col-md-4 text-left">
											<input type="text" readonly class="form-control" id="pesoUsual"/>
										</div>
									</div>
									<div class="col-md-6">
										<div class="col-md-1 text-left">
											<label for="cb" class="control-label">CB:</label>
										</div>
										<div class="col-md-2 text-left">
											<input type="text" readonly class="form-control" id="cb"/>
										</div>
									</div>
								</div>
								
								<div class="col-md-12" style="margin:10px 0px 10px 0px;">
									<div class="col-md-6">
										<div class="col-md-8 text-left">
											<label for="pesoIdeal" class="control-label">Peso e % de gordura "ideal" (objetivo):</label>
										</div>
										<div class="col-md-4 text-left">
											<input type="text" readonly class="form-control" id="pesoIdeal"/>
										</div>
									</div>
									<div class="col-md-6">
										<div class="col-md-1 text-left">
											<label for="cc" class="control-label">CC:</label>
										</div>
										<div class="col-md-2 text-left">
											<input type="text" readonly class="form-control" id="cc"/>
										</div>
									</div>
								</div>
								
								<div class="col-md-12" style="margin:10px 0px 10px 0px;">
									<div class="col-md-6">
										<div class="col-md-3 text-left">
											<label for="pesoAtual" class="control-label">Peso atual:</label>
										</div>
										<div class="col-md-3 text-left">
											<input type="text" readonly class="form-control" id="pesoAtual"/>
										</div>
									</div>
									<div class="col-md-6">
										<div class="col-md-1 text-left">
											<label for="ca" class="control-label">CA:</label>
										</div>
										<div class="col-md-2 text-left">
											<input type="text" readonly class="form-control" id="ca"/>
										</div>
									</div>
								</div>
								
								<div class="col-md-12" style="margin:10px 0px 10px 0px;">
									<div class="col-md-6">
										<div class="col-md-3 text-left">
											<label for="altura" class="control-label">Altura:</label>
										</div>
										<div class="col-md-3">
											<input type="text" readonly class="form-control" id="altura"/>
										</div>
									</div>
									<div class="col-md-6">
										<div class="col-md-2 text-left">
											<label for="pregas" class="control-label">Pregas:</label>
										</div>
										<div class="col-md-3 text-left">
											<input type="text" readonly class="form-control" id="pregas"/>
										</div>
									</div>
								</div>
								
								
								<div class="col-md-12" style="margin:10px 0px 20px 0px;">
									<div class="col-md-6">
										<div class="col-md-5 text-left">
											<label for="gordura" class="control-label">% de gordura corporal:</label>
										</div>
										<div class="col-md-2">
											<input type="text" readonly class="form-control" id="gordura"/>
										</div>
									</div>
								</div>								
							</div>
							<div class="col-md-12 text-right">
								<a href="#" style="margin-right: 5px;">Histórico de Avaliações</a>|<a href="#" style="margin-left: 5px;">Nova Avaliação Antropométrica</a>
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
							<h4 id="avaliacaoDietetica" style="margin: 0px 0px 0px 0px;" class="text-center">AVALIAÇÃO DIETÉ‰TICA</h4>
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
							<h4 id="recordatorioAlimentar" style="margin: 0px 0px 0px 0px;" class="text-center">RECORDATÁ“RIO ALIMENTAR 24H</h4>
							<div class="col-md-12"><hr/></div>
							<div id="exibeRecordatorio" style="display: none;">
								<table class="table">
									<thead>
										<tr>
											<th>Refeição</th>
											<th>Horário</th>
											<th>Alimento</th>
											<th>Quantidade</th>
										</tr>
									</thead>
								</table>
								<div class="form-group">
									<label for="cafe" class="col-sm-4 control-label">CAFÉ‰ DA MANHÃƒ</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" id="cafe"/>
									</div>
								</div>
								<div class="form-group">
									<label for="lancheManha" class="col-sm-4 control-label">LANCHE DA MANHÃƒ</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" id="lancheManha"/>
									</div>
								</div>
								<div class="form-group">
									<label for="almoco" class="col-sm-4 control-label">ALMOÃÇO</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" id="almoco"/>
									</div>
								</div>
								<div class="form-group">
									<label for="lancheTarde" class="col-sm-4 control-label">LANCHE DA TARDE</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" id="lancheTarde"/>
									</div>
								</div>
								<div class="form-group">
									<label for="jantar" class="col-sm-4 control-label">JANTAR</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" id="jantar"/>
									</div>
								</div>
								<div class="form-group">
									<label for="ceia" class="col-sm-4 control-label">CEIA</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" id="ceia"/>
									</div>
								</div>
							</div>
							<hr/>
							<h4 style="margin: 0px 0px 0px 0px;" class="text-center">CONDUTA NUTRICIONAL</h4>
							<div class="col-md-12"><hr/></div>
							<textarea rows="5" class="form-control"></textarea>
							<br/>
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
	
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>