	
	
<!-- 	Modal Delete -->
	<div class="modal fade bs-example-modal-sm" id="deletar" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	    	<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Deletar</h4>
			</div>
			<div class="modal-body">
				<label for="message-text" class="control-label" >Deseja realmente deletar?</label>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-danger">Sim</button>
				<button type="button" class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
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
