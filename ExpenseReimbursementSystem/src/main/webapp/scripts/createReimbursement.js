/**
 * 
 */


document.getElementById("createRForm").addEventListener("submit", submitCreateForm);

function submitCreateForm(event) {
	
	event.preventDefault();
	
	var form = event.target;
	var formData = new FormData(form);
	
	var dangerStyle = document.querySelector(".alert-danger");
	var successStyle = document.querySelector(".alert-success");
	dangerStyle.style.display = "none";
	successStyle.style.display = "none";
	
	var firstName = document.getElementById("firstName").value;
	var lastName = document.getElementById("lastName").value;
	var purpose = document.getElementById("purpose").value;
	var amount = document.getElementById("amount").value;
	var receipt = document.getElementById("receipt").value;

	if (firstName.length == 0 ||  lastName.length == 0 || 
			purpose.length == 0 || amount.length == 0) {
		dangerStyle.style.display = "block";
		return false;
	}
	
	var url = "http://localhost:8083/ExpenseReimbursementSystem/createrequest";

	var xhr = new XMLHttpRequest()
	|| new ActiveXObject("Microsoft.HTTPRequest");
	
	xhr.open("POST", url, true);
	
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log(this.responseText);
			
		}
	};
	
	xhr.send(formData);

	document.getElementById("createRForm").reset();
	successStyle.style.display = "block";
//	for (var pair of formData.entries()) {
//	    console.log(pair[0]+ ', ' + pair[1]); 
//	}
}