	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
										<i class="fa fa-check-square"></i>
										<span>Finalizar Torneio <strong>(<c:out value="${torneio.nome}"/>)</strong></span>
									</div>
									<div class="box-icons">
										<a class="expand-link">
											<i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<form class="form-horizontal" role="form" action="TecnicoController?action=finalizarTorneio" method="post">
										<input type="hidden" name="idTorneio" value="${torneio.idTorneio}"/>
										<input type="hidden" name="nome" value="${torneio.nome}"/>
										<div class="form-group">
											 <div class="form-group col-md-6">
												 <label for="inscritosGeral">Total inscritos (geral):</label>
												 <input type="number" class="form-control" id="inscritosGeral" name="inscritosGeral" value="${torneio.inscritosGeral}" maxlength="5" required/>
											 </div>
										 	<div class="form-group col-md-6">
												<label for="inscritosClube">Total inscritos (Clube Curitibano):</label>
												<input type="number" class="form-control" id="inscritosClube" name="inscritosClube" value="${torneio.inscritosClube}" maxlength="5" required />
										 	</div>
										</div>
										<div class="form-group">
											 <div class="form-group col-md-6">
												 <label for="destaque">Atleta Destaque:</label>
												 <select class="form-control" id="destaque" name="destaque" required>
													<option value="">Selecione</option>
													<c:forEach var="atleta" items="${listaAtletas}">
							                            <c:if test="${atleta.idPessoa == torneio.idDestaque.idPessoa}">
			                                                <option selected value="<c:out value='${atleta.idPessoa}'/>"><c:out value="${atleta.nome}" /></option>
			                                            </c:if>
			                                            <c:if test="${atleta.idPessoa != torneio.idDestaque.idPessoa}">
															<option value="<c:out value='${atleta.idPessoa}'/>"><c:out value="${atleta.nome}" /></option>
														</c:if>
						                            </c:forEach>
												</select>
											 </div>
										 	<div class="form-group col-md-6">
												<label for="motivoDestaque">Motivo:</label>
												<input type="text" class="form-control" id="motivoDestaque" name="motivoDestaque" value="${torneio.motivoDestaque}" maxlength="1000"/>
										 	</div>
										</div>
										<div class="form-group">
											 <div class="form-group col-md-6">
												 <label for="fotografo">Fotógrafo:</label>
												 <input type="text" class="form-control" id="fotografo" name="fotografo" value="${torneio.fotografo}" maxlength="255" required/>
											 </div>
										 	<div class="form-group col-md-6">
												<label for="encaminhamentoMkt">Encaminhar ao marketing em:</label>
												<fmt:formatDate value="${torneio.encaminhamentoMkt}" pattern="yyyy-MM-dd" var="dtEncaminhamento" />
												<input type="date" class="form-control" id="encaminhamentoMkt" name="encaminhamentoMkt" value="${dtEncaminhamento}" required/>
										 	</div>
										</div>
										</hr>
										<div class="form-group">
											<h4 class="text-center">Resultados:</h4>
										</div>
										<c:forEach var="atleta" items="${listaAtletas}">
											<div class="form-group">
												<div class="form-group col-md-3">
													 <label>Atleta:</label>
													 <input type="text" class="form-control" value="<c:out value='${atleta.nome}'/>" disabled="disabled"/>
												</div>
												<div class="form-group col-md-3">
													 <label for="colocacao">Colocação:</label>
													 <select class="form-control" id="colocacao" name="colocacao<c:out value='${atleta.idPessoa}'/>">
														<option value="">Selecione</option>
														<c:forEach var="resultado" items="${listaResultado}">
								                            <c:if test="${atleta.colocacao == resultado.valor}">
				                                                <option selected value="<c:out value='${resultado.valor}'/>"><c:out value="${resultado.nome}" /></option>
				                                            </c:if>
				                                            <c:if test="${atleta.colocacao != resultado.valor}">
																<option value="<c:out value='${resultado.valor}'/>"><c:out value="${resultado.nome}" /></option>
															</c:if>
							                            </c:forEach>
													</select>
												</div>
											 	<div class="form-group col-md-6">
													<label>Observação:</label>
													<input type="text" class="form-control" id="observacao" name="observacao<c:out value='${atleta.idPessoa}'/>" value="<c:out value='${atleta.observacao}'/>" maxlength="1000"/>
											 	</div>
											</div>
										</c:forEach>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10 text-right">
												<a href="SecretariaController" class="btn btn-danger" data-confirm="Deseja realmente cancelar esse cadastro?">Cancelar</a>
												<button type="reset" class="btn btn-info" onclick="LimparCampos()">Limpar</button>
												<button type="submit" class="btn btn-primary" >Salvar</button>
											</div>
										</div>
									</form>
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

