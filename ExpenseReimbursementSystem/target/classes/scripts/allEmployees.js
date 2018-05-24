var table = document.querySelector("table");

var headRow = document.querySelector("table thead tr");
var body = document.querySelector("table tbody");	

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

function populateUsers(xhr) {

	
	if (xhr.responseText) {
		console.log(xhr.responseText);
		var res = JSON.parse(xhr.responseText);
		console.log(res);

		if (res.users) {

			for (i = 0, len = res.users.length; i < len; i++) {
				var row = body.insertRow(i);
				

				row.insertCell(0).innerHTML = res.users[i].userId;
				var empFullName = res.users[i].fName + " " + res.users[i].lname;
				row.insertCell(1).innerHTML = empFullName;
				row.insertCell(2).innerHTML = res.users[i].email;
				row.insertCell(3).innerHTML = res.users[i].username;
				
				var manFullName = res.users[i].manFirstName + " " + res.users[i].manLastName;
				row.insertCell(4).innerHTML = (empFullName === manFullName) ? "self" : manFullName;
				var status = res.users[i].status;

			}
			
		} else {
			window.location = "http://localhost:8083/Expenseusersystem/welcome";
		}
	} else {
		window.location = "http://localhost:8083/Expenseusersystem/welcome";
	}
}
	

window.onload = function() {
	console.log("executed window.onload");
	sendAjaxGet("http://localhost:8083/ExpenseReimbursementSystem/employees",  populateUsers);
}