
function submitFormWithPage(){
	  document.getElementById("resume-form").submit();
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
		
	document.getElementById('resume-form').submit();

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

    var dataTableDiv=document.getElementById("data-table-div");
 
    var dataTableDiv=document.getElementById("data-table-div");

    if(!dataTableDiv.classList.contains("show"))
      	  dataTableDiv.classList.add("show");

        document.getElementById("searchQuery").value="";
        document.getElementById("searchBy").value="0";
        document.getElementById("pageno").value="";

    document.getElementById("resume-form").action ="/bas/resume/status/"+value;

  document.getElementById("resume-form").submit();
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



function addToBucket(index,self){

var resumeId=$('#resumeId'+index).val();
var name=$('#resumeName'+index).val();

var url="/bas/schedule/add";

   var requestBody={
        resumeId:resumeId,
        name:name,
   }
   $.ajax({
    type : "POST",
    contentType : "application/json",
    url : url,
    data : JSON.stringify(requestBody),
    dataType : 'json',
    timeout : 100000,
    success : function(data) {
      if(data.status)
      {      
	     $('#vacancyid').prop("disabled",false);
	      addbucketToList(data.data);     
	     self.className="btn btn-success"; 
	     self.innerText='Added';
	      disableButtons(false);
      }      
     else
         showErrorModal("Error ",data.message);
      },
    error : function(e) {
	   showErrorModal(e);
	   console.log("Error "+e);
    },
    done : function(e) {
      console.log("DONE");
      }
    });//Ajax Call		
}

function clearBucket(){
	
	var url="/bas/schedule/clear";

	$.ajax({
    type : "GET",
    url : url,
    timeout : 100000,
    success : function(data) {
      if(data.status)
      {      
	         emptyBucket();
	          $('#sveBkct').prop("disabled",true);
	          $('#defaultBkct').prop("disabled",true);
	          $('#clearBkct').prop("disabled",true);
	         $('#vacancyid').prop("disabled",true);
	         showErrorModal("Success","Scheduling list cleared.",function(){
	      	     location.reload(); 
	     });
	       
      }      
     else
         showErrorModal("Error ",data.message);
      },
    error : function(e) {
	   showErrorModal("Error ",e);
	   console.log("Error "+e);
    },
    done : function(e) {
      console.log("DONE");
      }
    });//Ajax Call		
}

function defaultVacancy(){
	  $('#sveBkct').prop("disabled",false);
	  	  $('#schDate').prop("disabled",false);
	  $('#vacancyid').val("9999");
}

function emptyBucket(){
	$('#bucketlist').html("<label id='emptyId'  class='btn btn-dark m-0  mb-2'>There is no item on the list for now.</label>")
}

function addbucketToList(buckets){
	
	if(buckets==null || buckets.length==0)
	 {
		 emptyBucket();
		 return;
   	}else{
		$('#bucketlist').html("");
    }
   	 for (var i=0; i < buckets.length; i++) {
              	$('#bucketlist').append("<label class='btn btn-dark m-0  mb-2'>"+ buckets[i].name+"</label> &nbsp;");
     }   
     
}

function disableButtons(flag){
	   $('#sveBkct').prop("disabled",flag);
	   $('#clearBkct').prop("disabled",flag);
	     $('#defaultBkct').prop("disabled",flag);
}



function ajaxGetInfo(vacancyId){

console.log("Ajax called "+vacancyId);
var url = "/bas/manpower/info?vacancyId="+vacancyId;

$.ajax({
    type : "GET",
    url : url,
    timeout : 10000,
    success : function(data) {
        $("#loaderImg").css("visibility","hidden")	;
      console.log("SUCCESS: ", data);	
    
     if(!data.status){
	    document.getElementById("sveBkct").disabled=true;
    	document.getElementById('vacancyInfo').style.display="none";
    	document.getElementById('noInfo').style.display="block";
    }
    else{
	console.log(data.status);
       	 document.getElementById('vacancyInfo').style.display="table";
       	 document.getElementById('noInfo').style.display="none";
         putData(data.data);
      }
    },
    error : function(e) {
	
    },
   done : function(e) {
      console.log("DONE");
    }
  });
}

function getVacancyInfo(){
	
	document.getElementById('vacancyInfo').style.display="none";
	var vacancyId=document.getElementById("vacancyid").value;

	if(vacancyId==""){return false;}

//document.getElementById("loaderImg").style.visibility = 'visible';	

hideLoaderImge();

	ajaxGetInfo(vacancyId);
	
}

function hideLoaderImge(){
	  var visib=$("#loaderImg").css("visibility");
	    if(visib=='hidden')
	         $("#loaderImg").css("visibility",'visible');
}


function putData(data){
  var vacancyId =  document.getElementById("vcnidlbl");
  var dept =  document.getElementById("dept");
  var jobProfile =  document.getElementById("jobProfile");
  var reqDate =  document.getElementById("reqDate");
  var acadMicQuali =  document.getElementById("acadMicQuali");
 var expRer  =  document.getElementById("expRer");
  var sts =  document.getElementById("sts");
  var schDate =  document.getElementById("schDate");
 
 var submtBtn=document.getElementById("sveBkct");
         dept.innerText=data.deptName;
		 vacancyId.innerHTML=data.reqNo  ;
		 jobProfile.innerHTML=data.jobProfile  ;
	 reqDate.innerHTML=data.requestedDate;
		 acadMicQuali.innerHTML=data.acadQualification;
	 expRer.innerHTML=data.expRequired;
	     sts .innerHTML=data.state  ;
	     
	     //Submitted Approved Confirmed Modify	     
	     if(data.state==='Approved')
           {
                    sts.className='font-weight-bold text-success';
                    submtBtn.disabled=false;
                    schDate.disabled=false;
           }
           else{
              	 sts.className='font-weight-bold text-danger';
                  submtBtn.disabled=true;
                  schDate.disabled=true;
            }
	}

function confirmSubmission(index){
showErrorModalWithText('Warning','This record with be blacklisted for further processing.','Confirm',function(){
    	 $( "#blklistFrm"+index ).submit();
})
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

function showErrorModalWithText(title,message,btnText,functionDesc){
	$("#errorModalCenterTitle").text(title);
	$("#errorModalMessage").text(message);
		$("#errorModalCenterCloseBtn").text(btnText);
	$('#errorModalCenter').modal('show'); 	
	$('#errorModalCenterCloseBtn').on('click',functionDesc); 
}


function showSimpleModal(title,btnTest,functionDesc){
	
	$("#simpleModalTitle").text(title);
	$("#simpleCloseButton").text(btnTest);
		$('#simpleModal').modal('show'); 
	$("#simpleCloseButton").click(functionDesc);
}
function showSimpleModal(title){
	
    	$("#simpleModalTitle").text(title);
		$('#simpleModal').modal('show'); 
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
