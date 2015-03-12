<%@page import="br.com.saat.core.Constants"%>

<%@include file='/layout/head.jsp'%>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-4 column"></div>
			<div class="col-md-4 column">
				<h3 class="text-center">
					SAAT
					<div>
						<span>Sistema de Acompanhamento de Atletas de Tênis</span>
					</div>
				</h3>
				<form role="form" method="post" action="Autenticador?action=login">
					<div class="form-group">
						<label for="exampleInputEmail1">Email</label> <input type="text"
							class="form-control" id="exampleInputEmail1" name="email"
							id="email">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Senha</label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							name="senha" id="senha">
					</div>

					<div class="form-group">
						<label class="checkbox-inline"> <input type="checkbox"
							value="">Lembre-me
						</label> <a href="#" style="float: right;">Esqueci minha senha</a>
					</div>
					<input type="submit" class="btn pull-right btn-info" value="Entrar">
				</form>
			</div>
			<div class="col-md-4 column"></div>
		</div>
	</div>
	<%@include file="/layout/footer.jsp"%>
</body>
</html>