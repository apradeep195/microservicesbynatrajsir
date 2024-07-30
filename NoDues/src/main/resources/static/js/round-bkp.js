function changeHref(btnObj){

    var value=btnObj.value;

    //document.getElementById("status-heading").innerText="CANDIDATES "+btnObj.innerText;
 
    var dataTableDiv=document.getElementById("data-table-div");
 
    var dataTableDiv=document.getElementById("data-table-div");

    if(!dataTableDiv.classList.contains("show"))
      	  dataTableDiv.classList.add("show");

        document.getElementById("searchQuery").value="";
        document.getElementById("searchBy").value="0";
        document.getElementById("pageno").value="";

    document.getElementById("round-form").action ="/bas/round/details/"+value;

  document.getElementById("round-form").submit();
}

function submitForm(value){
	
	console.log("Sumbit form()");
	
	if(value=='search-btn'){
	 var searchBy=document.getElementById("searchBy");
	 if(searchBy.value=="0")
	   {
		searchBy.focus();
		return false;
    	}
	}
	

	
	 var pageNo=document.getElementById("pageno").value;
	 
     var pageNumber= pageNo.replace(/\D/g, '');
	 
	 if(pageNumber==0)
		{
					changeBtnState('prevBtn',true)
							changeBtnState('nxtBtn',false)
	/*		document.getElementById("prevBtn").disabled =true;
			document.getElementById("nxtBtn").disabled =false;*/
		}
	else
	  {
				changeBtnState('prevBtn',true)
				changeBtnState('nxtBtn',true)
	/*	document.getElementById("prevBtn").disabled =true;
		document.getElementById("nxtBtn").disabled =true;*/
   	}
	 	
	  	
	 if(value=="prevBtn")
	   pageNumber--;
	 else if(value=="nxtBtn")
    	pageNumber++;
     else
      console.log("wrong input id"); 	
	
		console.log("Sumbit form() "+pageNumber);
	
	document.getElementById("pageno").value=pageNumber;
		
	document.getElementById('round-form').submit();

}


$(document).ready(function(){
	
	
	var vacancyId=document.getElementById("searchQuery");
		//var vacancyId=document.getElementById("vacancyId");
	
	vacancyId.addEventListener('input',function(){
		console.log('event listner')
		document.getElementById("pageNoLabel").innerHTML ="0";
		document.getElementById("pageno").value=0;
	});
	
	changeBtnState('prevBtn',true)
    changeBtnState('nxtBtn',true)
	
/*	document.getElementById("prevBtn").disabled =true;
	document.getElementById("nxtBtn").disabled =true;*/
	
	var pageNo=document.getElementById("pageNoLabel").innerText;
	var pageNoValue=document.getElementById("pageno").value;
	var vacancyId=document.getElementById("searchQuery").value;
	
    var pageNumber= pageNo.replace(/\D/g, '');
    console.log("PAGENO "+pageNumber);
     if(pageNumber==0 || pageNumber==1)
	 {
		changeBtnState('prevBtn',true)
		changeBtnState("nxtBtn",false)
/*		document.getElementById("prevBtn").disabled =true;
		document.getElementById("nxtBtn").disabled =false;
	 }
	 else if(pageNumber==1){
			changeBtnState('prevBtn',true)
		changeBtnState("nxtBtn",false)
			document.getElementById("prevBtn").disabled =true;
			document.getElementById("nxtBtn").disabled =false;*/
	}
	 else{
			changeBtnState('prevBtn',false)
	        changeBtnState("nxtBtn",false)
		/*	document.getElementById("prevBtn").disabled =false;
			document.getElementById("nxtBtn").disabled =false;*/
	}
	
	var nextBtn=document.getElementById("nxtBtn");
     //alert(nextBtn.disabled);
	if(nextBtn.disabled){
		console.log('ip disabled');
		nextBtn.classList.remove('btn-outline-success');
		nextBtn.classList.add('btn-outline-secondary');
		nextBtn.classList.add('disabled');
		nextBtn.classList.remove
	}
	
	window.scrollTo(0, document.body.scrollHeight);
	
})

function changeBtnState(value,state){
	 var element=document.getElementById(value);
	if(state)
	  {
		element.disabled=true;
		if(value=='prevBtn'){
			element.className="";
			element.className="btn btn-outline-secondary disabled";
			return;
		/*	element.classList.remove('btn-outline-success')
			element.classList.add('btn-outline-secondary')
			element.classList.add('disabled')*/
		}
		  if(!element.classList.contains('disabled')){
			//element.classList.remove('btn-outline-success')
			//element.classList.add('btn-outline-secondary')
			element.classList.add('disabled')
		}
	}
	else{
		
			element.disabled=false;
				if(value=='prevBtn'){
			element.className="";
			element.className="btn btn-outline-success";
			return;
		/*	element.classList.remove('btn-outline-success')
			element.classList.add('btn-outline-secondary')
			element.classList.add('disabled')*/
		}
		
		 if(element.classList.contains('disabled')){
			//element.classList.remove('btn-outline-secondary')
				element.classList.remove('disabled')
			//element.classList.add('btn-outline-success')
		}
		
	}
	
}

function statusChange(value,indexV,obj){

    console.log(value,indexV);
    console.log(obj.value);
 
   var url="/bas/round/status/change";
   
   var requestBody={
	arid:value,
	status:obj.value
   };
   console.log("Obj to be passed "+requestBody);
$.ajax({
    type : "POST",
    contentType : "application/json",
    url : url,
    data : JSON.stringify(requestBody),
    dataType : 'json',
    timeout : 100000,
    success : function(data) {
      console.log("SUCCESS: ", data);	
    },
    error : function(e) {
      console.log("ERROR: ", e);
		     location.reload();
    },
    done : function(e) {
      console.log("DONE");
    }
  });
}

function editableFields(index,selfObj){
	
	document.getElementById("remrkArea"+index).disabled=false;
	document.getElementById("panelArea"+index).disabled=false;
	document.getElementById("round"+index).disabled=false;
	
	this.style.display="none";
	document.getElementById("sveBtn"+index).style.display="block";
	
}
