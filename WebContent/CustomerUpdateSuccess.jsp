<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Update Success </title>
</head>
<body>

<%@include file="header.jsp"%>

<br><a href="home.jsp"> <span style="float:left">Home</span></a>
<a href="logout.jsp"> <span style="float:right">Logout</span><br></a>
<center>
<font size="3" face="timesnewroman">Customer Details Updated Successfully for the customer ID <%=request.getAttribute("customerId")%></font>
</center>
</body>
</html>