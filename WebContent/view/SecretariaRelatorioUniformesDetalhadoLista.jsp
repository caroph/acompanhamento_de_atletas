
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
						<!-- CONTEUDO -->
						<div class="col-sm-12">
							<div class="col-sm-12">
								<h3 class="text-center">
									<b>Relatório de Controle de Empréstimos</b>
								</h3>
							</div>
							<div class="col-sm-12">
								<h5 class="text-center">
									Relatório para controle de empréstimos por peça de roupa.
									Também é possível acessar o <a href="SecretariaUniforme.jsp">controle
										de empréstimos por atleta clicando aqui</a>
								</h5>
								<hr />
							</div>
						</div>
						<div class="col-sm-4">Selecione um tipo de peça</div>
						<div class="col-sm-8" style="margin-bottom: 25px;">
							<select id="selectInicio" class="form-control">
								<option selected value="#">Selecione</option>
								<option value="SecretariaRelatorioUniformesDetalhadoLista.jsp">Blusinha</option>
								<option value="SecretariaRelatorioUniformesDetalhadoLista.jsp">Camiseta</option>
								<option value="SecretariaRelatorioUniformesDetalhadoLista.jsp">Saia</option>
								<option value="SecretariaRelatorioUniformesDetalhadoLista.jsp">Bermuda</option>
								<option value="SecretariaRelatorioUniformesDetalhadoLista.jsp">Jaqueta</option>
								<option value="SecretariaRelatorioUniformesDetalhadoLista.jsp">Calça</option>
							</select>
						</div>
						<table class="table">
							<tr>
								<th colspan="7" class="text-center">****TIPO DE PEÇA
									SELECIONADO****</th>
							</tr>
							<tr>
								<th width="50%">Nome do Atleta</th>
								<th width="10%" class="text-center">PP</th>
								<th width="10%" class="text-center">P</th>
								<th width="10%" class="text-center">M</th>
								<th width="10%" class="text-center">G</th>
								<th width="10%" class="text-center">GG</th>
							</tr>
							<tr>
								<td>Atleta 01</td>
								<td align="center">0</td>
								<td align="center">4</td>
								<td align="center">0</td>
								<td align="center">0</td>
								<td align="center">0</td>
							</tr>
							<tr>
								<td>Atleta 02</td>
								<td align="center">0</td>
								<td align="center">0</td>
								<td align="center">0</td>
								<td align="center">5</td>
								<td align="center">0</td>
							</tr>
							<tr>
								<td>Atleta 03</td>
								<td align="center">0</td>
								<td align="center">0</td>
								<td align="center">0</td>
								<td align="center">10</td>
								<td align="center">0</td>
							</tr>
							<tr>
								<td>Atleta 04</td>
								<td align="center">2</td>
								<td align="center">0</td>
								<td align="center">0</td>
								<td align="center">0</td>
								<td align="center">0</td>
							</tr>
							<tr>
								<td>Atleta 05</td>
								<td align="center">0</td>
								<td align="center">0</td>
								<td align="center">0</td>
								<td align="center">0</td>
								<td align="center">7</td>
							</tr>
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
						<div class="col-sm-12 text-right">
							<hr />
							<button type="button" class="btn btn-primary"
								id="btnImprimirRelGeral" data-toggle="modal"
								data-target="#basicModal">Imprimir Relatório</button>
						</div>
					</div>
					<div class="col-md-2 column"></div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="basicModal" tabindex="-1" role="dialog"
			aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							id="fechar" aria-hidden="true">x</button>
						<h4 class="modal-title" id="myModalLabel">Imprimindo
							Relatório</h4>
					</div>
					<div class="modal-body">
						<div class="text-center">Imprimindo</div>
						<div class="progress" style="margin-top: 10px;" id="progress">
							<div class="progress-bar progress-bar-striped active"
								role="progressbar" aria-valuenow="100" aria-valuemin="0"
								aria-valuemax="100" style="width: 99%">99%</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							id="fechar">Fechar</button>
					</div>
				</div>
			</div>
		</div>
		<%@include file="../layout/footer.jsp"%>
</body>
</html>