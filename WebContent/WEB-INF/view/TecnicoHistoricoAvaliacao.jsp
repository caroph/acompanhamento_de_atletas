
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
										<i class="fa fa-folder-open"></i><span>Histórico de avaliação física <strong>(<c:out value="${nomeAtleta}"/>)</strong></span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content no-padding">
									<div id="listaHistorico"  style="padding: 10px;">
										<c:forEach var="avaliacao" items="${listaAvaliacaoFis}">
												<fmt:formatDate value="${avaliacao.dtAvaliacao}" pattern="dd/MM/yyyy" var="dtFormatada" />
												<div class="row clearfix">
													<div class="col-md-11 column" style="padding-left: 0;">
														<h4><c:out value='${dtFormatada}'/></h4>
													</div>
													<c:if test="${sessionScope.usuarioLogado.perfil == 6}">
														<div class="col-md-1 column" style="padding-top: 8px;">
															<a class="link-green" data-toggle="modal" href="#novaAvaliacao" onclick="passarDadosAvaliacao('${avaliacao.idAvaliacaoFisica}')" style="padding-left: 5px;"><abbr title="Editar"><i class="fa fa-large fa-pencil"></i></abbr></a>
															<a class="link-red" href="AvaliacaoFisController?action=excluirAvaliacao&idAvaliacaoFisica=${avaliacao.idAvaliacaoFisica}" style="padding-left: 5px;" data-confirm="Deseja realmente excluir a avaliação física selecionada?"><abbr title="Excluir"><i class="fa fa-large fa-trash-o"></i></abbr></a>
														</div>
													</c:if>
												</div>
												<div class="row clearfix">
													<div class="col-md-12 column">
														<table class="table">
															<thead>
																<tr>
																	<th>Capacidade</th>
																	<th>Teste</th>
																	<th>Desempenho</th>
																	<th>Resultado</th>
																</tr>
															</thead>
															<tbody>
																<c:forEach var="resultado" items="${avaliacao.avaliacaoResultado}">
																	<tr>
																		<td><c:out value="${resultado.getCategoriaAtividade().getAtividadeAvaliacao().capacidade}"></c:out></td>
																		<td><c:out value="${resultado.getCategoriaAtividade().getAtividadeAvaliacao().teste}"></c:out></td>
																		<td><c:out value="${resultado.desempenho}"></c:out></td>
																		<td><c:out value="${resultado.resultado}"></c:out></td>
																	</tr>
																</c:forEach>
															</tbody>
														</table>
													</div>
													<div class="col-md-12 column">
														<p><b>Observação geral: </b><c:out value='${avaliacao.observacaoGeral}'/></p>
													</div>
												</div>
										</c:forEach>
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
	<%@include file="Modals.jsp"%>

</body>
</html>