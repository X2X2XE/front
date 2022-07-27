<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp" />

<!-- Header-->
<header class="bg-dark py-5 main_img">
	<div class="container px-4 px-lg-5 my-5 ">
		<div class="text-center text-white">
			<h1 class="display-4 fw-bolder"></h1>
			<p class="lead fw-normal text-white-50 mb-0"></p>
		</div>
	</div>
</header>
<!-- Section-->
<div class="btn-group sel_menu" role="group" aria-label="Basic radio toggle button group">
<input type="radio" class="btn-check " name="btnradio" id="btnradio_all" autocomplete="off" checked>
  <label class="btn btn-dark btn-outline-danger sel_box" for="btnradio_all">ALL</label>
  
  <input type="radio" class="btn-check " name="btnradio" id="btnradio1" autocomplete="off">
  <label class="btn btn-dark btn-outline-danger sel_box" for="btnradio1">Coffee</label>

  <input type="radio" class="btn-check " name="btnradio" id="btnradio2" autocomplete="off">
  <label class="btn btn-dark btn-outline-danger sel_box" for="btnradio2">Juice & Smoothie</label>

  <input type="radio" class="btn-check " name="btnradio" id="btnradio3" autocomplete="off">
  <label class="btn btn-dark btn-outline-danger sel_box" for="btnradio3">Snack</label>
</div>
<div
      class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center" id="menu_list">
      
</div>
<script type="text/javascript" src="/js/cfmenulist.js">

</script>
  
<script type="text/javascript">

printCommentList();
</script>


<jsp:include page="footer.jsp" />