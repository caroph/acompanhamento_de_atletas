	<%@include file='/layout/head.jsp'%>
	
	<body>
	
	<%@include file='/layout/header.jsp'%>
	
	<div id="main" class="container-fluid">
		<div class="row">
			<%@include file='/layout/navigationSecretaria.jsp'%>
			<!--Start Content-->
			<div id="content" class="col-xs-12 col-sm-10">
				<div id="ajax-content">
					<div class="row">
						<div id="breadcrumb" class="col-xs-12">
							<ol class="breadcrumb">
								<li><a href="SecretariaPrincipal.jsp">Home</a></li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<div class="box-name">
										<i class="fa  fa-info-circle"></i>
										<span>Pendências</span>
									</div>
									<div class="box-icons">
										<a class="collapse-link">
											<i class="fa fa-chevron-up"></i>
										</a>
										<a class="expand-link">
											<i class="fa fa-expand"></i>
										</a>
										<a class="close-link">
											<i class="fa fa-times"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<h5><b>Existem 16 pendências nos cadastros de alunos!</b></h5>
									<table class="table">
										<thead>
											<tr>
												<th>Pendência</th>
												<th style="text-align: center;">Ocorrências</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>Declarações médicas não cadastradas</td>
												<td align="center">4</td>
												<td align="center"><a class="btn btn-primary" data-toggle="modal" data-target="#basicModal" id="btnListarAlunos">Listar Atletas</a></td>
											</tr>
											<tr>
												<td>Autorizações de Viagem e Hospedagem não cadastradas </td>
												<td align="center">4</td>
												<td align="center"><a class="btn btn-primary" data-toggle="modal" data-target="#basicModal" id="btnListarAlunos">Listar Atletas</a></td>
											</tr>
											<tr>
												<td>Cópias do RG não cadastradas</td>
												<td align="center">4</td>
												<td align="center"><a class="btn btn-primary" data-toggle="modal" data-target="#basicModal" id="btnListarAlunos">Listar Atletas</a></td>
											</tr>			
											<tr>
												<td>Fotos não cadastradas</td>
												<td align="center">4</td>
												<td align="center"><a class="btn btn-primary" data-toggle="modal" data-target="#basicModal" id="btnListarAlunos">Listar Atletas</a></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>		
				</div>
			</div>
			<!--End Content-->
		</div>
	</div>
	
<%@include file="/layout/footer.jsp"%>

	<!-- Modal -->	
	<div class="modal fade" id="basicModal" tabindex="-1" role="dialog"	aria-labelledby="basicModal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">x</button>
					<h4 class="modal-title" id="myModalLabel">Alunos com pendências</h4>
				</div>
				<div class="modal-body">
					<table class="table">
						<tr>
							<th class="text-center">Nome do aluno</th>
							<th class="text-center">Matrícula</th>
							<th></th>
						</tr>
						<tr>
							<td>Atleta 01</td>
							<td class="text-center">00000001</td>
							<td><a href="SecretariaAnexosAtleta.jsp">Anexar Documentos</a></td>
						</tr>
						<tr>
							<td>Atleta 02</td>
							<td class="text-center">00000002</td>
							<td><a href="SecretariaAnexosAtleta.jsp">Anexar Documentos</a></td>
						</tr>
						<tr>
							<td >Atleta 03</td>
							<td class="text-center">00000003</td>
							<td><a href="SecretariaAnexosAtleta.jsp">Anexar Documentos</a></td>
						</tr>
						<tr>
							<td>Atleta 04</td>
							<td class="text-center">00000004</td>
							<td><a href="SecretariaAnexosAtleta.jsp">Anexar Documentos</a></td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal"
						id="fechar">Fechar</button>
				</div>
			</div>
		</div>
	</div>
	
	
	
  </body>
</html>