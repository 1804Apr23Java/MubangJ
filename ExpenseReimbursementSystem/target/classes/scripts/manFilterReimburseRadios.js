/**
 * 
 */


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
		
	} else if (radioVal === "gPendR") {
		for ( i = 0, len = tBodyChildrenArr.length; i < len; i++) {
			if (tBodyChildrenArr[i].cells[5].innerHTML !== "Pending") {
				tBodyChildrenArr[i].style.display = "none";
			}  else {

				tBodyChildrenArr[i].style.display = "table-row";
			}
		}
		
	} else if (radioVal === "sPendR") {
		for ( i = 0, len = tBodyChildrenArr.length; i < len; i++) {
			if (tBodyChildrenArr[i].cells[5].innerHTML !== "Pending") {
				tBodyChildrenArr[i].style.display = "none";
			}  else {

				tBodyChildrenArr[i].style.display = "table-row";
			}
		}
		
	} else if (radioVal === "resR") {

		for ( i = 0, len = tBodyChildrenArr.length; i < len; i++) {

			var innerhtml = tBodyChildrenArr[i].cells[5].innerHTML
			if (innerhtml === "Approved" || innerhtml === "Denied") {
//				console.log("resolved display none")

				tBodyChildrenArr[i].style.display = "table-row";
			}  else {

				tBodyChildrenArr[i].style.display = "none";
			}
		}
		
	}	

}