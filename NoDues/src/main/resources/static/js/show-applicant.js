
$(document).ready(function(){
	
	
	var vacancyId=document.getElementById("searchQuery");
		//var vacancyId=document.getElementById("vacancyId");
	
	vacancyId.addEventListener('input',function(){
		console.log('event listner')
		document.getElementById("pageNoLabel").innerHTML ="0";
		document.getElementById("pageno").value=0;
	});
	
	document.getElementById("prevBtn").disabled =true;
	document.getElementById("nxtBtn").disabled =true;
	
	var pageNo=document.getElementById("pageno").value;
	var pageNoValue=document.getElementById("pageno").value;
	var vacancyId=document.getElementById("searchQuery").value;
	
    var pageNumber= pageNo.replace(/\D/g, '');
     if(pageNumber==0)
	 {
		document.getElementById("prevBtn").disabled =true;
		document.getElementById("nxtBtn").disabled =false;
	 }
	 else{
			document.getElementById("prevBtn").disabled =false;
				document.getElementById("nxtBtn").disabled =false;
	}
	if(pageNoValue==""||vacancyId==""){
			document.getElementById("prevBtn").disabled =true;
		document.getElementById("nxtBtn").disabled =true;
	}
	
})

function submitForm(value,frm_id){
	
	console.log("Sumbit form()");
	
	 var pageNo=document.getElementById("pageno").value;
	 
     var pageNumber= pageNo.replace(/\D/g, '');
	 
	 if(pageNumber==0)
		{
			document.getElementById("prevBtn").disabled =true;
			document.getElementById("nxtBtn").disabled =false;
		}
	else
	  {
		document.getElementById("prevBtn").disabled =true;
		document.getElementById("nxtBtn").disabled =true;
   	}
	 	
	  	
	 if(value=="prevBtn")
	   pageNumber--;
	 else if(value=="nxtBtn")
    	pageNumber++;
     else
      console.log("wrong input id"); 	
	
		console.log("Sumbit form() "+pageNumber);
	
	document.getElementById("pageno").value=pageNumber;
		
	document.getElementById(frm_id).submit();

}


