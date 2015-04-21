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
					<c:if test="${ msgErro != null && msgErro != ''}">
						<div class="alert alert-danger">
					        <a href="#" class="close" data-dismiss="alert">&times;</a>
					            <c:out value="${msgErro}"></c:out>       
				    	</div>
			        </c:if>
			        <c:if test="${ msgAlerta != null && msgAlerta != ''}">
						<div class="alert alert-info">
					        <a href="#" class="close" data-dismiss="alert">&times;</a>
					            <c:out value="${msgAlerta}"></c:out>       
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
										<span>Últimos Atendimentos</span>
									</div>
									<div class="box-icons">
										<a class="expand-link">
											<i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content no-padding">
									<table
										class="table table-bordered table-striped table-hover table-heading table-datatable"
										id="datatable">
										<thead>
											<tr>
												<th>Nome</th>
												<th style="text-align: center;">Data Atendimento</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="atendimento" items="${listaAtendimento}">
												<tr>
													<td><c:out value='${atendimento.atleta.nome}' /></td>
													<fmt:formatDate value="${atendimento.dtAtendimento}" pattern="dd/MM/yyyy" var="dtFormatada" />
													<fmt:formatDate value="${atendimento.hrAtendimento}" pattern="HH:mm" var="hrFormatada" />
													<td style="text-align: center;"><c:out value='${dtFormatada}'/> - <c:out value='${hrFormatada}'/></td>
													<td align="center">
														<a class="btn btn-primary" href="SaudeGeralController?action=jspHistorico&idAtleta=${atendimento.atleta.idPessoa}&nome=${atendimento.atleta.nome}">Histórico</a>												
													</td>
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
	<%@include file="Modals.jsp"%>
	<script src="<%=Constants.JS%>/scriptTables.js"></script>
	
  </body>
</html>
