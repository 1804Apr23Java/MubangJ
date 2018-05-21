<%@ include file="./partials/header.jsp" %>

<div class="container">

	<div class="success alert alert-success" style="display:none">Reimbursement Request Successfully Submitted</div>
	<div class="success alert alert-danger" style="display:none">Must fill out all the required fileds (First Name, Last Name, Purpose, and Amount</div>

	 <h1>Create Reimbursement</h1>
		<form id="createRForm" action="" method="POST" enctype="multipart/form-data">
			<div class="form-group">
				<label for="firstName">First Name</label> <input
					type="text" name="firstName" class="form-control" id="firstName"
					placeholder="First Name" required>
			</div>
			<div class="form-group">
				<label for="lastName">Last Name</label> <input
					type="text" name="lastName" class="form-control" id="lastName"
					placeholder="Last Name" required>
			</div>
			<div class="form-group">
				<label for="exampleFormControlInput1">Purpose</label> <input
					type="text" name="purpose" class="form-control" id="purpose"
					placeholder="Purpose" required>
			</div>
			<div class="form-group">
				<label for="exampleFormControlInput1">Amount</label> <input
					type="number" name="amount" class="form-control" id="amount"
					placeholder="Amount" value="0" min=0 step="0.01" required>
			</div>
			<div class="form-group">
				<label for="receipt">Upload receipt</label> <input
					type="file" name="receipt" class="form-control" id="receipt">
			</div>
			<button type="submit" id="submitReim" class="btn btn-primary">Submit</button> 
			
		</form>
		
		
		<div id="status"></div>
	</div>

<script type="text/javascript" src="./scripts/createReimbursement.js"></script>

<%@ include file="./partials/footer.jsp" %>