
	<%@include file='/layout/head.jsp'%>
	
	<body>
	
	<%@include file='/layout/header.jsp'%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
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
												<th width="40%">
													Nome do atleta
												</th>
												<th style="text-align: center;" width="20%">
													Data do último atendimento
												</th>
												<th width="10%">
												</th>
												<th width="10%">
												</th>
												<th width="10%">
												</th>
												<th width="10%">
												</th>
											</tr>
										</thead>
										<tbody>
										<c:choose>
											<c:when test="${listaUltimosAtendimentos != null}">
												<c:forEach var="atendimento" items="${listaUltimosAtendimentos}">
													<fmt:parseDate value="${atendimento.get(2)}" var="dtAtendimento" pattern="yyyy-MM-dd HH:mm:ss"/>
													<tr>
														<td style="max-width: 200px;">${atendimento.get(1)}</td>
														<td class="text-center"><fmt:formatDate value="${dtAtendimento}" pattern="dd/MM/yyyy - HH:mm"/></td>
														<td class="text-center"><a class="btn btn-primary" data-toggle="modal" href="#incluirParecer">Incluir
																Observação</a></td>
														<td class="text-center"><a class="btn btn-primary" href="NutricionistaController?action=jspFichaDeAtendimento&idAtleta=${atendimento.get(0)}&idFichaDeAtendimento=0">Novo Atendimento</a></td>
														<td class="text-center"><a class="btn btn-primary" href="NutricionistaDietaAtleta.jsp">Dieta</a></td>
														<td class="text-center"><a class="btn btn-primary" href="NutricionistaController?action=jspHistoricoAtendimento&idAtleta=${atendimento.get(0)}">Histórico</a>
														</td>
													</tr>	
												</c:forEach>
											</c:when>
											<c:otherwise>
												<tr>
													<td class="text-center" colspan="6"><b>Você ainda não realizou nenhum atendimento. Seus atendimentos mais recentes aparecerão aqui.</b></td>
												</tr>
											</c:otherwise>
										</c:choose>
											
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
