function customersearch()
{
	var customerId = document.forms["custsearch"]["customerId"].value;
	
	if (customerId == null || customerId == "") {
		document.getElementById("message").innerHTML = "Customer Id is blank";
		document.body.scrollTop = document.documentElement.scrollTop = 0;

		return false;
	}

}


function validate()
{
	var num1=/^\d{10}$/;
	var num2=/^\d{16}$/;
	var email=/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	
	var c=document.forms["customerupdate"]["address"].value;
	var d=document.forms["customerupdate"]["contactNo"].value;
	var e=document.forms["customerupdate"]["email"].value;
	var f=document.forms["customerupdate"]["cardNo"].value;
	
if(c==null || c=="")
{
	document.getElementById("message").innerHTML="address must be filled out";
	//alert("address must be filled out...");
	document.body.scrollTop = document.documentElement.scrollTop = 0;

	return false;
}
if(d==null || d=="")
{
	document.getElementById("message").innerHTML="Contact number must be filled out";
	document.body.scrollTop = document.documentElement.scrollTop = 0;

	return false;
}

if(isNaN(d))
	{
	document.getElementById("message").innerHTML=" Invalid Contact number";
	document.body.scrollTop = document.documentElement.scrollTop = 0;

	return false;
	}
if(!num1.test(d))
{
	document.getElementById("message").innerHTML="Contact number should be 10 digit number";
	document.body.scrollTop = document.documentElement.scrollTop = 0;

	return false;
}	
if(e==null || e=="")
{
	document.getElementById("message").innerHTML="email id must be filled out";
	document.body.scrollTop = document.documentElement.scrollTop = 0;

	return false;
}
if(!email.test(e))	
{
	document.getElementById("message").innerHTML="Email id should be in the following format 'abc@xyz.com' ";
	document.body.scrollTop = document.documentElement.scrollTop = 0;

	return false;
}

if(f==null || f=="")
{
	document.getElementById("message").innerHTML="Card Number must be filled out";
	document.body.scrollTop = document.documentElement.scrollTop = 0;

	return false;
}
if(!num2.test(f))
{
	document.getElementById("message").innerHTML="Card number should be 16 digit number";
	document.body.scrollTop = document.documentElement.scrollTop = 0;

	return false;
}	
if(isNaN(f))
{
document.getElementById("message").innerHTML=" Invalid Card number";
document.body.scrollTop = document.documentElement.scrollTop = 0;

return false;
}
}
