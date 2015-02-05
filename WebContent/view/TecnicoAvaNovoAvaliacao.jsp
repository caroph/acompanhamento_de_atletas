	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationTecnico.jsp'%>
				<div class="row clearfix">
					<div class="col-md-3 column">
					</div>
					<div class="col-md-6 column">
						<h3 class="text-center">Cadastro de Avalia��o F�sica</h3>
						<h5 class="text-center">Atleta 1 - 10/01/1994 - 21,1 Anos</h5>
						<hr>	
						<form role="form" id="demoform">
							<div class="form-group col-md-12">
								<div class="form-group col-md-6">
									 <label for="exampleInputEmail1">Data</label>
									 <input type="date" class="form-control" id="data"  />
								</div>
							 	<div class="form-group col-md-6">
									<label for="exampleInputEmail1">Caracter�stica</label>
									<div>
										 <select class="form-control" name="" id="">
										 	<option>In�cio de Ano</option>
											<option>In�cio de Temporada</option>
											<option>Pr� Interclubes</option>
									 	</select>
									 </div>
							 	</div>
							</div>
							<div class="form-group col-md-12">
								<table class="table">
							<tr>
								<th width="50%">Capacidade</th>
								<th width="35%" class="text-center">Teste</th>
								<th width="15%" class="text-center">Desempenho</th>
							</tr>
							<tr>
								<td>For�a Abdominal</td>
								<td class="text-center">Abdominal</td>
								<td><input type="text" width="10%" class="form-control text-center" value="" id="qtdeBlusinha"/></td>
							</tr>
							<tr>
								<td>For�a mmss</td>
								<td class="text-center">Flex�o de bra�o</td>
								<td><input type="text" width="10%" class="form-control text-center" value="" id="qtdeBlusinha"/></td>
							</tr>
							<tr>
								<td>Coordena��o</td>
								<td class="text-center">Escadinha</td>
								<td><input type="text" width="10%" class="form-control text-center" value="" id="qtdeBlusinha"/></td>
							</tr>
							<tr>
								<td>Agilidade</td>
								<td class="text-center">Aranha</td>
								<td><input type="text" width="10%" class="form-control text-center" value="" id="qtdeBlusinha"/></td>
							</tr>
						</table>
							</div>
							<div class="form-group col-md-12">
								<div class="col-sm-12 text-right">
									 <button type="submit" class="btn btn-primary">Salvar</button>
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-3 column">
					</div>
				</div>
			</div>
		</div>
	</div>	
	
	<%@include file="Modals.jsp"%>
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>