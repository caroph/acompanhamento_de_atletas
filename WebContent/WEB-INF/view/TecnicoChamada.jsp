
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
										<i class="fa fa-male"></i> <span>Chamada</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<div class="col-md-12">
										<form action="#" method="post">
											<div class="col-md-4 form-group">
												<div class="col-md-4">
													<label for="dataQuadra" class="control-label">Data:</label>
												</div>
												<div class="col-md-8">
													<fmt:formatDate value="${dataAtual}" pattern="yyyy-MM-dd"
														var="dataAtual" />
													<input type="date" class="form-control" required
														onchange="BuscarPresenca()" name="diaChamada"
														value="<c:out value="${dataAtual}"/>" id="dataQuadra" />
												</div>
											</div>
											<div class="col-md-8 form-group">
												<div class="col-md-4">
													<label for="diaTreino" class="control-label">Dia de
														treino:</label>
												</div>
												<div class="col-md-8">
													<select name="diaTreino" class="form-control"
														onchange="BuscarPresenca()" required>
														<option value="0" selected>Selecione</option>
														<c:forEach var="diaTreino" items="${listaDiasTreinos}">
															<fmt:formatDate value="${diaTreino.hrInicio}"
																pattern="HH:mm" var="horaIFormatada" />
															<fmt:formatDate value="${diaTreino.hrFim}"
																pattern="HH:mm" var="horaFFormatada" />
															<c:if test="${diaTreino.selecionado == true}">
																<option selected value="${diaTreino.idDiaTreino}">
																	<c:out
																		value="${diaTreino.getNomeEquipe()} - ${diaTreino.getNomeDiaSemana()}
																	 - ${horaIFormatada} - ${horaFFormatada}"></c:out>
																</option>
															</c:if>
															<c:if test="${diaTreino.selecionado == false}">
																<option value="${diaTreino.idDiaTreino}">
																	<c:out
																		value="${diaTreino.getNomeEquipe()} - ${diaTreino.getNomeDiaSemana()}
																	 - ${horaIFormatada} - ${horaFFormatada}"></c:out>
																</option>
															</c:if>
														</c:forEach>
													</select>
												</div>
											</div>
										</form>
										<table class="table">
											<thead>
												<tr>
													<th width="60%" class="text-center">Atletas</th>
													<th width="20%" class="text-center">Treino Físico</th>
													<th width="20%" class="text-center">Treino Técnico</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="atleta" items="${listaAtletas}">
													<tr>
														<td><c:out value="${atleta.nome}" /></td>
														<td align="center">
															<a href="#modalPresenca" class="btn btn-default" data-toggle="modal">
																<c:choose> 
																	<c:when test="${atleta.presenca.estadoPresencaF == 1}">
																		<i class="fa fa-check" style="color: green;"></i>
																	</c:when>
																	<c:when test="${atleta.presenca.estadoPresencaF == 2}">
																		<i class="fa fa-ban" style="color: red;"></i>
																	</c:when>
																	<c:when test="${atleta.presenca.estadoPresencaF == 3}">
																		<i class="fa fa-trophy" style="color: yellow;"></i>
																	</c:when>
																	<c:when test="${atleta.presenca.estadoPresencaF == 4}">																		
																		<i class="fa fa-ambulance" style="color: yellow;"></i>
																	</c:when>
																	<c:when test="${atleta.presenca.estadoPresencaF == 5}">
																		<i class="fa fa-cutlery" style="color: black;"></i>
																	</c:when>
																	<c:when test="${atleta.presenca.estadoPresencaF == 6}">
																		<i class="fa fa-question" style="color: black;"></i>
																	</c:when>
																	<c:when test="${atleta.presenca.estadoPresencaF == 7}">
																		<i class="fa fa-comment" style="color: black;"></i>
																	</c:when>
																	<c:when test="${atleta.presenca.estadoPresencaF == 8}">
																		<i class="fa  fa-pencil-square-o" style="color: blue;"></i>
																	</c:when>
																	<c:when test="${atleta.presenca.estadoPresencaF == 9}">
																		<i class="fa fa-exclamation" style="color: black;"></i>
																	</c:when>
																	<c:otherwise>
																		<i class="fa fa-plus" style="color: black;"></i>
																	</c:otherwise>
																</c:choose>
															</a> 
<%-- 															<c:out value="${atleta.presenca.estadoPresencaF}" /> --%>
														</td>
														<td align="center">
															<a href="#modalPresenca" class="btn btn-default" data-toggle="modal">
																<c:choose> 
																	<c:when test="${atleta.presenca.estadoPresencaT == 1}">
																		<i class="fa fa-check" style="color: green;"></i>
																	</c:when>
																	<c:when test="${atleta.presenca.estadoPresencaT == 2}">
																		<i class="fa fa-ban" style="color: red;"></i>
																	</c:when>
																	<c:when test="${atleta.presenca.estadoPresencaT == 3}">
																		<i class="fa fa-trophy" style="color: yellow;"></i>
																	</c:when>
																	<c:when test="${atleta.presenca.estadoPresencaT == 4}">																		
																		<i class="fa fa-ambulance" style="color: yellow;"></i>
																	</c:when>
																	<c:when test="${atleta.presenca.estadoPresencaT == 5}">
																		<i class="fa fa-question" style="color: black;"></i>
																	</c:when>
																	<c:when test="${atleta.presenca.estadoPresencaT == 6}">
																		<i class="fa fa-question" style="color: black;"></i>
																	</c:when>
																	<c:when test="${atleta.presenca.estadoPresencaT == 7}">
																		<i class="fa fa-comment" style="color: black;"></i>
																	</c:when>
																	<c:when test="${atleta.presenca.estadoPresencaT == 8}">
																		<i class="fa  fa-pencil-square-o" style="color: blue;"></i>
																	</c:when>
																	<c:when test="${atleta.presenca.estadoPresencaT == 9}">
																		<i class="fa fa-exclamation" style="color: black;"></i>
																	</c:when>
																	<c:otherwise>
																		<i class="fa fa-plus" style="color: black;"></i>
																	</c:otherwise>
																</c:choose>
															</a> 
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
			</div>
			<!--End Content-->
		</div>
	</div>
	<%@include file="/layout/footer.jsp"%>

</body>
</html>