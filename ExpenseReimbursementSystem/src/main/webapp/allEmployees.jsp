<%@ include file="./partials/manHeader.jsp" %>


<div class="container">
	<h1>Employees</h1>
	
	<table class="table table-hover">
	  <thead class="thead-dark">
	    <tr id="RowForHead">
	    	<th>EmployeeId</th>
	    	<th>Employee</th>
	    	<th>Email</th>
	    	<th>Username</th>
	    	<th>Manager</th>    		    	
	    </tr>
	  </thead>
	  <tbody id="RowForBody">
	  </tbody>
	</table>
	
	<div id="Test" class="container">
		
	</div>
</div>

<script type="text/javascript" src="./scripts/allEmployees.js"></script>

<%@ include file="./partials/footer.jsp" %>