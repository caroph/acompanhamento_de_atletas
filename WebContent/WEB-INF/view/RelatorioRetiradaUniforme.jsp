
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
										<i class="fa fa-tag"></i> <span>Retirada de Uniforme Por Peça</span>
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
											<form action="SecretariaController?action=gerarRelatorioRetiradaUniforme" method="post" target="_blank">
												<div class="col-md-12 form-group">
												<div class="col-md-2" style="text-align: right">
													<label for="uniforme" class="control-label">Tipo de Peça:</label>
												</div>
												<div class="col-md-10">
													<div class="col-md-9">
														<select name="uniforme" class="form-control" id="uniforme">
															<option value="0" selected>Selecione</option>
															<c:forEach var="uniforme" items="${tipoUniforme}">
																<option value="${uniforme.getValor()}"><c:out value="${uniforme.getNome()}"/></option>
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
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<div class="box-name">
										<i class="fa fa-tag"></i> <span>Retirada de Uniforme Por Atleta</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<div class="row clearfix"> 
										<form action="SecretariaController?action=gerarRelatorioRetiradaAtleta" method="post" target="_blank">
											<div class="col-md-12 form-group">
												<div class="col-md-2" style="text-align: right">
													<label for="atleta" class="control-label">Atleta:</label>
												</div>
												<div class="col-md-10">
													<div class="col-md-9">
														<select name="atleta" class="form-control" id="atleta">
															<option value="0" selected>Selecione</option>
															<c:forEach var="atleta" items="${listaAtleta}">
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