	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationTecnico.jsp'%>
				<div class="row clearfix">
					<div class="col-md-1 column">
					</div>
					<div class="col-md-10 column">
						<form class="form-horizontal" role="form">
							<div class="form-group">
								<label for="torneio" class="col-sm-4 control-label">Nome do torneio:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="torneio" />
								</div>
							</div>
							<div class="form-group">
								<label for="local" class="col-sm-4 control-label">Local do torneio:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="local" />
								</div>
							</div>
							<div class="form-group">
								<label for="datade" class="col-sm-4 control-label">De:</label>
								<div class="col-sm-3">
									<input type="date" class="form-control" id="datade" />
								</div>
								<label for="dataate" class="col-sm-2 control-label">Até:</label>
								<div class="col-sm-3">
									<input type="date" class="form-control" id="dataate" />
								</div>
							</div>
							<div class="form-group">
								<label for="categoria" class="col-sm-4 control-label">Categoria do torneio:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="categoria" />
								</div>
							</div>
							<div class="form-group">
								<label for="naipe" class="col-sm-4 control-label">Naipe do torneio:</label>
								<div class="col-sm-8">
									<select class="form-control">
										<option selected>Masculino e Feminino</option>
										<option>Masculino</option>
										<option>Feminino</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="naipe" class="col-sm-4 control-label">Selecionar atletas participantes:</label>
								<div class="col-sm-8">
									<select multiple="multiple" id="atletasTorneio" class="form-control">
										<option>Atleta 1</option>
										<option>Atleta 2</option>
										<option>Atleta 3</option>
									</select>
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-1 column">
					</div>
				</div>
			</div>
		</div>
	</div>	
	
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>