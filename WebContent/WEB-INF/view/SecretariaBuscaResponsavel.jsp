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
										<i class="fa  fa-group"></i> <span>Responsáveis</span>
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
												<th style="text-align: center;">Email</th>
												<th style="text-align: center;">Celular</th>
												<th></th>
												<th></th>
												<th></th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="responsavel" items="${listaResponsaveis}">
												<tr>
													<td><c:out value='${responsavel.nome}' /></td>
													<td class="text-center"><c:out value='${responsavel.email}' /></td>
													<td class="text-center"><c:out value='${responsavel.celular}' /></td>
													<td class="text-center">
														<a class="link-blue" data-toggle="modal" href="#detalhesResp"
														onclick="abrirModalVisualizarResponsavel('${responsavel.idPessoa}', '${responsavel.nome}', '${responsavel.email}', '${responsavel.enderecos[0].telefone}', '${responsavel.enderecos[1].telefone}', '${responsavel.celular}', '${responsavel.enderecos[0].endereco}', '${responsavel.enderecos[0].numero}', '${responsavel.enderecos[0].complemento}', '${responsavel.enderecos[0].bairro}', '${responsavel.enderecos[0].estado}', '${responsavel.enderecos[0].cidade}', '${responsavel.enderecos[1].endereco}', '${responsavel.enderecos[0].numero}', '${responsavel.enderecos[1].complemento}', '${responsavel.enderecos[1].bairro}', '${responsavel.enderecos[1].estado}', '${responsavel.enderecos[1].cidade}')"
														><abbr title="Visualizar"><i class="fa fa-large fa-eye"></i></abbr></a>
													</td>
													<td class="text-center">
														<a class="link-green" href='SecretariaController?action=editarResponsavel&idResponsavel=${responsavel.idPessoa}' 
														data-confirm="Deseja realmente editar o responsável selecionado?"><abbr title="Editar"><i class="fa fa-large fa-pencil"></i></abbr></a>
													</td>
													<td class="text-center">
														<a class="link-green" data-toggle="modal" href="SecretariaController?action=enviarEmailResponsavel&emailResponsavel=${responsavel.email}"><abbr title="Enviar email"><i class="fa fa-large fa-envelope"></i></abbr></a>
													</td>
													<td class="text-center">
														<a class="link-red"  
														href='SecretariaController?action=desativarResponsavel&idResponsavel=${responsavel.idPessoa}'
														data-confirm="Deseja realmente excluir o responsável selecionado?"><abbr title="Excluir"><i class="fa fa-large fa-trash-o"></i></abbr></a>
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
	
	<div class="modal fade" id="detalhesResp" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true"
	class="modal hide fade" role="dialog" aria-labelledby="orderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Detalhes do Responsável</h4>
				</div>
				<div class="modal-body body-responsavel">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn" data-dismiss="modal" id="fechar">Fechar</button>
				</div>
			</div>
		</div>
	</div>

	<%@include file="/layout/footer.jsp"%>
	<script src="<%=Constants.JS%>/scriptTables.js"></script>

</body>
</html>