	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationTecnico.jsp'%>
				<div class="row clearfix">
					<div class="col-md-2 column"></div>
					<div class="col-md-8 column">
						<a href="TecnicoAvaNovoCategoria.jsp" class="btn btn-primary btn-sm" role="button">Incluir Nova Categoria</a>
					</div>
					<div class="col-md-2 column"></div>
				</div>
				<div class="row clearfix">
					<div class="col-md-2 column">
					</div>
					<div class="col-md-8 column">
						<h4 class="text-center">
								Categorias de Avaliações Físicas
						</h4>
						<br/>
						<table class="table">
							<tr>
								<th width="40%" >Idade</th>
								<th width="20%" >Sexo</th>
								<th width="10%" class="text-center"></th>
								<th width="10%" class="text-center"></th>
							</tr>
							<tr>
								<td>7 - 11 Anos</td>
								<td >Masculino</td>
								<td align="center">
									<a href="TecnicoAvaNovoCategoria.jsp" class="btn btn-info btn-xs" role="button">Editar</a>
								</td>
								<td align="center">
									<button class="btn btn-danger btn-xs" data-toggle="modal" href="#deletar">Deletar</button>
								</td>
							</tr>
							<tr>
								<td>11 - 12 Anos</td>
								<td >Feminino</td>
								<td align="center">
									<a href="TecnicoAvaNovoCategoria.jsp" class="btn btn-info btn-xs" role="button">Editar</a>
								</td>
								<td align="center">
									<button class="btn btn-danger btn-xs" data-toggle="modal" href="#deletar">Deletar</button>
								</td>
							</tr>
							<tr>
								<td>13 - 14 Anos</td>
								<td >Feminino</td>
								<td align="center">
									<a href="TecnicoAvaNovoCategoria.jsp" class="btn btn-info btn-xs" role="button">Editar</a>
								</td>
								<td align="center">
									<button class="btn btn-danger btn-xs" data-toggle="modal" href="#deletar">Deletar</button>
								</td>
							</tr>
							<tr>
								<td>13 - 14 Anos</td>
								<td >Masculino</td>
								<td align="center">
									<a href="TecnicoAvaNovoCategoria.jsp" class="btn btn-info btn-xs" role="button">Editar</a>
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