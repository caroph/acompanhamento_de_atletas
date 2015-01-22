	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationSecretaria.jsp'%>
				<div class="row clearfix">
					<div class="col-md-2 column"></div>
					<div class="col-md-8 column">
						<h3 class="text-center">
						Gerenciamento de Empréstimos de Uniforme ao Aluno(a)
						</h3>
						<p class="text-center">Incluir empréstimo/devolução</p>
						<hr/>
						<form class="form-horizontal" role="form">
							<div class="form-group">
								<label for="tipoOperacao" class="col-sm-3 control-label text-left">Tipo de Operação</label>
								<div class="col-sm-8">
									<div class="col-sm-1">
										<input type="radio" name="tpOperacao" class="form-control" id="opEmprestimo"/>
									</div>
									<label for="emprestimo" class="col-sm-2 control-label">Empréstimo</label>
									<div class="col-sm-2"></div>								
									<div class="col-sm-1">
										<input type="radio" name="tpOperacao" class="form-control" id="opDevolucao"/>
									</div>
									<label for="emprestimo" class="col-sm-2 control-label">Devolução</label>
									
								</div>
							</div>
						
							<table class="table">
								<tr>
									<th width="80%">Tipo</th>
									<th width="10%">Tamanho</th>
									<th width="10%">Quantidade</th>
								</tr>
								<tr>
									<td>Blusinha</td>
									<td><input type="text" class="form-control" id="tamanhoBlusinha"/></td>
									<td><input type="text" class="form-control" id="qtdeBlusinha"/></td>
								</tr>
								<tr>
									<td>Camiseta</td>
									<td><input type="text" class="form-control" id="tamanhoCamiseta"/></td>
									<td><input type="text" class="form-control" id="qtdeCamiseta"/></td>
								</tr>
								<tr>
									<td>Saia</td>
									<td><input type="text" class="form-control" id="tamanhoSaia"/></td>
									<td><input type="text" class="form-control" id="qtdeSaia"/></td>
								</tr>
								<tr>
									<td>Bermuda</td>
									<td><input type="text" class="form-control" id="tamanhoBermuda"/></td>
									<td><input type="text" class="form-control" id="qtdeBermuda"/></td>
								</tr>
								<tr>
									<td>Jaqueta</td>
									<td><input type="text" class="form-control" id="tamanhoJaqueta"/></td>
									<td><input type="text" class="form-control" id="qtdeJaqueta"/></td>
								</tr>
								<tr>
									<td>Calça</td>
									<td><input type="text" class="form-control" id="tamanhoCalca"/></td>
									<td><input type="text" class="form-control" id="qtdeCalca"/></td>
								</tr>																
							</table>

							<div class="form-group">
								 <label for="numero" class="col-sm-2 control-label text-left">Data</label>
								<div class="col-sm-10">
									<input type="number" class="form-control" id="data" />
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
	</div>
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>