
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
									<b>Relat�rio de Controle de Empr�stimos</b>
								</h3>
							</div>
							<div class="col-sm-12">
								<h5 class="text-center">
									Relat�rio para controle de empr�stimos por pe�a de roupa.
									Tamb�m � poss�vel acessar o <a href="SecretariaUniforme.jsp">controle
										de empr�stimos por atleta clicando aqui</a>
								</h5>
								<hr />
							</div>
						</div>
						<div class="col-sm-4">Selecione um tipo de pe�a</div>
						<div class="col-sm-8" style="margin-bottom: 25px;">
							<select id="selectInicio" class="form-control">
								<option selected value="#">Selecione</option>
								<option value="SecretariaRelatorioUniformesDetalhadoLista.jsp">Blusinha</option>
								<option value="SecretariaRelatorioUniformesDetalhadoLista.jsp">Camiseta</option>
								<option value="SecretariaRelatorioUniformesDetalhadoLista.jsp">Saia</option>
								<option value="SecretariaRelatorioUniformesDetalhadoLista.jsp">Bermuda</option>
								<option value="SecretariaRelatorioUniformesDetalhadoLista.jsp">Jaqueta</option>
								<option value="SecretariaRelatorioUniformesDetalhadoLista.jsp">Cal�a</option>
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