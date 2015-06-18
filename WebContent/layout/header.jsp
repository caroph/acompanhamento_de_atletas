<header class="navbar">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="container-fluid expanded-panel">
		<div class="row">
			<div id="logo" class="col-xs-12 col-sm-2">
				<a href="Controller?action=voltaPaginaInicial">SAAT</a>
			</div>
			<div id="top-panel" class="col-xs-12 col-sm-10">
				<div class="row">
					<div class="col-xs-8 col-sm-4">
						<a href="#" class="show-sidebar">
						  <i class="fa fa-bars"></i>
						</a>
					</div>
					<div class="col-xs-4 col-sm-8 top-panel-right">
						<ul class="nav navbar-nav pull-right panel-menu" style="width: 100%;">
							<li class="dropdown" style="float: right;">
								<a href="#" class="dropdown-toggle account" data-toggle="dropdown">
									<i class="fa fa-large fa-angle-down pull-right"></i>
									<div class="user-mini pull-right account">
										<span class="welcome">Bem vindo(a),</span>
										<span>${ sessionScope.usuarioLogado.nome }</span>
									</div>
								</a>
								<ul class="dropdown-menu">
									<li>
										<a data-toggle="modal" href="#alterarSenha">
											<i class="fa fa-lock"></i>
											<span>Alterar Senha</span>
										</a>
									</li>
									<li>
										<a href="Autenticador?action=logout">
											<i class="fa fa-power-off"></i>
											<span>Sair</span>
										</a>
									</li>
								</ul>
							</li>
							<c:if test="${sessionScope.usuarioLogado.perfil != 1}">
								<li style="float: right;">
									<a href="Controller?action=jspObservacoes" class="modal-link">
										<i class="fa fa-large fa-bell"></i>
										<c:if test="${notificacaoObs > 0}">
	 										<span class="badge">${notificacaoObs}</span> 
	 									</c:if> 
									</a>
								</li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>