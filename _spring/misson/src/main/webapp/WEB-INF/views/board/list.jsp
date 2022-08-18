<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<div class="container mt-5">
	<div class="row">
		<div class="col-sm-12 col-md-6">

			<h1>
				<c:choose>
					<c:when test="${cate == 1 }">
						교육, 학문
					</c:when>
					<c:when test="${cate == 2 }">
						컴퓨터통신
					</c:when>
					<c:when test="${cate == 3 }">
						게임
					</c:when>
					<c:when test="${cate == 4 }">
						엔터테이먼트, 예술
					</c:when>
				</c:choose>
				<c:if test="${ses.email ne null }">
					<a href="/board/register" class="btn btn-primary">Register</a>
				</c:if>
			</h1>
		</div>
		<div class="col-sm-12 col-md-6">
			<form class="d-flex" action="/board/list" method="get">
			<input type="hidden" name="pageNo" value="${pgn.pgvo.pageNo }">
			<input type="hidden" name="qty" value="${pgn.pgvo.qty }">
				<div class="input-group">
				<c:set value="${pgn.pgvo.type }" var="typed"/>
					<select class="form-select" name="type">
						<option ${typed eq null ? 'selected' : '' }>선택</option>
						<option value="twc" ${typed eq 'twc' ? 'selected' : '' }>전체검색</option>
						<option value="t" ${typed eq 't' ? 'selected' : '' }>Title</option>
						<option value="w" ${typed eq 'w' ? 'selected' : '' }>Writer</option>
						<option value="c" ${typed eq 'c' ? 'selected' : '' }>Content</option>
						<option value="tw" ${typed eq 'tw' ? 'selected' : '' }>Title or Wirter</option>
						<option value="tc" ${typed eq 'tc' ? 'selected' : '' }>Title or Content</option>
						<option value="wc" ${typed eq 'wc' ? 'selected' : '' }>Writer or Content</option>
					</select> 
					<input class="form-control me-2" type="search"
						placeholder="Search" aria-label="Search" name="kw" value="${pgn.pgvo.kw }">
					<button class="btn btn-outline-success" type="submit">Search 
					<c:if test="${typed ne null }">
					<span class="badge bg-danger">${pgn.totalCount }</span>
					</c:if>
					</button>
				</div>
			</form>
		</div>
	</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Bno</th>
				<th>Category</th>
				<th>Bname</th>
				<th>Writer</th>
				<th>Mod At</th>
				<th>Read Count</th>
				<th>Cmt Qty</th>
				<th>Attach</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="bvo">
				<tr>
					<td>${bvo.bno}</td>
					<td>${bvo.category}</td>
					<td><a
						href="/board/detail?bno=${bvo.bno}&pageNo=${pgn.pgvo.pageNo}&qty=${pgn.pgvo.qty}">${bvo.bname}</a></td>
					
					<td>${bvo.writer}</td>
					<td>${bvo.modAt}</td>
					<td>${bvo.readCount}</td>
					<td>${bvo.cmtQty}</td>
					<td>
						<c:if test="${bvo.fileCount > 0}">
							<i class="material-icons">attachment</i>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<ul class="pagination justify-content-center">
		<c:if test="${pgn.prev}">
			<li class="page-item"><a class="page-link"
				href="/product/list?pageNo=${pgn.startPage-1}&qty=${pgn.pgvo.qty}&type=${pgn.pgvo.type}&kw=${pgn.pgvo.kw}">
					Prev </a></li>
		</c:if>
		<c:forEach begin="${pgn.startPage }" end="${pgn.endPage }" var="i">
			<li class="page-item ${pgn.pgvo.pageNo == i ? 'active' : '' }">
				<a class="page-link"
				href="/product/list?pageNo=${i}&qty=${pgn.pgvo.qty}&type=${pgn.pgvo.type}&kw=${pgn.pgvo.kw}">${i}</a>
			</li>
		</c:forEach>
		<c:if test="${pgn.next }">
			<li class="page-item"><a class="page-link"
				href="/product/list?pageNo=${pgn.endPage+1}&qty=${pgn.pgvo.qty}&type=${pgn.pgvo.type}&kw=${pgn.pgvo.kw}">Next</a></li>
		</c:if>
	</ul>

</div>

<jsp:include page="../common/footer.jsp" />