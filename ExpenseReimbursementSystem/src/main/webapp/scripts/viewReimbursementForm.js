/**
 * 
 */

var viewReimburseSbmtBtn = document.getElementById("viewRSubmitBtn");
var managerDecisionForm = document.getElementById("ManagerDecisionForm");

managerDecisionForm.addEventListener("submit", postDecisionUpdate);

function postDecisionUpdate(event) {
	event.preventDefault();
	var form = event.target;
	var formData = new FormData(form);
	
	var url = "http://localhost:8083/ExpenseReimbursementSystem/decision";
	sendAjaxPostTwo(url, formData)
	
};

function sendAjaxPostTwo(url, data) {
	
	var xhr = new XMLHttpRequest()
	|| new ActiveXObject("Microsoft.HTTPRequest");
	
	xhr.open("POST", url, true);
	
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
//			console.log(this)
		}
	};

	
	xhr.send(data);
}

