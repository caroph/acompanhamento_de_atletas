	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@include file='/layout/head.jsp'%>
	<body>
	<%@include file='/layout/header.jsp'%>
	<div id="main" class="container-fluid">
		<div class="row">
			<%@include file='/layout/navigationTecnico.jsp'%>
			<!--Start Content-->
			<div id="content" class="col-xs-12 col-sm-10">
				<div id="ajax-content">
					<%@include file="Mensagem.jsp"%>
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<div class="box-name">
										<i class="fa fa-line-chart"></i>
										<span>Últimas avaliações físicas</span>
									</div>
									<div class="box-icons">
										<a class="expand-link">
											<i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content no-padding">
									<table
										class="table table-bordered table-striped table-hover table-heading table-datatable"
										id="datatable">
										<thead>
											<tr>
												<th>Nome</th>
												<th style="text-align: center;">Data Atendimento</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="avaliacao" items="${listaAvaliacao}">
												<tr>
													<td><c:out value='${avaliacao.getAtleta().nome}' /></td>
													<fmt:formatDate value="${avaliacao.dtAvaliacao}" pattern="dd/MM/yyyy" var="dtFormatada" />
													<td style="text-align: center;"><c:out value='${dtFormatada}'/></td>
													<td align="center">
														<a class="link-green" href="AvaliacaoFisController?action=jspHistorico&idAtleta=${avaliacao.getAtleta().idPessoa}&nome=${avaliacao.getAtleta().nome}"><abbr title="Histórico de avaliações físicas"><i class="fa fa-large fa-folder-open"></i></abbr></a>		
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
	<%@include file="Modals.jsp"%>
	<script src="<%=Constants.JS%>/scriptTables.js"></script>
	
  </body>
</html>
