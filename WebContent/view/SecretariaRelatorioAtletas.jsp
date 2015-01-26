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
							<b>Relatório de Rendimentos dos Atletas</b>
						</h3>
						<hr />
						<h4 class="text-left">Atletas Bonificados</h4>
						<table class="table">
							<tr>
								<th width="10%">Matrícula</th>
								<th width="40%">Nome</th>
								<th width="10%">Torneios</th>
								<th width="10%">Treinos</th>
								<th width="10%">Avaliações</th>
								<th width="10%">Rank FPT</th>
								<th width="10%">Rank CBT</th>
							</tr>
							<tr>
								<td>00000001</td>
								<td>Atleta 01</td>
								<td align="center"><span class="glyphicon glyphicon-remove"
									aria-hidden="true"></span></td>
								<td align="center"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span></td>
								<td align="center"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span></td>
								<td align="center">100°<span
									class="glyphicon glyphicon-circle-arrow-up" aria-hidden="true"></span></td>
								<td align="center">20° <span
									class="glyphicon glyphicon-circle-arrow-down"
									aria-hidden="true"></span></td>
							</tr>
							<tr>
								<td>00000002</td>
								<td>Atleta 02</td>
								<td align="center"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span></td>
								<td align="center"><span class="glyphicon glyphicon-remove"
									aria-hidden="true"></span></td>
								<td align="center"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span></td>
								<td align="center">135°<span
									class="glyphicon glyphicon-circle-arrow-down"
									aria-hidden="true"></span></td>
								<td align="center">50° <span
									class="glyphicon glyphicon-circle-arrow-up" aria-hidden="true"></span></td>
							</tr>
							<tr>
								<td>00000003</td>
								<td>Atleta 03</td>
								<td align="center"><span class="glyphicon glyphicon-remove"
									aria-hidden="true"></span></td>
								<td align="center"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span></td>
								<td align="center"><span class="glyphicon glyphicon-remove"
									aria-hidden="true"></span></td>
								<td align="center">75°<span
									class="glyphicon glyphicon-circle-arrow-up" aria-hidden="true"></span></td>
								<td align="center">15° <span
									class="glyphicon glyphicon-circle-arrow-up" aria-hidden="true"></span></td>
							</tr>
							<tr>
								<td>00000004</td>
								<td>Atleta 04</td>
								<td align="center"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span></td>
								<td align="center"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span></td>
								<td align="center"><span class="glyphicon glyphicon-remove"
									aria-hidden="true"></span></td>
								<td align="center">80°<span
									class="glyphicon glyphicon-circle-arrow-down"
									aria-hidden="true"></span></td>
								<td align="center">40° <span
									class="glyphicon glyphicon-circle-arrow-up" aria-hidden="true"></span></td>
							</tr>

						</table>
						<div class="col-sm-12 text-right" style="margin-bottom: 25px;">
							<button type="button" class="btn btn-primary mostrarProgresso" data-toggle="modal"
								data-target="#basicModal" id="btnImprimirRelBonificados">Imprimir
								Relatório de Atletas Bonificados</button>
							<hr/>
						</div>

						<h4>Atletas não bonificados</h4>

						<table class="table">
							<tr>
								<th width="10%">Matrícula</th>
								<th width="40%">Nome</th>
								<th width="10%">Torneios</th>
								<th width="10%">Treinos</th>
								<th width="10%">Avaliações</th>
								<th width="10%">Rank FPT</th>
								<th width="10%">Rank CBT</th>
							</tr>
							<tr>
								<td>00000005</td>
								<td>Atleta 05</td>
								<td align="center"><span class="glyphicon glyphicon-remove"
									aria-hidden="true"></span></td>
								<td align="center"><span class="glyphicon glyphicon-remove"
									aria-hidden="true"></span></td>
								<td align="center"><span class="glyphicon glyphicon-remove"
									aria-hidden="true"></span></td>
								<td align="center">300°<span
									class="glyphicon glyphicon-circle-arrow-down" aria-hidden="true"></span></td>
								<td align="center">100°<span
									class="glyphicon glyphicon-circle-arrow-down"
									aria-hidden="true"></span></td>
							</tr>
							<tr>
								<td>00000006</td>
								<td>Atleta 06</td>
								<td align="center"><span class="glyphicon glyphicon-remove"
									aria-hidden="true"></span></td>
								<td align="center"><span class="glyphicon glyphicon-remove"
									aria-hidden="true"></span></td>
								<td align="center"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span></td>
								<td align="center">205°<span
									class="glyphicon glyphicon-circle-arrow-down"
									aria-hidden="true"></span></td>
								<td align="center">147° <span
									class="glyphicon glyphicon-circle-arrow-up" aria-hidden="true"></span></td>
							</tr>
							<tr>
								<td>00000007</td>
								<td>Atleta 07</td>
								<td align="center"><span class="glyphicon glyphicon-remove"
									aria-hidden="true"></span></td>
								<td align="center"><span class="glyphicon glyphicon-ok"
									aria-hidden="true"></span></td>
								<td align="center"><span class="glyphicon glyphicon-remove"
									aria-hidden="true"></span></td>
								<td align="center">235°<span
									class="glyphicon glyphicon-circle-arrow-down" aria-hidden="true"></span></td>
								<td align="center">178° <span
									class="glyphicon glyphicon-circle-arrow-down" aria-hidden="true"></span></td>
							</tr>
							<tr>
								<td>00000008</td>
								<td>Atleta 08</td>
								<td align="center"><span class="glyphicon glyphicon-remove"
									aria-hidden="true"></span></td>
								<td align="center"><span class="glyphicon glyphicon-remove"
									aria-hidden="true"></span></td>
								<td align="center"><span class="glyphicon glyphicon-remove"
									aria-hidden="true"></span></td>
								<td align="center">280°<span
									class="glyphicon glyphicon-circle-arrow-up"
									aria-hidden="true"></span></td>
								<td align="center">340° <span
									class="glyphicon glyphicon-circle-arrow-up" aria-hidden="true"></span></td>
							</tr>

						</table>
						<div class="col-sm-12 text-right" style="margin-bottom: 50px;">
							<button type="button" class="btn btn-primary mostrarProgresso"
								id="btnImprimirRelNaoBonificados" data-toggle="modal"
								data-target="#basicModal">Imprimir Relatório de
								Atletas Não Bonificados</button>
							<hr/>
						</div>
						<div class="col-sm-offset-2 col-sm-10 text-right">
							<button type="button" class="btn btn-primary mostrarProgresso"
								id="btnImprimirRelGeral" data-toggle="modal"
								data-target="#basicModal">Imprimir Relatório Geral</button>
						</div>
					</div>
					<div class="col-md-2 column"></div>
				</div>
			</div>
		</div>
		
		<div class="modal fade" id="basicModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" id="fechar" aria-hidden="true">x</button>
					<h4 class="modal-title" id="myModalLabel">Imprimindo Relatório</h4>
					</div>
					<div class="modal-body">
						<div class="text-center">Imprimindo</div>
						<div class="progress" style="margin-top:10px;" id="progress">
							<div class="progress-bar progress-bar-striped active" role="progressbar"
							  aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width:99%">
								99%
							</div>
						</div>						
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal" id="fechar">Fechar</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>