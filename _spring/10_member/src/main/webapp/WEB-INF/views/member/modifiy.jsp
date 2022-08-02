<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />


<form action="/member/modifiy" method="post">
	<div class="container mt-3">

		<div class="mb-3 mt-3 ">
			<h3>Member Modifiy</h3>
			<label for="email">Email:</label> <input type="email"
				class="form-control" id="email" value="${mvo.email}" name="email"
				readonly>
		</div>

		<div class="mb-3">
			<label for="pwd">PWD</label> <input type="password"
				class="form-control" id="pwd" value="${mvo.pwd}" name="pwd">
		</div>

		<div class="mb-3">
			<label for="nickName">NickName</label> <input type="text"
				class="form-control" id="nickName" value="${mvo.nickName}"
				name="nickName">
		</div>

		<div class="mb-3">
			<label for="regAt">Reg At:</label> <input type="text"
				class="form-control" id="regAt" value="${mvo.regAt}" name="regAt"
				readonly>
		</div>

		<div class="mb-3">
			<label for="lastLogin">Last_login:</label> <input type="text"
				class="form-control" id="lastLogin" value="${mvo.lastLogin}"
				name="lastLogin" readonly>
		</div>
		<c:if test="${ses.grade==1 }">
			<div class="mb-3">
				<label for="grade">Grade:</label> <input type="text"
					class="form-control" id="grade" value="${mvo.grade}" name="grade">
			</div>
		</c:if>


		<button type="submit" class="btn btn-warning">Modi!</button>
	</div>
</form>

<jsp:include page="../common/footer.jsp" />