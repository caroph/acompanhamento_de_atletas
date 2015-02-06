<%@include file='../layout/head.jsp'%>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationFisioterapia.jsp'%>
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
					<div class="col-md-2 column"></div>
					<div class="col-md-8 column">
						<br />
						<div id="listaHistorico">
							<div>
								<h4>03/01/2015 - 14:00h</h4>
								<hr />
							</div>
							<div>
								<p>Aqui segue um prontuário, aqui segue um prontuário, aqui
									segue um prontuário, aqui segue um prontuário , aqui segue um
									prontuário, aqui segue um prontuário, aqui segue um prontuário,
									aqui segue um prontuário , aqui segue um prontuário, aqui segue
									um prontuário, aqui segue um prontuário, aqui segue um
									prontuário , aqui segue um prontuário, aqui segue um
									prontuário, aqui segue um prontuário, aqui segue um prontuário
									, aqui segue um prontuário, aqui segue um prontuário, aqui
									segue um prontuário, aqui segue um prontuário.</p>
								<hr />
							</div>
							<div>
								<h4>02/01/2015 - 14:30h</h4>
								<hr />
							</div>
							<div>
								<p>Aqui segue um prontuário, aqui segue um prontuário, aqui
									segue um prontuário, aqui segue um prontuário , aqui segue um
									prontuário, aqui segue um prontuário, aqui segue um prontuário,
									aqui segue um prontuário , aqui segue um prontuário, aqui segue
									um prontuário, aqui segue um prontuário, aqui segue um
									prontuário , aqui segue um prontuário, aqui segue um
									prontuário, aqui segue um prontuário, aqui segue um prontuário
									, aqui segue um prontuário, aqui segue um prontuário, aqui
									segue um prontuário, aqui segue um prontuário.</p>
								<hr />
							</div>
							<div>
								<h4>01/01/2015 - 17:00h</h4>
								<hr />
							</div>
							<div>
								<p>Aqui segue um prontuário, aqui segue um prontuário, aqui
									segue um prontuário, aqui segue um prontuário , aqui segue um
									prontuário, aqui segue um prontuário, aqui segue um prontuário,
									aqui segue um prontuário , aqui segue um prontuário, aqui segue
									um prontuário, aqui segue um prontuário, aqui segue um
									prontuário , aqui segue um prontuário, aqui segue um
									prontuário, aqui segue um prontuário, aqui segue um prontuário
									, aqui segue um prontuário, aqui segue um prontuário, aqui
									segue um prontuário, aqui segue um prontuário.</p>
								<hr />
							</div>
						</div>
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
						<div class="col-md-12 text-right">
							<hr/>
							<button type="button" class="btn btn-primary"
								id="btnImprimirRelGeral" data-toggle="modal"
								data-target="#imprimir">Imprimir Histórico</button>
						</div>
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