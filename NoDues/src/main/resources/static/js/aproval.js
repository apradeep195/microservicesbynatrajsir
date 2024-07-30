
function submitFormWithPage(){
	  document.getElementById("admin-form").submit();
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
		
	document.getElementById('admin-form').submit();

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
	
	console.log(pageNo +" "+pageNoValue+" "+vacancyId);
	
	
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
		nextBtn.classList.remove('btn-outline-dark');
		nextBtn.classList.add('btn-outline-secondary');
		nextBtn.classList.add('disabled');
		nextBtn.classList.remove
	}
	
	//window.scrollTo(0, document.body.scrollHeight);
	
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
			element.className="btn btn-outline-dark";
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

function updateApprove(rowid,applicantId,index){
	
	var url="/bas/join/approve/"+rowid;
			
	$.ajax({
    type : "GET",
    url : url,
    timeout : 100000,
    success : function(data) {
	  document.getElementById("admin-form").submit();
      //console.log("SUCCESS: ", data);	
 
    },
    error : function(e) {
      console.log("ERROR: ", e);
    },
    done : function(e) {
      console.log("DONE");
    }
  });	
}


function updateDisApprove(rowid,applicantId){
	
	var url="/bas/join/disapprove/"+rowid;
			
	$.ajax({
    type : "GET",
    url : url,
    timeout : 100000,
    success : function(data) {
	  document.getElementById("admin-form").submit();
      //console.log("SUCCESS: ", data);	

    },
    error : function(e) {
      console.log("ERROR: ", e);
    },
    done : function(e) {
      console.log("DONE");
    }
  });	
}

function toggleEditableFields(index , isOpen){
	
	var admnEdit = document.getElementById("admnEdit"+index);
	var admnSave = document.getElementById("admnSave"+index);
	var admnCancel = document.getElementById("admnCancel"+index);
	
	var joinDt  = document.getElementById("joinDt"+index);
	var ecno  = document.getElementById("ecno"+index);
	var esicNo  = document.getElementById("esicNo"+index);
	var pfNo  = document.getElementById("pfNo"+index);
	var ifp  = document.getElementById("ifp"+index);
	
 if(isOpen)
	{
		joinDt.disabled=false;
		ecno.disabled=false;
		esicNo.disabled=false;
		pfNo.disabled=false;
		ifp.disabled=false;
	}
	else
	 {
		joinDt.disabled=true;
		ecno.disabled=true;
		esicNo.disabled=true;
		pfNo.disabled=true;
		ifp.disabled=true;
    }
    admnEdit.classList.toggle("d-none");
    admnSave.classList.toggle("d-none");
    admnCancel.classList.toggle("d-none");
	
}

function isEmpty(index){
	var joinDt  = document.getElementById("joinDt"+index);
	var ecno  = document.getElementById("ecno"+index);
	var esicNo  = document.getElementById("esicNo"+index);
	var pfNo  = document.getElementById("pfNo"+index);
	var ifp  = document.getElementById("ifp"+index);
	
	var flag=false;
	
	if(joinDt.value=="")
	{ 
		joinDt.style.border="1px solid #bf9f62";
		flag=true;
	}

   if(ecno.value=="")
		{ 
		ecno.style.border="1px solid #bf9f62";
		flag=true;
	}
	
	if(esicNo.value=="")
	 	{ 
		esicNo.style.border="1px solid red";
		flag=true;
	}  	    
	
	if(pfNo.value=="")
	  	{ 
		pfNo.style.border="1px solid #bf9f62";
		flag=true;
	}
	
	if(ifp.value=="")
		{ 
		ifp.style.border="1px solid #bf9f62";
		flag=true;
	}
	if(flag)
	   return false;
	else
	  return true;   
}


function getRowJson(rowid,roundId,index){
	
	var joinDt  = document.getElementById("joinDt"+index);
	var ecno  = document.getElementById("ecno"+index);
	var esicNo  = document.getElementById("esicNo"+index);
	var pfNo  = document.getElementById("pfNo"+index);
	var ifp  = document.getElementById("ifp"+index);
	
	var rowJson={
		id:rowid,
		roundId:roundId,
		ecNo:ecno.value,
	    esicNo:esicNo.value,
	   joiningDate:joinDt.value,
	   pfNo:pfNo.value,
	   isFacePunched:ifp.value
	   
	}
	console.log("Generated JSON "+JSON.stringify(rowJson));
	return rowJson;
}




function updateDetails(rowid,roundid,index){
	
	var flag= isEmpty(index);
	var requestBody;
	if(!flag)
	     return false;

   requestBody=getRowJson(rowid,roundid,index);
  
	    	
	var url="/bas/join/update";	
	
	$.ajax({
    type : "POST",
    contentType : "application/json",
    url : url,
    data : JSON.stringify(requestBody),
    dataType : 'json',
    timeout : 100000,
    success : function(data) {
	  document.getElementById("admin-form").submit(); 
    },
    error : function(e) {
      console.log("ERROR: ", e);
    },
    done : function(e) {
      console.log("DONE");
    }
  });
}






















