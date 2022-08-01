
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp" />


<section class="py-5">
  <div class="container px-4 px-lg-5 mt-5">
    
    <div
      class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center" id="menu_list">
  <c:forEach var="cfmevo" items="${list }">
      <div class="col mb-5">
        <div class="card h-100">
          <!-- Sale badge-->
          <c:choose>
          <c:when test="${cfmevo.sal eq 1 }">
            <div class="badge bg-dark text-white position-absolute"
              style="top: 0.5rem; right: 0.5rem">Sal</div>
          </c:when>
          <c:when test="${cfmevo.sal eq 2 }">
            <div class="badge bg-danger text-white position-absolute"
              style="top: 0.5rem; right: 0.5rem">Sold Out</div>
          </c:when>
            </c:choose>
          <!-- Product image-->
          <img class="card-img-top" name="image_file" value="${cfmevo.image_file }"
            src="/_fileUpload/th_${cfmevo.image_file}" alt="..." />
          <!-- Product details-->
          <div class="card-body p-4">
          <input type="hidden" value="${cfmevo.pno }" name="pno">
            <div class="text-center">
              <!-- Product name-->
              <h5 class="fw-bolder">${cfmevo.pno}. ${cfmevo.name }</h5>
              <!-- Product reviews-->
              <div
                class="d-flex justify-content-center small text-warning mb-2">
                <div class="bi-star-fill"></div>
                <div class="bi-star-fill"></div>
                <div class="bi-star-fill"></div>
                <div class="bi-star-fill"></div>
                <div class="bi-star-fill"></div>
              </div>
              <!-- Product price-->
              <span class="text-muted">Price : ${cfmevo.price }</span>
              
            </div>
          </div>
          <!-- Product actions-->
          <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
            <div class="text-center">
              
              <a href="/cfme/detail?pno=${cfmevo.pno}" class="btn btn-outline-warning">Menu Modify</a>
              <a href="/cfme/remove?pno=${cfmevo.pno}" class="btn btn-outline-danger">Menu Remove</a>
              <a href="/cfme/sal_change?pno=${cfmevo.pno}" class="btn btn-outline-info">Sal change</a>
            </div>
          </div>
        </div>
      </div>

      
    </c:forEach>
    </div>
    
  </div>
  </div>
  </div>
</section>

<jsp:include page="../footer.jsp" />