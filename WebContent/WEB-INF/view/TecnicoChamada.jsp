
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
										<i class="fa fa-male"></i> <span>Chamada</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<div class="col-md-12">
										<div class="col-md-5 text-right" style="line-height: 26px; font-size: 18px;">
											<label for="diaChamada" class="control-label"> Chamada dia:</label>
										</div>
										<div class="col-md-7">
											<input type="date" style="width: 180px;" class="form-control">
										</div>
										<table class="table">
										<thead>
											<tr>
												<th width="60%" class="text-center">Atletas</th>
												<th width="20%" class="text-center">Treino Físico</th>
												<th width="20%" class="text-center">Treino Técnico</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>
													Atleta 1
												</td>
												<td align="center">
													<a href="#modalPresenca" class="btn" data-toggle="modal">
														<span class="glyphicon glyphicon-plus" aria-hidden="true" style="color: red"></span>
													</a>
												</td>
												<td align="center">
													<a href="#modalPresenca" class="btn" data-toggle="modal">
														<span class="glyphicon glyphicon-plus" aria-hidden="true" style="color: red"></span>
													</a>
												</td>
											</tr>
											<tr>
												<td>
													Atleta 2
												</td>
												<td align="center">
													<a href="#modalPresenca" class="btn" data-toggle="modal">
														<span class="glyphicon glyphicon-ok" aria-hidden="true" style="color: green"></span>
													</a>
												</td>
												<td align="center">
													<a href="#modalPresenca" class="btn" data-toggle="modal">
														<span class="glyphicon glyphicon-ok" aria-hidden="true" style="color: green"></span>
													</a>
												</td>
											</tr>
											<tr>
												<td>
													Atleta 3
												</td>
												<td align="center">
													<a href="#modalPresenca" class="btn" data-toggle="modal">
														<span class="glyphicon glyphicon-ban-circle" aria-hidden="true" style="color: red"></span>
													</a>
												</td>
												<td align="center">
													<a href="#modalPresenca" class="btn" data-toggle="modal">
														<span class="glyphicon glyphicon-ok" aria-hidden="true" style="color: green"></span>
													</a>
												</td>
											</tr>
											<tr>
												<td>
													Atleta 4
												</td>
												<td align="center">
													<a href="#modalPresenca" class="btn" data-toggle="modal">
														<span class="glyphicon glyphicon-flag" aria-hidden="true" style="color: rgb(97, 97, 7)"></span>
													</a>
												</td>
												<td align="center">
													<a href="#modalPresenca" class="btn" data-toggle="modal">
														<span class="glyphicon glyphicon-flag" aria-hidden="true" style="color: rgb(97, 97, 7)"></span>
													</a>
												</td>
											</tr>
											<tr>
												<td>
													Atleta 5
												</td>
												<td align="center">
													<a href="#modalPresenca" class="btn" data-toggle="modal">
														<span class="glyphicon glyphicon-ok" aria-hidden="true" style="color: green"></span>
													</a>
												</td>
												<td align="center">
													<a href="#modalPresenca" class="btn" data-toggle="modal">
														<span class="glyphicon glyphicon-ok" aria-hidden="true" style="color: green"></span>
													</a>
												</td>
											</tr>
										</tbody>
										</table>
									</div>
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