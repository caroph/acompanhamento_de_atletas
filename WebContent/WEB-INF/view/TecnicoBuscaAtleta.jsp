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
										<i class="fa  fa-male"></i> <span>Atletas</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content no-padding">
									<table
										class="table table-bordered table-striped table-hover table-heading table-datatable"
										id="datatable">
										<thead>
											<tr>
												<th>Nome</th>
												<th style="text-align: center;">Equipe</th>
												<th></th>
												<th></th>
												<c:if test="${sessionScope.usuarioLogado.perfil == 6}">
													<th></th>
													<th></th>
												</c:if>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="atleta" items="${listaAtletas}">
												<tr>
													<td><c:out value='${atleta.nome}' /></td>
													<td align="center"><c:out value='${atleta.getNomeEquipe()}' /></td>
													<td align="center">
														<a class="link-blue" id="visualizarAtleta" onClick="abrirModalAtleta('${atleta.idPessoa}')"><abbr title="Visualizar"><i class="fa fa-large fa-eye"></i></abbr></a>
													</td>
													<td align="center">
														<a class="link-green" onClick="abrirModalObservacao('${atleta.idPessoa}')"><abbr title="Observação"><i class="fa fa-large fa-bell-o"></i></abbr></a>
													</td>
													<c:if test="${sessionScope.usuarioLogado.perfil == 6}">
														<td align="center">
															<a class="link-green" onClick="abrirModalAvaliacaoFis('${atleta.idPessoa}')"><abbr title="Avaliação física"><i class="fa fa-large fa-line-chart"></i></abbr></a>
														</td>	
														<td align="center">
															<a class="link-green" href="AvaliacaoFisController?action=jspHistorico&idAtleta=${atleta.idPessoa}&nome=${atleta.nome}"><abbr title="Histórico de avaliações físicas"><i class="fa fa-large fa-folder-open"></i></abbr></a>		
														</td>													
													</c:if>
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
			<!--End Content-->
		</div>
	</div>
	
	<!-- Detalhes Atleta -->
	<div class="modal fade" id="detalhes" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true"
		class="modal hide fade" role="dialog" aria-labelledby="orderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
					<h4 class="modal-title" id="myModalLabel">Detalhes Atleta</h4>
				</div>
				<div class="modal-body body-atleta">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn" data-dismiss="modal" id="fechar">Fechar</button>
				</div>
			</div>
		</div>
	</div>	
	
	<!-- Avaliação -->
	<div class="modal fade" id="avaliacaoFis" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true"
		class="modal hide fade" role="dialog" aria-labelledby="orderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
					<h4 class="modal-title" id="myModalLabel">Avaliação física</h4>
				</div>
				<div class="modal-body body-avaliacao">
				</div>
			</div>
		</div>
	</div>	
	
	<%@include file="/layout/footer.jsp"%>
	<%@include file="Modals.jsp"%>
	<script src="<%=Constants.JS%>/scriptTables.js"></script>

</body>
</html>