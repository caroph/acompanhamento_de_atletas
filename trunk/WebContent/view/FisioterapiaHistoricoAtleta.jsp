	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationFisioterapia.jsp'%>
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
						<br/>
						<div id="listaHistorico">
							<div><h4>Data: 03/01/2015</h4><hr/></div>
						    <div>
						    	<p><strong>Tipo: </strong>Parecer Oculto</p>
							    <p>Aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário
							    , aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário
							    , aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário
							    , aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário
							    , aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário.</p>
							    <hr/>
						    </div>
						    <div><h4>Data: 02/01/2015</h4><hr/></div>
						    <div>
						    	<p><strong>Tipo: </strong>Compartilhado com Todos os Profissionais</p>
							    <p>Aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário
							    , aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário
							    , aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário
							    , aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário
							    , aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário.</p>
							    <hr/>
						    </div>
						    <div><h4>Data: 01/01/2015</h4><hr/></div>
						    <div>
						    	<p><strong>Tipo: </strong>Compartilhado apenas com o Técnico</p>
							    <p>Aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário
							    , aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário
							    , aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário
							    , aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário
							    , aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário, aqui segue um prontuário.</p>
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
						<div>
						<button type="button" class="btn btn-primary"
								id="btnImprimirRelGeral" data-toggle="modal"
								data-target="#imprimir">Imprimir Histórico</button>
						</div>
					</div>
					<div class="col-md-2 column">
					</div>
				</div>
			</div>
		</div>
	</div>	
	
	<%@include file="Modals.jsp"%>
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>