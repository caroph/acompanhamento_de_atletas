	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- menu -->
				<%@include file='../layout/navigationSecretaria.jsp'%>
				<div class="row clearfix">
					<div class="col-md-2 column"></div>
					<div class="col-md-8 column">
						<h3 class="text-center">
						Gerenciamento de Estoque
						</h3>
						<p class="text-center">Incluir ou dar baixa em peças estocadas</p>
						<hr/>
						<form class="form-horizontal">							
							<div class="form-group col-md-8">    
					        	<label for="message-text" class="control-label" style="padding-right:15px;">Tipo de Operação</label>
								<label class="radio-inline">
									<input type="radio" name="optradio">Inclusão
								</label>
								<label class="radio-inline">
									<input type="radio" name="optradio">Baixa
								</label>
							</div>						
						
							<table class="table">
								<tr>
									<th width="77%">Tipo</th>
									<th width="13%">Tamanho</th>
									<th width="10%">Quantidade</th>
								</tr>
								<tr>
									<td>Blusinha</td>
									<td><select class="form-control">
											<option>PP</option>
											<option>P</option>
											<option selected>M</option>
											<option>G</option>
											<option>GG</option>
									</select></td>
									<td><input type="number" class="form-control text-center"
										value="0" id="qtdeBlusinha" /></td>
								</tr>
								<tr>
									<td>Camiseta</td>
									<td><select class="form-control">
											<option>PP</option>
											<option>P</option>
											<option selected>M</option>
											<option>G</option>
											<option>GG</option>
									</select></td>
									<td><input type="number" class="form-control text-center"
										value="0" id="qtdeCamiseta" /></td>
								</tr>
								<tr>
									<td>Saia</td>
									<td><select class="form-control">
											<option>PP</option>
											<option>P</option>
											<option selected>M</option>
											<option>G</option>
											<option>GG</option>
									</select></td>
									<td><input type="number" class="form-control text-center"
										value="0" id="qtdeSaia" /></td>
								</tr>
								<tr>
									<td>Bermuda</td>
									<td><select class="form-control">
											<option>PP</option>
											<option>P</option>
											<option selected>M</option>
											<option>G</option>
											<option>GG</option>
									</select></td>
									<td><input type="number" class="form-control text-center"
										value="0" id="qtdeBermuda" /></td>
								</tr>
								<tr>
									<td>Jaqueta</td>
									<td><select class="form-control">
											<option>PP</option>
											<option>P</option>
											<option selected>M</option>
											<option>G</option>
											<option>GG</option>
									</select></td>
									<td><input type="number" class="form-control text-center"
										value="0" id="qtdeJaqueta" /></td>
								</tr>
								<tr>
									<td>Calça</td>
									<td><select class="form-control">
											<option>PP</option>
											<option>P</option>
											<option selected>M</option>
											<option>G</option>
											<option>GG</option>
									</select></td>
									<td><input type="number" class="form-control text-center"
										value="0" id="qtdeCalca" /></td>
								</tr>
							</table>
							
							<div class="form-group">
								<div class="col-sm-12 text-right">
									 <button type="submit" class="btn btn-primary">Salvar</button>
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-2 column">
					</div>
				</div>
				<div class="col-md-2 column">
				</div>
			</div>	
		</div>
		</div>	
	</div>
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>