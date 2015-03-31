
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
					<div class="row">
						<div id="breadcrumb" class="col-xs-12">
							<ol class="breadcrumb">
								<li><a href="SecretariaController">Home</a></li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<div class="box-name">
										<i class="fa  fa-info-circle"></i> <span>Usuários</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i></a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content no-padding">
									<c:if test="${ msg != null && msg != ''}">
											<div class="alert alert-danger">
										        <a href="#" class="close" data-dismiss="alert">&times;</a>
										            <c:out value="${msg}"></c:out>       
									    	</div>
								        </c:if>
								        <c:if test="${ msgSucesso != null && msgSucesso != ''}">
											<div class="alert alert-success">
										        <a href="#" class="close" data-dismiss="alert">&times;</a>
										            <c:out value="${msgSucesso}"></c:out>       
									    	</div>
								        </c:if>
									<table
										class="table table-bordered table-striped table-hover table-heading table-datatable"
										id="datatable">
										<thead>
											<tr>
												<th>Nome</th>
												<th>Perfil</th>
												<th>Email</th>
												<th>Telefone</th>
												<th>Celular</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="usuario" items="${listaUsuarios}">
												<tr>
													<td id="nome"><c:out value='${usuario.nome}' /></td>
													<td id="perfil"><c:out value='${usuario.getNomePerfil()}' /></td>
						 							<td id="email"><c:out value='${usuario.email}' /></td>
													<td id="telefone"><c:out value='${usuario.telefone}' /></td>
													<td id="celular"><c:out value='${usuario.celular}' /></td>
													<td align="left">
														<a class="btn btn-info" data-toggle="modal" onClick="abrirModalUsuario('${usuario.nome}', '${usuario.getNomePerfil()}', '${usuario.email}',
														'${usuario.telefone}', '${usuario.celular}', '${usuario.CREF}')" data-target="#detalhes">Visualizar</a>
														<a class="btn btn-primary" href='SecretariaController?action=editarUsuario&idUsuario=${usuario.idPessoa}' 
														data-confirm="Deseja realmente editar o usuário selecionado?">Editar</a>
														<c:if test="${sessionScope.usuarioLogado.idPessoa != usuario.idPessoa}">
															<a class="btn btn-danger" href='SecretariaController?action=desativarUsuario&idUsuario=${usuario.idPessoa}' 
															data-confirm="Deseja realmente excluir o usuário selecionado?">Excluir</a>
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
			<!--End Content-->
		</div>
	</div>
	
	<div class="modal fade" id="detalhes" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true"
	class="modal hide fade" role="dialog" aria-labelledby="orderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Detalhes Usuário</h4>
				</div>
				<div class="modal-body body-usuario">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal" id="fechar">Fechar</button>
				</div>
			</div>
		</div>
	</div>	

	<%@include file="/layout/footer.jsp"%>
	<script src="<%=Constants.JS%>/scriptTables.js"></script>

</body>
</html>