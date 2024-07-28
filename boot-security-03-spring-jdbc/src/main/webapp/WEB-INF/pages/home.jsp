<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Home Page</h1>

<a th:href="@{/bank/balance}">Check Balance</a>
<a th:href="@{/bank/offers}">Offers</a>
<a th:href="@{/bank/loanApprove}">Approve Loan</a>


</body>
</html>