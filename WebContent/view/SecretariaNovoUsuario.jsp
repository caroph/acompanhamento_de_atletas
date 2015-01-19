<%@include file='../layout/head.jsp'%>
</head>
<body>
<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<nav class="navbar navbar-default" role="navigation">
					<div class="navbar-header">
						 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="SecretariaAtleta.html">Secretaria</a>
					</div>					
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="active dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">Atleta<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li>
										<a href="SecretariaNovoAtleta.html">Novo</a>
									</li>
									<li>
										<a href="SecretariaAtleta.html">Buscar</a>
									</li>
								</ul>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">Responsáveis<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li>
										<a href="SecretariaNovoResponsavel.html">Novo</a>
									</li>
									<li>
										<a href="SecretariaResponsavel.html">Buscar</a>
									</li>
								</ul>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">Usuários<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li>
										<a href="SecretariaNovoUsuario.html">Novo</a>
									</li>
									<li>
										<a href="SecretariaUsuario.html">Buscar</a>
									</li>
								</ul>
							</li>
							<li>
								<a href="SecretariaUniforme.html">Uniformes</a>
							</li>
							<li class="dropdown">
								 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Relatórios<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li>
										<a href="#">Atletas</a>
									</li>
									<li class="divider">
									</li>
									<li>
										<a href="#">Uniformes</a>
									</li>
									<li class="divider">
									</li>
									<li>
										<a href="#">Torneios</a>
									</li>
								</ul>
							</li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
						</ul>
					</div>
					
				</nav>
				
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
										<option>Técnico Avaliador</option>
										<option>Psicólogo(a)</option>
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
								 <label for="email" class="col-sm-4 control-label">Email</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" id="email" />
								</div>
							</div>
							<div class="form-group">
								 <label for="endereco" class="col-sm-4 control-label">Endereço</label>
								<div class="col-sm-8">
									<input type="enderecoPai" class="form-control" id="endereco" />
								</div>
							</div>
							<div class="form-group">
								 <label for="numero" class="col-sm-4 control-label">Número</label>
								<div class="col-sm-8">
									<input type="number" class="form-control" id="numero" />
								</div>
							</div>
							<div class="form-group">
								 <label for="complemento" class="col-sm-4 control-label">Complemento</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="complemento" />
								</div>
							</div>
							<div class="form-group">
								 <label for="bairro" class="col-sm-4 control-label">Bairro</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" id="bairro" />
								</div>
							</div>
							<div class="form-group">
								<label for="estado" class="col-sm-4 control-label">Estado:</label>
								<div class="col-sm-3">
									<select class="form-control" name="estado" id="estado"> </select>
								</div>
								<label for="cidade" class="col-sm-1 control-label">Cidade:</label>
								<div class="col-sm-4">
									<select class="form-control" name="cidade" id="cidade"> </select>
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
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
	
  </body>
</html>