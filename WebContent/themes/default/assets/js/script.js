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

//var demo1 = $('select[name="duallistbox_demo1[]"]').bootstrapDualListbox();
//$("#demoform").submit(function() {
//  alert($('[name="duallistbox_demo1[]"]').val());
//  return false;
//});


//Alert de Confirmação
$(document).ready(function() {
	$('a[data-confirm]').click(function(ev) {
		var href = $(this).attr('href');
		if (!$('#dataConfirmModal').length) {
			$('body').append('<div class="modal fade bs-example-modal-sm" id="dataConfirmModal" tabindex="-1" role="dialog" aria-labelledby="dataConfirmLabel" aria-hidden="true"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button><h4 class="modal-title" id="myModalLabel">Por favor, confirme:</h4></div><div class="modal-body"></div><div class="modal-footer"><a class="btn btn-danger" id="dataConfirmOK">Sim</a><button class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button></div></div></div></div>');
		} 
		$('#dataConfirmModal').find('.modal-body').text($(this).attr('data-confirm'));
		$('#dataConfirmOK').attr('href', href);
		$('#dataConfirmModal').modal({show:true});
		return false;
	});
});

//Passar email "Esqueci Senha"
function passar(){ 
		var valorA = document.getElementById("email"); 
		var email = document.getElementById("emailSenha"); 
		email.value = valorA.value; 
		}; 
		
function carregaScriptEstadoRes(){
	document.getElementById('cidade2').innerHMTL = "";
	new dgCidadesEstados(
			document.getElementById('estado2'),
			document.getElementById('cidade2'),
			true
		);
};
		
//Plugin de Horário e Calendario
function DemoTimePicker(){
	$('#hrInicio').timepicker({setDate: new Date()});
	$('#hrFim').timepicker({setDate: new Date()});
}

$(document).ready(function() {			
	// Initialize datepicker
	$('#dtNascimento').datepicker({setDate: new Date()});
	$('#dtValidade').datepicker({setDate: new Date()});
	// Load Timepicker plugin
	LoadTimePickerScript(DemoTimePicker);
});

//Plugin de Calendário

//Limpar Campos
function LimparCampos() {
	 
    $(":time").each(function () {
        $(this).val("");
    });

    $("select").each(function () {
        $(this).val("Selecione");
    });
}
