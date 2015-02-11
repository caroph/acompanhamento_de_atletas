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
						<h3 class="text-center">Bem Vindo Secret�rio(a) XXXXX</h3>
						<hr/>
						<h5><b>Existem 16 pend�ncias nos cadastros de alunos!</b></h5>
						<div style="margin-top: 30px;">
							<table class="table">
								<tr>
									<th align="center">Pend�ncia</th>
									<th align="center">Ocorr�ncias</th>
									<th></th>
								</tr>
								<tr>
									<td>Declara��es m�dicas n�o cadastradas</td>
									<td align="center">4</td>
									<td><a class="btn btn-primary" data-toggle="modal" data-target="#basicModal" id="btnListarAlunos">Listar Atletas</a></td>
								</tr>
								<tr>
									<td>Autoriza��es de Viagem e Hospedagem n�o cadastradas </td>
									<td align="center">4</td>
									<td><a class="btn btn-primary" data-toggle="modal" data-target="#basicModal" id="btnListarAlunos">Listar Atletas</a></td>
								</tr>
								<tr>
									<td>C�pias do RG n�o cadastradas</td>
									<td align="center">4</td>
									<td><a class="btn btn-primary" data-toggle="modal" data-target="#basicModal" id="btnListarAlunos">Listar Atletas</a></td>
								</tr>			
								<tr>
									<td>Fotos n�o cadastradas</td>
									<td align="center">4</td>
									<td><a class="btn btn-primary" data-toggle="modal" data-target="#basicModal" id="btnListarAlunos">Listar Atletas</a></td>
								</tr>
							</table>
						</div>
					</div>
					<div class="col-md-2 column">
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="basicModal" tabindex="-1" role="dialog"	aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">x</button>
						<h4 class="modal-title" id="myModalLabel">Alunos com pend�ncias</h4>
					</div>
					<div class="modal-body">
						<table class="table">
							<tr>
								<th class="text-center">Nome do aluno</th>
								<th class="text-center">Matr�cula</th>
								<th></th>
							</tr>
							<tr>
								<td>Atleta 01</td>
								<td class="text-center">00000001</td>
								<td><a href="SecretariaAnexosAtleta.jsp">Anexar Documentos</a></td>
							</tr>
							<tr>
								<td>Atleta 02</td>
								<td class="text-center">00000002</td>
								<td><a href="SecretariaAnexosAtleta.jsp">Anexar Documentos</a></td>
							</tr>
							<tr>
								<td >Atleta 03</td>
								<td class="text-center">00000003</td>
								<td><a href="SecretariaAnexosAtleta.jsp">Anexar Documentos</a></td>
							</tr>
							<tr>
								<td>Atleta 04</td>
								<td class="text-center">00000004</td>
								<td><a href="SecretariaAnexosAtleta.jsp">Anexar Documentos</a></td>
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