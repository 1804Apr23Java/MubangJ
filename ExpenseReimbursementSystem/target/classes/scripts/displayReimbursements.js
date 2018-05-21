/**
 * 
 */

var table = document.querySelector("table");

var headRow = document.querySelector("table thead tr");
var body = document.querySelector("table tbody");	

var hRow0 = headRow.insertCell(0);
hRow0.outerHTML = "<th>ReimbursementId</th>";
hRow0.setAttribute("scope", "col");	

var hRow1 = headRow.insertCell(1);
hRow1.outerHTML = "<th>Requester</th>"
	hRow1.setAttribute("scope", "col");	

var hRow2 = headRow.insertCell(2);
hRow2.outerHTML = "<th>Purpose</th>";
hRow2.setAttribute("scope", "col");	

var hRow3 = headRow.insertCell(3);
hRow3.outerHTML = "<th>Amount</th>";
hRow3.setAttribute("scope", "col");	

var hRow4 = headRow.insertCell(4);
hRow4.outerHTML = "<th>Status</th>";
hRow4.setAttribute("scope", "col");	

var hRow5 = headRow.insertCell(5);
hRow5.outerHTML = "<th>Date Created</th>";
hRow5.setAttribute("scope", "col");	

var radios = document.forms["filterForm"].elements["filterType"];
for (var i = 0, len = radios.length; i < len; i++) {
	radios[i].addEventListener("click", filterReim);
}

function filterReim(event) {
	var tBody = table.querySelectorAll("table tbody")[0]
	var tBodyChildrenArr = tBody.children;
	
	var radioVal = event.target.value;
	
	if (radioVal === "allR") {

		for ( i = 0, len = tBodyChildrenArr.length; i < len; i++) {

			tBodyChildrenArr[i].style.display = "table-row";
		}
		
	} else if (radioVal === "pendR") {
		for ( i = 0, len = tBodyChildrenArr.length; i < len; i++) {
			if (tBodyChildrenArr[i].cells[4].innerHTML !== "Pending") {
				tBodyChildrenArr[i].style.display = "none";
			}  else {

				tBodyChildrenArr[i].style.display = "table-row";
			}
		}
		
	} else if (radioVal === "resR") {

		for ( i = 0, len = tBodyChildrenArr.length; i < len; i++) {

			var innerhtml = tBodyChildrenArr[i].cells[4].innerHTML
			if (innerhtml === "Approved" || innerhtml === "Denied") {
				console.log("resolved display none")

				tBodyChildrenArr[i].style.display = "table-row";
			}  else {

				tBodyChildrenArr[i].style.display = "none";
			}
		}
		
	}	

}

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

function populateReimbursements(xhr) {

	
	if (xhr.responseText) {
//		console.log(xhr.responseText);
		var res = JSON.parse(xhr.responseText);
//		console.log(res);
		if (res.reimbursements) {
			for (i = 0, len = res.reimbursements.length; i < len; i++) {
				var row = body.insertRow(i);
				
				var reimbursementId = res.reimbursements[i].reimbursementId;
				var anchor = document.createElement("a");
				anchor.setAttribute("href", "/ExpenseReimbursementSystem/reimbursement/"+reimbursementId);
				anchor.innerHTML = reimbursementId;

				var cell0 = row.insertCell(0);
				cell0.appendChild(anchor);
				
				row.insertCell(1).innerHTML = "JJ Mubang";
				row.insertCell(2).innerHTML = res.reimbursements[i].purpose;
				row.insertCell(3).innerHTML = res.reimbursements[i].amount;
				var status = res.reimbursements[i].status;
				if (status === 0) {
					row.insertCell(4).innerHTML = "Denied";
				} else if (status === 1) {
					row.insertCell(4).innerHTML = "Pending";
				} else if (status === 2) {
					row.insertCell(4).innerHTML = "Approved";
				}
				row.insertCell(5).innerHTML = res.reimbursements[i].date;
			}
			
//			var tableArr = table.querySelectorAll("table tbody");
//			console.log(tableArr[0].children[0].cells[4].innerHTML);
			
//			var img = document.createElement('img');
//			img.src = "data:image/png;base64,"+res.reimbursements[0].image;
//			document.getElementById("Test").appendChild(img);
		} else {
			window.location = "http://localhost:8083/ExpenseReimbursementSystem/welcome";
		}
	} else {
		window.location = "http://localhost:8083/ExpenseReimbursementSystem/welcome";
	}
}
	

window.onload = function() {
	console.log("executed window.onload");
	sendAjaxGet("http://localhost:8083/ExpenseReimbursementSystem/allreimbursements",  populateReimbursements);
}