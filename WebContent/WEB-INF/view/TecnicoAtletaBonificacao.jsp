
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
										<i class="fa fa-star"></i> <span>Bonificação</span>
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
											<form action="TecnicoController?action=carregarAtletasBonificacao" method="POST">
												<div class="col-md-6 form-group">
													<div class="col-md-4" style="text-align: right">
														<label for="mes" class="control-label">Mês:</label>
													</div>
													<div class="col-md-8">
														<select name="mes" onchange="desabilitaBotoesTabela()" class="form-control" id="mes">
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
														<input type="number" onchange="desabilitaBotoesTabela()" class="form-control" name="ano" id="ano" value="${ano}"/>
													</div>
													<div class="col-md-4">
														<button type="submit" onclick="habilitaBotoesTabela()" class="btn btn-primary">Buscar Atletas</button>
													</div>
												</div>
											</form>
											<table class="table">
												<thead>
													<tr>
														<th>Atletas</th>
														<th class="text-center">Bonificação</th>
														<th class="text-center"></th>
														<th class="text-center"></th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${listaAtletas}" var="atleta">
														<c:set value="${atleta.avaliacaoDesempenho[0]}" var="bonificacao" />
														<tr>
															<td><c:out value="${atleta.nome}"/></td>
															<td align="center">															
																<c:if test="${bonificacao.idAvaliacaoDesempenho != 0}">
																	<c:if test="${bonificacao.bonificado == true}">
																		<i class="fa fa-check"></i>
																	</c:if>
																	<c:if test="${bonificacao.bonificado == false}">
																		<i class="fa fa-times"></i>
																	</c:if>
																</c:if>
															</td>
															<td align="center"><a onclick="visualizarBonificacao('${atleta.nome}', '${bonificacao.bonificado}', 
															'${bonificacao.torneios}', '${bonificacao.treinos}', '${bonificacao.avaliacoes}', '${bonificacao.rankFPT}', 
															'${bonificacao.rankCBT}', '${bonificacao.rankITF}', '${bonificacao.observacoes}')" class="link-blue"><abbr title="Visualizar"><i class="fa fa-large fa-eye"></i></abbr></a></td>
															<td align="center">
																<c:if test="${bonificacao.idAvaliacaoDesempenho != 0}">
																	<a onclick="editarBonificacao('${atleta.idPessoa}', '${bonificacao.idAvaliacaoDesempenho}', '${bonificacao.bonificado}', 
																		'${bonificacao.torneios}', '${bonificacao.treinos}', '${bonificacao.avaliacoes}', '${bonificacao.rankFPT}', 
																		'${bonificacao.rankCBT}', '${bonificacao.rankITF}', '${bonificacao.observacoes}')" class="link-green"><abbr title="Editar"><i class="fa fa-large fa-pencil"></i></abbr></a>
																</c:if>
																<c:if test="${bonificacao.idAvaliacaoDesempenho == 0}">
																	<a onclick="cadastrarBonificacao('${atleta.idPessoa}')" class="link-green"><abbr title="Cadastrar bonificação"><i class="fa fa-large fa-plus-circle"></i></abbr></a>
																</c:if>
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
			</div>
			<!--End Content-->
		</div>
	</div>
	<%@include file="/layout/footer.jsp"%>
	<%@include file="Modals.jsp" %>
</body>
</html>