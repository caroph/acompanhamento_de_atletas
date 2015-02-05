	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationTecnico.jsp'%>
				<div class="row clearfix">
					<div class="col-md-3 column">
					</div>
					<div class="col-md-6 column">
						<h3 class="text-center">
							Buscar Torneio
						</h3>
						<form role="form" action="TecnicoListaTorneio.jsp">
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
				<br/><br/>
				<div class="row clearfix">
					<div class="col-md-2 column">
					</div>
					<div class="col-md-8 column">
						<h4 class="text-center">
								Torneios a Serem Realizados
						</h4>
						<table class="table">
							<tr>
								<th width="25%">Nome do torneio</th>
								<th width="20%" class="text-center">Data do evento</th>
								<th width="20%" class="text-center">Tipo de torneio</th>
								<th width="20%" class="text-center">Cidade</th>
								<th width="5%" class="text-center"></th>
								<th width="5%" class="text-center"></th>
								<th width="5%" class="text-center"></th>
							</tr>
							<tr>
								<td>Torneio 1</td>
								<td align="center">02/01/2015</td>
								<td align="center">FPT</td>
								<td align="center">Curitiba</td>
								<td align="center">
									<a href="TecnicoNovoTorneio.jsp" class="btn btn-info btn-xs" role="button">Editar</a>
								</td>
								<td align="center">
									<a href="TecnicoResultadoTorneio.jsp" class="btn btn-info btn-xs" role="button">Finalizar</a>
								</td>
								<td align="center">
									<button class="btn btn-danger btn-xs" data-toggle="modal" href="#deletar">Deletar</button>
								</td>
							</tr>
							<tr>
								<td>Torneio 2</td>
								<td align="center">02/03/2014</td>
								<td align="center">CBT</td>
								<td align="center">Belo Horizonte</td>
								<td align="center">
									<a href="TecnicoNovoTorneio.jsp" class="btn btn-info btn-xs" role="button">Editar</a>
								</td>
								<td align="center">
									<a href="TecnicoResultadoTorneio.jsp" class="btn btn-info btn-xs" role="button">Finalizar</a>
								</td>
								<td align="center">
									<button class="btn btn-danger btn-xs" data-toggle="modal" href="#deletar">Deletar</button>
								</td>
							</tr>
							<tr>
								<td>Torneio 3</td>
								<td align="center">02/02/2014</td>
								<td align="center">FPT</td>
								<td align="center">Pato Branco</td>
								<td align="center">
									<a href="TecnicoNovoTorneio.jsp" class="btn btn-info btn-xs" role="button">Editar</a>
								</td>
								<td align="center">
									<a href="TecnicoResultadoTorneio.jsp" class="btn btn-info btn-xs" role="button">Finalizar</a>
								</td>
								<td align="center">
									<button class="btn btn-danger btn-xs" data-toggle="modal" href="#deletar">Deletar</button>
								</td>
							</tr>
							<tr>
								<td>Torneio 4</td>
								<td align="center">02/01/2014</td>
								<td align="center">ITF</td>
								<td align="center">Curitiba</td>
								<td align="center">
									<a href="TecnicoNovoTorneio.jsp" class="btn btn-info btn-xs" role="button">Editar</a>
								</td>
								<td align="center">
									<button href="#resultadoRegistrar" class="btn btn-info btn-xs" data-toggle="modal">Resultados</button>
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