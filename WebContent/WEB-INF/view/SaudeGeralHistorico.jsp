
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file='/layout/head.jsp'%>

<body>

	<%@include file='/layout/header.jsp'%>

	<div id="main" class="container-fluid">
		<div class="row">
			<%@include file='/layout/navigationSaudeGeral.jsp'%>
			<!--Start Content-->
			<div id="content" class="col-xs-12 col-sm-10">
				<div id="ajax-content">
					<div class="row">
						<div id="breadcrumb" class="col-xs-12">
							<ol class="breadcrumb">
								<li><a href="SaudeGeralController">Home</a></li>
							</ol>
						</div>
					</div>
					<c:if test="${ msg != null && msg != ''}">
						<div class="alert alert-danger">
					        <a href="#" class="close" data-dismiss="alert">&times;</a>
					            <c:out value="${msg}"></c:out>       
				    	</div>
			        </c:if>
			        <c:if test="${ msgSucesso != null && msgSucesso != ''}">
						<div class="alert alert-success">
					        <a href="#" class="close" data-dismiss="alert">&times;</a>
					            <c:out value="${msgSucesso}"></c:out>       
				    	</div>
			        </c:if>
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<div class="box-name">
										<i class="fa  fa-info-circle"></i> <span>Atletas</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content no-padding">
									<div id="listaHistorico">
										<div>
											<h4>03/01/2015 - 14:00h</h4>
											<hr />
										</div>
										<div>
											<p>Aqui segue um prontuário, aqui segue um prontuário, aqui
												segue um prontuário, aqui segue um prontuário , aqui segue um
												prontuário, aqui segue um prontuário, aqui segue um prontuário,
												aqui segue um prontuário , aqui segue um prontuário, aqui segue
												um prontuário, aqui segue um prontuário, aqui segue um
												prontuário , aqui segue um prontuário, aqui segue um
												prontuário, aqui segue um prontuário, aqui segue um prontuário
												, aqui segue um prontuário, aqui segue um prontuário, aqui
												segue um prontuário, aqui segue um prontuário.</p>
											<hr />
										</div>
										<div>
											<h4>02/01/2015 - 14:30h</h4>
											<hr />
										</div>
										<div>
											<p>Aqui segue um prontuário, aqui segue um prontuário, aqui
												segue um prontuário, aqui segue um prontuário , aqui segue um
												prontuário, aqui segue um prontuário, aqui segue um prontuário,
												aqui segue um prontuário , aqui segue um prontuário, aqui segue
												um prontuário, aqui segue um prontuário, aqui segue um
												prontuário , aqui segue um prontuário, aqui segue um
												prontuário, aqui segue um prontuário, aqui segue um prontuário
												, aqui segue um prontuário, aqui segue um prontuário, aqui
												segue um prontuário, aqui segue um prontuário.</p>
											<hr />
										</div>
										<div>
											<h4>01/01/2015 - 17:00h</h4>
											<hr />
										</div>
										<div>
											<p>Aqui segue um prontuário, aqui segue um prontuário, aqui
												segue um prontuário, aqui segue um prontuário , aqui segue um
												prontuário, aqui segue um prontuário, aqui segue um prontuário,
												aqui segue um prontuário , aqui segue um prontuário, aqui segue
												um prontuário, aqui segue um prontuário, aqui segue um
												prontuário , aqui segue um prontuário, aqui segue um
												prontuário, aqui segue um prontuário, aqui segue um prontuário
												, aqui segue um prontuário, aqui segue um prontuário, aqui
												segue um prontuário, aqui segue um prontuário.</p>
											<hr />
										</div>
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
	<%@include file="Modals.jsp"%>
	<script src="<%=Constants.JS%>/scriptTables.js"></script>

</body>
</html>