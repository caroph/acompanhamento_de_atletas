	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationTecnico.jsp'%>
				<div class="row clearfix">
					<div class="col-md-8"></div>
					<div class="col-md-4">
						<form role="form" action="#">
							<div class="input-group">
								<input type="text" class="form-control form-search" id="search">
								<span class="input-group-btn">
									<button class="btn btn-default" type="submit">
										<i class="icon-large icon-search"></i>
									</button>
								</span>
							</div>
						</form>
					</div>
					<div class="col-md-2 column"></div>
					<div class="col-md-8 column">
						<h3>Atleta: XXX</h3>
					</div>
					<div class="col-md-2 column"></div>
				</div>
				<div class="row clearfix">
					<div class="col-md-2 column"></div>
					<div class="col-md-8 column">
						<h3 class="text-center">Observações Ativas</h3>
						<hr />
					</div>
					<div class="col-md-2 column"></div>
				</div>
				<div class="row clearfix">
					<div class="col-md-2 column"></div>
					<div class="col-md-8 column">
						<table class="table">
							<thead>
								<tr>
									<th class="text-center">Data de inclusão</th>
									<th class="text-center">Duração</th>
									<th class="text-center">Observação</th>
									<th class="text-center">Gravidade</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="text-center">05/02/2015</td>
									<td class="text-center">30 dias</td>
									<td>Observação Observação Observação Observação...</td>
									<td class="text-center">Alta</td>
								</tr>
								<tr>
									<td class="text-center">03/01/2015</td>
									<td class="text-center">10 dias</td>
									<td>Observação Observação Observação Observação...</td>
									<td class="text-center">Moderada</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="col-md-2 column"></div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="Modals.jsp"%>
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>