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
		<c:import url="inc/navbar.jsp"></c:import>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<c:import url="inc/sidebar.jsp"></c:import>
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
				
					<div class="row">
						<div class="col-md-2">
						
						<form action="insertProduct" method="post">
						<input name="pname" type="text" class="form-control" placeholder="Product Name"/>
						<input name="pdesc" type="text" class="form-control" placeholder="Product Description"/>
						<input name="pprice" type="number" class="form-control" placeholder="Product Price"/>
						
						<div class="form-group">
						<select name="cid" class="form-control">
							<c:if test="${not empty catData }">
								<c:forEach items="${catData }" var="item">
								<!-- 
								<c:if test="${tablePro.cid == item.cid }">
										<option selected="selected" value="${item.cid }">${item.ctitle }</option>
									</c:if>
 								-->								
										<option value="${item.cid }">${item.ctitle }</option>
									<!--<option <c:if test="${tablePro.cid == item.cid }">selected</c:if> value="${item.cid }">${item.ctitle }</option>  -->
								</c:forEach>
							</c:if>
						</select>
					</div>					
						<input type="submit" class="btn btn-success" value="ADD PRODUCT">			
						</form>
						</div>
						<div class="col-md-10">
								<table class="table table-hover">
									<thead>
										<tr>
											<th scope="col">#</th>
											<th scope="col">ProductTitle</th>
											<th scope="col">ProductName</th>
											<th scope="col">ProductDescription</th>
											<th scope="col">ProductPrice</th>
											<th scope="col">EDIT</th>
											<th scope="col">DELETE</th>
										</tr>
									</thead>
									<tbody>
										<c:if test="${not empty tableData }">
											<c:forEach items="${tableData }" var="item">
												<tr>
													<th scope="row">${item.pid }</th>
													<td>${item.ctitle }</td>
													<td>${item.pname }</td>
													<td>${item.pdesc }</td>
													<td>${item.pprice }</td>
													<td><a href='<s:url value="updatePage/${item.pid }"></s:url>' class="btn btn-info">EDIT</a></td>
													<td><a href='<s:url value="/delete/${item.pid }"></s:url>' class="btn btn-danger">DELETE</a></td>
												</tr>
											</c:forEach>
										</c:if>
									</tbody>
								</table>		
						</div>
					</div>
				</div>
				<!-- content-wrapper ends -->
				   <c:import url="inc/footer.jsp"></c:import>
				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
<c:import url="inc/js.jsp"></c:import>
	
</body>
</html>