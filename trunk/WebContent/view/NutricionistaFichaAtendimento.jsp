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
							<h4>IDENTIFICA«√O</h4>
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
								<label for="acompanhamento" class="col-sm-4 control-label">Ja procurou acompanhamento nutricional antes:</label>
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
										 <label><input type="checkbox" /> DoenÁa CardÌaca</label>
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
								<label for="habitoIntestinal" class="col-sm-4 control-label">H·bito Intestinal:</label>
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
							<h4>PR¡ÅTICA DE ATIVIDADE FÕSICA/ ESPORTE/ TREINO:</h4>
							<div class="form-group">
								<label for="tipo" class="col-sm-4 control-label">Tipo:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="tipo"/>
								</div>
							</div>
							<div class="form-group">
								<label for="frequencia" class="col-sm-4 control-label">FrequÍncia:</label>
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
							<h4>AVALIA«√ÉO DIET…âTICA:</h4>
							<div class="form-group">
								<label for="intolerancia" class="col-sm-4 control-label">Intoler‚ncia ou alergia alimentar?</label>
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
								<label for="AlimentosNaoGosta" class="col-sm-4 control-label">Alimentos que n„o gosta?</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="AlimentosNaoGosta"/>
								</div>
							</div>
							<div class="form-group">
								<label for="apetite" class="col-sm-4 control-label">Como È o seu apetite?</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="apetite"/>
								</div>
							</div>
							<div class="form-group">
								<label for="horariosFome" class="col-sm-4 control-label">Hor·rios em que sente mais fome e quais alimentos vocÍ procura nestes momentos?</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="horariosFome"/>
								</div>
							</div>
							<div class="form-group">
								<label for="localRefeicao" class="col-sm-4 control-label">Locais que s„o feitas as refeiÁıes? Quem cozinha em casa?</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="localRefeicao"/>
								</div>
							</div>
							<div class="form-group">
								<label for="oleo" class="col-sm-4 control-label">”leo por mÍs:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="oleo"/>
								</div>
							</div>
							<div class="form-group">
								<label for="acucar" class="col-sm-4 control-label">AÁ˙car por mÍs:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="acucar"/>
								</div>
							</div>
							<table class="table">
								<thead>
									<tr>
										<th>Alimento</th>
										<th>FrequÍncia/Semana</th>
										<th>Alimento</th>
										<th>FrequÍncia/Semana</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Amil·cios</td>
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
								<label for="agua" class="col-sm-4 control-label">Consumo de lÌquidos: quantidade de ·gua por dia:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="agua"/>
								</div>
							</div>
							<div class="form-group">
								<label for="liquidos" class="col-sm-4 control-label">Outros lÌquidos:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="liquidos"/>
								</div>
							</div>
							<div class="form-group">
								<label for="suplemento" class="col-sm-4 control-label">Uso de suplemento vitamÌnico/alimentar:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="suplemento"/>
								</div>
							</div>
							<div class="form-group">
								<label for="suplementoTempo" class="col-sm-4 control-label">Qual? Qual hor·rio? E quantas vezes no dia/semana?</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="suplementoTempo"/>
								</div>
							</div>
							<hr/>
							<h4>RECORDAT¡ìRIO ALIMENTAR 24H</h4>
							<table class="table">
								<thead>
									<tr>
										<th>RefeiÁ„o</th>
										<th>Hor·rio</th>
										<th>Alimento</th>
										<th>Quantidade</th>
									</tr>
								</thead>
							</table>
							<div class="form-group">
								<label for="cafe" class="col-sm-4 control-label">CAF…â DA MANH√É</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="cafe"/>
								</div>
							</div>
							<div class="form-group">
								<label for="lancheManha" class="col-sm-4 control-label">LANCHE DA MANH√É</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="lancheManha"/>
								</div>
							</div>
							<div class="form-group">
								<label for="almoco" class="col-sm-4 control-label">ALMO«áO</label>
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
							<hr/>
							<h4>DADOS ANTROPOM…âTRICOS</h4>
							<div class="form-group">
								<label for="pesoUsual" class="col-sm-4 control-label">Peso usual e % de gordura usual/passado:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="pesoUsual"/>
								</div>
							</div>
							<div class="form-group">
								<label for="pesoIdeal" class="col-sm-4 control-label">Peso e % de gordura "ideal" (objetivo):</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="pesoIdeal"/>
								</div>
							</div>
							<div class="form-group">
								<label for="pesoAtual" class="col-sm-4 control-label">Peso atual:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="pesoAtual"/>
								</div>
							</div>
							<div class="form-group">
								<label for="altura" class="col-sm-4 control-label">Altura:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="altura"/>
								</div>
							</div>
							<div class="form-group">
								<label for="cb" class="col-sm-4 control-label">CB:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="cb"/>
								</div>
							</div>
							<div class="form-group">
								<label for="cc" class="col-sm-4 control-label">CC:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="cc"/>
								</div>
							</div>
							<div class="form-group">
								<label for="ca" class="col-sm-4 control-label">CA:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="ca"/>
								</div>
							</div>
							<div class="form-group">
								<label for="pregas" class="col-sm-4 control-label">Pregas:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="pregas"/>
								</div>
							</div>
							<div class="form-group">
								<label for="gordura" class="col-sm-4 control-label">% de gordura corporal:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="gordura"/>
								</div>
							</div>
							<hr/>
							<h4>CONDUTA NUTRICIONAL:</h4>
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
					<div class="col-md-2 column">
					</div>
				</div>
			</div>
		</div>
	</div>	
	
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>