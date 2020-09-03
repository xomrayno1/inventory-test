<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="right_col" role="main">
     <div class="">
         <div class="clearfix"></div>
            <div class="row" style="display: block;">             
              <div class="col-md-12 col-sm-12  ">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Product Info List</h2>

                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <div class="container" style="padding: 50px">
                    	<a href='<c:url value="/product-info/add"></c:url>' class="btn btn-app"><i class="fa fa-plus"></i>Add</a>
                   <div class="container">
                   <div c>
                   
                   </div>
                   <form:form  modelAttribute="searchForm" servletRelativeAction="/product-info/list/1" method="POST" cssClass="form-horizontal form-label-left">
					<div class="form-group">
						<label for="description" class="control-label col-md-3 col-sm-3 col-xs-12">Id</label>
						<div class="col-md-6 col-sm-6 ">
							<form:input path="id"  cssClass="form-control col-md-7 col-xs-12" />
						</div>
					</div>
					
					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12" for="code">Code <span class="required">*</span></label>
						<div class="col-md-6 col-sm-6 ">
							<form:input path="code" cssClass="form-control col-md-7 col-xs-12"  />
						
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Name <span class="required">*</span></label>
						<div class="col-md-6 col-sm-6 ">
							<form:input path="name"  cssClass="form-control col-md-7 col-xs-12"/>

						</div>
					</div>
				<div class="item form-group">
						<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
							<button type="submit" class="btn btn-success">Search</button>
							<button class="btn btn-primary" type="reset" >Reset</button>
						</div>
					</div>
				</form:form>
                   </div>
                    </div>
                    <div class="table-responsive">
                      <table class="table table-striped jambo_table bulk_action">
                        <thead>
                          <tr class="headings">
                            <th class="column-title">#</th>
                            <th class="column-title">Id</th>
                            <th class="column-title">Code</th>
                            <th class="column-title">Name</th>
                            <th class="column-title">Description</th>                          
                            <th class="column-title no-link last text-center" colspan="3"><span class="nobr">Action</span></th>
                          </tr>
                        </thead>
                        <tbody>
                         <c:forEach items="${productInfoDTOs}" var="productInfo" varStatus="loop">                        
                         	<c:choose>
                      			<c:when test="${loop.index % 2 ==0}">
                      				<tr class="even pointer">
                      			</c:when>
                      			<c:otherwise>
                      				<tr class="odd pointer">
                      			</c:otherwise>   	
                         	</c:choose>
                          	<td class=" ">${pageInfo.getOffset() + loop.index + 1}</td>
                            <td class=" ">${productInfo.id}</td>
                            <td class=" ">${productInfo.code}</td>
                            <td class=" ">${productInfo.name}</td>
                            <td class=" "><img alt="" src='<c:url value="/resources/${productInfo.imgUrl}"></c:url>' width="100px" height="100px"></td>
         					<input type="hidden" value="${productInfo.id}" id="idProductInfo" >                                                    
							<td class="text-center"><a href='<c:url value="/product-info/view/${productInfo.id}"></c:url>' class="btn btn-round btn-default">View</a></td>
							<td class="text-center"><a href='<c:url value="/product-info/edit/${productInfo.id}"></c:url>' class="btn btn-round btn-primary">Edit</a></td>
							<td class="text-center"><a href="#mymodal"  data-toggle="modal" class="btn btn-round btn-danger btn_delete">Delete</a></td>
							<!-- href="javascript:void(0);" onclick="confirmDelete(${category.id});" -->
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
</div>
<div class="modal fade" id="mymodal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<p class="modal-title">Xóa</p>
				<button class="close" data-dismiss="modal" >&times;</button>
			</div>
			<div class="modal-body">
				Bạn có chắc chắn muốn xóa không !
			</div>
			<input id="idProduct" type="hidden">
			<div class="modal-footer">
				<button class="btn" id="btn_ok">Ok</button>
				<button class="btn" data-dismiss="modal">Hủy</button>
			</div>	
		</div>
	</div>
</div>
        <!-- /page content -->
<script type="text/javascript">

	function confirmDelete(id){
		if(confirm("Bạn muốn xóa record")){
			window.location.href= '<c:url value="/product-info/delete/"/>'+id;
		}
	}
	
	var btnOk = document.getElementById('btn_ok');
	var btnDelete = document.getElementsByClassName("btn_delete");
	for(var i = 0 ; i < btnDelete.length ; i++){
		btnDelete[i].addEventListener('click',function(){
			var id = $(this).parents('tr').find("#idProductInfo");
			$('#idProduct').val(id.val());
		});
	}
	btnOk.addEventListener("click",function(){
		var id  = $('#idProduct').val();
		window.location.href= '<c:url value="/product-info/delete/"/>'+id;
	});
	function gotoPage(page){
		$('#searchForm').attr('action','<c:url value="/product-info/list/"/>'+page);
		$('#searchForm').submit();
	}
	
 	$(document).ready(function(){
 		processMessage();
 	});
 	function processMessage(){
 		var msgSuccess = '${msgSuccess}';
 		var msgError = '${msgError}'
 		if(msgSuccess){
 			new PNotify({
 				title: 'Success',
                text: msgSuccess,
                type: 'success',
                styling: 'bootstrap3'				
 			});
 		}
 		if(msgError){
 			new PNotify({
 				title: 'Error',
                text: msgError,
                type: 'error',
                styling: 'bootstrap3'	
 			});
 		}
 	}
 	$(document).ready(function(){
 		$('#product-infolistId').addClass('current-page').siblings().removeClass('current-page'); 
 		// add class currrent page và xóa current-page khỏi các cùng cấp ngoại trừ chính nó
 		var parent = $('#product-infolistId').parents('li'); // trỏ đến parents li của id categorylistId   - tìm kiếm tổ tiên li
 		parent.addClass('active').siblings().removeClass('active'); //add class active vào thẻ li và xóa các active ở cùng cấp 
 		$('#product-infolistId').parents().show();
 	});
</script>


