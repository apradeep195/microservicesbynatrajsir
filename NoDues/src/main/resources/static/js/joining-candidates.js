
function submitFormWithPage(){
	  document.getElementById("join-form").submit();
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
		
	document.getElementById('join-form').submit();

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

    document.getElementById("join-form").action ="/bas/join/level/"+value;

  document.getElementById("join-form").submit();
}


  
 function  updateLevels(level,roundId,applicantId){
 
    var url="/bas/join/generate-offer/"+level+"/"+roundId+"/"+applicantId;
    window.location=url;
   /* 
    $.ajax({
    type : "GET",
    url : url,
    timeout : 100000,
    success : function(data) {
      console.log("SUCCESS: ", data.data);	
      document.getElementById("join-form").submit();
    },
    error : function(e) {
      console.log("ERROR: ", e);
      alert(e);
    },
    done : function(e) {
      console.log("DONE");
      }
    });//Ajax Call		*/
    
  }
  
 function getFileName(filename){
  var lastIndex = filename.lastIndexOf("\\");
  if (lastIndex >= 0) {
    filename = filename.substring(lastIndex + 1);
  }
  return filename;
} 

function uploadAdharEvent(index,selfObj){
		changeKYEButton(index);
	console.log("called update Event")
	$('#adharScLbl'+index).text("Selected");
	$('#adharSm'+index).text(getFileName(selfObj.value));
	
	document.getElementById("adharScLbl"+index).classList.replace("btn-secondary","btn-success");
}

function uploadPassEvent(index,selfObj){
	
	changeKYEButton(index);
	
	console.log("called update Event")
	$('#passCopyLbl'+index).text("Selected");
    $('#pasbkSm'+index).text(getFileName(selfObj.value));
	document.getElementById("passCopyLbl"+index).classList.replace("btn-secondary","btn-success");


}
function openEditFieldsKYE(index,flag){
		console.log("called openEditFieldsKYE Event");


 if(flag){
	$('#panNo'+index).prop( "disabled", false );
	$('#bnkNo'+index).prop( "disabled", false );
		$('#ifscCode'+index).prop( "disabled", false );
	$('#passCopy'+index).prop( "disabled", false );
	$('#adharSc'+index).prop( "disabled", false );
	$('#passCopyLbl'+index).prop( "disabled", false );
	$('#adharScLbl'+index).prop( "disabled", false );
	
	$('#passCopy'+index).val("");
	$('#adharSc'+index).val("");
	
	$('#edtKYEBtn'+index).hide();
	$('#svekyeBtn'+index).show();
	$('#cnclKYEBtn'+index).show();
}
else{
		$('#panNo'+index).prop( "disabled", true );
	$('#bnkNo'+index).prop( "disabled", true );
		$('#ifscCode'+index).prop( "disabled", true );
	//$('#'+index).prop( "disabled", true );
	
	$('#passCopy'+index).prop( "disabled", true);
	$('#adharSc'+index).prop( "disabled", true );

	
		$('#passCopyLbl'+index).text("Upload");
	document.getElementById("passCopyLbl"+index).classList.replace("btn-success","btn-secondary");
		$('#adharScLbl'+index).text("Upload");
    document.getElementById("adharScLbl"+index).classList.replace("btn-success","btn-secondary");
	
	$('#edtKYEBtn'+index).show();
	$('#svekyeBtn'+index).hide();
	$('#cnclKYEBtn'+index).hide();

}
	$('#panNo'+index).val( "" );
	$('#bnkNo'+index).val( "" );
	$('#ifscCode'+index).val( "");
	$('#passCopyLbl'+index).toggleClass("disabled");
	$('#adharScLbl'+index).toggleClass("disabled");
	
	 $('#adharSm'+index).text("");
	 $('#pasbkSm'+index).text("");
	 
	 $('#panNo'+index).css("border","");
     $('#bnkNo'+index).css("border","");
     $('#ifscCode'+index).css("border","");
		
		
}

  function bankAccountSanitate(element){
	 var inpValue=element.value;
	
	console.log(inpValue.length);
	
	 if(inpValue.length>20 )
	  {
		inpValue = inpValue.slice(0, -1)
			console.log(inpValue);
	}    element.value=inpValue;
	
	return false;
	
}

function isFormEmpty(index){
var flag=false;
  var panNo=$('#panNo'+index);
 var bnkNo=	$('#bnkNo'+index);
 var ifscCode=	$('#ifscCode'+index);
 var passCopy=	$('#passCopy'+index);
  var pasbkSm=  $('#pasbkSm'+index)
 var adharSc=	$('#adharSc'+index);
 var adharSm=$('#adharSm'+index)
 
	if(panNo.val()==""){
		panNo.css("border","1px solid #bf9f62");
		flag=true;
	}
		
	if(bnkNo.val()==""){
		bnkNo.css("border","1px solid #bf9f62");
		flag=true;
	}
		
	if(ifscCode.val()==""){
		ifscCode.css("border","1px solid #bf9f62");
		flag=true;
	}
		
/*	if(passCopy.val()==""){
		pasbkSm.text("No file selected")
		flag=true;
	}*/
		
/*	if(adharSc.val()==""){
		adharSm.text("No file selected")
		flag=true;
	}*/
	return flag;
}


function saveDetails(index,rowId,roundId){
	
  var isEmpty=isFormEmpty(index);
	if(isEmpty)
	  return false;
	  
  var formData=getFormObject(index,rowId,roundId);
   console.log("Form data ",formData);	
 var url="/bas/join/kye-details"

  $.ajax({
    type : "POST",
    url : url,
    data : formData,
          processData: false,
        contentType: false,
    timeout : 100000,
    success : function(data) {
      console.log("SUCCESS: ", JSON.stringify(data));	
      if(!data.status)
      {
	     showErrorModal("Error Occured",data.message);
     	console.log(data.message);
      } 
      else
      {
	       document.getElementById("join-form").submit();
      }
    },
    error : function(e) {
      console.log("ERROR: ", e);
        alert('Error');
    },
    done : function(e) {
      console.log("DONE");
      }
    });//Ajax Call		

}

function getFormObject(index,rowId,roundId){

 var panNo=	$('#panNo'+index).val();
 var bnkNo=	$('#bnkNo'+index).val();
 var ifscCode=	$('#ifscCode'+index).val();
 var passCopy=	$('#passCopy'+index).prop('files')[0];
 var adharSc=	$('#adharSc'+index).prop('files')[0];
	
	var formData=new FormData();
	formData.append("rowId",rowId);
	formData.append("roundId",roundId);
	formData.append("panNo",panNo);
	formData.append("bankNo",bnkNo);
	formData.append("ifscCode",ifscCode);
	formData.append("passBook",passCopy);
	formData.append("addharCard",adharSc);
	
	return formData;
}

function generateEmpCode(index,roundId,applicantId) {
	
	var division= document.getElementById("division"+index);

	if(division.value==""){
		division.style.border="1px solid #bf9f62";
       return false;
	}

	
 var url="/bas/join/generate-emp-code";
  
  var requestBody={
	division:division.value ,
	roundId:roundId ,
	applicantId:applicantId ,
}
 
  $.ajax({
    type : "POST",
    url : url,
    data:JSON.stringify(requestBody),
    contentType: "application/json",
    timeout : 100000,
    success : function(data) {
      console.log("SUCCESS: ", JSON.stringify(data));	
      if(!data.status)
      {
	     showErrorModal("Message",data.message);
     	console.log(data.message);
      } 
      else
      {
	       showErrorModal("Message",data.message,function(){
		 document.getElementById("join-form").submit();
	});
	      // document.getElementById("join-form").submit();
      }
    },
    error : function(e) {
      console.log("ERROR: ", e);
    },
    done : function(e) {
      console.log("DONE");
      }
    });//Ajax Call		
    
}

   function generateOffer2(index,level,roundid,applicantId)
   {
   
   console.log("UUNOUT "+index+" "+level+" "+roundid+" "+applicantId);
   
     var rptOffice = document.getElementById('rptOffice'+index);
     var plant =document.getElementById('plant'+index);
     
     var isEmpty=false;

     if(rptOffice.value==""){
        rptOffice.style.border="1px solid #bf9f62";
        isEmpty=true;
     }
     if(plant.value==""){
        plant.style.border="1px solid #bf9f62";
        isEmpty=true;
     }
     if(isEmpty){
        //alert("FILL DETAILS");
       return false;
     }
     document.getElementById("offerFrm").submit();
    // window.location.href='/bas/join/generate-offer/'+level+'/'+roundid+'/'+applicantId+'/'+plant.value+'/'+rptOffice.value;
    
     console.log("File download reqyested");
     
  }
 
function showErrorModal(title,message){
	$("#errorModalCenterTitle").text(title);
	$("#errorModalMessage").text(message);
	$('#errorModalCenter').modal('show'); 
	
}

function showErrorModal(title,message,functionDesc){
	$("#errorModalCenterTitle").text(title);
	$("#errorModalMessage").text(message);
	$('#errorModalCenter').modal('show'); 	
	$('#errorModalCenterCloseBtn').on('click',functionDesc); 
}



function showSimpleModal(title,btnTest,functionDesc){
	
	$("#simpleModalTitle").text(title);
	$("#simpleCloseButton").text(btnTest);
		$('#simpleModal').modal('show'); 
	$("#simpleCloseButton").click(functionDesc);
}
function cancelEditDetails(index)
{
	showSimpleModal("Are you sure you want to cancel? You may lose some data."
	                                   ,"Yes"
	                                    ,function(){
		  openEditFieldsKYE(index,false);
		  document.getElementById("svekyeBtn"+index).className="btn btn-dark";
	} );
}

function changeButtonClass(index){
	
	var plant=  document.getElementById("plant"+index);
    var rptOffice =document.getElementById("rptOffice"+index);
    
    if(plant.value!=""&&rptOffice.value!="")   	
	          document.getElementById("gnrtBtn"+index).className="btn btn-success";
	  if(plant.value==""||rptOffice.value=="")   	
	         document.getElementById("gnrtBtn"+index).className="btn btn-dark";  
	          
}
function changeEmpButton(element,index){
	
	if(element.value=="")
	     document.getElementById("redyJoinSBtn"+index).className="btn btn-dark";  
	else
	      document.getElementById("redyJoinSBtn"+index).className="btn btn-success";  
}
function changeKYEButton(index){
	
    var svekyeBtn=  document.getElementById("svekyeBtn"+index);
    var panNo=  document.getElementById("panNo"+index);
    var bnkNo=  document.getElementById("bnkNo"+index);
    var ifscCode=  document.getElementById("ifscCode"+index);
    var passCopy=  document.getElementById("passCopy"+index);
    var adharSc=  document.getElementById("adharSc"+index);
	
	if(panNo.value==""||
	    bnkNo.value==""||
	    ifscCode.value==""||
	    passCopy.value==""||
	    adharSc.value=="")
	{ svekyeBtn.className="btn btn-dark";  }
	else{
		 svekyeBtn.className="btn btn-success"; 
	}
}

function closeApplicant(element){

        console.log(element.value);
  
        $('#exampleModalCenter').modal('hide');
  
}


function changeKYEButtonV2(index){
	changeKYEButton(index);
} 



function openCenterTemp(element,applicantID){
      document.getElementById("center-model-close").value=applicantID;
       document.getElementById("center-model-close").onclick=function(){
	       closeApplicant(element);
     }
      document.getElementById("exampleModalCenterTitle").innerText ='Are you sure you want to put this candidate in *Not Acceptence Category.';
      
      $('#exampleModalCenter').modal('show');
}

/*
function openCenterTemp (element,applicantID,message) {

     $(".modal-footer #model-close").val(applicantID );
      $("#exampleModalCenterTitle").text(message);
      $('#exampleModalCenter').modal('show');
}
*/






