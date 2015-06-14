
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
										<i class="fa fa-line-chart"></i> <span>Desempenho Geral</span>
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
											<form action="Controller?action=gerarRelatorioDesempGeral" method="post" target="_blank">
												<fmt:formatDate value="${dataAtual}" pattern="yyyy-MM-dd"
													var="dataAtual" />
												<div class="form-group">
													<div class="col-md-3">
														<label for="dtInicial" class="control-label">Data inicial:</label>
														<input type="date" class="form-control" required name="dtInicial"
															value="<c:out value="${dataAtual}"/>" id="dtInicial" />
													</div>
													<div class="col-md-3">
														<label for="dtFinal" class="control-label">Data final:</label>
														<input type="date" class="form-control" required name="dtFinal"
															value="<c:out value="${dataAtual}"/>" id="dtFinal" />
													</div>
													<div class="col-md-2" style="padding-top: 2%;">
														<button type="submit" class="link-green btn-vazio" style="margin: -5%;padding: 3%;"><abbr title="Gerar relatório"><i class="fa fa-large fa-file-pdf-o"></i></abbr></button>
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
										<i class="fa fa-line-chart"></i> <span>Desempenho Individual</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<div class="row clearfix"> 
										<form action="Controller?action=gerarRelatorioDesempAvaIndividual" method="post"
											target="_blank">
											<div class="col-md-12 form-group">
												<div class="col-md-2" style="text-align: right">
													<label for="mes" class="control-label">Atleta:</label>
												</div>
												<div class="col-md-10">
													<div class="col-md-9">
														<select name="idAtleta" class="form-control" id="idAtleta">
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