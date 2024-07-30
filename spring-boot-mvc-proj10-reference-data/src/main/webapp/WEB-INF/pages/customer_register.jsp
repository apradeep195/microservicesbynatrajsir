<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="cust" action="customer_register" name="frm">

		<table>
			<tr>
				<td>Customer Name</td>
				<td><form:input path="cname" /></td>
			</tr>

			<tr>
				<td>Country Name</td>
				<td><form:select  path="country" onchange="sendRequestForStates()">
						<form:options items="${countriesInfo}" />
					</form:select></td>
			</tr>
			
			<tr>
				<td>Select know Language</td>
				<td><form:select path="languages" multiple="multiple" size="5">
						<form:options items="${languagesInfo}" />
					</form:select></td>
			</tr>
			
			<tr>
				<td>Select state</td>
				<td><form:select path="state">
						<form:options items="${stateInfo}" />
					</form:select></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="register">
					<input type="reset" value="Cancel"></td>
			</tr>

		</table>
	</form:form>
<script language="javaScript">
function sendRequestForStates(){
	console.log('hello');
	frm.action="states";
	frm.submit();
}
</script>
</body>
</html>