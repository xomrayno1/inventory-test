<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script src="//cdnjs.cloudflare.com/ajax/libs/numeral.js/2.0.6/numeral.min.js"></script> 
<style>
.price{
	font-size: 14px;
}
</style>
<div class="right_col" role="main">
	<div class="">

		<div class="clearfix"></div>
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>Goods Issue</h2>

					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<a href="<c:url value="/goods-issue/add"/>" class="btn btn-app"><i class="fa fa-plus"></i>Add</a>
					<a href="<c:url value="/goods-issue/export"/>" class="btn btn-app"><i class="fa fa-cloud-download"></i>Export</a>
					<div class="container" style="padding: 50px;">
						<form:form modelAttribute="searchForm" cssClass="form-horizontal form-label-left" servletRelativeAction="/goods-issue/list/1" method="POST">
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="code">Code </label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<form:input path="code" cssClass="form-control col-md-7 col-xs-12" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="fromDate">From Date</label>
								<div class="col-md-6 col-sm-6 col-xs-12 ">
									<div class="input-group date" id='fromDatePicker'>
										<form:input path="fromDate" class="form-control" />
										<span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="toDate">To Date </label>
								<div class="col-md-6 col-sm-6 col-xs-12 ">
									<div class="input-group date" id='toDatePicker'>
										<form:input path="toDate" class="form-control" />
										<span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>

								</div>
							</div>
							<div class="form-group">
								<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
									<button type="submit" class="btn btn-success">Search</button>
								</div>
							</div>

						</form:form>
					</div>

					<div class="table-responsive">
						<table class="table table-striped jambo_table bulk_action">
							<thead>
								<tr class="headings">
									<th class="column-title">#</th>
									<th class="column-title">Code</th>
									<th class="column-title">Qty</th>
									<th class="column-title">Price</th>
									<th class="column-title">Product</th>
									<th class="column-title">Update Date</th>
									<th class="column-title no-link last text-center" colspan="3"><span class="nobr">Action</span></th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${invoices}" var="invoice" varStatus="loop">

									<c:choose>
										<c:when test="${loop.index%2==0 }">
											<tr class="even pointer">
										</c:when>
										<c:otherwise>
											<tr class="odd pointer">
										</c:otherwise>
									</c:choose>
									<td class=" ">${pageInfo.getOffset()+loop.index+1}</td>
									<td class=" ">${invoice.code }</td>
									<td class=" ">${invoice.qty }</td>
									<td class="price">${invoice.price }</td>
									<td class=" ">${invoice.productInfoDTO.name }</td>
									<td class="date">${invoice.updateDate}</td>

									<td class="text-center"><a href="<c:url value="/goods-issue/view/${invoice.id }"/>" class="btn btn-round btn-default">View</a></td>
									<td class="text-center"><a href="<c:url value="/goods-issue/edit/${invoice.id }"/>" class="btn btn-round btn-primary">Edit</a></td>
									<td class="text-center"><a href="javascript:void(0);" onclick="confirmDelete(${invoice.id});" class="btn btn-round btn-danger">Delete</a></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
						<jsp:include page="../layout/paging.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
 		$('#goods-issuelistId').addClass('current-page').siblings().removeClass('current-page'); 
 		// add class currrent page và xóa current-page khỏi các cùng cấp ngoại trừ chính nó
 		var parent = $('#goods-issuelistId').parents('li'); // trỏ đến parents li của id categorylistId   - tìm kiếm tổ tiên li
 		parent.addClass('active').siblings().removeClass('active'); //add class active vào thẻ li và xóa các active ở cùng cấp 
 		$('#goods-issuelistId').parents().show();
 	});


	 function confirmDelete(id){
		 if(confirm('Do you want delete this record?')){
			 window.location.href = '<c:url value="/goods-issue/delete/"/>'+id;
		 }
	 }
	 function gotoPage(page){
		 $('#searchForm').attr('action','<c:url value="/goods-issue/list/"/>'+page);
		 $('#searchForm').submit();
	 }
	 $(document).ready(function(){
		 processMessage();
		 $('#fromDatePicker').datetimepicker({
			 format : 'YYYY-MM-DD HH:mm:ss'
		 });
		 $('#toDatePicker').datetimepicker({
			 format : 'YYYY-MM-DD HH:mm:ss'
		 })
		  $('.price').each(function(){ 
			 $(this).text(numeral($(this).text()).format('0,0'));
		 }) 
	 });
	 function processMessage(){
		 var msgSuccess = '${msgSuccess}';
		 var msgError = '${msgError}';
		 if(msgSuccess){
			 new PNotify({
                 title: ' Success',
                 text: msgSuccess,
                 type: 'success',
                 styling: 'bootstrap3'
             });
		 }
		 if(msgError){
			 new PNotify({
                 title: ' Error',
                 text: msgError,
                 type: 'error',
                 styling: 'bootstrap3'
             });
		 }
	 }
	
	
</script>