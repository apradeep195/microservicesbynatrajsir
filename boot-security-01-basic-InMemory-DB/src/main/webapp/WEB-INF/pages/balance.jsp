<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Balance Page</h1>
<h5>Your CUrrent Balance is :: <%= new Random().nextInt(1000000) %></h5>
<a href="./home">Home</a><br>

<a href="logout">logout</a>
</body>
</html>