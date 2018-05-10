<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="com.bps.dao.*"%>
<%@ page import="java.util.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	ArrayList<String> list = new ArrayList<String>();
%>
<script type="text/javascript">
	
</script>

<script src="CustomerUpdateValidation.js"></script>
<title>customer Update</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="style1.css">


<style type="text/css">
#logout {
	position: fixed;
	text-align: right;
	right: 10px;
}
</style>
</head>

<body>
	<%@ include file="header.jsp"%>

	<a href='home.jsp'>Home</a>
	<div id="logout">
		<a href="logout.jsp">Logout</a>
	</div>

	<br>
	<br>
	<center>
	
		Welcome User <b>${result.customerName}</b>
	</center>
	<div class="testbox">
	<form name="customerupdate" style="text-align: center;"
		onsubmit="return validate()" method="post"
		action="CustomerUpdateController">
		<span id="message" style="color: red"></span>
		<table >

			<tr>
				<td>Customer ID</td>
				<td><input type="text" name="customerId"
					value="${result.customerId}" style="background-color: lightgrey"
					READONLY /></td>
			</tr>
			<tr>
				<td>Customer Name</td>
				<td><input type="text" name="Customer Name"
					value="${result.customerName}" style="background-color: lightgrey"
					READONLY /></td>
			</tr>

			<tr>
				<td>Country</td>
				<td><input type="text" name="countryName"
					value="${result.countryName}" placeholder="Country"
					style="background-color: lightgrey" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>State</td>
				<td><input type="text" name="state" value="${result.state}"
					placeholder="State" style="background-color: lightgrey"
					readonly="readonly" /></td>
			</tr>

			<tr>
				<td>Address</td>
				<td><input type="text" name="address" id="address"
					value="${result.address}" placeholder="Address" /></td>
			</tr>
			<tr>
				<td>Contact Number</td>
				<td><input type="text" name="contactNo" id="contactNo"
					value="${result.contactNo}" placeholder="Contact Number" /></td>
			</tr>

			<tr>
				<td>Country ID</td>
				<td><input type="text" name="countryId" id="countryId"
					value="${result.countryId}" placeholder="Country Id"
					style="background-color: lightgrey" READONLY /></td>
			</tr>
			<tr>
				<td>Registration Date</td>
				<td><input type="text" name="regDate" id="regDate"
					value="${result.regDate}" placeholder="Registration Date"
					style="background-color: lightgrey" READONLY /></td>
			</tr>


			<tr>
				<td>Email Address</td>
				<td><input type="text" name="email" id="email"
					value="${result.email}" placeholder="Email" /></td>
			</tr>
			<tr>

				<%--	<td>Vendor Type</td>
				<td><select name="VendorType"">
						<option value="-">--Select--</option>
						<option value="-">Electricity</option>
						<option value="-">Telephone</option>
						<option value="-">Insurance</option>
						<option value="-">Tax</option>
						
				</td>
				--%>

				<td>Vendor Type</td>
				<td><input type="text" name="vendorType" id="vendorType"
					value="${result.vendorType}" placeholder="Vendor Type" /></td>
			</tr>

			<tr>
				<td>Card Number</td>
				<td><input type="text" name="cardNo" id="cardNo"
					value="${result.cardNo}" placeholder="Card Number" /></td>
			</tr>
			<tr>
				<td>Balance</td>
				<td><input type="text" name="balance" value="${result.balance}"
					placeholder="Balance" style="background-color: lightgrey" READONLY />
				</td>
			</tr>

			<tr>
				<td>Identification document</td>
				<td><input type="text" name="idDoc" id="idDoc"
					value="${result.idDoc}" placeholder="Identification document"
					style="background-color: lightgrey" readonly /></td>
			</tr>
			<tr>
				<td>Identification Number</td>
				<td><input type="text" name="idNo" id="idNo"
					value="${result.idNo}" placeholder="Identification Number"
					style="background-color: lightgrey" readonly /></td>
			</tr>
            </table>
			
				<input type="submit" Value="Update" id="but" />
				
				<input type="reset" value="Reset" class="resetbutton" />
			
		
	</form>
	</div>
</body>
</html>