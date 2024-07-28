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
<h1>Loan Approve Home</h1>
<h5>Your Approved Loan  is :: <%= new Random().nextInt(300000) %></h5>
<a href="./home">Home</a>
<br>

<a href="logout">logout</a>

</body>
</html>