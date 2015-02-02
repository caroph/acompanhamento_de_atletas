	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
			<!-- menu -->
				<%@include file='../layout/navigationFisioterapia.jsp'%>
				
				<div class="row clearfix">
					<div class="col-md-3 column">
					</div>
					<div class="col-md-6 column">
						<h3 class="text-center">
							Buscar Atleta
						</h3>
						<form role="form" action="FisioterapiaListaAtleta.jsp">
						    <div class="input-group">
						      <input type="text" class="form-control form-search" id="search">
						      <span class="input-group-btn">
						        <button class="btn btn-default" type="submit">
						        	<i class="icon-large icon-search"></i></button>
						      </span>
						    </div>
						</form>
					</div>
					<div class="col-md-3 column">
					</div>
				</div>
				
				<div class="col-md-12 column">
					<h3 class="text-center">
							Atletas Encontrados
					</h3>
					<table class="table">
						<thead>
							<tr>
								<th class="text-center" width="36%">
									Nome
								</th>
								<th class="text-center" width="10%">
									�ltimo Atendimento
								</th>
								<th width="13%">
								</th>
								<th width="13%">
								</th>
								<th width="13%">
								</th>
								<th width="15%">
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-left">
									Atleta 1
								</td>
								<td class="text-center">
									01/02/2015
								</td>
								<td class="text-center">
									<a data-toggle="modal" href="#anunciarPresenca">Registrar Presen�a</a>
								</td>
								<td class="text-center">
									<a href="FisioterapiaNovoAtendimento.jsp">Novo Atendimento</a>
								</td>
								<td class="text-center">
									<a href="FisioterapiaHistoricoAtleta2.jsp">Ver Hist�rico</a>
								</td>
								<td class="text-center">
									<a data-toggle="modal" href="#incluirParecer">Adicionar Observa��o</a>
								</td>
							</tr>
							<tr>
								<td class="text-left">
									Atleta 2
								</td>
								<td class="text-center">
									01/04/2015
								</td>
								<td class="text-center">
									<a data-toggle="modal" href="#anunciarPresenca">Registrar Presen�a</a>
								</td>
								<td class="text-center">
									<a href="FisioterapiaNovoAtendimento.jsp">Novo Atendimento</a>
								</td>
								<td class="text-center">
									<a href="FisioterapiaHistoricoAtleta2.jsp">Ver Hist�rico</a>
								</td>
								<td class="text-center">
									<a data-toggle="modal" href="#incluirParecer">Adicionar Observa��o</a>
								</td>
							</tr>
							<tr>
								<td class="text-left">
									Atleta 3
								</td>
								<td class="text-center">
									01/07/2015
								</td>
								<td class="text-center">
									<a data-toggle="modal" href="#anunciarPresenca">Registrar Presen�a</a>
								</td>
								<td class="text-center">
									<a href="FisioterapiaNovoAtendimento.jsp">Novo Atendimento</a>
								</td>
								<td class="text-center">
									<a href="FisioterapiaHistoricoAtleta2.jsp">Ver Hist�rico</a>
								</td>
								<td class="text-center">
									<a data-toggle="modal" href="#incluirParecer">Adicionar Observa��o</a>
								</td>
							</tr>
							<tr>
								<td class="text-left">
									Atleta 4
								</td>
								<td class="text-center">
									01/09/2015
								</td>
								<td class="text-center">
									<a data-toggle="modal" href="#anunciarPresenca">Registrar Presen�a</a>
								</td>
								<td class="text-center">
									<a href="FisioterapiaNovoAtendimento.jsp">Novo Atendimento</a>
								</td>
								<td class="text-center">
									<a href="FisioterapiaHistoricoAtleta2.jsp">Ver Hist�rico</a>
								</td>
								<td class="text-center">
									<a data-toggle="modal" href="#incluirParecer">Adicionar Observa��o</a>
								</td>
							</tr>
							<tr>
								<td class="text-left">
									Atleta 5
								</td>
								<td class="text-center">
									01/05/2015
								</td>
								<td class="text-center">
									<a data-toggle="modal" href="#anunciarPresenca">Registrar Presen�a</a>
								</td>
								<td class="text-center">
									<a href="FisioterapiaNovoAtendimento.jsp">Novo Atendimento</a>
								</td>
								<td class="text-center">
									<a href="FisioterapiaHistoricoAtleta2.jsp">Ver Hist�rico</a>
								</td>
								<td class="text-center">
									<a data-toggle="modal" href="#incluirParecer">Adicionar Observa��o</a>
								</td>
							</tr>
						</tbody>
					</table>
					<ul class="pagination">
						<li>
							<a href="#">Anterior</a>
						</li>
						<li>
							<a href="#">1</a>
						</li>
						<li>
							<a href="#">2</a>
						</li>
						<li>
							<a href="#">3</a>
						</li>
						<li>
							<a href="#">4</a>
						</li>
						<li>
							<a href="#">5</a>
						</li>
						<li>
							<a href="#">Pr�ximo</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>	
	
	<!-- Anunciar Presen�a -->
	<div class="modal fade bs-example-modal-sm" id="anunciarPresenca" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	    	<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Registrar Presen�a</h4>
			</div>
			<div class="modal-body">
				<label for="message-text" class="control-label" >Confirma que o(a) atleta xxxxxx est� em fisioterapia nesse momento?</label>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">Sim</button>
				<button type="button" class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
			</div>
	    </div>
	  </div>
	</div>
	
	<!-- Incluir Observa��o -->
	<div class="modal fade bs-example-modal-sm" id="incluirParecer" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
		    <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Incluir Observa��o</h4>
			</div>
	    	<div class="modal-body">
		        <form action="">
		        	<div class="form-group">
		        		<label for="message-text" class="control-label">Dura��o:</label>
		        		<label class="radio-inline">
		        			<input type="number" class="form-control"/>
	        			</label>	        		
		        	</div>
		        	<div class="form-group">    
				        	<label for="message-text" class="control-label" style="padding-right:15px;">Gravidade da situa��o:</label>
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
								<input type="radio" name="optradio">T�cnico
							</label>
							<label class="radio-inline">
								<input type="radio" name="optradio">Todos 
							</label>
					</div>
			        <div class="form-group">
					        <label for="message-text" class="control-label">Observa��o:</label>
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