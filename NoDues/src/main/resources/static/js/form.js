
function windowRefresh(){
  location.reload();
}
function scrollToBottom(){
  window.scrollTo(0,document.body.scrollHeight);
}
function imageModalShow()
{
    $("#sample-image").modal('show');
}




var workingHeirarchyDirect = "";

// Check for the File API support.
if (window.File && window.FileReader && window.FileList && window.Blob) {
  document.getElementById('hierarchy').addEventListener('change', handleFileSelect, false);
  //document.getElementById('uploadPassImage').addEventListener('change', selfImageBase64Convert, false);
// document.getElementById('report-heirarchy').addEventListener('change', handleFileSelect, false);
} else {
  alert('The File APIs are not fully supported in this browser.');
}


  function handleFileSelect(evt) {
    var f = evt.target.files[0]; // FileList object
    var reader = new FileReader();
    // Closure to capture the file information.
    reader.onload = (function (theFile) {
      return function (e) {
        var binaryData = e.target.result;
        //Converting Binary Data to base 64
        workingHeirarchyDirect = window.btoa(binaryData);
        //showing file converted to base64
        // document.getElementById('base64').value = base64String;
        // alert('File converted to base64 successfuly!\nCheck in Textarea '+workingHeirarchyDirect.length);
      };
    })(f);
    // Read in the image file as a data URL.
    reader.readAsBinaryString(f);
  }



  function changeDisplayEmpHistory(value) {
    var empHisContainer = document.getElementById("empHistoryContainer");
    if (value == 1)
      empHisContainer.style.display = "none";
    else
      empHisContainer.style.display = "block";
  }


  /* Children Row Add Script Starts here*/
  var familyPerName;
  var dob;
  var relationShipWithApplicant;
  var age;
  var gender;
  var profession;
  var refCount = 1;
  var childrenRowCount = 1;
  var brotherRowCount = 1;
  var sisterRowCount = 1;
  var cerRowCount = 1;
  var pgRowCount = 1;
  var Childrens = "";
  var brothers = "";
  var sisters = "";
  var pgs = "";
  var cers = ""
  var childrensJson = [];
  function createChildrensJson() {
    Childrens = "";
    childrensJson = [];
    for (let i = 1; i < childrenRowCount + 1; i++) {
      relationShipWithApplicant = 6
      familyPerName = document.getElementById("children" + i + "Name").value;
      age = document.getElementById("children" + i + "Age").value;
      profession = document.getElementById("children" + i + "Profession").value;
      dob = document.getElementById("children" + i + "DOB").value;
      gender = document.getElementById("children" + i + "Gender").value;
      if (familyPerName === "")
        continue;
      var children = {
        name: familyPerName !== "" ? familyPerName : null,
        dob: dob !== "" ? dob : null,
        relationShipWithApplicant: relationShipWithApplicant,
        age: age !== "" ? age : null,
        gender: gender !== "" ? gender : null,
        profession: profession !== "" ? profession : null
      }

      //console.log("CHILD REN MADE "+i+" name : "+name+" DATA : "+JSON.stringify(children));
      childrensJson.push(children);
    }
    return childrensJson;
  }

  function addChildrensRow() {

    var inputFamilyPerName = document.getElementById("children" + childrenRowCount + "Name");
    if (inputFamilyPerName.value === "") {
      inputFamilyPerName.style.borderColor = "#ffc6c4";
      inputFamilyPerName.style.boxShadow = "0px 0px 5px red";
      return;
    }
    childrenRowCount++;
    document.getElementById("children-row" + (childrenRowCount - 1)).innerHTML += "<hr> <div  class=\"form-group row field-div2\"><div class=\"col-xs-4\"><label for=\"children" + childrenRowCount + "Name\">" + childrenRowCount + ".Name </label>" +
"<input class=\"form-control\" id=\"children" + childrenRowCount + "Name\" type=\"text\"  onclick=\"changeBorder(this.id);\"  maxlength=\"30\" ></div><div class=\"col-xs-4\"><label for=\"children" + childrenRowCount + "DOB\">Dob</label>" +
"<input class=\"form-control \" id=\"children" + childrenRowCount + "DOB\" type=\"date\"  onkeydown=\"return false\" onChange=\"calculateChildrenAge("+childrenRowCount+",this.value)\" ></div><div class=\"col-xs-3\"><label for=\"children" + childrenRowCount + "Age\">Age</label>" +
"<input class=\"form-control\" id=\"children" + childrenRowCount + "Age\" type=\"number\"  onkeyup=\"ageRecheck(this.id)\"></div><div class=\"col-xs-4\"><label for=\"children" + childrenRowCount + "Gender\">Gender</label>" +
"<select id=\"children" + childrenRowCount + "Gender\" class=\"form-control form-control-m\"><option value=\"\" >Select Gender</option>" +
"<option value=1>Male</option>  <option value=2>Female</option>" +
" </select> </div> <div class=\"col-xs-5\"><label for=\"children" + childrenRowCount + "Profession\">Profession</label>" +
"<input class=\"form-control\" id=\"children" + childrenRowCount + "Profession\" type=\"text\"  maxlength=\"30\"  placeholder=\"Please mention within 30 characters\" ></div></div>" +
" <div id=\"children-row" + childrenRowCount + "\"></div>";

      dateFormat();
  }
  /* Children Row Add Script Ends here*/
  var siblingRowCount = 1;

  function addSiblingsRow() {
    var inputFamilyPerName = document.getElementById("sibling" + siblingRowCount + "Name");
    if (inputFamilyPerName.value === "") {
      inputFamilyPerName.style.borderColor = "#ffc6c4";
      inputFamilyPerName.style.boxShadow = "0px 0px 5px red";
      return;
    }
    siblingRowCount++;
    document.getElementById("sibling-row" + (siblingRowCount - 1)).innerHTML +=   "<hr><div class=\"form-group row field-div2\"><div class=\"col-xs-4\"><label for=\"sibling"+siblingRowCount+"Name\">"+siblingRowCount+".Name</label><input class=\"form-control\" id=\"sibling"+siblingRowCount+"Name\" type=\"text\" maxlength=\"30\" onclick=\"changeBorder(this.id);\"> </div>"+
"<div class=\"col-xs-4\">"+"<label for=\"sibling"+siblingRowCount+"DOB\">Dob</label><input class=\"form-control \" id=\"sibling"+siblingRowCount+"DOB\"  onkeydown=\"return false\"  type=\"date\"  onChange=\"calculateSiblingAge("+siblingRowCount+",this.value)\"  autocomplete=\"off\" ></div>"+
"<div class=\"col-xs-3\"><label for=\"sibling"+siblingRowCount+"Age\">Age</label><input class=\"form-control\" id=\"sibling"+siblingRowCount+"Age\" type=\"number\" min=\"1\" max=\"100\"   onkeyup=\"ageRecheck(this.id)\"></div>"+
"<div class=\"col-xs-3\"><label for=\"sibling"+siblingRowCount+"Relation\">Relation</label><select id=\"sibling"+siblingRowCount+"Relation\" class=\"form-control\"><option value=\"\">Please select</option><option value=4>brother</option><option value=5>Sister</option><option value=0>Not Specified</option>"+
"</select></div><div class=\"col-xs-5\"><label for=\"sibling"+siblingRowCount+"Profession\">Profession</label><input class=\"form-control\" id=\"sibling"+siblingRowCount+"Profession\" type=\"text\" maxlength=\"30\"   placeholder=\"Please mention within 30 characters\"></div></div>"+
"<div id=\"sibling-row"+siblingRowCount+"\"> </div>";
dateFormat();

  }

  function createSiblingsJson() {
    siblings = "";
    siblingsJson = [];
    for (let i = 1; i < siblingRowCount + 1; i++) {
      var relationShipWithApplicant = document.getElementById("sibling" + i + "Relation").value;
      var familyPerName = document.getElementById("sibling" + i + "Name").value;
      var age = document.getElementById("sibling" + i + "Age").value;
      var profession = document.getElementById("sibling" + i + "Profession").value;
      var dob = document.getElementById("sibling" + i + "DOB").value;
      var relationShipWithApplicantNumber = relationShipWithApplicant == "" ? 0 : parseInt(relationShipWithApplicant);
      //console.log("VALUE CHECK+++++++++++++++  relationShipWithApplicant "+relationShipWithApplicant);
      var gender;
      if (relationShipWithApplicant == 4)
        gender = 1;
      else if (relationShipWithApplicant == 5)
        gender = 2
      else
        gender = null;

      if (familyPerName == "" && age === "") { continue; }
      var sibling = {
        name: familyPerName !== "" ? familyPerName : null,
        dob: dob !== "" ? dob : null,
        relationShipWithApplicant: relationShipWithApplicantNumber,
        gender: gender,
        age: age !== "" ? age : null,
        profession: profession !== "" ? profession : null,
      }
      siblingsJson.push(sibling);
    }
    return siblingsJson;
  }
  //PG G Certification
  var pgName;
  //MBA Msc
  var educationDetail;
  //university institue
  var educationPlaceType;
  var stream;
  var board;
  var pgFromDate;
  var pgToDate;
  var resultType;
  var pgMarksScored;
  var educationPlaceTypeName;
  var pgsJSON = [];
  function createPgJson() {
    pgs = "";
    pgsJSON = [];
    for (let i = 1; i < pgRowCount + 1; i++) {
      pgName = "POSTGRADUATION";
      educationDetail = document.getElementById("pg" + i + "Detail").value;
      educationPlaceType = "UNIVERSITY"
      educationPlaceTypeName = document.getElementById("pg" + i + "University").value;
      stream = document.getElementById("pg" + i + "Stream").value;
      board = null;
      pgFromDate = document.getElementById("pg" + i + "FromDate").value;
      pgToDate = document.getElementById("pg" + i + "ToDate").value;
      resultType = "";
      pgMarksScored = document.getElementById("pg" + i + "Scored").value;
      if (educationDetail === "")
        continue;
      var obj = {
        name: pgName !== "" ? pgName : null,
        educationDetails: educationDetail !== "" ? educationDetail : null,
        educationPlaceType: educationPlaceType !== "" ? educationPlaceType : null,
        educationPlaceTypeName: educationPlaceTypeName !== "" ? educationPlaceTypeName : null,
        board: board !== "" ? board : null,
        stream: stream !== "" ? stream : null,
        fromDate: pgFromDate !== "" ? pgFromDate : null,
        toDate: pgToDate !== "" ? pgToDate : null,
        resultType: resultType !== "" ? resultType : null,
        marksScored: pgMarksScored !== "" ? pgMarksScored : null,
      };
      pgsJSON.push(obj);
    }
    return pgsJSON;
  }

  function addPgRow() {

    var flag = false;
    var inputEducationPlaceTypeName = document.getElementById("pg" + pgRowCount + "University");
    var inputEducationDetail = educationDetail = document.getElementById("pg" + pgRowCount + "Detail");

    if (inputEducationPlaceTypeName.value == "") {
      inputEducationPlaceTypeName.style.borderColor = "#ffc6c4";
      inputEducationPlaceTypeName.style.boxShadow = "0px 0px 5px red"
      flag = true;
    }
    if (inputEducationDetail.value == "") {
      inputEducationDetail.style.borderColor = "#ffc6c4";
      inputEducationDetail.style.boxShadow = "0px 0px 5px red";
      flag = true;
    }
    if (flag)
      return;

    //  educationDetail = document.getElementById("pg" +pgRowCount + "Detail").value;
    // if(educationDetail==""){return;}

    pgRowCount++;
    document.getElementById("pg-row" + (pgRowCount - 1)).innerHTML += "<hr> <div class=\"field-div2\"><div class=\"form-group row\"><div class=\"col-xs-5\"><label for=\"pg" + pgRowCount + "Detail\">" + pgRowCount + ".Detail</label>" +
      "<input class=\"form-control\" id=\"pg" + pgRowCount + "Detail\" type=\"text\" placeholder=\"ex.MBA,MSc,M.TECH,MA etc.\" onclick=\"changeBorder(this.id);\"  maxlength=\"50\" ></div><div class=\"col-xs-3\">" +
      "<label for=\"pg" + pgRowCount + "University\">University</label><input class=\"form-control\" id=\"pg" + pgRowCount + "University\" type=\"text\" onclick=\"changeBorder(this.id);\" maxlength=\"50\"> </div>" +
      "<div class=\"col-xs-3\"><label for=\"pg" + pgRowCount + "Stream\">Stream</label><input class=\"form-control\" id=\"pg" + pgRowCount + "Stream\" type=\"text\" maxlength=\"20\">" +
      "</div></div><div class=\"form-group row\"><div class=\"col-xs-4\"><label for=\"pg" + pgRowCount + "FromDate\">From Date</label>" +
      "<input class=\"form-control \" id=\"pg" + pgRowCount + "FromDate\" type=\"date\"></div><div class=\"col-xs-4\"><label for=\"pg" + pgRowCount + "ToDate\">To Date</label>" +
      "<input class=\"form-control \" id=\"pg" + pgRowCount + "ToDate\" type=\"date\"></div><div class=\"col-xs-3\"><label for=\"pg" + pgRowCount + "Scored\">% Scored</label>" +
      "<input class=\"form-control\" id=\"pg" + pgRowCount + "Scored\" type=\"text\" maxlength=\"20\"></div></div>" +
      " </div> <div id=\"pg-row" + pgRowCount + "\"></div> ";
    //           $( function() {
    //             $( ".inputDOB" ).datepicker({ dateFormat: 'yy-mm-dd' });
    // } );

    dateFormat();
  }
  /* Post Graduation add Script Ends here*/

  /* Certification(DIP) add Script starts here*/
  var certificatesJson = [];
  function createCerJson() {
    cers = "";
    certificatesJson = [];
    for (let i = 1; i < cerRowCount + 1; i++) {
      cerName = "CERTIFICATION(DIP)";
      educationDetail = document.getElementById("cer" + i + "Detail").value;
      educationPlaceType = "INSTITUTE"
      educationPlaceTypeName = document.getElementById("cer" + i + "Institute").value;
      stream = document.getElementById("cer" + i + "Stream").value;
      board = null;
      cerFromDate = document.getElementById("cer" + i + "FromDate").value;
      cerToDate = document.getElementById("cer" + i + "ToDate").value;
      resultType = "";
      cerMarksScored = document.getElementById("cer" + i + "Scored").value;
      if (educationDetail === "")
        continue;
      var obj = {
        name: cerName !== "" ? cerName : null,
        educationDetails: educationDetail !== "" ? educationDetail : null,
        educationPlaceType: educationPlaceType !== "" ? educationPlaceType : null,
        educationPlaceTypeName: educationPlaceTypeName !== "" ? educationPlaceTypeName : null,
        board: board !== "" ? board : null,
        stream: stream !== "" ? stream : null,
        fromDate: cerFromDate !== "" ? cerFromDate : null,
        toDate: cerToDate !== "" ? cerToDate : null,
        resultType: resultType !== "" ? resultType : null,
        marksScored: cerMarksScored !== "" ? cerMarksScored : null,
      };
      certificatesJson.push(obj);
    }//For
    return certificatesJson;
  }
  function addCerRow() {
    var flag = false;
    var inputEducationPlaceTypeName = document.getElementById("cer" + cerRowCount + "Institute");
    var inputEducationDetail = document.getElementById("cer" + cerRowCount + "Detail");

    if (inputEducationPlaceTypeName.value == "") {
      inputEducationPlaceTypeName.style.borderColor = "#ffc6c4";
      inputEducationPlaceTypeName.style.boxShadow = "0px 0px 5px red"
      flag = true;
    }
    if (inputEducationDetail.value == "") {
      inputEducationDetail.style.borderColor = "#ffc6c4";
      inputEducationDetail.style.boxShadow = "0px 0px 5px red";
      flag = true;
    }
    if (flag)
      return;
    cerRowCount++;
    document.getElementById("cer-row" + (cerRowCount - 1)).innerHTML += "<hr><div class=\"field-div2\"><div class=\"form-group row\"><div class=\"col-xs-4\"><label for=\"cer" + cerRowCount + "Detail\">" + cerRowCount + ".Detail</label>" +
      "<input class=\"form-control\" id=\"cer" + cerRowCount + "Detail\" type=\"text\" placeholder=\"ex.MBA,MSc etc.\" onclick=\"changeBorder(this.id);\" maxlength=\"50\"></div><div class=\"col-xs-4\">" +
      "<label for=\"cer" + cerRowCount + "Institute\">Institute</label><input class=\"form-control\" id=\"cer" + cerRowCount + "Institute\" type=\"text\" onclick=\"changeBorder(this.id);\" maxlength=\"50\"> </div>" +
      "<div class=\"col-xs-3\"><label for=\"cer" + cerRowCount + "Stream\">Stream</label><input class=\"form-control\" id=\"cer" + cerRowCount + "Stream\" type=\"text\" maxlength=\"20\">" +
      "</div></div><div class=\"form-group row\"><div class=\"col-xs-4\"><label for=\"cer" + cerRowCount + "FromDate\">From Date</label>" +
      "<input class=\"form-control \" id=\"cer" + cerRowCount + "FromDate\" type=\"date\"></div><div class=\"col-xs-4\"><label for=\"cer" + cerRowCount + "ToDate\">To Date</label>" +
      "<input class=\"form-control \" id=\"cer" + cerRowCount + "ToDate\" type=\"date\" ></div><div class=\"col-xs-3\"><label for=\"cer" + cerRowCount + "Scored\">% Scored</label>" +
      "<input class=\"form-control\" id=\"cer" + cerRowCount + "Scored\" type=\"text\" maxlength=\"20\"></div></div> </div>" +
      " <div id=\"cer-row" + cerRowCount + "\"></div>";

      dateFormat();

  }
  /*  Certification(DIP)  add Script Ends here*/
  /*  Employee History  add Script Starts here*/
  var empHisRowCount = 1;
  var empHistories = "";
  var empfrom;
  var empTo;
  var empStartPosition;
  var empFinalPosition;
  var empStartSalary;
  var empFinalSalary;
  var empCurrentRept;
  var empOragName;
  var empDutiesResp;
  var empLeavingReason;
  var employmentStatus;

  var empHistoryJSon = [];
  function createEmphistoryJson() {
    empHistories = "";
    empHistoryJSon = [];
    for (let i = 1; i < empHisRowCount + 1; i++) {
      empfrom = document.getElementById("eh" + i + "From").value;
      empTo = document.getElementById("eh" + i + "To").value;
      empStartPosition = document.getElementById("eh" + i + "startPosition").value;
      empFinalPosition = document.getElementById("eh" + i + "FinalPosition").value;
      empStartSalary = document.getElementById("eh" + i + "StartSalary").value;
      empFinalSalary = document.getElementById("eh" + i + "FinalSalary").value;
      empCurrentRept = document.getElementById("eh" + i + "CurrentReportingTo").value;
      empOragName = document.getElementById("eh" + i + "OragName").value;
      empDutiesResp = document.getElementById("eh" + i + "DutiesResp").value;
      empLeavingReason = document.getElementById("eh" + i + "LeavingReason").value;
      if (document.getElementById("eh" + i + "esFt").checked) {
        employmentStatus = 1;
      }
      else if (document.getElementById("eh" + i + "esPt").checked) {
        employmentStatus = 2;
      }
      if (empOragName === "")
        continue;

      var empHistory = {
        orgnaizationNameAddress: empOragName !== "" ? empOragName : null,
        fromDate: empfrom !== "" ? empfrom : null,
        toDate: empTo !== "" ? empTo : null,
        employmentStatus: employmentStatus !== "" ? employmentStatus : null,
        startingPostitionTitle: empStartPosition !== "" ? empStartPosition : null,
        finalCourrentPosition: empFinalPosition !== "" ? empFinalPosition : null,
        startSalary: empStartSalary !== "" ? empStartSalary : null,
        finalSalary: empFinalSalary !== "" ? empFinalSalary : null,
        currentReportingTo: empCurrentRept !== "" ? empCurrentRept : null,
        dutiesAndResponsibilities: empDutiesResp !== "" ? empDutiesResp : null,
        leavingReason: empLeavingReason !== "" ? empLeavingReason : null,
      }
      empHistoryJSon.push(empHistory);
    }
    return empHistoryJSon.length == 0 ? null : empHistoryJSon;
  }
  function addEmphistoryRow() {
    var flag = false;
    var inputFrom = document.getElementById("eh" + empHisRowCount + "From");
    var inputTo = document.getElementById("eh" + empHisRowCount + "To");
    var inputName = document.getElementById("eh" + empHisRowCount + "OragName");


    if (inputFrom.value == "") {
      inputFrom.style.borderColor = "#ffc6c4";
      inputFrom.style.boxShadow = "0px 0px 5px red"
      flag = true;
    }
    if (inputTo.value == "") {
      inputTo.style.borderColor = "#ffc6c4";
      inputTo.style.boxShadow = "0px 0px 5px red";
      flag = true;
    }
    if (inputName.value == "") {
      inputName.style.borderColor = "#ffc6c4";
      inputName.style.boxShadow = "0px 0px 5px red";
      flag = true;
    }
    if (flag) { return; }
    empHisRowCount++;
    document.getElementById("emphistory-row" + (empHisRowCount - 1)).innerHTML += "<div class=\"field-div two\"><h4 class=\"legend-heading\" >Employement Detail</h4><div id=\"employment-div\"><div class=\"form-group row\"><div class=\"col-xs-5\"><label for=\"\">Dates</label><br><label for=\"eh" + empHisRowCount + "From\">From</label>" +
      "<input class=\"form-control\" id=\"eh" + empHisRowCount + "From\" type=\"date\"  autocomplete=\"off\"    onclick=\"changeBorder(this.id);\"></div><div class=\"col-xs-5\"><label for=\"\" class=\"invisible\">Dates Employed</label><br><label for=\"eh" + empHisRowCount + "To\">To</label>" +
      "<input class=\"form-control \" id=\"eh" + empHisRowCount + "To\" type=\"date\"  autocomplete=\"off\" onclick=\"changeBorder(this.id);\"></div><div class=\"col-xs-8\"><div style=\"margin-top:10px ;\"><label>Employment Status</label>" +
      "<input type=\"radio\" id=\"eh" + empHisRowCount + "esFt\" value=1 name=\"eh" + empHisRowCount + "EmploymentStatus\"> <label for=\"yes\">Full Time</label> <input type=\"radio\" id=\"eh" + empHisRowCount + "esPt\" value=2 name=\"eh" + empHisRowCount + "EmploymentStatus\"><label for=\"ex" + empHisRowCount + "\">Part Time</label>" +
      "</div></div></div><div class=\"form-group row\"><div class=\"col-xs-5\"><label for=\"eh" + empHisRowCount + "startPosition\">Starting Position Title :</label><input class=\"form-control\" id=\"eh" + empHisRowCount + "startPosition\" type=\"text\" maxlength=\"15\"   placeholder=\"Please mention within 15 characters\">" +
      "</div><div class=\"col-xs-6\"><label for=\"eh" + empHisRowCount + "FinalPosition\">Final or Current Position Title :</label><input class=\"form-control\" id=\"eh" + empHisRowCount + "FinalPosition\" type=\"text\"  maxlength=\"15\"   placeholder=\"Please mention within 15 characters\"></div>" +
      "</div><div class=\"form-group row\"></div><div class=\"form-group row\"><div class=\"col-xs-4\"><label for=\"ex" + empHisRowCount + "\">Salary</label><br><label for=\"eh" + empHisRowCount + "StartSalary\">Starting</label><input class=\"form-control\" id=\"eh" + empHisRowCount + "StartSalary\" type=\"number\">" +
      "</div><div class=\"col-xs-4\"><label for=\"ex" + empHisRowCount + "\" class=\"invisible\">Salary</label><br><label for=\"eh" + empHisRowCount + "FinalSalary\">Final</label><input class=\"form-control\" id=\"eh" + empHisRowCount + "FinalSalary\" type=\"number\">" +
      "</div></div><div class=\"form-group row\"><div class=\"col-xs-6\"><label for=\"eh" + empHisRowCount + "CurrentReportingTo\">Current Reporting to :</label><input class=\"form-control\" id=\"eh" + empHisRowCount + "CurrentReportingTo\" type=\"text\" maxlength=\"30\"     placeholder=\"Please mention within 30 characters\">" +
      "</div></div><div class=\"form-group row\"><div class=\"col-xs-10\"><label for=\"eh" + empHisRowCount + "OragName\">Organization Name and Address</label><input class=\"form-control\" id=\"eh" + empHisRowCount + "OragName\" type=\"text\" maxlength=\"45\"  placeholder=\"Please mention within 45 characters\"   onclick=\"changeBorder(this.id);\">" +
      "</div><div class=\"col-xs-10\"><label for=\"eh" + empHisRowCount + "DutiesResp\">Duties and Responsbilities</label><textarea class=\"form-control\" id=\"eh" + empHisRowCount + "DutiesResp\" rows=\"3\"  maxlength=\"150\"   placeholder=\"Please mention within 150 characters\"></textarea>" +
      "</div><div class=\"col-xs-10\"><label for=\"eh" + empHisRowCount + "LeavingReason\">Reason for leaving</label><textarea class=\"form-control\" id=\"eh" + empHisRowCount + "LeavingReason\" rows=\"3\"  maxlength=\"100\"   placeholder=\"Please mention within 100 characters\"></textarea>" +
      "</div></div></div></div><div id=\"emphistory-row" + empHisRowCount + "\"></div>";

      dateFormat();
  }
  /* Employee History  add Script Ends here*/
  /* Reference check div starts here*/
  var referenceCheckRowCount = 1;
  var references = "";
  var referenceName;
  var referenceAddress;
  var referenceContact;
  var referencesJson = [];

  function addReferenceCheck() {
    var flag = false;
    var inputName = document.getElementById("ref" + referenceCheckRowCount + "Name");
    var inputAddress = document.getElementById("ref" + referenceCheckRowCount + "Address");
    var inputContact = document.getElementById("ref" + referenceCheckRowCount + "Contact");

    if (inputName.value == "") {
      inputName.style.borderColor = "#ffc6c4";
      inputName.style.boxShadow = "0px 0px 5px red"
      flag = true;
    }
    if (inputAddress.value == "") {
      inputAddress.style.borderColor = "#ffc6c4";
      inputAddress.style.boxShadow = "0px 0px 5px red";
      flag = true;
    }
    if (inputContact.value == "") {
      inputContact.style.borderColor = "#ffc6c4";
      inputContact.style.boxShadow = "0px 0px 5px red";
      flag = true;
    }
    if (flag)
      return;


    referenceCheckRowCount++;
    document.getElementById("rfc-row" + (referenceCheckRowCount - 1)).innerHTML += "<div class=\"form-group row\"><div class=\"col-xs-4\"><label for=\"ref" + referenceCheckRowCount + "Name\">" + referenceCheckRowCount + ".Name</label> <input class=\"form-control\" id=\"ref" + referenceCheckRowCount + "Name\" type=\"text\"      onclick=\"changeBorder(this.id);\"  maxlength=\"30\"  placeholder=\"Please mention within 30 characters\"></div>" +
      "<div class=\"col-xs-4\"><label for=\"ref" + referenceCheckRowCount + "Address\">Address</label><input class=\"form-control\" id=\"ref" + referenceCheckRowCount + "Address\" type=\"text\"   onclick=\"changeBorder(this.id);\" maxlength=\"45\"   placeholder=\"Please mention within 45 characters\"></div>" +
      "<div class=\"col-xs-4\"><label for=\"ref" + referenceCheckRowCount + "Contact\">Contact</label>  <input class=\"form-control\" id=\"ref" + referenceCheckRowCount + "Contact\"  type=\"text\" pattern=\"\d*\" maxlength=\"10\"  onchange=\"try{setCustomValidity('')}catch(e){}\"   onkeydown=\"return validateNumber(event)\"  onclick=\"changeBorder(this.id);\"></div></div><div id=\"rfc-row" + referenceCheckRowCount + "\"></div>";
  }

  function createReferenceCheckJson() {
    references = "";
    referencesJson = [];
    for (let i = 1; i < referenceCheckRowCount + 1; i++) {

      //console.log("REFRENCE CHECK JSON "+referenceCheckRowCount);

      referenceName = document.getElementById("ref" + i + "Name").value;
      referenceAddress = document.getElementById("ref" + i + "Address").value;
      referenceContact = document.getElementById("ref" + i + "Contact").value;
      if (referenceName == "")
        continue;
      var reference = {
        name: referenceName !== "" ? referenceName : null,
        address: referenceAddress !== "" ? referenceAddress : null,
        contactNo: referenceContact !== "" ? referenceContact : null,
      }
      referencesJson.push(reference);
    }
    //console.log("REFRENCE CHECK PASSED ",referencesJson);
    return referencesJson.length == 0 ? null : referencesJson;
  }

  function changeBorder(inputId) {
    var inputBox = document.getElementById(inputId);
    //   if(inputBox.value=="")
    //    {

    //    }
    inputBox.style.border = "";
    inputBox.style.boxShadow = "";

  }
  function maritalStatusChange(inputId) {
    var maritalStatus = document.getElementById(inputId);

    if (maritalStatus.value == 2) {
      document.getElementById("dateOfWedding").disabled = false;
      document.getElementById("childrens-div").style.display = "block";
      document.getElementById("spouse-info-div").style.display = "block";
    }
    else {
      document.getElementById("dateOfWedding").disabled = true;
      document.getElementById("dateOfWedding").value = "";
      document.getElementById("childrens-div").style.display = "none";
      document.getElementById("spouse-info-div").style.display = "none";
    }

  }

  var JsonFileName = "applicant-data";
  var extension = ".json"
  var submitButtonType;
 function ajaxCall(myData) {

    // var url = "https://testeinvoice.hegltd.com/bas/applicant/register"
    var url = "/bas/applicant/register"

    console.log("MY DATA ",myData);

    document.getElementById("loading-div").style.display="flex";
    document.getElementById("wh-wrapper").style.display="none";
    document.getElementById("report-btn-div").style.display="none";    
    document.getElementById("scroll-div").style.display="none";

    $.ajax({
      url: url,
      type: "POST",
      data: JSON.stringify(myData),
      contentType: "application/json",
      success: function (data) {
        var x = JSON.stringify(data);
        document.getElementById("loading-div").style.display="none";
        $("#savedatamodal").modal('show');
        document.getElementById("wh-wrapper").style.display="block";
      },
      error: function (error) {
        document.getElementById("loading-div").style.display="none";
        document.getElementById("wh-wrapper").style.display="block";
        document.getElementById("scroll-div").style.display="block";
    //document.getElementById("report-btn-div").style.display="block";    
        $("#savedataErrormodal").modal('show');
                if (JsonFileName == "")
        JsonFileName = "sample-data";
        var myData=getData();
        saveDataLocally(myData);
      download(JSON.stringify(myData), JsonFileName, "application/json");
      }
    });
  }

  function getData() {

    var position = document.getElementById("position").value;
    var vacancyId=document.getElementById("vacancyId").value;
    var department = document.getElementById("department").value;
    // var positionCode = document.getElementById("positionCode").value;
    // var unitCode = document.getElementById("unitCode").value;
    var firstName = document.getElementById("firstName").value;
    var middleName = document.getElementById("middleName").value;
    var lastName = document.getElementById("lastName").value;
    JsonFileName = firstName + department;
    //Select Bar
    var gender = document.getElementById("gender").value;
    var category = document.getElementById("category").value;
    var nationality = document.getElementById("nationality").value;
    //Date field
    var dob = document.getElementById("selfDOB").value;
    var placeOfBirth = document.getElementById("placeOfBirth").value;
    var selfState = document.getElementById("selfState").value;
    var aadharNo = document.getElementById("aadharNo").value;
    var PANNo = document.getElementById("PANNo").value;
    var maritalStatus = document.getElementById("maritalStatus").value;
    var dateOfWedding = document.getElementById("dateOfWedding").value;
    var fatherName = document.getElementById("fatherName").value;
    var fatherAge = document.getElementById("fatherAge").value;
    var fatherProfession = document.getElementById("fatherProfession").value;
    var fatherDOB = document.getElementById("fatherDOB").value;
    var motherName = document.getElementById("motherName").value;
    var motherAge = document.getElementById("motherAge").value;
    var motherProfession = document.getElementById("motherProfession").value;
    var motherDOB = document.getElementById("motherDOB").value;
    var spouseName = document.getElementById("spouseName").value;
    var spouseAge = document.getElementById("spouseAge").value;
    var spouseNationality = document.getElementById("spouseNationality").value;
    
    var spouseProfession = document.getElementById("spouseProfession").value;
    var spouseRelation = document.getElementById("spouseRelation").value;
    var spouseDOB = document.getElementById("spouseDOB").value;
    //Addresses
    var presentHNo = document.getElementById("presentHNo").value;
    var presentArea = document.getElementById("presentArea").value;
    var presentCity = document.getElementById("presentCity").value;
    var presentState = document.getElementById("presentState").value;
    var presentPinNo = document.getElementById("presentPinNo").value;
    var permanentHNo = document.getElementById("permanentHNo").value;
    var permanentArea = document.getElementById("permanentArea").value;
    var permanentCity = document.getElementById("permanentCity").value;
    var permanentState = document.getElementById("permanentState").value;
    var permanentPinNo = document.getElementById("permanentPinNo").value;
    //Contact
    var homeNo = document.getElementById("homeNo").value;
    var officeNo = document.getElementById("officeNo").value;
    var mobileNo = document.getElementById("mobileNo").value;
    var emailAddress = document.getElementById("emailAddress").value;


    var emergencyContactName = document.getElementById("emergencyContactName").value;
    var emergencyContactRelation = document.getElementById("emergencyContactRelation").value;
    var emergencyContactAddress = document.getElementById("emergencyContactAddress").value;
    var emergencyNo = document.getElementById("emergencyNo").value;

    var vacanyAcknowledgment = document.getElementById("vacanyAcknowledgment").value;

    
   
    //Medical History
    var bloodGroup = document.getElementById("bloodGroup").value;
    //Radio
    var injuryRadio;
    var injury;
    var injuryDetails;

    if (document.getElementById('injuryRadioYes').checked) {
      injuryRadio = document.getElementById('injuryRadioYes').value;
      injuryDetails = document.getElementById("injuryDetails").value;
      injury = "yes";
    }
    else if (document.getElementById('injuryRadioNo').checked) {
      injuryRadio = document.getElementById('injuryRadioNo').value;
      injuryDetails = "";
      injury = "no";
    }
    else {
      injuryRadio = "";
      injuryDetails = "";
    }
    //Radio
    var employedInHegBefore = "";
    if (document.getElementById("employedInHegBeforeYes").checked) {
      employedInHegBefore = document.getElementById("employedInHegBeforeYes").value;

    }
    else if (document.getElementById("employedInHegBeforeNo").checked) {
      employedInHegBefore = document.getElementById("employedInHegBeforeNo").value;
    }

    //Date
    var employmentDateInHeg = document.getElementById("employmentDateInHeg").value;
    //RAdio
    var relatedInHeg = "";
    var relatedInHegFlag = "";
    var relativeNameInHeg;
    var relatedRelatioshipInHeg;
    if (document.getElementById("relatedInHegYes").checked) {
      relatedInHeg = document.getElementById("relatedInHegYes").value;
      relatedInHegFlag = "yes";
    }
    else if (document.getElementById("relatedInHegNo").checked) {
      relatedInHeg = document.getElementById("relatedInHegNo").value;
      relatedInHegFlag = "no";
    }
    relativeNameInHeg = document.getElementById("relativeNameInHeg").value;
    relatedRelatioshipInHeg = document.getElementById("relatedRelationInHeg").value;
    //Radio
    var crimeConviction = ""

    if(!document.getElementById("ccYes").checked&&!document.getElementById("ccNo").checked)
{
  crimeConviction="";
}
else    if (document.getElementById("ccYes").checked) {
      crimeConviction = 1;
    }
    else if (document.getElementById("ccNo").checked) {
      crimeConviction = 0;
    }
    else
      crimeConviction = "";

    //Academics
    var classXSchool = document.getElementById("classXSchool").value;
    var classXBoard = document.getElementById("classXBoard").value;
    var classXStream = document.getElementById("classXStream").value;
    var classXFromDate = document.getElementById("classXFromDate").value;
    var classXToDate = document.getElementById("classXToDate").value;
    var classXScored = document.getElementById("classXScored").value;


    var classXiiSchool = document.getElementById("classXiiSchool").value;
    var classXiiBoard = document.getElementById("classXiiBoard").value;
    var classXiiStream = document.getElementById("classXiiStream").value;
    var classXiiToDate = document.getElementById("classXiiToDate").value;
    var classXiiFromDate = document.getElementById("classXiiFromDate").value;
    var classXiiScored = document.getElementById("classXiiScored").value;

    var gEducationDetail = document.getElementById("gDetail").value;
    var gEducationPlaceTypeName = document.getElementById("gUniversity").value;
    //var gBoard = document.getElementById("gBoard").value;
    var gStream = document.getElementById("gStream").value;
    var gFromDate = document.getElementById("gFromDate").value;
    var gToDate = document.getElementById("gToDate").value;
    var gScored = document.getElementById("gScored").value;


    var gEducationDetail1 = document.getElementById("gDetail1").value;
    var gEducationPlaceTypeName1 = document.getElementById("gUniversity1").value;
    //var gBoard = document.getElementById("gBoard").value;
    var gStream1 = document.getElementById("gStream1").value;
    var gFromDate1 = document.getElementById("gFromDate1").value;
    var gToDate1 = document.getElementById("gToDate1").value;
    var gScored1 = document.getElementById("gScored1").value;




    //Skils
    var skillOne = document.getElementById("skillOne").value;
    var skillTwo = document.getElementById("skillTwo").value;
    var skillThree = document.getElementById("skillThree").value;

    var workingHierarchy = workingHeirarchyDirect;
   
    var applyingAs = document.getElementById("applyingAs").value;

    //console.log("JSON applyingAs  "+applyingAs);
    //console.log("Emp History " + createEmphistoryJson());


    var acedemicsDetailsModels = [];
    if (classXSchool !== "") {
      var classXDetailsJSON = {
        name: "ClassX",
        educationDetails: "Class X",
        educationPlaceType: "SCHOOL",
        educationPlaceTypeName: classXSchool,
        board: classXBoard,
        stream: classXStream,
        fromDate: classXFromDate,
        toDate: classXToDate,
        resultType: "",
        marksScored: classXScored
      };
      acedemicsDetailsModels.push(classXDetailsJSON);
    }
    if (classXiiSchool !== "") {
      var classXIIDetailsJSON = {
        name: "ClassXII",
        educationDetails: "Class Xii",
        educationPlaceType: "SCHOOL",
        educationPlaceTypeName: classXiiSchool,
        board: classXiiBoard,
        stream: classXiiStream,
        fromDate: classXiiFromDate,
        toDate: classXiiToDate,
        resultType: "",
        marksScored: classXiiScored
      };
      acedemicsDetailsModels.push(classXIIDetailsJSON);
    }
    if (gEducationDetail !== "") {
      var graducationDetailsJSON = {

        name: "Graduation",
        educationDetails: gEducationDetail,
        educationPlaceType: "UNIVERSITY",
        educationPlaceTypeName: gEducationPlaceTypeName,
        board: null,
        stream: gStream,
        fromDate: gFromDate,
        toDate: gToDate,
        resultType: "",
        marksScored: gScored
        
      };
      acedemicsDetailsModels.push(graducationDetailsJSON);
    }
    //For 2nd Gradutaion
    if (gEducationDetail1 !== "") {
      var graducationDetailsJSON = {

        name: "Graduation",
        educationDetails: gEducationDetail1,
        educationPlaceType: "UNIVERSITY",
        educationPlaceTypeName: gEducationPlaceTypeName1,
        board: null,
        stream: gStream1,
        fromDate: gFromDate1,
        toDate: gToDate1,
        resultType: "",
        marksScored: gScored1

      };
       acedemicsDetailsModels.push(graducationDetailsJSON);
    }

    var pgDetailsJSON = createPgJson();
    var cerDIPDetailsJSON = createCerJson();

    for (var i = 0; i < pgDetailsJSON.length; i++) {
      acedemicsDetailsModels.push(pgDetailsJSON[i]);
      //console.log(pgDetailsJSON[i])
    }

    for (var i = 0; i < cerDIPDetailsJSON.length; i++) {
      acedemicsDetailsModels.push(cerDIPDetailsJSON[i]);
      //console.log(pgDetailsJSON[i])
    }


    var familyJSONArray = [];

    var singleParent=document.getElementById("singleParent").value;

    if(singleParent==1)
    {
      var parentJson;
     var parentName = document.getElementById("parentName").value;
    var parentAge = document.getElementById("parentAge").value;
    var parentRelation = document.getElementById("parentRelation").value;
    var parentProfession = document.getElementById("parentProfession").value;
    var parentDOB = document.getElementById("parentDOB").value;

    if(parentName!=="")
    {
        parentJson= {
        name: parentName,
        dob: parentDOB==""?null:parentDOB,
        relationShipWithApplicant: parentRelation==""?null:parentRelation,
        age: parentAge==""?null:parentAge,
        gender: parentRelation==""?null:(parentRelation==1?1:2),
        profession: parentProfession==""?null:parentProfession
      };
      familyJSONArray.push(parentJson);
    }   
    }


    //Family array Generation
    var fatherJson;
    if (fatherName !== "") {
      var fatherJson = {
        name: fatherName,
        dob: fatherDOB,
        relationShipWithApplicant: 1,
        age: fatherAge,
        gender: 1,
        profession: fatherProfession
      };
      familyJSONArray.push(fatherJson);
    }

    var motherJson;
    if (motherName !== "") {
      motherJson = {
        name: motherName,
        dob: motherDOB,
        relationShipWithApplicant: 2,
        age: motherAge,
        gender: 2,
        profession: motherProfession
      };
      familyJSONArray.push(motherJson);
    }
    var spouseJson = null;
    if (spouseName !== "") {
      spouseJson = {
        name: spouseName,
        dob: spouseDOB,
        relationShipWithApplicant: spouseRelation,
        age: spouseAge,
        nationality:spouseNationality,
        gender: 2,
        profession: spouseProfession
      }
      familyJSONArray.push(spouseJson);
    }

    //var sisterJsonArray = createSistersJson()
    var childrensJsonArray = createChildrensJson();
    //var botherJsonArray = createBrothersJson();

    var siblingsArray = createSiblingsJson();

    for (var i = 0; i < siblingsArray.length; i++) {
      familyJSONArray.push(siblingsArray[i]);
      //console.log(siblingsArray[i])
    }

    for (var i = 0; i < childrensJsonArray.length; i++) {
      familyJSONArray.push(childrensJsonArray[i]);
      //console.log(childrensJsonArray[i])
    }

    var skillsArray = [];

    if (skillOne !== "")
      skillsArray.push(skillOne);
    if (skillTwo !== "")
      skillsArray.push(skillTwo);
    if (skillThree !== "")
      skillsArray.push(skillThree);

    if (skillsArray.length == 0)
      skillsArray = null;

    var addressDetailsArray = [];
    if (presentHNo !== "" || presentArea !== "" || presentCity !== "" || presentState !== "" || presentPinNo !== "") {
      var presentAddr = {
        addressType: 1,
        houseFlatNo: presentHNo,
        area: presentArea,
        city: presentCity,
        state: presentState,
        pinNo: presentPinNo
      };
      addressDetailsArray.push(presentAddr);
    }
    if (permanentHNo !== "" || permanentArea !== "" || permanentCity !== "" || permanentState !== "" || permanentPinNo !== "") {
      var permanentAddr = {
        addressType: 2,
        houseFlatNo: permanentHNo,
        area: permanentArea,
        city: permanentCity,
        state: permanentState,
        pinNo: permanentPinNo
      };
      addressDetailsArray.push(permanentAddr);
    }

    myData = {
      applyingPosition: position,
      department: department,
      firstName: firstName,
      middleName: middleName,
      lastName: lastName,
      gender: gender,
      nationality: nationality,
      imagePath: "",
      category: category,
      dob: dob,
      birth_place: placeOfBirth,

      positionCode: null,
       vacancyId:vacancyId,
      candidateId:"{$ENCRYPT_CANDIDATE_ID}",
      unitCode: null,
      state: selfState,
      email: emailAddress,
      homePhoneNo: homeNo,
      officePhoneNo: officeNo,
      mobileNo: mobileNo,
      emergencyNo:emergencyNo,
      emergencyContactName:emergencyContactName,
      emergencyContactRelation:emergencyContactRelation,
      emergencyContactAddress:emergencyContactAddress,
      panNo: PANNo,
      singleParent:singleParent,
      aadharNo: aadharNo,
      maritalStatus: maritalStatus,
      wedding_date: dateOfWedding,
      selfImage:selfImageGlobal==""?null:selfImageGlobal,
      bloodGroup: bloodGroup,
      majorIllness: injury,
      majorIllnessDetails: injuryDetails,
      vacanyAcknowledgment:vacanyAcknowledgment,
      past_employment_in_heg_date: employmentDateInHeg,
      relatedInHeg: relatedInHegFlag,
      relativeNameInHeg: relativeNameInHeg,
      relatedRelationInHeg: relatedRelatioshipInHeg,
      crimeConviction: crimeConviction,
      applyingAs: applyingAs,
      workingHierarchy: workingHierarchy,
      skills: skillsArray,
      academicsDetails: acedemicsDetailsModels.length > 0 ? acedemicsDetailsModels : null,
      employmentHistories:
        applyingAs == 1 ? null : createEmphistoryJson()
      ,
      referenceCheckDetails:
        createReferenceCheckJson()
      ,
      addressDetails: addressDetailsArray.length > 0 ? addressDetailsArray : null,
      familyDetails: familyJSONArray.length > 0 ? familyJSONArray : null,
    }
    return myData;
  }
  function saveDataLocally(item) {
    if (item === null)
      alert("Data Object is null");
    else
      localStorage.setItem("current-process", JSON.stringify(item));
  }

  function saveProcess() {
    var currentData = getData();
    saveDataLocally(currentData);
    $('#savedatamodal').modal('show');
    //console.log("data saved in loclst",currentData);
  }

  function generateReport() {

    //var fileVal=document.getElementById("hierarchy").value;;
    /////console.log("FILE VALUE"+fileVal)
    //saveProcess();    
    var currentData = getData();
    saveDataLocally(currentData);
    $('#savedatamodal').modal('hide');

    setReportData(currentData);

    //console.log("data saved in loclst",currentData);

    ///document.getElementById("report-heirarchy").value=fileVal;

    document.getElementById("bottom-btns-div").style.display = "none";
    document.getElementById("container").style.display = "none";
    // document.getElementById("report-div").style.display = "block";

    document.getElementById("report-btn-div").style.display = "none";
  }


  function submitDataForm(value) {
    var flag = false;
    //console.log("Hello "+value);
    var jsonData = getData();
    saveDataLocally(jsonData);

    flag=checkRequiredField();
    if(!flag) 
      return false;

    if (value == 'save-data') {
      //  //console.log(myData);
      var url = "/bas/applicant/register"
      $.ajax({
        url: url,
        type: "POST",
        data: JSON.stringify(myData),
        contentType: "application/json",
        success: function (data) {
          var x = JSON.stringify(data);
          //console.log(x);
          //showApiSuccessDiv();
          $('#savedatamodal').modal('show');
          saveDataLocally({});

        },
        error: function (error) {
          //console.log(`Error ${error}`);
          // showErrorDiv();
          $('#errormodal').modal('show');
          return false;
        }
      });
      return false;
    }
    else if (value == 'generate-report') {

      //document.getElementById("form-header").style.display="none";
      var returnFlag = checkRequiredField();
      if (!returnFlag)
          return false;

          $('#recheckdatamodal').modal('show');
          document.getElementById("scroll-div").style.display="block";

      //console.log("GENERATE REPORT CALLED");
      //var jsonData2=getDataFromLocal("current-process");
   //   setReportData(jsonData);

    //  generateReport();
      return true;
    }

    else if (value == 'generate-data-file') {
      if (JsonFileName == "")
        JsonFileName = "sample-data";
        var myData=getData();
        saveDataLocally(myData);
      download(JSON.stringify(myData), JsonFileName, "application/json");
      $('#datafilemodal').modal('show');
    }

    else if (value == 'generate-data') {
      if (JsonFileName == "")
        JsonFileName = "sample-data";
        var myData=getData();
        //saveDataLocally(myData);
        ajaxCall(myData);
       return true;
    }
    return false;
  }

  function replace() {
    document.getElementById("container").innerHTML = "<div class=\"center-div\"><div class=\"child-div\"><img src=\"img4.gif\" width=\"80\" height=\"80\"><h3>You have registered succesfully!</h3></div></div>";
  }
  function replaceTwo() {
    document.getElementById("container").innerHTML = "<div class=\"center-div\"><div class=\"child-div\"><img src=\"img4.gif\" width=\"80\" height=\"80\"><h3>Your Data file has been created succesfully!</h3></div></div>";
  }
  function showApiSuccessDiv() {
    document.getElementById("success-api-div").style.display = "block";
    document.getElementById("success-json-div").style.display = "none";
    document.getElementById("error-div").style.display = "none";
    document.getElementById("container").style.display = "none";
  }
  function showJsonSuccessDiv() {
    document.getElementById("success-json-div").style.display = "block";
    document.getElementById("error-div").style.display = "none";
    document.getElementById("success-api-div").style.display = "none";
    document.getElementById("container").style.display = "none";
  }
  function showErrorDiv() {
    document.getElementById("error-div").style.display = "block";
    document.getElementById("container").style.display = "none";
    document.getElementById("success-api-div").style.display = "none";
    document.getElementById("success-json-div").style.display = "none";
  }

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
      dd = '0' + dd
    }
    if (mm < 10) {
      mm = '0' + mm
    }
    today = yyyy + '-' + mm + '-' + dd;
    inputArray = document.getElementsByTagName("input");
    for (var index = 0; index < inputArray.length; index++) {
      if (inputArray[index].type == 'date')
        if (inputArray[index].name == 'dob') {
          var yyyy2 = parseInt(yyyy) - 18;
          inputArray[index].max = yyyy2 + '-' + mm + '-' + dd;
          continue;
        }
      inputArray[index].max = today;
    }

  }

  $(document).ready(function () {
    dateFormat();

    document.getElementById("scroll-div").style.display="none";

    document.getElementById("parent-details").style.display="none";

    document.getElementById("employmentDateInHeg").disabled = true;
    document.getElementById("relativeNameInHeg").disabled = true;
    document.getElementById("relatedRelationInHeg").disabled = true;
    document.getElementById("injuryDetails").disabled = true;
    document.getElementById("empHistoryContainer").style.display = "none";
    document.getElementById("dateOfWedding").disabled = true;
    document.getElementById("childrens-div").style.display = "none";
    document.getElementById("spouse-info-div").style.display = "none";

   

    //console.log("Data not found");
  });

  function getDataFromLocal(key) {
    var currentObject = localStorage.getItem(key);
    return JSON.parse(currentObject);
  }
  function setData(JsonObject) {
    document.getElementById("position").value = JsonObject.applyingPosition;
    document.getElementById("department").value = JsonObject.department;
    // document.getElementById("positionCode").value = JsonObject.positionCode;
    // document.getElementById("unitCode").value = JsonObject.unitCode;
    document.getElementById("firstName").value = JsonObject.firstName;
    document.getElementById("middleName").value = JsonObject.middleName;
    document.getElementById("lastName").value = JsonObject.lastName;

    document.getElementById("gender").value = JsonObject.gender
    document.getElementById("category").value = JsonObject.category
    document.getElementById("nationality").value = JsonObject.nationality
    //Date field=JsonObject.
    document.getElementById("selfDOB").value = JsonObject.dob
    document.getElementById("placeOfBirth").value = JsonObject.birth_place
    document.getElementById("selfState").value = JsonObject.state
    document.getElementById("aadharNo").value = JsonObject.aadharNo
    document.getElementById("PANNo").value = JsonObject.panNo
    document.getElementById("maritalStatus").value = JsonObject.maritalStatus
 
    //console.log("VALUE CHECK -====================="+JsonObject.maritalStatus);
    if (JsonObject.maritalStatus == 2) {
      document.getElementById("dateOfWedding").disabled = false;
      //document.getElementById("dateOfWedding1").disabled = false;
      document.getElementById("childrens-div").style.display = "block";
      document.getElementById("spouse-info-div").style.display = "block";
    }

    document.getElementById("dateOfWedding").value = JsonObject.wedding_date



    //Contact=JsonObject.
    document.getElementById("homeNo").value = JsonObject.homePhoneNo
    document.getElementById("officeNo").value = JsonObject.officePhoneNo
    document.getElementById("mobileNo").value = JsonObject.mobileNo
    document.getElementById("emailAddress").value = JsonObject.email

    document.getElementById("emergencyNo").value=JsonObject.emergencyNo

     document.getElementById("emergencyContactName").value=JsonObject.emergencyContactName;
     document.getElementById("emergencyContactRelation").value=JsonObject.emergencyContactRelation;
    document.getElementById("emergencyContactAddress").value=JsonObject.emergencyContactAddress;
  
    //Medical History=JsonObject.
    document.getElementById("bloodGroup").value = JsonObject.bloodGroup

    //Radio--------------------------------------------Handle=JsonObject.


    document.getElementById("vacanyAcknowledgment").value=JsonObject.vacanyAcknowledgment;

    document.getElementById('injuryRadioYes').checked = JsonObject.majorIllness == "yes" ? true : false;
    document.getElementById('injuryRadioNo').checked = JsonObject.majorIllness == "no" ? true : false;

    document.getElementById("injuryDetails").value = JsonObject.majorIllnessDetails;
    if (JsonObject.past_employment_in_heg_date == "") {
      document.getElementById("employedInHegBeforeYes").checked = false;
      document.getElementById("employedInHegBeforeNo").checked = false;
    }
    else {
      document.getElementById("employedInHegBeforeYes").checked = true;
      document.getElementById("employedInHegBeforeNo").checked = false;
    }
    document.getElementById("employmentDateInHeg").value = JsonObject.past_employment_in_heg_date;

    //RAdio=JsonObject.
    document.getElementById("relatedInHegYes").checked = JsonObject.relatedInHeg == "yes" ? true : false;
    document.getElementById("relatedInHegNo").checked = JsonObject.relatedInHeg == "no" ? true : false;




    document.getElementById("relativeNameInHeg").value = JsonObject.relativeNameInHeg;
    document.getElementById("relatedRelationInHeg").value = JsonObject.relatedRelationInHeg;


    //Radio=JsonObject.
    if( JsonObject.crimeConviction!=="")
     { document.getElementById("ccYes").checked = JsonObject.crimeConviction == 1 ? true : false;
    document.getElementById("ccNo").checked = JsonObject.crimeConviction == 0 ? true : false;}



    var isSingleParentO=JsonObject.singleParent;
    document.getElementById("singleParent").value=JsonObject.singleParent;
     if(isSingleParentO!=="")
     {
       isSingleParent(JsonObject.singleParent);
     }
    if (JsonObject.familyDetails !== null) {
      var siblingCount = 1;
      var sisterCount = 1;
      var brotherCount = 1;
      var childrenCount = 1;

  for (var i = 0; i < JsonObject.familyDetails.length; i++) {

        if(isSingleParentO==0&&JsonObject.familyDetails[i].relationShipWithApplicant ==1||JsonObject.familyDetails[i].relationShipWithApplicant == 2)
        {
        if (JsonObject.familyDetails[i].relationShipWithApplicant == 1) {
          document.getElementById("fatherName").value = JsonObject.familyDetails[i].name;
          document.getElementById("fatherAge").value = JsonObject.familyDetails[i].age;
          document.getElementById("fatherProfession").value = JsonObject.familyDetails[i].profession;
          document.getElementById("fatherDOB").value = JsonObject.familyDetails[i].dob;
          continue;
        }
        if (JsonObject.familyDetails[i].relationShipWithApplicant == 2) {
          document.getElementById("motherName").value = JsonObject.familyDetails[i].name;
          document.getElementById("motherAge").value = JsonObject.familyDetails[i].age;
          document.getElementById("motherProfession").value = JsonObject.familyDetails[i].profession;
          document.getElementById("motherDOB").value = JsonObject.familyDetails[i].dob;
          continue;
        }
      }
        if(isSingleParentO==1&&JsonObject.familyDetails[i].relationShipWithApplicant ==1||JsonObject.familyDetails[i].relationShipWithApplicant == 2)
  {
          document.getElementById("parentName").value = JsonObject.familyDetails[i].name;
          document.getElementById("parentAge").value = JsonObject.familyDetails[i].age;
          document.getElementById("parentProfession").value = JsonObject.familyDetails[i].profession;
          document.getElementById("parentDOB").value = JsonObject.familyDetails[i].dob;
         document.getElementById("parentRelation").value=JsonObject.familyDetails[i].relationShipWithApplicant;
         continue;
  }

        if (JsonObject.familyDetails[i].relationShipWithApplicant == 3) {
          document.getElementById("spouseName").value = JsonObject.familyDetails[i].name;
          document.getElementById("spouseAge").value = JsonObject.familyDetails[i].age;
          document.getElementById("spouseNationality").value = JsonObject.familyDetails[i].nationality;
          document.getElementById("spouseProfession").value = JsonObject.familyDetails[i].profession;
          document.getElementById("spouseDOB").value = JsonObject.familyDetails[i].dob;
          continue;
        }

        if (JsonObject.familyDetails[i].relationShipWithApplicant == 6) {
          //children" + childrenRowCount + "Name          
          if (childrenCount != 1) { addChildrensRow(); }

          document.getElementById("children" + childrenCount + "Name").value = JsonObject.familyDetails[i].name;
          document.getElementById("children" + childrenCount + "Age").value = JsonObject.familyDetails[i].age;
          document.getElementById("children" + childrenCount + "Profession").value = JsonObject.familyDetails[i].profession;
          document.getElementById("children" + childrenCount + "DOB").value = JsonObject.familyDetails[i].dob;
          document.getElementById("children" + childrenCount + "Gender").value = JsonObject.familyDetails[i].gender;
          childrenCount++;
          continue;
        }

        //console.log("VALUE CHECK  relationShipWithApplicant ====================="+JsonObject.familyDetails[i].relationShipWithApplicant);
        if (JsonObject.familyDetails[i].relationShipWithApplicant == 4 || JsonObject.familyDetails[i].relationShipWithApplicant == 5 || JsonObject.familyDetails[i].relationShipWithApplicant == 0) {
          //sister" + sisterRowCount + "Name          
          if (siblingCount != 1) { addSiblingsRow(); }
          document.getElementById("sibling" + siblingCount + "Name").value = JsonObject.familyDetails[i].name;
          document.getElementById("sibling" + siblingCount + "Age").value = JsonObject.familyDetails[i].age;
          document.getElementById("sibling" + siblingCount + "Profession").value = JsonObject.familyDetails[i].profession;
          document.getElementById("sibling" + siblingCount + "Relation").value = JsonObject.familyDetails[i].relationShipWithApplicant;
          document.getElementById("sibling" + siblingCount + "DOB").value = JsonObject.familyDetails[i].dob;
          siblingCount++;
        }
      } //For
} //if

    if (JsonObject.addressDetails !== null) {
      for (var i = 0; i < JsonObject.addressDetails.length; i++) {
        if (JsonObject.addressDetails[i].addressType == 1) {
          document.getElementById("presentHNo").value = JsonObject.addressDetails[i].houseFlatNo
          document.getElementById("presentArea").value = JsonObject.addressDetails[i].area
          document.getElementById("presentCity").value = JsonObject.addressDetails[i].city
          document.getElementById("presentState").value = JsonObject.addressDetails[i].state
          document.getElementById("presentPinNo").value = JsonObject.addressDetails[i].pinNo
          continue;
        }
        else if (JsonObject.addressDetails[i].addressType === 2) {
          document.getElementById("permanentHNo").value = JsonObject.addressDetails[i].houseFlatNo
          document.getElementById("permanentArea").value = JsonObject.addressDetails[i].area
          document.getElementById("permanentCity").value = JsonObject.addressDetails[i].city
          document.getElementById("permanentState").value = JsonObject.addressDetails[i].state
          document.getElementById("permanentPinNo").value = JsonObject.addressDetails[i].pinNo
        }
        else {//console.log("Invalid Address Type. Valids are {PRESENT:PERMANENT}")
        }
      }
    }
    if (JsonObject.academicsDetails != null) {
      var pgCount = 1;
      var cerCount = 1;
      for (var i = 0; i < JsonObject.academicsDetails.length; i++) {
        var acdemedicDetail = JsonObject.academicsDetails[i];
        if (acdemedicDetail.name.toUpperCase() == "CLASSX") {
          document.getElementById("classXSchool").value = acdemedicDetail.educationPlaceTypeName;
          document.getElementById("classXBoard").value = acdemedicDetail.board;
          document.getElementById("classXStream").value = acdemedicDetail.stream;
          document.getElementById("classXFromDate").value = acdemedicDetail.fromDate;
          document.getElementById("classXToDate").value = acdemedicDetail.toDate;
          document.getElementById("classXScored").value = acdemedicDetail.marksScored;
        }
        else if (acdemedicDetail.name.toUpperCase() == "CLASSXII") {
          document.getElementById("classXiiSchool").value = acdemedicDetail.educationPlaceTypeName;
          document.getElementById("classXiiBoard").value = acdemedicDetail.board;
          document.getElementById("classXiiStream").value = acdemedicDetail.stream;
          document.getElementById("classXiiFromDate").value = acdemedicDetail.fromDate;
          document.getElementById("classXiiToDate").value = acdemedicDetail.toDate;
          document.getElementById("classXiiScored").value = acdemedicDetail.marksScored;
        }
        else if (acdemedicDetail.name.toUpperCase() == "GRADUATION") {
          document.getElementById("gDetail").value = acdemedicDetail.educationDetails;
          document.getElementById("gUniversity").value = acdemedicDetail.educationPlaceTypeName;
          document.getElementById("gStream").value = acdemedicDetail.stream;
          document.getElementById("gFromDate").value = acdemedicDetail.fromDate;
          document.getElementById("gToDate").value = acdemedicDetail.toDate;
        }
        else if (acdemedicDetail.name.toUpperCase() == "POSTGRADUATION") {
          if (pgCount > 1) { addPgRow(); }
          document.getElementById("pg" + pgCount + "Detail").value = acdemedicDetail.educationDetails;
          document.getElementById("pg" + pgCount + "University").value = acdemedicDetail.educationPlaceTypeName;
          document.getElementById("pg" + pgCount + "Stream").value = acdemedicDetail.stream;
          document.getElementById("pg" + pgCount + "FromDate").value = acdemedicDetail.fromDate;
          document.getElementById("pg" + pgCount + "ToDate").value = acdemedicDetail.toDate;
          document.getElementById("pg" + pgCount + "Scored").value = acdemedicDetail.marksScored;
          pgCount++;
        }
        else if (acdemedicDetail.name.toUpperCase() == "CERTIFICATION(DIP)") {
          if (cerCount > 1) { addCerRow(); }
          document.getElementById("cer" + cerCount + "Detail").value = acdemedicDetail.educationDetails;
          document.getElementById("cer" + cerCount + "Institute").value = acdemedicDetail.educationPlaceTypeName;
          document.getElementById("cer" + cerCount + "Stream").value = acdemedicDetail.stream;
          document.getElementById("cer" + cerCount + "FromDate").value = acdemedicDetail.fromDate;
          document.getElementById("cer" + cerCount + "ToDate").value = acdemedicDetail.toDate;
          document.getElementById("cer" + cerCount + "Scored").value = acdemedicDetail.marksScored;
          cerCount++;
        }
        else {  }
      }
    }
    //console.log("(JsonObject.applyingAs "+JsonObject.applyingAs);
    document.getElementById("applyingAs").value = JsonObject.applyingAs;
    if (JsonObject.applyingAs != 1 && JsonObject.applyingAs != "") {
      document.getElementById("empHistoryContainer").style.display = "block";
      if (JsonObject.employmentHistories != null) {
        var empHistoryCount = 1;
        for (var i = 0; i < JsonObject.employmentHistories.length; i++) {
          var empHistory = JsonObject.employmentHistories[i];

          if (empHistoryCount > 1) { addEmphistoryRow(); }

          document.getElementById("eh" + empHistoryCount + "From").value = empHistory.fromDate;
          document.getElementById("eh" + empHistoryCount + "To").value = empHistory.toDate;
          document.getElementById("eh" + empHistoryCount + "startPosition").value = empHistory.startingPostitionTitle;
          document.getElementById("eh" + empHistoryCount + "FinalPosition").value = empHistory.finalCourrentPosition;
          document.getElementById("eh" + empHistoryCount + "StartSalary").value = empHistory.startSalary;
          document.getElementById("eh" + empHistoryCount + "FinalSalary").value = empHistory.finalSalary;
          document.getElementById("eh" + empHistoryCount + "CurrentReportingTo").value = empHistory.currentReportingTo;
          document.getElementById("eh" + empHistoryCount + "OragName").value = empHistory.orgnaizationNameAddress;
          document.getElementById("eh" + empHistoryCount + "DutiesResp").value = empHistory.dutiesAndResponsibilities;
          document.getElementById("eh" + empHistoryCount + "LeavingReason").value = empHistory.leavingReason;
          if (empHistory.employmentStatus == "") {
            document.getElementById("eh" + empHistoryCount + "esFt").checked = false;
            document.getElementById("eh" + empHistoryCount + "esPt").checked = false;
          }
          else if (empHistory.employmentStatus == 1) {
            document.getElementById("eh" + empHistoryCount + "esFt").checked = true;
            document.getElementById("eh" + empHistoryCount + "esPt").checked = false;
          }
          else if (empHistory.employmentStatus == 2) {
            document.getElementById("eh" + empHistoryCount + "esFt").checked = false;
            document.getElementById("eh" + empHistoryCount + "esPt").checked = true;
          }
          else { console.log("INVALID EMPLOYMENT STATUS TYPE VALIDS ARE {FULL_TIME:PART_TIME}") }
          empHistoryCount++;
        }//for loop
      }//if employmentHistories
    }

    if (JsonObject.skills != null) {
      var skilLength = JsonObject.skills.length;
      document.getElementById("skillOne").value = skilLength > 0 ? JsonObject.skills[0] : "";
      document.getElementById("skillTwo").value = skilLength > 1 ? JsonObject.skills[1] : "";
      document.getElementById("skillThree").value = skilLength > 2 ? JsonObject.skills[2] : "";
    } //if

    if (JsonObject.referenceCheckDetails !== null) {
      var referenceJSONCount = 1;
      for (var i = 0; i < JsonObject.referenceCheckDetails.length; i++) {
        var referenceCheckDetail = JsonObject.referenceCheckDetails[i];
        if (referenceJSONCount > 1) { addReferenceCheck(); }
        document.getElementById("ref" + referenceJSONCount + "Name").value = referenceCheckDetail.name;
        document.getElementById("ref" + referenceJSONCount + "Address").value = referenceCheckDetail.address;
        document.getElementById("ref" + referenceJSONCount + "Contact").value = referenceCheckDetail.contactNo;
        referenceJSONCount++;
      }//For loop
    }//if
  }
  function clearProcess() {
      var JsonObject = {};
        saveDataLocally(JsonObject);
        location.reload();
      //console.log("DATA CLEARED");
  }

  var totalPageNo = 7;

  var nextPage = 1;
  var base64String2 = "";
  function base64Convert() {
    var base64String3 = "";
  //  console.log("BASE 64 CONVERTOR ");
    const fileInput = document.getElementById('hierarchy');
    //console.log("BASE 64 CONVERTOR 2");

    if (fileInput.files.length != 0) {
      const file = fileInput.files[0];
      // Encode the file using the FileReader API
      const reader = new FileReader();
      reader.onloadend = () => {
        // Use a regex to remove data url part
        const base64String = reader.result
          .replace('data:', '')
          .replace(/^.+,/, '');
        base64String3 = base64String;
   //     console.log("base 64 generated " + base64String.length);
      };
      reader.readAsDataURL(file);
    }

    return base64String3;
  }


  $(document).ready(function () {
    ///To display last page <TEST>

    //  nextPage=3;
  //  divVisible(1);

       document.getElementById("generate-data-file").style.display = "none";


   document.getElementById("page1").style.display = "block";
     for (var i = 2; i < totalPageNo + 1; i++)
         document.getElementById("page" + i).style.display = "none";

     if (nextPage == 1)
       document.getElementById("previousBtn").disabled = true;



    //    nextPage=7;
    //   divVisible(nextPage);
    //   document.getElementById("previousBtn").disabled=false;
    // previousBtn

    // document.getElementById("family-details").style.display="none";
    // document.getElementById("address-details").style.display="none";
    // document.getElementById("medical-history").style.display="none";
    // document.getElementById("academic-details").style.display="none";
    // document.getElementById("skill-details").style.display="none";
    // document.getElementById("employment-details").style.display="none";
    // document.getElementById("reference-details").style.display="none";

  });
  function divVisible(pageNo) {
    nextPage = pageNo;
    if (pageNo == 1) {
      document.getElementById("nextBtn").disabled = false;
      document.getElementById("previousBtn").disabled = true;
    }
    else if (pageNo == totalPageNo) {
      document.getElementById("nextBtn").disabled = false;
      document.getElementById("previousBtn").disabled = true;
    }
    else {
      document.getElementById("nextBtn").disabled = false;
      document.getElementById("previousBtn").disabled = false;
    }

    for (var i = 1; i < totalPageNo + 1; i++)
      document.getElementById("page" + i).style.display = "none";

    document.getElementById("page" + pageNo).style.display = "block";
  }

  function nextPageShow() {

  // if(nextPage==1)
  // {
  //      if(!checkRequiredField())
  //        return false;
  // }

  document.body.scrollTop = 0; // For Safari
  document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera


    if (nextPage != totalPageNo) {
      nextPage++;
      divVisible(nextPage);
      if (nextPage == totalPageNo)
        document.getElementById("nextBtn").disabled = true;

    }
    else
      document.getElementById("nextBtn").disabled = true;

    if (nextPage > 1)
      document.getElementById("previousBtn").disabled = false;


  }

  function previousPageShow() {

    if (nextPage == totalPageNo || nextPage < totalPageNo)
      document.getElementById("nextBtn").disabled = false;


    if (nextPage == 2 || nextPage == 1)
      document.getElementById("previousBtn").disabled = true;

    if (nextPage != 1) {
      nextPage--;
      divVisible(nextPage);
    }
  }

  function checkRequiredField() {


    var flag = false;
    var totalRequiredFields = 1;
    const reqiuredFields = new Map();

    // reqiuredFields.set(totalRequiredFields, "position");
    // totalRequiredFields++;
    // reqiuredFields.set(totalRequiredFields, "department");
    // totalRequiredFields++;
    reqiuredFields.set(totalRequiredFields, "vacancyId");
    totalRequiredFields++;
    reqiuredFields.set(totalRequiredFields, "firstName");
    totalRequiredFields++;
    // reqiuredFields.set(totalRequiredFields, "lastName");
    // totalRequiredFields++;
    reqiuredFields.set(totalRequiredFields, "gender");
    totalRequiredFields++;
    reqiuredFields.set(totalRequiredFields, "category");
    totalRequiredFields++;
    reqiuredFields.set(totalRequiredFields, "nationality");
    totalRequiredFields++;
    reqiuredFields.set(totalRequiredFields, "selfDOB");
    totalRequiredFields++;
    // reqiuredFields.set(totalRequiredFields, "placeOfBirth");
    // totalRequiredFields++;
    reqiuredFields.set(totalRequiredFields, "selfState");
    totalRequiredFields++;
    reqiuredFields.set(totalRequiredFields, "aadharNo");
    // totalRequiredFields++;
    // reqiuredFields.set(totalRequiredFields, "mobileNo");
    // totalRequiredFields++;
    // reqiuredFields.set(totalRequiredFields, "vacanyAcknowledgment");
    // totalRequiredFields++;
    // reqiuredFields.set(totalRequiredFields, "PANNo");
    // totalRequiredFields++;
    // reqiuredFields.set(totalRequiredFields, "maritalStatus");
    //reqiuredFields.set(totalRequiredFields++,"dateOfWedding");
     var vcncyAck=document.getElementById("vacanyAcknowledgment");
     var mobileReq = document.getElementById("mobileNo");


     if(vcncyAck.value==""){
      vcncyAck.style.borderColor = "#ffc6c4";
      vcncyAck.style.boxShadow = "0px 0px 5px red"
       flag = true;

       nextPage=4;
     }

     if(mobileReq.value=="" || mobileReq.value.length<10){
       mobileReq.style.borderColor = "#ffc6c4";
        mobileReq.style.boxShadow = "0px 0px 5px red";

       flag = true;
       nextPage=3;
     }



    for (var i = 1; i <= totalRequiredFields; i++) {
      var test = document.getElementById("position").value;
      //console.log("test ",test);
      //console.log("field " +reqiuredFields.get(i));
      var field = document.getElementById(reqiuredFields.get(i))
    if(reqiuredFields.get(i)=="aadharNo"){
          if(field.value.length<12){
            document.getElementById("addharNoLabel").innerHTML="Aadhar No (12 digits)";
            field.style.borderColor = "#ffc6c4";
            field.style.boxShadow = "0px 0px 5px red"
            flag = true;
            nextPage = 1;
            continue;
          }
        }
      if (field.value == "") {
        field.style.borderColor = "#ffc6c4";
        field.style.boxShadow = "0px 0px 5px red"
        nextPage = 1;
        flag = true;
      }

}

    if (flag) {
         divVisible(nextPage);
         mobileReq.focus();
    }
    else {
        for(var i=1;i<=totalPageNo;i++){
          document.getElementById("page" + i).style.display = "block";        
          }
        document.getElementById("generate-data-file").style.display="block";

        document.getElementById("confirm-div").style.display="none";
        document.getElementById("report-btn-div").style.display="none";
        
      //   document.getElementById("nextBtn").disabled = true;
      //  document.getElementById("previousBtn").disabled = true;
      //  document.getElementById("confirmBtn").style.display="none";
    }
    return flag ? false : true;
  }

  // Function to download data to a file
  function download(data, filename, type) {
    var file = new Blob([data], { type: type });
    if (window.navigator.msSaveOrOpenBlob) // IE10+
      window.navigator.msSaveOrOpenBlob(file, filename);
    else { // Others
      var a = document.createElement("a"),
        url = URL.createObjectURL(file);
      a.href = url;
      a.download = filename;
      document.body.appendChild(a);
      a.click();
      setTimeout(function () {
        document.body.removeChild(a);
        window.URL.revokeObjectURL(url);
      }, 0);
    }
  }

  function disableInjuryDetails(value) {
    if (value == "Yes" || value == "yes")
      document.getElementById("injuryDetails").disabled = false;
    else
      document.getElementById("injuryDetails").disabled = true;
  }
  function disableRelatedName(value) {
    if (value == "Yes" || value == "yes") {
      document.getElementById("relativeNameInHeg").disabled = false;
      document.getElementById("relatedRelationInHeg").disabled = false;
    }
    else {
      document.getElementById("relativeNameInHeg").disabled = true;
      document.getElementById("relatedRelationInHeg").disabled = true;
      document.getElementById("relativeNameInHeg").value = "";
      document.getElementById("relatedRelationInHeg").value = "";
    }
  }
  function disableEmpDate(value) {
    if (value == "Yes" || value == "yes")
      document.getElementById("employmentDateInHeg").disabled = false;
    else {
      document.getElementById("employmentDateInHeg").disabled = true;
      document.getElementById("employmentDateInHeg").value = "";
    }

  }

  $(document).ready(function () {


    //document.getElementById("report-div").style.display = "none";
    document.getElementById("container").style.display = "block";


  //  document.getElementById("dateOfWedding1").disabled = true;
 //   var JsonObject = getDataFromLocal("current-process");
    //console.log(JsonObject);
    //setReportData(JsonObject);

    //         inputArray = document.getElementsByTagName("input");
    //    for (var index = 0; index < inputArray.length; index++)
    //     if (inputArray[index].type == 'text')
    //         inputArray[index].value="";
  });


function duplicatePresentAddress()
{
    var presentHNo=document.getElementById("presentHNo").value;
    var presentArea=document.getElementById("presentArea").value;
    var presentCity=document.getElementById("presentCity").value;
    var presentState=document.getElementById("presentState").value;
    var presentPinNo=document.getElementById("presentPinNo").value;

    if(presentHNo==""&&presentArea==""&&presentCity==""&&presentState==""&&presentPinNo=="")
    { 
        showTemplateModal("Please fill present address details first.");
        return;
    }
document.getElementById("permanentHNo").value=presentHNo;
document.getElementById("permanentArea").value=presentArea;
document.getElementById("permanentCity").value=presentCity;
document.getElementById("permanentState").value=presentState;
document.getElementById("permanentPinNo").value=presentPinNo;
}

function showTemplateModal(message)
{
    document.getElementById("template-modal-title").innerText=message;
    $('#template-modal').modal('show');

}
function isSingleParent(value)
{
    if(value==1)
      {
        document.getElementById("mother-details").style.display="none";
        document.getElementById("father-details").style.display="none";
       document.getElementById("parent-details").style.display="block";
    }
    else
  {
    document.getElementById("parent-details").style.display="none";
    document.getElementById("mother-details").style.display="block";
    document.getElementById("father-details").style.display="block";
  }  
}
function getAge(dateString) 
{ 
    var ageInMilliseconds = new Date() - new Date(dateString);
    return Math.floor(ageInMilliseconds/1000/60/60/24/365); // convert to years
}

function calculateSiblingAge(index,value)
{
    document.getElementById("sibling"+index+"Age").value=getAge(value);
}

function calculateChildrenAge(index,value)
{
    document.getElementById("children"+index+"Age").value=getAge(value);
}


var selfImageGlobal="";
function hello()
{
}
function selfImageBase64Convert() {
    //var f = evt.target.files[0]; // FileList object
var f=document.getElementById("uploadPassImage").files[0];

    var reader = new FileReader();
    // Closure to capture the file information.
    reader.onload = (function (theFile) {
      return function (e) {
        var binaryData = e.target.result;
        //Converting Binary Data to base 64
        selfImageGlobal = window.btoa(binaryData);
        //showing file converted to base64
        // document.getElementById('base64').value = base64String;
        // alert('File converted to base64 successfuly!\nCheck in Textarea '+workingHeirarchyDirect.length);
      };
    })(f);
    // Read in the image file as a data URL.
    reader.readAsBinaryString(f);

  }
  
function reportSelfImageBase64Convert() {
    //var f = evt.target.files[0]; // FileList object
var f=document.getElementById("reportUploadPassImage").files[0];

    var reader = new FileReader();
    // Closure to capture the file information.
    reader.onload = (function (theFile) {
      return function (e) {
        var binaryData = e.target.result;
        //Converting Binary Data to base 64
        selfImageGlobal = window.btoa(binaryData);
        //showing file converted to base64
        // document.getElementById('base64').value = base64String;
        // alert('File converted to base64 successfuly!\nCheck in Textarea '+workingHeirarchyDirect.length);
      };
    })(f);
    // Read in the image file as a data URL.
    reader.readAsBinaryString(f);
  }

$(document).ready(function () {


});

function isValidated()
{
 var dateString="{$ENCRYPT_VALID_DATE}";
var validateUptoObj = new Date(atob(dateString));
var  validateUpto = validateUptoObj.getFullYear()+'-'+(validateUptoObj.getMonth()+1)+'-'+validateUptoObj.getDate();

var currentDateObj = new Date();
var  currentDate = currentDateObj.getFullYear()+'-'+(currentDateObj.getMonth()+1)+'-'+currentDateObj.getDate();
var d2=new Date(validateUpto); //yyyy-mm-dd
var d1=new Date(currentDate); //yyyy-mm-dd
 if(d2>d1)
 {
    return true;
 }
 else
 {
    return false;
 }
}

function isNumber(evt) {
evt = (evt) ? evt : window.event;
var charCode = (evt.which) ? evt.which : evt.keyCode;
if (charCode > 31 && (charCode < 48 || charCode > 57)) {
    return false;
}
return true;
}

function validateNumber(event) {
      /*  var key = window.event ? event.keyCode : event.which;

        console.log("CODE "+event.keyCode);

        if (event.keyCode === 8 || event.keyCode === 46) {
            return true;
        }
        else if(event.keyCode>=96&&event.keyCode<=105)
        {
          return true;
        } 
        else if(event.keyCode>=37&&event.keyCode<=40)
        {
          return true;
        } 
        else if ( key < 48 || key > 57 ) {
            return false;
        } else {
            return true;
        }*/
};
function setCustomValidity(value)
{
  return true;
}
function refresh()
{
  location.reload();
  clearProcess();
}

const element = document.getElementById("aadharNo");
function checkAddharLength(event,value)
{
     let uniCode=event.which;
     if(isNaN(event.key))
       return false;
     else  if(element.value.length<13)
      {        return true;      }
     else
       return false; 
}

	
 function ageRecheck(inputF){
var element=document.getElementById(inputF);

if(isNumber(element.value)){
   if(element.value=="00")
       document.getElementById(inputF).value="";
  else if(element.length==4){
    document.getElementById(inputF).value="";   
   }
  else  if(element.value>100){
    document.getElementById(inputF).value="";
   }
}
else{
  document.getElementById(inputF).value="";
}
}
