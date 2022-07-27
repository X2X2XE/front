<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp" />

<!-- Testimonials -->
<div class="container mt-3">
	<h2>Order List</h2>
	<br>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Order Number</th>
				<th>Image</th>
				<th>Name</th>
				<th>price</th>
				<th>the_number</th>
				<th>Temper</th>
				<th>.etc</th>
				<th>Order time</th>
				<th>End time</th>
				<th>Order status</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cfovo" items="${list }">
				<tr>
					<form method="post" action="/cfo/cart_order">
						<td>${cfovo.ono} .<input type="hidden" value="${cfovo.ono}"
							name="ono" readonly></td>
						<td><img class="decoration-lines"
							src="/_fileUpload/th_${cfovo.image_file }"></td>
						<td>${cfovo.name } <input type="hidden"
							value="${cfovo.id }" name="id">
						</td>
						<td>${cfovo.price }</td>
						<td>${cfovo.the_number }</td>
						
						<td>
            <c:if test="${cfovo.kind eq 1 }">
            <input type="text" readonly
              value="${cfovo.temper eq 0 ? 'HOT' : 'ICE'}">
            </c:if> 
            </td>
            
            <td>
            <c:if test="${cfovo.kind eq 1 }">
              <c:choose>
              
              <c:when test="${cfovo.etc eq 0 }">
                <input type="text" readonly value="휘핑 X">
              </c:when>
              <c:when test="${cfovo.etc eq 1 }">
                <input type="text" readonly value="휘핑 조금">
              </c:when>
              <c:when test="${cfovo.etc eq 2 }">
                <input type="text" readonly value="휘핑 추가">
              </c:when>
              <c:when test="${cfovo.etc eq 3 }">
                <input type="text" readonly value="얼음 X">
              </c:when>
              <c:when test="${cfovo.etc eq 4 }">
                <input type="text" readonly value="얼음 추가">
              </c:when>
              
              
              </c:choose>
            </c:if>
            </td>
            
            <td>${cfovo.order_time }</td>
            <td>${cfovo.endtime eq null ? "wating" : cfovo.endtime}</td>
            <td>
              <c:choose>
                <c:when test="${cfovo.made eq 1 }">
                  <input type="button" value="준비중" class="btn btn-waring" disabled>
                </c:when>
                <c:when test="${cfovo.made eq 2 }">
                  <input type="button" value="주문 완료" class="btn btn-primary" disabled>
                </c:when>
                <c:when test="${cfovo.made eq 3 }">
                  <input type="button" value="사용자가 주문 취소" class="btn btn-info" disabled>
                </c:when>
                <c:when test="${cfovo.made eq 4 }">
                  <input type="button" value="매장에서 주문 취소" class="btn btn-danger" disabled>
                </c:when>
              </c:choose>
            </td>
            
						<td>
						<c:choose>
						  <c:when test="${cfovo.made eq 1 }">
						    <a href="/cfo/order_cancel?ono=${cfovo.ono }" class="btn btn-primary">주문취소</a>
						  </c:when>
						  <c:when test="${cfovo.made ne 1 }">
						    <a href="/cfo/order_remove?ono=${cfovo.ono}"
							  class="btn btn-outline-danger">삭제</a>
							</c:when>
            </c:choose>							
					 </td>
					</form>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>
<script src="/js/cart_list.js">
	
</script>
<jsp:include page="../footer.jsp" />