<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h2>${titlePage}</h2>
			</div>
		</div>
<div class="row">
	<div class="col-md-12 col-sm-12 ">
		<div class="x_panel">

			<div class="x_content">
				<br />
				<form:form modelAttribute="modelForm" servletRelativeAction="/product-info/save" method="POST" enctype="multipart/form-data" cssClass="form-horizontal form-label-left">
					<form:hidden path="id"/>
					<form:hidden path="createDate" />
					<form:hidden path="activeFlag" />
					<form:hidden path="imgUrl"/>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12" for="categoryDTO">Category <span class="required">*</span></label>
						<c:choose >
							<c:when test="${!viewOnly}">
								<div class="col-md-6 col-sm-6 ">
							 		<form:select path="cateId" cssClass="form-control">
							 			<form:options items="${mapCategory}"/>
							 		</form:select>
									 <div class="has-error">
										<form:errors path="cateId" cssClass="help-block" />
                					</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="col-md-6 col-sm-6 ">									
									<form:input path="categoryDTO.name"  class="form-control col-md-7 col-xs-12" disabled="${viewOnly}"/>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12" for="code">Code <span class="required">*</span></label>
						<div class="col-md-6 col-sm-6 ">
							<form:input path="code" cssClass="form-control col-md-7 col-xs-12"  disabled="${viewOnly}"/>
							 <div class="has-error">
								<form:errors path="code" cssClass="help-block" />
                			</div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Name <span class="required">*</span></label>
						<div class="col-md-6 col-sm-6 ">
							<form:input path="name"  cssClass="form-control col-md-7 col-xs-12" disabled="${viewOnly}"/>
							<div class="has-error">
								<form:errors path="name" cssClass="help-block" />
                			</div>
						</div>
					</div>
					<c:if test="${!viewOnly }">
						<div class="form-group">
						<label for="multipartFile" class="control-label col-md-3 col-sm-3 col-xs-12">Image Upload</label>
						<div class="col-md-6 col-sm-6 ">					
							<form:input path="multipartFile" cssClass="form-control col-md-7 col-xs-12" type="file"/>
							<div class="has-error">
								<form:errors path="multipartFile" cssClass="help-block" />
                			</div>
						</div>
						</div>
					</c:if>
					<div class="form-group">
						<label for="description" class="control-label col-md-3 col-sm-3 col-xs-12">Description</label>
						<div class="col-md-6 col-sm-6 ">					
							<form:textarea path="description" cssClass="form-control col-md-7 col-xs-12" disabled="${viewOnly}"/>
							<div class="has-error">
								<form:errors path="description" cssClass="help-block" />
                			</div>
						</div>
					</div>
				
				<div class="item form-group">
						<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
							<button class="btn btn-primary" type="button" onclick="cancel()">Cancel</button>
						<c:if test="${!viewOnly}">
							<button class="btn btn-primary" type="reset">Reset</button>
							<button type="submit" class="btn btn-success">Submit</button>
						</c:if>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	
	$('#product-infolistId').addClass('current-page').siblings().removeClass('current-page'); 
	// add class currrent page và xóa current-page khỏi các cùng cấp ngoại trừ chính nó
	var parent = $('#product-infolistId').parents('li'); // trỏ đến parents li của id categorylistId   - tìm kiếm tổ tiên li
	parent.addClass('active').siblings().removeClass('active'); //add class active vào thẻ li và xóa các active ở cùng cấp 
	$('#product-infolistId').parents().show();
});
function cancel(){
	window.location.href='<c:url value="/product-info/list" />'
}

//-->
</script>
