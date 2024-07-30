$(document).ready(function(){
            dateFormat();
 })
 
 function  dateFormat()
  {
   //var showDefault=browser.downloads.showDefaultFolder();
  // console.log("Default folder "+showDefault);
    // Use Javascript
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var yyyy = today.getFullYear();
    if (dd < 10) {
      dd = '0' + (dd+1)
    }
    else
     dd=dd+1;
    if (mm < 10) {
      mm = '0' + mm
    }
    today = yyyy + '-' + mm + '-' +dd;
    console.log(today);
    inputArray = document.getElementsByTagName("input");
    for (var index = 0; index < inputArray.length; index++) {
      if (inputArray[index].type == 'date')
        if (inputArray[index].name == 'dob') {
          var yyyy2 = parseInt(yyyy) - 18;
          inputArray[index].max = yyyy2 + '-' + mm + '-' + dd;
          continue;
        }
      inputArray[index].min = today;
    }
  }