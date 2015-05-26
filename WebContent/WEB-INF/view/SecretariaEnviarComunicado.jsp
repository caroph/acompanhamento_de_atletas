
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
					<%@include file="Mensagem.jsp"%>
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<div class="box-name">
										<i class="fa  fa-envelope"></i> <span>Enviar Email</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<form class="form-horizontal" role="form"
										action="SecretariaController?action=enviarComunicado"
										method="post">
										<div class="form-group">
											<div class="col-sm-12">
												<label>
											    	<input type="radio" value="1" name="optradio"><span style="padding: 0 10px 0 5px;">Equipe</span>
											    </label>
											    <label>
											    	<input type="radio" value="2" name="optradio"><span style="padding: 0 10px 0 5px;">Pré Equipe</span>
											    </label>
											    <label>
										    		<input type="radio" value="3" checked name="optradio"><span style="padding: 0 10px 0 5px;">Todos</span>
											    </label>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-12">
												<label for="assunto" class="control-label">Assunto</label>
												<input type="text" required class="form-control" id="assunto" name="assunto"/>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-12">
												<label for="mensagem" class="control-label">Mensagem</label>
												<textarea required class="form-control ckeditor" id="mensagemEmail" name="mensagemEmail"></textarea>
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

