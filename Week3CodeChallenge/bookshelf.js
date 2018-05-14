
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
console.log(bookShelf);

var booksTableBody = document.querySelectorAll("#books")
var trows = booksTableBody[0].children

// event listener for each row, when clicked redirect to page with specified book
booksTableBody.forEach(function(book) {
	book.addEventListener("click", function() {

	})
})

var books = {
	table: []
};

var count = 0;

// on submit save form data to json file
var form = document.querySelector('form')
form.addEventListener("submit", function() {
	var title = document.getElementById("Title").value;
	var author = document.getElementById("Author").value;
	var genre = document.getElementById("Genre").value;
	var cover = document.getElementById("Cover").value;

	var book = new Book(title, author, genre, cover)
	obj.table.push({id: count++, "title": title, "author":author, "genre":genre,"cover":cover})

	var json = JSON.stringify()

	console.log(books);

	// document.createElement("trow")
})

// console.log(form);
// console.log(booksTableBody[0]);
