
	<%@include file='/layout/head.jsp'%>
	
	<body>
	
	<%@include file='/layout/header.jsp'%>
	
	<div id="main" class="container-fluid">
		<div class="row">
			<%@include file='/layout/navigationNutricionista.jsp'%>
			<!--Start Content-->
			<div id="content" class="col-xs-12 col-sm-10">
				<div id="ajax-content">
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
												<th>
													Nome
												</th>
												<th style="text-align: center;">
													Data
												</th>
												<th>
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
												<td style="max-width: 200px;" class="text-center">Atleta 3</td>
												<td class="text-center">01/01/2015</td>
												<td><a href="NutricionistaFichaAtendimento.jsp">Ficha
														de Atendimento</a></td>
												<td><a data-toggle="modal" href="#incluirParecer">Incluir
														Observação</a></td>
												<td><a href="NutricionistaFichaAtendimento.jsp">Novo
														Atendimento</a></td>
												<td><a href="NutricionistaDietaAtleta.jsp">Dieta</a></td>
												<td><a href="NutricionistaHistoricoAtleta.jsp">Histórico</a>
												</td>
											</tr>
											<tr>
												<td style="max-width: 200px;" class="text-center">Atleta 3</td>
												<td class="text-center">01/01/2015</td>
												<td><a href="NutricionistaFichaAtendimento.jsp">Ficha
														de Atendimento</a></td>
												<td><a data-toggle="modal" href="#incluirParecer">Incluir
														Observação</a></td>
												<td><a href="NutricionistaFichaAtendimento.jsp">Novo
														Atendimento</a></td>
												<td><a href="NutricionistaDietaAtleta.jsp">Dieta</a></td>
												<td><a href="NutricionistaHistoricoAtleta.jsp">Histórico</a>
												</td>
											</tr>
											<tr>
												<td style="max-width: 200px;" class="text-center">Atleta 3</td>
												<td class="text-center">01/01/2015</td>
												<td><a href="NutricionistaFichaAtendimento.jsp">Ficha
														de Atendimento</a></td>
												<td><a data-toggle="modal" href="#incluirParecer">Incluir
														Observação</a></td>
												<td><a href="NutricionistaFichaAtendimento.jsp">Novo
														Atendimento</a></td>
												<td><a href="NutricionistaDietaAtleta.jsp">Dieta</a></td>
												<td><a href="NutricionistaHistoricoAtleta.jsp">Histórico</a>
												</td>
											</tr>
											<tr>
												<td style="max-width: 200px;" class="text-center">Atleta 3</td>
												<td class="text-center">01/01/2015</td>
												<td><a href="NutricionistaFichaAtendimento.jsp">Ficha
														de Atendimento</a></td>
												<td><a data-toggle="modal" href="#incluirParecer">Incluir
														Observação</a></td>
												<td><a href="NutricionistaFichaAtendimento.jsp">Novo
														Atendimento</a></td>
												<td><a href="NutricionistaDietaAtleta.jsp">Dieta</a></td>
												<td><a href="NutricionistaHistoricoAtleta.jsp">Histórico</a>
												</td>
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
