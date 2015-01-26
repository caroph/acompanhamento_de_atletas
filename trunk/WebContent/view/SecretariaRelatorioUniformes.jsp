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
						<!-- CONTEUDO -->
						<h3 class="text-center">
							<b>Relatório de Controle de Uniformes</b>
						</h3>
						<hr />
						<h4 class="text-left">Total de peças</h4>
						<table class="table">
							<tr>
								<th width="40%">Tipo de Peça</th>
								<th width="10%" class="text-center">PP</th>
								<th width="10%" class="text-center">P</th>
								<th width="10%" class="text-center">M</th>
								<th width="10%" class="text-center">G</th>
								<th width="10%" class="text-center">GG</th>
								<th width="10%" class="text-center">Total</th>
							</tr>
							<tr>
								<td>Blusinha</td>
								<td align="center">20</td>
								<td align="center">20</td>
								<td align="center">20</td>
								<td align="center">20</td>
								<td align="center">20</td>
								<td align="center">100</td>
							</tr>
							<tr>
								<td>Camiseta</td>
								<td align="center">30</td>
								<td align="center">30</td>
								<td align="center">30</td>
								<td align="center">30</td>
								<td align="center">30</td>
								<td align="center">150</td>
							</tr>
							<tr>
								<td>Saia</td>
								<td align="center">10</td>
								<td align="center">10</td>
								<td align="center">10</td>
								<td align="center">10</td>
								<td align="center">10</td>
								<td align="center">50</td>
							</tr>
							<tr>
								<td>Bermuda</td>
								<td align="center">25</td>
								<td align="center">25</td>
								<td align="center">25</td>
								<td align="center">25</td>
								<td align="center">25</td>
								<td align="center">125</td>
							</tr>
							<tr>
								<td>Jaqueta</td>
								<td align="center">5</td>
								<td align="center">5</td>
								<td align="center">5</td>
								<td align="center">5</td>
								<td align="center">5</td>
								<td align="center">25</td>
							</tr>
							<tr>
								<td>Calça</td>
								<td align="center">15</td>
								<td align="center">15</td>
								<td align="center">15</td>
								<td align="center">15</td>
								<td align="center">15</td>
								<td align="center">75</td>
							</tr>
						</table>
						<div class="col-sm-12 text-right" style="margin-bottom: 25px;">
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#basicModal" id="btnImprimirRelBonificados">Imprimir
								Relatório de Atletas Bonificados</button>
							<hr/>
						</div>
						<div class="col-sm-offset-2 col-sm-10 text-right">
							<button type="button" class="btn btn-primary"
								id="btnImprimirRelGeral" data-toggle="modal"
								data-target="#basicModal">Imprimir Relatório Geral</button>
						</div>
					</div>
					<div class="col-md-2 column"></div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>