
function openEditableFields(index){
    //Buttons
    var sedtBtn = document.getElementById("sedtBtn"+index);
    var ssveBtn = document.getElementById("ssveBtn"+index);
    var scanclBtn = document.getElementById("scanclBtn"+index);
 
    //Buttons
    sedtBtn.style.display="none";
    ssveBtn.style.display="block";
    scanclBtn.style.display="block";

    displaySelectedEditableFields(index,true);

}
function closeEditableFields(index){
    var sedtBtn = document.getElementById("sedtBtn"+index);
    var ssveBtn = document.getElementById("ssveBtn"+index);
    var scanclBtn = document.getElementById("scanclBtn"+index);
 
    //Buttons
    sedtBtn.style.display="block";
    ssveBtn.style.display="none";
    scanclBtn.style.display="none";
    displaySelectedEditableFields(index,false);
}

function displaySelectedEditableFields(index,attribute){
    //Inputs
    var empCodeip = document.getElementById("empCodeip"+index);
    var dojip = document.getElementById("dojip"+index);

    if(attribute){
        empCodeip.disabled=false;
        dojip.disabled=false;
    }
    else{
           empCodeip.disabled=true;
        dojip.disabled=true;
    }

}

function updateCandidateDetails(rowid,applicantId,index){

   var url="/bas/round/selected-candidates/update";

   var empCode=document.getElementById("empCodeip"+index).value;
   var doj=document.getElementById("dojip"+index).value;
 
   if(empCode=="" && doj==""){
       alert("booth empty");
       return false;
   }


   var requestBody={
        id:rowid,
        applicantId:applicantId,
        empCode:empCode,
        doj:doj
   }

   $.ajax({
    type : "POST",
    contentType : "application/json",
    url : url,
    data : JSON.stringify(requestBody),
    dataType : 'json',
    timeout : 100000,
    success : function(data) {
      console.log("SUCCESS: ", data.data);	
      closeEditableFields(index);
    },
    error : function(e) {
      console.log("ERROR: ", e);
    },
    done : function(e) {
      console.log("DONE");
      }
    });//Ajax Call		
}

function openFields(index,flag,clearValues){
	     
	var edtSBtn=document.getElementById('edtSBtn'+index);
	var canclSBtn=document.getElementById('canclSBtn'+index);
	var saveSBtn =document.getElementById('saveSBtn'+index);

	//var dept=  document.getElementById('dept'+index);
	var avgScore=  document.getElementById('avgScore'+index);
	var category=  document.getElementById('category'+index);
	var exptjd=  document.getElementById('exptjd'+index);
	var desg=  document.getElementById('desg'+index);
	var exptCtc=  document.getElementById('exptCtc'+index);
	
	if(flag){
	edtSBtn.classList.add("d-none");
	canclSBtn.classList.remove("d-none");
	saveSBtn.classList.remove("d-none");
	
	//dept.disabled=false;
	avgScore.disabled=false;
	category.disabled=false;
	exptjd.disabled=false;
	exptCtc.disabled=false;
	desg.disabled=false;
	}
	else{

	edtSBtn.classList.remove("d-none");
	canclSBtn.classList.add("d-none");
	saveSBtn.classList.add("d-none");
	
	//dept.disabled=true;
	
	avgScore.disabled=true;
	category.disabled=true;
	exptjd.disabled=true;
	exptCtc.disabled=true;
	desg.disabled=true;
	if(clearValues)
	    {
		//dept.value="";
		avgScore.value="";
	    category.value="";
	    exptjd.value="";
		exptCtc.value="";
		desg.value="";
	}
						
	}
	    //dept.style.border="";
		avgScore.style.border="";
	    category.style.border="";
	    exptjd.style.border="";
		exptCtc.style.border="";
		desg.style.border="";
}
function readySelectedCandidates(rowid,applicantId,index){
	
	var avgScore=  document.getElementById('avgScore'+index);
	var category=  document.getElementById('category'+index);
	var exptjd=  document.getElementById('exptjd'+index);
	var desg=  document.getElementById('desg'+index);
	var exptCtc=  document.getElementById('exptCtc'+index);
	
	var isEmpty=false;
	
  if(avgScore.value==""){
     avgScore.style.border="1px solid #bf9f62"
     isEmpty=true;
} 
  if(category.value==""){
     category.style.border="1px solid #bf9f62"
      isEmpty=true;
}
  if(exptjd.value==""){
     exptjd.style.border="1px solid #bf9f62"
     isEmpty=true;
}
  if(desg.value==""){
     desg.style.border="1px solid #bf9f62"
     isEmpty=true;
}
  if(exptCtc.value==""){
     exptCtc.style.border="1px solid #bf9f62"
     isEmpty=true;
}
 if(isEmpty)
    return false;
    
  var requestBody={
	rowId: rowid,
	applicantId:applicantId,
	avgScore:avgScore.value,
	category:category.value,
	expectedJoiningDate: exptjd.value,
	designation:desg.value,
	expectedCTC:exptCtc.value,
 }  

  console.log("DATA ",requestBody);
    
   var url="/bas/round/selected-candidates/ready";
    
   $.ajax({
    type : "POST",
    contentType : "application/json",
    url : url,
    data : JSON.stringify(requestBody),
    dataType : 'json',
    timeout : 100000,
    success : function(data) {
      console.log("SUCCESS: ", data.data);	
      openFields(index,false,false);
      document.getElementById("redyJoinSBtn"+index).disabled=false;
    },
    error : function(e) {
      console.log("ERROR: ", e);
    },
    done : function(e) {
      console.log("DONE");
      }
    });//Ajax Call		
    
    
    


}
function changeSelfBorder(selfObj){
	    selfObj.style.border="";
}


  function scoreSanitate(element){
	 var inpValue=element.value;
	
	 if(inpValue>10 )
	      element.value=" ";
	 if(inpValue<0 )
	      element.value=" ";     
	
}

function readyToJoin(rowId,applicantId){
	 var url="/bas/join/save/"+rowId+"/"+applicantId;
    
   $.ajax({
     url : url,
     timeout : 100000,
    success : function(data) {
      console.log("SUCCESS: ", JSON.stringify(data));
           console.log(data);
      document.getElementById("round-form").submit();	
    },
    error : function(e) {
      console.log("ERROR: ", e);
    },
    done : function(e) {
      console.log("DONE");
      }
    });//Ajax Call		
	
	
	
	
}
