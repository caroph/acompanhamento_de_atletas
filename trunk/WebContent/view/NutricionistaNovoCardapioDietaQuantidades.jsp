	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
			<!-- menu -->
				<%@include file='../layout/navigationNutricionista.jsp'%>
				
				<div class="row clearfix">
					<div class="col-md-12">
						<h3>Novo Cardápio para o Atleta XXXXXXX</h3>
					</div>
					<div class="col-md-12"><hr/></div>

					<div class="col-md-12 text-left" style="margin:10px 0px 10px 0px;">
						<h3>2/2 - Incluir Quantidades/Observações</h3>
						<hr/>
					</div>
					<div class="col-md-12" style="margin:10px 0px 10px 0px;">
						<table class="table">
							<thead>
								<tr>
									<th class="text-center" width="30%">Alimento</th>
									<th class="text-center" width="15%">Quantidade</th>
									<th class="text-center" width="15%">Unidade de Medida</th>
									<th class="text-center" width="40%">Observação</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="text-left">Alimento 01</td>
									<td class="text-center"><input type="number"
										class="form-control text-center" /></td>
									<td class="text-center">g</td>
									<td><textarea class="form-control" style="height: 80px;"
											id="message-text"></textarea></td>
								</tr>
								<tr>
									<td class="text-left">Alimento 02</td>
									<td class="text-center"><input type="number"
										class="form-control text-center" /></td>
									<td class="text-center">g</td>
									<td><textarea class="form-control" style="height: 80px;"
											id="message-text"></textarea></td>
								</tr>
								<tr>
									<td class="text-left">Alimento 03</td>
									<td class="text-center"><input type="number"
										class="form-control text-center" /></td>
									<td class="text-center">g</td>
									<td><textarea class="form-control" style="height: 80px;"
											id="message-text"></textarea></td>
								</tr>
								<tr>
									<td class="text-left">Alimento 04</td>
									<td class="text-center"><input type="number"
										class="form-control text-center" /></td>
									<td class="text-center">g</td>
									<td><textarea class="form-control" style="height: 80px;"
											id="message-text"></textarea></td>
								</tr>
								<tr>
									<td class="text-left">Alimento 05</td>
									<td class="text-center"><input type="number"
										class="form-control text-center" /></td>
									<td class="text-center">g</td>
									<td><textarea class="form-control" style="height: 80px;"
											id="message-text"></textarea></td>
								</tr>
							</tbody>
						</table>
					</div>
					
					<div class="col-md-12">
						<h4>Observações Gerais</h4>
					</div>
					<div class="col-md-12">
						<textarea class="form-control" style="height: 200px;" id="message-text"></textarea>
					</div>
					<div class="col-md-12 text-right"  style="margin:10px 0px 30px 0px;">
						<a class="btn btn-primary" href="NutricionistaDietaAtleta.jsp">Salvar Cardápio</a>
					</div>

				</div>
			</div>
		</div>		
	</div>	
	<%@include file="Modals.jsp"%>
	<%@include file="../layout/footer.jsp"%>
  </body>
</html>