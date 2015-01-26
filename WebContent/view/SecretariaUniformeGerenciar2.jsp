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
						Gerenciamento de Empr�stimos de Uniforme ao Atleta
						</h3>
						<p class="text-center">Incluir empr�stimo/devolu��o</p>
						<hr/>
						<form class="form-horizontal">
						
							<div class="form-group ">
								<label for="numero" class="col-sm-2 control-label text-left" style="padding-right:0px;">Data</label>
								<div class="col-sm-3">
									<input type="date" class="form-control" id="data" />
								</div>
							</div>
							
							<div class="form-group col-md-8">    
					        	<label for="message-text" class="control-label" style="padding-right:15px;">Tipo de Opera��o</label>
								<label class="radio-inline">
									<input type="radio" name="optradio">Empr�stimo
								</label>
								<label class="radio-inline">
									<input type="radio" name="optradio">Devolu��o
								</label>
							</div>						
						
							<table class="table">
								<tr>
									<th width="80%">Tipo</th>
									<th width="10%">Tamanho</th>
									<th width="10%">Quantidade</th>
								</tr>
								<tr>
									<td>Blusinha</td>
									<td><input type="text" class="form-control text-center" value="M" id="tamanhoBlusinha"/></td>
									<td><input type="text" class="form-control text-center" value="0" id="qtdeBlusinha"/></td>
								</tr>
								<tr>
									<td>Camiseta</td>
									<td><input type="text" class="form-control text-center" value="M" id="tamanhoCamiseta"/></td>
									<td><input type="text" class="form-control text-center" value="0" id="qtdeCamiseta"/></td>
								</tr>
								<tr>
									<td>Saia</td>
									<td><input type="text" class="form-control text-center" value="M" id="tamanhoSaia"/></td>
									<td><input type="text" class="form-control text-center" value="0" id="qtdeSaia"/></td>
								</tr>
								<tr>
									<td>Bermuda</td>
									<td><input type="text" class="form-control text-center" value="M" id="tamanhoBermuda"/></td>
									<td><input type="text" class="form-control text-center" value="0" id="qtdeBermuda"/></td>
								</tr>
								<tr>
									<td>Jaqueta</td>
									<td><input type="text" class="form-control text-center" value="M" id="tamanhoJaqueta"/></td>
									<td><input type="text" class="form-control text-center" value="0" id="qtdeJaqueta"/></td>
								</tr>
								<tr>
									<td>Cal�a</td>
									<td><input type="text" class="form-control text-center" value="M" id="tamanhoCalca"/></td>
									<td><input type="text" class="form-control text-center" value="0" id="qtdeCalca"/></td>
								</tr>																
							</table>

							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10 text-right">
									 <button type="submit" class="btn btn-primary">Salvar</button>
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-2 column">
					</div>
				</div>
				<div class="row clearfix">
					<div class="col-md-2 column">
					</div>
					<div class="col-md-8 column">
						<p class="text-center">Hist�rico</p>
						<table class="table">
						<thead>
							<tr>
								<th>
									Tipo
								</th>
								<th>
									Tamanho
								</th>
								<th>
									Quantidade
								</th>
								<th>
									Data Empr�stimo
								</th>
								<th>
									Data Devolu��o
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									Blusinha
								</td>
								<td>
									M
								</td>
								<td>
									02
								</td>
								<td>
									12/05/2014
								</td>
								<td>
								</td>
							</tr>
												<tbody>
							<tr>
								<td>
									Saia
								</td>
								<td>
									G
								</td>
								<td>
									01
								</td>
								<td>
									12/05/2014
								</td>
								<td>
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
	</div>
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>