/**
 * 
 */

document.getElementById("submitReim").addEventListener("submit", submitCreateForm);

function submitCreateForm() {
	var formData = new FormData(document.getElementById("createRForm"));
	console.log(formData);

	var url = "http://localhost:8083/ExpenseReimbursementSystem/createrequest";

	var xhr = new XMLHttpRequest()
	|| new ActiveXObject("Microsoft.HTTPRequest");

	xhr.open("POST", url, true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log(this.responseText);
			
		}
	};
	
	var firstName = document.getElementById("firstName");
	var lastName = document.getElementById("lastName");
	var purpose = document.getElementById("purpose");
	var amount = document.getElementById("amount");
	var receipt = document.getElementById("receipt");

	xhr.send(encodeURI("firstName="+firstName));
}