
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
										<i class="fa fa-flag"></i> <span>Dados de referÍncia</span>
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
										<a class="btn btn-primary" id="novoDadosRef" href="AvaliacaoFisController?action=jspNovoDadosRef">Novos dados de referÍncia</a>
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
													<td><c:out value='${catAtiv.categoriaAvaliacao.nmCategoria}'/> (<c:out value='${catAtiv.categoriaAvaliacao.getNomeTipo()}'/>)</td>
													<td align="center">
														<a class="link-blue" id="visualizarDadosRef" onClick="abrirModalDadosRef('${catAtiv.categoriaAvaliacao.idCategoriaAvaliacao}')"><abbr title="Visualizar"><i class="fa fa-large fa-eye"></i></abbr></a>
													</td>
													<td align="center">
														<a class="link-green" href="AvaliacaoFisController?action=jspMaisDadosRef&idCategoriaAvaliacao=${catAtiv.categoriaAvaliacao.idCategoriaAvaliacao}"><abbr title="Incluir mais atividades"><i class="fa fa-large fa-plus-square"></i></abbr></a>
													</td>
													<td align="center">
														<a class="link-green" href="AvaliacaoFisController?action=editarDadoRef&idCategoriaAvaliacao=${catAtiv.categoriaAvaliacao.idCategoriaAvaliacao}"><abbr title="Editar"><i class="fa fa-large fa-pencil"></i></abbr></a>
													</td>
													<td align="center">
														<a class="link-red" href="AvaliacaoFisController?action=desativarDadoRef&idCategoriaAvaliacao=${catAtiv.categoriaAvaliacao.idCategoriaAvaliacao}"
														data-confirm="Deseja realmente excluir todos os dados de referÍncia da categoria selecionada?"><abbr title="Excluir"><i class="fa fa-large fa-trash-o"></i></abbr></a>
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
					<h4 class="modal-title" id="myModalLabel">Detalhes do dado de referÍncia</h4>
				</div>
				<div class="modal-body body-dadosRef">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn" data-dismiss="modal" aria-hidden="true">Fechar</button>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="/layout/footer.jsp"%>
	<script src="<%=Constants.JS%>/scriptTables.js"></script>

</body>
</html>