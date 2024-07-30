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

function submitFormWithPage(){
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
		/*	element.classList.remove('btn-outline-dark')
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

function statusChange(jsonObj){
 
   var url="/bas/round/status/change";

   console.log("Obj to be passed "+jsonObj);
$.ajax({
    type : "POST",
    contentType : "application/json",
    url : url,
    data : JSON.stringify(jsonObj),
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


function showEditableFields(index,selfObj){
	
	displayEditableRowsOfIndex(index,true);
	selfObj.style.display="none";
	

	   var cancelBtn=document.getElementById('cancelBtn'+index);
	   cancelBtn.style.display="inline";
				
	if(selfObj.value=='modify'){
			document.getElementById("status"+index).disabled=true;
	
			var sveBtn=document.getElementById('sveBtn'+index);
		   var modSveBtn=document.getElementById('modSveBtn'+index);
			sveBtn.style.display="none";
			modSveBtn.style.display="inline";
	}
	else{
		 document.getElementById('modBtn'+index).style.display="none";
	}
}

function cancelModidfication(index){
	var cancelBtn=document.getElementById('cancelBtn'+index);
	cancelBtn.style.display="none";
	displayEditableRowsOfIndex(index,false);
}

function displayEditableRowsOfIndex(index,isShow){

	var edtBtn=document.getElementById('edtBtn'+index);
	var modBtn=document.getElementById('modBtn'+index);
	var modSveBtn=document.getElementById('modSveBtn'+index);
	var cancelBtn=document.getElementById('cancelBtn'+index);
	var sveBtn=document.getElementById('sveBtn'+index);
//	var rndTxtA=document.getElementById("roundte"+index);
	var panelte=document.getElementById("panelte"+index);
	var intervdtip=document.getElementById("intervdtip"+index);
	var remrkte=document.getElementById("remrkte"+index);
	var intervdtl=document.getElementById("intervdtl"+index);
	var status=document.getElementById("status"+index);

   var srcName=document.getElementById('srcName'+index);
   var srcType=document.getElementById('srcType'+index);
   var score=document.getElementById('score'+index);


	if(isShow){
		edtBtn.style.display="none";
		modBtn.style.display="none";
		sveBtn.style.display="inline";
		cancelBtn.style.display="inline";
		intervdtl.style.display="none";
	//	rndTxtA.style.display="block";
		panelte.style.display="block";
		panelte.style.border="";
		
		intervdtip.style.display="block";
		intervdtip.style.border="";
		remrkte.style.display="block";
		remrkte.style.border="";
		status.disabled=false;
		
		srcName.disabled=false;
		srcType.disabled=false;
		score.disabled=false;
	}
	else{
		sveBtn.style.display="none";
		modSveBtn.style.display="none";
		cancelBtn.style.display="none";
		edtBtn.style.display="inline";
		modBtn.style.display="inline";
		intervdtl.style.display="block";
		//rndTxtA.style.display="none";
		panelte.style.display="none";
		intervdtip.style.display="none";                
		remrkte.style.display="none";
		status.disabled=true;
		
	    srcName.disabled=true;
	    srcName.style.border="";
	    
	 	srcType.disabled=true;
	 	srcType.style.border="";
	 	
		score.disabled=true;
		score.style.border="";
	}
	

}

function isEmptyForm(index){
	var flag=false;
	var panelte=document.getElementById("panelte"+index);
	var intervdtip=document.getElementById("intervdtip"+index);
	var remrkte=document.getElementById("remrkte"+index);
    var status=document.getElementById("status"+index);
	
	
	
   var srcName=document.getElementById('srcName'+index);
   var srcType=document.getElementById('srcType'+index);
   var score=document.getElementById('score'+index);
	
	if(srcName.value==""){
		srcName.style.border="1px solid #bf9f62";
		flag=true;
	}
	if(srcType.value==""){
		srcType.style.border="1px solid #bf9f62";
		flag=true;
	}
	if(score.value==""){
		score.style.border="1px solid #bf9f62";
		flag=true;
	}
	
	if(panelte.value==""){
		panelte.style.border="1px solid #bf9f62";
		flag=true;
	}
	
	if(intervdtip.value==""){
		intervdtip.style.border="1px solid #bf9f62";
			flag=true;
	}
	
		if(remrkte.value==""){
		remrkte.style.border="1px solid #bf9f62";
			flag=true;
	}
	
		if(status.value==""){
		status.style.border="1px solid #bf9f62";
			flag=true;
	}
	
	return flag;
}


function changeSelfBorder(selfObj){
	    selfObj.style.border="";
}
function saveDetails(index,rowid){
	
 
 var isEmpty=isEmptyForm(index)
 if(isEmpty){
	return false;
}
 
    var jsonobj= getJsonOfRow(index,rowid);
	console.log("retrurn row "+JSON.stringify(jsonobj) );

	//Call Api
	
   var url="/bas/round/status/add";

   console.log("Obj to be passed "+jsonobj);
   $.ajax({
    type : "POST",
    contentType : "application/json",
    url : url,
    data : JSON.stringify(jsonobj),
    dataType : 'json',
    timeout : 100000,
    success : function(data) {
	   
	if(!data.status){
			   showErrorModal("Message",data.message,function(){
			 submitFormWithPage();    
	    });
	}
	else{
		 submitFormWithPage();    
	}
      console.log("SUCCESS: ", data.data);	
    },
    error : function(e) {
      console.log("ERROR: ", e);
      alert(e.message);
    },
    done : function(e) {
      console.log("DONE");
      }
    });//Ajax Call
   
    
	displayEditableRowsOfIndex(index,false);
	setUpdatedJson(jsonobj,index);
	document.getElementById('cancelBtn'+index).style.display="none";
		
}

function modifyDetails(index,rowid){

 var isEmpty=isEmptyForm(index)
 if(isEmpty){
	return false;
}

	 var jsonobj= getJsonOfRow(index,rowid);
	console.log("retrurn row "+JSON.stringify(jsonobj) );

	//Call Api
	
   var url="/bas/round/status/modify";

   console.log("Obj to be passed "+jsonobj);
   $.ajax({
    type : "POST",
    contentType : "application/json",
    url : url,
    data : JSON.stringify(jsonobj),
    dataType : 'json',
    timeout : 100000,
    success : function(data) {
	if(!data.status){
		  // showErrorModal("Message",data.message);
	   showErrorModal("Message",data.message,function(){
			 submitFormWithPage();    
	    });
	}
	else{
		 submitFormWithPage();    
	}
      console.log("SUCCESS: ", data.data);	
    },
    error : function(e) {
      console.log("ERROR: ", e);
    },
    done : function(e) {
      console.log("DONE");
      }
    });//Ajax Call
    
	var modSveBtn=document.getElementById('modSveBtn'+index);
	modSveBtn.style.display="none";
    
	displayEditableRowsOfIndex(index,false);
	setUpdatedJson(jsonobj,index);	
}

function setUpdatedJson(jsonObj,index){

	//var roundl=document.getElementById("roundl"+index);
	var panell=document.getElementById("panell"+index);
	var remrkl=document.getElementById("remrkl"+index);
	var intervdtl=document.getElementById("intervdtl"+index);
    var status=document.getElementById("status"+index);

	//roundl.innerText=jsonObj.round;
	panell.innerText=jsonObj.panel;
	remrkl.innerText=jsonObj.remark;
	

  if(jsonObj.interviewDate!=""){
	 var date=new Date(jsonObj.interviewDate);
	var day=date.getDate();  
     	
     	day=day<10?"0"+day:day;
     	
	var month=date.getMonth()+1;  
	month=month<10?"0"+month:month;
	var year=date.getFullYear(); 
	var fullDateString=day+"-"+month+"-"+year;
	intervdtl.innerText=fullDateString;
   }
   else{
		intervdtl.innerText="";
}
	

	status.value=jsonObj.statusValue;

}


function getJsonOfRow(index,rowid){

//	var rndTxtA=document.getElementById("roundte"+index);
	var panelte=document.getElementById("panelte"+index);
	var intervdtip=document.getElementById("intervdtip"+index);
	var remrkte=document.getElementById("remrkte"+index);
    var status=document.getElementById("status"+index);


   var srcName=document.getElementById('srcName'+index);
   var srcType=document.getElementById('srcType'+index);
   var score=document.getElementById('score'+index);
	

	var JsonObject={
		id:rowid,
		statusValue:status.value,
	   // round:rndTxtA.value,
	    sourceName:srcName.value,
	    sourceType:srcType.value,
	    avgScore:score.value,
		panel:panelte.value,
		remark:remrkte.value,
		interviewDate:intervdtip.value,
	}
	console.log('Obtained Object '+JSON.stringify(JsonObject));

	return JsonObject;

}

function showErrorModal(title,message){
	$("#errorModalCenterTitle").text(title);
	$("#errorModalMessage").text(message);
	$('#errorModalCenter').modal('show'); 
	
}


function showErrorModal(title,message,functionBody){
	$("#errorModalCenterTitle").text(title);
	$("#errorModalMessage").text(message);
	$('#errorModalCenter').modal('show'); 
	$('#errorModalCenterCloseBtn').click(functionBody); 
}

function vacancyInformation(vacancyId,selfElement){
 
if(selfElement.value=="3"){ 
	//Only Run On selected
   var url="/bas/vacancy/information/"+vacancyId;

   $.ajax({
    type : "POST",
    contentType : "application/json",
    url : url,
/*    data : JSON.stringify(jsonObj),
    dataType : 'json',*/
    timeout : 100000,
    success : function(data) {
	  showErrorModal("Message",data.message);
      console.log("SUCCESS: ", data.data);	
    },
    error : function(e) {
      console.log("ERROR: ", e);
      showErrorModal("Message",data.message);
    },
    done : function(e) {
      console.log("DONE");
      }
    });//Ajax Call
    }
    else
		return;
}

