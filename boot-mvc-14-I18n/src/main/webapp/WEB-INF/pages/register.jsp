<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
    <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
    <%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3><spring:message code="cust.reg.title"/> </h3>
<form:form modelAttribute="customer">
<form:errors path="*"/>
  <div class="col-md-4">
    <label for="inputEmail4" class="form-label"><spring:message code="cust.reg.name"/></label>
    <form:input path="cname" class="form-control" id="inputEmail4"/>
  </div>
  <div class="col-md-4">
    <label for="inputPassword4" class="form-label"><spring:message code="cust.reg.addrs"/></label>
    <form:input path="cadd" class="form-control" id="inputEmail4"/>
  </div>
  <div class="col-4">
    <label for="inputAddress" class="form-label"><spring:message code="cust.reg.billAmt"/></label>
    <form:input path="billAmt" class="form-control" type="number"/>
  </div>
  
  <div class="col-12 mt-2">
   <input type="submit" value="<spring:message code="cust.reg.submit"/>" class="btn btn-sm btn-primary"/>
  </div>


</form:form>

<p style="text-align:center">
<a href="?lang=fr_FR">French</a>
<a href="?lang=de_DE">GERMAN</a>
<a href="?lang=hi_IN">HINDI</a>
<a href="?lang=en_US">ENGLISH</a>
</p>
</body>
</html>