
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
													<td><c:out value='${usuario.nome}' /></td>
													<td><c:out value='${usuario.getNomePerfil()}' /></td>
													<td><c:out value='${usuario.email}' /></td>
													<td><c:out value='${usuario.telefone}' /></td>
													<td><c:out value='${usuario.celular}' /></td>
													<td align="center">
														<a class="btn btn-info" href="">Visualizar</a>
														<a class="btn btn-primary" href="" data-confirm="Deseja realmente editar o usuário selecionado?">Editar</a>
														<a class="btn btn-danger" href="" data-confirm="Deseja realmente desativar o usuário selecionado?">Desativar</a>
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

	<%@include file="/layout/footer.jsp"%>
	<script src="<%=Constants.JS%>/scriptTables.js"></script>

</body>
</html>