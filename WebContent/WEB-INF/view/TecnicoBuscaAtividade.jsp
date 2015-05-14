
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
										<i class="fa fa-flag"></i> <span>Atividade de avaliação física</span>
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
										<a class="btn btn-primary" id="novaAtividade" data-toggle="modal" href="#atividade">Nova atividade</a>
										<thead>
											<tr>
												<th>Capacidade</th>
												<th>Teste</th>
												<th>Unidade de medida</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="atividade" items="${listaAtividades}">
												<tr>
													<td><c:out value='${atividade.capacidade}' /></td>
													<td><c:out value='${atividade.teste}' /></td>
													<td><c:out value='${atividade.getNomeUnidade()}' /></td>
													<td align="center">
														<a class="btn btn-danger" href="AvaliacaoFisController?action=desativarAtividade&idAtividade=${atividade.idAtividadeAvaliacao}"
														data-confirm="Deseja realmente excluir a atividade selecionada?">Excluir</a>
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
	<div class="modal fade bs-example-modal-sm" id="atividade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	    	<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Nova atividade de avaliação física</h4>
			</div>
			<div class="modal-body">
				<form method="POST" action="AvaliacaoFisController?action=novaAtividade">
				
					<div  class="form-group">
						<div class="col-sm-12">
							<label for="capacidade" class=" control-label">Capacidade:</label>
							<input type="text" class="form-control" id="capacidade" name="capacidade" required/>
						</div>
					</div>
					<div  class="form-group">
						<div class="col-sm-12">
							<label for="teste" class=" control-label">Teste:</label>
							<input type="text" class="form-control" id="teste" name="teste" required/>
						</div>
					</div>
					<div  class="form-group" style="padding-bottom: 28%;">
						<div class="col-md-12">
							<label for="unidade">Unidade de medida:</label>
						 	<select id="unidade" name="unidade" required>
								<option value="">Selecione</option>
								<c:forEach var="unidade" items="${listaUnidades}">
									<option value="<c:out value='${unidade.valor}'/>"><c:out value="${unidade.nome}" /></option>
	                            </c:forEach>
							</select>
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