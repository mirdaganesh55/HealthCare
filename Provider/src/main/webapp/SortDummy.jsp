
 
$(document).ready(function() {
	$(".loader-wrapper").fadeOut("slow");
	toggleRadioVisibility();
	changeArrow();
	hideTableBackground();
});
 
$(document).ready(function() {
	$(".datepicker").datepicker({
		dateFormat: 'yy-mm-dd',
		changeMonth: true,
		changeYear: true,
		yearRange: "2023:2030"
	});
});
 
jQuery(document).ready(function($) {
	$('.timepicker').timepicker({
		timeFormat: 'hh.mm p',
	    interval: 30,
	    minTime: '7',
	    maxTime: '10:00 pm',
	    startTime: '07:00 am',
	    dynamic: false,
	    dropdown: true,
	    scrollbar: false
	});
});
 
function changeArrow() {
	var appointmentIdOrder = document.getElementById('form1:AppointmentIdOrder');
	var apidArr1 = document.getElementById('apid-arr1');
	var apidArr2 = document.getElementById('apid-arr2');
 
	var patientId = document.getElementById('form1:PatientId');
	var apidArr3 = document.getElementById('apid-arr3');
	var apidArr4 = document.getElementById('apid-arr4');
 
	var firstName = document.getElementById('form1:FirstName');
	var apidArr5 = document.getElementById('apid-arr5');
	var apidArr6 = document.getElementById('apid-arr6');
 
	var lastName = document.getElementById('form1:LastName');
	var apidArr7 = document.getElementById('apid-arr7');
	var apidArr8 = document.getElementById('apid-arr8');
 
	var appointmentDate = document.getElementById('form1:AppointmentDate');
	var apidArr9 = document.getElementById('apid-arr9');
	var apidArr10 = document.getElementById('apid-arr10');
 
	var appointmentTime = document.getElementById('form1:AppointmentTime');
	var apidArr11 = document.getElementById('apid-arr11');
	var apidArr12 = document.getElementById('apid-arr12');
 
	if ('desc' === appointmentIdOrder.value) {
		apidArr2.style.display = 'none';
	}
 
	else if (patientId.value === 'desc') {
		apidArr4.style.display = 'none';
	} else if (patientId.value === 'asc') {
		apidArr3.style.display = 'none';
	}
 
	else if (firstName.value === 'desc') {
		apidArr6.style.display = 'none';
	} else if (firstName.value === 'asc') {
		apidArr5.style.display = 'none';
	}
 
	else if (lastName.value === 'desc') {
		apidArr8.style.display = 'none';
	} else if (lastName.value === 'asc') {
		apidArr7.style.display = 'none';
	}
 
	else if (appointmentDate.value === 'desc') {
		apidArr10.style.display = 'none';
	} else if (appointmentDate.value === 'asc') {
		apidArr9.style.display = 'none';
	}
 
	else if (appointmentTime.value === 'desc') {
		apidArr12.style.display = 'none';
	} else if (appointmentTime.value === 'asc') {
		apidArr11.style.display = 'none';
	}
 
	else {
		apidArr1.style.display = 'none';
	}
}
 
function toggleRadioVisibility() {
	var searchType = document.getElementById('form:searchType');
	var searchValue = document.getElementById('form:searchValue');
	var searchDate = document.getElementById('form:searchDate');
	var searchLable = document.getElementById('form:searchLable');
	var radio = document.getElementById('form:radio');
	var radiolebel = document.getElementById('form:radiolebel');
	var search = document.getElementById('form:search');
	var clear = document.getElementById('form:clear');
	var reset = document.getElementById('form:reset');
	var searchTime = document.getElementById('searchTime');
	var errMsg = document.getElementById('errMsg');
	var dateMessage = document.getElementById('form:dateMessage');
	var toggleSwitch = document.getElementById('toggleSwitch');
 
	var searchbyValue = document.getElementById('searchbyValue');
	var buttonContainer = document.getElementById('buttonContainer');
 
	if (searchType.value === 'Select') {
		radio.style.display = 'none';
		radiolebel.style.display = 'none';
		searchValue.hidden = true;
		searchDate.hidden = true;
		searchTime.hidden = true;
		searchLable.style.display = 'none';
		search.style.display = 'none';
		clear.style.display = 'none';
		reset.style.display = 'none';
	} else if (searchType.value === 'Date') {
		radio.hidden = true;
		radiolebel.hidden = true;
		searchValue.style.display = 'none';
		searchDate.style.display = 'inline-block';
		searchDate.style.position = 'relative';
		searchDate.style.top = '4px';
		searchDate.style.left = '180px';
		searchLable.style.position = 'relative';
		searchLable.style.top = '7px';
		searchLable.style.left = '-125px';
		/*errMsg.style.marginTop = "20px";*/
		dateMessage.style.top = '-3px';
 
		buttonContainer.style.marginTop = '0px';
 
	} else if (searchType.value === 'Time') {
		radio.hidden = true;
		radiolebel.hidden = true;
		searchValue.style.display = 'none';
		searchLable.style.display = 'none';
		searchTime.style.display = 'block';
		buttonContainer.style.marginTop = '35px';
		errMsg.style.position = "relative";
		errMsg.style.top = "86px";
 
	} else if (searchType.value === 'patientId') {
		radio.style.display = 'block';
		radiolebel.style.display = 'block';
		radiolebel.style.display = 'block';
		searchValue.hidden = false;
		searchLable.hidden = false;
 
		search.style.display = 'block';
		reset.style.display = 'block';
		searchbyValue.style.marginLeft = '-29px';
		errMsg.style.marginTop = "30px";
		toggleSwitch.style.marginTop = '-38px';
	} else if (searchType.value === 'Name'){
		errMsg.style.marginTop = "30px";
		toggleSwitch.style.marginTop = '-38px';
		
	} else {
		radio.style.display = 'block';
		radiolebel.style.display = 'block';
		radiolebel.style.display = 'block';
		searchValue.hidden = false;
		searchLable.hidden = false;
 
		search.style.display = 'block';
		reset.style.display = 'block';
	}
}
function clearInputText() {
	var searchValue = document.getElementById('form:searchValue');
	var searchDate = document.getElementById('form:searchDate');
	var startTime = document.getElementById('form:startTime');
	var endTime = document.getElementById('form:endTime');
 
	if (searchValue) {
		searchValue.value = '';
	}
	if (searchDate) {
		searchDate.value = '';
	}
	if (startTime) {
		startTime.value = '';
	}
	if (endTime) {
		endTime.value = '';
	}
}
function hideTableBackground() {
	var notFoundErr = document.getElementById('form1:notFoundErr');
	var table = document.getElementById('form1:table');
 
	if (notFoundErr.value === 'Record Not Found') {
		table.style.backgroundColor = '#BFD7EA';
	}
}
 