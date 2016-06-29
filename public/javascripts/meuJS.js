
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


function checkPass()
{

    var pass1 = document.getElementById('password');
    var pass2 = document.getElementById('password2');

    var goodColor = "#66cc66";
    var badColor = "#ff6666";

    if(pass1.value == pass2.value){

        pass2.style.backgroundColor = goodColor;
        pass1.style.backgroundColor = goodColor;
        message.style.color = goodColor;

    }else{

        pass2.style.backgroundColor = badColor;
        pass1.style.backgroundColor = badColor;
        message.style.color = badColor;

    }
} 

function myDropdown() {
	  document.getElementById("dropdown").classList.toggle("show")
}

window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdn-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
} 