	<%@include file='/layout/head.jsp'%>
	
	<body>
	
	<%@include file='/layout/header.jsp'%>
	
	<div id="main" class="container-fluid">
		<div class="row">
			<%@include file='/layout/navigationSecretaria.jsp'%>
			<!--Start Content-->
			<div id="content" class="col-xs-12 col-sm-10">
				<div id="ajax-content">
					<div class="row">
						<div id="breadcrumb" class="col-xs-12">
							<ol class="breadcrumb">
								<li><a href="SecretariaController">Home</a></li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<div class="box-name">
										<i class="fa  fa-info-circle"></i>
										<span>Dados Pessoais do Atleta</span>
									</div>
									<div class="box-icons">
										<a class="collapse-link">
											<i class="fa fa-chevron-up"></i>
										</a>
										<a class="expand-link">
											<i class="fa fa-expand"></i>
										</a>
										<a class="close-link">
											<i class="fa fa-times"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
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
											<div class="col-sm-4">
												<label for="nr" class=" control-label">Nº Matrícula Clube Curitibano:</label>
												<input type="text" class="form-control" id="inputEmail3" />
											</div>
											<div class="col-sm-4">
												<label for="nr" class=" control-label">Nº Cadastro FPT:</label>
												<input type="text" class="form-control" id="inputEmail3" />
											</div>
											<div class="col-sm-4">
												<label for="nr" class=" control-label">Nº Cadastro CBT:</label>
												<input type="text" class="form-control" id="inputEmail3" />
											</div>
										</div>
										<hr/>
										<div class="form-group">
											<div class="col-sm-4">
												<label for="nr" class=" control-label">Nome:</label>
												<input type="text" class="form-control" id="inputEmail3" />
											</div>
											<div class="col-sm-4" >
												<label for="nr" class=" control-label">Data de Nascimento:</label>
												<input type="email" class="form-control" id="inputEmail3" />
											</div>
											<div class="col-sm-4">
												<label for="nr" class=" control-label">Email atleta:</label>
												<input type="email" class="form-control" id="inputEmail3" />
											</div>
										</div>
										<div class="form-group col-sm-12">
											<label for="nr" class=" control-label">Endereço Residencial:</label>
											<input type="email" class="form-control" id="inputEmail3" />
										</div>
										<div class="form-group">
											<div class="col-sm-4">
	  											<label for="numeroPai" class=" control-label">Número:</label>
												<input type="number" class="form-control" id="numeroPai" />
											</div>
											<div class="col-sm-4">
												<label for="complementoPai" class=" control-label">Complemento:</label>
												<input type="text" class="form-control" id="complementoPai" />
											</div>
											<div class="col-sm-4">
												<label for="emailPai" class="control-label">Bairro:</label>
												<input type="email" class="form-control" id="emailPai" />
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-4">
												<label for="nr" class=" control-label">Estado:</label>
												<select class="form-control" name="estado" id="estado"> </select>
											</div>
											<div class="col-sm-8">
												<label for="nr" class=" control-label">Cidade:</label>
												<select class="form-control" name="cidade" id="cidade"> </select>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-3">
												<label for="nr" class=" control-label">Telefone Residencial:</label>
												<input type="text" class="form-control" id="inputEmail3" />
											</div>
											<div class="col-sm-3">
												<label for="nr" class=" control-label">Telefone Celular:</label>
												<input type="text" class="form-control" id="inputEmail3" />
											</div>
											<div class="col-sm-3">
												<label for="nr" class=" control-label">RG:</label>
												<input type="text" class="form-control" id="inputEmail3" />
											</div>
											<div class="col-sm-3">
												<label for="nr" class=" control-label">CPF:</label>
												<input type="text" class="form-control" id="inputEmail3" />
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-6">
												<label for="nr" class=" control-label">Escola:</label>
												<input type="text" class="form-control" id="inputEmail3" />
											</div>
											<div class="col-sm-3">
												<label for="nr" class=" control-label">Série:</label>
												<input type="text" class="form-control" id="inputEmail3" />
											</div>
											<div class="col-sm-3">
												<label for="nr" class=" control-label">Turno:</label>
												<input type="text" class="form-control" id="inputEmail3" />
											</div>
										</div>
										<hr/>
										<!-- EMERGÊNCIA -->
										<div class="form-group">
											<h3 class="text-center">Cadastro de Emergência</h3>
										</div>
										<br/>
										<div class="form-group">
											<div class="col-sm-4">
												<label for="emailPai" class=" control-label">Nome Médico Responsável:</label>
												<input type="email" class="form-control" id="emailPai" />
											</div>
											<div class="col-sm-4">
												<label for="emailPai" class=" control-label">Telefone do Médico:</label>
												<input type="email" class="form-control" id="emailPai" />
											</div>
											<div class="col-sm-4">
												<label for="emailPai" class=" control-label">Convênio Médico Hospitalar:</label>
												<input type="email" class="form-control" id="emailPai" />
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-4">
												<label for="nr" class=" control-label">Acompanhamento psicológico externo:</label>
												<select class="form-control" name="sn"> 
													<option value="sim">Sim</option> 
													<option value="nao" selected>Não</option> 
												</select>
											</div>
											<div class="col-sm-8">
												<label for="emailPai" class=" control-label">Medicação autorizada a tomar em caso de dor:</label>
												<input type="email" class="form-control" id="emailPai" />
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-2">
												<label for="emailPai" class=" control-label">Alérgico:</label>
												<select class="form-control" name="sn"> 
													<option value="sim">Sim</option> 
													<option value="nao" selected>Não</option> 
												</select>
											</div>
											<div class="col-sm-4">
												<label for="emailPai" class=" control-label">Descrição</label>
												<input type="email" class="form-control" id="emailPai" />
											</div>
											<div class="col-sm-2">
												<label for="emailPai" class=" control-label">Medicação contínua:</label>
												<select class="form-control" name="sn"> 
													<option value="sim">Sim</option> 
													<option value="nao" selected>Não</option> 
												</select>
											</div>
											<div class="col-sm-4">
												<label for="emailPai" class=" control-label">Descrição</label>
												<input type="email" class="form-control" id="emailPai" />
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-4">
												<label for="emailPai" class=" control-label">Nome para emergência:</label>
												<input type="email" class="form-control" id="emailPai" />
											</div>
											<div class="col-sm-4">
												<label for="emailPai" class=" control-label">Telefone:</label>
												<input type="email" class="form-control" id="emailPai" />
											</div>
											<div class="col-sm-4">
												<label for="emailPai" class=" control-label">Grau de Parentesco:</label>
												<input type="email" class="form-control" id="emailPai" />
											</div>
										</div>
										<hr>
										<div class="form-group col-sm-4" >
											<label for="nr" class=" control-label">Data Validade Cadastro:</label>
											<input type="email" class="form-control" id="inputEmail3" />
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
							</div>
						</div>
					</div>		
				</div>
			</div>
			<!--End Content-->
		</div>
	</div>
	
	<%@include file="/layout/footer.jsp"%>
	<%@include file="Modals.jsp"%>

  </body>
</html>

