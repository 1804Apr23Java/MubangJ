<%@ include file="./partials/header.jsp" %>

<div class="container">
 <h1>Create Reimbursement</h1>
	<form id="createRForm" enctype="multipart/form-data">
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
				type="number" name="amount" class="form-control" id="exampleFormControlInput1"
				placeholder="Amount" value="0.00" min=0 required>
		</div>
		<div class="form-group">
			<label for="receipt">Upload receipt</label> <input
				type="file" name="receipt" class="form-control" id="receipt">
		</div>
		<button type="submit" id="submitReim" class="btn btn-primary">Submit</button> 
	</form>
	
	
</div>

<script type="text/javascript" src="./scripts/createReimbursement.js"></script>

<%@ include file="./partials/footer.jsp" %>