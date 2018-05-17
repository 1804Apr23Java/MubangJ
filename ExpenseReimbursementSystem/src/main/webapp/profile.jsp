<%@ include file="./partials/header.jsp" %>
	
	<div class="container">
		<h1>Welcome to your Profile</h1>
		<p>Username: <%= request.getAttribute("username") %></p>
		<p>Email: <%= request.getAttribute("email") %></p>
	</div>

<%@ include file="./partials/footer.jsp" %>
