<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registration Form</h1>
<form:form modelAttribute="cricketer">
<table>
<tr>
<td>Name</td>
<td><form:input path="name" /></td>
</tr>

<tr>
<td>Date of Birth</td>
<td><form:input path="type" type="date" /></td>
</tr>


<tr>
<td>Cricket Join Date</td>
<td><form:input path="type"  type="date"/></td>
</tr>


<tr>
<td><input type="submit" name="register"/></td>
<td><input type="reset" name="cancel"/></td>
</tr>


</table>
</form:form>

</body>
</html>