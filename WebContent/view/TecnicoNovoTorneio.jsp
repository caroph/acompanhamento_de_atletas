	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationTecnico.jsp'%>
				<div class="row clearfix">
					<div class="col-md-1 column">
					</div>
					<div class="col-md-10 column">
						<h3 class="text-center">
						Cadastro de Torneio
						</h3>
						<hr>	
						<form role="form" id="demoform">
							<div class="form-group col-md-12">
								 <div class="form-group col-md-6">
									 <label for="exampleInputEmail1">Nome</label>
									 <input type="email" class="form-control" id="exampleInputEmail1" />
								 </div>
							 	<div class="form-group col-md-6">
									<label for="exampleInputEmail1">Local</label>
									<input type="email" class="form-control" id="exampleInputEmail1" />
							 	</div>
							</div>
							<div class="form-group col-md-12">
								 <div class="form-group col-md-6">
									 <label for="datade" class="control-label">Data Inicial</label>
									 <input type="date" class="form-control" id="datade" />
								 </div>
								 <div class="form-group col-md-6">
									<label for="dataate" class="control-label">Data Final</label>
									<input type="date" class="form-control" id="dataate" />
								</div>
							</div>
							<div class="form-group col-md-12">
								<div class="form-group col-md-6">
								 	<label for="exampleInputEmail1">Categoria</label>
								 	<input type="email" class="form-control" id="exampleInputEmail1" />
								</div>
								<div class="form-group col-md-6">
									 <label for="exampleInputEmail1">Naipe</label>
									 <div>
										 <select class="form-control" name="" id="">
								 			<option selected>Masculino e Feminino</option>
											<option>Masculino</option>
											<option>Feminino</option>
									 	</select>
									 </div>
								 </div>
							</div>
							<div class="form-group col-md-12">
								<div class="form-group col-md-12">
									 <label for="exampleInputEmail1">Atletas Participantes</label>
									 <div>
									     <select multiple="multiple" size="10" name="duallistbox_demo1[]">
										      <option value="option1">Atleta 1</option>
										      <option value="option2">Atleta 2</option>
										      <option value="option3" selected="selected">Atleta 3</option>
										      <option value="option4">Atleta 4</option>
										      <option value="option5">Atleta  5</option>
										      <option value="option6" selected="selected">Atleta 6</option>
										      <option value="option7">Atleta 7</option>
										      <option value="option8">Atleta 8</option>
										      <option value="option9">Atleta 9</option>
										      <option value="option0">Atleta 10</option>
									    </select>
									 </div>
								 </div>
							</div>
							<div class="form-group col-md-12">
								<div class="col-sm-12 text-right">
									 <button type="submit" class="btn btn-primary">Salvar</button>
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-1 column">
					</div>
				</div>
			</div>
		</div>
	</div>	
	

  
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>