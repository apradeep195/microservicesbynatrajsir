<%@ page language="java" import="java.util.*" isELIgnored="false"%>

<%

String adImages[]=new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg"}; 
int adNumber=new Random().nextInt(5);
response.setHeader("referesh","2");
%>


<img src="images/<%= adImages[adNumber]%>" alt="not found" width="350px" height="200px"/>