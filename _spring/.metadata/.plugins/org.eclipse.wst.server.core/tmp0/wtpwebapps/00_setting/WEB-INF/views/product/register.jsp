<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="../common/nav.jsp"/>


<div class="container mt-3">
  <form action="/product/register" method="post" enctype="multipart/form-data">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
    <div class="mb-3 mt-3 ">
    	<h2>Product Register</h2>
      <label for="category">Category :</label>
      	<input type="text" class="form-control" id="category" placeholder="Enter category" name="category">
    </div>
    <div class="mb-3">
      <label for="pname">Pname:</label>
      <input type="text" class="form-control" id="pname" placeholder="Enter pname" name="pname">
    </div>
    <div class="mb-3">
      <label for="price">Price:</label>
      <input type="int" class="form-control" id="price" placeholder="Enter price" name="price">
    </div>
    <div class="mb-3">
      <label for="writer">Writer : </label>
      <input type="test" class="form-control" id="writer" value="${ses.email} " name="writer" readonly>
    </div>
    <div class="mb-3">
      <label for="madeBy">Made By:</label>
      <input type="text" class="form-control" id="madeBy" placeholder="Enter madeBy" name="madeBy">
    </div>
    <div class="mb-3">
      <label for="description">Description:</label>
      <textarea rows="5" class="form-control" id="description" placeholder="Enter description" name="description"></textarea>
      
    </div>
    
    <div class="mb-3">
      <label for="attach">File Attach:</label>
      <input type="file" class="form-control" style="display: none;" 
      id="files" name="fileAttached" multiple>
   	 <div class="d-grid">
      <button type="button" id="attachTrigger" class="btn btn-outline-primary btn-block d-block">Attach Files</button>
     </div>
     <div class="my-3" id="fileZone"></div>	
    </div>
    <button type="submit" class="btn btn-primary" id="regBtn">Submit</button>
  </form>
</div>

<script>
	document.getElementById('attachTrigger').addEventListener('click', () =>{
		document.getElementById('files').click();
	})
</script>
<script src="/resources/js/product.register.js">

</script>
<jsp:include page="../common/footer.jsp"/>