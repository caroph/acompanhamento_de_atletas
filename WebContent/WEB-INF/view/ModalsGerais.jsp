<div class="modal fade" id="alterarSenha" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
			<h4 class="modal-title" id="myModalLabel">Alterar Senha</h4>
			</div>
			<div class="modal-body">
				<form role="form" method="post" action="SecretariaController?action=alterarSenhaUsuario">
					<div class="form-group">
						<div>
							<label for="senhaAtual" class="control-label">Senha atual:</label> 
							<input type="password" value="" required class="form-control" id="senhaAtual" name="senhaAtual" />
						</div>
						<div>
							<label for="novaSenha" class="control-label">Nova senha:</label> 
							<input type="password" value="" required class="form-control" id="novaSenha" name="novaSenha" />
						</div>
						<div>
							<label for="confirmacaoSenha" class="control-label">Confirmação nova senha:</label> 
							<input type="password" value="" required class="form-control" id="confirmacaoSenha" name="confirmacaoSenha" />
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">Alterar</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>