
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
								<div class="box-content">
									<form class="form-horizontal" role="form" action="AvaliacaoFisController?action=inserirDadosRef" method="post">
										<div class="form-group">
											<div class="col-md-12">
												<label for="categoria">
													Categoria:</br>
													<small>[Selecione uma ou mais categorias, que terão as mesmas atividades e valores de referência]</small></br>
												</label>
											 	<select id="categoria" name="categoria" multiple="multiple" required>
													<option value="">Selecione</option>
													<c:forEach var="categoria" items="${listaCategorias}">
														<option value="<c:out value='${categoria.idCategoriaAvaliacao}'/>">
															<c:out value="${categoria.nmCategoria}"/> / 
															De <c:out value="${categoria.idadeMinima}"/> à <c:out value="${categoria.idadeMaxima}"/> anos /
															<c:out value="${categoria.getNomeTipo()}"/>
														</option>
						                            </c:forEach>
												</select>
											</div>
										</div>
										<hr/>
										<div class="form-group">
											<h4 class="text-center">Atividades</h4>
										</div>
										<div class="form-group">
											<div class=" col-sm-12"> 
												<table class=" col-sm-12">
													<tr>
														<th></th>
														<th>Descrição atividade</th>
														<th>Melhorar</th>
														<th>Média</th>
														<th>Bom</th>
														<th>Excelente</th>
													</tr>
													<c:forEach var="atividade" items="${listaAtividades}">
														<tr>
															<td><label style="padding: 6px 8px 0 0;"><input type="checkbox" name="<c:out value='${atividade.idAtividadeAvaliacao}'/>"></label></td>
															<td><c:out value='${atividade.capacidade}'/> / <c:out value='${atividade.teste}'/> (<c:out value='${atividade.getNomeUnidade()}'/>)</td>
															<td><input type="number" class="control-label " id="melhorar" name="melhorar<c:out value='${atividade.idAtividadeAvaliacao}'/>" /></td>
															<td><input type="number" class="control-label " id="media" name="media<c:out value='${atividade.idAtividadeAvaliacao}'/>" /></td>
															<td><input type="number" class="control-label " id="bom" name="bom<c:out value='${atividade.idAtividadeAvaliacao}'/>" /></td>
															<td><input type="number" class="control-label " id="excelente" name="excelente<c:out value='${atividade.idAtividadeAvaliacao}'/>" /></td>
														</tr>
													</c:forEach>
												</table>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10 text-right">
												<a href="AvaliacaoFisController" class="btn btn-danger" data-confirm="Deseja realmente cancelar esse cadastro?">Cancelar</a>
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
	<script src="<%=Constants.JS%>/scriptTables.js"></script>

</body>
</html>