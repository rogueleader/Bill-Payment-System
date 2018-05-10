<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<TITLE>Bill Payment System</TITLE>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="style1.css">

<style type="text/css">
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
input[type=text],input[type=password]{
 width: 100px; 
  height: 30px; 
  -webkit-border-radius: 0px 4px 4px 0px/5px 5px 4px 4px; 
  -moz-border-radius: 0px 4px 4px 0px/0px 0px 4px 4px; 
  border-radius: 0px 4px 4px 0px/5px 5px 4px 4px; 
  background-color: #fff; 
  -webkit-box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
  -moz-box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
  box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
  border: solid 1px #cbc9c9;
  margin-left: 35px;
  margin-top: 13px; 
  padding-left: 10px;
  }
</style>
</HEAD>

<body style="margin-top:0px">
        <%
        	String errorMsg = "";
        	if (request.getAttribute("msg") != null) {
        		errorMsg = (String) request.getAttribute("msg");
        	}
        	session.invalidate();
        %>
             Automating Bill Payment System ... introduction
             
            <form id ="rcorners" action="AdminLoginController" method="post" style="float: right">
             
             <h3 >Admin Login</h3>
                <table>
                    <tr>
                        <td> Username: </td><td> <input name="username" size=15 type="text" /> </td> 
                    </tr>
                    <tr>
                        <td> Password: </td><td> <input name="password" size=15 type="password" /> </td> 
                    </tr>
                     </table>
                    
                     <input type="submit" value="Login" id="but" /> 
                    
                
                  <span style="color: red;font-size: 16px;"><%=errorMsg%></span>
            </form>
        
         
    </body>
</HTML> 