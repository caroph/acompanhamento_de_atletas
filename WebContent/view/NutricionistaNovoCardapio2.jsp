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
						Cadastro de Card�pio
						</h3>
						</hr>	
						<form role="form" >
							<div class="form-group col-md-12">
								<div class="form-group col-md-6">
									 <label for="exampleInputEmail1">Nome Card�pio</label>
									 <input type="email" class="form-control" id="exampleInputEmail1" />
								 </div>
								 <div class="form-group col-md-6">
								 	<label for="exampleInputEmail1">Tipo</label>
								 	<div>
										<label class="radio-inline">
										  <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"> Gen�rico
										</label>
										<label class="radio-inline">
										  <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> Personalizado
										</label>
									</div>
								</div>
							</div>
							<div class="form-group col-md-12">
								<div class="form-group col-md-6">
									 <label for="exampleInputEmail1">Per�odo</label>
									 <div>
										 <select class="form-control" name="" id="">
								 			<option value="">Selecione</option>
											<option value="">Desjejum</option>
											<option value="pai">Cola��o</option>
											<option value="mae">Almo�o</option>
											<option value="outro">Lanche I</option>
											<option value="outro">Lanche II</option>
											<option value="outro">Lanche III</option>
											<option value="outro">Jantar</option>
											<option value="outro">Ceia</option>
											<option value="outro">Pr� Treino</option>
											<option value="outro">P�s Treino</option>
									 	</select>
									 </div>
								 </div>
								 <div class="form-group col-md-6">
								 	<label for="exampleInputEmail1">Hor�rio</label>
								 	<input type="email" class="form-control" id="exampleInputEmail1" />
								</div>
							</div>
							<div class="form-group col-md-12">
								<div class="form-group col-md-12">
									 <label for="exampleInputEmail1">Descri��o</label>
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
