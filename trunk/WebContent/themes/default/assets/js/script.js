window.onload = function() {
			new dgCidadesEstados(
				document.getElementById('estado'),
				document.getElementById('cidade'),
				true
			);
			new dgCidadesEstados(
				document.getElementById('estadoPai'),
				document.getElementById('cidadePai'),
				true
			);
			new dgCidadesEstados(
				document.getElementById('estadoPaiCom'),
				document.getElementById('cidadePaiCom'),
				true
			);
			new dgCidadesEstados(
				document.getElementById('estadoMae'),
				document.getElementById('cidadeMae'),
				true
			);
			new dgCidadesEstados(
				document.getElementById('estadoMaeCom'),
				document.getElementById('cidadeMaeCom'),
				true
			);
		}