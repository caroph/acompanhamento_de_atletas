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
										<i class="fa  fa-info-circle"></i>
										<span>Dias de Treino</span>
									</div>
									<div class="box-icons">
										<a class="collapse-link">
											<i class="fa fa-chevron-up"></i>
										</a>
										<a class="expand-link">
											<i class="fa fa-expand"></i>
										</a>
										<a class="close-link">
											<i class="fa fa-times"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<form class="form-horizontal" role="form" action="SecretariaController?action=inserirDiaTreino" method="post">
										<c:if test="${ msg != null }">
											<div class="alert alert-success">
										        <a href="#" class="close" data-dismiss="alert">&times;</a>
										            <c:out value="${msg}"></c:out>       
									    	</div>
								        </c:if>
										<div class="form-group">
											<div class=" col-sm-3">
												<label for="tpEquipe" class=" control-label">Equipe:</label>
												<div class="">
													<select class="form-control" id="tpEquipe" name="tpEquipe" required>
														<option value="0">Selecione</option>
														<c:forEach var="equipe" items="${listaEquipes}">
								                            <c:if test="${listaEquipes != null}">
							                                     <option value="<c:out value='${equipe.valor}'/>"><c:out value="${equipe.nome}" /></option>
							                                 </c:if>
							                            </c:forEach>
													</select>
												</div>
											</div>
											<div class=" col-sm-3">
												<label for="diaSemana" class=" control-label">Dia da Semana:</label>
												<div class="">
													<select class="form-control" id="diaSemana" name="diaSemana" required>
														<option value="0">Selecione</option>
														<c:forEach var="semana" items="${listaSemana}">
								                            <c:if test="${listaSemana != null}">
							                                     <option value="<c:out value='${semana.valor}'/>"><c:out value="${semana.nome}" /></option>
							                                 </c:if>
							                            </c:forEach>
													</select>
												</div>
											</div>
											<div class=" col-sm-3">
												<label for="hrInicio" class=" control-label">Hora Início:</label>
												<div class="">
													<input type="text" class="form-control" id="hrInicio" name="hrInicio" required />
												</div>
											</div>
											<div class=" col-sm-3">
												<label for="hrFim" class=" control-label">Hora Fim:</label>
												<div class="">
													<input type="text" class="form-control" id="hrFim" name="hrFim" required />
												</div>
											</div>
											<div class="col-sm-12 text-right">
												<button type="button" class="btn btn-danger">Cancelar</button>
												<button type="button" class="btn btn-info">Limpar</button>
												<button type="submit" class="btn btn-primary">Salvar</button>
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
	
	<script type="text/javascript">
	function DemoTimePicker(){
		$('#hrInicio').timepicker({setDate: new Date()});
		$('#hrFim').timepicker({setDate: new Date()});
	}
	$(document).ready(function() {		
		
		// Load Timepicker plugin
		LoadTimePickerScript(DemoTimePicker);
	});
	</script>
	
	<%@include file="Modals.jsp"%>
	

  </body>
</html>

