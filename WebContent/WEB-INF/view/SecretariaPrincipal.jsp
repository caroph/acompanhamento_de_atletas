	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
										<i class="fa  fa-warning"></i>
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
											<b>Há <c:out value="${nrPendencias}"/> pendência(s) no cadastro de atletas!</b>
										</h5>
										<table class="table">
											<thead>
												<tr>
													<th>Documento(s) Pendente(s)</th>
													<th style="text-align: center;">Ocorrência(s)</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<c:if test="${listaPendencias[0].size() > 0}">
													<tr>
														<td>Termo de compromisso do manual do atleta</td>
														<td align="center">
															${fn:length(listaPendencias[0])}
														</td>
														<td align="center"><a class="btn btn-primary" data-toggle="modal" data-target="#pendencias0Modal" id="btnListarAlunos">Listar Atletas</a></td>
													</tr>
												</c:if>
												<c:if test="${listaPendencias[1].size() > 0}">
													<tr>
														<td>Declação médica</td>
														<td align="center">
															${fn:length(listaPendencias[1])}
														</td>
														<td align="center"><a class="btn btn-primary" data-toggle="modal" data-target="#pendencias1Modal" id="btnListarAlunos">Listar Atletas</a></td>
													</tr>
												</c:if>
												<c:if test="${listaPendencias[2].size() > 0}">
													<tr>
														<td>Autorização de viagem e hospedagem</td>
														<td align="center">
															${fn:length(listaPendencias[2])}
														</td>
														<td align="center"><a class="btn btn-primary" data-toggle="modal" data-target="#pendencias2Modal" id="btnListarAlunos">Listar Atletas</a></td>
													</tr>
												</c:if>
												<c:if test="${listaPendencias[3].size() > 0}">
													<tr>
														<td>Autorização de imagem</td>
														<td align="center">
															${fn:length(listaPendencias[3])}
														</td>
														<td align="center"><a class="btn btn-primary" data-toggle="modal" data-target="#pendencias3Modal" id="btnListarAlunos">Listar Atletas</a></td>
													</tr>
												</c:if>
												<c:if test="${listaPendencias[4].size() > 0}">
													<tr>
														<td>Cópia de RG</td>
														<td align="center">
															${fn:length(listaPendencias[4])}
														</td>
														<td align="center"><a class="btn btn-primary" data-toggle="modal" data-target="#pendencias4Modal" id="btnListarAlunos">Listar Atletas</a></td>
													</tr>
												</c:if>
												<c:if test="${listaPendencias[5].size() > 0}">
													<tr>
														<td>Cópia de CPF</td>
														<td align="center">
															${fn:length(listaPendencias[5])}
														</td>
														<td align="center"><a class="btn btn-primary" data-toggle="modal" data-target="#pendencias5Modal" id="btnListarAlunos">Listar Atletas</a></td>
													</tr>
												</c:if>
												<c:if test="${listaPendencias[6].size() > 0}">
													<tr>
														<td>Foto do atleta</td>
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
						<h4 class="modal-title" id="myModalLabel">Atleta(s) sem termo de compromisso cadastrado:</h4>
					</div>
					<div class="modal-body">
						<table class="table tbModal">
						<thead>
							<tr>
								<th>Nome do Atleta</th>
								<th></th>
							</tr>
						</thead>
						<tbody>					
							<c:forEach var="pendencia" items="${listaPendencias[0]}">
								<tr>
									<td class="text-left">${pendencia.value}</td>
									<td class="text-right"><a class="btn btn-primary" href="SecretariaController?action=jspAnexarDocumentosAtleta&idPessoa=${pendencia.key}&nome=${pendencia.value}">Anexar Documento</a></td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn" data-dismiss="modal"
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
						<h4 class="modal-title" id="myModalLabel">Atleta(s) sem declaração médica cadastrada:</h4>
					</div>
					<div class="modal-body">
						<table class="table tbModal">
						<thead>
							<tr>
								<th>Nome do Atleta</th>
								<th></th>
							</tr>
						</thead>
						<tbody>					
							<c:forEach var="pendencia" items="${listaPendencias[1]}">
								<tr>
									<td class="text-left">${pendencia.value}</td>
									<td class="text-right"><a class="btn btn-primary" href="SecretariaController?action=jspAnexarDocumentosAtleta&idPessoa=${pendencia.key}&nome=${pendencia.value}">Anexar Documento</a></td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn" data-dismiss="modal"
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
						<h4 class="modal-title" id="myModalLabel">Atleta(s) sem autorização de viagem e hospedagem cadastrada:</h4>
					</div>
					<div class="modal-body">
						<table class="table tbModal">
						<thead>
							<tr>
								<th>Nome do Atleta</th>
								<th></th>
							</tr>
						</thead>
						<tbody>					
							<c:forEach var="pendencia" items="${listaPendencias[2]}">
								<tr>
									<td class="text-left">${pendencia.value}</td>
									<td class="text-right"><a class="btn btn-primary" href="SecretariaController?action=jspAnexarDocumentosAtleta&idPessoa=${pendencia.key}&nome=${pendencia.value}">Anexar Documento</a></td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn" data-dismiss="modal"
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
						<h4 class="modal-title" id="myModalLabel">Atleta(s) sem autorização de imagem cadastrada:</h4>
					</div>
					<div class="modal-body">
						<table class="table tbModal">
						<thead>
							<tr>
								<th>Nome do Atleta</th>
								<th></th>
							</tr>
						</thead>
						<tbody>					
							<c:forEach var="pendencia" items="${listaPendencias[3]}">
								<tr>
									<td class="text-left">${pendencia.value}</td>
									<td class="text-right"><a class="btn btn-primary" href="SecretariaController?action=jspAnexarDocumentosAtleta&idPessoa=${pendencia.key}&nome=${pendencia.value}">Anexar Documento</a></td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn" data-dismiss="modal"
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
						<h4 class="modal-title" id="myModalLabel">Atleta(s) sem cópia do RG cadastrada:</h4>
					</div>
					<div class="modal-body">
						<table class="table tbModal">
						<thead>
							<tr>
								<th>Nome do Atleta</th>
								<th></th>
							</tr>
						</thead>
						<tbody>					
							<c:forEach var="pendencia" items="${listaPendencias[4]}">
								<tr>
									<td class="text-left">${pendencia.value}</td>
									<td class="text-right"><a class="btn btn-primary" href="SecretariaController?action=jspAnexarDocumentosAtleta&idPessoa=${pendencia.key}&nome=${pendencia.value}">Anexar Documento</a></td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn" data-dismiss="modal"
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
						<h4 class="modal-title" id="myModalLabel">Atleta(s) sem cópia do CPF cadastrada:</h4>
					</div>
					<div class="modal-body">
						<table class="table tbModal">
						<thead>
							<tr>
								<th>Nome do Atleta</th>
								<th></th>
							</tr>
						</thead>
						<tbody>					
							<c:forEach var="pendencia" items="${listaPendencias[5]}">
								<tr>
									<td class="text-left">${pendencia.value}</td>
									<td class="text-right"><a class="btn btn-primary" href="SecretariaController?action=jspAnexarDocumentosAtleta&idPessoa=${pendencia.key}&nome=${pendencia.value}">Anexar Documento</a></td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn" data-dismiss="modal"
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
						<h4 class="modal-title" id="myModalLabel">Atleta(s) sem foto cadastrada:</h4>
					</div>
					<div class="modal-body">
						<table class="table tbModal">
						<thead>
							<tr>
								<th>Nome do Atleta</th>
								<th></th>
							</tr>
						</thead>
						<tbody>					
							<c:forEach var="pendencia" items="${listaPendencias[6]}">
								<tr>
									<td class="text-left">${pendencia.value}</td>
									<td class="text-right"><a class="btn btn-primary" href="SecretariaController?action=jspAnexarDocumentosAtleta&idPessoa=${pendencia.key}&nome=${pendencia.value}">Anexar Documento</a></td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn" data-dismiss="modal"
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