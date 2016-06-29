
$('#btnReloadPlanetas').click(function(event){
	
	reloadPlanetas();
	
});

function reloadPlanetas(){
	
	//Requisita a URL de forma assíncrona.
	
	$.getJSON('/api/planetas', function(data){
		for(var i=0; i<data.length;i++){
			console.log(data[i].nome);
		}
	});
}

function validaSenha(){ 
    if (document.getElementById('password') != document.getElementById('password2').value) {
    input.setCustomValidity('Repita a senha corretamente');
  } else {
    input.setCustomValidity('');
  }
} 