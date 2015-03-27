
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<div class="box-name">
										<i class="fa  fa-info-circle"></i> <span>Dias de Treino</span>
									</div>
									<div class="box-icons">
										<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
										</a> <a class="expand-link"> <i class="fa fa-expand"></i>
										</a> <a class="close-link"> <i class="fa fa-times"></i>
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
												<th>Equipe</th>
												<th>Dia da Semana</th>
												<th style="text-align: center;">Hora Início</th>
												<th style="text-align: center;">Hora Fim</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="treino" items="${listaDiasTreinos}">
												<tr>
													<td><c:out value='${treino.dsTpEquipe}' /></td>
													<td><c:out value='${treino.dsDiaSemana}' /></td>
													<fmt:formatDate value="${treino.hrInicio}" pattern="HH:mm"
														var="horaIFormatada" />
													<td align="center"><c:out value='${horaIFormatada}' /></td>
													<fmt:formatDate value="${treino.hrFim}" pattern="HH:mm"
														var="horaFFormatada" />
													<td align="center"><c:out value='${horaFFormatada}' /></td>
													<td align="center"><a class="btn btn-danger"
														href='SecretariaController?action=desativarDiaTreino&idDiaTreino=${treino.idDiaTreino}'
														data-confirm="Deseja realmente desativar o dia de treino selecionado?">Desativar</a></td>
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