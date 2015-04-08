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
										<input type="hidden" name="idEndereco" value="${atleta.endereco.idEndereco}"/>
										<div class="form-group">
											<h3 class="text-center">Dados Técnicos</h3>
										</div>
										<div class="form-group">
											<div class="col-sm-3">
												<label for="tpEquipe" class=" control-label">Equipe:</label>
												<select class="form-control" id="tpEquipe" name="tpEquipe" onchange="carregaDiasTreino()" required>
													<option value="">Selecione</option>
													<c:forEach var="equipe" items="${listaEquipes}">
							                            <c:if test="${equipe.valor == atleta.idTpEquipe}">
			                                                <option selected value="<c:out value='${equipe.valor}'/>"><c:out value="${equipe.nome}" /></option>
			                                            </c:if>
			                                            <c:if test="${equipe.valor != atleta.idTpEquipe}">
															<option value="<c:out value='${equipe.valor}'/>"><c:out value="${equipe.nome}" /></option>
														</c:if>
						                            </c:forEach>
												</select>
											</div>
											<div class="col-sm-3">
												<label for="nrMatricula" class=" control-label">Nº Matrícula:</label>
												<input type="text" value="${atleta.nrMatricula}" class="form-control" id="nrMatricula" name="nrMatricula" maxlength="20" required/>
											</div>
											<div class="col-sm-3">
												<label class=" control-label">Nº  FPT:</label>
												<input type="text" value="${atleta.nrCadFPT}" class="form-control" id="nrCadFPT" name="nrCadFPT" maxlength="20" />
											</div>
											<div class="col-sm-3">
												<label class=" control-label">Nº CBT:</label>
												<input type="text" value="${atleta.nrCadCBT}" class="form-control" id="nrCadCBT" name="nrCadCBT" maxlength="20"/>
											</div>
										</div>
										<div class="form-group col-sm-12">
										
											<label for="diasTreino">Dias de Treino: <small>[Disponíveis | Selecionados]</small></label>
											 <div>
												<select multiple="multiple" id="diasTreino" name="diasTreino">
													<c:forEach var="dia" items="${listaDiasTreinos}">
														<fmt:formatDate value="${dia.hrInicio}" pattern="HH:mm" var="hrInicioF" />
														<fmt:formatDate value="${dia.hrFim}" pattern="HH:mm" var="hrFimF" />
														<c:if test="${dia.selecionado == false}">
						                            		<option value="<c:out value='${dia.idDiaTreino}'/>"><c:out value="${dia.getNomeDiaSemana()} - ${hrInicioF} às ${hrFimF}" /></option>
						                            	</c:if>
						                            	<c:if test="${dia.selecionado == true}">
						                            		<option selected value="<c:out value='${dia.idDiaTreino}'/>"><c:out value="${dia.getNomeDiaSemana()} - ${hrInicioF} às ${hrFimF}" /></option>
						                            	</c:if>
						                            </c:forEach>
												</select>
											 </div>
										</div>
										<hr/>
										<div class="form-group">
											<h3 class="text-center">Dados Pessoais</h3>
										</div>
										<div class="form-group">
											<div class="col-sm-4">
												<label for="nome" class=" control-label">Nome:</label>
												<input type="text" value="${atleta.nome}" class="form-control" id="nome" name="nome" maxlength="255" required/>
											</div>
											<div class="col-sm-4" >
												<label for="dtNascimento" class="control-label data">Data de Nascimento:</label>
												<fmt:formatDate value="${atleta.dtNascimento}" pattern="dd/MM/yyyy" var="dtNascimento" />
												<input type="text" value="${dtNascimento}" class="form-control" id="dtNascimento" name="dtNascimento" required/>
											</div>
											<div class="col-sm-4">
												<label for="email" class=" control-label">Email:</label>
												<input type="email"  value="${atleta.email}" class="form-control" id="email" name="email" maxlength="70" required/>
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
												<input type="text"  value="${atleta.RG}"  class="form-control" id="rg" name="rg" maxlength="13" required/>
											</div>
											<div class="col-sm-3">
												<label for="cpf" class=" control-label">CPF:</label>
												<input type="text"  value="${atleta.CPF}" class="form-control" id="cpf" name="cpf" required/>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-8">
												<label for="endereco" class=" control-label">Endereço Residencial:</label>
												<input type="text"  value="${atleta.endereco.endereco}" class="form-control" id="endereco" name="endereco" maxlength="255" required />
											</div>
											<div class="col-sm-1">
	  											<label for="numero" class=" control-label">Número:</label>
												<input type="number"  value="${atleta.endereco.numero}"  class="form-control" id="numero" name="numero" maxlength="11" required />
											</div>
											<div class="col-sm-3">
												<label class=" control-label">Complemento:</label>
												<input type="text"  value="${atleta.endereco.complemento}" class="form-control" id="complemento" name="complemento" maxlength="45"/>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-3">
												<label for="bairro" class="control-label">Bairro:</label>
												<input type="text"  value="${atleta.endereco.bairro}"  class="form-control" id="bairro" name="bairro" maxlength="45" required/>
											</div>
											<div class="col-sm-3">
												<label for="estado" class=" control-label">Estado:</label>
												<select class="form-control" name="estado" id="estado" name="estado" value="${atleta.endereco.estado}" required></select>
											</div>
											<div class="col-sm-6">
												<label for="cidade" class=" control-label">Cidade:</label>
												<select class="form-control" name="cidade" id="cidade" name="cidade" value="${atleta.endereco.cidade}" required></select>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-6">
												<label class=" control-label">Escola:</label>
												<input type="text"  value="${atleta.escola}"  class="form-control" id="escola" name="escola" maxlength="150"/>
											</div>
											<div class="col-sm-3">
												<label class=" control-label">Série:</label>
												<input type="text"  value="${atleta.serie}" class="form-control" id="serie" name="serie" maxlength="5"/>
											</div>
											<div class="col-sm-3">
												<label class=" control-label">Turno:</label>
												<select class="form-control" id="turno" name="turno" required>
													<option value="">Selecione</option>
													<c:forEach var="turno" items="${listaTurnos}">
							                            <c:if test="${turno.valor == atleta.idTurno}">
															<option selected value="<c:out value='${turno.valor}'/>"><c:out value="${turno.nome}" /></option>
			                                            </c:if>
			                                            <c:if test="${turno.valor != atleta.idTurno}">
			                                                <option value="<c:out value='${turno.valor}'/>"><c:out value="${turno.nome}" /></option>
														</c:if>
						                            </c:forEach>
												</select>
											</div>
										</div>
										<hr/>
										<!-- EMERGï¿½NCIA -->
										<div class="form-group">
											<h3 class="text-center">Dados de Emergência</h3>
										</div>
										<br/>
										<div class="form-group">
											<div class="col-sm-4">
												<label class=" control-label">Nome Médico Responsável:</label>
												<input type="text"  value="${atleta.nmMedicoResponsavel}" class="form-control" id="nmMedicoResponsavel" name="nmMedicoResponsavel" maxlength="255"/>
											</div>
											<div class="col-sm-4">
												<label class=" control-label">Telefone:</label>
												<input type="text"  value="${atleta.telMedicoResponsavel}" class="form-control phone" id="telMedicoResponsavel" name="telMedicoResponsavel"/>
											</div>
											<div class="col-sm-4">
												<label class=" control-label">Convênio Médico:</label>
												<input type="text"  value="${atleta.convenio}" class="form-control" id="convenio" name="convenio" maxlength="45"/>
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
												<label class=" control-label">Medicação para dor:</label>
												<input type="text"  value="${atleta.medicacaoAutorizada}" class="form-control" id="medicacaoAutorizada" name="medicacaoAutorizada" maxlength="255"/>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-2">
												<label for="flAlergias" class=" control-label">Alérgias:</label>
												<select class="form-control" id="flAlergias" name="flAlergias" required> 
													<option value="sim">Sim</option> 
													<option value="nao" selected>Não</option> 
												</select>
											</div>
											<div class="col-sm-4">
												<label class=" control-label">Descrição:</label>
												<input type="text"  value="${atleta.dsAlergias}" class="form-control" id="dsAlergias" name="dsAlergias" maxlength="1000"/>
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
												<input type="text"  value="${atleta.dsMedicacao}" class="form-control" id="dsMedicacao" name="dsMedicacao" maxlength="1000"/>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-4">
												<label for="nmContatoEmergencia" class=" control-label">Nome para emergência:</label>
												<input type="text"  value="${atleta.nmContatoEmergencia}" class="form-control" id="nmContatoEmergencia" name="nmContatoEmergencia" maxlength="255" required/>
											</div>
											<div class="col-sm-4">
												<label for="telContatoEmergencia" class=" control-label">Telefone:</label>
												<input type="text"  value="${atleta.telContatoEmergencia}"  class="form-control phone" id="telContatoEmergencia" name="telContatoEmergencia" required/>
											</div>
											<div class="col-sm-4">
												<label for="grauParentesco" class=" control-label">Grau de Parentesco:</label>
												<select class="form-control" id="grauParentesco" name="grauParentesco" required>
													<option value="">Selecione</option>
													<c:forEach var="grau" items="${listaGrauParentesco}">
							                            <c:if test="${grau.valor == atleta.idGrauParentesco}">
															<option selected value="<c:out value='${grau.valor}'/>"><c:out value="${grau.nome}" /></option>
			                                            </c:if>
			                                            <c:if test="${grau.valor != atleta.idGrauParentesco}">
			                                                <option value="<c:out value='${grau.valor}'/>"><c:out value="${grau.nome}" /></option>
														</c:if>
						                            </c:forEach>
												</select>
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
												<c:if test="${atleta.idPessoa != null}">
													<a class="btn btn-primary" href="SecretariaController?action=jspAnexarDocumentosAtleta&idPessoa=1" id="anexos">Anexar Documentos</a>
													<a class="btn btn-primary" id="vinculaResponsavel" onClick="abrirModalVinculacao('${atleta.idPessoa}')">Vincular Responsável</a>
												</c:if>
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

