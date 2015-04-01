window.onload = function() {	
		  new dgCidadesEstados({
			    estado: document.getElementById('estado'),
			    cidade: document.getElementById('cidade')
			  });
		  
		  new dgCidadesEstados({
			    estado: document.getElementById('estadoCom'),
			    cidade: document.getElementById('cidadeCom')
			  });
		  
//			new dgCidadesEstadosCom(
//				document.getElementById('estadoCom'),
//				document.getElementById('cidadeCom'),
//				true
//			);
}

//Máscaras
$(document).ready(function(){
	   //$("#date").mask("99/99/9999",{placeholder:"mm/dd/yyyy"});
	   $(".phone").mask("(999) 9999-9999");
	   //$("#tin").mask("99-9999999");
	   //$("#ssn").mask("999-99-9999");
	});

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

function abrirModalUsuario(nome, perfil, email, telefone, celular, cref){
	var html = "Nome: "+ nome + "<br/> Perfil: " + perfil + "<br/> Email: " + email + "<br/> Telefone: "
	+ telefone + "<br/> Celular: " + celular;
	if(cref != null && cref != "")
		html += "<br/>CREF: " + cref;
	$('.body-usuario').html(html);
}

//Checked List Group
$(function () {
    $('.list-group.checked-list-box .list-group-item').each(function () {
        
        // Settings
        var $widget = $(this),
            $checkbox = $('<input type="checkbox" class="hidden" />'),
            color = ($widget.data('color') ? $widget.data('color') : "primary"),
            style = ($widget.data('style') == "button" ? "btn-" : "list-group-item-"),
            settings = {
                on: {
                    icon: 'fa fa-check-square-o'
                },
                off: {
                    icon: 'fa fa-square-o'
                }
            };
            
        $widget.css('cursor', 'pointer')
        $widget.append($checkbox);

        // Event Handlers
        $widget.on('click', function () {
            $checkbox.prop('checked', !$checkbox.is(':checked'));
            $checkbox.triggerHandler('change');
            updateDisplay();
        });
        $checkbox.on('change', function () {
            updateDisplay();
            escreverJson();
        });
          

        // Actions
        function updateDisplay() {
            var isChecked = $checkbox.is(':checked');

            // Set the button's state
            $widget.data('state', (isChecked) ? "on" : "off");

            // Set the button's icon
            $widget.find('.state-icon')
                .removeClass()
                .addClass('state-icon ' + settings[$widget.data('state')].icon);

            // Update the button's color
            if (isChecked) {
                $widget.addClass(style + color + ' active');
            } else {
                $widget.removeClass(style + color + ' active');
            }
            
        }

//        // Initialization
        function init() {
            
            if ($widget.data('checked') == true) {
                $checkbox.prop('checked', !$checkbox.is(':checked'));
            }
            
            updateDisplay();

            // Inject the icon if applicable
            if ($widget.find('.state-icon').length == 0) {
                $widget.prepend('<span class="state-icon ' + settings[$widget.data('state')].icon + '"></span>');
            }
        }
        init();
    });
    
//    $('#salvar').on('click', function(event) {
//    	alert("oi");
//        event.preventDefault(); 
//        var checkedItems = {}, counter = 0;
//        $("#check-list-box li.active").each(function(idx, li) {
//            checkedItems[counter] = $(li).text();
//            counter++;
//        });
//        $('#display-json').html(JSON.stringify(checkedItems, null, '\t'));
//    });
    
    function escreverJson(){
    	alert("oi json");
        event.preventDefault(); 
        var checkedItems = {}, counter = 0;
        $("#check-list-box li.active").each(function(idx, li) {
            checkedItems[counter] = $(li).text();
            counter++;
        });
        $('#diasTreino').html(JSON.stringify(checkedItems, null, '\t'));
    }
});
