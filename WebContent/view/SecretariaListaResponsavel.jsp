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
							Buscar Responsáveis
						</h3>
						<form role="form" action="SecretariaListaResponsavel.jsp">
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
				
				<div class="col-md-2 column">
				</div>
				<div class="col-md-8 column">
					<h3 class="text-center">
							Responsáveis Encontrados
					</h3>
					<table class="table">
					<thead>
						<tr>
							<th>
								Nome Pai
							</th>
							<th>
								Nome Mãe
							</th>
							<th>
							</th>
							<th>
							</th>
							<th>
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								Pai 1
							</td>
							<td>
								Mãe 1
							</td>
							<td>
								<a href="SecretariaNovoResponsavel.jsp">Editar</a>
							</td>
							<td>
								<a data-toggle="modal" href="#detalhes">Detalhes</a>
							</td>
							<td>
								<a data-toggle="modal" href="#deletar">Deletar</a>
							</td>
						</tr>
						<tr>
							<td>
								Pai 2
							</td>
							<td>
								Mãe 2
							</td>
							<td>
								<a href="SecretariaNovoResponsavel.jsp">Editar</a>
							</td>
							<td>
								<a data-toggle="modal" href="#detalhes">Detalhes</a>
							</td>
							<td>
								<a data-toggle="modal" href="#deletar">Deletar</a>
							</td>
						</tr>
						<tr>
							<td>
								Pai 3
							</td>
							<td>
								Mãe 3
							</td>
							<td>
								<a href="SecretariaNovoResponsavel.jsp">Editar</a>
							</td>
							<td>
								<a data-toggle="modal" href="#detalhes">Detalhes</a>
							</td>
							<td>
								<a data-toggle="modal" href="#deletar">Deletar</a>
							</td>
						</tr>
						<tr>
							<td>
								Pai 4
							</td>
							<td>
								Mãe 4
							</td>
							<td>
								<a href="SecretariaNovoResponsavel.jsp">Editar</a>
							</td>
							<td>
								<a data-toggle="modal" href="#detalhes">Detalhes</a>
							</td>
							<td>
								<a data-toggle="modal" href="#deletar">Deletar</a>
							</td>
						</tr>
						<tr>
							<td>
								Pai 5<br>
							</td>
							<td>
								Mãe 5
							</td>
							<td>
								<a href="SecretariaNovoResponsavel.jsp">Editar</a>
							</td>
							<td>
								<a data-toggle="modal" href="#detalhes">Detalhes</a>
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
							<a href="#">Próximo</a>
						</li>
					</ul>
				</div>
				<div class="col-md-2 column">
				</div>
			</div>
		</div>
	</div>	
	
	<div class="modal fade" id="detalhes" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Detalhes Atleta</h4>
				</div>
				<div class="modal-body">
					Nome: Responsável X<br/>
					Grau de Parentesco: Pai<br/>
					Email: xxxxx@xxxx.com<br/>
					Telefone Residencial: 9999-9999<br/>
					Telefone Celular: 9999-9999<br/>
					Telefone Comercial: 9999-9999<br/>
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