<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.bps.to.VendorTO"%>
<%@page import="com.bps.to.StateTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Vendor Registration </title>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$( document ).ready(function() {
    $("#country").change(function (){
    	var country=$("#country").val();
    	//alert(country);
    	$.ajax({url: "RegisterVendorController",
    		data:{country:country,choice:"2"},
    		success: function(result){
           // alert(result);
            $("#myStateList").empty();
            $("#myStateList").append(result);
        }});
    });
});
</script>

<script type="text/javascript">

function getState()
{
	var  country = document.getElementById("country").value;
	if (country!="-")
	{
	window.location.href="http://localhost:12032/BillPaymentSystem/RegisterVendorController?country="+country+"&choice=2";
	}
	
	}
	
function getVendorName(){
	var companyRegno=document.getElementById("companyRegNo").value;
	window.location.href="http://localhost:12032/BillPaymentSystem/RegisterVendorController?companyRegNo="+companyRegno+"&choice=3";
	
}
</script>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="style1.css">
</head>
<body >

<%@ include file="header.jsp"%>




      <a href='home.jsp'>Home</a>
      <div id="logout"><a href="logout.jsp">Logout</a></div>
      
      <br>
      <br>

<%
if (request.getAttribute("found")==null)
{
	response.sendRedirect("RegisterVendorController?choice=1");
}
List<String> countryList=new ArrayList<String>();
if(session.getAttribute("countryList")!=null){
	countryList=(ArrayList)session.getAttribute("countryList");
	
}
List<String> regNoList=new ArrayList<String>();
if(session.getAttribute("regNoList")!=null){
	regNoList=(ArrayList)session.getAttribute("regNoList");
}

List<StateTO> stateList  = new ArrayList<StateTO>();
if (session.getAttribute("stateList")!=null)
{
	stateList = (ArrayList<StateTO>)session.getAttribute("stateList");
}
//String vendorName=null;
//String vendorType=null;
//if(request.getAttribute("vendorName")!=null){
//	vendorName=(String)request.getAttribute("vendorName");
//}
//if(request.getAttribute("vendorType")!=null){
	//vendorType=(String)request.getAttribute("vendorType");
//}
%>
<%
String errorMsg="";
if(request.getAttribute("errMsg")!=null)
{
	errorMsg=(String) request.getAttribute("errMsg");
	 //out.println(errorMsg);
}
List<String> errorList = new ArrayList<String>();
for(int i=0;i<12;i++)
{
      errorList.add("");
}
if (request.getAttribute("errorList")!=null)
{
     
      errorList = (ArrayList<String>)request.getAttribute("errorList");
}
%>
<div class="testbox">
<h1 >Vendor Registration</h1>

<form action="RegisterVendorController" method="post"  > 
<span style="color:red;font-size:16px;"><%=errorMsg %></span>
<table >
<tr>
<td>Company Registration Number</td>
<td><select name="companyRegNo"  id="companyRegNo" onchange="getVendorName()">
<option value="-">--Select--</option>
<%
String companyRegNo ="";
if (session.getAttribute("companyRegno")!=null)
{
	companyRegNo=(String)session.getAttribute("companyRegno");
}

for(String temp:regNoList){
	String regNo=temp;
	if (companyRegNo.equals(regNo))
	{

%>
	<option value="<%=regNo%>" selected="selected"><%=regNo%></option>
<%	
	}
	else
	{
%>
	<option value="<%=regNo%>"><%=regNo%></option>
<%
}
}
%>

</select>
</td>

<td><span class="err"><%=errorList.get(0)%></span>
</tr>
<tr>
<td>Vendor Name</td>
<td><input name="name" id="name" value="<% if(session.getAttribute("vendorName")!=null
							){out.println(session.getAttribute("vendorName"));}%>" readonly="readonly">

</td>
<td><span class="err"><%=errorList.get(1)%></span>
</tr>
<tr>
<td>Vendor Type</td>
<td><input name="vendorType" id="vendorType" value="<% if(session.getAttribute("vendorType")!=null)
{out.println(session.getAttribute("vendorType"));} %>" readonly="readonly"></td>
<td><span class="err"><%=errorList.get(2)%></span>
</tr>
<tr>
<td>Address</td>
<td><textarea name="address" id="address" rows="4" cols="25"></textarea>
</td>
<td><span class="err"><%=errorList.get(3)%></span>
</tr>
<tr>
<td>Country</td>
<td><select name="country"  id="country" onchange="">
<option value="-">--Select--</option>
<%
String countryName ="";
if (session.getAttribute("countryName")!=null)
{
	countryName=(String)session.getAttribute("countryName");
}

for(String temp:countryList){
	String country=temp;
	if (countryName.equals(country))
	{

%>
	<option value="<%=country%>" selected="selected"><%=country%></option>
<%	
	}
	else
	{
%>
	<option value="<%=country%>"><%=country%></option>
<%
}
}
%>

</select>
</td>
<td><span class="err"><%=errorList.get(4)%></span>
</tr>
<tr>
<td>State</td>
<td>
<select name="state" id="myStateList">
<option value="-">--Select--</option>


</select>




</td>
<td><span class="err"><%=errorList.get(5)%></span>
</tr>
<tr>
<td>Email Address</td>
<td><input type="text" name="email" id="email"></td>
<td><span class="err"><%=errorList.get(6)%></span>
</tr>
<tr>
<td>Contact Number</td>
<td><input type="text" name="contact" id="contact"></td>
<td><span class="err"><%=errorList.get(7)%></span>
</tr>
<tr>
<td>Website</td>
<td><input type="text" name="website" id="website"></td>
<td><span class="err"><%=errorList.get(8)%></span>
</tr>
<tr>
<td>Employees Count</td>
<td><input type="text" name="eCount" id="eCount"></td>
<td><span class="err"><%=errorList.get(9)%></span>
</tr>
<tr>
<td>Customer Count</td>
<td><input type="text" name="cCount" id="cCount"></td>
<td><span class="err"><%=errorList.get(10)%></span>
</tr>
<tr>
<td>Year Of Establishment</td>
<td><input type="text" name="yoe" id="yos"></td>
<td><span class="err"><%=errorList.get(11)%></span>
</tr>
<tr>
<td>Certificate Issued Date</td>
<%Date today=new Date();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
String day=sdf.format(today);%>
<td><input type="text" name="issue" id="issue" value="<%=day %>" readonly="readonly"></td>
</tr>
<tr>
<td>Certificate Validity Date</td>
<%Calendar cal=Calendar.getInstance();
cal.add(Calendar.YEAR,15);
Date valid_date=cal.getTime();
String v_date=sdf.format(valid_date);
%>
<td><input type="text" name="validity" id="validity" value="<%=v_date%>" readonly="readonly"></td>
</tr>
</table>

<input type="submit" value="Register" id="but">
<input type="reset" value="Reset" class="resetbutton">


</form>
</div>

</body>
</html>