
	<%@include file='/layout/head.jsp'%>
	
	<body>
	
	<%@include file='/layout/header.jsp'%>
	
	<div id="main" class="container-fluid">
		<div class="row">
			<%@include file='/layout/navigationNutricionista.jsp'%>
			<!--Start Content-->
			<div id="content" class="col-xs-12 col-sm-10">
				<div id="ajax-content">
					<%@include file="Mensagem.jsp"%>
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<div class="box-name">
										<i class="fa fa-pencil-square"></i>
										<span>Últimos Atendimentos</span>
									</div>
									<div class="box-icons">
										<a class="expand-link">
											<i class="fa fa-expand"></i>
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
												<td><a href="NutricionistaController?action=jspFichaDeAtendimento&idAtleta=1&idFichaDeAtendimento=0">Novo
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
