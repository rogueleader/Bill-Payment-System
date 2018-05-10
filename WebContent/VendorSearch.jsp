<%@page import="java.awt.Color"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
	
</script>
<script src="VendorUpdateValidation.js"></script>
<title>Vendor Search</title>

<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="style1.css">
<style type="text/css">
#logout {
	position: fixed;
	text-align: right;
	right: 10px;
}

#but{

padding: 0 18px;
  height: 30px;
  width:100px;
  margin-top:20px;
  
  margin-left:30px;
  font-size: 15px;
  font-weight: bold;
  color:white;
  
  background:#57B9E0;
  border: 2px solid;
  border-color: #57B9E0;
    outline: 0;
  -webkit-box-shadow: inset 0 1px white, 0 1px 2px rgba(0, 0, 0, 0.15);
  box-shadow: inset 0 1px white, 0 1px 2px rgba(0, 0, 0, 0.15);
}
</style>
</head>

<body>
	<%@ include file="header.jsp"%>
	<a href='home.jsp'>Home</a>
	<div id="logout">
		<a href="logout.jsp">Logout</a>
	</div>

	<h1 style="color: black; text-align: center;">Vendor Search</h1>

	<form name="vendorsearch" style="text-align: center;"
		onsubmit="return search()" method="get"
		action="VendorUpdateController">

		<%
			String errMessage = "";
			if (request.getAttribute("message") != null)
			{
				errMessage = (String) request.getAttribute("message");
				
			}
			//out.println(message);
		%>

		<span id="message" style="color: red; font-weight: bold;"><%=errMessage%></span>

		<table align="center">

			<tr>
				<td>Enter Vendor Id</td>
				<td><input type="text" name="vendorId" placeholder="Vendor Id">
				</td>
			</tr>
		</table>
		<input type="submit" id="but" value="Search" name="Search" />
	</form>
</body>
</html>