<!-- NOVAS -->
<!-- Modal Vincular Respons�vel -->
<div class="modal fade" id="vincularResponsavel" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
			<h4 class="modal-title" id="myModalLabel">Vincular Respons�vel</h4>
			</div>
			<div class="vincular-body" style="margin-left: 20px;">
				<form method="POST" action="SecretariaController?action=vincularResponsavel">
					<p></p>					
					<div class="modal-footer">
						<a class="btn btn-info" href="SecretariaController?action=jspNovoResponsavel">Novo Respons�vel</a>
						<button type="submit" class="btn btn-primary">Vincular</button>
						<button type="button" class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
					</div>
				</form>
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
			<form method="POST" action="Controller?action=RegistrarPresenca">
				<label id="lblNomeAtleta" style="padding-bottom: 16px;" class="control-label" ></label>
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
					<div class="col-sm-6">
						<label for="dtAtendimento" class=" control-label">Data:</label>
						<input type="date" class="form-control" id="dtAtendimento" name="dtAtendimento" required/>
					</div>
					<div class="col-sm-6">
						<label for="hrAtendimento" class=" control-label">Hora:</label>
						<input type="time" class="form-control" id="hrAtendimento" name="hrAtendimento" required/>
					</div>
				<div class="col-md-12">
					<label class=" control-label">Anota��es:</label>
					<textarea class="form-control" id="anotacao" name="anotacao" required></textarea>
				</div>
				<div class="modal-footer">
<!-- 					<button type="button" class="btn btn-info">Incluir Observa��o</button> -->
					<button type="submit" class="btn btn-primary">Salvar</button>
					<button type="button" class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
				</div>
			</form>
		</div>
    </div>
  </div>
</div>


<!-- ---------------------ANTIGAS! ANTIGAS! ANTIGAS! ANTIGAS! ANTIGAS! ------------------ -->

<!-- <!-- Modal Imprimir --> -->
<!-- <div class="modal fade" id="imprimir" tabindex="-1" role="dialog" -->
<!-- 			aria-labelledby="basicModal" aria-hidden="true"> -->
<!-- 			<div class="modal-dialog"> -->
<!-- 				<div class="modal-content"> -->
<!-- 					<div class="modal-header"> -->
<!-- 						<button type="button" class="close" data-dismiss="modal" -->
<!-- 							id="fechar" aria-hidden="true">x</button> -->
<!-- 						<h4 class="modal-title" id="myModalLabel">Imprimindo -->
<!-- 							Relat�rio</h4> -->
<!-- 					</div> -->
<!-- 					<div class="modal-body"> -->
<!-- 						<div class="text-center">Imprimindo</div> -->
<!-- 						<div class="progress" style="margin-top: 10px;" id="progress"> -->
<!-- 							<div class="progress-bar progress-bar-striped active" -->
<!-- 								role="progressbar" aria-valuenow="100" aria-valuemin="0" -->
<!-- 								aria-valuemax="100" style="width: 99%">99%</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="modal-footer"> -->
<!-- 						<button type="button" class="btn btn-primary" data-dismiss="modal" -->
<!-- 							id="fechar">Fechar</button> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
		
<!-- <!-- Modal Resultado Torneio--> -->
<!-- <div class="modal fade" id="resultadoRegistrar" tabindex="-1" role="dialog" -->
<!-- 			aria-labelledby="basicModal" aria-hidden="true"> -->
<!-- 			<div class="modal-dialog"> -->
<!-- 				<div class="modal-content"> -->
<!-- 					<div class="modal-header"> -->
<!-- 						<button type="button" class="close" data-dismiss="modal" -->
<!-- 							id="fechar" aria-hidden="true">x</button> -->
<!-- 						<h4 class="modal-title" id="myModalLabel">Resultados</h4> -->
<!-- 					</div> -->
<!-- 					<div class="modal-body"> -->
<!-- 						Atleta 1 - Posi��o 2�<br/> -->
<!-- 						Atleta 2 - Posi��o 6�<br/> -->
<!-- 						Atleta 3 - Posi��o 1�<br/> -->
<!-- 					</div> -->
<!-- 					<div class="modal-footer"> -->
<!-- 						<button type="button" class="btn btn-primary" data-dismiss="modal">Fechar</button> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->

<!-- <!-- 	Modal Editar --> -->
<!-- 	<div class="modal fade bs-example-modal-xs" id="editar" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true"> -->
<!-- 	  <div class="modal-dialog"> -->
<!-- 	    <div class="modal-content"> -->
<!-- 	    	<div class="modal-header"> -->
<!-- 				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button> -->
<!-- 				<br/> -->
<!-- 			</div> -->
<!-- 			<div class="modal-body"> -->
<!-- 				<label for="message-text" class="control-label" >Atividade alterada com sucesso!</label> -->
<!-- 			</div> -->
<!-- 	    </div> -->
<!-- 	  </div> -->
<!-- 	</div> -->
	
<!-- 	<!-- Detalhes Card�pio--> -->
<!-- 	<div class="modal fade" id="detalhesCardapio" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true"> -->
<!-- 			<div class="modal-dialog"> -->
<!-- 				<div class="modal-content"> -->
<!-- 					<div class="modal-header"> -->
<!-- 					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button> -->
<!-- 					<h4 class="modal-title" id="myModalLabel">Detalhes Card�pio</h4> -->
<!-- 					</div> -->
<!-- 					<div class="modal-body"> -->
<!-- 						Nome: Card�pio X<br/> -->
<!-- 						Caf� da Manh�: xxx<br/> -->
<!-- 						Lanche I: xxx<br/> -->
<!-- 						Almo�o: xxx<br/> -->
<!-- 						Lanche II: XXXX<br/> -->
<!-- 						Janta: XXXX<br/> -->
<!-- 					</div> -->
<!-- 					<div class="modal-footer"> -->
<!-- 						<button type="button" class="btn btn-primary" data-dismiss="modal" id="fechar">Fechar</button> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div>	 -->
	
<!-- 		<!-- Incluir Observa��o --> -->
<!-- 	<div class="modal fade bs-example-modal-sm" id="incluirParecer" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true"> -->
<!-- 	  <div class="modal-dialog"> -->
<!-- 	    <div class="modal-content"> -->
<!-- 		    <div class="modal-header"> -->
<!-- 				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button> -->
<!-- 				<h4 class="modal-title" id="myModalLabel">Incluir Observa��o</h4> -->
<!-- 			</div> -->
<!-- 	    	<div class="modal-body"> -->
<!-- 		        <form action=""> -->
<!-- 		        	<div class="form-group"> -->
<!-- 		        		<label for="message-text" class="control-label">Dura��o:</label> -->
<!-- 		        		<label class="radio-inline"> -->
<!-- 		        			<input type="number" class="form-control"/> -->
<!-- 	        			</label>	        		 -->
<!-- 		        	</div> -->
<!-- 		        	<div class="form-group">     -->
<!-- 				        	<label for="message-text" class="control-label" style="padding-right:15px;">Gravidade da situa��o:</label> -->
<!-- 							<label class="radio-inline"> -->
<!-- 								<input type="radio" name="optradio">Baixa -->
<!-- 							</label> -->
<!-- 							<label class="radio-inline"> -->
<!-- 								<input type="radio" name="optradio">Moderada -->
<!-- 							</label> -->
<!-- 							<label class="radio-inline"> -->
<!-- 								<input type="radio" name="optradio">Alta -->
<!-- 							</label> -->
<!-- 					</div> -->
<!-- 		        	<div class="form-group">     -->
<!-- 				        	<label for="message-text" class="control-label" style="padding-right:15px;">Compartilhar com:</label> -->
<!-- 							<label class="radio-inline"> -->
<!-- 								<input type="radio" name="optradio">T�cnico -->
<!-- 							</label> -->
<!-- 							<label class="radio-inline"> -->
<!-- 								<input type="radio" name="optradio">Todos  -->
<!-- 							</label> -->
<!-- 					</div> -->
<!-- 			        <div class="form-group"> -->
<!-- 					        <label for="message-text" class="control-label">Observa��o:</label> -->
<!-- 					        <textarea class="form-control" style="max-width: 568px; height: 325px;" id="message-text"></textarea> -->
<!-- 					</div>    -->
<!-- 					<div class="modal-footer"> -->
<!-- 						<button type="submit" class="btn btn-primary">Incluir</button> -->
<!-- 						<button type="button" class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button> -->
<!-- 					</div> -->
<!-- 		        </form> -->
<!-- 		    </div> -->
<!-- 		  </div> -->
<!-- 		</div> -->
<!-- 	</div> -->
	
<!-- 		<!-- Selecionar Card�pio --> -->
<!-- 	<div class="modal fade" id="selecionarCard�pio" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true"> -->
<!-- 		<div class="modal-dialog"> -->
<!-- 			<div class="modal-content"> -->
<!-- 				<div class="modal-header"> -->
<!-- 				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button> -->
<!-- 				<h4 class="modal-title" id="myModalLabel">Selecionar Card�pio</h4> -->
<!-- 				</div> -->
<!-- 				<div class="modal-body"> -->
<!-- 					<div class="radio"> -->
<!-- 						<label><input type="radio" name="optradio"/> Card�pio 1</label> -->
<!-- 					</div> -->
<!-- 					<div class="radio"> -->
<!-- 						<label><input type="radio" name="optradio"/> Card�pio 2</label> -->
<!-- 					</div> -->
<!-- 					<div class="radio"> -->
<!-- 						<label><input type="radio" name="optradio"/> Card�pio 3</label> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="modal-footer"> -->
<!-- 					<a class="btn btn-primary" href="NutricionistaNovoCardapio.jsp">Card�pio Personalizado</a> -->
<!-- 					<button type="button" class="btn btn-primary" data-dismiss="modal">Selecionar</button> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div>	 -->