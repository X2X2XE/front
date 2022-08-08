<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<div class="container mt-5">
	<h1>Product Detail</h1>
	<table class="table table-striped">
		<tr>
			<th>Pno</th>
			<td id="pnoVal">${pvo.pno }</td>
		</tr>
		<tr>
			<th>Category</th>
			<td>${pvo.category }</td>
		</tr>
		<tr>
			<th>Pname</th>
			<td>${pvo.pname }</td>
		</tr>
		<tr>
			<th>Price</th>
			<td>${pvo.price }</td>
		</tr>
		<tr>
			<th>Writer</th>
			<td>${pvo.writer }</td>
		</tr>
		<tr>
			<th>Description</th>
			<td>${pvo.description }</td>
		</tr>
		<tr>
			<th>MadeBy</th>
			<td>${pvo.madeBy }</td>
		</tr>
		<tr>
			<th>RegAt</th>
			<td>${pvo.regAt }</td>
		</tr>
		<tr>
			<th>ModAt</th>
			<td>${pvo.modAt }</td>
		</tr>
		<tr>
			<th>ReadCount</th>
			<td>${pvo.readCount }</td>
		</tr>
		<tr>
			<th>CmtQty</th>
			<td>${pvo.cmtQty }</td>
		</tr>
	</table>
	<ul class="nav justify-content-center">
    <li class="nav-item">
      <a class="nav-link" href="/product/list?pageNo=${pgvo.pageNo }&qty=${pgvo.qty}">List</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/product/modify?pno=${pvo.pno }&pageNo=${pgvo.pageNo }&qty=${pgvo.qty}">Modify</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" id="productRemove">Remove</a>
    </li>    
  </ul>
  <form action="" id="productRmForm" style="display: none;" method="post">
  	<input type="hidden" id="pn" value="" name="pno">
  	<input type="hidden" value="${pgvo.pageNo}" name="pageNo">
  	<input type="hidden" value="${pgvo.qty}" name="qty">  	
  </form>
</div>

<!-- Button to Open the Modal -->
<button type="button" style="display:none;" id="modalBtn" 
class="btn btn-primary"
data-bs-toggle="modal" data-bs-target="#myModal">
  Open modal
</button>

<!-- The Modal -->
<div class="modal" id="myModal" >
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Modal Heading</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body" >
        Modal body..
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button"  class="btn btn-success modSbmBtn" data-cno="">Submit</button>
      </div>

    </div>
  </div>
</div>

<div class="container mt-3">
  <h2>Comment</h2>
	
    <div class="input-group mb-3">
      <span class="input-group-text" id="cmtWriter">${ses.email }</span>
      <input type="text" class="form-control" placeholder="Add Comment" id="cmtText">
    	<button type="button" class="btn btn-primary" id="cmtSbmBtn">ADD</button>
    </div>   
	
  <table class="table table-striped" id="cmtZone">
  </table>
  <div class="text-center" style="visibility : hidden;">
  
  	<button type="button" data-page="1" 
  	id="moreBtn" class="btn btn-outline-secondary">
  	MORE +
  	</button>
  </div>
  
  
</div>

<script src="/resources/js/product.detail.js"></script>
<script src="/resources/js/product.comment.js"></script>
<script>
document.addEventListener('DOMContentLoaded', function(){
	getCommentList(document.getElementById('pnoVal').innerText);
	if(document.getElementById('cmtWriter').innerText == ''){
		document.getElementById('cmtText').disabled = true;
		document.getElementById('cmtSbmBtn').classList.add("disabled");
	}
});
</script>
<jsp:include page="../common/footer.jsp" />