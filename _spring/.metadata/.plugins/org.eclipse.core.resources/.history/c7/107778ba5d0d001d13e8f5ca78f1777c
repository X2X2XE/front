<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />


<div class="container mt-3">
	<form action="/product/modify" method="post" enctype="multipart/form-data">
		<input type="hidden" value="${pdto.pvo.pno }" name="pno"> <input
			type="hidden" value="${pgvo.pageNo }" name="pageNo"> <input
			type="hidden" value="${pgvo.qty }" name="qty"> <input
			type="hidden" value="${pgvo.type }" name="type"> <input
			type="hidden" value="${pgvo.kw }" name="kw">
		<div class="mb-3 mt-3 ">
			<h3>Product Modify</h3>
			<label for="pno">Pno:</label> <input type="text" class="form-control"
				id="pno" value="${pvo.pno}" name="pno" readonly>
		</div>

		<div class="mb-3">
			<label for="category">Category</label> <input type="text"
				class="form-control" id="category" value="${pdto.pvo.category}"
				name="category">
		</div>

		<div class="mb-3">
			<label for="pname">Pname</label> <input type="text"
				class="form-control" id="pname" value="${pdto.pvo.pname}"
				name="pname">
		</div>

		<div class="mb-3">
			<label for="price">Price</label> <input type="text"
				class="form-control" id="price" value="${pdto.pvo.price}"
				name="price">
		</div>
		<div class="mb-3">
			<label for="writer">Writer</label> <input type="text"
				class="form-control" id="writer" value="${pdto.pvo.writer}"
				name="writer" readonly>
		</div>
		<div class="mb-3">
			<label for="description">Description</label>
			<textarea class="form-control" id="description"
				placeholder="${pdto.pvo.description}"
				value="${pdto.pvo.description}" name="description"></textarea>
		</div>
		<div class="mb-3">
			<label for="madeBy">MadeBy</label> <input type="text"
				class="form-control" id="madeBy" value="${pdto.pvo.madeBy}"
				name="madeBy">
		</div>
		<div class="mb-3">
			<label for="regAt">RegAt</label> <input type="text"
				class="form-control" id="regAt" value="${pdto.pvo.regAt}"
				name="regAt" readonly>
		</div>

		<div class="mb-3">
			<label for="modAt">ModAt</label> <input type="text"
				class="form-control" id="modAt" value="${pdto.pvo.modAt}"
				name="modAt" readonly>
		</div>
		<div class="mb-3">
			<label for="readCount">ReadCount</label> <input type="text"
				class="form-control" id="readCount" value="${pdto.pvo.readCount}"
				name="readCount" readonly>
		</div>
		<div class="mb-3">
			<label for="cmtQty">CmtQty</label> <input type="text"
				class="form-control" id="cmtQty" value="${pdto.pvo.cmtQty}"
				name="cmtQty" readonly>
		</div>
		<div class="mb-3">
			<label for="attach">File Attach:</label> <input type="file"
				class="form-control" style="display: none;" id="files"
				name="fileAttached" multiple>
			<div class="d-grid">
				<button type="button" id="attachTrigger"
					class="btn btn-outline-primary btn-block d-block">Attach
					Files</button>
			</div>
			<div class="my-3" id="fileZone"></div>
		</div>

		<button type="submit" class="btn btn-warning" id="regBtn" >Modi!</button>
	</form>
</div>
<hr>
<div class="container mt-3">
	<ul class="list-group list-group-flush">
		<c:forEach items="${pdto.fileList }" var="fvo">
			<li
				class="list-group-item d-flex justify-content-between align-items-center">
				${fvo.fileName } <span class="badge bg-primary rounded-pill">${fvo.fileSize }</span>
				<button data-uuid="${fvo.uuid }"
					class="btn btn-outline-danger btn-sm fileDelBtn">X</button>
			</li>
		</c:forEach>
	</ul>

</div>





<script>
	document.getElementById('attachTrigger').addEventListener('click', () =>{
		document.getElementById('files').click();
	})
</script>
<script src="/resources/js/product.register.js"></script>
<script src="/resources/js/product.modify.js"></script>
<jsp:include page="../common/footer.jsp" />