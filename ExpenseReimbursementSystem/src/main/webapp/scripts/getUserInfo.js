/**
 * 
 */

/**
 * 
 */


function sendAjaxGet(url, func) {

	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");

	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};

	xhr.open("GET", url, true);
	xhr.send();
}  

function populateUserInfo(xhr) {

	
	if (xhr.responseText) {
		console.log(xhr.responseText);
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		if (res.reimbursements) {
			
			

		} else {
			window.location = "http://localhost:8083/ExpenseReimbursementSystem/profile";
		}
	} else {
		window.location = "http://localhost:8083/ExpenseReimbursementSystem/profile";
	}
}
	

window.onload = function() {
	console.log("executed window.onload");
	sendAjaxGet("http://localhost:8083/ExpenseReimbursementSystem/session", populateUserInfo);
}