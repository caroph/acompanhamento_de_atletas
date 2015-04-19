
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file='/layout/head.jsp'%>

<body>

	<%@include file='/layout/header.jsp'%>

	<div id="main" class="container-fluid">
		<div class="row">
			<%@include file='/layout/navigationSaudeGeral.jsp'%>
			<!--Start Content-->
			<div id="content" class="col-xs-12 col-sm-10">
				<div id="ajax-content">
			        <c:if test="${ msgSucesso != null && msgSucesso != ''}">
						<div class="alert alert-success">
					        <a href="#" class="close" data-dismiss="alert">&times;</a>
					            <c:out value="${msgSucesso}"></c:out>       
				    	</div>
			        </c:if>
			        <c:if test="${ msgAlerta != null && msgAlerta != ''}">
						<div class="alert alert-info">
					        <a href="#" class="close" data-dismiss="alert">&times;</a>
					            <c:out value="${msgAlerta}"></c:out>       
				    	</div>
			        </c:if>
					<c:if test="${ msgErro != null && msgErro != ''}">
						<div class="alert alert-danger">
					        <a href="#" class="close" data-dismiss="alert">&times;</a>
					            <c:out value="${msgErro}"></c:out>       
				    	</div>
			        </c:if>
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<div class="box-name">
										<i class="fa  fa-info-circle"></i><span>Histórico de Atendimentos <strong>(<c:out value="${nomeAtleta}"/>)</strong></span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content no-padding">
									<div id="listaHistorico"  style="padding: 10px;">
										<c:forEach var="prontuario" items="${listaProntuario}">
												<fmt:formatDate value="${prontuario.dtAtendimento}" pattern="dd/MM/yyyy"
													var="dtFormatada" />
												<fmt:formatDate value="${prontuario.hrAtendimento}" pattern="HH:mm"
												var="hrFormatada" />
												<div class="row clearfix">
													<div class="col-md-11 column" style="padding-left: 0;">
														<h4><c:out value='${dtFormatada}'/> - <c:out value='${hrFormatada}'/></h4>
													</div>
													<div class="col-md-1 column" style="padding-top: 8px;">
														<a href="#" style="padding-left: 20px;"><i class="fa fa-pencil"></i></a>
														<a href="SaudeGeralController?action=excluirAtendimento&idProntuario=${prontuario.idProntuario}&idAtleta=${idAtleta}&nome=${nomeAtleta}" style="padding-left: 5px;" data-confirm="Deseja realmente excluir o atendimento selecionado?"><i class="fa fa-trash-o"></i></a>
													</div>
												</div>
												<div class="row clearfix">
													<div class="col-md-12 column">
														<p><c:out value='${prontuario.anotacao}'/></p>
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
	<%@include file="/layout/footer.jsp"%>
	<%@include file="Modals.jsp"%>

</body>
</html>