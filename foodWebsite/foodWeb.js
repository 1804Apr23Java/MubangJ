
document.getElementById("typeComment").addEventListener("submit", data);

function data() {
	var name = document.getElementById("usr").value;
	var description = document.getElementById("comment").value;
	console.log(name);
	console.log(description);
	// document.querySelector(".name").innerHTML = name;
	document.querySelector(".allComments").innerHTML = 	'<tr><td> ' + name+ '</td><td>' + description+ '</td></tr>'

	// document.querySelector(".comment").innerHTML = description;

}

// make a method that parse and display a list of JSON objects (Provided by a method)

// read form into json file



// use json file to populate table of comments with users



// data();