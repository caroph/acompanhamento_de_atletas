	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationSecretaria.jsp'%>				
				
				<div class="row clearfix">
					<div class="col-md-3 column">
					</div>
					<div class="col-md-6 column">
						<h3 class="text-center">
							Buscar Usu�rios
						</h3>
						<form role="form" action="SecretariaListaUsuario.jsp">
						    <div class="input-group">
						      <input type="text" class="form-control form-search" id="search">
						      <span class="input-group-btn">
						        <button class="btn btn-default" type="submit">
						        	<i class="icon-large icon-search"></i></button>
						      </span>
						    </div>
						</form>
					</div>
					<div class="col-md-3 column">
					</div>
				</div>
				<div class="row clearfix">
					<div class="col-md-2 column"></div>
					<div class="col-md-8 column">
						<h3 class="text-center">
								Usu�rios Encontrados
						</h3>
						<table class="table">
						<thead>
							<tr>
								<th>
									Nome
								</th>
								<th>
									Perfil
								</th>
								<th></th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									Usu�rio 1
								</td>
								<td>
									T�cnico
								</td>
								<td>
									<a data-toggle="modal" href="#detalhes">Detalhes</a>
								</td>
								<td>
									<a href="SecretariaNovoUsuario.jsp">Editar</a>
								</td>
								<td>
									<a data-toggle="modal" href="#deletar">Deletar</a>
								</td>
							</tr>
							<tr>
								<td>
									Usu�rio 2
								</td>
								<td>
									Fisioterapeuta
								</td>
								<td>
									<a data-toggle="modal" href="#detalhes">Detalhes</a>
								</td>
								<td>
									<a href="SecretariaNovoUsuario.jsp">Editar</a>
								</td>
								<td>
									<a data-toggle="modal" href="#deletar">Deletar</a>
								</td>
							</tr>
							<tr>
								<td>
									Usu�rio 3
								</td>
								<td>
									Nutricionista
								</td>
								<td>
									<a data-toggle="modal" href="#detalhes">Detalhes</a>
								</td>
								<td>
									<a href="SecretariaNovoUsuario.jsp">Editar</a>
								</td>
								<td>
									<a data-toggle="modal" href="#deletar">Deletar</a>
								</td>
							</tr>
							<tr>
								<td>
									Usuario 4
								</td>
								<td>
									Psic�loga
								</td>
								<td>
									<a data-toggle="modal" href="#detalhes">Detalhes</a>
								</td>
								<td>
									<a href="SecretariaNovoUsuario.jsp">Editar</a>
								</td>
								<td>
									<a data-toggle="modal" href="#deletar">Deletar</a>
								</td>
							</tr>
							<tr>
								<td>
									Usuario 5
								</td>
								<td>
									Secret�rio
								</td>
								<td>
									<a data-toggle="modal" href="#detalhes">Detalhes</a>
								</td>
								<td>
									<a href="SecretariaNovoUsuario.jsp">Editar</a>
								</td>
								<td>
									<a data-toggle="modal" href="#deletar">Deletar</a>
								</td>
							</tr>
						</tbody>
						</table>
						<ul class="pagination">
							<li>
								<a href="#">Anterior</a>
							</li>
							<li>
								<a href="#">1</a>
							</li>
							<li>
								<a href="#">2</a>
							</li>
							<li>
								<a href="#">3</a>
							</li>
							<li>
								<a href="#">4</a>
							</li>
							<li>
								<a href="#">5</a>
							</li>
							<li>
								<a href="#">Pr�ximo</a>
							</li>
						</ul>
					</div>
					<div class="col-md-2 column"></div>
				</div>
			</div>
		</div>
	</div>	
	
		<div class="modal fade" id="detalhes" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
					<h4 class="modal-title" id="myModalLabel">Detalhes Usu�rio</h4>
					</div>
					<div class="modal-body">
						Nome: Usu�rio X<br/>
						Perfil: X<br/>
						Emial: xxxx@gmail.com<br/>
						Telefone Residencial: 333333333<br/>
						Telefone Celular: 99999999<br/>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal" id="fechar">Fechar</button>
					</div>
				</div>
			</div>
		</div>	
	
	<%@include file="Modals.jsp"%>
	
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>