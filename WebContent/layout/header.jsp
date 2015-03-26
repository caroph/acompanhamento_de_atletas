<header class="navbar">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="container-fluid expanded-panel">
		<div class="row">
			<div id="logo" class="col-xs-12 col-sm-2">
				<a href="#">SAAT</a>
			</div>
			<div id="top-panel" class="col-xs-12 col-sm-10">
				<div class="row">
					<div class="col-xs-8 col-sm-4">
						<a href="#" class="show-sidebar">
						  <i class="fa fa-bars"></i>
						</a>
					</div>
					<div class="col-xs-4 col-sm-8 top-panel-right">
						<ul class="nav navbar-nav pull-right panel-menu">
							<li>
								<a href="#" class="modal-link">
									<i class="fa fa-bell"></i>
<!-- 									<span class="badge">7</span> -->
								</a>
							</li>
							<li>
								<a href="Autenticador?action=logout">
									<i class="fa fa-power-off"></i>
								</a>
							</li>
							<li class="dropdown">
									<div class="user-mini pull-right account">
										<span class="welcome">Bem vindo(a),</span>
										<span>${ sessionScope.usuarioLogado.nome }</span>
									</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>