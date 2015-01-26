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
						<h3><b>Relatório de Rendimentos dos Atletas</b></h3>
					</div>
					
					<div class="col-md-2 column"></div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="basicModal" tabindex="-1" role="dialog"	aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">x</button>
						<h4 class="modal-title" id="myModalLabel">Alunos com pendências</h4>
					</div>
					<div class="modal-body">
						<table class="table">
							<tr>
								<th class="text-center">Nome do aluno</th>
								<th class="text-center">Matrícula</th>
							</tr>
							<tr>
								<td>Atleta 01</td>
								<td class="text-center">00000001</td>
							</tr>
							<tr>
								<td>Atleta 02</td>
								<td class="text-center">00000002</td>
							</tr>
							<tr>
								<td >Atleta 03</td>
								<td class="text-center">00000003</td>
							</tr>
							<tr>
								<td>Atleta 04</td>
								<td class="text-center">00000004</td>
							</tr>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							id="fechar">Fechar</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>