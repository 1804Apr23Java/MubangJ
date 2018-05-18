<%@ include file="./partials/header.jsp" %>


<div class="container">
	<h1>History of Reimbursements</h1>

	<span>radio button: resolved, pending</span>
	<span>options: add reimbursement</span>
	
	<table class="table">
	  <thead class="thead-dark">
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">ReimbursementId</th>
	      <th scope="col">EmployeeId</th>
	      <th scope="col">Purpose</th>
	      <th scope="col">Status</th>
	      <th scope="col">Amount</th>
	      <th scope="col">Date Created</th>     
	    </tr>
	  </thead>
	  <tbody>
	    <tr>
	      <th scope="row">1</th>
	      <th scope="col">ReimbursementId</th>
	      <th scope="col">EmployeeId</th>
	      <th scope="col">Purpose</th>
	      <th scope="col">Status</th>
	      <th scope="col">Amount</th>
	      <th scope="col">Date Created</th>  
	    </tr>
	    <tr>
	      <th scope="row">2</th>
	      <td scope="col">ReimbursementId</td>
	      <td scope="col">EmployeeId</td>
	      <td scope="col">Purpose</td>
	      <td scope="col">Status</td>
	      <td scope="col">Amount</td>
	      <td scope="col">Date Created</td>  
	    </tr>
	    <tr>
	      <th scope="row">3</th>
	      <td scope="col">ReimbursementId</td>
	      <td scope="col">EmployeeId</td>
	      <td scope="col">Purpose</td>
	      <td scope="col">Status</td>
	      <td scope="col">Amount</td>
	      <td scope="col">Date Created</td>  
	    </tr>
	  </tbody>
	</table>
</div>

<%@ include file="./partials/footer.jsp" %>