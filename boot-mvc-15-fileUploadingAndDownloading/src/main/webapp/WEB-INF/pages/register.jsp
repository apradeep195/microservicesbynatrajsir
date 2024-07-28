<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
    <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Marriage Seeker Registration</h3>
<form:form modelAttribute="profile"  enctype="multipart/form-data">
<form:errors path="*"/>
  <div class="col-md-4">
    <label for="inputEmail4" class="form-label">Marraige Seekar Name</label>
    <form:input path="profileName" class="form-control" id="inputEmail4"/>
  </div>
  <div class="col-md-4">
    <label for="inputEmail4" class="form-label">Marraige Seekar Gender</label>
    <form:radiobutton path="gender" value="Male"/>Male &nbsp;&nbsp;
    <form:radiobutton path="gender" value="Female" />Female 
  </div>
  
    <div class="col-md-4">
    <label for="inputEmail4" class="form-label">Select Resume</label>
    <form:input type="file" path="resume"/>
    
  </div>
  
   <div class="col-md-4">
    <label for="inputEmail4" class="form-label">Select Photo</label>
    <form:input type="file" path="photo"/>
    
  </div>
  
  
    
  
  <div class="col-12 mt-2">
   <input type="submit" value="Register" class="btn btn-sm btn-primary"/>
   <input type="reset" value="Cancel" class="btn btn-sm btn-warning"/>
  </div>


</form:form>


</body>
</html>