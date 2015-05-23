
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file='/layout/head.jsp'%>

<body>

	<%@include file='/layout/header.jsp'%>

	<div id="main" class="container-fluid">
		<div class="row">
			<c:if test="${sessionScope.usuarioLogado.perfil == 2}">
				<%@include file='/layout/navigationNutricionista.jsp'%>
			</c:if>
			<c:if test="${sessionScope.usuarioLogado.perfil == 3 || sessionScope.usuarioLogado.perfil == 4}">
				<%@include file='/layout/navigationSaudeGeral.jsp'%>
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
										<i class="fa fa-bell"></i> <span>Observações ativas</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<div class="row clearfix"> 
										<table
											class="table table-bordered table-striped table-hover table-heading table-datatable"
											id="datatable">
											<thead>
												<tr>
													<th>Atleta</th>
													<th style="text-align: center;">Gravidade</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="observacao" items="${listaObservacoesAtivas}">
													<c:if test="${observacao.dtVisualizacao == null}">
														<tr style="color: red;">
															<td><c:out value='${observacao.atleta.nome}' /></td>
															<td><c:out value='${observacao.getNomeGravidade()}' /></td>
															<td align="center"><a class="link-red" onClick="visualizarObservacao('${observacao.idObservacao}',
															'${observacao.atleta.nome}', '${observacao.getNomeGravidade()}', '${observacao.dsObservacao}',
															'${observacao.getDisplayDataValidade()}', '${observacao.usuario.nome}', '${observacao.usuario.getNomePerfil()}')"><abbr title="Visualizar"><i class="fa fa-large fa-eye"></i></abbr></a></td>
														</tr>
													</c:if>
													<c:if test="${observacao.dtVisualizacao != null}">
														<tr>
															<td><c:out value='${observacao.atleta.nome}' /></td>
															<td><c:out value='${observacao.getNomeGravidade()}' /></td>
															<td align="center"><a class="link-blue" onClick="visualizarObservacao(0,
															'${observacao.atleta.nome}', '${observacao.getNomeGravidade()}', '${observacao.dsObservacao}',
															'${observacao.getDisplayDataValidade()}', '${observacao.usuario.nome}', '${observacao.usuario.getNomePerfil()}')"><abbr title="Visualizar"><i class="fa fa-large fa-eye"></i></abbr></a></td>
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
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<div class="box-name">
										<i class="fa fa-bell"></i> <span>Minhas observações</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<div class="row clearfix"> 
										<table
											class="table table-bordered table-striped table-hover table-heading table-datatable"
											id="datatable2">
											<thead>
												<tr>
													<th>Atleta</th>
													<th style="text-align: center;">Gravidade</th>
													<th>Data Inserção</th>
													<th></th>
													<th></th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="observacao" items="${listaObservacoesMinhas}">
													<tr>
														<td><c:out value='${observacao.atleta.nome}' /></td>
														<td align="center"><c:out value='${observacao.getNomeGravidade()}' /></td>
														<td><c:out value='${observacao.getDisplayDataGeracao()}' /></td>
														<td align="center"><a class="link-blue" onClick="visualizarObservacao(0,
														'${observacao.atleta.nome}', '${observacao.getNomeGravidade()}', '${observacao.dsObservacao}',
														'${observacao.getDisplayDataValidade()}', '${observacao.usuario.nome}', '${observacao.usuario.getNomePerfil()}')"><abbr title="Visualizar"><i class="fa fa-large fa-eye"></i></abbr></a></td>
														<td align="center">
															<c:if test="${observacao.flCadastroAtivo == 1}">
																<a class="link-green" onClick="modalEditarObservacao('${observacao.atleta.idPessoa}', 
																'${observacao.dtValidade}', '${observacao.gravidade}', '${observacao.dsObservacao}', '${observacao.idObservacao}')"><abbr title="Editar"><i class="fa fa-large fa-pencil"></i></abbr></a>
															</c:if>
														</td>
														<td align="center">
															<c:if test="${observacao.flCadastroAtivo == 1}">
																<a class="link-red" data-confirm="Deseja realmente desativar esta observação?" 
																href="Controller?action=desativarObservacao&idObservacao=${observacao.idObservacao}"><abbr title="Desativar"><i class="fa fa-large fa-minus-square"></i></abbr></a>
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
			<!--End Content-->
		</div>
	</div>
	<%@include file="Modals.jsp" %>
	<%@include file="/layout/footer.jsp"%>
	<script src="<%=Constants.JS%>/scriptTables.js"></script> 
</body>
</html>