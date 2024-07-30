$(document).ready(function(){
});

//loading-img

function getVacancyInfo(){
	
	var vacancyId=document.getElementById("vacancyid").value;
	  var sts =  document.getElementById("sts");
	                sts.classList.remove('bg-success');
                    sts.classList.remove('text-white');
	
	if(vacancyId==""){return false;}
		document.getElementById("loading-img").style.visibility = 'visible';	
	ajaxGetInfo(vacancyId);
	
}

function ajaxGetInfo(vacancyId){

console.log("Ajax called "+vacancyId);
var url = "/bas/manpower/info?vacancyId="+vacancyId;

$.ajax({
    type : "GET",
    url : url,
    timeout : 10000,
    success : function(data) {
	  document.getElementById("loading-img").style.visibility = 'hidden';		
      console.log("SUCCESS: ", data);	
    
     if(!data.status){
	   document.getElementById("errorDiv").style.display = 'flex';	
	    document.getElementById("errorText").innerHTML = data.message;		
	       document.getElementById("info-div").style.display = 'none';	
	        document.getElementById("submtBtn").disabled=true;  
    }
    else{
	    document.getElementById("errorDiv").style.display = 'none';	
	    document.getElementById("errorText").innerHTML = data.message;		
	    document.getElementById("info-div").style.display = 'block';	
		putData(data.data);
      }
    },
    error : function(e) {
	document.getElementById("loading-img").style.visibility = 'hidden';	
	document.getElementById("errorDiv").style.display = 'flex';	
	document.getElementById("errorText").innerHTML = "Internal Server Error!!";		
     console.log("ERROR: ", e);    		
    },
   done : function(e) {
      console.log("DONE");
    }
  });
}

function putData(data){
  var vacancyId =  document.getElementById("vacancyId");
  var jobProfile =  document.getElementById("jobProfile");
  var reqDate =  document.getElementById("reqDate");
  var acadMicQuali =  document.getElementById("acadMicQuali");
  var expRer  =  document.getElementById("expRer");
  var sts =  document.getElementById("sts");
 
 var submtBtn=document.getElementById("submtBtn");
		 vacancyId.innerHTML=data.reqNo  ;
		 jobProfile.innerHTML=data.jobProfile  ;
		 reqDate.innerHTML=data.requestedDate;
		 acadMicQuali.innerHTML=data.acadQualification;
		 expRer.innerHTML=data.expRequired;
	     sts .innerHTML=data.state  ;
	     
	     //Submitted Approved Confirmed Modify	     
	     if(data.state=='Approved')
           {
	                sts.classList.add('bg-success');
                    sts.classList.add('text-white');
                    submtBtn.disabled=false;
           }
           else{
	              sts.classList.add('bg-primary');
                  sts.classList.add('text-white');
                  submtBtn.disabled=true;
            }
	}
function generateDefaultId(){
	
       document.getElementById("vacancyid").value= "90001";
       document.getElementById("submtBtn").disabled=false;  
       
    }