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
										<i class="fa  fa-info-circle"></i> <span>Responsáveis</span>
									</div>
									<div class="box-icons">
										</a> <a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content no-padding">
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
									<table
										class="table table-bordered table-striped table-hover table-heading table-datatable"
										id="datatable">
										<thead>
											<tr>
												<th>Nome</th>
												<th></th>
												<th></th>
												<th></th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="responsavel" items="${listaResponsaveis}">
												<tr>
													<td class="text-left" width="75%"><c:out value='${responsavel.nome}' /></td>
													<td class="text-center" width="5%">
														<a class="btn btn-primary" href='SecretariaController?action=editarResponsavel&idResponsavel=${responsavel.idPessoa}' 
														data-confirm="Deseja realmente editar o responsï¿½vel selecionado?">Editar</a>
													</td>
													<td class="text-center" width="5%">
														<a data-toggle="modal" href="#detalhes">Detalhes</a>
													</td>
													<td class="text-center" width="5%">
														<a class="btn btn-danger"  
														href='SecretariaController?action=desativarResponsavel&idResponsavel=${responsavel.idPessoa}'
														data-confirm="Deseja realmente excluir o responsï¿½vel selecionado?">Deletar</a>
													</td>
													<td class="text-center" width="10%">
														<a data-toggle="modal" href="#enviarEmail">Enviar Email</a>
													</td>
												</tr>
											</c:forEach>
											<c:forEach var="treino" items="${listaDiasTreinos}">
												<tr>
													<td><c:out value='${treino.dsTpEquipe}' /></td>
													<td><c:out value='${treino.dsDiaSemana}' /></td>
													<fmt:formatDate value="${treino.hrInicio}" pattern="HH:mm"
														var="horaIFormatada" />
													<td align="center"><c:out value='${horaIFormatada}' /></td>
													<fmt:formatDate value="${treino.hrFim}" pattern="HH:mm"
														var="horaFFormatada" />
													<td align="center"><c:out value='${horaFFormatada}' /></td>
													<td align="center"><a class="btn btn-danger"
														href='SecretariaController?action=desativarDiaTreino&idDiaTreino=${treino.idDiaTreino}'
														data-confirm="Deseja realmente excluir o dia de treino selecionado?">Excluir</a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
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
	<script src="<%=Constants.JS%>/scriptTables.js"></script>

</body>
</html>