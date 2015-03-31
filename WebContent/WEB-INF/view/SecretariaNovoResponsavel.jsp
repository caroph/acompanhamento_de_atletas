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
										<i class="fa  fa-info-circle"></i> <span>Novo Respons�vel</span>
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
										<input type="hidden" name="idResponsavel" value='${responsavel.idPessoa}'>
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
										<div class="form-group">
											 <label for="nomeResponsavel" class="col-sm-4 control-label">Nome</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="nome" name="nome" value='${responsavel.nome}'/>
											</div>
										</div>
										<div class="form-group">
											 <label for="email" class="col-sm-4 control-label">Email</label>
											<div class="col-sm-8">
												<input type="email" class="form-control" id="email" name="email" value='${responsavel.email}'/>
											</div>
										</div>
										<div class="form-group">
											 <label for="endereco" class="col-sm-4 control-label">Endere�o</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="endereco" name="endereco" value='${enderecoResidencial.endereco}'/>
											</div>
										</div>
										<div class="form-group">
											 <label for="numero" class="col-sm-4 control-label">N�mero</label>
											<div class="col-sm-8">
												<input type="number" class="form-control" id="numero" name="numero" value='${enderecoResidencial.numero}'/>
											</div>
										</div>
										<div class="form-group">
											 <label for="complemento" class="col-sm-4 control-label">Complemento</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="complemento" name="complemento" value='${enderecoResidencial.complemento}'/>
											</div>
										</div>
										<div class="form-group">
											 <label for="email" class="col-sm-4 control-label">Bairro</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="bairro" name="bairro" value='${enderecoResidencial.bairro}'/>
											</div>
										</div>
										<div class="form-group">
											<label for="estadoResp" class="col-sm-4 control-label">Estado</label>
											<div class="col-sm-3">
												<select class="form-control" name="estado" id="estado" value="${enderecoResidencial.estado}"></select>
											</div>
											<label for="cidadeResp" class="col-sm-1 control-label">Cidade:</label>
											<div class="col-sm-4">
												<select class="form-control" name="cidade" id="cidade" value="${enderecoResidencial.cidade}"></select>
											</div>
										</div>
										<div class="form-group">
											 <label for="endereco" class="col-sm-4 control-label">Endere�o (Comercial)</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="enderecoCom" name="enderecoCom" value='${enderecoComercial.endereco}'/>
											</div>
										</div>
										<div class="form-group">
											 <label for="numero" class="col-sm-4 control-label">N�mero</label>
											<div class="col-sm-8">
												<input type="number" class="form-control" id="numeroCom" name="numeroCom" value='${enderecoComercial.numero}'/>
											</div>
										</div>
										<div class="form-group">
											 <label for="complemento" class="col-sm-4 control-label">Complemento</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="complementoCom" name="complementoCom" value='${enderecoComercial.complemento}'/>
											</div>
										</div>
										<div class="form-group">
											 <label for="bairro" class="col-sm-4 control-label">Bairro</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="bairroCom" name="bairroCom" value='${enderecoComercial.bairro}'/>
											</div>
										</div>
										<div class="form-group">
											<label for="nr" class="col-sm-4 control-label">Estado:</label>
											<div class="col-sm-3">
												<select class="form-control" name="estadoCom" id="estadoCom" name="estadoCom" value='${enderecoComercial.estado}'> </select>
											</div>
											<label for="nr" class="col-sm-1 control-label">Cidade:</label>
											<div class="col-sm-4">
												<select class="form-control" name="cidadeCom" id="cidadeCom" name="cidadeCom" value='${enderecoComercial.cidade}'> </select>
											</div>
										</div>
										<div class="form-group">
											 <label for="tel" class="col-sm-4 control-label">Telefone Residencial</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="telefone" name="telefone" value='${enderecoResidencial.telefone}'/>
											</div>
										</div>
										<div class="form-group">
											 <label for="telCom" class="col-sm-4 control-label">Telefone Comercial</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="telefoneCom" name="telefoneCom" value='${enderecoComercial.telefone}'/>
											</div>
										</div>
										<div class="form-group">
											 <label for="celular" class="col-sm-4 control-label">Telefone Celular</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="celular" name="celular" value='${responsavel.celular}'/>
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

