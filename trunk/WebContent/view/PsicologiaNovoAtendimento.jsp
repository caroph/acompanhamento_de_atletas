	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
			<!-- menu -->
				<%@include file='../layout/navigationFisioterapia.jsp'%>
				
				<div class="row clearfix">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<h3 class="text-center">Consulta</h3>
						<hr/>
						<div class="col-md-2">
							Data do Atendimento
						</div>
						<div class="col-md-3 text-left">
							<input type="date" class="form-control" id="data" />
						</div>
						<div class="col-md-2 text-right">
							Hora:
						</div>
						<div class="col-md-2 text-left">
							<input type="text" class="form-control" id="hora" />
						</div>
						<div class="col-md-2"></div>
						<div class="col-md-12" style="padding: 10px 0px 10px 10px">
							<h4>Anotações</h4>
						</div>
						<div class="col-md-12">
							<textarea class="form-control" style="height: 325px;" id="message-text"></textarea>
						</div>
						<div class="col-md-12 text-right" style="margin: 10px 0px 0px 0px;">
								<a data-toggle="modal" href="#incluirParecer" style="margin: 0px 10px 0px 0px;">Incluir Observação</a>
								<button type="button" class="btn btn-primary">Salvar</button>
							</div>
						<div class="col-md-12" style="padding: 10px 0px 10px 0px;">
							<h3>Últimas Consultas</h3>
							<hr/>
						</div>
						<div class="col-md-12" style="padding: 0px 0px 30px 0px;">
							<div id="listaHistorico">
								<div>
									<h4>03/01/2015 - 14:00h</h4>
									<hr />
								</div>
								<div>
									<p>Aqui segue um prontuário, aqui segue um prontuário, aqui
										segue um prontuário, aqui segue um prontuário , aqui segue um
										prontuário, aqui segue um prontuário, aqui segue um prontuário,
										aqui segue um prontuário , aqui segue um prontuário, aqui segue
										um prontuário, aqui segue um prontuário, aqui segue um
										prontuário , aqui segue um prontuário, aqui segue um
										prontuário, aqui segue um prontuário, aqui segue um prontuário
										, aqui segue um prontuário, aqui segue um prontuário, aqui
										segue um prontuário, aqui segue um prontuário.</p>
									<hr />
								</div>
								<div>
									<h4>02/01/2015 - 14:30h</h4>
									<hr />
								</div>
								<div>
									<p>Aqui segue um prontuário, aqui segue um prontuário, aqui
										segue um prontuário, aqui segue um prontuário , aqui segue um
										prontuário, aqui segue um prontuário, aqui segue um prontuário,
										aqui segue um prontuário , aqui segue um prontuário, aqui segue
										um prontuário, aqui segue um prontuário, aqui segue um
										prontuário , aqui segue um prontuário, aqui segue um
										prontuário, aqui segue um prontuário, aqui segue um prontuário
										, aqui segue um prontuário, aqui segue um prontuário, aqui
										segue um prontuário, aqui segue um prontuário.</p>
									<hr />
								</div>
								<div>
									<h4>01/01/2015 - 17:00h</h4>
									<hr />
								</div>
								<div>
									<p>Aqui segue um prontuário, aqui segue um prontuário, aqui
										segue um prontuário, aqui segue um prontuário , aqui segue um
										prontuário, aqui segue um prontuário, aqui segue um prontuário,
										aqui segue um prontuário , aqui segue um prontuário, aqui segue
										um prontuário, aqui segue um prontuário, aqui segue um
										prontuário , aqui segue um prontuário, aqui segue um
										prontuário, aqui segue um prontuário, aqui segue um prontuário
										, aqui segue um prontuário, aqui segue um prontuário, aqui
										segue um prontuário, aqui segue um prontuário.</p>
									<hr />
								</div>
							</div>
						</div>
						
						
					</div>
					<div class="col-md-3"></div>
				</div>				
			</div>
		</div>
	</div>	
	
	<!-- Incluir Observação -->
	<div class="modal fade bs-example-modal-sm" id="incluirParecer" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
		    <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Incluir Observação</h4>
			</div>
	    	<div class="modal-body">
		        <form action="">
		        	<div class="form-group">
		        		<label for="message-text" class="control-label">Duração:</label>
		        		<label class="radio-inline">
		        			<input type="number" class="form-control"/>
	        			</label>	        		
		        	</div>
		        	<div class="form-group">    
				        	<label for="message-text" class="control-label" style="padding-right:15px;">Gravidade da situação:</label>
							<label class="radio-inline">
								<input type="radio" name="optradio">Baixa
							</label>
							<label class="radio-inline">
								<input type="radio" name="optradio">Moderada
							</label>
							<label class="radio-inline">
								<input type="radio" name="optradio">Alta
							</label>
					</div>
		        	<div class="form-group">    
				        	<label for="message-text" class="control-label" style="padding-right:15px;">Compartilhar com:</label>
							<label class="radio-inline">
								<input type="radio" name="optradio">Técnico
							</label>
							<label class="radio-inline">
								<input type="radio" name="optradio">Todos 
							</label>
					</div>
			        <div class="form-group">
					        <label for="message-text" class="control-label">Observação:</label>
					        <textarea class="form-control" style="max-width: 568px; height: 325px;" id="message-text"></textarea>
					</div>   
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">Incluir</button>
						<button type="button" class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
					</div>
		        </form>
		    </div>
		  </div>
		</div>
	</div>
	
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>