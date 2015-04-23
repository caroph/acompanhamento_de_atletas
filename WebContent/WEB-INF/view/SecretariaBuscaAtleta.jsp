
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file='/layout/head.jsp'%>

<body>

	<%@include file='/layout/header.jsp'%>

	<div id="main" class="container-fluid">
		<div class="row">
			<%@include file='/layout/navigationSecretaria.jsp'%>
			<!--Start Content-->
			<div id="content" class="col-xs-12 col-sm-10">
				<div id="ajax-content">
					<%@include file="Mensagem.jsp"%>
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<div class="box-name">
										<i class="fa fa-male"></i> <span>Atletas</span>
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
												<th>Nº Matrícula</th>
												<th style="text-align: center;">Telefone</th>
												<th style="text-align: center;">Equipe</th>
												<th></th>
												<th></th>
												<th></th>
												<th></th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="atleta" items="${listaAtletas}">
												<tr>
													<td><c:out value='${atleta.nome}' /></td>
													<td><c:out value='${atleta.nrMatricula}' /></td>
													<td align="center"><c:out value='${atleta.endereco.telefone}' /></td>
													<td align="center"><c:out value='${atleta.getNomeEquipe()}' /></td>
													<td align="center">
														<a class="btn btn-info" id="visualizarAtleta" onClick="abrirModalAtleta('${atleta.idPessoa}')">Visualizar</a>
													</td>
													<c:if test="${atleta.flCadastroAtivo == 1}">
														<td>
															<a class="btn btn-primary" href='SecretariaController?action=editarAtleta&idAtleta=${atleta.idPessoa}' 
															data-confirm="Deseja realmente editar o atleta selecionado?">Editar</a>
														</td>
														<td>	
															<a class="btn btn-danger" href='SecretariaController?action=desativarAtleta&idAtleta=${atleta.idPessoa}' 
																data-confirm="Deseja realmente desativar o atleta selecionado?">Desativar</a>
														</td>
														<td>	
															<a class="btn btn-primary" id="vinculaResponsavel" onClick="abrirModalVinculacao('${atleta.idPessoa}', 1)">Vincular Responsável</a>
														</td>
														<td>
															<a class="btn btn-primary" id="anexos" href="SecretariaController?action=jspAnexarDocumentosAtleta&idPessoa=${atleta.idPessoa}&nome=${atleta.nome}">Anexar Documentos</a>
														</td>
													</c:if>
													<c:if test="${atleta.flCadastroAtivo == 0}">														
														<td>
															<a class="btn btn-primary" href='SecretariaController?action=ativarAtleta&idAtleta=${atleta.idPessoa}' 
															data-confirm="Deseja realmente ativar o atleta selecionado?">Ativar</a>
														</td>														
														<td></td>
														<td></td>
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
	<div class="modal fade" id="detalhes" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true"
		class="modal hide fade" role="dialog" aria-labelledby="orderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
					<h4 class="modal-title" id="myModalLabel">Detalhes do Atleta</h4>
				</div>
				<div class="modal-body body-atleta">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn" data-dismiss="modal" id="fechar">Fechar</button>
				</div>
			</div>
		</div>
	</div>	
	<%@include file="/layout/footer.jsp"%>
	<%@include file="Modals.jsp"%>
	<script src="<%=Constants.JS%>/scriptTables.js"></script>

</body>
</html>