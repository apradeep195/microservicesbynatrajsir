var tableCount=1;
var rowcount=1;
var sourceRowCount=1;
 const rmvdRow=[];
 const rmvdSourceRow=[];


 function addMoreSource(){
  var i=sourceRowCount;
  var flag;
   var name=document.getElementById("rnme"+i);
   flag=changeBorder(name);
   var type=document.getElementById("rtype"+i);
   flag=changeBorder(type);
   var typeId=document.getElementById("rtypeid"+i);
   flag=changeBorder(typeId);

   if(flag)
     return !flag;

     sourceRowCount++;

     var addRow="<div class=\"mid\"><table> <tr> <td><label>Name</label></td><td><input  style=\"width:250px\" class=\"form-control\" type=\"text\" id=\"rnme"+sourceRowCount+"\" required></td>   "+
     "<td><label>Type</label></td> <td><select name=\"type\" id=\"rtype"+sourceRowCount+"\"  class=\"form-control so\" style=\"height: 30px;\"> <option value=0>Select Type</option> "+
     "<option value=1>Consultant</option><option value=2>Reference</option></select></td><td><label>Type id</label></td><td><input class=\"form-control\" type=\"text\" id=\"rtypeid"+sourceRowCount+"\" ></td> "+
     "<td class=\"table-tl\"> <button type=\"button\" id=\"rbtn-r"+sourceRowCount+"\" class=\"btn btn-danger\" value=\""+sourceRowCount+"\"  onclick=\"removeSourceRow(this.value)\" >Remove</button>  "+
     "<button type=\"button\" id=\"rbtn-ad"+sourceRowCount+"\" class=\"btn btn-success\" value=\""+sourceRowCount+"\"  style=\"display: none;\"  onclick=\"addSourceRow(this.value)\" >add</button></td> "+
     "</tr></table></div><div id=\"rmtp-div"+sourceRowCount+"\"></div>";
   
     document.getElementById("rmtp-div"+(sourceRowCount-1)).innerHTML +=addRow;
    window.scrollTo(0,document.body.scrollHeight);
 }

 
function removeSourceRow(row){
  console.log("ROW "+row);
  rmvdSourceRow.push(row);
   document.getElementById("rbtn-r"+row).style.display="none";
   document.getElementById("rbtn-ad"+row).style.display="block";
   console.log("REMOVED ARRAY ",rmvdSourceRow);
}

function addSourceRow(row){
  console.log("ROW "+row);
  rmvdSourceRow.pop(row);
  document.getElementById("rbtn-r"+row).style.display="block";
  document.getElementById("rbtn-ad"+row).style.display="none";
  console.log("REMOVED ARRAY ",rmvdSourceRow);
}


var sourceJsonArray=[];

function saveAllSources(){
	
  sourceJsonArray=[];
	
for(let i=1;i<=sourceRowCount;i++){

   if(!rmvdSourceRow.includes(""+i)){

    var flag;
    var name=document.getElementById("rnme"+i);
    flag=changeBorder(name);
    var type=document.getElementById("rtype"+i);
    flag=changeBorder(type);
    var typeId=document.getElementById("rtypeid"+i);
    flag=changeBorder(typeId);

    if(flag)
      return !flag;
      
    if(name.value==""&&type.value=="")
     {
	    alert("Fields can't be empty'");
	    return false;
     }
    var sourceJson={
         name:name.value,
         type:type.value,
         isReference:0,
         typeId:typeId.value,
    }
    //Null before Create Array

    console.log("Source  ",sourceJson);
    sourceJsonArray.push(sourceJson);
  }//if
}//for
ajaxSaveSource();
console.log("Sources ",sourceJsonArray);
}

function ajaxSaveSource(){

  if(sourceJsonArray.length==0){ 
          return false;  }

  var url = "/ams/source/save";

$.ajax({
    type : "POST",
    contentType : "application/json",
    url : url,
    data : JSON.stringify(sourceJsonArray),
    dataType : 'json',
    timeout : 100000,
    success : function(data) {
      console.log("SUCCESS: ", data.message);
   if(!data.status){
					 document.getElementById("lowerErrorDiv").style.display="block";
				     document.getElementById("lowerError").innerHTML=data.message;
				}
				else {
					    document.getElementById("rmtp-div1").innerHTML="";
					 	document.getElementById("cndtWrp2").innerHTML +="";
					    document.getElementById("lowerSuccesDiv").style.display="block";
				        document.getElementById("lowerSucces").innerHTML=data.message;
				        eventListnerToIp();
				}			
    },
    error : function(e) {
   console.log("ERROR: ", e);
		     location.reload();
    		
    },
    done : function(e) {
      console.log("DONE");
    }
  });
}










function addMore(){
  var i=rowcount;
 var flag;
  var vacancyid=document.getElementById("vac"+i);
  flag=changeBorder(vacancyid);
  var name=document.getElementById("nme"+i);
  flag=changeBorder(name);
  var email=document.getElementById("email"+i);
  flag=changeBorder(email);
  
  if(flag)
    return !flag;

    rowcount++;
   var addRow="<div class=\"mid\"> <table><tr><td  class=\"table-r1\"><label>"+rowcount+". Vacancy id</label></td>   <td>"+
   "<input class=\"form-control form-small\" type=\"number\" id=\"vac"+rowcount+"\"   required></td>"+
   "<td><label>Name</label></td>   <td><input class=\"form-control\" type=\"text\" id=\"nme"+rowcount+"\"    ></td> <td><label>Contact</label></td>   <td><input class=\"form-control form-small2\" type=\"text\" id=\"con"+rowcount+"\"  value=\"\"  required></td>"+
   "<td><label>Email</label></td><td><input class=\"form-control\" type=\"text\" id=\"email"+rowcount+"\" ></td><td><label>Source</label></td>"+
   "<td><select name=\"source\" id=\"src"+rowcount+"\"  class=\"form-control so\" style=\"height: 30px;\"  ><option>Select source</option>"+
   "<option>consult one</option> <option>consult two</option><option>consult three</option><option>consult four</option>"+
   "<option>reference five</option></select></td><td class=\"table-tl\"> <button type=\"button\" id=\"btn-r"+rowcount+"\" class=\"btn btn-danger\" value=\""+rowcount+"\"  onclick=\"removeRow(this.value)\" >Remove</button> "+
   "<button type=\"button\" id=\"btn-ad"+rowcount+"\" class=\"btn btn-success\" value=\""+rowcount+"\"  style=\"display: none;\"  onclick=\"addThisRow(this.value)\" >add</button></td>"+
   "</tr></table> </div><div id=\"mtp-div"+rowcount+"\"></div>";
   

  document.getElementById("mtp-div"+(rowcount-1)).innerHTML +=addRow;

  window.scrollTo(0,document.body.scrollHeight);

  console.log("ROW COUNT "+rowcount);
}

function removeRow(row){
    console.log("ROW "+row);
     rmvdRow.push(row);
     document.getElementById("btn-r"+row).style.display="none";
     document.getElementById("btn-ad"+row).style.display="block";
     console.log("REMOVED ARRAY ",rmvdRow);
}

function addThisRow(row){
    console.log("ROW "+row);
    rmvdRow.pop(row);
    document.getElementById("btn-r"+row).style.display="block";
    document.getElementById("btn-ad"+row).style.display="none";
    console.log("REMOVED ARRAY ",rmvdRow);
}

var candidatesJsonArray=[];

function saveAllCandidates(){
	    var flag=false;
	    candidatesJsonArray=[];
	
for(let i=1;i<=rowcount;i++){

   if(!rmvdRow.includes(""+i)){
    var vacancyid=document.getElementById("vac"+i);
  flag=  changeBorder(vacancyid);
    var name=document.getElementById("nme"+i);
  flag= changeBorder(name);
    var contact=document.getElementById("con"+i);
    //changeBorder(contact);
    var email=document.getElementById("email"+i);
flag=   changeBorder(email);
    var sourceType= document.getElementById("src"+i);
    changeBorder(sourceType);

if(flag)
	return !flag;

    var candidateJson={
         vacancyId:vacancyid.value,
         name:name.value,
         contact:contact.value,
         email:email.value,
         sourceType:sourceType.value
    }
    //Null before Create Array

    console.log("candidate ",candidateJson);
    candidatesJsonArray.push(candidateJson);
  }//if
}//for
ajaxSaveCandiates();
console.log("Candidates ",candidatesJsonArray);
}

function ajaxSaveCandiates(){
    if(candidatesJsonArray.length==0){ 
            return false;
    }

    var url = "/ams/candidates/save";

	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : url,
			data : JSON.stringify(candidatesJsonArray),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data.message);
				
				if(!data.status){
					 document.getElementById("upperErrorDiv").style.display="block";
				     document.getElementById("upperError").innerHTML=data.message;
				}
				else {
					    document.getElementById("mtp-div1").innerHTML="";
					 	document.getElementById("cndtWrp1").innerHTML +="";
					    document.getElementById("upperSuccesDiv").style.display="block";
				        document.getElementById("upperSucces").innerHTML=data.message;
				        eventListnerToIp();
   
				}				
                 //candidatesSaved(data.message,true,false);
			},
			error : function(e) {
				console.log("ERROR: ", e);
		     location.reload();
		
			},
			done : function(e) {
				console.log("DONE");
			}
		});
  }

  function changeBorder( field){
   if(field.value=="")
  { 
          field.style.borderColor = "#bf9f62";
          field.style.boxShadow = "0px 0px 5px red"
        return true;
  }
  return false;
  }

  
  function removeBorder(){
     var collection=document.getElementsByTagName("input");
     for(let i=0;i<collection.length;i++){
      var field=collection[i];
      field.style.borderColor = "";
      field.style.boxShadow = ""
     }
     
        collection=document.getElementsByTagName("select");
     for(let i=0;i<collection.length;i++){
      var field=collection[i];
      field.style.borderColor = "";
      field.style.boxShadow = ""
     }
   }
   
   function showMinusBtn(value){
    document.getElementById("cndtWrp"+value).style.display="block";
         document.getElementById("plus"+value).style.display="none";
      document.getElementById("minus"+value).style.display="block";
}
function showPlusBtn(value){
    removeBorder();
    document.getElementById("cndtWrp"+value).style.display="none";
    document.getElementById("plus"+value).style.display="block";
    document.getElementById("minus"+value).style.display="none";
}

$(document).ready(function(){
	
    document.body.addEventListener('click', function(){
        removeBorder();
        		
        
    }, true); 
    document.getElementById("cndtWrp2").style.display="none";

});
function eventListnerToIp(){
let elementsArray = document.querySelectorAll("input");
elementsArray.forEach(function(elem) {
    elem.addEventListener("click", function() {
         document.getElementById("upperSuccesDiv").style.display="none";
         document.getElementById("upperErrorDiv").style.display="none";
          document.getElementById("lowerSuccesDiv").style.display="none";
         document.getElementById("lowerErrorDiv").style.display="none";
    });
});
}