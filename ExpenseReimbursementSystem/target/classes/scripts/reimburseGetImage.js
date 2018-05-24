/**
 * 
 */

var fullNameDisp = document.getElementById("fullNameDisp");
var manFullNameDisp = document.getElementById("manFullNameDisp");
var purposeDisp = document.getElementById("purposeDisp");
var amountDisp = document.getElementById("amountDisp");
var statusDisp = document.getElementById("statusDisp");
var dateDisp = document.getElementById("dateDisp");
var img =  document.querySelector("#reimburseImage img");

var fullNameBtn = document.getElementById("reimburse");

// Modal Reimbursement Form
var viewReimburseForm = document.getElementById("viewReimburseForm");

// Hidden input on form
var reimburseHiddenInput = document.getElementById("#rIdHidden");

// view receipt button
var viewReceiptBtn = document.getElementById("viewReceiptBtn");	

viewReimburseForm.addEventListener("submit", submitReimburseForm);


function submitReimburseForm(event) {
	
	event.preventDefault();
	
	var form = event.target;
	var formData = new FormData(form);

	var url = "http://localhost:8083/ExpenseReimbursementSystem/reimbursementView";

	sendAjaxPost(url, formData, sendAjaxGet);
//	viewReimburseForm.reset();
}

// AJAX

function sendAjaxPost(url, data, callback) {
	var xhr = new XMLHttpRequest()
	|| new ActiveXObject("Microsoft.HTTPRequest");

	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			callback(url, populateReimburseModal);
//			console.log(this)
		}
	};

	xhr.open("POST", url, true);
	xhr.send(data);
}

function sendAjaxGet(url, callback) {

	var xhr = new XMLHttpRequest()
	|| new ActiveXObject("Microsoft.HTTPRequest");

	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			callback(this);
		}
	};

	xhr.open("GET", url, true);
	xhr.send();
} 

// GET callback

function populateReimburseModal(xhr) {
	fullNameDisp.innerHTML = "";
	manFullNameDisp.innerHTML = "";
	purposeDisp.innerHTML = "";
	dateDisp.innerHTML = "";
	
	if (xhr.responseText) {
		
//		console.log(xhr.responseText);
		var res = JSON.parse(xhr.responseText);
//		console.log(res);
		if (res.reimbursement) {
			fullNameDisp.innerHTML = "ReimbursementId: " + res.reimbursement.reimbursementId;
			manFullNameDisp.innerHTML = "Requester: " + res.reimbursement.firstName + res.reimbursement.lastName;
			purposeDisp.innerHTML = "Purpose: " + res.reimbursement.purpose;
			amountDisp.innerHTML = "Amount: " + res.reimbursement.amount;
			var status = res.reimbursement.status
			if (status == 0) {
				status = "Denied";
			} else if (status == 1) {
				status = "Pending";
			} else if (status == 2) {
				status = "Approved";
			}
			statusDisp.innerHTML = "Status: " + status;
			dateDisp.innerHTML = "Date Requested: " + res.reimbursement.date;

			//image
//			var img = document.getElementById("reimburseImage");
//			var img = document.createElement(img);
			if (res.reimbursement.image !== null) {
				img.src = "data:image/png;base64,"+res.reimbursement.image;
			} else {
				img.src="";
			}
//			document.getElementById("reimburseImage").appendChild(img);
//			console.log(res.reimbursement.image)
		} else {
			window.location = "http://localhost:8083/ExpenseReimbursementSystem/welcome";
		}
	} else {
		window.location = "http://localhost:8083/ExpenseReimbursementSystem/welcome";
	}
	
}
