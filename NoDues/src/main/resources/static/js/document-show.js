function updateApprovalStatus(rowId,applicantId,isApproved){

    var url="/bas/documents/status";



   var requestBody={
    docRowId:rowId,
    applicantId:applicantId,
    isApproved:isApproved
}

$.ajax({
type : "POST",
contentType : "application/json",
url : url,
data : JSON.stringify(requestBody),
dataType : 'json',
timeout : 100000,
success : function(data) {
  console.log("SUCCESS: ", data);	
  if(!data.status)
 { showErrorModal("Error Occured",data.message,function(){
    location.reload();
});}
else{
    showErrorModal("Success",data.message,function(){
        location.reload();
    });
}
},
error : function(e) {
  console.log("ERROR: ", e);
  showErrorModal("Error Occured",e.message,function(){
    location.reload();
});
},
done : function(e) {
  console.log("DONE");
  }
});//Ajax Call		
}

function changeCheckedLabel(index){
	console.log("changeCheckedLabel called");
	$('#chklbl'+index).attr('class','text-success');
 	$('#chklbl'+index).html('&#10004;');
}

function showErrorModal(title,message,functionDesc){
	$("#errorModalCenterTitle").text(title);
	$("#errorModalMessage").text(message);
	$('#errorModalCenter').modal('show'); 	
	$('#errorModalCenterCloseBtn').on('click',functionDesc); 
}

