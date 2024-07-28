<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Loan Approve Home</h1>
<h5>Your Approved Loan  is ::  <%= new Random().nextInt(300000) %></h5>
<a th:href="@{/bank/}">Home</a>
<br>

<a th:href="@{/logout}">logout</a>

</body>
</html>