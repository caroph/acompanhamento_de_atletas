//Plugin Estados e Cidade
window.onload = function() {	
	  new dgCidadesEstados({
		    estado: document.getElementById('estado'),
		    cidade: document.getElementById('cidade')
		  });
	  
	  new dgCidadesEstados({
		    estado: document.getElementById('estadoCom'),
		    cidade: document.getElementById('cidadeCom')
		  });
}

//Máscaras
$(document).ready(function(){
	   $(".data").mask("99/99/9999",{placeholder:"dd/mm/yyyy"});
	   $(".phone").mask("(999) 9999-9999");
	   $("#cpf").mask("999.999.999-99");
	});


//Plugin Dual List
var demo1 = $('select[name="diasTreino"]').bootstrapDualListbox();



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
		
//Limpar Campos
		function LimparCampos() {
			$(":time").each(function () {
				$(this).val("");
			});
			$("select").each(function () {
				$(this).val("Selecione");
			});
		}
			
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


function abrirModalUsuario(nome, perfil, email, telefone, celular, cref){
	var html = "<b>Nome:</b> "+ nome + "<br/>";
	html += "<b>Perfil:</b> " + perfil + "<br/>"; 
	html += "<b>Email:</b> " + email + "<br/>";
	html += "<b>Telefone:</b> "+ telefone + "<br/>";
	html += "<b>Celular:</b> " + celular + "<br/>";
	
	if(cref != null && cref != "")
		html += "CREF: " + cref + "<br/>";
	$('.body-usuario').html(html);
}

function abrirModalVisualizarResponsavel(nome, email, telResidencial, telComercial, celular){
	var html = "<b>Nome:</b> " + nome + "<br/>";
	html += "<b>Email:</b> " + email + "<br/>";
	html += "<b>Telefone Residencial:</b> " + telResidencial + "<br/>";
	html += "<b>Telefone Comercial:</b> " + telComercial + "<br/>";
	html += "<b>Celular:</b> " + celular + "<br/>";
	
	$('.body-responsavel').html(html);	
}

//Combo Dinamico - Dias de Treino Atleta
function carregaDiasTreino(){     
//    document.forms[0].action.value="carregaDiasTreino";     
    document.forms[0].action="SecretariaController?action=carregaDiasTreino";     
    document.forms[0].submit();  
}  

//$('#selectInicio').on('change', function () {
//	var url = this.value.toString();
//	$(window.document.location).attr('href',url);
//});
//			
//$('.mostrarProgresso').click(function() {
//	$('#progress').css("display", "block");
//});
//$('#fechar').click(function() {
//	$('#progress').css("display", "none");
//});
//
//$("#listaHistorico").accordion();
//
//$("#objetivoConsulta").click(function(){
//	$("#exibeObjetivoConsulta").toggle();
//});
//
//$("#praticaAtividade").click(function(){
//	$("#exibePraticaAtividade").toggle();
//});
//
//$("#avaliacaoDietetica").click(function(){
//	$("#exibeAvaliacaoDietetica").toggle();
//});
//
//$("#recordatorioAlimentar").click(function(){
//	$("#exibeRecordatorio").toggle();
//});
//	
//$("#dadosAntropometricos").click(function(){
//	$("#exideDadosAntropometricos").toggle();
//});
//
//$("#selectModelos").click(function(){
//	$("descricaoModelo").css("display", "block");
//});