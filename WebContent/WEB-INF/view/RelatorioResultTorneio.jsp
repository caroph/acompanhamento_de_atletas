
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file='/layout/head.jsp'%>

<body>

	<%@include file='/layout/header.jsp'%>

	<div id="main" class="container-fluid">
		<div class="row">
			<c:if test="${sessionScope.usuarioLogado.perfil == 1}">
				<%@include file='/layout/navigationSecretaria.jsp'%>
			</c:if>
			<c:if test="${sessionScope.usuarioLogado.perfil == 5}">
				<%@include file='/layout/navigationTecnico.jsp'%>
			</c:if>
			<!--Start Content-->
			<div id="content" class="col-xs-12 col-sm-10">
				<div id="ajax-content">
					<%@include file="Mensagem.jsp"%>
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<div class="box-name">
										<i class="fa fa-trophy"></i><span>Torneios Finalizados</span>
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
										<thead>
											<tr>
												<th>Nome</th>
												<th>Categoria</th>
												<th>Cidade/UF</th>
												<th style="text-align: center;">Data realização</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="torneio" items="${listaTorneios}">
												<tr>
													<td><c:out value='${torneio.nome}' /></td>
													<td><c:out value='${torneio.getNomeCategoria()}' /></td>
													<td><c:out value='${torneio.cidade}'/>/<c:out value='${torneio.estado}'/></td>
													<fmt:formatDate value="${torneio.dtInicial}" pattern="dd/MM/yyyy"
														var="dataI" />
													<fmt:formatDate value="${torneio.dtFinal}" pattern="dd/MM/yyyy"
														var="dataF" />
													<td align="center"><c:out value='${dataI}'/> à <c:out value='${dataF}'/></td>
													<td align="center">
														<a class="btn btn-primary" href="Controller?action=relResulTorneio&idTorneio=${torneio.idTorneio}" target="_blank">Resultado</a>
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
	<div class="modal fade" id="detalhes" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true"
		class="modal hide fade" role="dialog" aria-labelledby="orderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
					<h4 class="modal-title" id="myModalLabel">Detalhes Atleta</h4>
				</div>
				<div class="modal-body body-atleta">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn" data-dismiss="modal" id="fechar">Fechar</button>
				</div>
			</div>
		</div>
	</div>	
	<%@include file="/layout/footer.jsp"%>
	<%@include file="Modals.jsp"%>
	<script src="<%=Constants.JS%>/scriptTables.js"></script>

</body>
</html>