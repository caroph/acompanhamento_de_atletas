	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@include file='/layout/head.jsp'%>
	
	<body>
	
	<%@include file='/layout/header.jsp'%>
	
	<div id="main" class="container-fluid">
		<div class="row">
			<%@include file='/layout/navigationTecnico.jsp'%>
			<!--Start Content-->
			<div id="content" class="col-xs-12 col-sm-10">
				<div id="ajax-content">
					<%@include file="Mensagem.jsp"%>
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<div class="box-name">
										<i class="fa  fa-plus-circle"></i>
										<span>Torneio</span>
									</div>
									<div class="box-icons">
										<a class="expand-link">
											<i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<form class="form-horizontal" role="form" action="TecnicoController?action=novoTorneio" method="post">
										<input type="hidden" name="idAtleta" value="${torneio.idTorneio}"/>
										<div class="form-group">
											 <div class="form-group col-md-6">
												 <label for="nome">Nome:</label>
												 <input type="text" class="form-control" id="nome" name="nome" value="${torneio.nome}" maxlength="100" required/>
											 </div>
										 	<div class="form-group col-md-6">
												<label>Local:</label>
												<input type="text" class="form-control" id="local" name="local" value="${torneio.local}" maxlength="100"/>
										 	</div>
										</div>
										<div class="form-group">
											<div class="col-sm-4">
												<label for="estado">Estado:</label>
												<select class="form-control" name="estado" id="estado" name="estado" value="${torneio.estado}" required></select>
											</div>
											<div class="col-sm-8">
												<label for="cidade">Cidade:</label>
												<select class="form-control" name="cidade" id="cidade" name="cidade" value="${torneio.cidade}" required></select>
											</div>
										</div>
										<div class="form-group">
											 <div class="form-group col-md-6">
												 <label for="dtInicial">Data Inicial:</label>
												 <fmt:formatDate value="${torneio.dtInicial}" pattern="yyyy-MM-dd" var="dtInicial" />
												 <input type="date" class="form-control" id="dtInicial" name="dtInicial" value="${dtInicial}" required/>
											 </div>
											 <div class="form-group col-md-6">
												<label for="dtFinal">Data Final:</label>
												<fmt:formatDate value="${torneio.dtFinal}" pattern="yyyy-MM-dd" var="dtFinal" />
												<input type="date" class="form-control" id="dtFinal" name="dtFinal" value="${dtFinal}" required/>
											</div>
										</div>
										<div class="form-group">
											<div class="form-group col-md-6">
												 <label for="naipe">Naipe:</label>
												 <select class="form-control" id="naipe" name="naipe" required>
													<option value="">Selecione</option>
													<c:forEach var="naipe" items="${listaNaipe}">
							                            <c:if test="${naipe.valor == torneio.idNaipe}">
			                                                <option selected value="<c:out value='${naipe.valor}'/>"><c:out value="${naipe.nome}" /></option>
			                                            </c:if>
			                                            <c:if test="${naipe.valor != torneio.idNaipe}">
															<option value="<c:out value='${naipe.valor}'/>"><c:out value="${naipe.nome}" /></option>
														</c:if>
						                            </c:forEach>
												 </select>
											 </div>
											<div class="form-group col-md-6">
											 	<label for="categoria">Categoria:</label>
											 	<select class="form-control" id="categoria" name="categoria" required>
													<option value="">Selecione</option>
													<c:forEach var="categoria" items="${listaCategoria}">
							                            <c:if test="${categoria.valor == torneio.idCatTorneio}">
			                                                <option selected value="<c:out value='${categoria.valor}'/>"><c:out value="${categoria.nome}" /></option>
			                                            </c:if>
			                                            <c:if test="${categoria.valor != torneio.idCatTorneio}">
															<option value="<c:out value='${categoria.valor}'/>"><c:out value="${categoria.nome}" /></option>
														</c:if>
						                            </c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group">
											<div class="form-group col-md-6">
												 <label for="tipo">Tipo:</label>
												 <select class="form-control" id="tipo" name="tipo" required>
													<option value="">Selecione</option>
													<c:forEach var="tipo" items="${listaTipo}">
							                            <c:if test="${tipo.valor == torneio.idTpTorneio}">
			                                                <option selected value="<c:out value='${tipo.valor}'/>"><c:out value="${tipo.nome}" /></option>
			                                            </c:if>
			                                            <c:if test="${tipo.valor != torneio.idTpTorneio}">
															<option value="<c:out value='${tipo.valor}'/>"><c:out value="${tipo.nome}" /></option>
														</c:if>
						                            </c:forEach>
												 </select>
											 </div>
											<div class="form-group col-md-6">
											 	<label for="grupo">Grupo:</label>
											 	<select class="form-control" id="grupo" name="grupo" required>
													<option value="">Selecione</option>
													<c:forEach var="grupo" items="${listaGrupo}">
							                            <c:if test="${grupo.valor == torneio.idGpTorneio}">
			                                                <option selected value="<c:out value='${grupo.valor}'/>"><c:out value="${grupo.nome}" /></option>
			                                            </c:if>
			                                            <c:if test="${grupo.valor != torneio.idGpTorneio}">
															<option value="<c:out value='${grupo.valor}'/>"><c:out value="${grupo.nome}" /></option>
														</c:if>
						                            </c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group">
											<div class="form-group col-md-12">
												 <label>Descrição:</label>
												 <input type="text" class="form-control" id="descricao" name="descricao" value="${torneio.descricao}"/>
											</div>
										</div>
										<div class="form-group">
											<div class="form-group col-md-12">
												 <label for="atletasPart">Atletas participantes: <small>[Disponíveis | Selecionados]</small></label>
												 <br/><small>(Apenas atletas que possuem cadastro CBT e FBT)</small>
												 <div>
													<select multiple="multiple" id="atletasPart" name="atletasPart">
														<c:forEach var="atleta" items="${listaAtletasPart}">
															<c:if test="${atleta.selecionado == false}">
							                            		<option value="<c:out value='${atleta.idPessoa}'/>"><c:out value="${atleta.nome} (${atleta.getNomeEquipe()})" /></option>
							                            	</c:if>
							                            	<c:if test="${atleta.selecionado == true}">
							                            		<option selected value="<c:out value='${atleta.idPessoa}'/>"><c:out value="${atleta.nome} (${atleta.getNomeEquipe()})" /></option>
							                            	</c:if>
							                            </c:forEach>
													</select>
												 </div>
											 </div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10 text-right">
												<a href="SecretariaController" class="btn btn-danger" data-confirm="Deseja realmente cancelar esse cadastro?">Cancelar</a>
												<button type="reset" class="btn btn-info" onclick="LimparCampos()">Limpar</button>
												<button type="submit" class="btn btn-primary" >Salvar</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>		
				</div>
			</div>
			<!--End Content-->
		</div>
	</div>
	
	<%@include file="/layout/footer.jsp"%>
	
  </body>
</html>

