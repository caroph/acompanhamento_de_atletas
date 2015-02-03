	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationTecnico.jsp'%>
				<div class="row clearfix">
					<div class="col-md-2 column"></div>
					<div class="col-md-8 column">
						<!-- CONTEUDO -->
						<div class="col-sm-12">
							<h3 class="text-center">
								<b>Desempenho Individual em Torneios</b>
							</h3>
						</div>
						<div class="col-sm-12">
							<h5 class="text-center">
								Resumo do desempenho do atleta em torneios participados.
							</h5>
							<hr />
						</div>
						<table class="table">
							<tr>
								<th width="30%">Nome do torneio</th>
								<th width="10%" class="text-center">Data do evento</th>
								<th width="10%" class="text-center">Tipo de torneio</th>
								<th width="10%" class="text-center">Cidade</th>
								<th width="20%" class="text-center">Categoria</th>
								<th width="20%" class="text-center">Classificação</th>
							</tr>
							<tr>
								<td>Torneio 1</td>
								<td align="center">02/01/2015</td>
								<td align="center">FPT</td>
								<td align="center">Curitiba</td>
								<td align="center">12 anos - Masculino</td>
								<td align="center">2 lugar</td>
							</tr>
							<tr>
								<td>Torneio 2</td>
								<td align="center">02/03/2014</td>
								<td align="center">CBT</td>
								<td align="center">Belo Horizonte</td>
								<td align="center">12 anos - Masculino</td>
								<td align="center">2 lugar</td>
							</tr>
							<tr>
								<td>Torneio 3</td>
								<td align="center">02/02/2014</td>
								<td align="center">FPT</td>
								<td align="center">Pato Branco</td>
								<td align="center">12 anos - Masculino</td>
								<td align="center">2 lugar</td>
							</tr>
							<tr>
								<td>Torneio 4</td>
								<td align="center">02/01/2014</td>
								<td align="center">ITF</td>
								<td align="center">Curitiba</td>
								<td align="center">12 anos - Masculino</td>
								<td align="center">2 lugar</td>
							</tr>
						</table>
					</div>
					<div class="col-md-2 column"></div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>