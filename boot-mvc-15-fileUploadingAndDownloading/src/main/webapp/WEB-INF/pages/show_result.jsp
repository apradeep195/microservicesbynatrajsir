<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Seekars Info</h3>
	<c:choose>
	<c:when test="${ !empty seekerInfo}">
	<table class="table">
	<tr>
	<th>ID</th><th>Profile Name</th><th>Gender</th><th>Resume</th><th>Photo</th>
	</tr>
	<c:forEach var="seekar" items=""${seekerInfo}>
	<tr>
	<td>${seekar.profileId }</td>
	<td>${seekar.profileName }</td>
	<td>${seekar.gender }</td>
	<td><a href="download?file=${seekar.resumePath }">${seekar.resumePath }</a></td>
	<td><a href="download?file=${seekar.photoPath }">${seekar.photoPath }</a></td>
	</tr>
	</c:forEach>
	</table>
	
	</c:when>
	<c:otherwise>
	<h1 class="text-danger">Records Not Found</h1></c:otherwise>
	
	</c:choose>
	
	
	<a hreg="./">Home</a>
	
</body>
</html>