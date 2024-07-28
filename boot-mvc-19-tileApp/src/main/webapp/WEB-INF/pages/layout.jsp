<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute></title>
</head>
<body>

	<table border="0" height="100%" width="100%" row="3" cols="3">
		<tr height="30%" bgcolor="pink">
			<td colspan="3"><tiles:insertAttribute name="header"></tiles:insertAttribute>
			</td>
		</tr>
		
		<tr height="60%">
			<td width="20%" bgcolor="yellow"><tiles:insertAttribute name="menu"></tiles:insertAttribute>
			<td width="60%" bgcolor="cyan"><tiles:insertAttribute name="body"></tiles:insertAttribute>
			<td width="20%" bgcolor="grey"><tiles:insertAttribute name="advertisement"></tiles:insertAttribute>
			</td>
		</tr>
		
		<tr height="10%" bgcolor="red">
			<td colspan="3"><tiles:insertAttribute name="footer"></tiles:insertAttribute>
			</td>
		</tr>
		
	</table>
</body>
</html>