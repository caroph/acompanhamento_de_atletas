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
						Cadastro de Categoria de Avaliações Físicas
						</h3>
						<hr>	
						<form role="form" id="demoform">
							<div class="form-group col-md-12">
								<div class="form-group col-md-4">
									 <label for="exampleInputEmail1">Idade Mínima</label>
									 <input type="number" class="form-control" id="exampleInputEmail1" />
								</div>
								<div class="form-group col-md-4">
									 <label for="exampleInputEmail1">Idade Máxima</label>
									 <input type="number" class="form-control" id="exampleInputEmail1" />
								</div>
							 	<div class="form-group col-md-4">
									 <label for="exampleInputEmail1">Sexo</label>
									 <div>
										 <select class="form-control" name="" id="">
										 	<option>Selecione</option>
											<option>Masculino</option>
											<option>Feminino</option>
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