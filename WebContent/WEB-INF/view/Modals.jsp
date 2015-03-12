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
							N�. Matr�cula Clube Curitibano: XXXX<br/>
							N�. Cadastro FPT: XXXX<br/>
							N�. Cadastro CBT: XXXX<br/>
							Respons�vel: Respons�vel 1<br/>
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
							Relat�rio</h4>
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
						Atleta 1 - Posi��o 2�<br/>
						Atleta 2 - Posi��o 6�<br/>
						Atleta 3 - Posi��o 1�<br/>
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
	
	<!-- Detalhes Card�pio-->
	<div class="modal fade" id="detalhesCardapio" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
					<h4 class="modal-title" id="myModalLabel">Detalhes Card�pio</h4>
					</div>
					<div class="modal-body">
						Nome: Card�pio X<br/>
						Caf� da Manh�: xxx<br/>
						Lanche I: xxx<br/>
						Almo�o: xxx<br/>
						Lanche II: XXXX<br/>
						Janta: XXXX<br/>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal" id="fechar">Fechar</button>
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
				<h4 class="modal-title" id="myModalLabel">Anunciar Presen�a</h4>
			</div>
			<div class="modal-body">
				<label for="message-text" class="control-label" >Confirma que o(a) atleta xxxxxx est� em consulta? (incluir data e hora)</label>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">Sim</button>
				<button type="button" class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
			</div>
	    </div>
	  </div>
	</div>