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
						<h3 class="text-center">
						Resultado do Torneio XXX
						</h3>
						<hr>	
						<table class="table">
							<tr>
								<th><strong>Atleta</strong></th>
								<th class="text-center">Resultado</th>
								<th></th>
							</tr>
							<tr>
								<td>Atleta 1</td>
								<td class="text-center">1º</td>
								<td class="text-center"><a class="btn btn-primary" disabled data-toggle="modal" data-target="#basicModal">Registrar Posição</a></td>
							</tr>
							<tr>
								<td>Atleta 2</td>
								<td class="text-center"></td>
								<td class="text-center"><a class="btn btn-primary" data-toggle="modal" data-target="#basicModal">Registrar Posição</a></td>
							</tr>
							<tr>
								<td>Atleta 3</td>
								<td class="text-center"></td>
								<td class="text-center"><a class="btn btn-primary" data-toggle="modal" data-target="#basicModal">Registrar Posição</a></td>
							</tr>
							<tr>
								<td>Atleta 4</td>
								<td class="text-center"></td>
								<td class="text-center"><a class="btn btn-primary" data-toggle="modal" data-target="#basicModal">Registrar Posição</a></td>
							</tr>
						</table>
					</div>
					<div class="col-md-2 column">
					</div>
				</div>
			</div>
		</div>
	</div>	
	
	<div class="modal fade" id="basicModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Resultado Torneio</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label for="posicao" class="col-sm-4 control-label">Posição no torneio:</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" id="posicao" />
							</div>
						</div>	
					</form>			
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" data-dismiss="modal">Salvar</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
				</div>
			</div>
		</div>
	</div>	
  
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>