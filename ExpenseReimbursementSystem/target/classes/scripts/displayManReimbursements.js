/**
 * 
 */

// table and table rows
var table = document.querySelector("table");

var headRow = document.querySelector("table thead tr");
var body = document.querySelector("table tbody");	

var hRow0 = headRow.insertCell(0);
hRow0.outerHTML = "<th>ReimbursementId</th>";
hRow0.setAttribute("scope", "col");	

var hRow1 = headRow.insertCell(1);
hRow1.outerHTML = "<th>Manager</th>"
	hRow1.setAttribute("scope", "col");

var hRow2 = headRow.insertCell(2);
hRow2.outerHTML = "<th>Requester</th>"
	hRow2.setAttribute("scope", "col");	

var hRow3 = headRow.insertCell(3);
hRow3.outerHTML = "<th>Purpose</th>";
hRow3.setAttribute("scope", "col");	

var hRow4 = headRow.insertCell(4);
hRow4.outerHTML = "<th>Amount</th>";
hRow4.setAttribute("scope", "col");	

var hRow5 = headRow.insertCell(5);
hRow5.outerHTML = "<th>Status</th>";
hRow5.setAttribute("scope", "col");	

var hRow6 = headRow.insertCell(6);
hRow6.outerHTML = "<th>Date Created</th>";
hRow6.setAttribute("scope", "col");	

// modal elements
var fullNameDisp = document.getElementById("fullNameDisp");
var manFullNameDisp = document.getElementById("manFullNameDisp");
var purposeDisp = document.getElementById("purposeDisp");
var amountDisp = document.getElementById("amountDisp");
var statusDisp = document.getElementById("statusDisp");
var dateDisp = document.getElementById("dateDisp");
var img = document.getElementById("reimburseImage");
var img =  document.querySelector("#reimburseImage img");

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

//function sendAjaxPost(url, data, func) {
//
//	var xhr = new XMLHttpRequest()
//			|| new ActiveXObject("Microsoft.HTTPRequest");
//
//	xhr.onreadystatechange = function() {
//		if (this.readyState == 4 && this.status == 200) {
//			console.log(this.responseText)
//		}
//	};
//
//	xhr.open("POST", url, true);
//	xhr.send(data);
//	func();
//}

function populateReimbursements(xhr) {

	
	if (xhr.responseText) {
//		console.log(xhr.responseText);
		var res = JSON.parse(xhr.responseText);
//		console.log(res);
		if (res.reimbursements.length == 0) {
			document.getElementById("filterForm").style.diplay = "none";
			document.getElementById("Test").innerHTML = "There are no requests to be displayed at this time."
			return false;
		}
		if (res.reimbursements) {

			for (i = 0, len = res.reimbursements.length; i < len; i++) {
				var row = body.insertRow(i);
				
				var reimbursementId = res.reimbursements[i].reimbursementId;

				var td0 = row.insertCell(0)
				td0.innerHTML = reimbursementId;
				td0.classList.add("showReimburse");
				td0.setAttribute("data-toggle", "modal");
				td0.setAttribute("data-target", ".bd-example-modal-lg");
				
				row.insertCell(1).innerHTML = res.reimbursements[i].manFirstName + " " + res.reimbursements[i].manLastName;
				row.insertCell(2).innerHTML = res.reimbursements[i].firstName + " " + res.reimbursements[i].lastName;
				row.insertCell(3).innerHTML = res.reimbursements[i].purpose;
				row.insertCell(4).innerHTML = res.reimbursements[i].amount;
				var status = res.reimbursements[i].status;
				
				switch(status) {
				case 0:
					row.insertCell(5).innerHTML = "Denied";
					break;
				case 1:
					row.insertCell(5).innerHTML = "Pending";
					break;
				case 2:
					row.insertCell(5).innerHTML = "Approved";
					break;
				}
				row.insertCell(6).innerHTML = res.reimbursements[i].date;
			}
			
			var td0Listner = document.querySelectorAll("table #RowForBody .showReimburse");
//			console.log(td0Listner[0]);
			for (var i = 0, len = td0Listner.length; i < len; i ++) {
				
				td0Listner[i].addEventListener("click", function(event) {
					
					fullNameDisp.innerHTML = "";
					manFullNameDisp.innerHTML = "";
					purposeDisp.innerHTML = "";
					amountDisp.innerHTML = "";
					statusDisp.innerHTML = "";
					dateDisp.innerHTML = "";
					img.src = "";
					
					var reimbursementId = event.target.innerHTML;

					document.getElementById("rIdHidden").setAttribute("value", reimbursementId);
				
				})
			}
			

		} else {
			window.location = "http://localhost:8083/ExpenseReimbursementSystem/welcome";
		}
	} else {
		window.location = "http://localhost:8083/ExpenseReimbursementSystem/welcome";
	}
}
	

window.onload = function() {
//	console.log("executed window.onload");
	sendAjaxGet("http://localhost:8083/ExpenseReimbursementSystem/allreimbursements",  populateReimbursements);
}