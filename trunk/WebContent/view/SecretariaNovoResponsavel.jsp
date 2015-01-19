<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<%@include file='../layout/navigation.jsp'%>
				
				<div class="row clearfix">					
					<div class="col-md-12 column">
						<div class="row clearfix">
							<div class="col-md-1 column"></div>
							<div class="col-md-10 column">
								<h3 class="text-center">
								Cadastro de Responsável do Atleta
								</h3>
								<form class="form-horizontal" role="form">
									<div class="form-group">
										<label class="col-sm-12 control-label" style="text-align:center">Dados do Pai</label>
									</div>
									<hr/>
									

									<div class="form-group">
										 <label for="nomePai" class="col-sm-4 control-label">Nome</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="nomePai" />
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
											<input type="enderecoPai" class="form-control" id="enderecoPai" />
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
											<select class="form-control" name="estado" id="estadoPai"> </select>
										</div>
										<label for="nr" class="col-sm-1 control-label">Cidade:</label>
										<div class="col-sm-4">
											<select class="form-control" name="cidade" id="cidadePai"> </select>
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
											<select class="form-control" name="estado" id="estadoPaiCom"> </select>
										</div>
										<label for="nr" class="col-sm-1 control-label">Cidade:</label>
										<div class="col-sm-4">
											<select class="form-control" name="cidade" id="cidadePaiCom"> </select>
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
									
									<!-- MÃE -->
									<div class="form-group">
										<label class="col-sm-12 control-label" style="text-align:center">Dados da Mãe</label> 
									</div>
									<hr/>
									<div class="form-group">
										<label for="nomeMae" class="col-sm-4 control-label">Nome</label>
										<div class="col-sm-8">											
											<input type="text" class="form-control" id="nomeMae" />
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
											<input type="enderecoPai" class="form-control" id="enderecoPai" />
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
											<select class="form-control" name="estado" id="estadoMae"> </select>
										</div>
										<label for="nr" class="col-sm-1 control-label">Cidade:</label>
										<div class="col-sm-4">
											<select class="form-control" name="cidade" id="cidadeMae"> </select>
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
											<select class="form-control" name="estado" id="estadoMaeCom"> </select>
										</div>
										<label for="nr" class="col-sm-1 control-label">Cidade:</label>
										<div class="col-sm-4">
											<select class="form-control" name="cidade" id="cidadeMaeCom"> </select>
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
									
									<!-- EMERGÊNCIA -->
									<div class="form-group">
										<label class="col-sm-12 control-label" style="text-align:center">Cadastro de Emergência</label> 
									</div>
									</hr>
									<div class="form-group">
										<label for="emailPai" class="col-sm-4 control-label">Nome Médico Responsável</label>
										<div class="col-sm-8">
											<input type="email" class="form-control" id="emailPai" />
										</div>
									</div>
									<div class="form-group">
										<label for="emailPai" class="col-sm-4 control-label">Telefone do Médico</label>
										<div class="col-sm-8">
											<input type="email" class="form-control" id="emailPai" />
										</div>
									</div>
									<div class="form-group">
										<label for="emailPai" class="col-sm-4 control-label">Convênio Médico Hospitalar</label>
										<div class="col-sm-8">
											<input type="email" class="form-control" id="emailPai" />
										</div>
									</div>
									<div class="form-group">
										<label for="emailPai" class="col-sm-4 control-label">Medicação autorizada a tomar em casa de dor</label>
										<div class="col-sm-8">
											<input type="email" class="form-control" id="emailPai" />
										</div>
									</div>
									<div class="form-group">
										<label for="emailPai" class="col-sm-4 control-label">Alérgico</label>
										<div class="col-sm-3">											
											<div class="checkbox">
												 <label><input type="checkbox" /> Sim</label>
												 <label><input type="checkbox" /> Não</label>
											</div>
										</div>
										<label for="emailPai" class="col-sm-1 control-label">Descrição</label>
										<div class="col-sm-4">
											<input type="email" class="form-control" id="emailPai" />
										</div>
									</div>
									<div class="form-group">
										<label for="emailPai" class="col-sm-4 control-label">Uso contínuo de medicação</label>
										<div class="col-sm-3">											
											<div class="checkbox">
												 <label><input type="checkbox" /> Sim</label>
												 <label><input type="checkbox" /> Não</label>
											</div>
										</div>
										<label for="emailPai" class="col-sm-1 control-label">Descrição</label>
										<div class="col-sm-4">
											<input type="email" class="form-control" id="emailPai" />
										</div>
									</div>
									<div class="form-group">
										<label for="emailPai" class="col-sm-4 control-label">Nome para emergência</label>
										<div class="col-sm-8">
											<input type="email" class="form-control" id="emailPai" />
										</div>
									</div>
									<div class="form-group">
										<label for="emailPai" class="col-sm-4 control-label">Telefone</label>
										<div class="col-sm-8">
											<input type="email" class="form-control" id="emailPai" />
										</div>
									</div>
									<div class="form-group">
										<label for="emailPai" class="col-sm-4 control-label">Grau de parentesco</label>
										<div class="col-sm-8">
											<input type="email" class="form-control" id="emailPai" />
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
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