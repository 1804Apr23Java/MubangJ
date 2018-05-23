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
//		console.log(xhr.responseText);
		var res = JSON.parse(xhr.responseText);
//		console.log(res);
		if (res.user) {
			
			document.getElementById("fullName").innerHTML = res.user.fName + " " + res.user.lname;
			document.getElementById("username").innerHTML = res.user.username;
			document.getElementById("email").innerHTML = res.user.email;


		} else {
			window.location = "http://localhost:8083/ExpenseReimbursementSystem/home";
		}
	} else {
		window.location = "http://localhost:8083/ExpenseReimbursementSystem/home";
	}
}
	

window.onload = function() {
	console.log("executed window.onload");
	sendAjaxGet("http://localhost:8083/ExpenseReimbursementSystem/session", populateUserInfo);
}