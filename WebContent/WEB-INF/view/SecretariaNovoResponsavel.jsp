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
										<i class="fa  fa-info-circle"></i> <span>Novo Responsável</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<form class="form-horizontal" role="form" action="SecretariaController?action=inserirResponsavel"
										method="post">
										<c:if test="${ msg != null }">
											<div class="alert alert-success">
												<a href="#" class="close" data-dismiss="alert">&times;</a>
												<c:out value="${msg}"></c:out>
											</div>
										</c:if>
										<div class="form-group">
											 <label for="nomeResponsavel" class="col-sm-4 control-label">Nome</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="nome" name="nome"/>
											</div>
										</div>
										<div class="form-group">
											 <label for="email" class="col-sm-4 control-label">Email</label>
											<div class="col-sm-8">
												<input type="email" class="form-control" id="email" name="email"/>
											</div>
										</div>
										<div class="form-group">
											 <label for="endereco" class="col-sm-4 control-label">Endereço</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="endereco" name="endereco" />
											</div>
										</div>
										<div class="form-group">
											 <label for="numero" class="col-sm-4 control-label">Número</label>
											<div class="col-sm-8">
												<input type="number" class="form-control" id="numero" name="numero"/>
											</div>
										</div>
										<div class="form-group">
											 <label for="complemento" class="col-sm-4 control-label">Complemento</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="complemento" name="complemento"/>
											</div>
										</div>
										<div class="form-group">
											 <label for="email" class="col-sm-4 control-label">Bairro</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="bairro" name="bairro" />
											</div>
										</div>
										<div class="form-group">
											<label for="estadoResp" class="col-sm-4 control-label">Estado:</label>
											<div class="col-sm-3">
												<select class="form-control" name="estado" id="estado"> </select>
												<input type="hidden" id="estadoSelecionado" name="estadoSelecionado"></input>
											</div>
											<label for="cidadeResp" class="col-sm-1 control-label">Cidade:</label>
											<div class="col-sm-4">
												<select class="form-control" name="cidade" id="cidade"> </select>
											</div>
										</div>
										<div class="form-group">
											 <label for="endereco" class="col-sm-4 control-label">Endereço (Comercial)</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="enderecoCom" name="enderecoCom"/>
											</div>
										</div>
										<div class="form-group">
											 <label for="numero" class="col-sm-4 control-label">Número</label>
											<div class="col-sm-8">
												<input type="number" class="form-control" id="numeroCom" name="numeroCom"/>
											</div>
										</div>
										<div class="form-group">
											 <label for="complemento" class="col-sm-4 control-label">Complemento</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="complementoCom" name="complementoCom" />
											</div>
										</div>
										<div class="form-group">
											 <label for="bairro" class="col-sm-4 control-label">Bairro</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="bairroCom" name="bairroCom"/>
											</div>
										</div>
										<div class="form-group">
											<label for="nr" class="col-sm-4 control-label">Estado:</label>
											<div class="col-sm-3">
												<select class="form-control" name="estadoCom" id="estadoCom" name="estadoCom"> </select>
											</div>
											<label for="nr" class="col-sm-1 control-label">Cidade:</label>
											<div class="col-sm-4">
												<select class="form-control" name="cidadeCom" id="cidadeCom" name="cidadeCom"> </select>
											</div>
										</div>
										<div class="form-group">
											 <label for="tel" class="col-sm-4 control-label">Telefone Residencial</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="telefone" name="telefone"/>
											</div>
										</div>
										<div class="form-group">
											 <label for="telCom" class="col-sm-4 control-label">Telefone Comercial</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="telefoneCom" name="telefoneCom"/>
											</div>
										</div>
										<div class="form-group">
											 <label for="celular" class="col-sm-4 control-label">Telefone Celular</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="celular" name="celular"/>
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

