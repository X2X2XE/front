<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp" />

<!-- Testimonials -->
<div class="container mt-3">
	<h2>Cart Page</h2>
	
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>image</th>
				<th>Name</th>
				<th>temper</th>
				<th>price</th>
				<th>the_number</th>
				<th>.etc</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cfovo" items="${list }">
				<c:if test="${cfovo.order_time eq null }">
					<tr>
						<form method="post" action="/cfo/cart_order">
							<td><img class="decoration-lines"
								src="/_fileUpload/th_${cfovo.image_file }"></td>
							<td>${cfovo.name } <input type="hidden"
								value="${cfovo.ono }" name="ono"> <input type="hidden"
								value="${cfovo.id }" name="id">
							</td>
							<td>
							   <c:choose>
									<c:when test="${cfovo.kind eq 1}">
										<div class="mb-4 form-floating">
											<input class="form-check-input" type="radio" name="temper"
												id="" value="0" checked="checked"> <label
												class="form-check-label" for="flexRadioDefault1">
												Hot </label>
										</div>
										<div class="mb-4 form-floating">
											<input class="form-check-input" type="radio" name="temper"
												id="" value="1"> <label class="form-check-label"
												for="flexRadioDefault1"> Ice </label>
										</div>
									</c:when>
									<c:when test="${cfovo.kind ne 1}">
                    <div class="mb-4 form-floating">
                      <input class="form-check-input" type="hidden" name="temper"
                        id="" value="3" > <label
                        class="form-check-label" for="flexRadioDefault1">
                        No check </label>
                    </div>
                    
                  </c:when>
								</c:choose>
								</td>
							<td>${cfovo.price }</td>
							<td>
							   <input type="button"
								class="btn btn-outline-info number_minus" id="number_minus"
								value="-"> <input type="number" id="the_number"
								name="the_number" value="1"> <input type="button"
								class="btn btn-outline-info number_plus" id="number_plus"
								value="+">
							</td>
							<td>
							<c:choose>
							<c:when test="${cfovo.kind eq 1 }">
								<div class="mb-4 form-floating">
									<input class="form-check-input" type="radio" name="etc" id=""
										value="1" checked="checked"> <label
										class="form-check-label" for="flexRadioDefault1">
										whippingX </label>
								</div>
								<div class="mb-4 form-floating">
									<input class="form-check-input" type="radio" name="etc" id=""
										value="2" > <label
										class="form-check-label" for="flexRadioDefault1">
										whipping△ </label>
								</div>
								<div class="mb-4 form-floating">
									<input class="form-check-input" type="radio" name="etc" id=""
										value="3" > <label
										class="form-check-label" for="flexRadioDefault1">
										whipping more </label>
								</div>
								<div class="mb-4 form-floating">
									<input class="form-check-input" type="radio" name="etc" id=""
										value="4" > <label
										class="form-check-label" for="flexRadioDefault1"> Ice
										X </label>
								</div>
								<div class="mb-4 form-floating">
									<input class="form-check-input" type="radio" name="etc" id=""
										value="5" > <label
										class="form-check-label" for="flexRadioDefault1"> Ice
										more </label>
								</div>
									</c:when>
									<c:when test="${cfovo.kind ne 1 }">
                <div class="mb-4 form-floating">
                  <input class="form-check-input" type="hidden" name="etc" id=""
                    value="6" > <label
                    class="form-check-label" for="flexRadioDefault1">
                    No check </label>
                </div>
                  </c:when>
								</c:choose>
							</td>
							<td><button type="submit"
								class="btn btn-outline-primary">주문</button></td>
							<td><a href="/cfo/cart_cancel?ono=${cfovo.ono }"
								class="btn btn-outline-danger">취소</a></td>
						</form>
					</tr>
				</c:if>
			</c:forEach>

		</tbody>
	</table>
</div>
<script src="/js/cart_list.js">
	
</script>
<jsp:include page="../footer.jsp" />