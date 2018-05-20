<%@ include file="./partials/header.jsp" %>


<div class="container">
	<h1>History of Reimbursements</h1>

	<span> <a href="createrequest">add reimbursement</a></span>

	<form name="filterForm">
		<input id="allR" type="radio" name="filterType" value="allR" checked> All Reimbursements<br>
		<input id="pendR" type="radio" name="filterType" value="pendR"> Pending Reimbursements<br>
		<input id="resR" type="radio" name="filterType" value="resR"> Resolved Reimbursements
	</form>

	<table class="table table-hover">
	  <thead class="thead-dark">
	    <tr id="RowForHead">
	    </tr>
	  </thead>
	  <tbody id="RowForBody">
	  </tbody>
	</table>
	
	<div id="Test">
		
	</div>
</div>

<script type="text/javascript" src="./scripts/displayReimbursements.js"></script>

<%@ include file="./partials/footer.jsp" %>