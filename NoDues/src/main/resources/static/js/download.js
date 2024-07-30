$(document).ready(function(){
});

//loading-img

function getVacancyInfo(){
	
	var vacancyId=document.getElementById("vacancyid").value;

	if(vacancyId==""){return false;}

//document.getElementById("loaderImg").style.visibility = 'visible';	

      hideLoaderImge();

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
        $("#loaderImg").css("visibility","hidden")	;
      console.log("SUCCESS: ", data);	
    
     if(!data.status){
        $("#dataTb").prop("class","d-none")
        $("#errortd").prop("class","w-50")
        $("#errorMsg").text(data.message);
        $("#submtBtn").prop('disabled',"true");
    }
    else{
        $("#dataTb").prop("class","")
        $("#errortd").prop("class","d-none")
        $("#submtBtn").prop('disabled',"false");
        //$("#errortd").toggleClass('d-none');
		putData(data.data); 
      }
    },
    error : function(e) {
        $("#dataTb").prop("class","d-none")
        $("#loaderImg").css("visibility","hidden")	;
       $("#errortd").prop("class","w-50")
       $("#errorMsg").text("Internal Server Error");
       $("#submtBtn").prop('disabled',"true"); 		
    },
   done : function(e) {
      console.log("DONE");
    }
  });
}

function putData(data){
  var vacancyId =  document.getElementById("vcnidlbl");
  var dept =  document.getElementById("dept");
  var jobProfile =  document.getElementById("jobProfile");
  var reqDate =  document.getElementById("reqDate");
  var acadMicQuali =  document.getElementById("acadMicQuali");
  var expRer  =  document.getElementById("expRer");
  var sts =  document.getElementById("sts");
 
 var submtBtn=document.getElementById("submtBtn");
         dept.innerText=data.deptName;
		 vacancyId.innerHTML=data.reqNo  ;
		 jobProfile.innerHTML=data.jobProfile  ;
		 reqDate.innerHTML=data.requestedDate;
		 acadMicQuali.innerHTML=data.acadQualification;
		 expRer.innerHTML=data.expRequired;
	     sts .innerHTML=data.state  ;
	     
	     //Submitted Approved Confirmed Modify	     
	     if(data.state=='Approved')
           {
                    sts.classList.add('text-success');
                    submtBtn.disabled=false;
           }
           else{
                  sts.classList.add('text-danger');
                  submtBtn.disabled=true;
            }
	}
function generateDefaultId(){
	
       document.getElementById("vacancyid").value= "90001";
       document.getElementById("submtBtn").disabled=false;
       
         $("#dataTb").prop("class","d-none")
         $("#errortd").prop("class","d-none")  
       
  }
    
document.getElementById('file').onchange = function () {
  $('#rnme1').text('File Name : '+this.files[0].name);
};

function hideLoaderImge(){
	  var visib=$("#loaderImg").css("visibility");
	    if(visib=='hidden')
	         $("#loaderImg").css("visibility",'visible');
}

 
   function showMinusBtn(value){
    document.getElementById("cndtWrp"+value).style.display="block";
         document.getElementById("plus"+value).style.display="none";
      document.getElementById("minus"+value).style.display="block";
}
function showPlusBtn(value){
    document.getElementById("cndtWrp"+value).style.display="none";
    document.getElementById("plus"+value).style.display="block";
    document.getElementById("minus"+value).style.display="none";
}

$(document).ready(function(){

});




