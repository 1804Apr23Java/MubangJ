/**
 * 
 */

// form
var modalForm = document.querySelector(".modal-dialog .modal-content #updateUserForm");
console.log(modalForm);

// inputs
var firstInput = document.getElementById("originalVal");
var secondInput = document.getElementById("newVal");
var thirdInput = document.getElementById("reNewVal");

modalForm.addEventListener("submit", submitEditInfo);

function submitEditInfo(event) {
	event.preventDefault();
	
	var form = event.target;
	var formData = new FormData(form);
	
	var firstInputVal = firstInput.value;
	var secondInputVal = secondInput.value;
	var thirdInputVal = thirdInput.value;
		
	if (firstInputVal.length == 0 ||  secondInputVal.length == 0 || 
			thirdInputVal.length == 0) {
//		dangerStyle.style.display = "block";
		return false;
	}

	
//	var dangerStyle = document.querySelector(".alert-danger");
//	var successStyle = document.querySelector(".alert-success");
//	dangerStyle.style.display = "none";
//	successStyle.style.display = "none";

	var url = "http://localhost:8083/ExpenseReimbursementSystem/profile";

	var xhr = new XMLHttpRequest()
	|| new ActiveXObject("Microsoft.HTTPRequest");
	
	xhr.open("POST", url, true);

	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log(this.responseText);
			
		}
	};
	
	xhr.send(formData);
	
	modalForm.reset();
	window.setTimeout(function() {
		document.location.reload(true);
	}, 1000);
//	successStyle.style.display = "block";
//	for (var pair of formData.entries()) {
//	    console.log(pair[0]+ ', ' + pair[1]); 
//	}
}