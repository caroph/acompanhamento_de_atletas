<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-4 column">
			</div>
			<div class="col-md-4 column">
				<h3 class="text-center">
					SAAT
					<div>
						<span>Sistema de Acompanhamento de Atletas de Tênis</span>
					</div>
				</h3>
				<form role="form" action="view/SecretariaAtleta.jsp">
					<div class="form-group">
						 <label for="exampleInputEmail1">Usuário</label><input type="email" class="form-control" id="exampleInputEmail1">
					</div>
					<div class="form-group">
						 <label for="exampleInputPassword1">Senha</label><input type="password" class="form-control" id="exampleInputPassword1">
					</div> <button type="submit" class="btn btn-default">Entrar</button>
				</form>
			</div>
			<div class="col-md-4 column">
			</div>
		</div>
	</div>
	
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>