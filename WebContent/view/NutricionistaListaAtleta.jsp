	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
			<!-- menu -->
				<%@include file='../layout/navigationNutricionista.jsp'%>
				
				<div class="row clearfix">
					<div class="col-md-3 column">
					</div>
					<div class="col-md-6 column">
						<h3 class="text-center">
							Buscar Atleta
						</h3>
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
							<td style="max-width: 200px;">
								Atleta 1
							</td>
							<td>
								<a data-toggle="modal" href="#selecionarCard�pio">Card�pio</a>
							</td>
							<td>
								<a href="NutricionistaAvaliacaoAntropometrica.jsp">Avalia��o Antropom�trica</a>
							</td>
							<td>
								<a data-toggle="modal" href="#incluirParecer">Parecer</a>
							</td>
							<td>
								<a href="NutricionistaFichaAtendimento.jsp">Ficha de Atendimento</a>
							</td>
						</tr>
						<tr>
							<td style="max-width: 200px;">
								Atleta 2
							</td>
							<td>
								<a data-toggle="modal" href="#selecionarCard�pio">Card�pio</a>
							</td>
							<td>
								<a href="NutricionistaAvaliacaoAntropometrica.jsp">Avalia��o Antropom�trica</a>
							</td>
							<td>
								<a data-toggle="modal" href="#incluirParecer">Parecer</a>
							</td>
							<td>
								<a href="NutricionistaFichaAtendimento.jsp">Ficha de Atendimento</a>
							</td>
						</tr>
						<tr>
							<td style="max-width: 200px;">
								Atleta 3
							</td>
							<td>
								<a data-toggle="modal" href="#selecionarCard�pio">Card�pio</a>
							</td>
							<td>
								<a href="NutricionistaAvaliacaoAntropometrica.jsp">Avalia��o Antropom�trica</a>
							</td>
							<td>
								<a data-toggle="modal" href="#incluirParecer">Parecer</a>
							</td>
							<td>
								<a href="NutricionistaFichaAtendimento.jsp">Ficha de Atendimento</a>
							</td>
						</tr>
						<tr>
							<td style="max-width: 200px;">
								Atleta 4
							</td>
							<td>
								<a data-toggle="modal" href="#selecionarCard�pio">Card�pio</a>
							</td>
							<td>
								<a href="NutricionistaAvaliacaoAntropometrica.jsp">Avalia��o Antropom�trica</a>
							</td>
							<td>
								<a data-toggle="modal" href="#incluirParecer">Parecer</a>
							</td>
							<td>
								<a href="NutricionistaFichaAtendimento.jsp">Ficha de Atendimento</a>
							</td>
						</tr>
						<tr>
							<td style="max-width: 200px;">
								Atleta 5
							</td>
							<td>
								<a data-toggle="modal" href="#selecionarCard�pio">Card�pio</a>
							</td>
							<td>
								<a href="NutricionistaAvaliacaoAntropometrica.jsp">Avalia��o Antropom�trica</a>
							</td>
							<td>
								<a data-toggle="modal" href="#incluirParecer">Parecer</a>
							</td>
							<td>
								<a href="NutricionistaFichaAtendimento.jsp">Ficha de Atendimento</a>
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
				<div class="col-md-2 column">
				</div>
			</div>
		</div>
	</div>	
	<!-- Selecionar Card�pio -->
	<div class="modal fade" id="selecionarCard�pio" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Selecionar Card�pio</h4>
				</div>
				<div class="modal-body">
					<div class="radio">
						<label><input type="radio" name="optradio"/> Card�pio 1</label>
					</div>
					<div class="radio">
						<label><input type="radio" name="optradio"/> Card�pio 2</label>
					</div>
					<div class="radio">
						<label><input type="radio" name="optradio"/> Card�pio 3</label>
					</div>
				</div>
				<div class="modal-footer">
					<a class="btn btn-primary" href="#">Card�pio Personalizado</a>
					<button type="button" class="btn btn-primary" data-dismiss="modal">Selecionar</button>
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
		        <form action="">
			        <div class="form-group">
					        <label for="message-text" class="control-label">Parecer:</label>
					        <textarea class="form-control" id="message-text"></textarea>
					</div>   
					<div class="form-group">    
				        	<label for="message-text" class="control-label" style="padding-right:15px;">Compartilhar com:</label>
							<label class="radio-inline">
								<input type="radio" name="optradio">Parecer Oculto
							</label>
							<label class="radio-inline">
								<input type="radio" name="optradio">T�cnico
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