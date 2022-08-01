<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="../common/nav.jsp"/>


<div class="container mt-3">
  <form action="/member/register" method="post">
    <div class="mb-3 mt-3 ">
    	<h3>Member Detail</h3>
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="emVal" value="${mvo.email}" name="" readonly>
    </div>
    <div class="mb-3">
      <label for="nickName">NickName</label>
      <input type="text" class="form-control" id="nickName" value="${mvo.nickName}" name="nickName" readonly>
    </div>
    <div class="mb-3">
      <label for="regAt">Reg At:</label>
      <input type="text" class="form-control" id="regAt" value="${mvo.regAt}"  name="regAt" readonly>
    </div>
    <div class="mb-3">
      <label for="lastLogin">Last_login:</label>
      <input type="text" class="form-control" id="lastLogin" value="${mvo.lastLogin}"  name="lastLogin" readonly>
    </div>
    <div class="mb-3">
      <label for="grade">Grade:</label>
      <input type="text" class="form-control" id="grade" value="${mvo.grade}"  name="grade" readonly>
    </div>
    <button type="button" class="btn btn-warning"><a href="/member/modifiy?email=${mvo.email }">Modifiy</a></button>
	<button type="button" class="btn btn-danger"><a id="memberRemove">Remove</a></button>
	
  </form>
  <form action="asd" id="memberRmForm" style="display: none;" method="post">
		<input type="hidden" id="em" value="" name="email">
	</form>
</div>
<script src="/resources/js/member.detail.js"></script>

<jsp:include page="../common/footer.jsp"/>