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

	$('#anexar').click(function() {
		$('#progress').css("display", "block");
	});
	$('#fechar').click(function() {
		$('#progress').css("display", "none");
	});
	
	$(".date-picker").datepicker();

	$(".date-picker").on("change", function () {
	    var id = $(this).attr("id");
	    var val = $("label[for='" + id + "']").text();
	    $("#msg").text(val + " changed");
	});