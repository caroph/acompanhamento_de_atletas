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
								Chamada dia: 01/01/2015
						</h4>
						<table class="table">
						<thead>
							<tr>
								<th width="60%" class="text-center">Atletas</th>
								<th width="20%" class="text-center">Treino Físico</th>
								<th width="20%" class="text-center">Treino Técnico</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									Atleta 1
								</td>
								<td align="center">
									<a href="#modalPresenca" class="btn" data-toggle="modal">
										<span class="glyphicon glyphicon-plus" aria-hidden="true" style="color: red"></span>
									</a>
								</td>
								<td align="center">
									<a href="#modalPresenca" class="btn" data-toggle="modal">
										<span class="glyphicon glyphicon-plus" aria-hidden="true" style="color: red"></span>
									</a>
								</td>
							</tr>
							<tr>
								<td>
									Atleta 2
								</td>
								<td align="center">
									<a href="#modalPresenca" class="btn" data-toggle="modal">
										<span class="glyphicon glyphicon-ok" aria-hidden="true" style="color: green"></span>
									</a>
								</td>
								<td align="center">
									<a href="#modalPresenca" class="btn" data-toggle="modal">
										<span class="glyphicon glyphicon-ok" aria-hidden="true" style="color: green"></span>
									</a>
								</td>
							</tr>
							<tr>
								<td>
									Atleta 3
								</td>
								<td align="center">
									<a href="#modalPresenca" class="btn" data-toggle="modal">
										<span class="glyphicon glyphicon-ban-circle" aria-hidden="true" style="color: red"></span>
									</a>
								</td>
								<td align="center">
									<a href="#modalPresenca" class="btn" data-toggle="modal">
										<span class="glyphicon glyphicon-ok" aria-hidden="true" style="color: green"></span>
									</a>
								</td>
							</tr>
							<tr>
								<td>
									Atleta 4
								</td>
								<td align="center">
									<a href="#modalPresenca" class="btn" data-toggle="modal">
										<span class="glyphicon glyphicon-flag" aria-hidden="true" style="color: rgb(97, 97, 7)"></span>
									</a>
								</td>
								<td align="center">
									<a href="#modalPresenca" class="btn" data-toggle="modal">
										<span class="glyphicon glyphicon-flag" aria-hidden="true" style="color: rgb(97, 97, 7)"></span>
									</a>
								</td>
							</tr>
							<tr>
								<td>
									Atleta 5
								</td>
								<td align="center">
									<a href="#modalPresenca" class="btn" data-toggle="modal">
										<span class="glyphicon glyphicon-ok" aria-hidden="true" style="color: green"></span>
									</a>
								</td>
								<td align="center">
									<a href="#modalPresenca" class="btn" data-toggle="modal">
										<span class="glyphicon glyphicon-ok" aria-hidden="true" style="color: green"></span>
									</a>
								</td>
							</tr>
						</tbody>
						</table>
					</div>
					<div class="col-md-2 column">
					</div>
				</div>
			</div>
		</div>
	</div>	
	<div class="modal fade" id="modalPresenca" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Editar presença</h4>
				</div>
				<div class="modal-body">
					<div class="radio">
						<label><input type="radio" name="optradio"/><span class="glyphicon glyphicon-ban-circle" aria-hidden="true" style="color: red"></span> Falta</label>
					</div>
					<div class="radio">
						<label><input type="radio" name="optradio"/><span class="glyphicon glyphicon-flag" aria-hidden="true" style="color: rgb(97, 97, 7)"></span> Torneio</label>
					</div>
					<div class="radio">
						<label><input type="radio" name="optradio"/><span class="glyphicon glyphicon-plus" aria-hidden="true" style="color: red"></span> Falta médica</label>
					</div>
					<div class="radio">
						<label><input type="radio" name="optradio"/><span class="glyphicon glyphicon-ok" aria-hidden="true" style="color: green"></span> Presença</label>
					</div>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">Salvar</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
				</div>
			</div>
		</div>
	</div>	
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>