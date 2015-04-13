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

//Vincular Responsável
function abrirModalVinculacao(atleta, pagina){
	$("#vincularResponsavel").modal();
	$.ajax({
		type : "POST",
		url : "SecretariaController?action=buscarResponsaveisVinculacao&idAtleta=" + atleta + "&pagina=" + pagina,
		success : function(data) {
			var html = "";
			$.each(data.listaResponsaveis, function(index, item){
				html += "<input name='responsavel' value=" + item.idPessoa + " type='radio'/>   " + item.nome + "<br/>";
			});
			html += "<input type='hidden' name='idAtleta' value=" + data.idAtleta + " />";
			html += "<input type='hidden' name='pagina' value=" + data.pagina + " />";
			html += "<select class='form-control' style='width: 95%;' name='grauParentesco' required>";
			html +="<option selected>Selecione</option>";
			$.each(data.grauParentesco, function(index, item){
				html +="<option value=" + index + ">" + item + "</option>";
			});
			html +="</select>";
			$('.vincular-body p').html(html);
		}
	});
}

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

function abrirModalAtleta(idAtleta){
	$("#detalhes").modal();
	$.ajax({
		type : "POST",
		url : "SecretariaController?action=buscarAtletaDetalhes&idAtleta=" + idAtleta,
		success : function(data) {
			var html = "<b>Nome:</b> " + data.atleta.nome + "<br/>";
			html += "<b>Equipe:</b> " + data.equipe[data.atleta.idTpEquipe - 1] + "<br/>";
			html += "<br/><b>Dias de Treino:</b> " + "<br/>";
			var diasSemana = data.diaSemana;
			$.each(data.atleta.listaDiasTreinos, function(index, item){
				html += diasSemana[item.idDiaSemana - 1] + " - " + item.hrInicio + " - " + item.hrFim + "<br/>";
			});
			html += "<br/><b>N. Matricula:</b> " + data.atleta.nrMatricula + "<br/>";
			html += "<b>N. Cadastro CBT:</b> " + data.atleta.nrCadCBT + "<br/>";
			html += "<b>N. Cadastro FTP:</b> " + data.atleta.nrCadFPT + "<br/>";
			html += "<br/><b>Responsaveis:</b> " + "<br/>";
			var grauParentesco = data.grauParentesco;
			$.each(data.atleta.listaResponsaveis, function(index, item){
				html += grauParentesco[item.idGrauParentesco - 1] + " - " + item.nome + " - " + item.celular + "<br/>";
			});
			html += "<br/><b>Contato de Emergencia:</b> " + "<br/>";
			html += "<b>Nome:</b> " + data.atleta.nmContatoEmergencia + "<br/>";
			html += "<b>Grau de Parentesco:</b> " + data.grauParentesco[data.atleta.idGrauParentesco - 1] + "<br/>";
			html += "<b>Telefone:</b> " + data.atleta.telContatoEmergencia + "<br/>";
			
			$('.body-atleta').html(html);
		}
	});
}

function abrirModalVisualizarResponsavel(nome, email, telResidencial, telComercial, celular, endRes, numeroRes, compRes, bairroRes, estadoRes, cidadeRes, endCom, numeroCom, compCom, bairroCom, estadoCom, cidadeCom){
	var html = "<b>Nome:</b> " + nome + "<br/>";
	html += "<b>Email:</b> " + email + "<br/>";
	html += "<b>Telefone Residencial:</b> " + telResidencial + "<br/>";
	html += "<b>Telefone Comercial:</b> " + telComercial + "<br/>";
	html += "<b>Celular:</b> " + celular + "<br/>";
	html += "<b>Endereco Residencial:</b> " + endRes + ", " + numeroRes + ", " + compRes + " - " + bairroRes + " - " + cidadeRes + "/" + estadoRes + "<br/>";
	html += "<b>Endereco Comercial:</b> " + endCom + ", " + numeroCom + ", " + compCom + " - " + bairroCom + " - " + cidadeCom + "/" + estadoCom + "<br/>";		
	$('.body-responsavel').html(html);	
}

function abrirModalAnexarArquivo(idTpDocumento,idPessoa){
	//Valor que irá aparecer na label
	var strNmDoc;
	
	switch(idTpDocumento){
	case 1:
		strNmDoc = "Termo de compromisso do manual do atleta";
		break;	
	case 2:
		strNmDoc = "Declara\u00e7\u00e3o m\u00e9dica";
		break;
	case 3:
		strNmDoc = "Autoriza\u00e7\u00e3o de viagem e hospedagem";
		break;
	case 4:
		strNmDoc = "Autoriza\u00e7\u00e3o de imagem";
		break;
	case 5:
		strNmDoc = "C\u00f3pia do RG";
		break;
	case 6:
		strNmDoc = "C\u00f3pia do CPF";
		break;
	default:
		strNmDoc = "Valor Inv\u00e1lido!";
		break;
	}
	
	var html = "<form class='form-horizontal' role='form' action='SecretariaController?action=anexarDocumento' enctype='multipart/form-data' method='post'>"+
					"<input type='hidden' id='idPessoa' name='idPessoa' value='"+ idPessoa +"'/>"+
					"<input type='hidden' id='idTpDocumento' name='idTpDocumento' value='"+ idTpDocumento +"'/>"+
					"<div class='form-group'>"+
						"<label for='nmArquivo' class='col-sm-12 text-left'>" + strNmDoc + "</label>"+
						"<div class='col-sm-12'>"+
							"<input type='file' class='form-control text-left' id='arquivo' name='arquivo' required/>"+
						"</div>" +
					"</div>" +
					"<div class='form-group'>" +
						"<label for='dtValidadeArquivo' class='col-sm-12 text-left'>Data de validade do documento</label>" +
						"<div class='col-sm-5'>" +
							"<input type='date' class='form-control' id='dtValidade' name='dtValidade'/>" +
						"</div>"+
					"</div>" +
					"<div class='form-group'>" +
						"<div class='col-sm-8'></div>" +
						"<div class='col-sm-4'>" +
							"<input type='submit' class='form-control btn btn-primary' id='anexarArquivo' name='anexarArquivo' value='Anexar Arquivo'/>" +
						"</div>"+
					"</div>" +
				"</form>";
	
	$('.body-anexarArquivo').html(html);
}

function visualizarDoc(srcDocumento){
	var html = "<img src='" + srcDocumento + "'>";
	//var html = "<img src='C:\\Program Files\\apache-tomcat-7.0.52\\wtpwebapps\\saatDocumentacaoAtletas\\1\\1_termo_compromisso_manual.jpg'/>";
	//alert(srcDocumento);
	//var html = "<b>" + srcDocumento + "</b>";
	$('.body-imgVisualizarDoc').html(html);
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