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
						Cadastro de Atividades de Avaliações Físicas
						</h3>
						<hr>	
						<form role="form" id="demoform">
							<div class="form-group col-md-12">
								<div class="form-group col-md-4">
									 <label for="exampleInputEmail1">Capacidade</label>
									 <input type="email" class="form-control" id="exampleInputEmail1" />
								</div>
							 	<div class="form-group col-md-4">
									<label for="exampleInputEmail1">Teste</label>
									<input type="email" class="form-control" id="exampleInputEmail1" />
							 	</div>
							 	<div class="form-group col-md-4">
									 <label for="exampleInputEmail1">Categoria</label>
									 <div>
										 <select class="form-control" name="" id="">
										 	<option>Categoria 1 - Feminino</option>
											<option>Categoria 2 - Masculino</option>
											<option>Categoria 3 - Feminino</option>
									 	</select>
									 </div>
								 </div>
							</div>
							<div class="form-group col-md-12">
								<div class="form-group col-md-12" style="text-align: center">
									 <label for="exampleInputEmail1">Valores de Classificação</label>
								</div>
								<div class="form-group col-md-2" style="margin-left: 75px">
									 <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Atenção"/>
								</div>
								<div class="form-group col-md-2">
									 <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Melhorar"/>
								</div>
								<div class="form-group col-md-2">
									 <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Média"/>
								</div>
								<div class="form-group col-md-2">
									 <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Bom"/>
								</div>
								<div class="form-group col-md-2">
									 <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Excelente"/>
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