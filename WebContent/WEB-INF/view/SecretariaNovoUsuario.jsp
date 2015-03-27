
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
										<i class="fa  fa-info-circle"></i> <span>Novo Usuário</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<form class="form-horizontal" role="form" action="SecretariaController?action=inserirUsuario"
										method="post">
										<c:if test="${ msg != null }">
											<div class="alert alert-success">
												<a href="#" class="close" data-dismiss="alert">&times;</a>
												<c:out value="${msg}"></c:out>
											</div>
										</c:if>
										<div class="form-group">
											<div class="col-sm-4">
												<label for="perfil" class=" control-label">Perfil:</label> <select
													class="form-control" id="sel1">
													<option value="0">Selecione</option>
													<c:forEach var="perfil" items="${listaPerfis}">
														<option value="<c:out value='${perfil.valor}'/>"><c:out
																value="${perfil.nome}" /></option>
													</c:forEach>
												</select>
											</div>
											<div class="col-sm-4">
												<label for="nome" class="control-label">Nome:</label> <input
													type="text" class="form-control" id="nome" />
											</div>
											<div class="col-sm-4">
												<label for="cref" class="control-label">CREF:</label> <input
													type="text" class="form-control" id="cref" />
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-4">
												<label for="email" class="control-label">Email:</label> <input
													type="email" class="form-control" id="email" />
											</div>
											<div class="col-sm-4">
												<label for="telresidencial" class="control-label">Telefone
													Residencial:</label> <input type="text" class="form-control"
													id="telresidencial" />
											</div>
											<div class="col-sm-4">
												<label for="telcelular" class="control-label">Telefone
													Celular:</label> <input type="text" class="form-control"
													id="telcelular" />
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10 text-right">
												<button type="submit" class="btn btn-primary">Salvar</button>
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

	<%@include file="Modals.jsp"%>


</body>
</html>

