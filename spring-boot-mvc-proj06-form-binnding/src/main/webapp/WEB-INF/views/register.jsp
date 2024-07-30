<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" 
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
    <title>Hello, world!</title>
  </head>
  <body>
    <h1>Registration Form</h1>
<form:form modelAttribute="emp">
  <div class="form-row">
  <div class="form-group col-md-6">
      <label for="inputPassword4">Emp Number</label>
      <form:input path="eno" class="form-control" placeholder="Emp No"/>
    </div>
    
    
    <div class="form-group col-md-6">
      <label for="inputEmail4">Name</label>
      <form:input  class="form-control" path="ename" placeholder="Emp Name" />
    </div>
    
    <div class="form-group col-md-6">
      <label for="inputPassword4">Salary</label>
      <form:input  class="form-control" path="salary"  placeholder="salary"/>
    </div>
    
  </div>
  
  <div class="form-group">
    <label for="inputAddress2">Address 2</label>
    <form:input  class="form-control" path="eadd"   placeholder="Apartment, studio, or floor" />
  </div>
  
  <form:button path="submit" class="btn btn-primary">Sign in</form:button>
</form:form>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>