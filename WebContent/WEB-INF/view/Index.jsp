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
								<input type="text" class="form-control" name="email" id="email"/>
								<!-- Alterar para type="email" -->
							</div>
							<div class="form-group">
								<label class="control-label">Senha</label>
								<input type="password" class="form-control" name="senha" id="senha"/>
							</div>
							<div class="text-center">
								<input type="submit" class="btn btn-primary" value="Entrar">
							</div>
							<div class="form-group">
									<label>
										<input type="checkbox" name="lembrar" value="true"> Lembre-me
									</label>
								<a href="#" style="float: right;">Esqueci minha senha</a>
							</div>							
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="/layout/footer.jsp"%>
</body>
</html>