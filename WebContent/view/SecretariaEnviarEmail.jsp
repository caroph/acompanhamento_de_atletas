<%@include file='../layout/head.jsp'%>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationSecretaria.jsp'%>
				<div class="row clearfix">
					<div class="col-md-2 column"></div>
					<div class="col-md-8 column">
						<div class="col-md-12 text-center">
							<h3>Enviar Comunicado</h3>
						</div>
						<div class="col-md-12 text-center">
							<h5>Enviar um email para todos respons�veis ou para respons�veis de um grupo espec�fico</h5>
							<hr/>
						</div>
						<div class="col-md-12 text-left">
							<b>Enviar para</b>
						</div>
						<div class="col-md-12 text-left">
							<div class="col-md-1">
								<input class="form-control" type="radio" name="rdPara"/>
							</div>
							Equipe
						</div>
						<div class="col-md-12 text-left">
							<div class="col-md-1">
								<input class="form-control" type="radio" name="rdPara"/>
							</div>
							Pr�-Equipe
						</div>
						
						<div class="col-md-12 text-left">
							<div class="col-md-1">
								<input class="form-control" type="radio" name="rdPara"/>
							</div>
							Todos
						</div>						
					</div>
					<div class="col-md-2 column"></div>
				</div>
			</div>
		</div>

	<%@include file="../layout/footer.jsp"%>

</body>
</html>