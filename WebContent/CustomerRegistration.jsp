<%@page import="java.util.StringTokenizer"%>
<%@page import="sun.util.locale.StringTokenIterator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.bps.to.StateTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>

<script type="text/javascript">
$( document ).ready(function() {
    $("#country").change(function (){
      var country=$("#country").val();
      //alert(country);
      $.ajax({url: "CustomerRegistrationController",
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
$( document ).ready(function() {
	
    $("#identificationDocument").change(function (){
      var identificationDocument=$("#identificationDocument").val();
      var arr =identificationDocument.split("-");
    //  alert(arr[1]);
      $("#prefixFormat").val(arr[1]);
        });
    
});
</script>
<script type="text/javascript">
 
function getState()
{
      var  country = document.getElementById("country").value;
      if (country!="-")
      {
      window.location.href="http://localhost:9090/BillPaymentSystem/CustomerRegistrationController?country="+country+"&choice=2";
      }
     
      }
     
function getprefixFormat()
{
      var  identificationDocument = document.getElementById("identificationDocument").value;
      if (identificationDocument!="-")
      {
      window.location.href="http://localhost:9090/BillPaymentSystem/CustomerRegistrationController?identificationDocument="+identificationDocument+"&choice=3";
      }
     
      }

      </script>
      
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
      <div id="logout"><a href="logout.jsp">Logout</a></div>
      
      <br>
      <br>


<%
if (request.getAttribute("found")==null)
{
      response.sendRedirect("CustomerRegistrationController?choice=1");
}
List<String> countryList=new ArrayList<String>();
if(session.getAttribute("countryList")!=null){
      countryList=(ArrayList)session.getAttribute("countryList");
     
}
 
List<StateTO> stateList  = new ArrayList<StateTO>();
if (session.getAttribute("stateList")!=null)
{
      stateList = (ArrayList<StateTO>)session.getAttribute("stateList");
}

List<String> identificationDocumentList=new ArrayList<String>();
if(session.getAttribute("identificationDocumentList")!=null){
	identificationDocumentList=(ArrayList)session.getAttribute("identificationDocumentList");
     
}
 String prefixFormat= new String();
 if (session.getAttribute("prefixFormat")!=null)
 {
	 prefixFormat = (String)session.getAttribute("prefixFormat");
 }
%>
<%
String errorMsg="";
if(request.getAttribute("errMsg")!=null)
{
	errorMsg=(String)request.getAttribute("errMsg");
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
<span style="color: red;font-size:15px "><%=errorMsg %></span>
<div class="testbox">
<h1 >Customer Registration</h1>
<form  action="CustomerRegistrationController" method="post">
<table >
<tr>
<td>Customer Name</td>
<td><input type="text" name="customerName"></td>
<td> <span class="err"><%=errorList.get(0)%></span>
</tr>
<tr>
<td>Address</td>
<td><textarea name="address" id="address" rows="4" cols="30"></textarea>
</td>
<td> <span class="err"><%=errorList.get(1)%></span>
</tr>
<tr>
<td>Contact Number</td>
<td><input type="text" name="contactNumber"></td>
<td> <span class="err"><%=errorList.get(2)%></span>
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
<td> <span class="err"><%=errorList.get(3)%></span>
</tr>
<tr>
<td>State</td>
<td>
<select name="state" id="myStateList">
<option value="-">--Select--</option>
</select>
</td>
<td> <span class="err"><%=errorList.get(4)%></span>
</tr>
<tr>
<td>Mail Id</td>
<td><input type="text" name="mailId"></td>
<td> <span class="err"><%=errorList.get(5)%></span>
</tr>
<tr><td>Identification document</td>
<td><select name="identificationDocument"  id="identificationDocument" onchange="">
<option value="-">--Select--</option>
<%
String identificationDocumentName ="";
if (session.getAttribute("identificationDocumentName")!=null)
{
	identificationDocumentName=(String)session.getAttribute("identificationDocumentName");
}
 
for(String temp:identificationDocumentList){
StringTokenizer st = new StringTokenizer(temp,"-");
	
      String identificationDocument=st.nextToken();
      if (identificationDocumentName.equals(identificationDocument))
      {
 
%>
      <option value="<%=temp%>" selected="selected"><%=identificationDocument%></option>
<%   
      }
      else
      {
%>
      <option value="<%=temp%>"><%=identificationDocument%></option>
<%
}
}
%>
 
</select>
</td>
<td> <span class="err"><%=errorList.get(6)%></span>
</tr>
<tr>
<td>Document Detail Number</td>
<td><input type="text"  width="10" name="prefixFormat" id="prefixFormat" readonly="readonly"> </td>
<td>
<input type="text" name="documemtDetailNumber" id="documemtDetailNumber"></td>

<td> <span class="err"><%=errorList.get(7)%></span>
</tr>
<tr>
<td>Registration date</td>
<%Date today=new Date();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
String day=sdf.format(today);%>
<td><input type="text" name="registrationDate" id="registrationDate" value="<%=day %>"></td>
<td> <span class="err"><%=errorList.get(8)%></span>
</tr>
<tr>
<td>Type of vendor</td>
<td><select name="typeOfVendor" id="typeOfVendor" >
<option value="-">--Select---</option>
<option value="electricity">Electricity</option>
<option value="telephone">Telephone</option>
<option value="insurance">Insurance</option>
<option value="tax">Tax</option></select>
</td>
<td> <span class="err"><%=errorList.get(9)%></span>
</tr>
<tr>
<td>Card No</td>
<td><input type="text" name="cardNo"></td>
<td> <span class="err"><%=errorList.get(10)%></span>
</tr>
<tr>
<td>Balance</td>
<td><input type="text" name="balance"></td>
<td> <span class="err"><%=errorList.get(11)%></span>
</tr>
</table>

<input type="submit" value="Register" id=but >

<input type="reset" value="Reset" class="resetbutton">



</form>
</div>
</body>
</html>