	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
								<div class="box-content no-padding">
									<table class="table table-bordered table-striped table-hover table-heading table-datatable"
										id="datatable">
										<thead>
											<tr>
												<th>Nome</th>
												<th style="text-align: center;">Data Atendimento</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="atendimento" items="${listaUltimosAtendimentos}">
												<tr>
													<td>${atendimento.atleta.nome}</td>
													<td class="text-center"><fmt:formatDate value="${atendimento.dtAtendimento}" pattern="dd/MM/yyyy - HH:mm"/></td>
													<td class="text-center"><a class="link-green" href="NutricionistaController?action=jspHistoricoAtendimento&idAtleta=${atendimento.atleta.idPessoa}"><abbr title="Histórico"><i class="fa fa-large fa-folder-open"></i></abbr></a>
													</td>
												</tr>	
											</c:forEach>
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
	<script src="<%=Constants.JS%>/scriptTables.js"></script>

  </body>
</html>
