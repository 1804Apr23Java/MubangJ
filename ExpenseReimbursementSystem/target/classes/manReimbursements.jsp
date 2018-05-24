<%@ include file="./partials/manHeader.jsp" %>


<div class="container">
	<h1>History of Reimbursements</h1>
	
	<span> <a href="createrequest">add reimbursement</a></span>

	<form id="filterForm" name="filterForm">
<!--  		<div class="btn-group btn-group-toggle" data-toggle="buttons">
			<label class="btn btn-secondary active"><input type="radio"
				name="filterType" id="allR" autocomplete="off" checked>
				All Reimbursements
			</label> <label class="btn btn-secondary"> <input type="radio"
				name="filterType" id="gPendR" autocomplete="off"> General Pending Reimbursements
			</label> <label class="btn btn-secondary"> <input type="radio"
				name="filterType" id="sPendR"  autocomplete="off"> Self Pending Reimbursements
			</label>
			</label> <label class="btn btn-secondary"> <input type="radio"
				name="filterType" id="resR" autocomplete="off"> Resolved Reimbursements
			</label>			
		</div>  -->
		<input id="allR" type="radio" name="filterType" value="allR" checked> All Reimbursements<br>
		<input id="gPendR" type="radio" name="filterType" value="gPendR"> General Pending Reimbursements<br>
		<input id="sPendR" type="radio" name="filterType" value="sPendR"> Self Pending Reimbursements<br>
		<input id="resR" type="radio" name="filterType" value="resR"> Resolved Reimbursements
	</form>

	<table class="table table-hover mt-3">
	  <thead class="thead-dark">
	    <tr id="RowForHead">
	    </tr>
	  </thead>
	  <tbody id="RowForBody">
	  </tbody>
	</table>

	<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<form id="viewReimburseForm" action="" method="POST" enctype="multipart/form-data">
					<div id="reimburseId">
					
					</div>
					<input id="rIdHidden" type="hidden" name="reimburseId"/>
					
					<div class="form-group" id="fullNameDisp"></div>
					<div class="form-group" id="manFullNameDisp"></div>
					<div class="form-group" id="purposeDisp"></div>
					<div class="form-group" id="amountDisp"></div>
					<div class="form-group" id="statusDisp"></div>
					<div class="form-group" id="dateDisp"></div>
					<div class="form-group" class="container" id="reimburseImage">
						<img src="">
					</div>
					<button id="viewReceiptBtn"  class="btn btn-primary">View Receipt</button>					
					
					<!-- <button id="" type="submit" class="btn btn-primary">Submit</button> -->
				
				</form>
				<form id="ManagerDecisionForm" action="decision" method="POST" enctype="multipart/form-data">
					<input class="form-group" id="approveR" type="radio" name="decision" value="approve" checked> Approve<br>
					<input class="form-group" id="declineR" type="radio" name="decision" value="decline"> Decline
					<button id="viewRSubmitBtn"  class="btn btn-primary">Submit</button>					
				</form>
			
			</div>
		</div>
	</div>

	<div id="Test" class="container">
		
	</div>
</div>

<script type="text/javascript" src="./scripts/displayManReimbursements.js"></script>
<script type="text/javascript" src="./scripts/manFilterReimburseRadios.js"></script>
<<script type="text/javascript" src="./scripts/tableRowEventListener.js"></script>
<script type="text/javascript" src="./scripts/reimburseGetImage.js"></script>
<script type="text/javascript" src="./scripts/viewReimbursementForm.js"></script>



<%@ include file="./partials/footer.jsp" %>