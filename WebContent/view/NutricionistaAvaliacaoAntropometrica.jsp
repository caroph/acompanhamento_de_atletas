	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationNutricionista.jsp'%>
				<div class="row clearfix">
					<div class="col-md-1 column"></div>
					<div class="col-md-7 column">
						<h3>Atleta: XXX</h3>
					</div>
					<div class="col-md-4 column">
						<form role="form" action="#">
						    <div class="input-group">
						      <input type="text" class="form-control form-search" id="search">
						      <span class="input-group-btn">
						        <button class="btn btn-default" type="submit">
						        	<i class="icon-large icon-search"></i></button>
						      </span>
						    </div>
						</form>
					</div>
				</div>
				<div class="row clearfix">
					<div class="col-md-2 column">
					</div>
					<div class="col-md-8 column">
						<div id="listaHistorico">
							<div><h4>Data: 03/01/2015</h4><hr/></div>
						    <div>
							    <p> 
							    	PESO: 42 (Ganhar peso)<br/>
									ALTURA: 1,62<br/>
									<br/>
									CB direito = 21,5<br/>
									CB esquerdo = 21,5<br/>
									<br/>
									CC direita = 49<br/>
									CC esquerda = 49 <br/>
									<br/>
									% DE GORDURA: 7,91 <br/>
								</p>
							    <hr/>
						    </div>
						    <div><h4>Data: 02/01/2015</h4><hr/></div>
						    <div>
							    <p> 
							    	PESO: 42,6 (Ganhar peso)<br/>
									ALTURA: 1,62
								</p>
							    <hr/>
						    </div>
						    <div><h4>Data: 01/01/2015</h4><hr/></div>
						    <div>
							    <p>
							    	PESO: 43 kg<br/>
									ALTURA: 1,625<br/>
									<br/>
									%GC: 7,24<br/>
							    </p>
							    <hr/>
						    </div>
					    </div>
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
								<a href="#">Próximo</a>
							</li>
						</ul>
						<a class="btn btn-primary" data-toggle="modal" href="#novaAvaliação">Incluir Avaliação</a>
					</div>
					<div class="col-md-2 column">
					</div>
				</div>
			</div>
		</div>
	</div>	
	<div class="modal fade bs-example-modal-sm" id="novaAvaliação" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
		    <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Incluir Avaliação Antropométrica</h4>
			</div>
	    	<div class="modal-body">
		        <form action="">
			        <div class="form-group">
					        <label for="message-text" class="control-label">Avaliação:</label>
					        <textarea class="form-control" id="message-text"></textarea>
					</div>   
					<div class="form-group">    
				        	<label for="message-text" class="control-label" style="padding-right:15px;">Compartilhar com:</label>
							<label class="radio-inline">
								<input type="radio" name="optradio">Parecer Oculto
							</label>
							<label class="radio-inline">
								<input type="radio" name="optradio">Técnico
							</label>
							<label class="radio-inline">
								<input type="radio" name="optradio">Todos 
							</label>
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