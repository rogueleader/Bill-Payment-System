<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="com.bps.dao.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Calendar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="VendorUpdateValidation.js"></script>
<title>Vendor Update</title>

<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="style1.css">


</head>

<%
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String certificate_issue_date = sdf.format(date);

	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.YEAR, 15);
	Date certificate_validity_date1 = cal.getTime();
	String certificate_validity_date = sdf
			.format(certificate_validity_date1);
%>

<body>
	<%@ include file="header.jsp"%>

	<a href='home.jsp'>Home</a>
	<div id="logout">
		<a href="logout.jsp">Logout</a>
	</div>

	<br>
	<br>
	<center>
		Welcome User <b>${result.vendorName}</b>
	</center>

    <div class="testbox">
	<form name="vendorupdate" style="text-align: center;"
		onsubmit="return validateForm()" method="post"
		action="VendorUpdateController">
		<span id="message" style="color: red"></span>
		<table >
			<tr>
				<td>Vendor ID</td>
				<td><input type="text" name="vendorId"
					value="${result.vendorId}" style="background-color: lightgrey"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><input type="text" name="countryName"
					value="${result.countryName}" placeholder="Country"
					style="background-color: lightgrey" readonly="readonly" /></td>
			</tr>

			<tr>
				<td>Company Registration Number</td>
				<td><input type="text" name="RegNum"
					value="${result.companyRegNo}" style="background-color: lightgrey"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td>State</td>
				<td><input type="text" name="state" value="${result.state}"
					placeholder="State" style="background-color: lightgrey"
					readonly="readonly" /></td>
			</tr>

			<tr>
				<td>Vendor Name</td>
				<td><input type="text" name="Vendor Name"
					value="${result.vendorName}" style="background-color: lightgrey"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" id="address"
					value="${result.address}" placeholder="Address" /></td>
			</tr>

			<tr>
				<td>Vendor Type</td>
				<td><input type="text" name="Vendor Type"
					value="${result.vendorType}" style="background-color: lightgrey"
					readonly="readonly" /></td>
					</tr>
					<tr>
				<td>Contact Number</td>
				<td><input type="text" name="contactNo" id="contactNo"
					value="${result.contactNo}" placeholder="Contact Number" /></td>
			</tr>

			<tr>
				<td>Certificate</td>
				<td><input type="text" name="certificate"
					value="${result.certificate}" style="background-color: lightgrey"
					readonly="readonly" /></td>
					</tr>
					<tr>
				<td>Email Address</td>
				<td><input type="text" name="email" id="email"
					value="${result.email}" placeholder="Email" /></td>
			</tr>

			<tr>
				<td>Certificate Issued Date</td>
				<td><input type="text" name="certIssueDate"
					value=<%=certificate_issue_date%>
					style="background-color: lightgrey" readonly="readonly" />
				</td>
				</tr>
				<tr>
				<td>Web Site</td>
				<td><input type="text" name="website" id="website"
					value="${result.website}" placeholder="Website" /></td>
			</tr>

			<tr>
				<td>Certificate Validity Date</td>
				<td><input type="text" name="certValDate"
					value=<%=certificate_validity_date%>
					style="background-color: lightgrey" readonly="readonly" />
				</td>
				</tr>
				<tr>
				<td>Customer Count</td>
				<td><input type="text" name="customerCount" id="customerCount"
					value="${result.customerCount}" placeholder="Customer Count" /></td>
			</tr>

			<tr>
				<td>Year of Establishment</td>
				<td><input type="text" name="yearOfEstablish"
					value="${result.yearOfEstablish}"
					style="background-color: lightgrey" readonly="readonly" /></td>
					</tr>
					<tr>
				<td>Employee Count</td>
				<td><input type="text" name="employeeCount" id="employeeCount"
					value="${result.employeeCount}" placeholder="Employee Count" /></td>
			</tr>

            </table>
            
			<input type="submit" Value="Update" id="but" />
				<input type="reset" value="Reset" class="resetbutton" />
				
		</form>
	
	</div>
</body>
</html>