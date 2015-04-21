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
					<%@include file="Mensagem.jsp"%>
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
										<input type="hidden" name="idResponsavel" value='${responsavel.idPessoa}'>
										<input type="hidden" name="idEnderecoResidencial" value='${enderecoResidencial.idEndereco}'>
										<input type="hidden" name="idEnderecoComercial" value='${enderecoComercial.idEndereco}'>
   										<div class="form-group">
											<h4 class="text-center">Dados Pessoais</h4>
											<hr/>
										</div>
										<div class="form-group">
											<div class="col-sm-8">
												<label for="nomeResponsavel" class="control-label">Nome</label>
												<input type="text" class="form-control" id="nome" name="nome" value='${responsavel.nome}' required/>
											</div>
											<div class="col-sm-4">
												<label for="email" class="control-label">Email</label>
												<input type="email" class="form-control" id="email" name="email" value='${responsavel.email}' required/>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-2">
												<label for="tel" class="control-label">Telefone Residencial</label>
												<input type="text" class="form-control phone" id="telefone" name="telefone" value='${enderecoResidencial.telefone}' required/>
											</div>
											<div class="col-sm-2">
												<label for="telCom" class="control-label">Telefone Comercial</label>
												<input type="text" class="form-control phone" id="telefoneCom" name="telefoneCom" value='${enderecoComercial.telefone}' required/>
											</div>
											<div class="col-sm-2">
												<label for="celular" class="control-label">Telefone Celular</label>
												<input type="text" class="form-control phone" id="celular" name="celular" value='${responsavel.celular}' required/>
											</div>
										</div>
										<div class="form-group">
											<h4 class="text-center">Endereço Residencial</h4>
											<hr/>						
										</div>			
										<div class="form-group">
											<div class="col-sm-8">
												<label for="endereco" class="control-label">Endereço</label>
												<input type="text" class="form-control" id="endereco" name="endereco" value='${enderecoResidencial.endereco}' required/>
											</div>
											<div class="col-sm-1">
												<label for="numero" class="control-label">Número</label>
												<input type="number" class="form-control" id="numero" name="numero" value='${enderecoResidencial.numero}' required/>
											</div>
											<div class="col-sm-3">
												<label for="complemento" class="control-label">Complemento</label>
												<input type="text" class="form-control" id="complemento" name="complemento" value='${enderecoResidencial.complemento}' required/>
											</div>
										</div>										
										<div class="form-group">
 											<div class="col-sm-3">
												<label for="bairro" class="control-label">Bairro</label>
												<input type="text" class="form-control" id="bairro" name="bairro" value='${enderecoResidencial.bairro}' required/>
											</div>
											<div class="col-sm-3">
												<label for="estadoResp" class="control-label">Estado</label>
												<select class="form-control" name="estado" id="estado" value="${enderecoResidencial.estado}" required></select>
											</div>
											<div class="col-sm-6">
												<label for="cidadeResp" class="control-label">Cidade:</label>
												<select class="form-control" name="cidade" id="cidade" value="${enderecoResidencial.cidade}" required></select>
											</div>
										</div>
										<div class="form-group">
											<h4 class="text-center">Endereço Comercial</h4>
											<hr/>	
										</div>
										<div class="form-group">
											<div class="col-sm-8">
												<label for="endereco" class="control-label">Endereço</label>
												<input type="text" class="form-control" id="enderecoCom" name="enderecoCom" value='${enderecoComercial.endereco}' required/>
											</div>
											<div class="col-sm-1">
												<label for="numero" class="control-label">Número</label>
												<input type="number" class="form-control" id="numeroCom" name="numeroCom" value='${enderecoComercial.numero}' required/>
											</div>
											<div class="col-sm-3">
												<label for="complemento" class="control-label">Complemento</label>
												<input type="text" class="form-control" id="complementoCom" name="complementoCom" value='${enderecoComercial.complemento}' required/>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-3">
												<label for="bairro" class="control-label">Bairro</label>
												<input type="text" class="form-control" id="bairroCom" name="bairroCom" value='${enderecoComercial.bairro}' required/>
											</div>
											<div class="col-sm-3">
												<label for="nr" class="control-label">Estado:</label>
												<select class="form-control" name="estadoCom" id="estadoCom" name="estadoCom" value='${enderecoComercial.estado}' required> </select>
											</div>
											<div class="col-sm-6">
												<label for="nr" class="control-label">Cidade:</label>
												<select class="form-control" name="cidadeCom" id="cidadeCom" name="cidadeCom" value='${enderecoComercial.cidade}' required> </select>
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

