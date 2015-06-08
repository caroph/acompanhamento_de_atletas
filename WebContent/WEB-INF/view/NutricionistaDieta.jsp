<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file='/layout/head.jsp'%>

<body>

	<%@include file='/layout/header.jsp'%>

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
										<i class="fa fa-cutlery"></i><span>Dieta(s) do(a) atleta ${atleta.nome}</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<a class="link-green" id="novaDieta" data-toggle="modal" href="#dieta"><abbr title="Nova dieta"><i class="fa fa-large fa-plus-circle"></i></abbr></a>
									<c:if test="${fn:length(listaDieta) gt 0}">
										<a class="link-green" id="novaDieta" href="NutricionistaController?action=imprimirDieta&idAtleta=${atleta.idPessoa}" target="_blank"><abbr title="Imprimir"><i class="fa fa-large fa-print"></i></abbr></a>
										<a class="link-green" id="novaDieta" href="NutricionistaController?action=enviarDieta&idAtleta=${atleta.idPessoa}" data-confirm="Deseja realmente encaminhar a dieta aos responsáveis do atleta?"><abbr title="Encaminhar aos responsáveis"><i class="fa fa-large fa-envelope"></i></abbr></a>
									</c:if>
									<div id="listaDieta"  style="padding: 10px;">
										<c:forEach var="dieta" items="${listaDieta}">
												<div class="row clearfix">
													<div class="col-md-11 column" style="padding-left: 0;">
														<h4>
															<c:out value='${dieta.getNomeRefeicao()}'/>
															<c:if test='${dieta.competicao}'><b>(Período de competição)</b></c:if>
														</h4>
													</div>
													<div class="col-md-1 column" style="padding-top: 8px;">
														<a class="link-green" data-toggle="modal" onclick="editarDieta('${dieta.idDieta}', '${atleta.idPessoa}')" style="padding-left: 5px;"><abbr title="Editar"><i class="fa fa-large fa-pencil"></i></abbr></a>
														<a class="link-red" href="NutricionistaController?action=excluirDieta&idDieta=${dieta.idDieta}&idAtleta=${atleta.idPessoa}" style="padding-left: 5px;" data-confirm="Deseja realmente excluir a dieta selecionada?"><abbr title="Excluir"><i class="fa fa-large fa-trash-o"></i></abbr></a>
													</div>
												</div>
												<div class="row clearfix">
													<div class="col-md-12 column">
														<c:if test='${dieta.competicao}'>
															<fmt:formatDate value="${dieta.dtValidadeInicio}" pattern="dd/MM/yyyy" var="dtInicio" />
															<fmt:formatDate value="${dieta.dtValidadeFim}" pattern="dd/MM/yyyy" var="dtFim" />
															<p><b>Data de validade: </b><c:out value='${dtInicio}'/> à <c:out value='${dtFim}'/></p>
														</c:if>
														<p><b>Descrição: </b><c:out value='${dieta.descricao}'/></p>
													</div>
												</div>
										</c:forEach>
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
	
	<!-- Nova Dieta -->
	<div class="modal fade bs-example-modal-sm" id="dieta" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	    	<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Nova dieta</h4>
			</div>
			<div class="modal-body">
				<form method="POST" action="NutricionistaController?action=novaDieta&idAtleta=${atleta.idPessoa}&idDieta=0">
					<div class="form-group">
						<div class="col-sm-12">
							<label for="refeicao" class=" control-label">Refeição:</label>
						 	<select id="refeicao" name="refeicao" required>
								<option value="">Selecione</option>
								<c:forEach var="refeicao" items="${listaRefeicao}">
									<option value="<c:out value='${refeicao.valor}'/>"><c:out value="${refeicao.nome}" /></option>
	                            </c:forEach>
							</select>
						</div>
					</div>
					<div  class="form-group">
						<div class="col-sm-12">
							<label style="padding: 5px 22px 5px 0;"><input type="checkbox" name="competicao" value="true"> Período de competição</label>
						</div>
					</div>
					<div  class="form-group">
						<div class="col-sm-12">
							<label for="dataPresenca" class=" control-label">Período de validade: <small>[Início | Fim]</small></label>
							<br/><small><b>(Necessário apenas para período de competição)</b></small>
						</div>
						<div class="col-sm-6">
							<input type="date" class="form-control" id="dtValidadeInicio" name="dtValidadeInicio"/>
						</div>
						<div class="col-sm-6">
							<input type="date" class="form-control" id="dtValidadeFim" name="dtValidadeFim"/>
						</div>
					</div>
					<div  class="form-group" style="padding-bottom: 40%;">
						<div  class="col-sm-12">
							<label for="descricao" class=" control-label">Descrição:</label>
							<textarea class="form-control" id="descricao"  maxlength='3000' name="descricao" required></textarea>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">Salvar</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal" aria-hidden="true">Cancelar</button>
					</div>
				</form>
			</div>
	    </div>
	  </div>
	</div>
	
	<!-- Nova Dieta -->
	<div class="modal fade bs-example-modal-sm" id="editarDieta" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	    	<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Editar dieta</h4>
			</div>
			<div class="modal-body body-dieta">
			</div>
	    </div>
	  </div>
	</div>
	
	<%@include file="/layout/footer.jsp"%>
	<script src="<%=Constants.JS%>/scriptTables.js"></script>

</body>
</html>