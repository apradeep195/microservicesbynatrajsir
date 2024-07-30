function editInpuField(){
    $('#updt').css("display",'none');
    $('#error').css("display",'none');

    $('#vcnid').prop("disabled",false);
    $('#edtBtn').css("display",'none');
    $('#svBtn').css("display",'inline'); 
}
function saveVcnId(apcntId){

    $( "#vcnid" ).focus();

   var  oldVacancyID=$('#oldVacancyID').val();
    var  vcnid=$('#vcnid').val();
        
    if(vcnid=="")
     {
	       $('#vcnid').focus();
	       return false;
	 }
	 else if(oldVacancyID==vcnid){
		
		 $('#vcnid').focus();
		 $('#error').text("Same as Old vacancy.");
		 $('#error').css("display",'inline');
	      return false;
	}
	 
	    $('#svBtn').css("display",'none');
	    $('#vcnid').prop("disabled",true);

    ajaxUpdateVacancyId(vcnid,apcntId);

    
    //$('#edtBtn').css("display",'inline');

}
function isUpdated(value){
    $('#vcnid').prop("disabled",true);
    $('#loadImg').css("display",'none');
    $('#svBtn').css("display",'none');
    $('#edtBtn').css("display",'inline');
    if(value){
           $('#updt').css("display",'inline');
           $('#error').css("display",'none');
     }
    else{
        $('#updt').css("display",'none');
        $('#error').css("display",'inline');
    }
}
function ajaxUpdateVacancyId(vcnId2,apcntId2){
  
  $('#loadImg').css("display",'inline');

   console.log("PARAMS ",vcnId2,apcntId2);

    let formData = new FormData();
    formData.append('vcnId', vcnId2);
    formData.append('apcntId', apcntId2);
    
   console.log("FORM  ",formData);
    
    let url='/bas/admin/applicant/edit?vacancyId='+vcnId2+'&applicantId='+apcntId2;
    
    /*    contentType :'application/x-www-form-urlencoded',*/
/*    data:formData,*/

   $.ajax({
    type : "GET",
    url :url,
    timeout : 10000,
    success : function(data) {
      console.log("SUCCESS: ", data);
      if(data.status)
       {  $('#oldVacancyID').val(vcnId2);
           isUpdated(true);
       }
      else  
           isUpdated(false);     
    },
    error : function(e) {
     console.log("ERROR: ", e);    	
     isUpdated(false);	
    },
   done : function(e) {
      console.log("DONE");
    }
  });
}

