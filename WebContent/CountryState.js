var states = new Array();

states['india'] = new Array('New Delhi','Andaman/Nicobar Islands','Andhra Pradesh','Arunachal Pradesh','Assam|Bihar','Chandigarh','Chhattisgarh','Dadra/Nagar Haveli','Daman/Diu','Goa','Gujarat','Haryana','Himachal Pradesh','Jammu/Kashmir','Jharkhand','Karnataka','Kerala','Lakshadweep','Madhya Pradesh','Maharashtra','Manipur','Meghalaya','Mizoram','Nagaland','Orissa','Pondicherry','Punjab','Rajasthan','Sikkim','Tamil Nadu','Tripura','Uttaranchal','Uttar Pradesh','West Bengal');
states['uk'] = new Array('Scotland');
states['usa'] = new Array('New Jersey');
states['italy'] = new Array('Rome');

function setStates() {
	  cntrySel = document.getElementById('country');
	  stateList = states[cntrySel.value];
	  changeSelect('state', stateList, stateList);
	  
	}
function changeSelect(fieldID, newOptions, newValues) {
	  selectField = document.getElementById(fieldID);
	  selectField.options.length = 0;
	  for (i=0; i<newOptions.length; i++) {
	    selectField.options[selectField.length] = new Option(newOptions[i], newValues[i]);
	  }
	}

function addLoadEvent(func) {
	  var oldonload = window.onload;
	  if (typeof window.onload != 'function') {
	    window.onload = func;
	  } else {
	    window.onload = function() {
	      if (oldonload) {
	        oldonload();
	      }
	      func();
	    };
	  }
	}

	addLoadEvent(function() {
	  setStates();
	});


