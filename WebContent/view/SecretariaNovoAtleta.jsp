	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationSecretaria.jsp'%>
				
				<!-- Content -->
				<div class="row clearfix">
					<div class="col-md-1 column"></div>
					<div class="col-md-10 column">
						<h3 class="text-center">
							Cadastro Pessoal do Atleta
						</h3>
						<hr/>
						<form class="form-horizontal" role="form">
							<div class="form-group">
								<label for="diasTreinamento" class="col-sm-4 control-label">Dias da semana que treina:</label>
								<div class="col-sm-8 form-inline">
									<div class="checkbox">
										 <label><input type="checkbox" /> Segunda</label>
									</div>
									<div class="checkbox">
										 <label><input type="checkbox" /> Terça</label>
									</div>
									<div class="checkbox">
										 <label><input type="checkbox" /> Quarta</label>
									</div>
									<div class="checkbox">
										 <label><input type="checkbox" /> Quinta</label>
									</div>
									<div class="checkbox">
										 <label><input type="checkbox" /> Sexta</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="equipe" class="col-sm-4 control-label">Equipe:</label>
								<div class="col-sm-8">
									<select class="form-control" id="sel1">
										<option>Equipe</option>
										<option>Pré-Equipe</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="nr" class="col-sm-4 control-label">Nº Matrícula Clube Curitibano:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="inputEmail3" />
								</div>
							</div>
							<div class="form-group">
								<label for="nr" class="col-sm-4 control-label">Nº Cadastro FPT:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="inputEmail3" />
								</div>
							</div>
							<div class="form-group">
								<label for="nr" class="col-sm-4 control-label">Nº Cadastro CBT:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="inputEmail3" />
								</div>
							</div>
							<hr/>
							<div class="form-group">
								<label for="nr" class="col-sm-4 control-label">Nome:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="inputEmail3" />
								</div>
							</div>
							<div class="form-group" >
								<label for="nr" class="col-sm-4 control-label">Data de Nascimento:</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" id="inputEmail3" />
								</div>
							</div>
							<div class="form-group">
								<label for="nr" class="col-sm-4 control-label">Email atleta:</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" id="inputEmail3" />
								</div>
							</div>
							<div class="form-group">
								<label for="nr" class="col-sm-4 control-label">Endereço residencial do atleta:</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" id="inputEmail3" />
								</div>
							</div>
							<div class="form-group">
								<label for="nr" class="col-sm-4 control-label">Estado:</label>
								<div class="col-sm-3">
									<select class="form-control" name="estado" id="estado"> </select>
								</div>
								<label for="nr" class="col-sm-1 control-label">Cidade:</label>
								<div class="col-sm-4">
									<select class="form-control" name="cidade" id="cidade"> </select>
								</div>
							</div>
							<div class="form-group">
								<label for="nr" class="col-sm-4 control-label">Telefone Celular do atleta:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="inputEmail3" />
								</div>
							</div>
							<div class="form-group">
								<label for="nr" class="col-sm-4 control-label">Telefone Residencial do atleta:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="inputEmail3" />
								</div>
							</div>
							<div class="form-group">
								<label for="nr" class="col-sm-4 control-label">RG:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="inputEmail3" />
								</div>
							</div>
							<div class="form-group">
								<label for="nr" class="col-sm-4 control-label">CPF:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="inputEmail3" />
								</div>
							</div>
							<div class="form-group">
								<label for="nr" class="col-sm-4 control-label">Escola:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="inputEmail3" />
								</div>
							</div>
							<div class="form-group">
								<label for="nr" class="col-sm-4 control-label">Série:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="inputEmail3" />
								</div>
							</div>
							<div class="form-group">
								<label for="nr" class="col-sm-4 control-label">Turno:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="inputEmail3" />
								</div>
							</div>
							<div class="form-group">
								<label for="nr" class="col-sm-6 control-label text-left">Faz acompanhamento psicológico fora do Clube?</label>
								<div class="col-sm-2">
									<select class="form-control" name="sn"> 
										<option value="sim">Sim</option> 
										<option value="nao" selected>Não</option> 
									</select>
								</div>
								<div class="col-sm-4"></div>
							</div>
							<hr/>
							<!-- EMERGÊNCIA -->
							<div class="form-group">
								<h3 class="text-center">Cadastro de Emergência</h3>
							</div>
							<hr />
							<div class="form-group">
								<label for="emailPai" class="col-sm-4 control-label">Nome
									Médico Responsável</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" id="emailPai" />
								</div>
							</div>
							<div class="form-group">
								<label for="emailPai" class="col-sm-4 control-label">Telefone
									do Médico</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" id="emailPai" />
								</div>
							</div>
							<div class="form-group">
								<label for="emailPai" class="col-sm-4 control-label">Convênio
									Médico Hospitalar</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" id="emailPai" />
								</div>
							</div>
							<div class="form-group">
								<label for="emailPai" class="col-sm-4 control-label">Medicação
									autorizada a tomar em caso de dor</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" id="emailPai" />
								</div>
							</div>
							<div class="form-group">
								<label for="emailPai" class="col-sm-4 control-label">Alérgico</label>
								<div class="col-sm-3">
									<div class="checkbox">
										<label><input type="checkbox" /> Sim</label> <label><input
											type="checkbox" /> Não</label>
									</div>
								</div>
								<label for="emailPai" class="col-sm-1 control-label">Descrição</label>
								<div class="col-sm-4">
									<input type="email" class="form-control" id="emailPai" />
								</div>
							</div>
							<div class="form-group">
								<label for="emailPai" class="col-sm-4 control-label">Uso
									contínuo de medição</label>
								<div class="col-sm-3">
									<div class="checkbox">
										<label><input type="checkbox" /> Sim</label> <label><input
											type="checkbox" /> Não</label>
									</div>
								</div>
								<label for="emailPai" class="col-sm-1 control-label">Descrição</label>
								<div class="col-sm-4">
									<input type="email" class="form-control" id="emailPai" />
								</div>
							</div>
							<div class="form-group">
								<label for="emailPai" class="col-sm-4 control-label">Nome
									para emergência</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" id="emailPai" />
								</div>
							</div>
							<div class="form-group">
								<label for="emailPai" class="col-sm-4 control-label">Telefone</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" id="emailPai" />
								</div>
							</div>
							<div class="form-group">
								<label for="emailPai" class="col-sm-4 control-label">Grau
									de parentesco</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" id="emailPai" />
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10 text-right">
									<a class="btn btn-primary" href="SecretariaAnexosAtleta.jsp" id="anexos">Anexar Documentos</a>
									<a class="btn btn-primary" data-toggle="modal" data-target="#basicModal">Vincular Responsável</a>
									<button type="submit" class="btn btn-primary">Salvar</button>
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-1 column"></div>
				</div>
					
			</div>
				<!-- End Content -->
		</div>
	</div>
	<div class="modal fade" id="basicModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Vincular Responsável</h4>
				</div>
				<div class="modal-body">
					<!-- <div class="form-group">
						<input type="text" class="form-control" id="search" />
						</div> <button type="submit" class="btn btn-default">Buscar</button>
					</div> -->
					<div class="radio">
						<label><input type="radio" name="optradio"/> Responsável 1</label>
					</div>
					<div class="radio">
						<label><input type="radio" name="optradio"/> Responsável 2</label>
					</div>
					<div class="radio">
						<label><input type="radio" name="optradio"/> Responsável 3</label>
					</div>
				</div>
				<div class="modal-footer">
					<a class="btn btn-primary" href="SecretariaNovoResponsavel.jsp">Novo Responsável</a>
					<button type="button" class="btn btn-primary">Vincular</button>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>