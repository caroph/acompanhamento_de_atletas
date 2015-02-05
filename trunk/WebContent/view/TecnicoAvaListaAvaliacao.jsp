	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationTecnico.jsp'%>
				<div class="row clearfix">
					<div class="col-md-2 column">
					</div>
					<div class="col-md-8 column">
						<h4 class="text-center">
								Avaliações Físicas do Atleta 1
						</h4>
						<br/>
						<a href="TecnicoAvaNovoAvaliacao.jsp" class="btn btn-info btn-sm" role="button">Nova Avaliação</a>
						<a href="#" class="btn btn-primary btn-sm" role="button">Relatório Individual de Avaliações</a>
						<br/><br/>
						<table class="table">
							<tr>
								<th width="30%" >Data</th>
								<th width="40%" >Característica</th>
								<th width="10%" class="text-center"></th>
								<th width="10%" class="text-center"></th>
								<th width="10%" class="text-center"></th>
							</tr>
							<tr>
								<td>01/01/2015</td>
								<td >Pré Interclubes</td>
								<td align="center">
									<button class="btn btn-info btn-xs" data-toggle="modal" href="#detalhes">Detalhes</button>
								</td>
								<td align="center">
									<a href="TecnicoAvaNovoAvaliacao.jsp" class="btn btn-info btn-xs" role="button">Editar</a>
								</td>
								<td align="center">
									<button class="btn btn-danger btn-xs" data-toggle="modal" href="#deletar">Deletar</button>
								</td>
							</tr>
							<tr>
								<td>01/01/2015</td>
								<td >Início de Temporada</td>
								<td align="center">
									<button class="btn btn-info btn-xs" data-toggle="modal" href="#detalhes">Detalhes</button>
								</td>
								<td align="center">
									<a href="TecnicoAvaNovoAvaliacao.jsp" class="btn btn-info btn-xs" role="button">Editar</a>
								</td>
								<td align="center">
									<button class="btn btn-danger btn-xs" data-toggle="modal" href="#deletar">Deletar</button>
								</td>
							</tr>
							<tr>
								<td>01/01/2015</td>
								<td >Início de Ano</td>
								<td align="center">
									<button class="btn btn-info btn-xs" data-toggle="modal" href="#detalhes">Detalhes</button>
								</td>
								<td align="center">
									<a href="TecnicoAvaNovoAvaliacao.jsp" class="btn btn-info btn-xs" role="button">Editar</a>
								</td>
								<td align="center">
									<button class="btn btn-danger btn-xs" data-toggle="modal" href="#deletar">Deletar</button>
								</td>
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
					</div>
					<div class="col-md-2 column">
					</div>
				</div>
			</div>
		</div>
	</div>	
	
		<div class="modal fade" id="detalhes" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
					<h4 class="modal-title" id="myModalLabel">Detalhes da Avaliação Física</h4>
					</div>
					<div class="modal-body">
						Nome: Atleta X<br/>
						Data Avaliação:<br/>
						...
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