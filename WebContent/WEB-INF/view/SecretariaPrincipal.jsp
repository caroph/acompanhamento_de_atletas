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
								<li><a href="SecretariaController">Home</a></li>
							</ol>
						</div>
					</div>
					<c:if test="${ msg != null && msg != ''}">
						<div class="alert alert-danger">
					        <a href="#" class="close" data-dismiss="alert">&times;</a>
					            <c:out value="${msg}"></c:out>       
				    	</div>
			        </c:if>
			        <c:if test="${ msgSucesso != null && msgSucesso != ''}">
						<div class="alert alert-success">
					        <a href="#" class="close" data-dismiss="alert">&times;</a>
					            <c:out value="${msgSucesso}"></c:out>       
				    	</div>
			        </c:if>
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
	<%@include file="Modals.jsp"%>

  </body>
</html>