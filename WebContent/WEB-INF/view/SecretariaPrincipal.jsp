	<%@include file='/layout/header.jsp'%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<%@include file='/layout/head.jsp'%>
	
	<body>
	
	<div id="main" class="container-fluid">
		<div class="row">
			<%@include file='/layout/navigationSecretaria.jsp'%>
			<!--Start Content-->
			<div id="content" class="col-xs-12 col-sm-10">
				<div id="ajax-content">
					<c:if test="${ msg != null && msg != ''}">
						<div class="alert alert-danger">
					        <a href="#" class="close" data-dismiss="alert">&times;</a>
					            <c:out value="${msg}"></c:out>       
				    	</div>
			        </c:if>
			        <c:if test="${ msgErro != null && msgErro != ''}">
						<div class="alert alert-danger">
					        <a href="#" class="close" data-dismiss="alert">&times;</a>
					            <c:out value="${msgErro}"></c:out>       
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
										<span>Pendências</span>
									</div>
									<div class="box-icons">
										<a class="expand-link">
											<i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<c:if test="${nrPendencias > 0}">
										<h5>
											<b>Existem <c:out value="${nrPendencias}"/> pendências nos cadastros de alunos!</b>
										</h5>
										<table class="table">
											<thead>
												<tr>
													<th>Pendência</th>
													<th style="text-align: center;">Ocorrências</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<c:if test="${listaPendencias[0].size() > 0}">
													<tr>
														<td>Termos de compromisso do manual do atleta não cadastrados</td>
														<td align="center">
															${fn:length(listaPendencias[0])}
														</td>
														<td align="center"><a class="btn btn-primary" data-toggle="modal" data-target="#pendencias0Modal" id="btnListarAlunos">Listar Atletas</a></td>
													</tr>
												</c:if>
												<c:if test="${listaPendencias[1].size() > 0}">
													<tr>
														<td>Declações médicas não cadastradas</td>
														<td align="center">
															${fn:length(listaPendencias[1])}
														</td>
														<td align="center"><a class="btn btn-primary" data-toggle="modal" data-target="#pendencias1Modal" id="btnListarAlunos">Listar Atletas</a></td>
													</tr>
												</c:if>
												<c:if test="${listaPendencias[2].size() > 0}">
													<tr>
														<td>Autorizações de viagem e hospedagem não cadastradas</td>
														<td align="center">
															${fn:length(listaPendencias[2])}
														</td>
														<td align="center"><a class="btn btn-primary" data-toggle="modal" data-target="#pendencias2Modal" id="btnListarAlunos">Listar Atletas</a></td>
													</tr>
												</c:if>
												<c:if test="${listaPendencias[3].size() > 0}">
													<tr>
														<td>Autorizações de Imagem não cadastradas</td>
														<td align="center">
															${fn:length(listaPendencias[3])}
														</td>
														<td align="center"><a class="btn btn-primary" data-toggle="modal" data-target="#pendencias3Modal" id="btnListarAlunos">Listar Atletas</a></td>
													</tr>
												</c:if>
												<c:if test="${listaPendencias[4].size() > 0}">
													<tr>
														<td>Cópias de RG não cadastradas</td>
														<td align="center">
															${fn:length(listaPendencias[4])}
														</td>
														<td align="center"><a class="btn btn-primary" data-toggle="modal" data-target="#pendencias4Modal" id="btnListarAlunos">Listar Atletas</a></td>
													</tr>
												</c:if>
												<c:if test="${listaPendencias[5].size() > 0}">
													<tr>
														<td>Cópias de CPF não cadastradas</td>
														<td align="center">
															${fn:length(listaPendencias[5])}
														</td>
														<td align="center"><a class="btn btn-primary" data-toggle="modal" data-target="#pendencias5Modal" id="btnListarAlunos">Listar Atletas</a></td>
													</tr>
												</c:if>
												<c:if test="${listaPendencias[6].size() > 0}">
													<tr>
														<td>Fotos de atleta não cadastradas</td>
														<td align="center">
															${fn:length(listaPendencias[6])}
														</td>
														<td align="center"><a class="btn btn-primary" data-toggle="modal" data-target="#pendencias6Modal" id="btnListarAlunos">Listar Atletas</a></td>
													</tr>												
												</c:if>
											</tbody>
										</table>
									</c:if>
								</div>
							</div>
						</div>
					</div>		
				</div>
			</div>
			<!--End Content-->
		</div>
	</div>
	<c:if test="${listaPendencias[0].size() > 0}">
		<div class="modal fade" id="pendencias0Modal" tabindex="-1" role="dialog"	aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">x</button>
						<h4 class="modal-title" id="myModalLabel">Atletas sem termo de compromisso cadastrado</h4>
					</div>
					<div class="modal-body">
						<table class="table">
						<thead>
							<tr>
								<th class="text-center">Nome do Atleta</th>
								<th></th>
							</tr>
						</thead>
						<tbody>					
							<c:forEach var="pendencia" items="${listaPendencias[0]}">
								<tr>
									<td class="text-left">${pendencia.value}</td>
									<td class="text-right"><a class="btn btn-primary" href="SecretariaController?action=jspAnexarDocumentosAtleta&idPessoa=${pendencia.key}">Anexar Documentos</a></td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							id="fechar">Fechar</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>	
	<c:if test="${listaPendencias[1].size() > 0}">
		<div class="modal fade" id="pendencias1Modal" tabindex="-1" role="dialog"	aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">x</button>
						<h4 class="modal-title" id="myModalLabel">Atletas sem declaração médica cadastrada</h4>
					</div>
					<div class="modal-body">
						<table class="table">
						<thead>
							<tr>
								<th class="text-center">Nome do Atleta</th>
								<th></th>
							</tr>
						</thead>
						<tbody>					
							<c:forEach var="pendencia" items="${listaPendencias[1]}">
								<tr>
									<td class="text-left">${pendencia.value}</td>
									<td class="text-right"><a class="btn btn-primary" href="SecretariaController?action=jspAnexarDocumentosAtleta&idPessoa=${pendencia.key}">Anexar Documentos</a></td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							id="fechar">Fechar</button>
					</div>
				</div>
			</div>
		</div>	
	</c:if>
	<c:if test="${listaPendencias[2].size() > 0}">
		<div class="modal fade" id="pendencias2Modal" tabindex="-1" role="dialog"	aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">x</button>
						<h4 class="modal-title" id="myModalLabel">Atletas sem autorização de viagem e hospedagem cadastrada</h4>
					</div>
					<div class="modal-body">
						<table class="table">
						<thead>
							<tr>
								<th class="text-center">Nome do Atleta</th>
								<th></th>
							</tr>
						</thead>
						<tbody>					
							<c:forEach var="pendencia" items="${listaPendencias[2]}">
								<tr>
									<td class="text-left">${pendencia.value}</td>
									<td class="text-right"><a class="btn btn-primary" href="SecretariaController?action=jspAnexarDocumentosAtleta&idPessoa=${pendencia.key}">Anexar Documentos</a></td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							id="fechar">Fechar</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${listaPendencias[3].size() > 0}">
		<div class="modal fade" id="pendencias3Modal" tabindex="-1" role="dialog"	aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">x</button>
						<h4 class="modal-title" id="myModalLabel">Atletas sem autorização de imagem cadastrada</h4>
					</div>
					<div class="modal-body">
						<table class="table">
						<thead>
							<tr>
								<th class="text-center">Nome do Atleta</th>
								<th></th>
							</tr>
						</thead>
						<tbody>					
							<c:forEach var="pendencia" items="${listaPendencias[3]}">
								<tr>
									<td class="text-left">${pendencia.value}</td>
									<td class="text-right"><a class="btn btn-primary" href="SecretariaController?action=jspAnexarDocumentosAtleta&idPessoa=${pendencia.key}">Anexar Documentos</a></td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							id="fechar">Fechar</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${listaPendencias[4].size() > 0}">
		<div class="modal fade" id="pendencias4Modal" tabindex="-1" role="dialog"	aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">x</button>
						<h4 class="modal-title" id="myModalLabel">Atletas sem cópia do RG cadastrada</h4>
					</div>
					<div class="modal-body">
						<table class="table">
						<thead>
							<tr>
								<th class="text-center">Nome do Atleta</th>
								<th></th>
							</tr>
						</thead>
						<tbody>					
							<c:forEach var="pendencia" items="${listaPendencias[4]}">
								<tr>
									<td class="text-left">${pendencia.value}</td>
									<td class="text-right"><a class="btn btn-primary" href="SecretariaController?action=jspAnexarDocumentosAtleta&idPessoa=${pendencia.key}">Anexar Documentos</a></td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							id="fechar">Fechar</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${listaPendencias[5].size() > 0}">
		<div class="modal fade" id="pendencias5Modal" tabindex="-1" role="dialog"	aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">x</button>
						<h4 class="modal-title" id="myModalLabel">Atletas sem cópia do CPF cadastrada</h4>
					</div>
					<div class="modal-body">
						<table class="table">
						<thead>
							<tr>
								<th class="text-center">Nome do Atleta</th>
								<th></th>
							</tr>
						</thead>
						<tbody>					
							<c:forEach var="pendencia" items="${listaPendencias[5]}">
								<tr>
									<td class="text-left">${pendencia.value}</td>
									<td class="text-right"><a class="btn btn-primary" href="SecretariaController?action=jspAnexarDocumentosAtleta&idPessoa=${pendencia.key}">Anexar Documentos</a></td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							id="fechar">Fechar</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${listaPendencias[6].size() > 0}">
		<div class="modal fade" id="pendencias6Modal" tabindex="-1" role="dialog"	aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">x</button>
						<h4 class="modal-title" id="myModalLabel">Atletas sem foto cadastrada</h4>
					</div>
					<div class="modal-body">
						<table class="table">
						<thead>
							<tr>
								<th class="text-center">Nome do Atleta</th>
								<th></th>
							</tr>
						</thead>
						<tbody>					
							<c:forEach var="pendencia" items="${listaPendencias[6]}">
								<tr>
									<td class="text-left">${pendencia.value}</td>
									<td class="text-right"><a class="btn btn-primary" href="SecretariaController?action=jspAnexarDocumentosAtleta&idPessoa=${pendencia.key}">Anexar Documentos</a></td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							id="fechar">Fechar</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>	
	
	
	<%@include file="/layout/footer.jsp"%>
	<%@include file="Modals.jsp"%>

  </body>
</html>