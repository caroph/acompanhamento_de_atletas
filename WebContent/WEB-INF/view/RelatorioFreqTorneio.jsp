
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
										<i class="fa fa-trophy"></i><span>Torneios</span>
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
											<form action="Controller?action=relFrequenciaTorneio" method="post">
												<fmt:formatDate value="${dataAtual}" pattern="yyyy-MM-dd"
													var="dataAtual" />
												<div class="form-group">
													<div class="col-md-3">
														<label for="dtInicial" class="control-label">Data Inicial:</label>
														<input type="date" class="form-control" required name="dtInicial"
															value="<c:out value="${dataAtual}"/>" id="dtInicial" />
													</div>
													<div class="col-md-3">
														<label for="dtFinal" class="control-label">Data Final:</label>
														<input type="date" class="form-control" required name="dtFinal"
															value="<c:out value="${dataAtual}"/>" id="dtFinal" />
													</div>
													<div class="col-md-4">
														 <label for="classificacao">Classificação:</label>
														 <select class="form-control" id="classificacao" name="classificacao" required>
															<option value="">Selecione</option>
															<option value="1">Geral</option>
															<option value="2">Por Atleta</option>
															<option value="3">Por Tipo</option>
														 </select>
													</div>
													<div class="col-md-2" style="padding-top: 2%;">
														<button type="submit" class="btn btn-primary">Gerar</button>
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