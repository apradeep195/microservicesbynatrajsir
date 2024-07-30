<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Data Renderring using Without JSP</title>
</head>
<body>
<h1 style="color: blue; text-align: center">Reading Array, Collections </h1>

<b>Nick Names(Array) :: </b><br>
<c:forEach var="name" items="${nickNames}">
${name} <br>
</c:forEach>
<hr>

<b>Phones Info(Set) :: </b><br>
<c:forEach var="ph" items="${mobilePhonesSet}">
${ph} <br>
</c:forEach>
<hr>


<b>Courses Info(List) :: </b><br>
<c:forEach var="course" items="${courseList}">
${course} <br>
</c:forEach>
<hr>


<b>IDS (Map)Courses Info :: </b><br>
<c:forEach var="id" items="${idsMap}">
${id.key} ==> ${id.value} <br>
</c:forEach>
<hr>
 

</body>
</html>