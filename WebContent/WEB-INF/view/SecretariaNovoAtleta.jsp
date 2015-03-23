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
													 <label><input type="checkbox" /> Ter�a</label>
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
													<option>Pr�-Equipe</option>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label for="nr" class="col-sm-4 control-label">N� Matr�cula Clube Curitibano:</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="inputEmail3" />
											</div>
										</div>
										<div class="form-group">
											<label for="nr" class="col-sm-4 control-label">N� Cadastro FPT:</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="inputEmail3" />
											</div>
										</div>
										<div class="form-group">
											<label for="nr" class="col-sm-4 control-label">N� Cadastro CBT:</label>
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
											<label for="nr" class="col-sm-4 control-label">Endere�o residencial do atleta:</label>
											<div class="col-sm-8">
												<input type="email" class="form-control" id="inputEmail3" />
											</div>
										</div>
										<div class="form-group">
											 <label for="numeroPai" class="col-sm-4 control-label">N�mero</label>
											<div class="col-sm-8">
												<input type="number" class="form-control" id="numeroPai" />
											</div>
										</div>
										<div class="form-group">
											 <label for="complementoPai" class="col-sm-4 control-label">Complemento</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="complementoPai" />
											</div>
										</div>
										<div class="form-group">
											 <label for="emailPai" class="col-sm-4 control-label">Bairro</label>
											<div class="col-sm-8">
												<input type="email" class="form-control" id="emailPai" />
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
											<label for="nr" class="col-sm-4 control-label">S�rie:</label>
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
											<label for="nr" class="col-sm-6 control-label text-left">Faz acompanhamento psicol�gico fora do Clube?</label>
											<div class="col-sm-2">
												<select class="form-control" name="sn"> 
													<option value="sim">Sim</option> 
													<option value="nao" selected>N�o</option> 
												</select>
											</div>
											<div class="col-sm-4"></div>
										</div>
										<hr/>
										<!-- EMERG�NCIA -->
										<div class="form-group">
											<h3 class="text-center">Cadastro de Emerg�ncia</h3>
										</div>
										<hr />
										<div class="form-group">
											<label for="emailPai" class="col-sm-4 control-label">Nome
												M�dico Respons�vel</label>
											<div class="col-sm-8">
												<input type="email" class="form-control" id="emailPai" />
											</div>
										</div>
										<div class="form-group">
											<label for="emailPai" class="col-sm-4 control-label">Telefone
												do M�dico</label>
											<div class="col-sm-8">
												<input type="email" class="form-control" id="emailPai" />
											</div>
										</div>
										<div class="form-group">
											<label for="emailPai" class="col-sm-4 control-label">Conv�nio
												M�dico Hospitalar</label>
											<div class="col-sm-8">
												<input type="email" class="form-control" id="emailPai" />
											</div>
										</div>
										<div class="form-group">
											<label for="emailPai" class="col-sm-4 control-label">Medica��o
												autorizada a tomar em caso de dor</label>
											<div class="col-sm-8">
												<input type="email" class="form-control" id="emailPai" />
											</div>
										</div>
										<div class="form-group">
											<label for="emailPai" class="col-sm-4 control-label">Al�rgico</label>
											<div class="col-sm-3">
												<div class="checkbox">
													<label><input type="checkbox" /> Sim</label> <label><input
														type="checkbox" /> N�o</label>
												</div>
											</div>
											<label for="emailPai" class="col-sm-1 control-label">Descri��o</label>
											<div class="col-sm-4">
												<input type="email" class="form-control" id="emailPai" />
											</div>
										</div>
										<div class="form-group">
											<label for="emailPai" class="col-sm-4 control-label">Uso
												cont�nuo de medi��o</label>
											<div class="col-sm-3">
												<div class="checkbox">
													<label><input type="checkbox" /> Sim</label> <label><input
														type="checkbox" /> N�o</label>
												</div>
											</div>
											<label for="emailPai" class="col-sm-1 control-label">Descri��o</label>
											<div class="col-sm-4">
												<input type="email" class="form-control" id="emailPai" />
											</div>
										</div>
										<div class="form-group">
											<label for="emailPai" class="col-sm-4 control-label">Nome
												para emerg�ncia</label>
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
										<hr>
										<div class="form-group" >
											<label for="nr" class="col-sm-4 control-label">Data Validade Cadastro:</label>
											<div class="col-sm-8">
												<input type="email" class="form-control" id="inputEmail3" />
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10 text-right">
												<a class="btn btn-primary" href="SecretariaAnexosAtleta.jsp" id="anexos">Anexar Documentos</a>
												<a class="btn btn-primary" data-toggle="modal" data-target="#basicModal">Vincular Respons�vel</a>
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

