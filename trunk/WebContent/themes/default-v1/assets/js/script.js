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

$('#selectInicio').on('change', function () {
	var url = this.value.toString();
	$(window.document.location).attr('href',url);
});
			
$('.mostrarProgresso').click(function() {
	$('#progress').css("display", "block");
});
$('#fechar').click(function() {
	$('#progress').css("display", "none");
});

$("#listaHistorico").accordion();

$("#objetivoConsulta").click(function(){
	$("#exibeObjetivoConsulta").toggle();
});

$("#praticaAtividade").click(function(){
	$("#exibePraticaAtividade").toggle();
});

$("#avaliacaoDietetica").click(function(){
	$("#exibeAvaliacaoDietetica").toggle();
});

$("#recordatorioAlimentar").click(function(){
	$("#exibeRecordatorio").toggle();
});
	
$("#dadosAntropometricos").click(function(){
	$("#exideDadosAntropometricos").toggle();
});

$("#selectModelos").click(function(){
	$("descricaoModelo").css("display", "block");
});

var demo1 = $('select[name="duallistbox_demo1[]"]').bootstrapDualListbox();
$("#demoform").submit(function() {
  alert($('[name="duallistbox_demo1[]"]').val());
  return false;
});

