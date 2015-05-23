//Plugin Estados e Cidade
window.onload = function() {
	new dgCidadesEstados({
		estado : document.getElementById('estado'),
		cidade : document.getElementById('cidade')
	});

	new dgCidadesEstados({
		estado : document.getElementById('estadoCom'),
		cidade : document.getElementById('cidadeCom')
	});	
}

// Máscaras
$(document).ready(function() {
	$(".data").mask("99/99/9999");
	$(".phone").mask("(999) 9999-9999");
	$("#cpf").mask("999.999.999-99");
});

// Plugin Dual List
var demo1 = $('select[name="diasTreino"]').bootstrapDualListbox();
var demo2 = $('select[name="atletasPart"]').bootstrapDualListbox();

//Plugin Histórico de Atendimento
$("#listaHistorico").accordion();

//Plugins Ficha de Atendimento
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

$("#condutaNutri").click(function(){
	$("#condutaNutric").toggle();
});
	
$("#dadosAntropometricos").click(function(){
	$("#exibeDadosAntropometricos").toggle();
});

// Alert de Confirmação
$(document)
	.ready(
		function() {
			$('a[data-confirm]')
				.click(
					function(ev) {
						var href = $(this).attr('href');
						if (!$('#dataConfirmModal').length) {
							$('body')
									.append(
											'<div class="modal fade bs-example-modal-sm" id="dataConfirmModal" tabindex="-1" role="dialog" aria-labelledby="dataConfirmLabel" aria-hidden="true"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button><h4 class="modal-title" id="myModalLabel">Por favor, confirme:</h4></div><div class="modal-body"></div><div class="modal-footer"><a class="btn btn-danger" id="dataConfirmOK">Sim</a><button class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button></div></div></div></div>');
						}
						$('#dataConfirmModal').find(
								'.modal-body').text(
								$(this).attr('data-confirm'));
						$('#dataConfirmOK').attr('href', href);
						$('#dataConfirmModal').modal({
							show : true
						});
						return false;
					});
			});

// Passar email "Esqueci Senha"
function passar() {
	var valorA = document.getElementById("email");
	var email = document.getElementById("emailSenha");
	email.value = valorA.value;
};

// Limpar Campos
function LimparCampos() {
	$(":time").each(function() {
		$(this).val("");
	});
	$("select").each(function() {
		$(this).val("Selecione");
	});
}

$(document).ready(function() {
	// Datapicker
	$('#dtNascimento').datepicker({
		setDate : new Date()
	});
	$('#dtValidade').datepicker({
		setDate : new Date()
	});
	//Calendário
	SetMinBlockHeight($('#calendar'));
	DrawFullCalendar();
});

// Vincular Responsável
function abrirModalVinculacao(atleta, pagina) {
	$("#vincularResponsavel").modal();
	$
			.ajax({
				type : "POST",
				url : "SecretariaController?action=buscarResponsaveisVinculacao&idAtleta="
						+ atleta + "&pagina=" + pagina,
				success : function(data) {
					var html = "";
					html += "<br/><label>Selecione um responsavel:</label><br/>";
					$.each(data.listaResponsaveis, function(index, item) {
						html += "<input name='responsavel' value="
								+ item.idPessoa + " type='radio'/>   "
								+ item.nome + "<br/>";
					});
					html += "<input type='hidden' name='idAtleta' value="
							+ data.idAtleta + " />";
					html += "<input type='hidden' name='pagina' value="
							+ data.pagina + " />";
					html += "<br/><label>Grau Parentesco:</label>"
							+ "<select class='form-control' style='width: 95%;' name='grauParentesco' required>";
					html += "<option selected>Selecione</option>";
					$.each(data.grauParentesco, function(index, item) {
						html += "<option value=" + index + ">" + item
								+ "</option>";
					});
					html += "</select>";
					$('.vincular-body p').html(html);
				}
			});
}

function abrirModalUsuario(nome, perfil, email, telefone, celular, cref) {
	var html = "<b>Nome:</b> " + nome + "<br/>";
	html += "<b>Perfil:</b> " + perfil + "<br/>";
	html += "<b>Email:</b> " + email + "<br/>";
	html += "<b>Telefone:</b> " + telefone + "<br/>";
	html += "<b>Celular:</b> " + celular + "<br/>";

	if (cref != null && cref != "")
		html += "CREF: " + cref + "<br/>";
	$('.body-usuario').html(html);
}

function abrirModalAtleta(idAtleta) {
	$("#detalhes").modal();
	$.ajax({
		type : "POST",
		url : "Controller?action=buscarAtletaDetalhes&idAtleta="
				+ idAtleta,
		success : function(data) {
			var sexo = data.listaSexo;
			var html = "";
			if(data.atleta.listaDocumentos[0] != null){
				var srcDocumento = data.atleta.listaDocumentos[0].src;
				var explode = srcDocumento.split(".");
				var extensao = explode[explode.length - 1];
				if(extensao == "jpg" || extensao == "jpeg" || extensao == "png"){
				html += "<img style='float:left; margin: 10px; max-width: 100px; max-height: 100px;' src='" 
					+ srcDocumento + "'> </img><br/>";
				}
			}
			html += "<b>Nome:</b> " + data.atleta.nome + "<br/>";
			html += "<b>Equipe:</b> "
					+ data.equipe[data.atleta.idTpEquipe - 1] + "<br/>";
			html += "<b>Data de nascimento:</b> "
					+ data.atleta.dtNascimentoDisplay + "<br/>";
			html += "<b>Sexo:</b> "
				+ sexo[data.atleta.sexo - 1] + "<br/>";
			html += "<b>Email:</b> " + data.atleta.email + "<br/>";
			html += "<br/><b>Dias de Treino:</b> " + "<br/>";
			var diasSemana = data.diaSemana;
			$.each(data.atleta.listaDiasTreinos, function(index, item) {
				html += diasSemana[item.idDiaSemana - 1] + " - "
						+ item.hrInicioDisplay + " - "
						+ item.hrFimDisplay + "<br/>";
			});
			html += "<br/><b>RG:</b> " + data.atleta.RG + "<br/>";
			html += "<b>CPF:</b> " + data.atleta.CPF + "<br/>";
			html += "<b>N&#186; Matr\u00edcula:</b> " + data.atleta.nrMatricula + "<br/>";
			html += "<b>N&#186; Cadastro CBT:</b> " + data.atleta.nrCadCBT + "<br/>";
			html += "<b>N&#186; Cadastro FTP:</b> " + data.atleta.nrCadFPT + "<br/>";
			html += "<br/><b>Respons\u00e1veis:</b> " + "<br/>";
			var grauParentesco = data.grauParentesco;
				$.each(
						data.atleta.listaResponsaveis,
						function(index, item) {
							html += grauParentesco[item.idGrauParentesco - 1]
							+ " - "
							+ item.nome
							+ " - "
							+ item.celular + "<br/>";
						});
				html += "<br/><b>Contato de Em\u00eargencia:</b> " + "<br/>";
				html += data.grauParentesco[data.atleta.idGrauParentesco - 1]
				+ " - "
				+ data.atleta.nmContatoEmergencia
				+ " - "
				+ data.atleta.telContatoEmergencia + "<br/>";
			$('.body-atleta').html(html);
		}
	});
}

function abrirModalVisualizarResponsavel(idResponsavel, nome, email, telResidencial,
		telComercial, celular, endRes, numeroRes, compRes, bairroRes, estadoRes, 
		cidadeRes, endCom, numeroCom, compCom, bairroCom, estadoCom, cidadeCom) {
	$("#detalhesResp").modal();	
	$.ajax({
		type : "POST",
		url : "SecretariaController?action=buscarAtletasVinculados&idResponsavel="
				+ idResponsavel,
		success : function(data) {
			
			var html = ""
				html += "<b>Nome:</b> " + nome + "<br/>";
			html += "<b>Email:</b> " + email + "<br/>";
			html += "<b>Celular:</b> " + celular + "<br/>";
			html += "<b>Telefone Residencial:</b> " + telResidencial + "<br/>";
			html += "<b>Telefone Comercial:</b> " + telComercial + "<br/>";
			html += "<b>Endereco Residencial:</b> " + endRes + ", " + numeroRes + ", "
			+ compRes + " - " + bairroRes + " - " + cidadeRes + "/" + estadoRes
			+ "<br/>";
			html += "<b>Endereco Comercial:</b> " + endCom + ", " + numeroCom + ", "
			+ compCom + " - " + bairroCom + " - " + cidadeCom + "/" + estadoCom
			+ "<br/><br/>"
			html += "<b>Atleta(s) vinculado(s) ao respons\u00e1vel:</b><br/>";
			
			var grauParentesco = data.grauParentesco;
			if (data.listaAtleta.length <= 0){
				html += "<small>Nenhum atleta vinculado.</small>"
			}else{
				$.each(
					data.listaAtleta,
					function(index, item) {
						html += grauParentesco[item.idGrauParentesco - 1]
								+ " do(a) atleta "
								+ item.nome 
								+ "<br/>";
					});
			}
			$('.body-responsavel').html(html);
		}
	});
}

function abrirModalDadosRef(idCategoria) {
	$("#detalhesDadosRef").modal();	
	$.ajax({
		type : "POST",
		url : "AvaliacaoFisController?action=buscarDadoRef&idCategoria="
				+ idCategoria,
		success : function(data) {
			var sexo = data.listaSexo;
			
			var html = ""
				html += "<b>Categoria:</b> " + data.categoria.nmCategoria + "<br/>";
			html += "<b>Idade m\u00ednima:</b> " + data.categoria.idadeMinima + "<br/>";
			html += "<b>Idade m\u00e1xima:</b> " + data.categoria.idadeMaxima + "<br/>";
			html += "<b>Sexo:</b> " + sexo[data.categoria.sexo - 1] + "<br/><br/>";
			html += "<b>Atividades:</b><br/>";
			if (data.listaCatAtiv.length <= 0){
				html += "<small>Nenhuma atividade física vinculada.</small>"
			}else{
				var unidade = data.listaUnidades;
				html += "<table>" +
						"<tr>" +
						"<th style='padding:5px'>Capacidade</th>" +
						"<th style='padding:5px'>Teste</th>" +
						"<th style='padding:5px'>Medida</th>" +
						"<th style='padding:5px'>Melhorar</th>" +
						"<th style='padding:5px'>M\u00e9dia</th>" +
						"<th style='padding:5px'>Bom</th>" +
						"<th style='padding:5px'>Excelente</th>" +
						"</tr>";
				$.each(
					data.listaCatAtiv,
					function(index, item) {
						html += "<tr>" +
								"<td style='padding:5px'>" + item.AtividadeAvaliacao.capacidade + "</td>";
						html += "<td style='padding:5px'>" + item.AtividadeAvaliacao.teste  + "</td>";
						html += "<td style='padding:5px'>" + unidade[item.AtividadeAvaliacao.idUnidadeDeMedida - 1] + "</td>";
						html += "<td style='padding:5px;text-align: right;'>" + item.melhorar + "</td>";
						html += "<td style='padding:5px;text-align: right;'>" + item.media  + "</td>";
						html += "<td style='padding:5px;text-align: right;'>" + item.bom + "</td>";
						html += "<td style='padding:5px;text-align: right;'>" + item.excelente + "</td>";
						html += "</tr>"
					});
				html += "</table>";
			}
			$('.body-dadosRef').html(html);
		}
	});
}

function abrirModalAvaliacaoFis(idAtleta) {
	$("#avaliacaoFis").modal();	
	$.ajax({
		type : "POST",
		url : "AvaliacaoFisController?action=jspNovaAvaliacao&idAtleta="
				+ idAtleta,
		success : function(data) {
			var caract = data.tpCaracteristica;
			
			var html = "<form class='form-horizontal' role='form' action='AvaliacaoFisController?action=novaAvaliacao&idAtleta=" + idAtleta + "' enctype='multipart/form-data' method='post'>"
			+ "<div class='form-group'>"
			+ "<div class='col-sm-4'>"
			+ "<label for='data' class='text-left'>Data:</label>"
			+ "<input type='date' class='form-control data' id='data' name='data' value='" + data.dataAtual +  "' required/>"
			+ "</div>"
			+ "<div class='col-sm-8'>"
			+ "<label for='caracteristica' class='text-left'>Caracter\u00edstica:</label>"
			+ "<select class='form-control' id='caracteristica' name='caracteristica' required>"
			+ "<option value=''>Selecione</option>";
			$.each(
					caract,
					function(index, item) {
						html += "<option value='" + (index + 1) + "'>" + caract[index] + "</option>";
					});
            html += "</select>"
			+ "</div>"
			+ "</div><br/>";
			
			html += "<b>Atividades:</b><br/>";
			
		if (data.listaAvaResul.length <= 0){
			html += "<small>Nenhuma atividade para avalia\u00e7\u00e3o f\u00edsica equivalente ao sexo e idade cronol\u00f3gica do atleta selecionado.</small><br/><br/>"
		}else{
			html += "<small>Atividades para avalia\u00e7\u00e3o f\u00edsica baseadas no sexo e idade cronol\u00f3gica do atleta selecionado.</small><br/><br/>"
				
			var unidade = data.listaUnidades;
			html += 
					"<div class='form-group col-sm-12'>" + 
					"<table>" +
					"<tr>" +
					"<th style='padding:5px'>Capacidade</th>" +
					"<th style='padding:5px'>Teste</th>" +
					"<th style='padding:5px'>Medida</th>" +
					"<th style='padding:5px'>Desempenho</th>" +
					"</tr>";

			$.each(
				data.listaAvaResul,
				function(index, item) {
					html += "<tr>" +
							"<td style='padding:5px'>" + item.categoriaAtividade.AtividadeAvaliacao.capacidade + "</td>";
					html += "<td style='padding:5px'>" + item.categoriaAtividade.AtividadeAvaliacao.teste  + "</td>";
					html += "<td style='padding:5px'>" + unidade[item.categoriaAtividade.AtividadeAvaliacao.idUnidadeDeMedida - 1] + "</td>";
					html += "<td style='padding:5px'><input type='number' step='any' class='control-label' name='desempenho<c:out value='" + item.categoriaAtividade.idCategoriaAtividade + "'/></td>";
					html += "<input type='hidden' name='idCategoriaAtividade' value='" + item.categoriaAtividade.idCategoriaAtividade + "'/>"
					html += "</tr>"
				});
			html += "</table>" + 
					"</div>";

			html += "<div class='modal-footer'>"
				+ "<button type='submit' class='btn btn-primary'>Salvar</button>"
				+ "<button type='button' class='btn btn-danger' data-dismiss='modal' id='fechar'>Cancelar</button>"
				+ "</div>" + "</form>";
				html += "<b>Atividades:</b><br/>";	
			$('.body-avaliacao').html(html);
			}
		}
	});
}

function registrarPresenca(idAtleta, nomeAtleta) {
	$("#anunciarPresenca").modal();
	var data = new Date().toISOString().split('T');
	$("#dataPresenca").val(data[0]);
	$("#hrPresenca").val("");
	var label = $("#lblNomeAtleta");
	label.html('Confirma que o(a) atleta ' + nomeAtleta + ' esta em consulta?');
	var a = $("#idAtleta")
	a.val(idAtleta);
}

function novoAtendimento(idAtleta, nomeAtleta) {
	var label = $("#lblAtendimento");
	label.html('Novo atendimento ao atleta ' + nomeAtleta + ':');
	var a = $("#idAtletaAtend");
	a.val(idAtleta);
	var b = $("#idProntuario");
	b.val("0");
	$("#novoAtendimento").modal();
}

function passarDadosPront(idAtleta, idProntuario, dtAtendimento, hrAtendimento,
		anotacao) {
	var idAtletaM = document.getElementById("idAtletaAtend");
	idAtletaM.value = idAtleta;
	var idProntuarioM = document.getElementById("idProntuario");
	idProntuarioM.value = idProntuario;
	var dtAtendimentoM = document.getElementById("dtAtendimento");
	dtAtendimentoM.value = dtAtendimento; // Formato yyyy-MM-dd
	var hrAtendimentoM = document.getElementById("hrAtendimento");
	hrAtendimentoM.value = hrAtendimento;
	var anotacaoM = document.getElementById("anotacao");
	anotacaoM.value = anotacao;
};

// Campos de que usam o CKEditor
CKEDITOR.replace('mensagemEmail');
CKEDITOR.replace('recordatorioAlim');
CKEDITOR.replace('condutaNutricional');

function abrirModalAnexarArquivo(idTpDocumento, idPessoa) {
	// Valor que irá aparecer na label
	var strNmDoc;

	switch (idTpDocumento) {
	case 1:
		strNmDoc = "Termo de compromisso do manual do atleta:";
		break;
	case 2:
		strNmDoc = "Declara\u00e7\u00e3o m\u00e9dica:";
		break;
	case 3:
		strNmDoc = "Autoriza\u00e7\u00e3o de viagem e hospedagem:";
		break;
	case 4:
		strNmDoc = "Autoriza\u00e7\u00e3o de imagem:";
		break;
	case 5:
		strNmDoc = "C\u00f3pia do RG:";
		break;
	case 6:
		strNmDoc = "C\u00f3pia do CPF:";
		break;
	case 7:
		strNmDoc = "Foto do atleta:";
		break;
	default:
		strNmDoc = "Valor inv\u00e1lido!";
		break;
	}

	var html = "<form class='form-horizontal' role='form' action='SecretariaController?action=anexarDocumento' enctype='multipart/form-data' method='post'>"
			+ "<input type='hidden' id='idPessoa' name='idPessoa' value='"
			+ idPessoa
			+ "'/>"
			+ "<input type='hidden' id='idTpDocumento' name='idTpDocumento' value='"
			+ idTpDocumento
			+ "'/>"
			+ "<div class='form-group'>"
			+ "<div class='col-sm-8'>"
			+ "<label for='nmArquivo' class='text-left'>"
			+ strNmDoc
			+ "</label>"
			+ "<input type='file' class='form-control text-left' id='arquivo' name='arquivo' required/>"
			+ "</div>"
			+ "<div class='col-sm-4'>"
			+ "<label for='dtValidadeArquivo' class='text-left'>Data de validade:</label>"
			+ "<input type='date' class='form-control data' id='dtValidade' name='dtValidade'/>"
			+ "</div>"
			+ "</div>"
			+ "<div class='modal-footer'>"
			+ "<button type='submit' class='btn btn-primary' id='anexarArquivo'>Anexar Arquivo</button>"
			+ "<button type='button' class='btn' data-dismiss='modal' id='fechar'>Cancelar</button>"
			+ "</div>" + "</form>";

	$('.body-anexarArquivo').html(html);
}

function visualizarDoc(srcDocumento) {
	var explode = srcDocumento.split(".");
	var extensao = explode[explode.length - 1];
	var html = "";
	if (extensao == "doc" || extensao == "docx" || extensao == "xls"
			|| extensao == "xlsx") {
		html += "<b>Formato de arquivo '."
				+ extensao
				+ "' n\u00e3o suportado para visualiza\u00e7\u00e3o online. Download iniciado.</b>";
		html += "<iframe width='100%' frameBorder='0' src='" + srcDocumento
				+ "'> </iframe>";
	} else {
		html += "<iframe width='100%' style='min-height: 500px; max-height: 500px;' frameBorder='0' src='"
				+ srcDocumento + "'> </iframe>";
	}

	$('.body-imgVisualizarDoc').html(html);
}

//Abrir modal editar chamada
function abriModalEditarChamada(estado, id, just, tpChamada, idAtleta){
	$("#modalPresenca").modal();
	var radio = document.getElementsByName("optradio");
	for(i = 0; i< radio.length; i++){
		if(radio[i].value == estado){
			radio[i].checked = true;
		}else{
			radio[i].checked = false;
		}
	}
	var justificativa = $("#justificativaChamada");
	justificativa.val(just);
	var idPresenca = $("#idPresencaJutificativa")
	idPresenca.val(id);
	var tipo = $("#tipoChamada");
	tipo.val(tpChamada);
	var idDiaTreino = $("#idDiaTreino");
	idDiaTreino.val($("#diaTreino").val());
	var dtChamada = $("#dtChamada");
	dtChamada.val($("#dataQuadra").val());
	var atleta = $("#idAtletaModal");
	atleta.val(idAtleta);
}

// Combo Dinamico - Dias de Treino Atleta
function carregaDiasTreino() {
	// document.forms[0].action.value="carregaDiasTreino";
	document.forms[0].action = "SecretariaController?action=carregaDiasTreino";
	document.forms[0].submit();
}

function BuscarChamada(){
	document.forms[0].action = "TecnicoController?action=carregarChamada";
	document.forms[0].submit();
}

function BuscarPresenca(){
	document.forms[0].action = "TecnicoController?action=CarregarChamadaPresenca";
	document.forms[0].submit();
}

function abrirModalObservacao(idAtleta){
	$("#incluirObservacao").modal();
	
	$("#dtValidade").val("");
	$("#message-text").val("");
	$("#idObservacaoModal").val("");
	
	var atleta = $("#idAtletaObs");	
	atleta.val(idAtleta);
	
	var radioGravidade = document.getElementsByName("optGravidade");
	for(i = 0; i< radioGravidade.length; i++){
		radioGravidade[i].checked = false;
	}
	
	var radioCompartilhar = document.getElementsByName("optCompartilhar");
	for(i = 0; i< radioCompartilhar.length; i++){
		radioCompartilhar[i].checked = false;
	}
}

function modalEditarObservacao(idAtleta, dtValidade, gravidade, obs, idObs){
	$("#incluirObservacao").modal();
	var atleta = $("#idAtletaObs");
	atleta.val(idAtleta);
	var validade = $("#dtValidade");
	validade.val(dtValidade);
	var radio = document.getElementsByName("optGravidade");
	for(i = 0; i< radio.length; i++){
		if(radio[i].value == gravidade){
			radio[i].checked = true;
		}
	}
	var radioCompartilhar = document.getElementsByName("optCompartilhar");
	for(i = 0; i< radioCompartilhar.length; i++){
		radioCompartilhar[i].checked = false;
	}
	var observacao = $("#message-text");
	observacao.val(obs);
	var idObservacao = $("#idObservacaoModal");
	idObservacao.val(idObs);
}

function visualizarObservacaoNova(idObs, atleta, grav, obs, val, usu, usuPerfil){
	$.ajax({
		type : "POST",
		url : "Controller?action=salvarVisualizacaoObservacao&idObservacao=" + idObs,
		success : function(data) {
			visualizarObservacao(atleta, grav, obs, val, usu, usuPerfil);
		}
	});
}

function visualizarObservacao(idObs, atleta, grav, obs, val, usu, usuPerfil){
	$("#visualizarObservacao").modal();
	var html = "";
	html += "<b>Atleta: </b>" + atleta;
	html += "<br/><br/><b>Gravidade: </b>" + grav;
	html += "<br/><b>Observa\u00e7\u00e3o: </b>" + obs;
	html += "<br/><b>Data validade: </b>" + val;
	if(usu != null && usu !== ""){
		html += "<br/><br/><b>Registrado por:</b> <br/>";
		html += usu + " - " + usuPerfil;
	}
	
	var buttonFechar = $("#fecharModalObservacao")[0];
	if(idObs != 0){
		buttonFechar.href = "Controller?action=salvarVisualizacaoObservacao&idObservacao=" + idObs; 
	}else{
		//data-dismiss="modal"
		buttonFechar.onclick = function(){ $("#visualizarObservacao").modal('hide'); }
	}
	$("#conteudoModalObs").html(html);
}

function cadastrarBonificacao(idAtleta){
	$("#bonificacaoModal").modal();
	
	var mes = $("#mesBonificacao");
	mes.val($("#mes").val());
	
	var ano = $("#anoBonificacao");
	ano.val($("#ano").val());
	
	var atleta = $("#idAtletaBonificacao");
	atleta.val(idAtleta);
	
	$("#idAvaliacaoBonificacao").val("");
	$("#observacoes").val("");
	$("#torneios").prop("checked", false);
	$("#treinos").prop("checked", false);
	$("#avaliacoes").prop("checked", false);
	$("#rankFPT").val("");
	$("#rankCBT").val("");
	$("#rankITF").val("");
	var radio = document.getElementsByName("optBonificado");
	for(i = 0; i< radio.length; i++){
		if(radio[i].value == 2){
			radio[i].checked = true;
		}
	}
}

function editarBonificacao(idAtleta, idAvaliacao, bonificado, torneios, treinos, avaliacoes, fpt, cbt, itf, obs){
	$("#bonificacaoModal").modal();
	
	var mes = $("#mesBonificacao");
	mes.val($("#mes").val());
	
	var ano = $("#anoBonificacao");
	ano.val($("#ano").val());
	
	var atleta = $("#idAtletaBonificacao");
	atleta.val(idAtleta);
	
	var bonificacao = $("#idAvaliacaoBonificacao");
	bonificacao.val(idAvaliacao);
	
	if(torneios == "true")
		$("#torneios").prop("checked", true);
	else
		$("#torneios").prop("checked", false);
	if(treinos == "true")
		$("#treinos").prop("checked", true);
	else
		$("#treinos").prop("checked", false);
	if(avaliacoes == "true")
		$("#avaliacoes").prop("checked", true);
	else
		$("#avaliacoes").prop("checked", false);
	
	if(fpt != "0")
		$("#rankFPT").val(fpt);
	else
		$("#rankFPT").val("");
	if(cbt != "0")
		$("#rankCBT").val(cbt);
	else
		$("#rankCBT").val("");
	if(itf != "0")
		$("#rankITF").val(itf);
	else
		$("#rankITF").val("");
	
	$("#observacoes").val(obs);
	
	var radio = document.getElementsByName("optBonificado");
	var boni = bonificado == "true" ? 1 : 2; 
	for(i = 0; i< radio.length; i++){
		if(radio[i].value == boni){
			radio[i].checked = true;
		}
	}
}

function desabilitaBotoesTabela(){
	$(".table").find("a").attr("disabled", "disabled");
}

function habilitaBotoesTabela(){
	$(".table").find("a").removeAttr("disabled");
}

function visualizarBonificacao(atleta, bonificado, torneios, treinos, avaliacoes, fpt, cbt, itf, obs){
	$("#visualizarBonificacao").modal();
	$("#tituloModalBonificacao").html(atleta);
	var html = "<b>" + (bonificado == "true" ? "ATLETA BONIFICADO" : "ATLETA N\u00c3O BONIFICADO") + "</b><br/><br/>";
	html += "<b>Torneios:</b> " + (torneios == "true" ? "Sim" : "N\u00e3o") + "<br/>";
	html += "<b>Treinos:</b> " + (treinos == "true" ? "Sim" : "N\u00e3o") + "<br/>";
	html += "<b>Avalia\u00e7\u00f5es:</b> " + (avaliacoes == "true" ? "Sim" : "N\u00e3o") + "<br/>";
	html += "<br/><b>Ranking FPT:</b> " + (fpt == "0" ? "N\u00e3o informado": fpt + "&#186;") + "<br/>";
	html += "<b>Ranking CBT: </b>" + (cbt == "0" ? "N\u00e3o informado": cbt + "&#186;") + "<br/>";
	html += "<b>Ranking ITF: </b>" + (itf == "0" ? "N\u00e3o informado": itf + "&#186;") + "<br/>";
	html += "<br/><b>Observa\u00e7\u00f5es: </b>" + obs;
	$("#conteudoModalBonificacao").html(html);
}


// $('#selectInicio').on('change', function () {
// var url = this.value.toString();
// $(window.document.location).attr('href',url);
// });
//			
// $('.mostrarProgresso').click(function() {
// $('#progress').css("display", "block");
// });
// $('#fechar').click(function() {
// $('#progress').css("display", "none");
// });
//

//
// $("#objetivoConsulta").click(function(){
// $("#exibeObjetivoConsulta").toggle();
// });
//
// $("#praticaAtividade").click(function(){
// $("#exibePraticaAtividade").toggle();
// });
//
// $("#avaliacaoDietetica").click(function(){
// $("#exibeAvaliacaoDietetica").toggle();
// });
//
// $("#recordatorioAlimentar").click(function(){
// $("#exibeRecordatorio").toggle();
// });
//	
// $("#dadosAntropometricos").click(function(){
// $("#exideDadosAntropometricos").toggle();
// });
//
// $("#selectModelos").click(function(){
// $("descricaoModelo").css("display", "block");
// });
