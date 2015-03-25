<!-- Navigation -->
<div id="sidebar-left" class="col-xs-2 col-sm-2">
	<ul class="nav main-menu">
		<li class="dropdown">
			<a href="#" class="dropdown-toggle">
				<i class="fa fa-male"></i>
				<span class="hidden-xs">Atletas</span>
			</a>
			<ul class="dropdown-menu">
				<li><a class="" href="SecretariaController?action=jspNovoAtleta">Novo</a></li>
				<li><a class="ajax-link" href="SecretariaAtleta.jsp">Buscar</a></li>
			</ul>
		</li>
		<li class="dropdown">
			<a href="#" class="dropdown-toggle">
				<i class="fa fa-group"></i>
				<span class="hidden-xs">Responsáveis</span>
			</a>
			<ul class="dropdown-menu">
				<li><a class="ajax-link" href="SecretariaNovoResponsavel.jsp">Novo</a></li>
				<li><a class="ajax-link" href="SecretariaResponsavel.jsp">Buscar</a></li>
			</ul>
		</li>				
		<li class="dropdown">
			<a href="#" class="dropdown-toggle">
				<i class="fa fa-user"></i>
				<span class="hidden-xs">Usuários</span>
			</a>
			<ul class="dropdown-menu">
				<li><a class="ajax-link" href="SecretariaNovoUsuario.jsp">Novo</a></li>
				<li><a class="ajax-link" href="SecretariaUsuario.jsp">Buscar</a></li>
			</ul>
		</li>
		<li class="dropdown">
			<a href="#" class="dropdown-toggle">
				<i class="fa fa-calendar"></i>
				<span class="hidden-xs">Dias de Treino</span>
			</a>
			<ul class="dropdown-menu">
				<li><a class="" href="SecretariaController?action=jspNovoDiaTreino">Novo</a></li>
				<li><a class="" href="SecretariaController?action=jspBuscaDiaTreino">Buscar</a></li>
			</ul>
		</li>
		<li class="dropdown">
			<a href="#" class="dropdown-toggle">
				<i class="fa fa-sort-numeric-asc"></i>
				<span class="hidden-xs">Relatórios</span>
			</a>
			<ul class="dropdown-menu">
				<li><a class="ajax-link" href="SecretariaRelatorioAtletas.jsp">Atletas</a></li>
				<li><a class="ajax-link" href="SecretariaRelatorioUniformes.jsp">Uniformes</a></li>
				<li><a class="ajax-link" href="SecretariaRelatorioTorneios.jsp">Torneios</a></li>
			</ul>
		</li>
		<li>
			<a href="SecretariaEnviarEmail.jsp">
				<i class="fa fa-envelope"></i>
				<span class="hidden-xs">Enviar email</span>
			</a>
		</li>
	</ul>
</div>
		
