<!-- Modal Vincular Responsável -->
<div class="modal fade" id="vincularResponsavel" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
			<h4 class="modal-title" id="myModalLabel">Vincular Responsável</h4>
			</div>
			<div class="vincular-body" style="margin-left: 20px;">
				<form method="POST" action="SecretariaController?action=vincularResponsavel">
					<p></p>					
					<div class="modal-footer">
						<a class="btn btn-info" href="SecretariaController?action=jspNovoResponsavel">Novo Responsável</a>
						<button type="submit" class="btn btn-primary">Vincular</button>
						<button type="button" class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
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
			<form method="POST" action="Controller?action=RegistrarPresenca">
				<label id="lblNomeAtleta" style="padding-bottom: 16px;" class="control-label col-sm-12" ></label>
				<input type="hidden" id="idAtleta" name="idAtleta" value=""/>
				<div  class="form-group" style="padding-bottom: 13%;">
					<div class="col-sm-6">
						<label for="dataPresenca" class=" control-label">Data:</label>
						<input type="date" class="form-control" id="dataPresenca" name="dataPresenca" required/>
					</div>
					<div class="col-sm-6">
						<label for="hrPresenca" class=" control-label">Hora:</label>
						<input type="time" class="form-control" id="hrPresenca" name="hrPresenca" required/>
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


<!-- Novo Atendimento -->
<div class="modal fade bs-example-modal-sm" id="novoAtendimento" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
    	<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
			<h4 class="modal-title" id="myModalLabel">Novo Atendimento</h4>
		</div>
		<div class="modal-body">
			<form method="POST" action="SaudeGeralController?action=novoAtendimento">
				<label id="lblAtendimento" style="padding-bottom: 16px;" class="control-label col-sm-12"></label>
				<input type="hidden" id="idAtletaAtend" name="idAtletaAtend"/>
				<input type="hidden" id="idProntuario" name="idProntuario"/>
				<div  class="form-group">
					<div class="col-sm-6">
						<label for="dtAtendimento" class=" control-label">Data:</label>
						<input type="date" class="form-control" id="dtAtendimento" name="dtAtendimento" required/>
					</div>
					<div class="col-sm-6">
						<label for="hrAtendimento" class=" control-label">Hora:</label>
						<input type="time" class="form-control" id="hrAtendimento" name="hrAtendimento" required/>
					</div>
				</div>
				<div  class="form-group" style="padding-bottom: 26%;">
					<div class="col-md-12">
						<label class=" control-label">Anotações:</label>
						<textarea class="form-control" id="anotacao" name="anotacao" required></textarea>
					</div>
				</div>
				<div class="modal-footer">
<!-- 				<button type="button" class="btn btn-info">Incluir Observação</button> -->
					<button type="submit" class="btn btn-primary">Salvar</button>
					<button type="button" class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
				</div>
			</form>
		</div>
    </div>
  </div>
</div>

<!-- Modal AlterarPresenca -->
<div class="modal fade" id="modalPresenca" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
			<h4 class="modal-title" id="myModalLabel">Editar Presença</h4>
			</div>
			<div class="modal-body">
				<form method="POST" action="TecnicoController?action=editarChamada">
					<div style="height: 200px;">
						<div class="col-md-6">
							<label><input type="radio" name="optradio" value="1"/>
							<span class="fa fa-check" aria-hidden="true" style="color: green"></span> Presente</label>
						</div>
						<div class="col-md-6">
							<label><input type="radio" name="optradio" value="2"/>
							<span class="fa fa-ban" aria-hidden="true" style="color: red"></span> Falta</label>
						</div>
						<div class="col-md-6">
							<label><input type="radio" name="optradio" value="3"/>
							<span class="fa fa-trophy" aria-hidden="true" style="color: rgb(97, 97, 7)"></span> Torneio</label>
						</div>
						<div class="col-md-6">
							<label><input type="radio" name="optradio" value="4"/>
							<span class="fa fa-ambulance" aria-hidden="true" style="color: red"></span> Falta médica</label>
						</div>
						<div class="col-md-6">
							<label><input type="radio" name="optradio" value="5"/>
							<span class="fa fa-cutlery" aria-hidden="true" style="color: black"></span> Nutricionista</label>
						</div>
						<div class="col-md-6">
							<label><input type="radio" name="optradio" value="6"/>
							<span class="fa fa-question" aria-hidden="true" style="color: black"></span> Fisioterapeuta</label>
						</div>
						<div class="col-md-6">
							<label><input type="radio" name="optradio" value="7"/>
							<span class="fa fa-comment" aria-hidden="true" style="color: black"></span> Psicólogo(a)</label>
						</div>
						<div class="col-md-6">
							<label><input type="radio" name="optradio" value="8"/>
							<span class="fa fa-pencil-square-o" aria-hidden="true" style="color: blue"></span> Escola</label>
						</div>
						<div class="col-md-6">
							<label><input type="radio" name="optradio" value="9"/>
							<span class="fa fa-exclamation" aria-hidden="true" style="color: black"></span> Outros</label>
						</div>
						<div class="col-md-12">
							<label>Justificativa: </label>
							<textarea id="justificativaChamada" name="txtJustificativa" class="form-control"></textarea>
						</div>
						<input type="hidden" name="idPresencaJutificativa" id="idPresencaJutificativa"/>
						<input type="hidden" id="tipoChamada" name="tipoChamada"/>
					</div>
					<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Salvar</button>
					<button type="button" class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
				</div>
				</form>
			</div>
		</div>
	</div>
</div>

