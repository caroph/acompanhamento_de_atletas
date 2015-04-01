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
										<input type="hidden" name="idEnderecoResidencial" value='${enderecoResidencial.idEndereco}'>
										<input type="hidden" name="idEnderecoComercial" value='${enderecoComercial.idEndereco}'>
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
											<div class="col-sm-12">
												<h5><b>Dados Pessoais</b></h5>
												<hr/>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-8">
												<label for="nomeResponsavel" class="control-label">Nome</label>
												<input type="text" class="form-control" id="nome" name="nome" value='${responsavel.nome}'/>
											</div>
											<div class="col-sm-4">
												<label for="email" class="control-label">Email</label>
												<input type="email" class="form-control" id="email" name="email" value='${responsavel.email}'/>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-2">
												<label for="tel" class="control-label">Telefone Residencial</label>
												<input type="text" class="form-control phone" id="telefone" name="telefone" value='${enderecoResidencial.telefone}'/>
											</div>
											<div class="col-sm-2">
												<label for="telCom" class="control-label">Telefone Comercial</label>
												<input type="text" class="form-control phone" id="telefoneCom" name="telefoneCom" value='${enderecoComercial.telefone}'/>
											</div>
											<div class="col-sm-2">
												<label for="celular" class="control-label">Telefone Celular</label>
												<input type="text" class="form-control phone" id="celular" name="celular" value='${responsavel.celular}'/>
											</div>
										</div>
										<div class="form-group" style="margin-top: 30px;">
											<div class="col-sm-12">
												<h5><b>Endere�o Residencial</b></h5>
												<hr/>
											</div>
										</div>										
										<div class="form-group">
											<div class="col-sm-8">
												<label for="endereco" class="control-label">Endere�o</label>
												<input type="text" class="form-control" id="endereco" name="endereco" value='${enderecoResidencial.endereco}'/>
											</div>
											<div class="col-sm-1">
												<label for="numero" class="control-label">N�mero</label>
												<input type="number" class="form-control" id="numero" name="numero" value='${enderecoResidencial.numero}'/>
											</div>
											<div class="col-sm-3">
												<label for="complemento" class="control-label">Complemento</label>
												<input type="text" class="form-control" id="complemento" name="complemento" value='${enderecoResidencial.complemento}'/>
											</div>
										</div>										
										<div class="form-group">
 											<div class="col-sm-3">
												<label for="bairro" class="control-label">Bairro</label>
												<input type="text" class="form-control" id="bairro" name="bairro" value='${enderecoResidencial.bairro}'/>
											</div>
											<div class="col-sm-2">
												<label for="estadoResp" class="control-label">Estado</label>
												<select class="form-control" name="estado" id="estado" value="${enderecoResidencial.estado}"></select>
											</div>
											<div class="col-sm-2">
												<label for="cidadeResp" class="control-label">Cidade:</label>
												<select class="form-control" name="cidade" id="cidade" value="${enderecoResidencial.cidade}"></select>
											</div>
										</div>
										<div class="form-group" style="margin-top: 30px;">
											<div class="col-sm-12">
												<h5><b>Endere�o Comercial</b></h5>
												<hr/>
											</div>
										</div>	
										<div class="form-group">
											<div class="col-sm-8">
												<label for="endereco" class="control-label">Endere�o</label>
												<input type="text" class="form-control" id="enderecoCom" name="enderecoCom" value='${enderecoComercial.endereco}'/>
											</div>
											<div class="col-sm-1">
												<label for="numero" class="control-label">N�mero</label>
												<input type="number" class="form-control" id="numeroCom" name="numeroCom" value='${enderecoComercial.numero}'/>
											</div>
											<div class="col-sm-3">
												<label for="complemento" class="control-label">Complemento</label>
												<input type="text" class="form-control" id="complementoCom" name="complementoCom" value='${enderecoComercial.complemento}'/>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-3">
												<label for="bairro" class="control-label">Bairro</label>
												<input type="text" class="form-control" id="bairroCom" name="bairroCom" value='${enderecoComercial.bairro}'/>
											</div>
											<div class="col-sm-2">
												<label for="nr" class="control-label">Estado:</label>
												<select class="form-control" name="estadoCom" id="estadoCom" name="estadoCom" value='${enderecoComercial.estado}'> </select>
											</div>
											<div class="col-sm-2">
												<label for="nr" class="control-label">Cidade:</label>
												<select class="form-control" name="cidadeCom" id="cidadeCom" name="cidadeCom" value='${enderecoComercial.cidade}'> </select>
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

