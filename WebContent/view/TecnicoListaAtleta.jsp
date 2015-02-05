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
							Buscar Atleta
						</h3>
						<form role="form" action="TecnicoListaAtleta.jsp">
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
								Atletas Encontrados
						</h4>
						<table class="table">
						<thead>
							<tr>
								<th width="20%" class="text-center">Nome</th>
								<th width="20%" class="text-center">Equipe</th>
								<th width="30%" class="text-center"></th>
								<th width="30%" class="text-center"></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td align="center">
									Atleta 1
								</td>
								<td align="center">
									Alto Rendimento
								</td>
								<td align="center">
									<a href="TecnicoObservacao.jsp" class="btn btn-info btn-xs" role="button">Observações</a>
								</td>
								<td align="center">
									<a href="TecnicoDesempenhoTorneio.jsp" class="btn btn-info btn-xs" role="button">Desempenho em Torneios</a>
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