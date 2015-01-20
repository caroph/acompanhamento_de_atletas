window.onload = function() {
			new dgCidadesEstados(
				document.getElementById('estado'),
				document.getElementById('cidade'),
				true
			);
			new dgCidadesEstadosCom(
					document.getElementById('estadocom'),
					document.getElementById('cidadecom'),
					true
				);			
		}

//	$('#anexar').click(function() {
//		$('#progress').css("display", "block");
//	});
//	$('#fechar').click(function() {
//		$('#progress').css("display", "none");
//	});