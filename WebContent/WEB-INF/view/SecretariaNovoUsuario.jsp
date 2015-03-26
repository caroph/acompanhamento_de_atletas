	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
										<i class="fa  fa-info-circle"></i>
										<span>Novo Usuário</span>
									</div>
									<div class="box-icons">
										<a class="expand-link">
											<i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<form class="form-horizontal" role="form" action="#" method="post">
										<c:if test="${ msg != null }">
											<div class="alert alert-success">
										        <a href="#" class="close" data-dismiss="alert">&times;</a>
										            <c:out value="${msg}"></c:out>       
									    	</div>
								        </c:if>
										<div class="form-group">
											<label for="equipe" class="col-sm-4 control-label">Perfil:</label>
											<div class="col-sm-8">
												<select class="form-control" id="sel1">
													<option>Secretário(a)</option>
													<option>Técnico</option>
													<option>Preparador Físico</option>
													<option>Psicóogo(a)</option>
													<option>Nutricionista</option>
													<option>Fisioterapeuta</option>
												</select>
											</div>
										</div>
										<div class="form-group">
											 <label for="nome" class="col-sm-4 control-label">Nome</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="nome" />
											</div>
										</div>
										<div class="form-group">
											 <label for="nome" class="col-sm-4 control-label">CREF</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="nome" />
											</div>
										</div>
										<div class="form-group">
											 <label for="email" class="col-sm-4 control-label">Email</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="email" />
											</div>
										</div>
										<div class="form-group">
											 <label for="email" class="col-sm-4 control-label">Senha</label>
											<div class="col-sm-3">
												<input type="password" class="form-control" id="senha" />
											</div>
										</div>
										<div class="form-group">
											 <label for="email" class="col-sm-4 control-label">Confirmação de Senha</label>
											<div class="col-sm-3">
												<input type="password" class="form-control" id="confSenha" />
											</div>
										</div>
										<div class="form-group">
											 <label for="telresidencial" class="col-sm-4 control-label">Telefone Residencial</label>
											<div class="col-sm-8">
												<input type="email" class="form-control" id="telresidencial" />
											</div>
										</div>
										<div class="form-group">
											 <label for="telcelular" class="col-sm-4 control-label">Telefone Celular</label>
											<div class="col-sm-8">
												<input type="email" class="form-control" id="telcelular" />
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

