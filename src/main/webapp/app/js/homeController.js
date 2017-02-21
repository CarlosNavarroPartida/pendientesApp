function deletePendiente(idPendiente){
	
    if(confirm('¿Esta seguro de borrar este pendiente?')){
        var url = 'delete/'+idPendiente;
        window.location.href = url;
    }
}

function formHide(){
	$("#pendienteForm").hide(500);
	$("#btnShow").show();
	$("#btnHide").hide();
	$("#logoFamsa").show(300);
}

function formShow(){
	$("#pendienteForm").show(500);
	$("#btnShow").hide();
	$("#btnHide").show();
	$("#logoFamsa").hide(300);
}

$(document).ready(function(){
	var pathname = window.location.pathname; // Returns path only
	
	if(pathname == "/Pendiente/index"){
		$("#pendienteForm").hide();
		$("#btnHide").hide();
	}else{
		$("#btnShow").hide();
		$("#logoFamsa").hide(300);
	}
	
});