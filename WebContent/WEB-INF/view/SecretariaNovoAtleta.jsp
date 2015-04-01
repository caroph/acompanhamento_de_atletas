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
									<form class="form-horizontal" role="form" action="SecretariaController?action=inserirAtleta" method="post" >
										<input type="hidden" name="idAtleta" value="${atleta.idPessoa}"/>
										<div class="form-group">
											<h3 class="text-center">Dados T�cnicos</h3>
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
										<div class="form-group">
											<div class="col-sm-3">
												<label for="tpEquipe" class=" control-label">Equipe:</label>
												<select class="form-control" id="tpEquipe" name="tpEquipe" required>
													<option value="">Selecione</option>
													<c:forEach var="equipe" items="${listaEquipes}">
						                            	<option value="<c:out value='${equipe.valor}'/>"><c:out value="${equipe.nome}" /></option>
						                            </c:forEach>
												</select>
											</div>
											<div class="col-sm-3">
												<label for="nrMatricula" class=" control-label">N� Matr�cula:</label>
												<input type="text" value="${atleta.nrMatricula}" class="form-control" id="nrMatricula" name="nrMatricula" required/>
											</div>
											<div class="col-sm-3">
												<label class=" control-label">N�  FPT:</label>
												<input type="text" value="${atleta.nrCadFPT}" class="form-control" id="nrCadFPT" name="nrCadFPT"  />
											</div>
											<div class="col-sm-3">
												<label class=" control-label">N� CBT:</label>
												<input type="text" value="${atleta.nrCadCBT}" class="form-control" id="nrCadCBT" name="nrCadCBT"/>
											</div>
										</div>
										<div class="form-group col-sm-12">
										<!-- Testando Check List Group -->
<!-- 											<label class=" control-label">Dias de Treino:</label> -->
<!-- 								            <div class="well"> -->
<!-- 								        		<ul id="check-list-box" class="list-group checked-list-box"> -->
<!-- 								                  <li class="list-group-item" value="1">Cras justo odio</li> -->
<!-- 								                  <li class="list-group-item" value="2">Dapibus ac facilisis in</li> -->
<!-- 								                  <li class="list-group-item" value="3">Morbi leo risus</li> -->
<!-- 								                  <li class="list-group-item"  value="4">Porta ac consectetur ac</li> -->
<!-- 								                  <li class="list-group-item"  value="5">Vestibulum at eros</li> -->
<!-- 								                  <li class="list-group-item">Cras justo odio</li> -->
<!-- 								                  <li class="list-group-item">Dapibus ac facilisis in</li> -->
<!-- 								                  <li class="list-group-item">Morbi leo risus</li> -->
<!-- 								                  <li class="list-group-item">Porta ac consectetur ac</li> -->
<!-- 								                  <li class="list-group-item">Vestibulum at eros</li> -->
<!-- 								                </ul> -->
<!-- 								            </div> -->
<!-- 								            <input id="diasTreino" name="diasTreino" type="text" value=""/> -->
											<!-- Testando Dual List -->
<!-- 											<label for="diasTreino">Dias de Treino:</label> -->
<!-- 											 <div> -->
<!-- 											     <select multiple="multiple" name="diasTreino" required> -->
<!-- 												      <option value="option1">Atleta 1</option> -->
<!-- 												      <option value="option2">Atleta 2</option> -->
<!-- 												      <option value="option3">Atleta 3</option> -->
<!-- 												      <option value="option4">Atleta 4</option> -->
<!-- 												      <option value="option5">Atleta  5</option> -->
<!-- 												      <option value="option6">Atleta 6</option> -->
<!-- 												      <option value="option7">Atleta 7</option> -->
<!-- 												      <option value="option8">Atleta 8</option> -->
<!-- 												      <option value="option9">Atleta 9</option> -->
<!-- 												      <option value="option0">Atleta 10</option> -->
<!-- 											    </select> -->
<!-- 											 </div> -->
										</div>
										<hr/>
										<div class="form-group">
											<h3 class="text-center">Dados Pessoais</h3>
										</div>
										<div class="form-group">
											<div class="col-sm-4">
												<label for="nome" class=" control-label">Nome:</label>
												<input type="text" value="${atleta.nome}" class="form-control" id="nome" name="nome" required/>
											</div>
											<div class="col-sm-4" >
												<label for="dtNascimento" class="control-label data">Data de Nascimento:</label>
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
												<input type="text"  value="${atleta.endereco.telefone}" class="form-control phone" id="telefone" name="telefone" required/>
											</div>
											<div class="col-sm-3">
												<label for="celular" class=" control-label">Telefone Celular:</label>
												<input type="text"  value="${atleta.celular}" class="form-control phone" id="celular" name="celular" required/>
											</div>
											<div class="col-sm-3">
												<label for="rg" class=" control-label">RG:</label>
												<input type="text"  value="${atleta.RG}"  class="form-control" id="rg" name="rg" required/>
											</div>
											<div class="col-sm-3">
												<label for="cpf" class=" control-label">CPF:</label>
												<input type="text"  value="${atleta.CPF}" class="form-control" id="cpf" name="cpf" required/>
											</div>
										</div>
										<div class="form-group col-sm-12">
											<label for="endereco" class=" control-label">Endere�o Residencial:</label>
											<input type="text"  value="${atleta.endereco.endereco}" class="form-control" id="endereco" name="endereco" required />
										</div>
										<div class="form-group">
											<div class="col-sm-4">
	  											<label for="numero" class=" control-label">N�mero:</label>
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
												<select class="form-control" name="estado" id="estado" name="estado" value="${atleta.endereco.estado}" required></select>
											</div>
											<div class="col-sm-8">
												<label for="cidade" class=" control-label">Cidade:</label>
												<select class="form-control" name="cidade" id="cidade" name="cidade" value="${atleta.endereco.cidade}" required></select>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-6">
												<label class=" control-label">Escola:</label>
												<input type="text"  value="${atleta.escola}"  class="form-control" id="escola" name="escola" />
											</div>
											<div class="col-sm-3">
												<label class=" control-label">S�rie:</label>
												<input type="text"  value="${atleta.serie}" class="form-control" id="serie" name="serie" />
											</div>
											<div class="col-sm-3">
												<label class=" control-label">Turno:</label>
												<input type="text"  value="${atleta.turno}"  class="form-control" id="turno" name="turno" />
											</div>
										</div>
										<hr/>
										<!-- EMERG�NCIA -->
										<div class="form-group">
											<h3 class="text-center">Dados de Emerg�ncia</h3>
										</div>
										<br/>
										<div class="form-group">
											<div class="col-sm-4">
												<label class=" control-label">Nome M�dico Respons�vel:</label>
												<input type="text"  value="${atleta.nmMedicoResponsavel}" class="form-control" id="nmMedicoResponsavel" name="nmMedicoResponsavel" />
											</div>
											<div class="col-sm-4">
												<label class=" control-label">Telefone do M�dico:</label>
												<input type="text"  value="${atleta.telMedicoResponsavel}" class="form-control phone" id="telMedicoResponsavel" name="telMedicoResponsavel"/>
											</div>
											<div class="col-sm-4">
												<label class=" control-label">Conv�nio M�dico Hospitalar:</label>
												<input type="text"  value="${atleta.convenio}" class="form-control" id="convenio" name="convenio"/>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-4">
												<label for="acompPsicologico" class=" control-label">Acompanhamento psicol�gico externo:</label>
												<select class="form-control" id="acompPsicologico" name="acompPsicologico" required> 
													<option value="sim">Sim</option> 
													<option value="nao" selected>N�o</option> 
												</select>
<!-- 												<div class="toggle-switch toggle-switch-success"> -->
<!-- 													<label> -->
<!-- 														<input type="checkbox" checked=""> -->
<!-- 														<div class="toggle-switch-inner"></div> -->
<!-- 														<div class="toggle-switch-switch"><i class="fa fa-check"></i></div> -->
<!-- 													</label> -->
<!-- 												</div> -->
											</div>
											<div class="col-sm-8">
												<label class=" control-label">Medica��o autorizada a tomar em caso de dor:</label>
												<input type="text"  value="${atleta.medicacaoAutorizada}" class="form-control" id="medicacaoAutorizada" name="medicacaoAutorizada" />
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-2">
												<label for="flAlergias" class=" control-label">Al�rgico:</label>
												<select class="form-control" id="flAlergias" name="flAlergias" required> 
													<option value="sim">Sim</option> 
													<option value="nao" selected>N�o</option> 
												</select>
											</div>
											<div class="col-sm-4">
												<label class=" control-label">Descri��o:</label>
												<input type="text"  value="${atleta.dsAlergias}" class="form-control" id="dsAlergias" name="dsAlergias"/>
											</div>
											<div class="col-sm-2">
												<label for="flMedicacao" class=" control-label">Medica��o cont�nua:</label>
												<select class="form-control" id="flMedicacao" name="flMedicacao" required> 
													<option value="sim">Sim</option> 
													<option value="nao" selected>N�o</option> 
												</select>
											</div>
											<div class="col-sm-4">
												<label class=" control-label">Descri��o</label>
												<input type="text"  value="${atleta.dsMedicacao}" class="form-control" id="dsMedicacao" name="dsMedicacao" />
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-4">
												<label for="nmContatoEmergencia" class=" control-label">Nome para emerg�ncia:</label>
												<input type="text"  value="${atleta.nmContatoEmergencia}" class="form-control" id="nmContatoEmergencia" name="nmContatoEmergencia" required/>
											</div>
											<div class="col-sm-4">
												<label for="telContatoEmergencia" class=" control-label">Telefone:</label>
												<input type="text"  value="${atleta.telContatoEmergencia}"  class="form-control phone" id="telContatoEmergencia" name="telContatoEmergencia" required/>
											</div>
											<div class="col-sm-4">
												<label for="grauParentescoContatoEmergencia" class=" control-label">Grau de Parentesco:</label>
												<input type="tel"  value="${atleta.grauParentescoContatoEmergencia}" class="form-control" id="grauParentescoContatoEmergencia" name="grauParentescoContatoEmergencia" required/>
											</div>
										</div>
										<hr>
										<div class="form-group col-sm-4" >
											<label for="dtValidade" class="control-label data">Data Validade Cadastro:</label>
											<fmt:formatDate value="${atleta.dtValidade}" pattern="dd/MM/yyyy" var="dtValidade" />
											<input type="text"  value="${dtValidade}" class="form-control" id="dtValidade" name="dtValidade" required />
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10 text-right">
												<a href="SecretariaController" class="btn btn-danger" data-confirm="Deseja realmente cancelar esse cadastro?">Cancelar</a>
												<button type="reset" class="btn btn-info" onclick="LimparCampos()">Limpar</button>
												<a class="btn btn-primary" href="SecretariaAnexosAtleta.jsp" id="anexos">Anexar Documentos</a>
												<a class="btn btn-primary" data-toggle="modal" data-target="#basicModal">Vincular Respons�vel</a>
												<button type="submit" class="btn btn-primary" >Salvar</button>
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

