
	<%@include file='/layout/head.jsp'%>
	
	<body>
	
	<%@include file='/layout/header.jsp'%>
	
	<div id="main" class="container-fluid">
		<div class="row">
			<%@include file='/layout/navigationPsicologia.jsp'%>
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
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<div class="box-name">
										<i class="fa  fa-info-circle"></i>
										<span>Últimos Atendimentos</span>
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
									<table class="table">
										<thead>
											<tr>
												<th>Nome</th>
												<th style="text-align: center;">Data</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<tr>
											<td>Atleta 1</td>
											<td>01/02/2015</td>
											<td><a href="FisioterapiaHistoricoAtleta.jsp">Ver
													Histórico</a>
														</td>
											</tr>
											<tr>
												<td>Atleta 2</td>
												<td>19/01/2015</td>
												<td><a href="FisioterapiaHistoricoAtleta.jsp">Ver
														Histórico</a></td>
											</tr>
											<tr>
												<td>Atleta 3</td>
												<td>06/09/2014</td>
												<td><a href="FisioterapiaHistoricoAtleta.jsp">Ver
														Histórico</a></td>
											</tr>
											<tr>
												<td>Atleta 4</td>
												<td>13/07/2014</td>
												<td><a href="FisioterapiaHistoricoAtleta.jsp">Ver
														Histórico</a></td>
											</tr>
											<tr>
												<td>Atleta 5<br>
												</td>
												<td>23/05/2014</td>
												<td><a href="FisioterapiaHistoricoAtleta.jsp">Ver
														Histórico</a></td>
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

  </body>
</html>