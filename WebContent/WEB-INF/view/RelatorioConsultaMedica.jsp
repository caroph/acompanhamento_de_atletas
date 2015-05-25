
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
		<c:if test="${sessionScope.usuarioLogado.perfil == 5 || sessionScope.usuarioLogado.perfil == 6}">
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
										<i class="fa fa-stethoscope"></i> <span>Presença em consultas médicas</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<div class="row clearfix"> 
										<div class="col-md-12">
											<form action="Controller?action=gerarRelatorioConsultaMedica" method="post"
												target="_blank">
												<fmt:formatDate value="${dataAtual}" pattern="yyyy-MM-dd"
													var="dataAtual" />
												<div class="col-md-12 form-group">
													<div class="col-md-2">
														<label for="dataInicio" class="control-label">Data inicial:</label>
													</div>
													<div class="col-md-3">
														<input type="date" class="form-control" required name="dataInicio"
															value="<c:out value="${dataAtual}"/>" id="dataInicio" />
													</div>
													<div class="col-md-2">
														<label for="dataFim" class="control-label">Data final:</label>
													</div>
													<div class="col-md-3">
														<input type="date" class="form-control" required name="dataFim"
															value="<c:out value="${dataAtual}"/>" id="dataFim" />
													</div>
													<div class="col-md-2">
														<button type="submit" class="btn btn-primary" style="margin: -5%;padding: 3%;"><abbr title="Gerar relatório"><i class="fa fa-large fa-file-pdf-o"></i></abbr></button>
													</div>
												</div>
											</form>
										</div>
									</div>
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
	<%@include file="Modals.jsp" %>
</body>
</html>