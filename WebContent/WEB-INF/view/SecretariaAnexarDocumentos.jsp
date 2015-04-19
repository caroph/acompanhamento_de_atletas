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
										<i class="fa  fa-info-circle"></i> <span>Anexar Documento</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<table class="table">
										<thead>
										<tr>
											<th width="33%"><strong>Documento</strong></th>
											<th width="33%" class="text-center">Situação</th>
											<th width="34%"></th>
										</tr>
										</thead>
										<tbody>		
											<c:choose>
												<c:when test="${fotoAtleta != null}">
													<tr>
														<td><a data-toggle="modal" href="#visualizarDoc" onclick="visualizarDoc('${fotoAtleta.src}')">Foto do Atleta</a></td>
														<td class="text-center"><i class="fa fa-check-circle-o"></i></td>
														<td class="text-left">
															<a class="btn btn-primary" data-toggle="modal" data-target="#anexarArquivo" id="btnAnexo" onclick="abrirModalAnexarArquivo(7,${idPessoa})">Alterar</a>
														</td>
													</tr>
												</c:when>
												<c:otherwise>
													<tr>
														<td><a data-toggle="modal" href="#visualizarFoto">Foto do Atleta</a></td>
														<td class="text-center"><i class="fa fa-times-circle-o"></i></td>
														<td class="text-left">
															<a class="btn btn-primary" data-toggle="modal" data-target="#anexarArquivo" id="btnAnexo" onclick="abrirModalAnexarArquivo(7,${idPessoa})">Anexar</a>
														</td>
													</tr>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${termoDeCompromisso != null}">
													<tr>
														<td><a data-toggle="modal" href="#visualizarDoc" onclick="visualizarDoc('${termoDeCompromisso.src}')">Termo de Compromisso do Manual do Atleta</a></td>
														<td class="text-center"><i class="fa fa-check-circle-o"></i></td>
														<td>
															<a class="btn btn-primary" data-toggle="modal" data-target="#anexarArquivo" id="btnAnexo" onclick="abrirModalAnexarArquivo(1,${idPessoa})">Alterar</a>
														</td>
													</tr>
												</c:when>
												<c:otherwise>
													<tr>
														<td><a data-toggle="modal" href="#">Termo de Compromisso do Manual do Atleta</a></td>
														<td class="text-center"><i class="fa fa-times-circle-o"></i></td>
														<td>
															<a class="btn btn-primary" data-toggle="modal" data-target="#anexarArquivo" id="btnAnexo" onclick="abrirModalAnexarArquivo(1,${idPessoa})">Anexar</a>
														</td>
													</tr>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${declaracaoMedica != null}">
													<tr>
														<td><a data-toggle="modal" href="#visualizarDoc" onclick="visualizarDoc('${declaracaoMedica.src}')">Declaração Médica</a></td>
														<td class="text-center"><i class="fa fa-check-circle-o"></i></td>
														<td>
															<a class="btn btn-primary" data-toggle="modal" data-target="#anexarArquivo" id="btnAnexo" onclick="abrirModalAnexarArquivo(2,${idPessoa})">Alterar</a>
														</td>
													</tr>
												</c:when>
												<c:otherwise>
													<tr>
														<td><a data-toggle="modal" href="#">Declaração Médica</a></td>
														<td class="text-center"><i class="fa fa-times-circle-o"></i></td>
														<td>
															<a class="btn btn-primary" data-toggle="modal" data-target="#anexarArquivo" id="btnAnexo" onclick="abrirModalAnexarArquivo(2,${idPessoa})">Anexar</a>
														</td>
													</tr>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${autorizacaoViagem != null}">
													<tr>
														<td><a data-toggle="modal" href="#visualizarDoc" onclick="visualizarDoc('${autorizacaoViagem.src}')">Autorização de Viagem e Hospedagem</a></td>
														<td class="text-center"><i class="fa fa-check-circle-o"></i></td>
														<td>
															<a class="btn btn-primary" data-toggle="modal" data-target="#anexarArquivo" id="btnAnexo" onclick="abrirModalAnexarArquivo(3,${idPessoa})">Alterar</a>
														</td>
													</tr>
												</c:when>
												<c:otherwise>
													<tr>
														<td><a data-toggle="modal" href="#">Autorização de Viagem e Hospedagem</a></td>
														<td class="text-center"><i class="fa fa-times-circle-o"></i></td>
														<td>
															<a class="btn btn-primary" data-toggle="modal" data-target="#anexarArquivo" id="btnAnexo" onclick="abrirModalAnexarArquivo(3,${idPessoa})">Anexar</a>
														</td>
													</tr>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${autorizacaoImagem != null}">
													<tr>
														<td><a data-toggle="modal" href="#visualizarDoc" onclick="visualizarDoc('${autorizacaoImagem.src}')">Autorização de Imagem</a></td>
														<td class="text-center"><i
															class="fa fa-check-circle-o"></i></td>
														<td><a class="btn btn-primary" data-toggle="modal"
															data-target="#anexarArquivo" id="btnAnexo"
															onclick="abrirModalAnexarArquivo(4,${idPessoa})">Alterar</a>
														</td>
													</tr>
												</c:when>
												<c:otherwise>
													<tr>
														<td><a data-toggle="modal" href="#">Autorização de Imagem</a></td>
														<td class="text-center"><i class="fa fa-times-circle-o"></i></td>
														<td>
															<a class="btn btn-primary" data-toggle="modal" data-target="#anexarArquivo" id="btnAnexo" onclick="abrirModalAnexarArquivo(4,${idPessoa})">Anexar</a>
														</td>
													</tr>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${copiaRG != null}">
													<tr>			
														<td><a data-toggle="modal" href="#visualizarDoc" onclick="visualizarDoc('${copiaRG.src}')">Cópia do RG</a></td>
														<td class="text-center"><i class="fa fa-check-circle-o"></i></td>
														<td>
															<a class="btn btn-primary" data-toggle="modal" data-target="#anexarArquivo" id="btnAnexo" onclick="abrirModalAnexarArquivo(5,${idPessoa})">Alterar</a>
														</td>
													</tr>
												</c:when>
												<c:otherwise>
													<tr>
														<td><a data-toggle="modal" href="#">Cópia do RG</a></td>
														<td class="text-center"><i class="fa fa-times-circle-o"></i></td>
														<td>
															<a class="btn btn-primary" data-toggle="modal" data-target="#anexarArquivo" id="btnAnexo" onclick="abrirModalAnexarArquivo(5,${idPessoa})">Anexar</a>
														</td>
													</tr>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${copiaCPF != null}">
													<tr>
														<td><a data-toggle="modal" href="#visualizarDoc" onclick="visualizarDoc('${copiaCPF.src}')">Cópia do CPF</a></td>
														<td class="text-center"><i class="fa fa-check-circle-o"></i></td>
														<td>
															<a class="btn btn-primary" data-toggle="modal" data-target="#anexarArquivo" id="btnAnexo" onclick="abrirModalAnexarArquivo(6,${idPessoa})">Alterar</a>
														</td>
													</tr>
												</c:when>
												<c:otherwise>
													<tr>
														<td><a data-toggle="modal" href="#">Cópia do CPF</a></td>
														<td class="text-center"><i class="fa fa-times-circle-o"></i></td>
														<td>
															<a class="btn btn-primary" data-toggle="modal" data-target="#anexarArquivo" id="btnAnexo" onclick="abrirModalAnexarArquivo(6,${idPessoa})">Anexar</a>
														</td>
													</tr>	
												</c:otherwise>
											</c:choose>
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

	<div class="modal fade" id="anexarArquivo" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true"
	class="modal hide fade" role="dialog" aria-labelledby="orderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
					<h4 class="modal-title" id="myModalLabel">Anexar Arquivo</h4>
				</div>
				<div class="modal-body body-anexarArquivo">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal" id="fechar">Fechar</button>
				</div>
			</div>
		</div>
	</div>	
	
	<div class="modal fade" id="visualizarDoc" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true"
	class="modal hide fade" role="dialog" aria-labelledby="orderModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
					<h4 class="modal-title" id="myModalLabel">Visualizar Documento</h4>
				</div>
				<div class="modal-body body-imgVisualizarDoc">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal" id="fechar">Fechar</button>
				</div>
			</div>
		</div>
	</div>	
	
	<%@include file="/layout/footer.jsp"%>
	
	<%@include file="Modals.jsp"%>

</body>
</html>

