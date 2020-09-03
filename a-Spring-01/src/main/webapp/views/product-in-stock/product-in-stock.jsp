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
                    <h2>History List</h2>

                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <div class="container" style="padding: 50px">
                    
                   <div class="container">
                   <form:form  modelAttribute="searchForm" servletRelativeAction="/product-in-stock/list/1" method="POST" cssClass="form-horizontal form-label-left">
					<div class="form-group">
						<label for="description" class="control-label col-md-3 col-sm-3 col-xs-12">Id</label>
						<div class="col-md-6 col-sm-6 ">
							<form:input path="productInfoDTO.categoryDTO.name"  cssClass="form-control col-md-7 col-xs-12" />
						</div>
					</div>
					
					<div class="item form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12" for="code">Code <span class="required">*</span></label>
						<div class="col-md-6 col-sm-6 ">
							<form:input path="productInfoDTO.code" cssClass="form-control col-md-7 col-xs-12"  />
						
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Name <span class="required">*</span></label>
						<div class="col-md-6 col-sm-6 ">
							<form:input path="productInfoDTO.name"  cssClass="form-control col-md-7 col-xs-12"/>

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
                            <th class="column-title">Category</th>
                            <th class="column-title">Code</th>
                            <th class="column-title">Name</th>
                            <th class="column-title">Image</th>                          
                            <th class="column-title">Qty</th> 
                            <th class="column-title">Price</th> 
                          </tr>
                        </thead>
                        <tbody>
                         <c:forEach items="${productInStockDTOs}" var="productInStock" varStatus="loop">                        
                         	<c:choose>
                      			<c:when test="${loop.index % 2 ==0}">
                      				<tr class="even pointer">
                      			</c:when>
                      			<c:otherwise>
                      				<tr class="odd pointer">
                      			</c:otherwise>   	
                         	</c:choose>
                          	<td class=" ">${pageInfo.getOffset() + loop.index + 1}</td>
                            <td class=" ">${productInStock.productInfoDTO.categoryDTO.name}</td>
                            <td class=" ">${productInStock.productInfoDTO.code}</td>
                            <td class=" ">${productInStock.productInfoDTO.name}</td>
                            <td class=" "><img alt="" src='<c:url value="/resources/${productInStock.productInfoDTO.imgUrl}"></c:url>' height="100px" width="100px"></td>  
                            <td class=" ">${productInStock.qty}</td>
                            <td class=" ">${productInStock.price}</td>                            												
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

        <!-- /page content -->
<script type="text/javascript">

 	$(document).ready(function(){
 		$('#product-in-stocklistId').addClass('current-page').siblings().removeClass('current-page'); 
 		// add class currrent page và xóa current-page khỏi các cùng cấp ngoại trừ chính nó
 		var parent = $('#product-in-stocklistId').parents('li'); // trỏ đến parents li của id categorylistId   - tìm kiếm tổ tiên li
 		parent.addClass('active').siblings().removeClass('active'); //add class active vào thẻ li và xóa các active ở cùng cấp 
 		$('#product-in-stocklistId').parents().show();
 	});
</script>


