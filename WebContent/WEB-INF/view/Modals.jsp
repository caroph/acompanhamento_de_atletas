<!-- NOVAS -->
<!-- Modal Vincular Responsável -->
<div class="modal fade" id="vincularResponsavel" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
			<h4 class="modal-title" id="myModalLabel">Vincular Responsável  ${pagina}</h4>
			</div>
			<div class="vincular-body" style="margin-left: 20px;">
				<form method="POST" action="SecretariaController?action=vincularResponsavel">
					<p></p>
					
					<div class="modal-footer">
						<a class="btn btn-primary" href="SecretariaController?action=jspNovoResponsavel">Novo Responsável</a>
						<button type="submit" class="btn btn-primary">Vincular</button>
					</div>
				</form>
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
			<form method="POST" action="NutricionistaController?action=RegistrarPresenca">
				<label id="lblNomeAtleta" style="padding-bottom: 16px;" class="control-label" >Confirma que o(a) atleta está em consulta? (incluir data e hora)</label>
				<input type="hidden" id="idAtleta" name="idAtleta" value=""/>
				<div class="col-md-6">
					<div class="col-md-2">Data:</div>
					<div class="col-md-10">
						<input type="date" class="form-control" id="dataPresenca" name="dataPresenca"/>
					</div>
				</div>
				<div class="col-md-6">
					<div class="col-md-2"> Hora: </div>
					<div class="col-md-10">
						<input type="time" class="form-control" id="hrPresenca" name="hrPresenca" />
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Sim</button>
					<button type="button" class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
				</div>
			</form>
		</div>
    </div>
  </div>
</div>



<!-- ---------------------ANTIGAS! ANTIGAS! ANTIGAS! ANTIGAS! ANTIGAS! ------------------ -->

<!-- Modal ver detalhes do atleta -->
<div class="modal fade" id="verDetalhes" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
			<h4 class="modal-title" id="myModalLabel">Detalhes Atleta</h4>
			</div>
			<div class="modal-body">
				<div class="row clearfix">
					<div class="col-md-12 text-left">
						<div class="col-md-4">
							<img src="../themes/default/assets/img/avatar.jpg" width="150px" height="150px"/>								
						</div>
						<div class="col-md-8 text-left">
							Nome: Atleta X<br/>
							Equipe: Equipe<br/>
							Dias que treina: Seg, Ter, Qua<br/>
							Nº. Matrícula Clube Curitibano: XXXX<br/>
							Nº. Cadastro FPT: XXXX<br/>
							Nº. Cadastro CBT: XXXX<br/>
							Responsável: Responsável 1<br/>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal" id="fechar">Fechar</button>
			</div>
		</div>
	</div>
</div>		
	
<!-- Modal Imprimir -->
<div class="modal fade" id="imprimir" tabindex="-1" role="dialog"
			aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							id="fechar" aria-hidden="true">x</button>
						<h4 class="modal-title" id="myModalLabel">Imprimindo
							Relatório</h4>
					</div>
					<div class="modal-body">
						<div class="text-center">Imprimindo</div>
						<div class="progress" style="margin-top: 10px;" id="progress">
							<div class="progress-bar progress-bar-striped active"
								role="progressbar" aria-valuenow="100" aria-valuemin="0"
								aria-valuemax="100" style="width: 99%">99%</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							id="fechar">Fechar</button>
					</div>
				</div>
			</div>
		</div>
		
<!-- Modal Resultado Torneio-->
<div class="modal fade" id="resultadoRegistrar" tabindex="-1" role="dialog"
			aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							id="fechar" aria-hidden="true">x</button>
						<h4 class="modal-title" id="myModalLabel">Resultados</h4>
					</div>
					<div class="modal-body">
						Atleta 1 - Posição 2º<br/>
						Atleta 2 - Posição 6º<br/>
						Atleta 3 - Posição 1º<br/>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">Fechar</button>
					</div>
				</div>
			</div>
		</div>

<!-- 	Modal Editar -->
	<div class="modal fade bs-example-modal-xs" id="editar" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	    	<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<br/>
			</div>
			<div class="modal-body">
				<label for="message-text" class="control-label" >Atividade alterada com sucesso!</label>
			</div>
	    </div>
	  </div>
	</div>
	
	<!-- Detalhes Cardápio-->
	<div class="modal fade" id="detalhesCardapio" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
					<h4 class="modal-title" id="myModalLabel">Detalhes Cardápio</h4>
					</div>
					<div class="modal-body">
						Nome: Cardápio X<br/>
						Café da Manhã: xxx<br/>
						Lanche I: xxx<br/>
						Almoço: xxx<br/>
						Lanche II: XXXX<br/>
						Janta: XXXX<br/>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal" id="fechar">Fechar</button>
					</div>
				</div>
			</div>
		</div>	
	
	<!-- Atletas com Pendencias -->	
	<div class="modal fade" id="basicModal" tabindex="-1" role="dialog"	aria-labelledby="basicModal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">x</button>
					<h4 class="modal-title" id="myModalLabel">Alunos com pendências</h4>
				</div>
				<div class="modal-body">
					<table class="table">
						<tr>
							<th class="text-center">Nome do aluno</th>
							<th class="text-center">Matrícula</th>
							<th></th>
						</tr>
						<tr>
							<td>Atleta 01</td>
							<td class="text-center">00000001</td>
							<td><a href="SecretariaAnexosAtleta.jsp">Anexar Documentos</a></td>
						</tr>
						<tr>
							<td>Atleta 02</td>
							<td class="text-center">00000002</td>
							<td><a href="SecretariaAnexosAtleta.jsp">Anexar Documentos</a></td>
						</tr>
						<tr>
							<td >Atleta 03</td>
							<td class="text-center">00000003</td>
							<td><a href="SecretariaAnexosAtleta.jsp">Anexar Documentos</a></td>
						</tr>
						<tr>
							<td>Atleta 04</td>
							<td class="text-center">00000004</td>
							<td><a href="SecretariaAnexosAtleta.jsp">Anexar Documentos</a></td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal"
						id="fechar">Fechar</button>
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