<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<div class="container mt-5">
	<c:choose>
		<c:when test="${ses.grade==1 }">
	<div class="container mt-5">
	<div class="row">
		<div class="col-sm-12 col-md-6">

			<h1>Member List</h1>
		</div>
		<div class="col-sm-12 col-md-6">
			<form class="d-flex" action="/member/list" method="get">
			<input type="hidden" name="pageNo" value="${pgn.pgvo.pageNo }">
			<input type="hidden" name="qty" value="${pgn.pgvo.qty }">
				<div class="input-group">
				<c:set value="${pgn.pgvo.type }" var="typed"/>
					<select class="form-select" name="type">
						<option ${typed eq null ? 'selected' : '' }>선택</option>
						<option value="en" ${typed eq 'en' ? 'selected' : '' }>전체검색</option>
						<option value="e" ${typed eq 'e' ? 'selected' : '' }>Email</option>
						<option value="n" ${typed eq 'n' ? 'selected' : '' }>NickName</option>
						
						
						
						
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
				<th>Email</th>
				<th>Nickname</th>
				<th>Reg At</th>
				<th>Last Login</th>
				<th>Grade</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="mvo">
				<tr>
					<td>${mvo.email}</td>
					<td><a href="/member/detail?email=${mvo.email}&pageNo=${pgn.pgvo.pageNo}&qty=${pgn.pgvo.qty}">${mvo.nickName}</a></td>
					<td>${mvo.regAt}</td>
					<td>${mvo.lastLogin}</td>
					<td>${mvo.grade}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<ul class="pagination justify-content-center">
		<c:if test="${pgn.prev}">
    		<li class="page-item">
    			<a class="page-link" href="/member/list?pageNo=${pgn.startPage-1}&qty=${pgn.pgvo.qty}&type=${pgn.pgvo.type}&kw=${pgn.pgvo.kw}">
    			Prev
    			</a>
    		</li>
    	</c:if>
    	<c:forEach begin = "${pgn.startPage }" end="${pgn.endPage }" var="i">
    	<li class="page-item ${pgn.pgvo.pageNo == i ? 'active' : '' }">
    	<a class="page-link" href="/member/list?pageNo=${i}&qty=${pgn.pgvo.qty}&type=${pgn.pgvo.type}&kw=${pgn.pgvo.kw}">${i}</a>
    	</li>
    	</c:forEach >
    	<c:if test="${pgn.next }">
    	<li class="page-item"><a class="page-link" href="/member/list?pageNo=${pgn.endPage+1}&qty=${pgn.pgvo.qty}&type=${pgn.pgvo.type}&kw=${pgn.pgvo.kw}">Next</a></li>
    	</c:if>
  	</ul>
	</c:when>
	<c:otherwise>
		<h2>권한이 필요한 페이지 입니다</h2>
	</c:otherwise>
	</c:choose>
</div>

<jsp:include page="../common/footer.jsp" />