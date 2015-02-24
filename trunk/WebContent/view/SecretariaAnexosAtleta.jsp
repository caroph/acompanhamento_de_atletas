	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationSecretaria.jsp'%>
				<div class="row clearfix">
					<div class="col-md-2 column">
					</div>
					<div class="col-md-8 column">
						<h3 class="text-center">
							Documentos Atletas
						</h3>
						<br/>
						<h4>Nome do Atleta: XXX</h4>
						<br/>
						<table class="table">
							<tr>
								<th><strong>Documento</strong></th>
								<th class="text-center">Situação</th>
								<th></th>
							</tr>
							<tr>
								<td><a data-toggle="modal" href="#visualizarFoto">Foto do Atleta</td>
								<td class="text-center"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
								<td><a class="btn btn-primary" data-toggle="modal" data-target="#tirarFoto" id="btnAnexo">Tirar Foto</a></td>
							</tr>
							<tr>
								<td><a data-toggle="modal" href="#visualizarDoc">Termo de Compromisso do Manual do Atleta</a></td>
								<td class="text-center"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
								<td><a class="btn btn-primary" data-toggle="modal" data-target="#basicModal" id="btnAnexo">Anexar</a></td>
							</tr>
							<tr>
								<td><a data-toggle="modal" href="#visualizarDoc">Declaração Médica</a></td>
								<td class="text-center"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
								<td><a class="btn btn-primary" data-toggle="modal" data-target="#basicModal" id="btnAnexo">Anexar</a></td>
							</tr>
							<tr>
								<td><a data-toggle="modal" href="#visualizarDoc">Autorização de Viagem e Hospedagem</a></td>
								<td class="text-center"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
								<td><a class="btn btn-primary" data-toggle="modal" data-target="#basicModal" id="btnAnexo">Anexar</a></td>
							</tr>
							<tr>
								<td><a data-toggle="modal" href="#visualizarDoc">Autorização de Imagem</a></td>
								<td class="text-center"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
								<td><a class="btn btn-primary" data-toggle="modal" data-target="#basicModal" id="btnAnexo">Anexar</a></td>
							</tr>
							<tr>
								<td><a data-toggle="modal" href="#visualizarDoc">Cópia do RG</a></td>
								<td class="text-center"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
								<td><a class="btn btn-primary" data-toggle="modal" data-target="#basicModal" id="btnAnexo">Anexar</a></td>
							</tr>
							<tr>
								<td><a data-toggle="modal" href="#visualizarDoc">Cópia do CPF</a></td>
								<td class="text-center"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
								<td><a class="btn btn-primary" data-toggle="modal" data-target="#basicModal" id="btnAnexo">Anexar</a></td>
							</tr>
						</table>
					</div>
					<div class="col-md-2 column">
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="basicModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
					<h4 class="modal-title" id="myModalLabel">Anexar</h4>
					</div>
					<div class="modal-body">
						<button type="button" class="btn">Selecionar Arquivo...</button>
						<button type="button" class="btn btn-primary mostrarProgresso" id="anexar">Anexar</button>
						<div class="form-group" >
								<label for="nr" class="col-sm-4 control-label">Data Validade Documento:</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" id="inputEmail3" />
								</div>
							</div>
						<div class="progress" style="display: none; margin-top:10px;" id="progress">
							<div class="progress-bar progress-bar-striped active" role="progressbar"
							  aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:70%">
								70%
							</div>
						</div>						
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal" id="fechar">Fechar</button>
					</div>
				</div>
			</div>
		</div>	
		<div class="modal fade" id="tirarFoto" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
					<h4 class="modal-title" id="myModalLabel">Tirar Foto</h4>
					</div>
					<div class="modal-body text-center">
						<img src="../themes/default/assets/img/avatar.jpg" align="middle" width="500px" height="450px"/>	
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal" id="fechar">Cancelar</button>
						<button type="button" class="btn btn-primary" id="btnTirarFoto">Tirar foto</button>
					</div>
				</div>
			</div>
		</div>	
		<div class="modal fade" id="visualizarDoc" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
					<h4 class="modal-title" id="myModalLabel">Visualizar Documento</h4>
					</div>
					<div class="modal-body text-center">
						<img src="../themes/default/assets/img/iconeImg.png" align="middle" width="500px" height="450px"/>	
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal" id="fechar">Fechar</button>
					</div>
				</div>
			</div>
		</div>	
		<div class="modal fade" id="visualizarFoto" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
					<h4 class="modal-title" id="myModalLabel">Visualizar Foto</h4>
					</div>
					<div class="modal-body text-center">
						<img src="../themes/default/assets/img/avatar.jpg" align="middle" width="500px" height="450px"/>	
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal" id="fechar">Fechar</button>
					</div>
				</div>
			</div>
		</div>	
	</div>
	<%@include file="../layout/footer.jsp"%>
	<script>
// 		$('#anexar').click(function() {
// 			$('#progress').css("display", "block");
// 		});
// 		$('#fechar').click(function() {
// 			$('#progress').css("display", "none");
// 		});
	</script>
	
  </body>
</html>