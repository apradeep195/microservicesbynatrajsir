<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <title>Employees Reports</title>
  </head>
  <body>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="./">Home</a>
 
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="insert_employee">Add Employee </a>      
      
    </div>
  </div>
</nav>

    <h5>Employee Reports</h5>

	<c:choose>
	<c:when test="${!empty empList}">
	<table class="table">
        <thead>
          <tr>
            <th scope="col">Eno</th>
            <th scope="col">Name</th>
            <th scope="col">Designation</th>
            <th scope="col">Salary</th>
            <th scope="col">Dept No</th>
            <th scope="col">Operations</th>
          </tr>
        </thead>
        <tbody>
       <c:forEach var="emp" items="${empList}">
       <tr>
            <th scope="row">${emp.empNo}</th>
            <th scope="row">${emp.empName}</th>
            <th scope="row">${emp.job}</th>
            <th scope="row">${emp.salary}</th>
            <th scope="row">${emp.deptNo}</th>
            <th scope="row"><a href="edit_employee?eno=${emp.empNo}">Edit Employee</a> &nbsp;
            				<a href="delete_employee?eno=${emp.empNo}" onclick="confirm('Do you want to delete')">Remove Employee</a></th>
          </tr>
       </c:forEach>
          
         
        </tbody>
      </table>
	</c:when>
	
	<c:otherwise>
	<h1 class="text-danger"> Records Not Found</h1>
	</c:otherwise>
	
	</c:choose>

    <!-- Optional JavaScript; choose one of the two! -->
    
     <h2 class="text-success">${resultMsg} </h2>
    

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
  </body>
</html>