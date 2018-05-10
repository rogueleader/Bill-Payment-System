<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<%@ include file="sessioncheck.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Home Page</title>

<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="style1.css">
</head>
<body style="margin-top:0px">
	<%
		String myname = (String) session.getAttribute("username");

		if (myname != null) {
			out.println("Welcome  " + myname);
		}
	%>
	<div style="float: right;">
		<a href="index.jsp">Logout</a>
	</div>
	<br>
	<br>

	<a href="RegisterVendor.jsp">Vendor Registration </a>
	<br>
	<br>
	<a href="VendorSearch.jsp"> Vendor Update</a>
	<br>
	<br>
	<a href="CustomerRegistration.jsp">Customer Registration</a>
	<br>
	<br>
	<a href="CustomerSearch.jsp">Customer Update </a>
	<br>
	<br>
	<a href="BillPayment.jsp">Bill Payment </a>
	<br>
	<br>
</body>
</html>