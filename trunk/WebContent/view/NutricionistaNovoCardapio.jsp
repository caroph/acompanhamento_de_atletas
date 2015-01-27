	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationNutricionista.jsp'%>
				
				<div class="row clearfix">
					<div class="col-md-1 column">
					</div>
					<div class="col-md-10 column">
						<h3 class="text-center">
						Cadastro de Cardápio
						</h3>
						</hr>	
						<form role="form" >
							<div class="form-group col-md-12">
								<div class="form-group col-md-6">
									 <label for="exampleInputEmail1">Nome Cardápio</label>
									 <input type="email" class="form-control" id="exampleInputEmail1" />
								 </div>
								 <div class="form-group col-md-6">
								 	<label for="exampleInputEmail1">Tipo</label>
								 	<div>
										<label class="radio-inline">
										  <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"> Genérico
										</label>
										<label class="radio-inline">
										  <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> Personalizado
										</label>
									</div>
								</div>
							</div>
							<div class="form-group col-md-12">
								<div class="form-group col-md-6">
									 <label for="exampleInputEmail1">Período</label>
									 <div>
										 <select class="form-control" name="" id="">
								 			<option value="">Selecione</option>
											<option value="">Desjejum</option>
											<option value="pai">Colação</option>
											<option value="mae">Almoço</option>
											<option value="outro">Lanche I</option>
											<option value="outro">Lanche II</option>
											<option value="outro">Lanche III</option>
											<option value="outro">Jantar</option>
											<option value="outro">Ceia</option>
											<option value="outro">Pré Treino</option>
											<option value="outro">Pós Treino</option>
									 	</select>
									 </div>
								 </div>
								 <div class="form-group col-md-6">
								 	<label for="exampleInputEmail1">Horário</label>
								 	<input type="email" class="form-control" id="exampleInputEmail1" />
								</div>
							</div>
							<div class="form-group col-md-12">
								<div class="form-group col-md-12">
									 <label for="exampleInputEmail1">Descrição</label>
									 <textarea class="form-control" id="message-text"></textarea>
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
			<!-- End Content -->
		</div>
	</div>
	
	
	<%@include file='../layout/footer.jsp'%>
	</html>
	</body>
