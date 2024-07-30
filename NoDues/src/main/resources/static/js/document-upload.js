var formData=new FormData();
var selectedIndex=[];
function populateFileArray(index,count){


    var grd  = document.getElementById("grd"+index);
    var  grdDetails = document.getElementById("grdDetails"+index);
    var file  = document.getElementById("file"+index);

    formData.append("documents[" + count+ "].file", file.files[0]);
    formData.append("documents["+ count+ "].graduationCode", grd.value);
    formData.append("documents["+ count+ "].branchCode", grdDetails.value);

    for(var pair  of formData.entries()){
        console.log(" "+pair[0]+" , "+pair[1])
    }

}
function isFileSelected(selfE,index){
	
          const fsize = selfE.files[0].size;
          const file = Math.round((fsize / 1024));
                // The size of the file.
           if (file >= 8192) {
                      showErrorModal("Error Occured","Unfortunate!! Please Make sure you are not uploading files larger then 8 mb.");
                      selfE.files=null;
                      document.getElementById("filelbl"+index).className="btn btn-dark upbtn";
                     document.getElementById("sbmitAll").className="btn btn-dark upbtn";
                     var lbl=document.getElementById("filesm"+index);
                     lbl.className="m-0 p-0 d-none h-small";
                     lbl.innerText="";
                      return false;
          } 
        
     document.getElementById("filelbl"+index).className="btn btn-success upbtn";
     document.getElementById("sbmitAll").className="btn btn-success upbtn";
     var lbl=document.getElementById("filesm"+index);
     lbl.className="m-0 p-0 d-block h-small";
     lbl.innerText=selfE.files[0].name
     selectedIndex.push(index);
}
function submitAllDocuments(){
	
    formData=new FormData();
	
	var count=0;
  if(selectedIndex.length>0){
    selectedIndex.forEach(function(s){
        console.log(s);
        populateFileArray(s,count);
        count++;
    });
    return false;
  }
  else{
	return true;
}
}
    function showHeading(selfE,index){
        var gradhead=document.getElementById("gradhead"+index);
        if(selfE.value!=""){
            gradhead.className="font-weight-bold text-success";
            gradhead.innerText=selfE.options[selfE.selectedIndex].text;
        }
        else{
		    gradhead.className="font-weight-bold"
            gradhead.innerText="Select";
        }
    }

    function openFileDialog(index){
        var flag=false;
        var grdDetails=document.getElementById("grdDetails"+index);
        var grd=document.getElementById("grd"+index);
         
        if(grdDetails.value==""){
            grdDetails.style.border="1px solid #bf9f62";
            flag=true;
        }
        if(grd.value==""){
            grd.style.border="1px solid #bf9f62";
            flag=true;
        }
        if(!flag){
            $("#file"+index).trigger('click');
        }
    }
    
    function saveAllDocuments(applicantId){
	
	var isIndexZero= submitAllDocuments();
	if(isIndexZero)
	     {
		showErrorModal("Warning","Please select atleast one document");
		return false;
	}
	       
	/*    var isOk = true;   
	     $('input[type=file][data-max-size]').each(function(){
            if(typeof this.files[0] !== 'undefined'){
                var maxSize = parseInt($(this).attr('max-size'),10),
                size = this.files[0].size;
                   console.log("MAx Size "+maxSize+" SIZE "+size);
                isOk = maxSize > size;
            }
        });
	      console.log("FORM DATA "+formData);
	      alert(isOk);
	  if(!isOk){
		showErrorModal("Error Occured","Unfortunate!! Please Make sure you are not uploading files larger then 8 mb.");
		return false;
	   }     */
	       
	 //formData.append("roundId",roundId);
	 formData.append("applicantId",applicantId);

     var url="/bas/documents/save";
     
    for(var pair  of formData.entries()){
        console.log(" "+pair[0]+" , "+pair[1])
    }

showLoader(true);

  $.ajax({
    type : "POST",
    url : url,
    data : formData,
    processData: false,
    contentType:false,
    timeout : 100000,
    success : function(data) {
      console.log("SUCCESS: ", JSON.stringify(data));	
      showLoader(false);
      if(!data.status)
      {
	     showErrorModal("Error Occured",data.message,function(){
		 location.reload();
		 formData=new FormData();
	  });
     	console.log(data.message);
      } 
      else
      {
	        formData=new FormData();
	       document.getElementById("admr").classList.toggle("d-none");
	       showErrorModal("Message",data.message,function(){
		  refreshLabelsFiles()
		 formData=new FormData();
	  });
      }
    },
    error : function(e) {
	   showLoader(false);
      console.log("ERROR: ", e);
       formData=new FormData();
        showErrorModal("Error Occured","Unfortunate!! Please Make sure you are not uploading files larger then 8 mb.",function(){
		 location.reload();
	});
    },
    done : function(e) {
      console.log("DONE");
      }
    });//Ajax Call		
  }
  
  function showErrorModal(title,message,functionBody){
	$("#errorModalCenterTitle").text(title);
	$("#errorModalMessage").text(message); 
	$('#errorModalCenter').modal('show'); 
	
    $("#errorModalCenterCloseBtn").on('click',functionBody);
  
    }
    
    function changeSelfBorder(selfObj){
	    selfObj.style.border="";
}

function refreshLabelsFiles(){
	
	  selectedIndex.forEach(function(indx){
		  document.getElementById("file"+indx).value="";
		 document.getElementById("file"+indx).files[0]=null;
	    document.getElementById("filelbl"+indx).className="btn btn-dark upbtn";
        document.getElementById("sbmitAll").className="btn btn-dark upbtn";
        var lbl=document.getElementById("filesm"+indx);
        lbl.className="m-0 p-0 d-none h-small";
        lbl.innerText="";
	});
		
	selectedIndex=[];
}

  function showLoader(flag){
        if(flag){
            document.getElementById("loaderDiv").classList.remove("d-none");
             document.getElementById("loaderDiv").classList.add("d-flex");
        }
        else{
               document.getElementById("loaderDiv").classList.remove("d-flex");
            document.getElementById("loaderDiv").classList.add("d-none");
        }
         document.getElementById("container2").classList.toggle("d-none");
    }

    

     