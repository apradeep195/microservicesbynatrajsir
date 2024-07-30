function validate(frm){
	//this means form
	console.log('Hello');
	//read form data 	
	let name=frm.name.value;
	let dept=frm.dept.value;
	let unit=frm.unit.value;
	let designation=frm.designation.value;
	let sal=frm.sal.value;
	let validationFlag=true;
	//form validation logic (client side) 
	
	if(name==""){ //required role 
	document.getElementById("nameErr").innerHTML="Employee Name is required (Javascript function call) ";
	validationFlag=false;
	}else if(name.length()<5){ //minimum length role  
		document.getElementById("nameErr").innerHTML="Employee Name minimum 5 character required (Javascript function call) ";
	validationFlag=false;
	}
	
	return validationFlag;
	
}