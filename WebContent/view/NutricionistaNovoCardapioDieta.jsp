
<%@include file='../layout/head.jsp'%>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationNutricionista.jsp'%>

				<div class="row clearfix">
					<div class="col-md-10">
						<h3>Novo Cardápio para o Atleta XXXXXXX</h3>
					</div>
					<div class="col-md-2">
						<a data-toggle="modal" href="#carregarModelo">* Carregar um
							Modelo</a>
					</div>
					<div class="col-md-12">
						<hr />
					</div>

					<div class="col-md-12" style="margin: 10px 0px 10px 0px;">
						<div class="col-md-6">
							<div class="col-md-2 text-left">
								<label for="refeicao" class="control-label text-left">Refeição</label>
							</div>
							<div class="col-md-5">
								<select class="form-control">
									<option value=""></option>
									<option value="">Café da Manhã</option>
									<option value="">Lanche da Manhã</option>
									<option value="">Almoço</option>
									<option value="">Lanche da Tarde</option>
									<option value="">Jantar</option>
									<option value="">Ceia</option>
								</select>
							</div>
						</div>
					</div>
					<div class="col-md-12" style="margin: 10px 0px 10px 0px;">
						<div class="col-md-6">
							<div class="col-md-5 text-left">
								<label for="periodoCompeticao" class="control-label text-left">Periodo
									de Competição</label>
							</div>
							<div class="col-md-4">
								<input type="radio" id="rdCompeticao" name="rdCompeticao"
									value="s" /> Sim <input type="radio" id="rdCompeticao2"
									name="rdCompeticao" value="n" checked="checked"
									style="margin-left: 10px;" /> Não
							</div>
						</div>
					</div>
					<div class="col-md-12" style="margin: 10px 0px 10px 0px;">
						<div class="col-md-9">
							<div class="col-md-3 text-left">
								<label for="periodoValidade" class="control-label text-left">Periodo
									de validade</label>
							</div>
							<div class="col-md-3">
								<input type="date" class="form-control" id="dtInicioValidade" />
							</div>
							<div class="col-md-1">Até</div>
							<div class="col-md-3">
								<input type="date" class="form-control" id="dtFimValidade"
									style="margin-left: 10px;" />
							</div>
						</div>
					</div>

					<div class="col-md-12" style="margin: 10px 0px 10px 0px;">
						<h3>1/2 - Escolher Alimentos</h3>
						<hr />
					</div>
					<div class="col-md-12" style="margin: 10px 0px 10px 0px;">
						<div class="col-md-6 text-left">
							<label for="periodoValidade" class="control-label text-left">Alimentos
								Atualmente no Cardápio</label>
						</div>
						<div class="col-md-6">
							<div class="col-md-6 text-left">
								<label for="periodoValidade" class="control-label text-left">Alimentos
									Disponíveis</label>
							</div>
							<div class="col-md-6 text-right">
								<a data-toggle="modal" href="#adicionarNovoAlimento">Adicionar Alimentos à Lista</a>
							</div>
						</div>
					</div>

					<div class="col-md-12" style="margin: 10px 0px 10px 0px;">
						<div class="form-group col-md-12">
							<div>
								<select multiple="multiple" size="10" name="duallistbox_demo1[]">
									<option value="option1" selected>Alimento 1</option>
									<option value="option2" selected>Alimento 2</option>
									<option value="option3" selected>Alimento 3</option>
									<option value="option4" selected>Alimento 4</option>
									<option value="option5" selected>Alimento 5</option>
									<option value="option6" selected>Alimento 6</option>
									<option value="option7" selected>Alimento 7</option>
									<option value="option8" selected>Alimento 8</option>
									<option value="option9" selected>Alimento 9</option>
									<option value="option10" selected>Alimento 10</option>
								</select>
							</div>
						</div>
					</div>
					<div class="col-md-12 text-right"
						style="margin: 10px 0px 10px 0px;">
						<a class="btn btn-primary"
							href="NutricionistaNovoCardapioDietaQuantidades.jsp">Incluir
							Quantidades</a>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal Carregar Modelo -->
		<div class="modal fade bs-example-modal-sm" id="carregarModelo"
			tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"
			aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">x</button>
						<h4 class="modal-title" id="myModalLabel">Carregar um modelo</h4>
					</div>
					<div class="modal-body">
						<div class="row clearfix">
							<div class="col-md-12">
								<div class="row clearfix">
									<div class="col-md-12">
										<div class="col-md-3">
											Selecione um modelo:
										</div>
										<div class="col-md-9">
											<select id="selectModelos" class="form-control">
												<option>Modelo 01</option>
												<option>Modelo 02</option>
												<option>Modelo 03</option>
											</select>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn" data-dismiss="modal"
								aria-hidden="true">Fechar</button>
							<button type="button" class="btn btn-primary" data-dismiss="modal"
								aria-hidden="true">Carregar</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal Carregar Modelo -->
		<div class="modal fade bs-example-modal-sm" id="adicionarNovoAlimento"
			tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"
			aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">x</button>
						<h4 class="modal-title" id="myModalLabel">Adicionar Novo Alimento</h4>
					</div>
					<div class="modal-body">
						<div class="row clearfix">
							<div class="col-md-12">
								<div class="row clearfix">
									<div class="col-md-12">
										<div class="col-md-4">Nome:</div>
										<div class="col-md-8">
											<input type="text" class="form-control" id="nomeAlimento" />
										</div>
									</div>
									<div class="col-md-12" style="margin:10px 0px 10px 0px;">
										<div class="col-md-4">Unidade de Medida</div>
										<div class="col-md-8">
											<select id="selectModelos" class="form-control">
												<option>Unidades</option>
												<option>Gramas</option>
												<option>Copos</option>
												<option>Colheres</option>
												<option>Outros</option>
											</select>
										</div>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn" data-dismiss="modal"
										aria-hidden="true">Fechar</button>
									<button type="button" class="btn btn-primary"
										data-dismiss="modal" aria-hidden="true">Gravar</button>
								</div>
							</div>
						</div>
					</div>
		</div>
		<%@include file="Modals.jsp"%>
		<%@include file="../layout/footer.jsp"%>
</body>
</html>