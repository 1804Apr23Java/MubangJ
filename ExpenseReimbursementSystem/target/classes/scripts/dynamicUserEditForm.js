/**
 * 
 */
//addEventListener("submit", submitCreateForm);

// form
var modalForm = document.querySelector(".modal-dialog .modal-content form");

// buttons
var fullNameBtn = document.getElementById("fullNameBtn");
var usernameBtn = document.getElementById("usernameBtn");
var emailBtn = document.getElementById("emailBtn");
var passwordBtn = document.getElementById("passwordBtn");
var editProfileSubmitBtn = document.getElementById("editProfileSbmtBtn");

// Labels
var firstEnterValLab = document.getElementById("firstEnter");
var secondEnterValLab = document.getElementById("secondEnter");
var thirdEnterValLab = document.getElementById("thirdEnter")

// inputs
var firstEnterVal = document.getElementById("originalVal");
var secondEnterVal = document.getElementById("newVal");
var thirdEnterVal = document.getElementById("reNewVal");


fullNameBtn.addEventListener("click", populateModal);
usernameBtn.addEventListener("click", populateModal);
emailBtn.addEventListener("click", populateModal);
passwordBtn.addEventListener("click", populateModal);

function populateModal(event) {
	var btnId = event.target.id
	modalForm.reset();
	
	switch(btnId) {
	
	case "fullNameBtn":
		
		
		firstEnterVal.type="text";
		secondEnterVal.type="text";
		thirdEnterVal.type="text";
		
		firstEnterValLab.innerHTML = "Enter Old Full Name";
		secondEnterValLab.innerHTML = "Enter New Full Name";
		thirdEnterValLab.innerHTML = "Re-Enter New Full Name";
		
		firstEnterVal.placeholder = "Enter Old Full Name";
		secondEnterVal.placeholder = "Enter New Full Name";
		thirdEnterVal.placeholder = "Re-Enter New Full Name";
		
		editProfileSubmitBtn.name = "fullNameBtn";
		break;
	case "usernameBtn":
		firstEnterVal.type="text";
		secondEnterVal.type="text";
		thirdEnterVal.type="text";
		
		firstEnterValLab.innerHTML = "Enter Old Username";
		secondEnterValLab.innerHTML = "Enter New Usernme";
		thirdEnterValLab.innerHTML = "Re-Enter Username";
		
		firstEnterVal.placeholder = "Enter Old Username";
		secondEnterVal.placeholder = "Enter New Username";
		thirdEnterVal.placeholder = "Re-Enter Username";
		
		editProfileSubmitBtn.name = "usernameBtn";
		
		break;
	case "emailBtn":
		
		firstEnterVal.type="text";
		secondEnterVal.type="text";
		thirdEnterVal.type="text";
		
		firstEnterValLab.innerHTML = "Enter Old Email";
		secondEnterValLab.innerHTML = "Enter New Email";
		thirdEnterValLab.innerHTML = "Re-Enter Email";
		
		firstEnterVal.placeholder = "Enter Old Email";
		secondEnterVal.placeholder = "Enter New Email";
		thirdEnterVal.placeholder = "Re-Enter Email";
		
		editProfileSubmitBtn.name = "emailBtn";
		break;
	case "passwordBtn":
		firstEnterVal.type="password";
		secondEnterVal.type="password";
		thirdEnterVal.type="password";
		
		firstEnterValLab.innerHTML = "Enter Old password";
		secondEnterValLab.innerHTML = "Enter New password";
		thirdEnterValLab.innerHTML = "Re-Enter password";
		
		firstEnterVal.placeholder = "Enter Old Password";
		secondEnterVal.placeholder = "Enter New Password";
		thirdEnterVal.placeholder = "Re-Enter Password";
		
		editProfileSubmitBtn.name = "passwordBtn";
		break;
	default:
		console.log("invalid");
	}
};

