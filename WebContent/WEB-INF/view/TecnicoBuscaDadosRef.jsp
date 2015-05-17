
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
										<i class="fa fa-flag"></i> <span>Dados de referência</span>
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
										<a class="btn btn-primary" id="novoDadosRef" href="AvaliacaoFisController?action=jspNovoDadosRef">Novos dados de referência</a>
										<thead>
											<tr>
												<th>Categoria</th>
												<th></th>
												<th></th>
												<th></th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="catAtiv" items="${categoriasAtividades}">
												<tr>
													<td><c:out value='${catAtiv.categoriaAvaliacao.nmCategoria}' /></td>
													<td align="center">
														<a class="btn btn-info" id="visualizarDadosRef" onClick="abrirModalDadosRef('${catAtiv.categoriaAvaliacao.idCategoriaAvaliacao}')">Visualizar</a>
													</td>
													<td align="center">
														<a class="btn btn-primary" href="AvaliacaoFisController?action=jspMaisDadosRef&idCategoriaAvaliacao=${catAtiv.categoriaAvaliacao.idCategoriaAvaliacao}">Incluir atividades</a>
													</td>
													<td align="center">
														<a class="btn btn-primary" href="AvaliacaoFisController?action=editarDadoRef&idCategoriaAvaliacao=${catAtiv.categoriaAvaliacao.idCategoriaAvaliacao}">Editar</a>
													</td>
													<td align="center">
														<a class="btn btn-danger" href="AvaliacaoFisController?action=desativarDadoRef&idCategoriaAvaliacao=${catAtiv.categoriaAvaliacao.idCategoriaAvaliacao}"
														data-confirm="Deseja realmente excluir todos os dados de referência da categoria selecionada?">Excluir</a>
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
			<!--End Content-->
		</div>
	</div>
	
	<div class="modal fade" id="detalhesDadosRef" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true"
		class="modal hide fade" role="dialog" aria-labelledby="orderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
					<h4 class="modal-title" id="myModalLabel">Detalhes do dado de referência</h4>
				</div>
				<div class="modal-body body-dadosRef">
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="/layout/footer.jsp"%>
	<script src="<%=Constants.JS%>/scriptTables.js"></script>

</body>
</html>