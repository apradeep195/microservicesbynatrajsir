<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
	<script src="js/form_validation.js"></script>
	
    <title>Employee Management</title>
  </head>
  <body>
    
  	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="./">Home</a>


		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="./">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="emp_report">Report</a>
				</li>

				<li class="nav-item"><a class="nav-link" href="add_employee">Add
						Employee</a></li>
						
						<li class="nav-item"><a class="nav-link" href="customerHome">Customer Home</a></li>

			</ul>

		</div>
	</nav>


<form:form modelAttribute="cust"  >
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Customer Name</label>
      <form:input  class="form-control w-50" path="cname" placeholder="Customer Name"/>
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Countries</label>
      <form:select path="country" class="form-control w-50" > 
						<form:options items="${countriesInfo}"/>
					</form:select>
    </div>
    
    
    <div class="form-group col-md-6">
      <label for="inputPassword4">Languages </label>
      <form:select path="languages" class="form-control w-50" multiple="multiple" > 
						<form:options items="${languageInfo}"/>
					</form:select>
    </div>
    
    
  </div>

  
  <button type="submit" class="btn btn-primary">Edit Employee</button>
</form:form>


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>