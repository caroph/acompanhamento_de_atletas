	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page import="br.com.saat.core.Constants"%>
	
	<%@include file='/layout/head.jsp'%>
	
	<body>
		<div class="container-fluid">
			<div id="page-login" class="row">
				<div class="col-xs-12 col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
					<div class="box">
						<div class="box-content">
							<div class="text-center">
								<img src="<%=Constants.IMG%>/logo.jpg" alt="" id="img-logo"/>
								<h3 class="page-header">Sistema de Acompanhamento de Atletas de Tênis</h3>
							</div>
							<form role="form" method="post" action="Autenticador?action=login">
								<c:if test="${ msg != null }">
									<div class="alert alert-danger">
								        <a href="#" class="close" data-dismiss="alert">&times;</a>
								            <c:out value="${msg}"></c:out>       
							    	</div>
						        </c:if>
								<div class="form-group">
									<label class="control-label">Email</label>
									<input type="text" class="form-control" name="email" id="email" required/>
									<!-- ALTERAR PARA type="email" -->
								</div>
								<div class="form-group">
									<label class="control-label">Senha</label>
									<input type="password" class="form-control" name="senha" id="senha" required/>
								</div>
								<div class="text-center">
									<input type="submit" class="btn btn-primary" value="Entrar">
								</div>
								<div class="form-group">
									<label>
										<input type="checkbox" name="lembrar" value="true"> Lembrar-me
									</label>
									<a data-toggle="modal" href="#esqueciSenha" role="button" style="float: right;" onclick="passar()">Esqueci minha senha</a>
								</div>		
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<%@include file="/layout/footer.jsp"%>
		
		<!-- Esqueci Senha -->
		<div class="modal fade" id="esqueciSenha" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="exampleModalLabel">Recuperação de senha</h4>
		      </div>
		      <div class="modal-body">
		        <form role="form" method="post" action="Autenticador?action=esqueci">
		          <div class="form-group">
		            <label for="emailSenha" class="control-label">Favor informe seu email cadastrado no sistema:</label>
		            <input type="email" class="form-control" id="emailSenha" name="emailSenha" value="" required> 
		          </div>
			      <div class="modal-footer">
			        <input type="submit" class="btn btn-primary" value="Enviar">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
			      </div>
		        </form>
		      </div>
		    </div>
		  </div>
		</div>
		<!-- Fim Esqueci Senha -->
	
	</body>
</html>