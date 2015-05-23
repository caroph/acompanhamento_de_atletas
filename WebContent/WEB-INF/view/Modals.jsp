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
						<input type="hidden" id="dtChamada" name="dtChamada"/>
						<input type="hidden" id="idDiaTreino" name="idDiaTreino"/>
						<input type="hidden" id="idAtletaModal" name="idAtleta"/>
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

<!-- Incluir Observação -->
<div class="modal fade bs-example-modal-sm" id="incluirObservacao" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
	    <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
			<h4 class="modal-title" id="myModalLabel">Incluir Observação</h4>
		</div>
    	<div class="modal-body">
	        <form action="Controller?action=salvarObservacao" method="POST">
	        	<div class="form-group">
	        		<label for="message-text" class="control-label">Data de Validade:</label>
	        		<label class="radio-inline">
	        			<input type="date" required class="form-control" name="dtValidade" id="dtValidade"/>
        			</label>	        		
	        	</div>
	        	<div>    
		        	<label for="message-text" class="control-label" style="padding-right:15px;">Gravidade da situação:</label>
					<label><input type="radio" value="1" name="optGravidade"><span style="padding: 0 10px 0 5px;">Baixa</span></label>
					<label><input type="radio" value="2" name="optGravidade"><span style="padding: 0 10px 0 5px;">Moderada</span></label>
					<label><input type="radio" value="3" name="optGravidade"><span style="padding: 0 10px 0 5px;">Alta</span></label>
				</div>
	        	<div class="form-group">    
		        	<label for="message-text" class="control-label" style="padding-right:15px;">Compartilhar com:</label>
					<label><input type="radio" value="1" name="optCompartilhar"><span style="padding: 0 10px 0 5px;">Técnico</span></label>
					<label><input type="radio" value="2" name="optCompartilhar"><span style="padding: 0 10px 0 5px;">Todos</span></label>
				</div>
		        <div class="form-group">
			        <label for="message-text" class="control-label">Observação:</label>
			        <textarea class="form-control" required style="max-width: 568px; height: 325px;" name="observacao" id="message-text"></textarea>
				</div>   
				<input type="hidden" name="idAtleta" id="idAtletaObs" />
				<input type="hidden" name="idObservacao" id="idObservacaoModal" />
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Salvar</button>
					<button type="button" class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
				</div>
	        </form>
	    </div>
	  </div>
	</div>
</div>

<!-- Visualizar Observação -->
<div class="modal fade bs-example-modal-sm" id="visualizarObservacao" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
	    <div class="modal-header">
			<h4 class="modal-title" id="myModalLabel">Observação</h4>
		</div>
    	<div class="modal-body" id="conteudoModalObs">
	    </div>
	    <div class="modal-footer">
			<a type="button" class="btn" id="fecharModalObservacao" aria-hidden="true">Fechar</a>
		</div>
	  </div>
	</div>
</div>

<!-- Bonificação-->
<div class="modal fade bs-example-modal-sm" id="bonificacaoModal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
	    <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
			<h4 class="modal-title">Bonificação</h4>
		</div>
    	<div class="modal-body">
    	<form action="TecnicoController?action=salvarBonificacaoAtleta" method="POST">
    		<div class="form-group">
        		<label>
        			<input type="checkbox" name="torneios" id="torneios"><span style="padding: 0 10px 0 5px;">Torneios</span></input>
       			</label>
        		<label>
        			<input type="checkbox" name="treinos" id="treinos"><span style="padding: 0 10px 0 5px;">Treinos</span></input>
				</label>
        		<label>
        			<input type="checkbox" name="avaliacoes" id="avaliacoes"><span style="padding: 0 10px 0 5px;">Avaliações</span></input>
       			</label>	        		
        	</div>
    		<div class="form-group">
    			<label for="rankCBT" class="control-label">Rank CBT:</label>
        		<label>
        			<input type="number" class="form-control" name="rankCBT" id="rankCBT"/>
       			</label>	
    		</div>
    		<div class="form-group">
    			<label for="rankFPT" class="control-label">Rank FPT:</label>
        		<label>
        			<input type="number" class="form-control" name="rankFPT" id="rankFPT"/>
       			</label>	
    		</div>
    		<div class="form-group">
    			<label for="rankITF" class="control-label">Rank ITF:</label>
        		<label>
        			<input type="number" class="form-control" name="rankITF" id="rankITF"/>
       			</label>	
    		</div>
    		<div class="form-group">
    			<label for="observacoes" class="control-label">Observações:</label>
		        <textarea class="form-control" required style="max-width: 568px; max-height: 325px;" name="observacoes" id="observacoes"></textarea>	
    		</div>
    		<div class="form-group">
    			<label for="optBonificado" class="control-label" style="padding-right:15px;">Atleta bonificado:</label>
				<label><input type="radio" value="1" name="optBonificado"><span style="padding: 0 10px 0 5px;">Sim</span></label>
				<label><input type="radio" value="2" name="optBonificado"><span style="padding: 0 10px 0 5px;">Não</span></label>	
    		</div>
    		<input type="hidden" id="mesBonificacao" name="mesBonificacao"/>
    		<input type="hidden" id="anoBonificacao" name="anoBonificacao"/>
    		<input type="hidden" id="idAtletaBonificacao" name="idAtleta"/>
    		<input type="hidden" id="idAvaliacaoBonificacao" name="idAvaliacaoDesempenho"/>
    		<div class="modal-footer">
    			<button type="submit" class="btn btn-primary">Salvar</button>
				<button type="button" class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
			</div>
    	</form>
	    </div>
	    
	  </div>
	</div>
</div>

<!-- Visualizar Observação -->
<div class="modal fade bs-example-modal-sm" id="visualizarBonificacao" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
	    <div class="modal-header">
	    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
			<h4 class="modal-title" id="tituloModalBonificacao"></h4>
		</div>
    	<div class="modal-body" id="conteudoModalBonificacao">
	    </div>
	    <div class="modal-footer">
			<a type="button" class="btn" data-dismiss="modal" aria-hidden="true">Fechar</a>
		</div>
	  </div>
	</div>
</div>

