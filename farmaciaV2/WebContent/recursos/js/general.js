function openCloseHelp() {
	var helpdisplay = document.getElementById('info_help').style.display;
	if ((helpdisplay == '') || (helpdisplay == 'none')) {
		document.getElementById('info_help').style.display = 'block';
	} else {
		document.getElementById('info_help').style.display = 'none';
	}
}

function closeId(id) {
	document.getElementById(id).style.display = 'none';
}

PrimeFaces.locales['pt'] = {
	closeText : 'Fechar',
	prevText : 'Anterior',
	nextText : 'Pr�ximo',
	currentText : 'Come�o',
//	showOn: "button",
//  buttonImage: "../../recursos/imagens/calendario.png",
//  buttonImageOnly: true,
	monthNames : [ 'Janeiro', 'Fevereiro', 'Mar&ccedil;o', 'Abril', 'Maio', 'Junho',
			'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro' ],
	monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago',
			'Set', 'Out', 'Nov', 'Dez' ],
	dayNames : [ 'Domingo', 'Segunda', 'Ter�a', 'Quarta', 'Quinta', 'Sexta',
			'S�bado' ],
	dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'S�b' ],
	dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S' ],
	weekHeader : 'Semana',
	firstDay : 1,
	isRTL : false,
	showMonthAfterYear : false,
	yearSuffix : '',
	timeOnlyTitle : 'S� Horas',
	timeText : 'Tempo',
	hourText : 'Hora',
	minuteText : 'Minuto',
	secondText : 'Segundo',
	currentText : 'Data Atual',
	ampm : false,
	month : 'M�s',
	week : 'Semana',
	day : 'Dia',
	allDayText : 'Todo Dia'
};

$('input[maxlength][tabindex]').on('keyup', function() {
    var $this = $(this);
    if ($this.val().length == $this.attr('maxlength')) {
        $("input[maxlength][tabindex='" + (parseInt($this.attr('tabindex')) + 1) + "']").focus();
    }
});

function mascara(o, f) {
	v_obj = o;
	v_fun = f;
	setTimeout("execmascara()", 1);
}

function execmascara() {
	v_obj.value = v_fun(v_obj.value);
}

function valor(v) {
	v = v.replace(/\D/g, "");
	v = v.replace(/[0-9]{20}/, "invalido");
	v = v.replace(/(\d{1})(\d{14})$/, "$1.$2"); // coloca ponto antes dos
	// �ltimos 11 digitos	
	v = v.replace(/(\d{1})(\d{11})$/, "$1.$2"); // coloca ponto antes dos
	// �ltimos 11 digitos
	v = v.replace(/(\d{1})(\d{8})$/, "$1.$2"); // coloca ponto antes dos
	// �ltimos 8 digitos
	v = v.replace(/(\d{1})(\d{5})$/, "$1.$2"); // coloca ponto antes dos
	// �ltimos 5 digitos
	v = v.replace(/(\d{1})(\d{1,2})$/, "$1,$2"); // coloca virgula antes dos
	// �ltimos 2 digitos
	return v;
} 

function verificarColar()
{
	var ctrl=window.event.ctrlKey;
	var tecla=window.event.keyCode;
	//Ctrl + V
	if (ctrl && tecla==86) {
		event.keyCode=0; 
		event.returnValue=false;
	}
}

function verificarArrastar(element)
{
	alert(window.event);
	alert(window.event.keyCode);
	alert(element.value);
	
}

//$(".bloqueiaColar").live('copy paste cut drag drop', function (e) {
//	e.preventDefault();
//});

$(document).ready(function() {
	$(function() {
	    $( ".datapicker" ).datepicker({
	        showOn: "button",
	        buttonImage: "../recursos/imagens/calendario.png",
	        buttonImageOnly: true,
	        closeText : 'Fechar',
		  	prevText : 'Anterior',
		  	nextText : 'Pr�ximo',
		  	currentText : 'Come�o',
		  	monthNames : [ 'Janeiro', 'Fevereiro', 'Mar&ccedil;o', 'Abril', 'Maio', 'Junho',
		  			'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro' ],
		  	monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago',
		  			'Set', 'Out', 'Nov', 'Dez' ],
		  	dayNames : [ 'Domingo', 'Segunda', 'Ter�a', 'Quarta', 'Quinta', 'Sexta',
		  			'S�bado' ],
		  	dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'S�b' ],
		  	dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S' ],
		  	weekHeader : 'Semana',
		  	firstDay : 1,
		  	isRTL : false,
		  	showMonthAfterYear : false,
		  	yearSuffix : '',
		  	timeOnlyTitle : 'S� Horas',
		  	timeText : 'Tempo',
		  	hourText : 'Hora',
		  	minuteText : 'Minuto',
		  	secondText : 'Segundo',
		  	currentText : 'Data Atual',
		  	ampm : false,
		  	month : 'M�s',
		  	week : 'Semana',
		  	day : 'Dia',
		  	allDayText : 'Todo Dia'
		  
	    });
	  });
});

//var $ = jQuery;
//$(document).ready(function() {
//    $("input[id*='Date']").mask('99/99/9999');
//});

function exibeLoad(){
	$("#loadGeral").css({"display" : "block"});
}

function marcarCampo(idCampo){
	var campo = $(PrimeFaces.escapeClientId(idCampo));
	if(campo.parents('.form-group').length) {
		campo.parents('.form-group').addClass('has-error');
	} else {
		campo.addClass('has-error');
	}
}

function desmarcarCampo(idCampo){
	var campo = $(PrimeFaces.escapeClientId(idCampo));
	if(campo.parents('.form-group').length) {
		campo.parents('.form-group').removeClass('has-error');
	} else {
		campo.removeClass('has-error');
	}
}

function exibirMsgErro(idMsg, msgErro){
	$('#'+idMsg).prepend("<div id='nomeDiv' class='ui-messages-error ui-corner-all'>" +
			"<span class='ui-messages-error-icon'>" +
			"</span><ul><span class='ui-messages-error-detail'>"+
			msgErro+
			"</span></ul></div>");
}

function exibirMsgSucesso(idMsg, msgErro){
	$('#'+idMsg).prepend("<div id='nomeDiv' class='ui-messages-info ui-corner-all'>" +
			"<span class='ui-messages-info-icon'>" +
			"</span><ul><span class='ui-messages-info-detail'>"+
			msgErro+
	"</span></ul></div>");
}

function limparDiv(idMsg){
	$('#'+idMsg).remove();
}

function colocaFocoCampo(campo){
	$(PrimeFaces.escapeClientId(campo)).focus();
}

function validaTabelaHabAdvogado(){
	if($(PrimeFaces.escapeClientId('form-confirmar:confirmar')).length > 0){
		if($(PrimeFaces.escapeClientId('formPartes:tabelaPassivo tbody tr td')).html() != "Lista Vazia."){
			if((!($(PrimeFaces.escapeClientId('formDataTables:btn-consultar-adv')).length > 0)) && (!($(PrimeFaces.escapeClientId('formDataTables:btn-consultar-adv_1')).length > 0))){
				throw new Exception();											
			}
		}
	}
}

function executeClickButton(){
	$(PrimeFaces.escapeClientId('tabViewCargaRemessa:commandButtonDownloadIndividual')).click();
}

function habilitarDesabilitarTabela(){
	if($(PrimeFaces.escapeClientId('form_incluir:tabela tbody tr td')).html() == "Lista Vazia."){
		$(PrimeFaces.escapeClientId('form_incluir:tabela')).css('display','none');
		$(PrimeFaces.escapeClientId('form_incluir:btIncluir')).css('display','none');
		$(PrimeFaces.escapeClientId('form_incluir:btCancelar')).css('display','none');
	}else{
		$(PrimeFaces.escapeClientId('form_incluir:tabela')).css('display','block');
		$(PrimeFaces.escapeClientId('form_incluir:btIncluir')).css('display','inline-block');
		$(PrimeFaces.escapeClientId('form_incluir:btCancelar')).css('display','inline-block');
	}
}

function executeClickButtonJs(idCampoBotao){
	$(PrimeFaces.escapeClientId(idCampoBotao)).click();
}

function trataEnter(e) {
    var keycode;
    if (window.event) keycode = window.event.keyCode;
    else if (e) keycode = (e.keyCode ? e.keyCode : e.which);
    else return true;

    if (keycode == 13) {
        if (window.previousKeyCode) {
            // down=40,up=38,pgdn=34,pgup=33
            if (window.previousKeyCode == 33 || window.previousKeyCode == 34 ||
                window.previousKeyCode == 39 || window.previousKeyCode == 40) {
                    window.previousKeyCode = keycode;
                    return true;
            }
        }
        return false;
    } else {
        window.previousKeyCode = keycode;
        return true;
    }
}

function colocaFocoErro(){
	$( "input, select" ).each(function() {
		if($( this ).hasClass('has-error')){
			$( this ).focus();
			return false;
		}
	});
}
