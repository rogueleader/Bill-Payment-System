function search()
{
	var vId = document.forms["vendorsearch"]["vendorId"].value;
	
	if (vId == null || vId == "") {
		document.getElementById("message").innerHTML = "Vendor Id must be filled out";
		document.body.scrollTop = document.documentElement.scrollTop = 0;

		return false;
	}

}

function validateForm() {
	var num1 = /^\d{10}$/;
	var email = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var web = /^w{3}\.([a-zA-Z0-9])+\.com$/;
	
	var a = document.forms["vendorupdate"]["countryName"].value;
	var b = document.forms["vendorupdate"]["state"].value;
	var c = document.forms["vendorupdate"]["address"].value;
	var d = document.forms["vendorupdate"]["contactNo"].value;
	var e = document.forms["vendorupdate"]["email"].value;
	var f = document.forms["vendorupdate"]["website"].value;
	var g = document.forms["vendorupdate"]["customerCount"].value;
	var h = document.forms["vendorupdate"]["employeeCount"].value;
	
	if (a == null || a == "") {
		document.getElementById("message").innerHTML = "Country must be filled out";
		document.body.scrollTop = document.documentElement.scrollTop = 0;

		return false;
	}
	if (b == null || b == "") {
		document.getElementById("message").innerHTML = "State must be filled out";
		document.body.scrollTop = document.documentElement.scrollTop = 0;

		return false;
	}
	if (c == null || c == "") {
		document.getElementById("message").innerHTML = "address must be filled out";
		document.body.scrollTop = document.documentElement.scrollTop = 0;

		return false;
	}
	if (d == null || d == "") {
		document.getElementById("message").innerHTML = "Contact number must be filled out";
		document.body.scrollTop = document.documentElement.scrollTop = 0;

		return false;
	}

	if (isNaN(d)) {
		document.getElementById("message").innerHTML = " Invalid Contact number";
		document.body.scrollTop = document.documentElement.scrollTop = 0;

		return false;
	}
	if (!num1.test(d)) {
		document.getElementById("message").innerHTML = "Contact number should be 10 digit number";
		document.body.scrollTop = document.documentElement.scrollTop = 0;

		return false;
	}
	if (e == null || e == "") {
		document.getElementById("message").innerHTML = "email id must be filled out";
		document.body.scrollTop = document.documentElement.scrollTop = 0;

		return false;
	}
	if (!email.test(e)) {
		document.getElementById("message").innerHTML = "Email id should be in the following format 'abc@xyz.com' ";
		document.body.scrollTop = document.documentElement.scrollTop = 0;

		return false;
	}
	if (f == null || f == "") {
		document.getElementById("message").innerHTML = "website must be filled out";
		document.body.scrollTop = document.documentElement.scrollTop = 0;

		return false;
	}
	if (!web.test(f)) {
		document.getElementById("message").innerHTML = "website must be in the format www.abc.com";
		document.body.scrollTop = document.documentElement.scrollTop = 0;

		return false;
	}
	if (g == null || g == "") {
		document.getElementById("message").innerHTML = "Customer count must be filled out";
		document.body.scrollTop = document.documentElement.scrollTop = 0;

		return false;
	}
	if (isNaN(g) || g < 0) {
		document.getElementById("message").innerHTML = " Invalid Customer count";
		document.body.scrollTop = document.documentElement.scrollTop = 0;

		return false;
	}
	if (h == null || h == "") {
		document.getElementById("message").innerHTML = "Employee count must be filled out";
		document.body.scrollTop = document.documentElement.scrollTop = 0;

		return false;
	}
	if (isNaN(h) || h < 0) {
		document.getElementById("message").innerHTML = " Invalid Employee count";
		document.body.scrollTop = document.documentElement.scrollTop = 0;

		return false;
	}

}