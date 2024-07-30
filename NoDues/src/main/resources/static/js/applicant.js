function submitDocumentForm(){
    
    var flag=false;
   var aadharNo=document.getElementById("aadharNo");
   var contactNo=document.getElementById("contactNo");
if(aadharNo.value=="")
{
    aadharNo.style.border="1px solid red"; 
    flag=true;
}
if(contactNo.value=="")
{
    contactNo.style.border="1px solid red"; 
    flag=true;
}
   if(flag)
       return false;
    else{
        document.getElementById("applicant-srch-form").submit();
    }
}

    
    function changeSelfBorder(selfObj){
	    selfObj.style.border="";
}