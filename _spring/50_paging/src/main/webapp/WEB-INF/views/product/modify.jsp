<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />


<form action="/product/modify" method="post">
	<input type="hidden" value="${pvo.pno }" name="pno">
	<input type="hidden" value="${pgvo.pageNo }" name="pageNo">
	<input type="hidden" value="${pgvo.qty }" name="qty">
	<div class="container mt-3">
		<div class="mb-3 mt-3 ">
			<h3>Product Modify</h3>
			<label for="pno">Pno:</label> <input type="text" class="form-control"
				id="pno" value="${pvo.pno}" name="pno" readonly>
		</div>

		<div class="mb-3">
			<label for="category">Category</label> <input type="text"
				class="form-control" id="category" value="${pvo.category}"
				name="category">
		</div>

		<div class="mb-3">
			<label for="pname">Pname</label> <input type="text"
				class="form-control" id="pname" value="${pvo.pname}" name="pname">
		</div>

		<div class="mb-3">
			<label for="price">Price</label> <input type="text"
				class="form-control" id="price" value="${pvo.price}" name="price">
		</div>
		<div class="mb-3">
			<label for="writer">Writer</label> <input type="text"
				class="form-control" id="writer" value="${pvo.writer}" name="writer"
				readonly>
		</div>
		<div class="mb-3">
			<label for="description">Description</label> 
			<textarea class="form-control" id="description" placeholder="${pvo.description}" value="${pvo.description}"
				name="description"></textarea>
		</div>
		<div class="mb-3">
			<label for="madeBy">MadeBy</label> <input type="text"
				class="form-control" id="madeBy" value="${pvo.madeBy}" name="madeBy">
		</div>
		<div class="mb-3">
			<label for="regAt">RegAt</label> <input type="text"
				class="form-control" id="regAt" value="${pvo.regAt}" name="regAt"
				readonly>
		</div>

		<div class="mb-3">
			<label for="modAt">ModAt</label> <input type="text"
				class="form-control" id="modAt" value="${pvo.modAt}" name="modAt"
				readonly>
		</div>
		<div class="mb-3">
			<label for="readCount">ReadCount</label> <input type="text"
				class="form-control" id="readCount" value="${pvo.readCount}" name="readCount"
				readonly>
		</div>
		<div class="mb-3">
			<label for="cmtQty">CmtQty</label> <input type="text"
				class="form-control" id="cmtQty" value="${pvo.cmtQty}" name="cmtQty"
				readonly>
		</div>


		<button type="submit" class="btn btn-warning">Modi!</button>
	</div>
</form>

<jsp:include page="../common/footer.jsp" />