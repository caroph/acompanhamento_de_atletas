	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigation.jsp'%>
				
				<!-- Content -->
				<div class="row clearfix">
					<div class="col-md-1 column"></div>
					<div class="col-md-10 column">
						<h3 class="text-center">
							Cadastro Pessoal do Atleta
						</h3>
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
										<option>Desenvolvimento</option>
										<option>Auto Rendimento</option>
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
								<div class="col-sm-8 input-append date" id="dp3" data-date="12-02-2012" data-date-format="dd-mm-yyyy">
									<input type="text" size="16" class="form-control span2" id="dp2" data-date-format="mm/dd/yy" />
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
										<option value="nao">"N�o</option> 
									</select>
								</div>
								<div class="col-sm-4"></div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10 text-right">
									<a class="btn btn-primary" href="SecretariaAnexosAtleta.jsp" id="anexos">Anexar Documentos</a>
									<a class="btn btn-primary" data-toggle="modal" data-target="#basicModal">Vincular Respons�vel</a>
									<button type="submit" class="btn btn-primary">Salvar</button>
								</div>
							</div>
						</div>
						</form>
					</div>
					<div class="col-md-1 column"></div>
				</div>
				<!-- End Content -->
			</div>
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
						<label><input type="radio" name="optradio"/> Respons�vel 1</label>
					</div>
					<div class="radio">
						<label><input type="radio" name="optradio"/> Respons�vel 2</label>
					</div>
					<div class="radio">
						<label><input type="radio" name="optradio"/> Respons�vel 3</label>
					</div>
				</div>
				<div class="modal-footer">
					<a class="btn btn-primary" href="SecretariaNovoResponsavel.jsp">Novo Respons�vel</a>
					<button type="button" class="btn btn-primary">Vincular</button>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	
	
	
	<div class="date-form">
    
<div class="form-horizontal">
    <div class="control-group">
        <label for="date-picker-1" class="control-label">A <span class="glyphicon glyphicon-calendar"> </span>

        </label>
        <div class="controls">
            <input id="date-picker-1" type="text" class="date-picker form-control" />
        </div>
    </div>
    <div class="control-group">
        <label for="date-picker" class="control-label">B</label>
        <div class="controls">
            <div class="input-group">
                <input id="date-picker" type="text" class="date-picker form-control" />
                <label for="date-picker" class="input-group-addon btn"><span class="glyphicon glyphicon-calendar"></span>

                </label>
            </div>
        </div>
    </div>
    <div class="control-group">
        <label for="date-picker-3" class="control-label">C</label>
        <div class="controls">
            <div class="input-group">
                <label for="date-picker-3" class="input-group-addon btn"><span class="glyphicon glyphicon-calendar"></span>

                </label>
                <input id="date-picker-3" type="text" class="date-picker form-control" />
            </div>
        </div>
    </div>
</div>
    
    <hr />
<div>
    <span id="msg" class="controls form-control uneditable-input"></span>
</div>
</div>



	
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>