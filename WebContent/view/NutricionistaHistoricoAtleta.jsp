
<%@include file='../layout/head.jsp'%>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationNutricionista.jsp'%>
				<div class="row clearfix">
					<div class="col-md-8"></div>
					<div class="col-md-4">
						<form role="form" action="#">
							<div class="input-group">
								<input type="text" class="form-control form-search" id="search">
								<span class="input-group-btn">
									<button class="btn btn-default" type="submit">
										<i class="icon-large icon-search"></i>
									</button>
								</span>
							</div>
						</form>
					</div>
					<div class="col-md-2 column"></div>
					<div class="col-md-8 column">
						<h3>Atleta: XXX</h3>
					</div>
					<div class="col-md-2 column"></div>
				</div>
				<div class="row clearfix">
					<div class="col-md-2 column"></div>
					<div class="col-md-8 column">
						<h3 class="text-center">Histórico de Atendimentos</h3>
						<hr />
					</div>
					<div class="col-md-2 column"></div>
				</div>
				<div class="row clearfix">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<table class="table">
							<thead>
								<tr>
									<th class="text-center">Data de criação</th>
									<th class="text-center">Data da última atualização</th>
									<th class="text-center"></th>
									<th class="text-center"></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="text-center">02/01/2014</td>
									<td class="text-center">03/01/2014</td>
									<td><a href="NutricionistaFichaAtendimento.jsp">Visualizar</a></td>
									<td><a id="btnImprimir" data-toggle="modal" href="#imprimir">Imprimir</a></td>
								</tr>
								<tr>
									<td class="text-center">02/05/2014</td>
									<td class="text-center">03/06/2014</td>
									<td><a href="NutricionistaFichaAtendimento.jsp">Visualizar</a></td>
									<td><a id="btnImprimir" data-toggle="modal" href="#imprimir">Imprimir</a></td>
								</tr>
								<tr>
									<td class="text-center">02/07/2014</td>
									<td class="text-center">03/09/2014</td>
									<td><a href="NutricionistaFichaAtendimento.jsp">Visualizar</a></td>
									<td><a id="btnImprimir" data-toggle="modal" href="#imprimir">Imprimir</a></td>
								</tr>
								<tr>
									<td class="text-center">02/01/2015</td>
									<td class="text-center">03/02/2015</td>
									<td><a href="NutricionistaFichaAtendimento.jsp">Visualizar</a></td>
									<td><a id="btnImprimir" data-toggle="modal" href="#imprimir">Imprimir</a></td>
								</tr>
								<tr>
									<td class="text-center">02/02/2015</td>
									<td class="text-center">13/02/2015</td>
									<td><a href="NutricionistaFichaAtendimento.jsp">Visualizar</a></td>
									<td><a id="btnImprimir" data-toggle="modal" href="#imprimir">Imprimir</a></td>
								</tr>
							</tbody>
						</table>
						<div class="col-md-12">
							<ul class="pagination">
								<li><a href="#">Anterior</a></li>
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">Próximo</a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-2"></div>
				</div>
				<div class="col-md-2 column"></div>
			</div>
			<div class="row clearfix">
				<div class="col-md-2 column"></div>
				<div class="col-md-8 column">
					<h3 class="text-center">Observações Ativas</h3>
					<hr />
				</div>
				<div class="col-md-2 column"></div>
			</div>
			<div class="row clearfix">
				<div class="col-md-2 column"></div>
				<div class="col-md-8 column">
					<table class="table">
						<thead>
							<tr>
								<th class="text-center">Data de inclusão</th>
								<th class="text-center">Duração</th>
								<th class="text-center">Observação</th>
								<th class="text-center">Gravidade</th>
								<th class="text-center">Visível para</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-center">05/02/2015</td>
								<td class="text-center">30 dias</td>
								<td>Observação Observação Observação Observação...</td>
								<td class="text-center">Alta</td>
								<td class="text-center">Todos</td>
								<td class="text-center"><a href="#">Editar</a></td>
								<td class="text-center"><a href="#">Excluir</a></td>
							</tr>
							<tr>
								<td class="text-center">03/01/2015</td>
								<td class="text-center">10 dias</td>
								<td>Observação Observação Observação Observação...</td>
								<td class="text-center">Moderada</td>
								<td class="text-center">Técnico</td>
								<td class="text-center"><a href="#">Editar</a></td>
								<td class="text-center"><a href="#">Excluir</a></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="col-md-2 column"></div>
			</div>
			<div class="row clearfix">
				<div class="col-md-2 column"></div>
				<div class="col-md-8 column">
					<h3 class="text-center">Histórico de Observações</h3>
					<hr />
				</div>
				<div class="col-md-2 column"></div>
			</div>
			<div class="row clearfix">
				<div class="col-md-2 column"></div>
				<div class="col-md-8 column">
					<table class="table">
						<thead>
							<tr>
								<th class="text-center">Data de inclusão</th>
								<th class="text-center">Duração</th>
								<th class="text-center">Observação</th>
								<th class="text-center">Gravidade</th>
								<th class="text-center">Visível para</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-center">05/03/2014</td>
								<td class="text-center">7 dias</td>
								<td>Observação Observação Observação Observação...</td>
								<td class="text-center">Leve</td>
								<td class="text-center">Todos</td>
							</tr>
							<tr>
								<td class="text-center">23/04/2014</td>
								<td class="text-center">15 dias</td>
								<td>Observação Observação Observação Observação...</td>
								<td class="text-center">Alta</td>
								<td class="text-center">Todos</td>
							</tr>
							<tr>
								<td class="text-center">26/07/2014</td>
								<td class="text-center">10 dias</td>
								<td>Observação Observação Observação Observação...</td>
								<td class="text-center">Moderada</td>
								<td class="text-center">Técnico</td>
							</tr>
							<tr>
								<td class="text-center">25/09/2014</td>
								<td class="text-center">20 dias</td>
								<td>Observação Observação Observação Observação...</td>
								<td class="text-center">Alta</td>
								<td class="text-center">Todos</td>
							</tr>
							<tr>
								<td class="text-center">12/01/2015</td>
								<td class="text-center">3 dias</td>
								<td>Observação Observação Observação Observação...</td>
								<td class="text-center">Baixa</td>
								<td class="text-center">Técnico</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="col-md-2 column"></div>
			</div>
		</div>
	</div>
	</div>

	<%@include file="Modals.jsp"%>
	<%@include file="../layout/footer.jsp"%>

</body>
</html>