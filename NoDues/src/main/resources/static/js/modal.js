
function showLogoutModal(){
	showModal("logout-modal");
}

function logout(){
	 window.location="/bas/logout";
}

function showModal(id){
	$("#"+id).modal('show');
}

function candidatesSaved(value,isReload,isFailed){
	
	var old_element = document.getElementById("template-btn");
    var new_element = old_element.cloneNode(true);
    old_element.parentNode.replaceChild(new_element, old_element);
	
	if(isFailed)
	{
		document.getElementById("template-btn").classList.remove('btn-success');
		document.getElementById("template-btn").classList.add('btn-danger');
	}
	else{
		if (!document.getElementById("template-btn").classList.contains('btn-success') )
                           	document.getElementById("template-btn").classList.add('btn-success');
	}
	
	document.getElementById("template-modal-title").innerHTML=value;
	if(isReload){
		const element = document.getElementById("template-btn");
        element.addEventListener("click", function() {
            location.reload();
         });	
	}
	showTemplateModal();
}


function showTemplateModal(){
	$('#template-modal').modal('show');
}