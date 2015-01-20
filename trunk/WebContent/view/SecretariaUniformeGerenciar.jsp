	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigation.jsp'%>
				<div class="row clearfix">
					<div class="col-md-2 column"></div>
					<div class="col-md-8 column">
						<h3 class="text-center">
						Gerenciamento de Empréstimos de Uniforme ao Aluno(a) .......
						</h3>
						<p>Incluir emprÃ©stimo/devoluÃ§Ã£o</p>
						<form class="form-horizontal" role="form">
							<div class="form-group">
								<label for="equipe" class="col-sm-4 control-label">Tipo:</label>
								<div class="col-sm-8">
									<select class="form-control" id="sel1">
										<option>Blusinha</option>
										<option>Camiseta</option>
										<option>Saia</option>
										<option>Bermuda</option>
										<option>Jaqueta</option>
										<option>CalÃ§a</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								 <label for="nome" class="col-sm-4 control-label">Tamanho</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="nome" />
								</div>
							</div>
							<div class="form-group">
								 <label for="email" class="col-sm-4 control-label">Quantidade</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" id="email" />
								</div>
							</div>
							<div class="form-group">
								 <label for="endereco" class="col-sm-4 control-label">Data Empréstimo</label>
								<div class="col-sm-8">
									<input type="enderecoPai" class="form-control" id="endereco" />
								</div>
							</div>
							<div class="form-group">
								 <label for="numero" class="col-sm-4 control-label">Data Devolução</label>
								<div class="col-sm-8">
									<input type="number" class="form-control" id="numero" />
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10 text-right">
									 <button type="submit" class="btn btn-primary">Salvar</button>
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-2 column">
					</div>
				</div>
				<div class="row clearfix">
					<div class="col-md-2 column">
					</div>
					<div class="col-md-8 column">
						<p>Histórico</p>
						<table class="table">
						<thead>
							<tr>
								<th>
									Tipo
								</th>
								<th>
									Tamanho
								</th>
								<th>
									Quantidade
								</th>
								<th>
									Data Empréstimo
								</th>
								<th>
									Data Devolução
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									Blusinha
								</td>
								<td>
									M
								</td>
								<td>
									02
								</td>
								<td>
									12/05/2014
								</td>
								<td>
								</td>
							</tr>
												<tbody>
							<tr>
								<td>
									Saia
								</td>
								<td>
									G
								</td>
								<td>
									01
								</td>
								<td>
									12/05/2014
								</td>
								<td>
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
	
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>