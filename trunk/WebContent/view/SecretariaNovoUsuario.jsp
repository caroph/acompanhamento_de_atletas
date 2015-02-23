	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationSecretaria.jsp'%>
				<div class="row clearfix">
					<div class="col-md-1 column"></div>
					<div class="col-md-10 column">
						<h3 class="text-center">
						Cadastro de Usuário
						</h3>
						<form class="form-horizontal" role="form">
							<div class="form-group">
								<label for="equipe" class="col-sm-4 control-label">Perfil:</label>
								<div class="col-sm-8">
									<select class="form-control" id="sel1">
										<option>Secretário(a)</option>
										<option>Técnico</option>
										<option>Preparador Físico</option>
										<option>Psicóogo(a)</option>
										<option>Nutricionista</option>
										<option>Fisioterapeuta</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								 <label for="nome" class="col-sm-4 control-label">Nome</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="nome" />
								</div>
							</div>
							<div class="form-group">
								 <label for="nome" class="col-sm-4 control-label">CREF</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="nome" />
								</div>
							</div>
							<div class="form-group">
								 <label for="email" class="col-sm-4 control-label">Email</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="email" />
								</div>
							</div>
							<div class="form-group">
								 <label for="email" class="col-sm-4 control-label">Senha</label>
								<div class="col-sm-3">
									<input type="password" class="form-control" id="senha" />
								</div>
							</div>
							<div class="form-group">
								 <label for="email" class="col-sm-4 control-label">Confirmação de Senha</label>
								<div class="col-sm-3">
									<input type="password" class="form-control" id="confSenha" />
								</div>
							</div>
							<div class="form-group">
								 <label for="telresidencial" class="col-sm-4 control-label">Telefone Residencial</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" id="telresidencial" />
								</div>
							</div>
							<div class="form-group">
								 <label for="telcelular" class="col-sm-4 control-label">Telefone Celular</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" id="telcelular" />
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10 text-right">
									 <button type="submit" class="btn btn-primary">Salvar</button>
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-1 column"></div>
				</div>
			</div>
		</div>
	</div>	
	
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>