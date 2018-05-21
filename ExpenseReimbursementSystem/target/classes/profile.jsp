<%@ include file="./partials/header.jsp" %>
	
	<div class="container">
		<h1>Welcome to your Profile</h1>
		
		<div id="fullName">
		
		<span><a>update</a></span>
		</div>
		
		<div id="email">
		
		<span><a>update</a></span>		
		</div>
		
		<div id="username">
		
		<span><a>update</a></span>		
		</div>
		
		<div id="password">
		
		<span><a>update</a></span>		
		</div>
		
<%-- 		<p>Name: </p>	
		<p>Email: <%= request.getAttribute("email") %></p>
			
		<p>Username: <%= request.getAttribute("username") %></p>
		<p><a>Update Password</a></p> --%>
	
	</div>
	
	<script type="text/javascript" src="./scripts/getUserInfo.js"></script>

<%@ include file="./partials/footer.jsp" %>
