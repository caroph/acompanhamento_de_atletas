
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
										<i class="fa fa-flag"></i> <span>Dados de referência</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content no-padding">
									<table
										class="table table-bordered table-striped table-hover table-heading table-datatable"
										id="datatable">
										<a class="btn btn-primary" id="novoDadosRef" href="AvaliacaoFisController?action=jspNovoDadosRef">Novos dados de referência</a>
										<thead>
											<tr>
<!-- 												<th>Capacidade</th> -->
<!-- 												<th>Teste</th> -->
<!-- 												<th>Unidade de medida</th> -->
<!-- 												<th></th> -->
											</tr>
										</thead>
										<tbody>
<%-- 											<c:forEach var="atividade" items="${listaAtividades}"> --%>
<!-- 												<tr> -->
<%-- 													<td><c:out value='${atividade.capacidade}' /></td> --%>
<%-- 													<td><c:out value='${atividade.teste}' /></td> --%>
<%-- 													<td><c:out value='${atividade.getNomeUnidade()}' /></td> --%>
<!-- 													<td align="center"> -->
<%-- 														<a class="btn btn-danger" href="AvaliacaoFisController?action=desativarAtividade&idAtividade=${atividade.idAtividadeAvaliacao}" --%>
<!-- 														data-confirm="Deseja realmente excluir a atividade selecionada?">Excluir</a> -->
<!-- 													</td> -->
<!-- 												</tr> -->
<%-- 											</c:forEach> --%>
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