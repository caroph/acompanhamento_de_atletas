
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
									<form role="form" class="form-horizontal">
										<div class="form-group col-md-5 text-right">
											<label for="datade" class="control-label">Data:</label>
										</div>
										<div class="form-group col-md-7">
											 <input type="date" class="form-control" id="dataQuadra" style="width: 30%; margin-left: 1%"/>
										 </div>
										<div class="col-md-2 column">
											<div class="panel panel-primary">
												<div class="panel-heading">
											    	<h3 class="panel-title">Quadra 1</h3>
											  	</div>
											  	<div class="panel-body">
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											  	</div>
											</div>
										</div>
										<div class="col-md-2 column">
											<div class="panel panel-primary">
												<div class="panel-heading">
											    	<h3 class="panel-title">Quadra 2</h3>
											  	</div>
											  	<div class="panel-body">
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											  	</div>
											</div>
										</div>
										<div class="col-md-2 column">
											<div class="panel panel-primary">
												<div class="panel-heading">
											    	<h3 class="panel-title">Quadra 3</h3>
											  	</div>
											  	<div class="panel-body">
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											  	</div>
											</div>
										</div>
										<div class="col-md-2 column">
											<div class="panel panel-primary">
												<div class="panel-heading">
											    	<h3 class="panel-title">Quadra 4</h3>
											  	</div>
											  	<div class="panel-body">
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											  	</div>
											</div>
										</div>
										<div class="col-md-2 column">
											<div class="panel panel-primary">
												<div class="panel-heading">
											    	<h3 class="panel-title">Quadra 5</h3>
											  	</div>
											  	<div class="panel-body">
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											  	</div>
											</div>
										</div>
										<div class="col-md-2 column">
											<div class="panel panel-primary">
												<div class="panel-heading">
											    	<h3 class="panel-title">Quadra 6</h3>
											  	</div>
											  	<div class="panel-body">
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											  	</div>
											</div>
										</div>
										<div class="col-md-2 column">
											<div class="panel panel-primary">
												<div class="panel-heading">
											    	<h3 class="panel-title">Quadra 7</h3>
											  	</div>
											  	<div class="panel-body">
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											  	</div>
											</div>
										</div>
										<div class="col-md-2 column">
											<div class="panel panel-primary">
												<div class="panel-heading">
											    	<h3 class="panel-title">Quadra 8</h3>
											  	</div>
											  	<div class="panel-body">
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											  	</div>
											</div>
										</div>
										<div class="col-md-2 column">
											<div class="panel panel-primary">
												<div class="panel-heading">
											    	<h3 class="panel-title">Quadra 9</h3>
											  	</div>
											  	<div class="panel-body">
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											  	</div>
											</div>
										</div>
										<div class="col-md-2 column">
											<div class="panel panel-primary">
												<div class="panel-heading">
											    	<h3 class="panel-title">Quadra 10</h3>
											  	</div>
											  	<div class="panel-body">
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											  	</div>
											</div>
										</div>
										<div class="col-md-2 column">
											<div class="panel panel-primary">
												<div class="panel-heading">
											    	<h3 class="panel-title">Quadra 11</h3>
											  	</div>
											  	<div class="panel-body">
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											  	</div>
											</div>
										</div>
										<div class="col-md-2 column">
											<div class="panel panel-primary">
												<div class="panel-heading">
											    	<h3 class="panel-title">Quadra 12</h3>
											  	</div>
											  	<div class="panel-body">
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											    	<input type="text" class="form-control" id="exampleInputEmail1" />
											  	</div>
											</div>
										</div>
										<div class="form-group col-md-12">
											<div class="col-sm-12 text-right">
												 <a type="submit" class="btn btn-info" href="TecnicoChamada.jsp">Visualizar Chamada</a>
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
	<script src="<%=Constants.JS%>/scriptTables.js"></script>

</body>
</html>