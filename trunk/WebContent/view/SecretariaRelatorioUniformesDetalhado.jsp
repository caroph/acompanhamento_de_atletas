
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
						<div class="col-sm-12">
							<div class="col-sm-12">
								<h3 class="text-center">
									<b>Relatório de Controle de Empréstimos</b>
								</h3>
							</div>
							<div class="col-sm-12">
								<h5 class="text-center">
									Relatório para controle de empréstimos por peça de roupa.
									Também é possível acessar o <a href="SecretariaUniforme.jsp">controle
										de empréstimos por atleta clicando aqui</a>
								</h5>
								<hr />
							</div>
						</div>
						<div class="col-sm-4">Selecione um tipo de peça</div>
						<div class="col-sm-8" style="margin-bottom: 25px;">
							<select id="selectInicio" class="form-control">
								<option selected value="#">Selecione</option>
								<option value="SecretariaRelatorioUniformesDetalhadoLista.jsp">Blusinha</option>
								<option value="SecretariaRelatorioUniformesDetalhadoLista.jsp">Camiseta</option>
								<option value="SecretariaRelatorioUniformesDetalhadoLista.jsp">Saia</option>
								<option value="SecretariaRelatorioUniformesDetalhadoLista.jsp">Bermuda</option>
								<option value="SecretariaRelatorioUniformesDetalhadoLista.jsp">Jaqueta</option>
								<option value="SecretariaRelatorioUniformesDetalhadoLista.jsp">Calça</option>
							</select>
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