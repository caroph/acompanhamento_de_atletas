	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
			<!-- menu -->
				<%@include file='../layout/navigationNutricionista.jsp'%>
				
				<div class="row clearfix">
					<div class="col-md-3 column">
					</div>
					<div class="col-md-6 column">
						<h3 class="text-center">
							Buscar Modelo de Cardápio
						</h3>
						<form role="form" action="NutricionistaListaModelos.jsp">
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
							Modelos Encontrados
					</h3>
					<table class="table">
					<thead>
						<tr>
							<th>
								Nome
							</th>
							<th>
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
								Modelo Cardápio 1
							</td>
							<td>
								<a data-toggle="modal" href="#detalhesCardapio">Detalhes</a>
							</td>
							<td>
								<a href="NutricionistaNovoCardapio.jsp">Editar</a>
							</td>
							<td>
								<a data-toggle="modal"href="#deletar">Excluir</a>
							</td>
						</tr>
						<tr>
							<td>
								Modelo Cardápio 2
							</td>
							<td>
								<a data-toggle="modal" href="#detalhesCardapio">Detalhes</a>
							</td>
							<td>
								<a href="NutricionistaNovoCardapio.jsp">Editar</a>
							</td>
							<td>
								<a data-toggle="modal"href="#deletar">Excluir</a>
							</td>
						</tr>
						<tr>
							<td>
								Modelo Cardápio 3
							</td>
							<td>
								<a data-toggle="modal" href="#detalhesCardapio">Detalhes</a>
							</td>
							<td>
								<a href="NutricionistaNovoCardapio.jsp">Editar</a>
							</td>
							<td>
								<a data-toggle="modal"href="#deletar">Excluir</a>
							</td>
						</tr>
						<tr>
							<td>
								Modelo Cardápio 4
							</td>
							<td>
								<a data-toggle="modal" href="#detalhesCardapio">Detalhes</a>
							</td>
							<td>
								<a href="NutricionistaNovoCardapio.jsp">Editar</a>
							</td>
							<td>
								<a data-toggle="modal"href="#deletar">Excluir</a>
							</td>
						</tr>
						<tr>
							<td>
								Modelo Cardápio 5
							</td>
							<td>
								<a data-toggle="modal" href="#detalhesCardapio">Detalhes</a>
							</td>
							<td>
								<a href="NutricionistaNovoCardapio.jsp">Editar</a>
							</td>
							<td>
								<a data-toggle="modal"href="#deletar">Excluir</a>
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
	
	
		
	<%@include file="Modals.jsp"%>
		
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>