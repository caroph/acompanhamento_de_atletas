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
							<h5>Enviar um email para todos responsáveis ou para responsáveis de um grupo específico</h5>
							<hr/>
						</div>
						<div class="col-md-12 text-left">
							<b>Enviar para</b>
						</div>
						<div class="col-md-12 text-left" style="margin-top: 10px;">
							<div class="col-md-1">
								<input type="radio" name="rdPara"/> 
							</div>							
							Equipe
						</div>
						<div class="col-md-12 text-left">
							<div class="col-md-1">
								<input type="radio" name="rdPara"/>
							</div>
							Pré-Equipe
						</div>
						
						<div class="col-md-12 text-left">
							<div class="col-md-1">
								<input type="radio" name="rdPara"/>
							</div>
							Todos
						</div>	
								
						<div class="col-md-12 text-left">
							<b>Assunto:</b>
						</div>
						
						<div class="col-md-12 text-left">
							<input type="text" class="form-control" id="emailAssunto" />
						</div>
						
						<div class="col-md-12 text-left">
							<b>Mensagem:</b>
						</div>
						
						<div class="col-md-12 text-left" style="margin-bottom: 10px;">
							<textarea class="form-control"
								style="max-height: 325px; height: 325px;" id="message-text"></textarea>
						</div>
						
						<div class="col-md-12 text-right">
							<button class="btn btn-primary">Enviar</button>
						</div>
									
					</div>
					<div class="col-md-2 column"></div>
				</div>
			</div>
		</div>

	<%@include file="../layout/footer.jsp"%>

</body>
</html>