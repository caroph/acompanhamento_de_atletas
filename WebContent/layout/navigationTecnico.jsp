
<!-- Navigation -->
<div id="sidebar-left" class="col-xs-2 col-sm-2">
	<ul class="nav main-menu">
		<li class="dropdown">
			<a href="TecnicoController?action=jspBuscarAtletas">
				<i class="fa fa-male"></i>
				<span class="hidden-xs">Atletas</span>
			</a>
		</li>
		<li class="dropdown">
			<a href="#" class="dropdown-toggle">
				<i class="fa fa-trophy"></i>
				<span class="hidden-xs">Torneios</span>
			</a>
			<ul class="dropdown-menu">
				<li><a class="" href="TecnicoController?action=jspNovoTorneio">Novo</a></li>
				<li><a class="" href="TecnicoController?action=jspCalendario">Calendário</a></li>
			</ul>
		</li>	
		<li class="dropdown">
			<a href="#" class="dropdown-toggle">
				<i class="fa fa-calendar"></i>
				<span class="hidden-xs">Chamada</span>
			</a>
			<ul class="dropdown-menu">
				<li><a class="" href="TecnicoController?action=jspChamadaQuadra">Quadra</a></li>
				<li><a class="" href="TecnicoController?action=jspChamada">Chamada</a></li>
			</ul>
		</li>
		<c:if test="${sessionScope.usuarioLogado.perfil == 6}">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle">
					<i class="fa fa-exchange"></i>
					<span class="hidden-xs">Avaliação Física</span>
				</a>
				<ul class="dropdown-menu">
					<li><a class="" href="AvaliacaoFisController?action=jspAtividade">Atividades</a></li>
					<li><a class="" href="AvaliacaoFisController?action=jspCategoria">Categorias</a></li>
				</ul>
			</li>
		</c:if>
		<li class="dropdown">
			<a href="#" class="dropdown-toggle">
				<i class="fa fa-sort-numeric-asc"></i>
				<span class="hidden-xs">Relatórios</span>
			</a>
			<ul class="dropdown-menu">
				<li><a class="" href="TecnicoController?action=jspResulTorneio">Resultados de Torneios</a></li>
				<li><a class="" href="SecretariaController?action=jspFrequenciaTorneio">Frequência em Torneios</a></li>
				<li><a class="" href="TecnicoController?action=jspRelatorioTreinos">Presença em Treinos</a></li>
				<li><a class="" href="TecnicoController?action=jspRelatorioConsultaMedica">Presença Consulta Médica</a></li>
			</ul>
		</li>	
	</ul>
</div>


		
