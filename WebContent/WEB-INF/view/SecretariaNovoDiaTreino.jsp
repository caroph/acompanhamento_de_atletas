	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
										<i class="fa  fa-info-circle"></i>
										<span>Dias de Treino</span>
									</div>
									<div class="box-icons">
										<a class="expand-link">
											<i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<form class="form-horizontal" role="form" action="SecretariaController?action=inserirDiaTreino" method="post">
										<div class="form-group">
											<div class=" col-sm-3">
												<label for="tpEquipe" class=" control-label">Equipe:</label>
												<select class="form-control" id="tpEquipe" name="tpEquipe" required>
													<option value="">Selecione</option>
													<c:forEach var="equipe" items="${listaEquipes}">
						                            	<option value="<c:out value='${equipe.valor}'/>"><c:out value="${equipe.nome}" /></option>
						                            </c:forEach>
												</select>
											</div>
											<div class=" col-sm-3">
												<label for="diaSemana" class=" control-label">Dia da Semana:</label>
												<select class="form-control" id="diaSemana" name="diaSemana" required>
													<option value="">Selecione</option>
													<c:forEach var="semana" items="${listaSemana}">
						                            	<option value="<c:out value='${semana.valor}'/>"><c:out value="${semana.nome}" /></option>
						                            </c:forEach>
												</select>
											</div>
											<div class=" col-sm-3">
												<label for="hrInicio" class=" control-label">Hora Início:</label>
												<input type="time" class="form-control" id="hrInicio" name="hrInicio" required />
											</div>
											<div class=" col-sm-3">
												<label for="hrFim" class=" control-label">Hora Fim:</label>
												<input type="time" class="form-control" id="hrFim" name="hrFim" required />
											</div>
										</div>
											<div class="form-group">
												<div class="col-sm-offset-2 col-sm-10 text-right">
													<a href="SecretariaController" class="btn btn-danger" data-confirm="Deseja realmente cancelar esse cadastro?">Cancelar</a>
													<button type="reset" class="btn btn-info" onclick="LimparCampos()">Limpar</button>
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
	
  </body>
</html>

