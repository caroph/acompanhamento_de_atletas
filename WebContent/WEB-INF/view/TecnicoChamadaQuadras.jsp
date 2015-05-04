
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
										<i class="fa fa-calendar"></i> <span>Chamada</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<form role="form" class="form-horizontal" 
									action="TecnicoController?action=SalvarChamadaQuadra" method="post">
										<div class="col-md-4 form-group">
											<div class="col-md-4">
												<label for="dataQuadra" class="control-label">Data:</label>
											</div>
											<div class="col-md-8">
												<fmt:formatDate value="${dataAtual}" pattern="yyyy-MM-dd"
													var="dataAtual" />
												<input type="date" class="form-control" required onchange="BuscarChamada()"
													name="dataQuadra" value="<c:out value="${dataAtual}"/>" id="dataQuadra"/>
											</div>
										</div>
										<div class="col-md-8 form-group">
											<div class="col-md-4">
												<label for="diaTreino" class="control-label">Dia de treino:</label>
											</div>
											<div class="col-md-8">
												<select name="diaTreino" class="form-control" onchange="BuscarChamada()" 
													required>
													<option value="0" selected>Selecione</option>
													<c:forEach var="diaTreino" items="${listaDiasTreinos}">
														<fmt:formatDate value="${diaTreino.hrInicio}" pattern="HH:mm"
	 															var="horaIFormatada" />
 														<fmt:formatDate value="${diaTreino.hrFim}" pattern="HH:mm"
 															var="horaFFormatada" />
														<c:if test="${diaTreino.selecionado == true}">
															<option selected value="${diaTreino.idDiaTreino}">
																<c:out value="${diaTreino.getNomeEquipe()} - ${diaTreino.getNomeDiaSemana()}
																	 - ${horaIFormatada} - ${horaFFormatada}"></c:out>
															</option>
														</c:if>
														<c:if test="${diaTreino.selecionado == false}">
															<option value="${diaTreino.idDiaTreino}">
																<c:out value="${diaTreino.getNomeEquipe()} - ${diaTreino.getNomeDiaSemana()}
																	 - ${horaIFormatada} - ${horaFFormatada}"></c:out>
															</option>
														</c:if>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 1</h3>
												</div>
												<div class="panel-body">
													<c:forEach var="presenca" items="${listaPresencaChamada1}" varStatus="loop">
														<input type="text" class="form-control atletasComplete"
															<c:set var="idQuadra" value="quadra-1-${loop.index + 1}"/>
															id="${idQuadra}" value="${presenca.atleta.nome}"/>
															<input type="hidden" value="${presenca.idAtleta}"
																id="item-1-${loop.index + 1}"/>
													</c:forEach>
													<c:forEach begin="${listaPresencaChamada1.size() + 1}" var="index" 
														end="5">
														<c:set var="idQuadra" value="quadra-1-${index}"/>
														<input type="text" class="form-control atletasComplete"
														id="${idQuadra}" />
													</c:forEach>
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 2</h3>
												</div>
												<div class="panel-body">
													<c:forEach var="presenca" items="${listaPresencaChamada2}" varStatus="loop">
														<input type="text" class="form-control atletasComplete"
															<c:set var="idQuadra" value="quadra-2-${loop.index + 1}"/>
															id="${idQuadra}" value="${presenca.atleta.nome}"/>
														<input type="hidden" value="${presenca.idAtleta}"
															id="item-2-${loop.index + 1}"/>
													</c:forEach>
													<c:forEach begin="${listaPresencaChamada2.size() + 1}" var="index" 
														end="5">
														<c:set var="idQuadra" value="quadra-2-${index}"/>
														<input type="text" class="form-control atletasComplete"
														id="${idQuadra}" />
													</c:forEach>
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 3</h3>
												</div>
												<div class="panel-body">
													<c:forEach var="presenca" items="${listaPresencaChamada3}" varStatus="loop">
														<input type="text" class="form-control atletasComplete"
															<c:set var="idQuadra" value="quadra-3-${loop.index + 1}"/>
															id="${idQuadra}" value="${presenca.atleta.nome}"/>
														<input type="hidden" value="${presenca.idAtleta}"
															id="item-3-${loop.index + 1}"/>
													</c:forEach>
													<c:forEach begin="${listaPresencaChamada3.size() + 1}" var="index" 
														end="5">
														<c:set var="idQuadra" value="quadra-3-${index}"/>
														<input type="text" class="form-control atletasComplete"
														id="${idQuadra}" />
													</c:forEach>
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 4</h3>
												</div>
												<div class="panel-body">
													<c:forEach var="presenca" items="${listaPresencaChamada4}" varStatus="loop">
														<input type="text" class="form-control atletasComplete"
															<c:set var="idQuadra" value="quadra-4-${loop.index + 1}"/>
															id="${idQuadra}" value="${presenca.atleta.nome}"/>
														<input type="hidden" value="${presenca.idAtleta}"
															id="item-4-${loop.index + 1}"/>
													</c:forEach>
													<c:forEach begin="${listaPresencaChamada4.size() + 1}" var="index" 
														end="5">
														<c:set var="idQuadra" value="quadra-4-${index}"/>
														<input type="text" class="form-control atletasComplete"
														id="${idQuadra}" />
													</c:forEach>
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 5</h3>
												</div>
												<div class="panel-body">
													<c:forEach var="presenca" items="${listaPresencaChamada5}" varStatus="loop">
														<input type="text" class="form-control atletasComplete"
															<c:set var="idQuadra" value="quadra-5-${loop.index + 1}"/>
															id="${idQuadra}" value="${presenca.atleta.nome}"/>
														<input type="hidden" value="${presenca.idAtleta}"
															id="item-5-${loop.index + 1}"/>
													</c:forEach>
													<c:forEach begin="${listaPresencaChamada5.size() + 1}" var="index" 
														end="5">
														<c:set var="idQuadra" value="quadra-5-${index}"/>
														<input type="text" class="form-control atletasComplete"
														id="${idQuadra}" />
													</c:forEach>
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 6</h3>
												</div>
												<div class="panel-body">
													<c:forEach var="presenca" items="${listaPresencaChamada6}" varStatus="loop">
														<input type="text" class="form-control atletasComplete"
															<c:set var="idQuadra" value="quadra-6-${loop.index + 1}"/>
															id="${idQuadra}" value="${presenca.atleta.nome}"/>
														<input type="hidden" value="${presenca.idAtleta}"
															id="item-6-${loop.index + 1}"/>
													</c:forEach>
													<c:forEach begin="${listaPresencaChamada6.size() + 1}" var="index" 
														end="5">
														<c:set var="idQuadra" value="quadra-6-${index}"/>
														<input type="text" class="form-control atletasComplete"
														id="${idQuadra}" />
													</c:forEach>
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 7</h3>
												</div>
												<div class="panel-body">
													<c:forEach var="presenca" items="${listaPresencaChamada7}" varStatus="loop">
														<input type="text" class="form-control atletasComplete"
															<c:set var="idQuadra" value="quadra-7-${loop.index + 1}"/>
															id="${idQuadra}" value="${presenca.atleta.nome}"/>
														<input type="hidden" value="${presenca.idAtleta}"
															id="item-7-${loop.index + 1}"/>
													</c:forEach>
													<c:forEach begin="${listaPresencaChamada7.size() + 1}" var="index" 
														end="5">
														<c:set var="idQuadra" value="quadra-7-${index}"/>
														<input type="text" class="form-control atletasComplete"
														id="${idQuadra}" />
													</c:forEach>
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 8</h3>
												</div>
												<div class="panel-body">
													<c:forEach var="presenca" items="${listaPresencaChamada8}" varStatus="loop">
														<input type="text" class="form-control atletasComplete"
															<c:set var="idQuadra" value="quadra-8-${loop.index + 1}"/>
															id="${idQuadra}" value="${presenca.atleta.nome}"/>
														<input type="hidden" value="${presenca.idAtleta}"
															id="item-8-${loop.index + 1}"/>
													</c:forEach>
													<c:forEach begin="${listaPresencaChamada8.size() + 1}" var="index" 
														end="5">
														<c:set var="idQuadra" value="quadra-8-${index}"/>
														<input type="text" class="form-control atletasComplete"
														id="${idQuadra}" />
													</c:forEach>
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 9</h3>
												</div>
												<div class="panel-body">
													<c:forEach var="presenca" items="${listaPresencaChamada9}" varStatus="loop">
														<input type="text" class="form-control atletasComplete"
															<c:set var="idQuadra" value="quadra-9-${loop.index + 1}"/>
															id="${idQuadra}" value="${presenca.atleta.nome}"/>
														<input type="hidden" value="${presenca.idAtleta}"
															id="item-9-${loop.index + 1}"/>
													</c:forEach>
													<c:forEach begin="${listaPresencaChamada9.size() + 1}" var="index" 
														end="5">
														<c:set var="idQuadra" value="quadra-9-${index}"/>
														<input type="text" class="form-control atletasComplete"
														id="${idQuadra}" />
													</c:forEach>
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 10</h3>
												</div>
												<div class="panel-body">
													<c:forEach var="presenca" items="${listaPresencaChamada10}" varStatus="loop">
														<input type="text" class="form-control atletasComplete"
															<c:set var="idQuadra" value="quadra-10-${loop.index + 1}"/>
															id="${idQuadra}" value="${presenca.atleta.nome}"/>
														<input type="hidden" value="${presenca.idAtleta}"
															id="item-10-${loop.index + 1}"/>
													</c:forEach>
													<c:forEach begin="${listaPresencaChamada10.size() + 1}" var="index" 
														end="5">
														<c:set var="idQuadra" value="quadra-10-${index}"/>
														<input type="text" class="form-control atletasComplete"
														id="${idQuadra}" />
													</c:forEach>
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 11</h3>
												</div>
												<div class="panel-body">
													<c:forEach var="presenca" items="${listaPresencaChamada11}" varStatus="loop">
														<input type="text" class="form-control atletasComplete"
															<c:set var="idQuadra" value="quadra-11-${loop.index + 1}"/>
															id="${idQuadra}" value="${presenca.atleta.nome}"/>
														<input type="hidden" value="${presenca.idAtleta}"
															id="item-11-${loop.index + 1}"/>
													</c:forEach>
													<c:forEach begin="${listaPresencaChamada11.size() + 1}" var="index" 
														end="5">
														<c:set var="idQuadra" value="quadra-11-${index}"/>
														<input type="text" class="form-control atletasComplete"
														id="${idQuadra}" />
													</c:forEach>
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 12</h3>
												</div>
												<div class="panel-body">
													<c:forEach var="presenca" items="${listaPresencaChamada12}" varStatus="loop">
														<input type="text" class="form-control atletasComplete"
															<c:set var="idQuadra" value="quadra-12-${loop.index + 1}"/>
															id="${idQuadra}" value="${presenca.atleta.nome}"/>
														<input type="hidden" value="${presenca.idAtleta}"
															id="item-12-${loop.index + 1}"/>
													</c:forEach>
													<c:forEach begin="${listaPresencaChamada12.size() + 1}" var="index" 
														end="5">
														<c:set var="idQuadra" value="quadra-12-${index}"/>
														<input type="text" class="form-control atletasComplete"
														id="${idQuadra}" />
													</c:forEach>
												</div>
											</div>
										</div>
										<input type="hidden" name="atletasQuadras" id="atletasQuadras"/>
										<div class="form-group col-md-12">
											<div class="col-sm-12 text-right">
												<a type="button" class="btn btn-info"
													href="TecnicoChamada.jsp">Visualizar Chamada</a>
												<button type="submit" class="btn btn-primary">Salvar</button>
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
	<%@include file="Modals.jsp"%>

	<script type="text/javascript">
		var atletas = []; 
		$(".atletasComplete").change(function(){
			if(this.val == null){
				var id = this.id;
				atletas = jQuery.grep(atletas, function( n, i ) {
					  return ( n.idQuadra != id );
				});
				$("#atletasQuadras").val(JSON.stringify(atletas));
			}
		});
		for(i=1; i<=12; i++){
			for(j=1; j<=5; j++){
				if($("#item-"+i+"-"+j).length > 0){
					var valor = $("#item-"+i+"-"+j)[0].value;
					if(valor != "")
						atletas.push({idQuadra: "quadra-" + i + "-" + j, idAtleta: valor});
				}
			}
		}
		$(function() {
			$(".atletasComplete").autocomplete({
				source : function(request, response) {
					$.ajax({
						dataType : "json",
						data : {
							acbusca : request.term
						},
						type : 'GET',
						url : 'TecnicoController?action=CarregarAtletasAutoComplete',
						success : function(data) {
							response($.map(data, function(el) {
								return {
									label : el.nome,
									value : el.nome,
									id : el.idPessoa
								};
							}));
						}
					});
				},
				select : function(event, ui) {
					atletas = jQuery.grep(atletas, function( n, i ) {
						  return ( n.idQuadra != event.target.id );
					});
					atletas.push({idQuadra: event.target.id, idAtleta: ui.item.id});
					$("#atletasQuadras").val(JSON.stringify(atletas));
				}
			});
		});
	</script>
</body>
</html>