<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"/>


<br>
<br>
<br>
<br>
<div class="container mt-3">
  <h2>Product Detail</h2>  
</div> 
<div class="container mt-3">
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Pno : ${pvo.pno }</li>
    <li class="list-group-item">Pname : ${pvo.pname }</li>
    <li class="list-group-item">Price : ${pvo.price }</li>
    <li class="list-group-item">Regdate : ${pvo.regdate }</li>
    <li class="list-group-item">Made by : ${pvo.madeby }</li>
  </ul>
  <a href="/pd/list" class="btn btn-primary">List</a>
  <a href="/pd/modify?pno=${pvo.pno }" class="btn btn-outline-warning">Modify</a>
  <a href="/pd/remove?pno=${pvo.pno }" class="btn btn-outline-danger">Remove</a>
</div>

<!-- Questions -->
<div class="accordion-1">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <h2 class="h2-heading">Product Replies</h2>
        <div class="input-group mb-3">
          <span class="input-group-text" id="repWriter">${ssmvo.email }</span>
          <input type="text" class="form-control" id="repText" placeholder="Add Comment">
          <button class="btn btn-success" type="button" id="repAddBtn">ADD</button>
        </div>
      </div>
      <!-- end of col -->
    </div>
    <!-- end of row -->
    <div class="row">
      <div class="col-lg-12">
        <div class="accordion" id="accordionExample">

          <!-- Accordion Item -->
          <div class="accordion-item">
            <h2 class="accordion-header" id="headingOne">
              <button class="accordion-button" type="button"
                data-bs-toggle="collapse" data-bs-target="#collapseOne"
                aria-expanded="true" aria-controls="collapseOne">
                rno, pno, replier
                </button>
            </h2>
            <div id="collapseOne" class="accordion-collapse collapse show"
              aria-labelledby="headingOne" data-bs-parent="#accordionExample">
              <div class="accordion-body">reply, mod_at</div>
            </div>
          </div>
          <!-- end of accordion-item -->

        </div>
        <!-- end of accordion -->
      </div>
      <!-- end of col -->
    </div>
    <!-- end of row -->
  </div>
  <!-- end of container -->
</div>
<!-- end of accordion-1 -->
<!-- end of questions -->

<script>
const pnoVal = '<c:out value="${pvo.pno}"/>';
</script>
<script src="/resources/js/product.detail.js"></script>
<script>
printRepliesList(pnoVal);
</script>
<jsp:include page="../footer.jsp"/>