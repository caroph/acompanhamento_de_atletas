
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file='/layout/head.jsp'%>

<body>

	<%@include file='/layout/header.jsp'%>

	<div id="main" class="container-fluid">
		<div class="row">
			<c:if test="${sessionScope.usuarioLogado.perfil == 2}">
				<%@include file='/layout/navigationNutricionista.jsp'%>
			</c:if>
			<c:if test="${sessionScope.usuarioLogado.perfil == 3 || sessionScope.usuarioLogado.perfil == 4}">
				<%@include file='/layout/navigationSaudeGeral.jsp'%>
			</c:if>
			<c:if test="${sessionScope.usuarioLogado.perfil == 5 || sessionScope.usuarioLogado.perfil == 6}">
				<%@include file='/layout/navigationTecnico.jsp'%>
			</c:if>
			
			<!--Start Content-->
			<div id="content" class="col-xs-12 col-sm-10">
				<div id="ajax-content">
					<%@include file="Mensagem.jsp"%>
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<div class="box-name">
										<i class="fa fa-bell"></i> <span>Observações</span>
									</div>
									<div class="box-icons">
										<a class="expand-link"> <i class="fa fa-expand"></i>
										</a>
									</div>
									<div class="no-move"></div>
								</div>
								<div class="box-content">
									<div class="row clearfix"> 
										<div class="col-md-12">
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
	<%@include file="Modals.jsp" %>
</body>
</html>