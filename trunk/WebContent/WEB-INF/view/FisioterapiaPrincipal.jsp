
<%@include file='/layout/head.jsp'%>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='/layout/navigationFisioterapia.jsp'%>

				<div class="col-md-2 column"></div>
				<div class="col-md-8 column">
					<h3 class="text-center">Últimos Atendimentos</h3>
					<table class="table">
						<thead>
							<tr>
								<th>Nome</th>
								<th>Data</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Atleta 1</td>
								<td>01/02/2015</td>
								<td><a href="FisioterapiaHistoricoAtleta.jsp">Ver
										Histórico</a></td>
							</tr>
							<tr>
								<td>Atleta 2</td>
								<td>19/01/2015</td>
								<td><a href="FisioterapiaHistoricoAtleta.jsp">Ver
										Histórico</a></td>
							</tr>
							<tr>
								<td>Atleta 3</td>
								<td>06/09/2014</td>
								<td><a href="FisioterapiaHistoricoAtleta.jsp">Ver
										Histórico</a></td>
							</tr>
							<tr>
								<td>Atleta 4</td>
								<td>13/07/2014</td>
								<td><a href="FisioterapiaHistoricoAtleta.jsp">Ver
										Histórico</a></td>
							</tr>
							<tr>
								<td>Atleta 5<br>
								</td>
								<td>23/05/2014</td>
								<td><a href="FisioterapiaHistoricoAtleta.jsp">Ver
										Histórico</a></td>
							</tr>
						</tbody>
					</table>
					<ul class="pagination">
						<li><a href="#">Anterior</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">Próximo</a></li>
					</ul>
				</div>
				<div class="col-md-2 column"></div>
			</div>
		</div>
	</div>

	<%@include file="/layout/footer.jsp"%>

</body>
</html>