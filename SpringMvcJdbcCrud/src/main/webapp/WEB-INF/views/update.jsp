<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="inc/css.jsp"></c:import>
</head>
<body>
	<div class="container-scroller">
		<!-- partial:../../partials/_navbar.html -->
		<c:import url="inc/navbar.jsp"></c:import>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<c:import url="inc/sidebar.jsp"></c:import>
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row">
						<div class="col-md-4">
						
						<form action='<s:url value="/productUpdate"></s:url>' method="post">
						<input value="${tablePro.pname }" name="pname" type="text" class="form-control" placeholder="Product Name"/>
						<input value="${tablePro.pdesc }" name="pdesc" type="text" class="form-control" placeholder="Product Description"/>
						<input value="${tablePro.pprice }" name="pprice" type="number" class="form-control" placeholder="Product Price"/>
						
						<div class="form-group">
						<select name="cid" class="form-control">
							<c:if test="${not empty catData }">
								<c:forEach items="${catData }" var="item">
						
								<c:if test="${tablePro.cid == item.cid }">
										<option selected="selected" value="${item.cid }">${item.ctitle }</option>
									</c:if>
 											<c:if test="${tablePro.cid != item.cid }">	
										<option value="${item.cid }">${item.ctitle }</option>
										</c:if>	
									<!--<option <c:if test="${tablePro.cid == item.cid }">selected</c:if> value="${item.cid }">${item.ctitle }</option>  -->
								</c:forEach>
							</c:if>
						</select>
					</div>
						
						<input type="submit" class="btn btn-success" value="ADD PRODUCT">
						
						</form>
						
						</div>


						<div class="col-md-8">
						
						</div>

					</div>

				</div>
				<!-- content-wrapper ends -->
				<!-- partial:../../partials/_footer.html -->
				<footer class="footer">
					<div class="container-fluid clearfix">
						<span
							class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright
							© 2019 <a href="http://www.bootstrapdash.com/" target="_blank">Bootstrapdash</a>.
							All rights reserved.
						</span> <span
							class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted
							& made with <i class="mdi mdi-heart text-danger"></i>
						</span>
					</div>
				</footer>
				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	
	<c:import url="inc/js.jsp"></c:import>
</body>
</html>