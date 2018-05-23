<%@ include file="./partials/header.jsp" %>
	
	<div class="container">
		<h1>Welcome to your Profile</h1>
		<div class="row">
			<div class="col align-self-start"></div>
				<div class="col align-self-center">
					<div class="card" style="width: 30rem;">
						<ul class="list-group list-group-flush">
							<li class="list-group-item">
								Full Name: <span id="fullName"></span>
								<button id="fullNameBtn" type="button" class="btn btn-primary" data-toggle="modal"
									data-target=".bd-example-modal-lg">Update</button>
							</li>
							<li class="list-group-item">
								Email: <span id="email"></span>
								<button id="emailBtn" type="button" class="btn btn-primary" data-toggle="modal"
									data-target=".bd-example-modal-lg">Update</button>
							</li>
							<li class="list-group-item">
								Username: <span id="username"></span>
								<button id="usernameBtn" type="button" class="btn btn-primary" data-toggle="modal"
									data-target=".bd-example-modal-lg">Update</button>
							</li>
							<li class="list-group-item">
								<span id="password">Update Password</span>
								<button id="passwordBtn" type="button" class="btn btn-primary" data-toggle="modal"
									data-target=".bd-example-modal-lg">Update</button>								
							</li>
						</ul>
					</div>
	
					<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
							<div class="container">
								<form id="updateUserForm" action="" method="POST" enctype="multipart/form-data">
									<div class="form-group">
										<label id="firstEnter" for="oldName"></label> <input
											type="text" class="form-control" id="originalVal"
											 name="firstInputVal" required>
									</div>
									<div class="form-group">
										<label id="secondEnter" for="newName"></label> <input
											type="text" class="form-control" id="newVal"
											 name="secondInputVal" required>
									</div>
									<div class="form-group">
										<label id="thirdEnter" for="reNewName"></label> <input
											type="text" class="form-control" id="reNewVal"
											name="thirdInputVal" required>
									</div>
									<div class="form-row text-center">
										<div class="col-12">
											<button id="editProfileSbmtBtn" type="submit" class="btn btn-primary">Submit</button>
										</div>
									</div>
								</form>
							</div>
							</div>
						</div>
					</div>
				</div>
			<div class="col align-self-end"></div>
		</div>
	</div>
	
	<script type="text/javascript" src="./scripts/getUserInfo.js"></script>
	<script type="text/javascript" src="./scripts/dynamicUserEditForm.js"></script>
	<script type="text/javascript" src="./scripts/updateUserInfo.js"></script>
	

<%@ include file="./partials/footer.jsp" %>
