// 1. USA, Define function getUSA(), Find the html element that contains "USA"., Print that element's contents.


function getUSA() {

	var states = document.querySelector("body div h1 span")
	console.log(states.dataset.customattr);
}

// getUSA();

// 2. Sales, Define function getPeopleInSales(), Print the names of all the people in the sales department.

function getPeopleInSales() {

	var emps = document.querySelectorAll(".empName");

	emps.forEach(function(emp) {
		if (emp.nextElementSibling.innerHTML === "Sales") {
			console.log(emp.innerHTML)
		}
	})
}

// getPeopleInSales();

// 3. Click Here, Define function getAnchorChildren(), Find all anchor elements with a <span> child. Print the contents of <span>

function getAnchorChildren() {

	var spanChildArr = document.querySelectorAll("a span")

	spanChildArr.forEach(function(item){

		console.log(item.innerHTML);

	})
}

// getAnchorChildren();

// 4. Hobbies, Define function, Find all checked options in the 'skills' select element. Print the value and the contents.

function checkedOptions() {

	var selectedValue = document.querySelectorAll("#firstForm select[name='skills']")[0].value;

	var selectedContent = document.querySelectorAll("#firstForm option[value=" + selectedValue + "]")[0].innerHTML;

	console.log("Value: " + selectedValue + " | Content: " + selectedContent);


}

// checkedOptions();

// 5.Custom Attribute, Define function getCustomAttribute(), Find all elements with "data-customAttr" attribute, Print the value of the attribute. Print the element that has the attribute.

function getCustomAttribute() {

	var custAttrArr = document.querySelectorAll("[data-customAttr]");

	custAttrArr.forEach(function(item) {
		console.log("element: " + item.outerHTML + " | Attribute Value: " + item.dataset.customattr)
	})
}

// getCustomAttribute();

// 6 NOTE: Write unobtrusive Javascript, Regarding these elements: <input id="num1" class="nums" type="text"/> <input id="num2" class="nums" type="text"/> <h3>Sum: span id="sum"></span></h3> . Define onchange event handler. Add <input> element values. Put the sum in the <span> element. If values cannot be added, put "Cannot add" in the <span> element

function sum() {
	var num1 = 0;
	var num2 = 0;
	var sum = document.querySelector("#sum");

	document.querySelector("#num1").addEventListener("change", function() {

		num1 = parseInt(document.querySelector("#num1").value);
		sum.innerHTML = (Number.isInteger(num1)) ? num1 + num2 : "Cannot add";

	})
	document.querySelector("#num2").addEventListener("change", function() {

		num2 = parseInt(document.querySelector("#num2").value);
		sum.innerHTML = (Number.isInteger) ? num1 + num2 : "Cannot add";
	})

}

// sum();

// 7 Skills Event, NOTE: Write unobtrusive Javascript, When user selects a skill, create an alert with a message similar to: "Are you sure CSS is one of your skills?" NOTE: no alert should appear when user deselects a skill.

function radAlerts() {

	var allOptions = document.querySelectorAll("select[name='skills']")[0];

	allOptions.onchange = function(event) {
		index = event.target.options.selectedIndex
		option = event.target.options[index].innerHTML
		alert("Are you sure " + option + " is one of your skills?")
	}

}

// radAlerts();

// 8  Favorite Color Event, NOTE: Write unobtrusive Javascript NOTE: This is regarding the favoriteColor radio buttons. When a user selects a color, create an alert with a message similar to: "So you like green more than blue now?" In this example, green is the new value and blue is the old value. Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor


// **** // NOTE: changes background color of radio button to current selected one but it does not show b/c the radiobuttons are too small.  *****

function favColor() {

	var allOptions = document.querySelectorAll("input[name='favoriteColor']");
	var previous;
	var current;

	allOptions.forEach(function(option) {

		option.onclick = function(event) {

			current = event.target.nextSibling.data

			if (previous === undefined) {
				alert("So you like " + current + " now?");
				option.style.backgroundColor  = "'" + current + "'";

				previous = current

			} else {
				alert("So you like " + current + " more than " + previous + " now?");

				previous = current;

			}
			option.style.backgroundColor = current;
		}


	})

}

// favColor();

// 9) Show/Hide Event NOTE: Write unobtrusive Javascript When user hovers over an employees name: Hide the name if shown. Show the name if hidden.

function empHover() {

	names = document.querySelectorAll(".empName");

	names.forEach(function(name) {

		name.onmouseover = function() {

			if(name.style.opacity === "0") {

				name.style.opacity = "1";

			} else {

				name.style.opacity = "0";

			}
		}

	})
}

// empHover();

// 10) Current Time Regarding this element: <h5 id="currentTime"></h5> Show the current time in this element in this format: 9:05:23 AM The time should be accurate to the second without having to reload the page.

function currentTime() {
	var time = document.querySelector("#currentTime");
	var date = new Date();
	time.innerHTML = date.toLocaleTimeString("en-US");
	setInterval(currentTime);
}
// setInterval(currentTime);


// currentTime();


// 11) Delay. Regarding this element: s <p id="helloWorld">Hello, World!</p> Three seconds after a user clicks on this element, change the text to a random color

function delay() {
	// var rgb = "rgb(" + Math.random()*256 + ","+ Math.random()*256 + ","+ Math.random()*256 + ")"

	var heWd = document.querySelector("#helloWorld");
	heWd.addEventListener("click", function(){
		var rgb = "rgb(" + Math.random()*256 + ","+ Math.random()*256 + ","+ Math.random()*256 + ")";

		setTimeout(function() {
			heWd.style.color = rgb;

		},3000)
	})
}

// delay();

//12 Walk the DOM Define function walkTheDOM(node, func) This function should traverse every node in the DOM. Use recursion. On each node, call func(node).

function walkTheDom(node, func) {

	if (node.children.length === 0) {
	} else {
			Array.from(node.children).forEach(function(item) {

			func(item);
			walkTheDom(item, func);

		})
	}
}

// var node = document.querySelectorAll("html")[0];

// walkTheDom(node, function(child){console.log(child)})
