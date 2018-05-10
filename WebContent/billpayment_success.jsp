<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Successful</title>
</head>
<body>
<a href="home.jsp" >Click here to go to Home </a> 
<br>
Hi <%  out.print(request.getAttribute("id")); %> !! Payment Successful .. 
<br>
<a href="logout.jsp" >Logout </a> 
</body>
</html>