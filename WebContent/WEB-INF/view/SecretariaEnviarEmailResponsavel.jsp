
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
										<i class="fa  fa-info-circle"></i> <span>Enviar Email</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<form class="form-horizontal" role="form"
										action="SecretariaController?action=enviarEmailIndividual"
										method="post">
										<input type="hidden" name="emailResponsavel" value='${emailResponsavel}'/>
										<div class="form-group">
											<div class="col-sm-12">
												<label for="assunto" class="control-label">Assunto</label>
												<input type="text" class="form-control" id="assunto" name="assunto"/>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-12">
												<label for="mensagem" class="control-label">Mensagem</label>
												<textarea class="form-control" id="mensagemEmail" name="mensagemEmail"></textarea>
												<script type="text/javascript">
													CKEDITOR.replace( 'mensagemEmail' );
												</script>
											</div>
										</div>										
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10 text-right">
												<button type="submit" class="btn btn-primary">Enviar</button> 
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

