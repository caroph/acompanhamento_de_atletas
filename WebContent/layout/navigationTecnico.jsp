
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
				<li><a class="" href="TecnicoController?action=jspCalendario">Calend�rio</a></li>
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
		<li class="dropdown">
			<a href="TecnicoController?action=jspAtletaBonificacao" class="dropdown-toggle">
				<i class="fa fa-star"></i>
				<span class="hidden-xs">Bonifica��o</span>
			</a>
		</li>
		<c:if test="${sessionScope.usuarioLogado.perfil == 6}">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle">
					<i class="fa fa-line-chart"></i>
					<span class="hidden-xs">Avalia��o f�sica</span>
				</a>
				<ul class="dropdown-menu">
					<li><a class="" href="AvaliacaoFisController?action=jspAtividade">Atividades</a></li>
					<li><a class="" href="AvaliacaoFisController?action=jspCategoria">Categorias</a></li>
					<li><a class="" href="AvaliacaoFisController?action=jspDadosRef">Dados de refer�ncia</a></li>
				</ul>
			</li>
		</c:if>
		<li class="dropdown">
			<a href="#" class="dropdown-toggle">
				<i class="fa fa-sort-numeric-asc"></i>
				<span class="hidden-xs">Relat�rios</span>
			</a>
			<ul class="dropdown-menu">
				<li><a class="" href="TecnicoController?action=jspResulTorneio">Resultados de torneios</a></li>
				<li><a class="" href="SecretariaController?action=jspFrequenciaTorneio">Frequ�ncia em torneios</a></li>
				<li><a class="" href="TecnicoController?action=jspRelatorioTreinos">Presen�a em treinos</a></li>
				<li><a class="" href="TecnicoController?action=jspRelatorioConsultaMedica">Presen�a consultas m�dicas</a></li>
				<li><a class="" href="TecnicoController?action=jspRelatorioDesempenhoAvalFis">Desempenho em avalia��o f�sica</a></li>
			</ul>
		</li>	
	</ul>
</div>


		
