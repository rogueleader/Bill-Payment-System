/**
 * 
 */

function getType() {
	var venType = document.getElementById("ventype").value;
	var idc = document.getElementById("id").value;
	if (venType != "-") {

		window.location.href = "http://localhost:12032/BillPaymentSystem/BillPaymentController?venType="
				+ venType + "&choice=2&" + "cid=" + idc;
	}

}
function getDuration() {/*
						 * var amount =
						 * document.getElementById("PolicyAmount").value; var
						 * arr = amount.split("-"); var duration = arr[1];
						 * //alert(duration);
						 * document.getElementById("policy_duration").value =
						 * duration;
						 */
}
function validate() {

	if (document.forms["billpayment"]["CustomerID"].value == ""
			|| document.forms["billpayment"]["Vendortype"].value == ""
			|| document.forms["billpayment"]["VendorName"].value == ""
			|| document.forms["billpayment"]["PendingAmount"].value == ""
			|| document.forms["billpayment"]["PaymentDate"].value == "" ||

			document.forms["billpayment"]["AmountToPay"].value == ""
			|| document.forms["billpayment"]["CardType"].value == ""
			|| document.forms["billpayment"]["CardNumber"].value == ""
			|| document.forms["billpayment"]["ConfirmCardNumber"].value == ""
			|| document.forms["billpayment"]["cvv"].value == ""
			|| document.forms["billpayment"]["agree"].value == ""

	) {
		document.getElementById("message").innerHTML = "One or more fields are empty...";
		document.body.scrollTop = document.documentElement.scrollTop = 0;

		return false;
	}

	if (isNaN(document.forms["billpayment"]["CustomerID"].value)) {
		document.getElementById("message").innerHTML = "Customer ID must be a number";
		document.body.scrollTop = document.documentElement.scrollTop = 0;

		return false;
	}
	if (isNaN(document.forms["billpayment"]["AmountToPay"].value)) {
		document.getElementById("message").innerHTML = "Amount to Pay must be a number";
		document.body.scrollTop = document.documentElement.scrollTop = 0;

		return false;
	}

	if (isNaN(document.forms["billpayment"]["CardNumber"].value)
			|| isNaN(document.forms["billpayment"]["ConfirmCardNumber"].value)) {
		document.getElementById("message").innerHTML = "Card Number must be a number";
		document.body.scrollTop = document.documentElement.scrollTop = 0;

		return false;
	}

	if (isNaN(document.forms["billpayment"]["cvv"].value)) {
		document.getElementById("message").innerHTML = "CVV must be a number";
		document.body.scrollTop = document.documentElement.scrollTop = 0;

		return false;
	}

	return true;

}

var monthtext = [ '01', '02', '03', '04', '05', '06', '07', '08', '09', '10',
		'11', '12' ];

function populatedropdown(monthfield, yearfield) {
	var today = new Date();

	var monthfield = document.getElementById(monthfield);
	var yearfield = document.getElementById(yearfield);

	for ( var m = 0; m < 12; m++)
		monthfield.options[m] = new Option(monthtext[m], monthtext[m]);
	monthfield.options[today.getMonth()] = new Option(monthtext[today
			.getMonth()], monthtext[today.getMonth()], true, true);

	var thisyear = today.getFullYear();
	for ( var y = 0; y < 20; y++) {
		yearfield.options[y] = new Option(thisyear, thisyear);
		thisyear += 1;
	}
	yearfield.options[0] = new Option(today.getFullYear(), today.getFullYear(),
			true, true);

}
/*
 * var cid, vtype; /*function save(){ cid=document.getElementById("id"); }
 */
/*
 * function sendval() { cid = document.getElementById("id"); vtype =
 * document.getElementById("ventype"); location.href = 'BillPayment.jsp?option=' +
 * vtype.value + '&cid=' + cid.value; }
 */
// document.getElementById("id").value=request.
