
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file='/layout/head.jsp'%>

<body>

	<%@include file='/layout/header.jsp'%>

	<div id="main" class="container-fluid">
		<div class="row">
			<%@include file='/layout/navigationSecretaria.jsp'%>
			<!--Start Content-->
			<div id="content" class="col-xs-12 col-sm-10">
				<div id="ajax-content">
					<%@include file="Mensagem.jsp"%>
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<div class="box-name">
										<i class="fa fa-tags"></i> <span>Estoque de Uniformes</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content clearfix">
									<table class="table">
										<thead>
											<tr>
												<th width="60%">Tipo</th>
												<th width="20%">Tamanho</th>
												<th width="20%">Quantidade</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="uniforme" items="${listaUniformes}">
												<c:if test="${uniforme.quantidadeUniforme > 30}">
													<tr>
														<td><c:out value='${uniforme.getNomeTpUniforme()}' /></td>
														<td><c:out value='${uniforme.getNomeTamanhoUniforme()}' /></td>
														<td><c:out value='${uniforme.quantidadeUniforme}' /></td>
													</tr>
												</c:if>
												<c:if test="${uniforme.quantidadeUniforme <= 30}">
													<tr style="background-color: rgb(255, 234, 238);">
														<td><c:out value='${uniforme.getNomeTpUniforme()}' /></td>
														<td><c:out value='${uniforme.getNomeTamanhoUniforme()}' /></td>
														<td><c:out value='${uniforme.quantidadeUniforme}' /></td>
													</tr>
												</c:if>
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
</body>
</html>

