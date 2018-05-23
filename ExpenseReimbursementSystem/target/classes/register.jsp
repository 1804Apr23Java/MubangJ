<%@ include file="./partials/loggedOutHeader.jsp" %>

<div class="container mt-5">
	<div class="row justify-content-center">
		<div class="col-md-6 ">
			<div class="card">
				<header class="card-header">
					<a href="login" class="float-right btn btn-outline-primary mt-1">Log
						in</a>
					<h4 class="card-title mt-2">Sign up</h4>
				</header>
				<article class="card-body">
					<form action="register" method="POST">
						<div class="form-row">
							<div class="col form-group">
								<label>First name </label> <input type="text"
									class="form-control" placeholder="First Name" name="firstName" required>
							</div>
							<div class="col form-group">
								<label>Last name</label> <input type="text" class="form-control"
									placeholder="Last Name" name="lastName" required>
							</div>
						</div>
						<div class="form-group">
							<label>Email address</label> <input type="email" class="form-control" placeholder="Email Address" name="email" required> 
						</div>
						<div class="form-group">
							<label>Username</label> <input type="text" class="form-control" placeholder="Username" name="username" required> 
						</div>
						<div class="form-group">
							<label>Create password</label> <input class="form-control" type="password" name="password" required>
						</div>
						<div class="form-group">
							<label>Re-Enter password</label> <input class="form-control" type="password" name="rePassword" required>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-primary btn-block">Register</button>
						</div>
						<div class="form-group">
							<label for="department">Department</label>
							 <select class="form-control" id="department" name="department">
								<option>Accounting</option>
								<option>Marketing</option>
								<option>Sales</option>
								<option>Software Development</option>
							</select>
						</div>
					</form>
				</article>
				<div class="border-top card-body text-center">
					Have an account? <a href="login">Log In</a>
				</div>
			</div>
		</div>
	</div>


</div>
<%@ include file="./partials/footer.jsp" %>