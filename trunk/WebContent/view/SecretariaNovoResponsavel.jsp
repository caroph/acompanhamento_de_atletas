	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationSecretaria.jsp'%>
				
				<div class="row clearfix">					
					<div class="col-md-12 column">
						<div class="row clearfix">
							<div class="col-md-1 column"></div>
							<div class="col-md-10 column">
								<h3 class="text-center">
								Cadastro de Responsável do Atleta
								</h3>
								<hr/>	
								<form class="form-horizontal" role="form">			
									<div class="form-group">
										 <label for="nomePai" class="col-sm-4 control-label">Nome</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="nomePai" />
										</div>
									</div>
									<div class="form-group">
										 <label for="grParentesco" class="col-sm-4 control-label">Grau de parentesco</label>
										<div class="col-sm-2">
											<select class="form-control" name="cbGrParentesco" id="cbGrParentesco">
												<option value="">Selecione</option>
												<option value="pai">Pai</option>
												<option value="mae">Mãe</option>
												<option value="outro">Outro</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										 <label for="emailPai" class="col-sm-4 control-label">Outros Grau de Parentesco:</label>
										<div class="col-sm-8">
											<input type="email" class="form-control" id="emailPai" />
										</div>
									</div>
									<div class="form-group">
										 <label for="emailPai" class="col-sm-4 control-label">Email</label>
										<div class="col-sm-8">
											<input type="email" class="form-control" id="emailPai" />
										</div>
									</div>
									<div class="form-group">
										 <label for="emailPai" class="col-sm-4 control-label">Endereço</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="enderecoPai" />
										</div>
									</div>
									<div class="form-group">
										 <label for="numeroPai" class="col-sm-4 control-label">Número</label>
										<div class="col-sm-8">
											<input type="number" class="form-control" id="numeroPai" />
										</div>
									</div>
									<div class="form-group">
										 <label for="complementoPai" class="col-sm-4 control-label">Complemento</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="complementoPai" />
										</div>
									</div>
									<div class="form-group">
										 <label for="emailPai" class="col-sm-4 control-label">Bairro</label>
										<div class="col-sm-8">
											<input type="email" class="form-control" id="emailPai" />
										</div>
									</div>
									<div class="form-group">
										<label for="nr" class="col-sm-4 control-label">Estado:</label>
										<div class="col-sm-3">
											<select class="form-control" name="estado" id="estado"> </select>
										</div>
										<label for="nr" class="col-sm-1 control-label">Cidade:</label>
										<div class="col-sm-4">
											<select class="form-control" name="cidade" id="cidade"> </select>
										</div>
									</div>
									<div class="form-group">
										 <label for="emailPai" class="col-sm-4 control-label">Endereço (Comercial)</label>
										<div class="col-sm-8">
											<input type="email" class="form-control" id="emailPai" />
										</div>
									</div>
									<div class="form-group">
										 <label for="complementoPai" class="col-sm-4 control-label">Complemento</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="complementoPai" />
										</div>
									</div>
									<div class="form-group">
										 <label for="emailPai" class="col-sm-4 control-label">Bairro</label>
										<div class="col-sm-8">
											<input type="email" class="form-control" id="emailPai" />
										</div>
									</div>
									<div class="form-group">
										<label for="nr" class="col-sm-4 control-label">Estado:</label>
										<div class="col-sm-3">
											<select class="form-control" name="estadoCom" id="estadoCom"> </select>
										</div>
										<label for="nr" class="col-sm-1 control-label">Cidade:</label>
										<div class="col-sm-4">
											<select class="form-control" name="cidadeCom" id="cidadeCom"> </select>
										</div>
									</div>
									<div class="form-group">
										 <label for="emailPai" class="col-sm-4 control-label">Telefone Residencial</label>
										<div class="col-sm-8">
											<input type="email" class="form-control" id="emailPai" />
										</div>
									</div>
									<div class="form-group">
										 <label for="emailPai" class="col-sm-4 control-label">Telefone Celular</label>
										<div class="col-sm-8">
											<input type="email" class="form-control" id="emailPai" />
										</div>
									</div>
									<div class="form-group">
										 <label for="emailPai" class="col-sm-4 control-label">Telefone Comercial</label>
										<div class="col-sm-8">
											<input type="email" class="form-control" id="emailPai" />
										</div>
									</div>
									
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10 text-right">
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
		</div>
	</div>	
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>