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
										<i class="fa  fa-info-circle"></i>
										<span>Cadastro do Atleta</span>
									</div>
									<div class="box-icons">
										<a class="expand-link">
											<i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<form class="form-horizontal" role="form" action="SecretariaController?action=inserirAtleta" method="post">
										<input type="hidden" name="idAtleta" value="${atleta.idPessoa}"/>
										<div class="form-group">
											<h3 class="text-center">Dados Técnicos</h3>
										</div>
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
<!-- 										<div class="form-group"> -->
<!-- 											<label for="diasTreinamento" class="col-sm-4 control-label">Dias da semana que treina:</label> -->
<!-- 											<div class="col-sm-8 form-inline"> -->
<!-- 												<div class="checkbox"> -->
<!-- 													 <label><input type="checkbox" /> Segunda</label> -->
<!-- 												</div> -->
<!-- 												<div class="checkbox"> -->
<!-- 													 <label><input type="checkbox" /> Terça</label> -->
<!-- 												</div> -->
<!-- 												<div class="checkbox"> -->
<!-- 													 <label><input type="checkbox" /> Quarta</label> -->
<!-- 												</div> -->
<!-- 												<div class="checkbox"> -->
<!-- 													 <label><input type="checkbox" /> Quinta</label> -->
<!-- 												</div> -->
<!-- 												<div class="checkbox"> -->
<!-- 													 <label><input type="checkbox" /> Sexta</label> -->
<!-- 												</div> -->
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 										<div class="form-group"> -->
<!-- 											<label for="equipe" class="col-sm-4 control-label">Equipe:</label> -->
<!-- 											<div class="col-sm-8"> -->
<!-- 												<select class="form-control" id="sel1"> -->
<!-- 													<option>Equipe</option> -->
<!-- 													<option>Pré-Equipe</option> -->
<!-- 												</select> -->
<!-- 											</div> -->
<!-- 										</div> -->
										
										<div class="form-group">
											<div class="col-sm-4">
												<label for="nrMatricula" class=" control-label">Nº Matrícula Clube Curitibano:</label>
												<input type="text" value="${atleta.nrMatricula}" class="form-control" id="nrMatricula" name="nrMatricula" required/>
											</div>
											<div class="col-sm-4">
												<label class=" control-label">Nº Cadastro FPT:</label>
												<input type="text" value="${atleta.nrCadFPT}" class="form-control" id="nrCadFPT" name="nrCadFPT"  />
											</div>
											<div class="col-sm-4">
												<label class=" control-label">Nº Cadastro CBT:</label>
												<input type="text" value="${atleta.nrCadCBT}" class="form-control" id="nrCadCBT" name="nrCadCBT"/>
											</div>
										</div>
										<hr/>
										<div class="form-group">
											<h3 class="text-center">Dados Pessoais</h3>
										</div>
										<div class="form-group">
											<div class="col-sm-4">
												<label for="nome" class=" control-label">Nome:</label>
												<input type="text" value="${atleta.nome}" class="form-control" id="nome" name="name" required/>
											</div>
											<div class="col-sm-4" >
												<label for="dtNascimento" class=" control-label">Data de Nascimento:</label>
												<fmt:formatDate value="${atleta.dtNascimento}" pattern="dd/MM/yyyy" var="dtNascimento" />
												<input type="text" value="${dtNascimento}" class="form-control" id="dtNascimento" name="dtNascimento" required/>
											</div>
											<div class="col-sm-4">
												<label for="email" class=" control-label">Email:</label>
												<input type="email"  value="${atleta.email}" class="form-control" id="email" name="email" required/>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-3">
												<label for="telefone" class=" control-label">Telefone Residencial:</label>
												<input type="number"  value="${atleta.endereco.telefone}" class="form-control" id="telefone" name="telefone" required/>
											</div>
											<div class="col-sm-3">
												<label for="celular" class=" control-label">Telefone Celular:</label>
												<input type="number"  value="${atleta.celular}" class="form-control" id="celular" name="celular" required/>
											</div>
											<div class="col-sm-3">
												<label for="rg" class=" control-label">RG:</label>
												<input type="text"  value="${atleta.rg}"  class="form-control" id="rg" name="rg" required/>
											</div>
											<div class="col-sm-3">
												<label for="cpf" class=" control-label">CPF:</label>
												<input type="text"  value="${atleta.cpf}" class="form-control" id="cpf" name="cpf" required/>
											</div>
										</div>
										<div class="form-group col-sm-12">
											<label for="endereco" class=" control-label">Endereço Residencial:</label>
											<input type="email"  value="${atleta.endereco.endereco}" class="form-control" id="endereco" name="endereco" required />
										</div>
										<div class="form-group">
											<div class="col-sm-4">
	  											<label for="numero" class=" control-label">Número:</label>
												<input type="number"  value="${atleta.endereco.numero}"  class="form-control" id="numero" name="numero" required />
											</div>
											<div class="col-sm-4">
												<label class=" control-label">Complemento:</label>
												<input type="text"  value="${atleta.endereco.complemento}" class="form-control" id="complemento" name="complemento" />
											</div>
											<div class="col-sm-4">
												<label for="bairro" class="control-label">Bairro:</label>
												<input type="text"  value="${atleta.endereco.bairro}"  class="form-control" id="bairro" name="bairro" required/>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-4">
												<label for="estado" class=" control-label">Estado:</label>
												<select class="form-control" name="estado" id="estado" name="estado" required></select>
											</div>
											<div class="col-sm-8">
												<label for="cidade" class=" control-label">Cidade:</label>
												<select class="form-control" name="cidade" id="cidade" name="cidade" required></select>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-6">
												<label class=" control-label">Escola:</label>
												<input type="text"  value="${atleta.escola}"  class="form-control" id="escola" name="escola" />
											</div>
											<div class="col-sm-3">
												<label class=" control-label">Série:</label>
												<input type="text"  value="${atleta.serie}" class="form-control" id="serie" name="serie" />
											</div>
											<div class="col-sm-3">
												<label class=" control-label">Turno:</label>
												<input type="text"  value="${atleta.turno}"  class="form-control" id="turno" name="turno" />
											</div>
										</div>
										<hr/>
										<!-- EMERGÊNCIA -->
										<div class="form-group">
											<h3 class="text-center">Dados de Emergência</h3>
										</div>
										<br/>
										<div class="form-group">
											<div class="col-sm-4">
												<label class=" control-label">Nome Médico Responsável:</label>
												<input type="text"  value="${atleta.nmMedicoResponsavel}" class="form-control" id="nmMedicoResponsavel" name="nmMedicoResponsavel" />
											</div>
											<div class="col-sm-4">
												<label class=" control-label">Telefone do Médico:</label>
												<input type="number"  value="${atleta.telMedicoResponsavel}" class="form-control" id="telMedicoResponsavel" name="telMedicoResponsavel"/>
											</div>
											<div class="col-sm-4">
												<label class=" control-label">Convênio Médico Hospitalar:</label>
												<input type="text"  value="${atleta.convenio}" class="form-control" id="convenio" name="convenio"/>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-4">
												<label for="acompPsicologico" class=" control-label">Acompanhamento psicológico externo:</label>
												<select class="form-control" id="acompPsicologico" name="acompPsicologico" required> 
													<option value="sim">Sim</option> 
													<option value="nao" selected>Não</option> 
												</select>
											</div>
											<div class="col-sm-8">
												<label class=" control-label">Medicação autorizada a tomar em caso de dor:</label>
												<input type="text"  value="${atleta.medicacaoAutorizaca}" class="form-control" id="medicacaoAutorizada" name="medicacaoAutorizada" />
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-2">
												<label for="flAlergias" class=" control-label">Alérgico:</label>
												<select class="form-control" id="flAlergias" name="flAlergias" required> 
													<option value="sim">Sim</option> 
													<option value="nao" selected>Não</option> 
												</select>
											</div>
											<div class="col-sm-4">
												<label class=" control-label">Descrição:</label>
												<input type="text"  value="${atleta.dsAlergias}" class="form-control" id="dsAlergias" name="dsAlergias"/>
											</div>
											<div class="col-sm-2">
												<label for="flMedicacao" class=" control-label">Medicação contínua:</label>
												<select class="form-control" id="flMedicacao" name="flMedicacao" required> 
													<option value="sim">Sim</option> 
													<option value="nao" selected>Não</option> 
												</select>
											</div>
											<div class="col-sm-4">
												<label class=" control-label">Descrição</label>
												<input type="text"  value="${atleta.dsMedicacao}" class="form-control" id="dsMedicacao" name="dsMedicacao" />
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-4">
												<label for="nmContatoEmergencia" class=" control-label">Nome para emergência:</label>
												<input type="text"  value="${atleta.nmContatoEmergencia}" class="form-control" id="nmContatoEmergencia" name="nmContatoEmergencia" required/>
											</div>
											<div class="col-sm-4">
												<label for="telContatoEmergencia" class=" control-label">Telefone:</label>
												<input type="number"  value="${atleta.telContatoEmergencia}"  class="form-control" id="telContatoEmergencia" name="telContatoEmergencia" required/>
											</div>
											<div class="col-sm-4">
												<label for="grauParentescoContatoEmergencia" class=" control-label">Grau de Parentesco:</label>
												<input type="tel"  value="${atleta.grauParentescoContatoEmergencia}" class="form-control" id="grauParentescoContatoEmergencia" name="grauParentescoContatoEmergencia" required/>
											</div>
										</div>
										<hr>
										<div class="form-group col-sm-4" >
											<label for="dtValidade" class=" control-label">Data Validade Cadastro:</label>
											<fmt:formatDate value="${atleta.dtValidade}" pattern="dd/MM/yyyy" var="dtValidade" />
											<input type="text"  value="${dtValidade}" class="form-control" id="dtValidade" name="dtValidade" required />
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10 text-right">
												<a href="SecretariaController" class="btn btn-danger" data-confirm="Deseja realmente cancelar esse cadastro?">Cancelar</a>
												<button type="reset" class="btn btn-info" onclick="LimparCampos()">Limpar</button>
												<a class="btn btn-primary" href="SecretariaAnexosAtleta.jsp" id="anexos">Anexar Documentos</a>
												<a class="btn btn-primary" data-toggle="modal" data-target="#basicModal">Vincular Responsável</a>
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

