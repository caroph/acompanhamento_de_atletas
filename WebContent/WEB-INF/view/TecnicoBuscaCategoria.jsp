
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
										<i class="fa fa-flag"></i> <span>Categoria de avaliação física</span>
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
										<a class="btn btn-primary" id="novaCategoria" data-toggle="modal" href="#categoria">Nova categoria</a>
										<thead>
											<tr>
												<th>Nome</th>
												<th>Tipo</th>
												<th align="center">Idade mínima</th>
												<th align="center">Idade máxima</th>
												<th>Sexo</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="categoria" items="${listaCategorias}">
												<tr>
													<td><c:out value='${categoria.nmCategoria}' /></td>
													<td><c:out value='${categoria.getNomeTipo()}' /></td>
													<td><c:out value='${categoria.idadeMinima}' /></td>
													<td align="center"><c:out value='${categoria.idadeMaxima}' /></td>
													<td align="center"><c:out value='${categoria.getNomeSexo()}' /></td>
													<td align="center">
														<a class="link-red" href="AvaliacaoFisController?action=desativarCategoria&idCategoria=${categoria.idCategoriaAvaliacao}"
														data-confirm="Deseja realmente excluir a categoria selecionada?"><abbr title="Excluir"><i class="fa fa-large fa-trash-o"></i></abbr></a>
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
	
	<!-- Nova Atividade -->
	<div class="modal fade bs-example-modal-sm" id="categoria" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	    	<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Nova categoria de avaliação física</h4>
			</div>
			<div class="modal-body">
				<form method="POST" action="AvaliacaoFisController?action=novaCategoria">
				
					<div  class="form-group">
						<div class="col-sm-12">
							<label for="nome" class=" control-label">Nome:</label>
							<input type="text" class="form-control" id="nome" name="nome" required/>
						</div>
					</div>
					<div  class="form-group">
						<div class="col-md-12">
							<label for="tipo" class=" control-label">Tipo:</label></br>
							<c:forEach var="tipo" items="${listaTipo}">
								<label style="padding: 5px 22px 5px 0;"><input type="checkbox" name="<c:out value='${tipo.valor}'/>" value="true"> <c:out value="${tipo.nome}" /></label>
                            </c:forEach>
						</div>
					</div>
					<div  class="form-group">
						<div class="col-sm-12">
							<label for="idadeMin" class=" control-label">Idade mínima:</label>
							<input type="number" class="form-control" id="idadeMin" name="idadeMin" required/>
						</div>
					</div>
					<div  class="form-group">
						<div class="col-sm-12">
							<label for="idadeMax" class=" control-label">Idade máxima:</label>
							<input type="number" class="form-control" id="idadeMax" name="idadeMax" required/>
						</div>
					</div>
					<div  class="form-group" style="padding-bottom: 46%;">
						<div class="col-md-12">
							<label for="sexo" class=" control-label">Sexo:</label></br>
							<c:forEach var="sexo" items="${listaSexo}">
								<label style="padding: 5px 22px 5px 0;"><input type="checkbox" name="<c:out value='${sexo.valor}'/>" value="true"> <c:out value="${sexo.nome}" /></label>
                            </c:forEach>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">Salvar</button>
						<button type="button" class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
					</div>
				</form>
			</div>
	    </div>
	  </div>
	</div>

	<%@include file="/layout/footer.jsp"%>
	<script src="<%=Constants.JS%>/scriptTables.js"></script>

</body>
</html>