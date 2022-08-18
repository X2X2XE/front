<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<c:set var="bvo" value="${bdto.bvo }"/>
<div class="container mt-5">
	<h1>Product Detail</h1>
	<table class="table table-striped">
		<tr>
			<th>bno</th>
			<td id="bnoVal">${bvo.bno }</td>
		</tr>
		<tr>
			<th>Category</th>
			<td>${bvo.category }</td>
		</tr>
		<tr>
			<th>Read Count</th>
			<td>${bvo.readCount }</td>
		</tr>
		<tr>
			<th>bname</th>
			<td>${bvo.bname }</td>
		</tr>
		<tr>
			<th>Writer</th>
			<td>${bvo.writer }</td>
		</tr>
		<tr>
			<th>Description</th>
			<td>${bvo.description }</td>
		</tr>
		<tr>
			<th>RegAt</th>
			<td>${bvo.regAt }</td>
		</tr>
		<tr>
			<th>ModAt</th>
			<td>${bvo.modAt }</td>
		</tr>
		
		
	</table>
	<div class="d-flex mb-3">
    <c:forEach items="${bdto.fileList }" var="fvo" >
    <c:choose>
    <c:when test="${fvo.fileType == 1 }">
    	<div class="p-2 flex-fill bg-info">
    	<img src="/upload/${fn:replace(fvo.saveDir, '\\','/')}/${fvo.uuid}_th_${fvo.fileName}" class="th_img">
    	 
    	</div>
    </c:when>
    <c:otherwise></c:otherwise>
    </c:choose>
	</c:forEach>
	</div>
	
	
	<ul class="nav justify-content-center">
    <li class="nav-item">
      <a class="nav-link" href="/board/list?pageNo=${pgvo.pageNo }&qty=${pgvo.qty}&type=${pgvo.type}&kw=${pgvo.kw}&category=${bvo.category}">List</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/board/modify?bno=${bvo.bno }&pageNo=${pgvo.pageNo }&qty=${pgvo.qty}&type=${pgvo.type}&kw=${pgvo.kw}">Modify</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" id="productRemove">Remove</a>
    </li>    
  </ul>
  <form action="" id="productRmForm" style="display: none;" method="post">
  	<input type="hidden" id="bn" value="" name="bno">
  	<input type="hidden" value="${pgvo.pageNo}" name="pageNo">
  	<input type="hidden" value="${pgvo.qty}" name="qty">
  	<input type="hidden" value="${pgvo.kw } " name="kw">  	
  </form>
</div>

<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal2" id="modalBtn2" style="display:none;">
    Open modal
  </button>
</div>

<div class="modal" id="myModal2">
  <div class="modal-dialog modal-xl" style="position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%);">
    <div class="modal-content" style="background-color:rgba(0,0,0,0); border:0;" id="modalZone2">
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

<script src="/resources/js/board.detail.js"></script>
<script src="/resources/js/board.comment.js"></script>
<script>
document.addEventListener('DOMContentLoaded', function(){
	getCommentList(document.getElementById('bnoVal').innerText,document.getElementById('cmtWriter').innerText);
	if(document.getElementById('cmtWriter').innerText == ''){
		document.getElementById('cmtText').disabled = true;
		document.getElementById('cmtSbmBtn').classList.add("disabled");
	}
});
</script>
<jsp:include page="../common/footer.jsp" />