	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
			<!-- menu -->
				<%@include file='../layout/navigationNutricionista.jsp'%>
				
				<div class="col-md-2 column"></div>
				<div class="col-md-8 column" style="margin-top: 30px;">
					<h3 class="text-center">
							Último Atendimentos
					</h3>
					<table class="table">
					<thead>
						<tr>
							<th class="text-center">
								Nome
							</th>
							<th class="text-center">
								Data
							</th>
							<th>
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
								<td style="max-width: 200px;" class="text-center">Atleta 1</td>
								<td class="text-center">01/01/2015</td>
								<td><a href="NutricionistaFichaAtendimento.jsp">Ficha
										de Atendimento</a></td>
								<td><a data-toggle="modal" href="#incluirParecer">Incluir
										Observação</a></td>
								<td><a href="NutricionistaFichaDeAtendimento.jsp">Novo
										Atendimento</a></td>
								<td><a href="NutricionistaDietaAtleta.jsp">Dieta</a></td>
								<td><a href="NutricionistaHistoricoAtleta.jsp">Histórico</a>
								</td>
							</tr>
							<tr>
								<td style="max-width: 200px;" class="text-center">Atleta 2</td>
								<td class="text-center">01/01/2015</td>
								<td><a href="NutricionistaFichaAtendimento.jsp">Ficha
										de Atendimento</a></td>
								<td><a data-toggle="modal" href="#incluirParecer">Incluir
										Observação</a></td>
								<td><a href="NutricionistaFichaAtendimento.jsp">Novo
										Atendimento</a></td>
								<td><a href="NutricionistaDietaAtleta.jsp">Dieta</a></td>
								<td><a href="NutricionistaHistoricoAtleta.jsp">Histórico</a>
								</td>
							</tr>
							<tr>
								<td style="max-width: 200px;" class="text-center">Atleta 3</td>
								<td class="text-center">01/01/2015</td>
								<td><a href="NutricionistaFichaAtendimento.jsp">Ficha
										de Atendimento</a></td>
								<td><a data-toggle="modal" href="#incluirParecer">Incluir
										Observação</a></td>
								<td><a href="NutricionistaFichaAtendimento.jsp">Novo
										Atendimento</a></td>
								<td><a href="NutricionistaDietaAtleta.jsp">Dieta</a></td>
								<td><a href="NutricionistaHistoricoAtleta.jsp">Histórico</a>
								</td>
							</tr>
							<tr>
								<td style="max-width: 200px;" class="text-center">Atleta 4</td>
								<td class="text-center">01/01/2015</td>
								<td><a href="NutricionistaFichaAtendimento.jsp">Ficha
										de Atendimento</a></td>
								<td><a data-toggle="modal" href="#incluirParecer">Incluir
										Observação</a></td>
								<td><a href="NutricionistaFichaAtendimento.jsp">Novo
										Atendimento</a></td>
								<td><a href="NutricionistaDietaAtleta.jsp">Dieta</a></td>
								<td><a href="NutricionistaHistoricoAtleta.jsp">Histórico</a>
								</td>
							</tr>

							<tr>
								<td style="max-width: 200px;" class="text-center">Atleta 5</td>
								<td class="text-center">01/01/2015</td>
								<td><a href="NutricionistaFichaAtendimento.jsp">Ficha
										de Atendimento</a></td>
								<td><a data-toggle="modal" href="#incluirParecer">Incluir
										Observação</a></td>
								<td><a href="NutricionistaFichaAtendimento.jsp">Novo
										Atendimento</a></td>
								<td><a href="NutricionistaDietaAtleta.jsp">Dieta</a></td>
								<td><a href="NutricionistaHistoricoAtleta.jsp">Histórico</a>
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
				<div class="col-md-2 column"></div>				
			</div>
		</div>
	</div>	
	<!-- Selecionar Cardápio -->
	<div class="modal fade" id="selecionarCardápio" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Selecionar Cardápio</h4>
				</div>
				<div class="modal-body">
					<div class="radio">
						<label><input type="radio" name="optradio"/> Cardápio 1</label>
					</div>
					<div class="radio">
						<label><input type="radio" name="optradio"/> Cardápio 2</label>
					</div>
					<div class="radio">
						<label><input type="radio" name="optradio"/> Cardápio 3</label>
					</div>
				</div>
				<div class="modal-footer">
					<a class="btn btn-primary" href="NutricionistaNovoCardapio.jsp">Cardápio Personalizado</a>
					<button type="button" class="btn btn-primary" data-dismiss="modal">Selecionar</button>
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