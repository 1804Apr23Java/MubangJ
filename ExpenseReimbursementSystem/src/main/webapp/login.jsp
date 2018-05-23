<%@ include file="./partials/loggedOutHeader.jsp" %>

<div class="container center">
	<div class="row">
		<aside class="col-5 mx-auto">
			<div class="card">
				<article class="card-body">
					<a href="register" class="float-right btn btn-outline-primary">Sign up</a>
					<h4 class="card-title mb-4 mt-1">Sign in</h4>
					<form method="POST" action="login" accept-charset="UTF-8">
						<div class="form-group">
							<label>Username</label>
							<input id="username" class="form-control" placeholder="Username"
								name="username" type="text">
						</div>
						<!-- form-group// -->
						<div class="form-group">
							<label>Password</label> 
							<input id="password" class="form-control" placeholder="Password" name="password" type="password" value="">							
						</div>
						<!-- form-group// -->
						<div class="form-group">
							<input class="btn btn-primary btn-block" type="submit" value="Login">				
						</div>
						<!-- form-group// -->
					</form>
				</article>
			</div>
		</aside>
	</div>
	
</div>

	<%@ include file="./partials/footer.jsp" %>