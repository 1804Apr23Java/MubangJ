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
//	sendAjaxPostTwo(url, formData);
	sendAjaxPostTwo(url, formData, reloadPage)

	
};

function sendAjaxPostTwo(url, data, callback) {
	
	var xhr = new XMLHttpRequest()
	|| new ActiveXObject("Microsoft.HTTPRequest");
	
	xhr.open("POST", url, true);
	
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			callback();
		}
	};

	
	xhr.send(data);
}

function reloadPage() {
	   window.location.reload();
}