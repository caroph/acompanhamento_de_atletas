window.onload = function() {
			new dgCidadesEstados(
				document.getElementById('estado'),
				document.getElementById('cidade'),
				true
			);
			new dgCidadesEstadosCom(
					document.getElementById('estadoCom'),
					document.getElementById('cidadeCom'),
					true
				);		
}
			
//	$('#anexar').click(function() {
//		$('#progress').css("display", "block");
//	});
//	$('#fechar').click(function() {
//		$('#progress').css("display", "none");
//	});
	

