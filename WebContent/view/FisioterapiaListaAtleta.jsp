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
						<form role="form" action="SecretariaListaFisioterapia.jsp">
							<div class="form-group">
								<input type="text" class="form-control" id="search" />
							</div> <button type="submit" class="btn btn-default">Buscar</button>
						</form>
					</div>
					<div class="col-md-3 column">
					</div>
				</div>
				
				<div class="col-md-2 column">
				</div>
				<div class="col-md-8 column">
					<h3 class="text-center">
							Atletas Encontrados
					</h3>
					<table class="table">
					<thead>
						<tr>
							<th>
								Nome
							</th>
							<th>
							</th>
							<th>
							</th>
							<th>
							</th>
							<th>
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								Atleta 1
							</td>
							<td>
								<a data-toggle="modal" href="#anunciarPresenca">Anunciar Presença</a>
							</td>
							<td>
								<a>Incluir Parecer</a>
							</td>
							<td>
								<a>Ver Histórico</a>
							</td>
							<td>
								<a>Excluir</a>
							</td>
						</tr>
						<tr>
							<td>
								Atleta 2
							</td>
							<td>
								<a data-toggle="modal" href="#anunciarPresenca">Anunciar Presença</a>
							</td>
							<td>
								<a data-toggle="modal" href="#incluirParecer">Incluir Parecer</a>
							</td>
							<td>
								<a>Ver Histórico</a>
							</td>
							<td>
								<a>Excluir</a>
							</td>
						</tr>
						<tr>
							<td>
								Atleta 3
							</td>
							<td>
								<a data-toggle="modal" href="#anunciarPresenca">Anunciar Presença</a>
							</td>
							<td>
								<a>Incluir Parecer</a>
							</td>
							<td>
								<a>Ver Histórico</a>
							</td>
							<td>
								<a>Excluir</a>
							</td>
						</tr>
						<tr>
							<td>
								Atleta 4
							</td>
							<td>
								<a data-toggle="modal" href="#anunciarPresenca">Anunciar Presença</a>
							</td>
							<td>
								<a>Incluir Parecer</a>
							</td>
							<td>
								<a>Ver Histórico</a>
							</td>
							<td>
								<a>Excluir</a>
							</td>
						</tr>
						<tr>
							<td>
								Atleta 5<br>
							</td>
							<td>
								<a data-toggle="modal" href="#anunciarPresenca">Anunciar Presença</a>
							</td>
							<td>
								<a>Incluir Parecer</a>
							</td>
							<td>
								<a>Ver Histórico</a>
							</td>
							<td>
								<a>Excluir</a>
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
							<a href="#">Próximo</a>
						</li>
					</ul>
				</div>
				<div class="col-md-2 column">
				</div>
			</div>
		</div>
	</div>	
	
	<!-- Anunciar Presença -->
	<div class="modal fade bs-example-modal-sm" id="anunciarPresenca" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	    	<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Anunciar Presença</h4>
			</div>
			<div class="modal-body">
				<label for="message-text" class="control-label" >Deseja confirmar que o(a) atleta xxxxxx está em fisioterapia nesse momento?</label>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">Sim</button>
				<button type="button" class="btn" data-dismiss="modal" aria-hidden="true">Não</button>
			</div>
	    </div>
	  </div>
	</div>
	
	<!-- Incluir Parecer -->
	<div class="modal fade bs-example-modal-sm" id="incluirParecer" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
		    <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Incluir Parecer</h4>
			</div>
	    	<div class="modal-body">
		        <form>
			        <div class="form-group">
				        <label for="message-text" class="control-label">Parecer:</label>
				        <textarea class="form-control" id="message-text"></textarea>
				        <div class="col-sm-8 form-inline">
							<div class="checkbox">
								 <label><input type="checkbox" />Oculto</label>
							</div>
							<div class="checkbox">
								 <label><input type="checkbox" />À todos os profissionais</label>
							</div>
							<div class="checkbox">
								 <label><input type="checkbox" />Apenas ao técnico</label>
							</div>
						</div>
			        </div>
		        </form>
		        <div class="modal-footer">
					<button type="button" class="btn btn-primary">Sim</button>
					<button type="button" class="btn" data-dismiss="modal" aria-hidden="true">Não</button>
				</div>
		    </div>
		  </div>
		</div>
	</div>
	
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>