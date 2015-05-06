<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file='/layout/head.jsp'%>

<body>

	<%@include file='/layout/header.jsp'%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
	<div id="main" class="container-fluid">
		<div class="row">
			<%@include file='/layout/navigationNutricionista.jsp'%>
			<!--Start Content-->
			<div id="content" class="col-xs-12 col-sm-10">
				<div id="ajax-content">
					<%@include file="Mensagem.jsp"%>
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<div class="box-name">
										<i class="fa  fa-group"></i> <span>Histórico de atendimentos de ${atleta.nome}</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content no-padding">
									<div class="row clear-fix">
										<div class="col-md-12" style="margin: 10px 0px 10px 10px;">
											<h3><b>Histórico de atendimentos</b></h3>
										</div>			
										<div class="col-md-12">
											<c:choose>
												<c:when test="${listaAtendimentos != null}">
													<table class="table table-bordered table-striped table-hover table-heading table-datatable" id="datatable">
														<thead>
															<tr>
																<th class="text-center" width="90%">Data do atendimento</th>
																<th class="text-center" width="5%"></th>
																<th class="text-center" width="5%"></th>
															</tr>
														</thead>
														<tbody>
															<c:forEach var="atendimento" items="${listaAtendimentos}">
																<tr>
																	<td class="text-center"><fmt:formatDate value="${atendimento.value}" pattern="dd/MM/yyyy - HH:mm"/></td>
																	<td class="text-center"><a href="NutricionistaController?action=jspFichaDeAtendimento&idAtleta=${atleta.idPessoa}&idFichaDeAtendimento=${atendimento.key}">Visualizar</a></td>
																	<td class="text-center"><a id="btnImprimir" data-toggle="modal" href="NutricionistaController?action=imprimirFichaDeAtendimento&idFichaDeAtendimento=${atendimento.key}">Imprimir</a></td>
																</tr>												
															</c:forEach>
														</tbody>
													</table>						
												</c:when>
												<c:otherwise>
													<table class="table table-bordered table-striped table-hover table-heading">
														<thead>
															<tr>
																<th class="text-center" width="90%">Data do atendimento</th>
															</tr>
														</thead>
														<tbody>
															<tr>
																<td class="text-center">
																	<b>Não existem atendimentos anteriores para ${atleta.nome}</b>
																</td>
															</tr>
														</tbody>
													</table>												
												</c:otherwise>													
											</c:choose>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--End Content-->
		</div>
	</div>
	
	<div class="modal fade" id="detalhesResp" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true"
	class="modal hide fade" role="dialog" aria-labelledby="orderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Detalhes do Responsável</h4>
				</div>
				<div class="modal-body body-responsavel">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn" data-dismiss="modal" id="fechar">Fechar</button>
				</div>
			</div>
		</div>
	</div>

	<%@include file="/layout/footer.jsp"%>
	<script src="<%=Constants.JS%>/scriptTables.js"></script>

</body>
</html>