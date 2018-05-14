// demo; http://avantiusa.com/avanti/wp-content/uploads/2017/01/51WT4gebGdL._SX332_BO1204203200_.jpg


function Book(title, author, genre, cover) {

	this.title = title;
	this.author = author;
	this.genre = genre;
	this.cover = cover;
}

// var books = [];
// var xhr = new XMLHttpRequest();
// xhr.open("GET", "index.html", true);


var bookShelf = document.querySelectorAll(".table");

var booksTableBody = document.querySelectorAll("#books")
var trows = booksTableBody[0].children

var books = [new Book("Gifted Hands", "Dr. Benjamin Carson", "Auto-Biography", "https://images-na.ssl-images-amazon.com/images/I/41cj8NKr68L._SX308_BO1,204,203,200_.jpg"),
new Book("Influence", "Robert B Cialdini, PH.D", "Self Improvement", "https://images-na.ssl-images-amazon.com/images/I/512-B-1yXuL._SX331_BO1,204,203,200_.jpg"),
new Book("Thinking Fast and Slow", "Daniel Kahneman", "Self Improvement", "https://upload.wikimedia.org/wikipedia/en/c/c1/Thinking%2C_Fast_and_Slow.jpg")];

books.forEach(function(item, value) {
	var img = document.createElement("img");
	var row = booksTableBody[0].insertRow(value);
	var cell1 = row.insertCell(0).innerHTML= item.title;
	var cell2 = row.insertCell(1).innerHTML= item.author;
	var cell3 = row.insertCell(2).innerHTML= item.genre;
	img.src=item.cover;
	var cell4 = row.insertCell(3).appendChild(img);

})

// event listener for each row, when clicked redirect to page with specified book
booksTableBody.forEach(function(book) {
	book.addEventListener("click", function() {

	})
})


var count = 0;

// on submit save form data to json file
var form = document.querySelector('#button')
form.addEventListener("click", function() {
	var title = document.getElementById("Title").value;
	var author = document.getElementById("Author").value;
	var genre = document.getElementById("Genre").value;
	var cover = document.getElementById("Cover").value;

	var img = document.createElement("img");
	var row = booksTableBody[0].insertRow(books.length - 1);
	var cell1 = row.insertCell(0).innerHTML= title;
	var cell2 = row.insertCell(1).innerHTML= author;
	var cell3 = row.insertCell(2).innerHTML= genre;
	img.src=cover;
	var cell4 = row.insertCell(3).appendChild(img);

	var book = new Book(title, author, genre, cover)
	books.push(book);

	// obj.table.push({id: count++, "title": title, "author":author, "genre":genre,"cover":cover})
	//
	// var json = JSON.stringify(obj)

	console.log(books);

	// document.createElement("trow")
})
