<c:if test="${ msgSucesso != null && msgSucesso != ''}">
	<div class="alert alert-success">
		<a href="#" class="close" data-dismiss="alert">&times;</a>
		<c:out value="${msgSucesso}"></c:out>
	</div>
</c:if>
<c:if test="${ msgAlerta != null && msgAlerta != ''}">
	<div class="alert alert-info">
		<a href="#" class="close" data-dismiss="alert">&times;</a>
		<c:out value="${msgAlerta}" escapeXml="false"></c:out>
	</div>
</c:if>
<c:if test="${ msgErro != null && msgErro != ''}">
	<div class="alert alert-danger">
		<a href="#" class="close" data-dismiss="alert">&times;</a>
		<c:out value="${msgErro}"></c:out>
	</div>
</c:if>
<c:if test="${ msgErroSenha != null && msgErroSenha != ''}">
	<div class="alert alert-danger">
		<a href="#" class="close" data-dismiss="alert">&times;</a>
		<c:out value="${msgErroSenha}"></c:out>
	</div>
</c:if>
<c:if test="${ msgSucessoSenha != null && msgSucessoSenha != ''}">
	<div class="alert alert-success">
		<a href="#" class="close" data-dismiss="alert">&times;</a>
		<c:out value="${msgSucessoSenha}"></c:out>
	</div>
</c:if>