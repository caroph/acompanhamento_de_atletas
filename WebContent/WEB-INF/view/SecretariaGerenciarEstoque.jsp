
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file='/layout/head.jsp'%>

<body>

	<%@include file='/layout/header.jsp'%>

	<div id="main" class="container-fluid">
		<div class="row">
			<%@include file='/layout/navigationSecretaria.jsp'%>
			<!--Start Content-->
			<div id="content" class="col-xs-12 col-sm-10">
				<div id="ajax-content">
					<%@include file="Mensagem.jsp"%>
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<div class="box-name">
										<i class="fa fa-tags"></i> <span>Gerenciamento de Estoque de Uniformes</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content clearfix">
									<form action="SecretariaController?action=gerenciarEstoque" method="post">
										<div class="col-md-12 form-group">
											<div class="form-group">
												<span><strong>Tipo de operação:</strong></span>
								    			<input type="radio" style="margin-left: 7px;" name="optEstoque" value="I">Inclusão</input>
								    			<input type="radio" style="margin-left: 7px;" name="optEstoque" value="B">Baixa</input>
								    		</div>
										</div>
										<table class="table">
											<thead>
												<tr>
													<th width="60%">Tipo</th>
													<th width="20%">Tamanho</th>
													<th width="20%">Quantidade</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="uniforme" items="${listaUniformes}">
													<tr>
														<td><c:out value='${uniforme.getNome()}' /></td>
														<td>
															<select name="tamanho-${uniforme.getValor()}" class="form-control">
																<option value="0" selected>Selecione</option>
																<c:forEach var="tamanho" items="${listaTamanhos}">
																	<option value="${tamanho.getValor()}">
																		<c:out value="${tamanho.getNome()}"></c:out>
																	</option>
																</c:forEach>
															</select>
														</td>
														<td><input type="number" name="qtd-${uniforme.getValor()}"/></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<div align="right">
											<button type="submit" class="btn btn-primary">Salvar</button>
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

