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
								Atividades de Avaliações Físicas
						</h4>
						<br/>
						<table class="table">
							<tr>
								<th width="50%" >Categoria da Atividade</th>
								<th width="35%" class="text-center">Quantidade</th>
								<th width="5%" class="text-center"></th>
								<th width="5%" class="text-center"></th>
								<th width="5%" class="text-center"></th>
							</tr>
							<tr>
								<td>11 Anos - Feminino</td>
								<td align="center">2</td>
								<td align="center">
									<a href="TecnicoAvaNovoAtividade.jsp" class="btn btn-info btn-xs" role="button">Incluir Atividade</a>
								</td>
								<td align="center">
									<a href="TecnicoAvaDetalheAtividade.jsp" class="btn btn-info btn-xs" role="button">Detalhes</a>
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
	
	<%@include file="Modals.jsp"%>
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>