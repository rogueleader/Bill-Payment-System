<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.bps.to.AmountTO"%>
<%@page import="com.bps.to.VenTO"%>
<%@page import="com.bps.dbutil.DbUtil"%>
<%@page import="com.bps.dao.*"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.*"%>





<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="style1.css">


<script src="BillPaymentValidation.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill Payment</title>
</head>
<%
String errorMsg="";
if (request.getAttribute("message")!=null)
{
	errorMsg =(String)request.getAttribute("message");
	System.out.println(errorMsg);
}
  Date date=new Date();
  SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
  String payment_Date = format.format(date);
  // payment date is defaulted to system date as per SRD
 
  
 %>
<body onload="javascript:window.history.forward(1);">
	<%@ include file="sessioncheck.jsp"%>
	<%@ include file="header.jsp"%>

    
	<%
if (request.getAttribute("found")==""||request.getAttribute("found")==null)
{try{
	if(errorMsg==null||errorMsg.isEmpty())
response.sendRedirect("BillPaymentController?choice=1");
}
catch(Exception e){
	System.out.println("idk");
	}
}
List<VenTO> venToList = new ArrayList<VenTO>();
if ( session.getAttribute("bpToList")!=null)
{
venToList = (ArrayList)session.getAttribute("bpToList");
 
}
List<AmountTO> amountToList = new ArrayList<AmountTO>();
if (request.getAttribute("amountToList")!=null)
{
amountToList = (ArrayList<AmountTO>)request.getAttribute("amountToList");
 
}
 
%>


	
	<div style="float: left;">
		<a href="home.jsp"> Home </a>
	</div>
	<div id="logout">
		<a href="logout.jsp">Logout</a>
	</div>
    <div class="testbox">
	<h1 >Bill Payment Form</h1>
	<br/>
	
	<span id="message" style="color: red; font-size: 16px; position:absolute; left: 40%"> <% out.println(errorMsg);%>
	</span>
	<br/>
	<form name="billpayment" action="BillPaymentController" method="post"
		onsubmit="return validate()">

		<table >
			
			<tr>
				<td>Customer ID</td>
				<td><input type="text" name="CustomerID" id="id"
					placeholder="Customer Id" maxlength="6" 
					value=<% if(request.getParameter("cid")!=null
							){out.println(request.getParameter("cid"));}%>>
				</td>
			</tr>

			<tr>
				<td>Vendor type :</td>
				<td><select name="Vendortype" id="ventype"
					onchange="getType();">
						<%/*
						//VendorType vendorType = new VendorType(); 
						BillPaymentDAO vendorType = new BillPaymentDAO();
						vendorType.setVendorType();
						for (String s: vendorType.getVendorType()) 
						{ 
						if(request.getParameter("option") != null && request.getParameter("option").equals(s)) 
						out.println("<option value="+s+" selected=\"selected\">"+s+"</option>"); 
						else
						out.println("<option value="+s+">"+s+"</option>"); 
						}*/


%>
						<option value="-">--Select--</option>
						<%
String selectedType="";
if (request.getAttribute("venType")!=null)
{
selectedType=(String)request.getAttribute("venType");
}
for( VenTO vTypeTo : venToList)
{
 
String venType = vTypeTo.getVentype();
//String venName = vTypeTo.getVenname();
if (venType.equals(selectedType))
{
%>
						<option value="<%=venType%>" selected="selected"><%=venType%>
						</option>


						<%
}
else
{
%>
						<option value="<%=venType%>"><%=venType %>
						</option>
						<%
}
}
%>


				</select>
				</td>
			</tr>
			<tr>
				<td>Vendor Name :</td>
				<td><select name="VendorName" id="VendorName">
						<option value="-">--Select--</option>
						<%
 
for( AmountTO aTo : amountToList)
{
String name = aTo.getVenName();
System.out.println(name);
 
 
%>

						<option value="<%=name%>"><%=name %>
						</option>
						<%
 
}
%>
						<%/*
//VendorName vendorName = new VendorName(request.getParameter("option")); //hardcoded
BillPaymentDAO vendorName = new BillPaymentDAO();
vendorName.setVendorName(request.getParameter("option"));
for(String s : vendorName.getVendorName()) 
out.println("<option value="+s+">"+s+"</option>");*/
%>
				</select>
				</td>
			</tr>

			<% /*
			BillPaymentDAO pendingAmount = new BillPaymentDAO();
			pendingAmount.setPendingAmount(request.getParameter("option"));*/
			
//PendingAmount pendingAmount = new PendingAmount(request.getParameter("option")); //hardcoded
%>

			<tr>
				<td>Pending Amount:</td>
				<td><input type="text" name="PendingAmount" 
					placeholder="Pending"
					 readonly value=<%
					if(request.getParameter("cid")!=null
					){for( AmountTO aTo : amountToList)
					{
					Double amt = aTo.getAmount();
					out.println(amt);
					  }}
					  %> >
				</td>
			</tr>
			<tr>
				<td>Payment Date:</td>
				<td><input type="text" value=<%=payment_Date%>
					name="PaymentDate" placeholder="Payment Date" readonly>
				</td>
			</tr>
			<tr>
				<td>Amount to pay</td>
				<td><input type="text" name="AmountToPay" placeholder="Amount">
				</td>
			</tr>
			<tr>
				<td>Card type :</td>
				<td><select name="CardType" id="CardType">

						<option value="P2">Debit Card</option>
						<option value="P3">Credit Card</option>

				</select>
				</td>
			</tr>
			<tr>
				<td>Card number</td>
				<td><input type="text" name="CardNumber"
					placeholder="Card Number"></td>
			</tr>
			<tr>
				<td>Confirm Card number</td>
				<td><input type="text" name="ConfirmCardNumber"
					placeholder="Card Number"></td>
			</tr>

			<tr>
				<td>Confirm Card validity:</td>
				<td><select name="MM" id="monthdropdown"
					placeholder="Card Validity"></select> <select name="yyyy"
					id="yeardropdown">
				</select> <script type="text/javascript">
					//populatedropdown(id_of_day_select, id_of_month_select, id_of_year_select)
					window.onload = function() {
						populatedropdown("monthdropdown", "yeardropdown");
					};
				</script>
			<tr>
				<td>CVV</td>
				<td><input type="text" name="cvv" maxlength="6" placeholder="CVV"></td>
			</tr>
			<tr>
				<td align="left"><input type="checkbox" name="agree">I
					Agree</td>
			</tr>
			</table>
			
			<input type="submit" value="Submit" id="but">
				<input type="reset" value="Reset" class="resetbutton">
			

		</form>
	
	</div>
</body>
</html>