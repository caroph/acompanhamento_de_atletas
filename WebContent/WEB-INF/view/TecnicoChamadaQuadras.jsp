
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
												<input type="date" class="form-control" required
													name="dataQuadra" value="<c:out value="${dataAtual}"/>" id="dataQuadra"/>
											</div>
										</div>
										<div class="col-md-8 form-group">
											<div class="col-md-4">
												<label for="diaTreino" class="control-label">Dia de treino:</label>
											</div>
											<div class="col-md-8">
												<select name="diaTreino" class="form-control" required>
													<option selected>Selecione</option>
													<c:forEach var="diaTreino" items="${listaDiasTreinos}">
														<fmt:formatDate value="${diaTreino.hrInicio}" pattern="HH:mm"
	 															var="horaIFormatada" />
	 														<fmt:formatDate value="${diaTreino.hrFim}" pattern="HH:mm"
	 															var="horaFFormatada" />
														<option value="${diaTreino.idDiaTreino}">
														<c:out value="${diaTreino.getNomeEquipe()} - ${diaTreino.getNomeDiaSemana()}
															 - ${horaIFormatada} - ${horaFFormatada}"></c:out>
														</option>
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
													<input type="text" class="form-control atletasComplete"
														id="quadra11" /> <input type="text"
														class="form-control atletasComplete" id="quadra12" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra13" /> <input type="text"
														class="form-control atletasComplete" id="quadra14" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra15" />
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 2</h3>
												</div>
												<div class="panel-body">
													<input type="text" class="form-control atletasComplete"
														id="quadra21" /> <input type="text"
														class="form-control atletasComplete" id="quadra22" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra23" /> <input type="text"
														class="form-control atletasComplete" id="quadra24" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra25" />
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 3</h3>
												</div>
												<div class="panel-body">
													<input type="text" class="form-control atletasComplete"
														id="quadra31" /> <input type="text"
														class="form-control atletasComplete" id="quadra32" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra33" /> <input type="text"
														class="form-control atletasComplete" id="quadra34" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra35" />
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 4</h3>
												</div>
												<div class="panel-body">
													<input type="text" class="form-control atletasComplete"
														id="quadra41" /> <input type="text"
														class="form-control atletasComplete" id="quadra42" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra43" /> <input type="text"
														class="form-control atletasComplete" id="quadra44" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra45" />
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 5</h3>
												</div>
												<div class="panel-body">
													<input type="text" class="form-control atletasComplete"
														id="quadra51" /> <input type="text"
														class="form-control atletasComplete" id="quadra52" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra53" /> <input type="text"
														class="form-control atletasComplete" id="quadra54" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra55" />
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 6</h3>
												</div>
												<div class="panel-body">
													<input type="text" class="form-control atletasComplete"
														id="quadra61" /> <input type="text"
														class="form-control atletasComplete" id="quadra62" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra63" /> <input type="text"
														class="form-control atletasComplete" id="quadra64" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra65" />
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 7</h3>
												</div>
												<div class="panel-body">
													<input type="text" class="form-control atletasComplete"
														id="quadra71" /> <input type="text"
														class="form-control atletasComplete" id="quadra72" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra73" /> <input type="text"
														class="form-control atletasComplete" id="quadra74" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra75" />
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 8</h3>
												</div>
												<div class="panel-body">
													<input type="text" class="form-control atletasComplete"
														id="quadra81" /> <input type="text"
														class="form-control atletasComplete" id="quadra82" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra83" /> <input type="text"
														class="form-control atletasComplete" id="quadra84" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra85" />
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 9</h3>
												</div>
												<div class="panel-body">
													<input type="text" class="form-control atletasComplete"
														id="quadra91" /> <input type="text"
														class="form-control atletasComplete" id="quadra92" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra93" /> <input type="text"
														class="form-control atletasComplete" id="quadra94" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra95" />
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 10</h3>
												</div>
												<div class="panel-body">
													<input type="text" class="form-control atletasComplete"
														id="quadra101" /> <input type="text"
														class="form-control atletasComplete" id="quadra102" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra103" /> <input type="text"
														class="form-control atletasComplete" id="quadra104" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra105" />
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 11</h3>
												</div>
												<div class="panel-body">
													<input type="text" class="form-control atletasComplete"
														id="quadra111" /> <input type="text"
														class="form-control atletasComplete" id="quadra112" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra113" /> <input type="text"
														class="form-control atletasComplete" id="quadra114" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra115" />
												</div>
											</div>
										</div>
										<div class="col-md-2 form-group">
											<div class="panel panel-primary">
												<div class="panel-heading">
													<h3 class="panel-title">Quadra 12</h3>
												</div>
												<div class="panel-body">
													<input type="text" class="form-control atletasComplete"
														id="quadra121" /> <input type="text"
														class="form-control atletasComplete" id="quadra122" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra123" /> <input type="text"
														class="form-control atletasComplete" id="quadra124" /> <input
														type="text" class="form-control atletasComplete"
														id="quadra125" />
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