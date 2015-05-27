
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
										<i class="fa fa-star"></i> <span>Bonificação Geral</span>
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
											<form action="#" method="post"
												target="_blank">
												<div class="col-md-6 form-group">
													<div class="col-md-4" style="text-align: right">
														<label for="mes" class="control-label">Mês:</label>
													</div>
													<div class="col-md-8">
														<select name="mes" class="form-control" id="mes">
															<option value="0" selected>Selecione</option>
															<c:forEach var="mes" items="${listaMes}">
																<c:if test="${mesSelecionado == mes.valor}">
																	<option value="${mes.valor}" selected><c:out value="${mes.nome}"/></option>
																</c:if>
																<c:if test="${mesSelecionado != mes.valor}">
																	<option value="${mes.valor}"><c:out value="${mes.nome}"/></option>
																</c:if>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="col-md-6 form-group">
													<div class="col-md-2" style="text-align: right">
														<label for="ano" class="control-label">Ano:</label>
													</div>
													<div class="col-md-6">
														<input type="number" class="form-control" name="ano" id="ano" value="${ano}"/>
													</div>
													<div class="col-md-4" align="right">
														<button type="submit" class="link-green btn-vazio"><abbr title="Gerar relatório"><i class="fa fa-large fa-file-pdf-o"></i></abbr></button>
													</div>
												</div>
											</form>
										</div>
									</div>
								</div> 
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<div class="box-name">
										<i class="fa fa-star"></i> <span>Bonificação Individual</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<div class="row clearfix"> 
										<form action="#" method="post"
											target="_blank">
											<div class="col-md-12 form-group">
												<div class="col-md-2" style="text-align: right">
													<label for="mes" class="control-label">Atleta:</label>
												</div>
												<div class="col-md-10">
													<div class="col-md-9">
														<select name="mes" class="form-control" id="mes">
															<option value="0" selected>Selecione</option>
															<c:forEach var="atleta" items="${listaAtletas}">
																<option value="${atleta.idPessoa}"><c:out value="${atleta.nome}"/></option>
															</c:forEach>
														</select>
													</div>
													<div class="col-md-3" align="right">
														<button type="submit" class="link-green btn-vazio"><abbr title="Gerar relatório"><i class="fa fa-large fa-file-pdf-o"></i></abbr></button>
													</div>
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
			<!--End Content-->
		</div>
	</div>
	<%@include file="/layout/footer.jsp"%>
	<%@include file="Modals.jsp" %>
</body>
</html>