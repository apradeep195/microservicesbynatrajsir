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
<h3>Cricketer Registration page</h3>
<form:form modelAttribute="crickt">
<form:errors path="*"/>
  <div class="col-md-4">
    <label for="inputEmail4" class="form-label">Cricketer Name</label>
    <form:input path="name" class="form-control" id="inputEmail4"/>
  </div>
  <div class="col-md-4">
    <label for="inputPassword4" class="form-label">Cricketer Type</label>
    <form:input path="type" class="form-control" id="inputEmail4"/>
  </div>
  <div class="col-4">
    <label for="inputAddress" class="form-label">Cricketer DOB</label>
    <form:input path="dob" class="form-control" type="date"/>
  </div>
  <div class="col-4">
    <label for="inputAddress2" class="form-label">Date of Joining</label>
     <form:input path="doj" class="form-control" type="date"/>
  </div>
  
  
  
  
  <div class="col-12 mt-2">
    <button type="submit" class="btn btn-primary">Sign in</button>
     <button type="reset" class="btn btn-primary">Cancel</button>
  </div>


</form:form>
</body>
</html>