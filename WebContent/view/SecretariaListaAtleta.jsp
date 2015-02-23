	<%@include file='../layout/head.jsp'%>
	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
			<!-- menu -->
				<%@include file='../layout/navigationSecretaria.jsp'%>
				
				<div class="row clearfix">
					<div class="col-md-3 column">
					</div>
					<div class="col-md-6 column">
						<h3 class="text-center">
							Buscar Atleta
						</h3>
						<form role="form" action="SecretariaListaAtleta.jsp">
						    <div class="input-group">
						      <input type="text" class="form-control form-search" id="search">
						      <span class="input-group-btn">
						        <button class="btn btn-default" type="submit">
						        	<i class="icon-large icon-search"></i></button>
						      </span>
						    </div>
						</form>
					</div>
					<div class="col-md-3 column">
					</div>
				</div>
				
				<div class="col-md-2 column">
				</div>
				<div class="col-md-8 column">
					<h3 class="text-center">
							Atletas Encontrados
					</h3>
					<table class="table">
					<thead>
						<tr>
							<th width="65%" align="center"> 
								Nome
							</th>
							<th width="5%"></th>
							<th width="10%"></th>
							<th width="10%"></th>
							<th width="5%"></th>
							<th width="5%"></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td align="center">
								Atleta 1
							</td>
							<td align="center">
								<a data-toggle="modal" href="#basicModal" class="btn btn-info btn-sm" role="button">Detalhes</a>
							</td>
							<td>
								<a href="SecretariaAnexosAtleta.jsp" class="btn btn-info btn-sm" role="button">Anexar Documentos</a>
							</td>
							<td align="center">
								<a href="SecretariaUniformeGerenciar.jsp" class="btn btn-info btn-sm" role="button">Gerenciar Uniformes</a>
							</td>
							<td align="center">
								<a href="SecretariaNovoAtleta.jsp" class="btn btn-info btn-sm" role="button">Editar</a>
							</td>
							<td align="center">
								<a data-toggle="modal" href="#deletar" class="btn btn-danger btn-sm" role="button">Deletar</a>
							</td>
						</tr>
						<tr>
							<td align="center">
								Atleta 2
							</td>
							<td align="center">
								<a data-toggle="modal" href="#basicModal" class="btn btn-info btn-sm" role="button">Detalhes</a>
							</td>
							<td>
								<a href="SecretariaAnexosAtleta.jsp" class="btn btn-info btn-sm" role="button">Anexar Documentos</a>
							</td>
							<td align="center">
								<a href="SecretariaUniformeGerenciar.jsp" class="btn btn-info btn-sm" role="button">Gerenciar Uniformes</a>
							</td>
							<td align="center">
								<a href="SecretariaNovoAtleta.jsp" class="btn btn-info btn-sm" role="button">Editar</a>
							</td>
							<td align="center">
								<a data-toggle="modal" href="#deletar" class="btn btn-danger btn-sm" role="button">Deletar</a>
							</td>
						</tr>
						<tr> 
							<td align="center">
								Atleta 3
							</td>
							<td align="center">
								<a data-toggle="modal" href="#basicModal" class="btn btn-info btn-sm" role="button">Detalhes</a>
							</td>
							<td>
								<a href="SecretariaAnexosAtleta.jsp" class="btn btn-info btn-sm" role="button">Anexar Documentos</a>
							</td>
							<td align="center">
								<a href="SecretariaUniformeGerenciar.jsp" class="btn btn-info btn-sm" role="button">Gerenciar Uniformes</a>
							</td>
							<td align="center">
								<a href="SecretariaNovoAtleta.jsp" class="btn btn-info btn-sm" role="button">Editar</a>
							</td>
							<td align="center">
								<a data-toggle="modal" href="#deletar" class="btn btn-danger btn-sm" role="button">Deletar</a>
							</td>
						</tr>
						<tr>
							<td align="center">
								Atleta 4
							</td>
							<td align="center">
								<a data-toggle="modal" href="#basicModal" class="btn btn-info btn-sm" role="button">Detalhes</a>
							</td>
							<td>
								<a href="SecretariaAnexosAtleta.jsp" class="btn btn-info btn-sm" role="button">Anexar Documentos</a>
							</td>
							<td align="center">
								<a href="SecretariaUniformeGerenciar.jsp" class="btn btn-info btn-sm" role="button">Gerenciar Uniformes</a>
							</td>
							<td align="center">
								<a href="SecretariaNovoAtleta.jsp" class="btn btn-info btn-sm" role="button">Editar</a>
							</td>
							<td align="center">
								<a data-toggle="modal" href="#deletar" class="btn btn-danger btn-sm" role="button">Deletar</a>
							</td>
						</tr>
						<tr>
							<td align="center">
								Atleta 5<br>
							</td>
							<td align="center">
								<a data-toggle="modal" href="#basicModal" class="btn btn-info btn-sm" role="button">Detalhes</a>
							</td>
							<td>
								<a href="SecretariaAnexosAtleta.jsp" class="btn btn-info btn-sm" role="button">Anexar Documentos</a>
							</td>
							<td align="center">
								<a href="SecretariaUniformeGerenciar.jsp" class="btn btn-info btn-sm" role="button">Gerenciar Uniformes</a>
							</td>
							<td align="center">
								<a href="SecretariaNovoAtleta.jsp" class="btn btn-info btn-sm" role="button">Editar</a>
							</td>
							<td align="center">
								<a data-toggle="modal" href="#deletar" class="btn btn-danger btn-sm" role="button">Deletar</a>
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
				<div class="col-md-2 column">
				</div>
			</div>
		</div>
	</div>	
	
	<div class="modal fade" id="basicModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
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
		
		<div class="modal fade" id="basicModal2" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
					<h4 class="modal-title" id="myModalLabel">Vincular Responsável</h4>
					</div>
					<div class="modal-body">
						<div class="radio">
							<label><input type="radio" name="optradio"/> Responsável 1</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="optradio"/> Responsável 2</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="optradio"/> Responsável 3</label>
						</div>
					</div>
					<div class="modal-footer">
						<a class="btn btn-primary" href="SecretariaNovoResponsavel.jsp">Novo Responsável</a>
						<button type="button" class="btn btn-primary">Vincular</button>
					</div>
				</div>
			</div>
		</div>
	
	<%@include file="Modals.jsp"%>
	
	<%@include file="../layout/footer.jsp"%>
	
  </body>
</html>