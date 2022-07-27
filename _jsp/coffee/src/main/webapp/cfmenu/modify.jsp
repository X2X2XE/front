<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp" />

<!-- Testimonials -->
<div class="slider-1 bg-gray">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
			<img class="card-img-top" name="image_file" value="${prd_info.image_file }"
            src="/_fileUpload/th_${prd_info.image_file}" alt="..." />
				<h2 class="h2-heading">${prd_info.pno}번 Modify</h2>
			</div>
			<!-- end of col -->
		</div>
		<!-- end of row -->
		<div class="row">
			<div class="col-lg-12">

				<!-- Card Slider -->
				<div class="slider-container">
					<div class="swiper-container card-slider">
						<div class="swiper-wrapper">

							
								<!-- Slide -->
								<form action="/cfme/modify" method="post" enctype="multipart/form-data">
									<input type="text" class="form-control" placeholder="Pno : ${prd_info.pno }"  name="pno" value="${prd_info.pno }" readonly>
									<input type="text" class="form-control" placeholder="Name : ${prd_info.name }" name="name" value="${prd_info.name }">
									<input type="text" class="form-control" placeholder="Price : ${prd_info.price }" name="price" value="${prd_info.price }">
									<div class="mb-4 form-floating">
              <input class="form-check-input" type="radio"
                name="kind" id="" value="1" checked="checked"> <label
                class="form-check-label" for="flexRadioDefault1">
                coffee </label>
            </div>
            <div class="mb-4 form-floating">
              <input class="form-check-input" type="radio"
                name="kind" id="" value="2"> <label
                class="form-check-label" for="flexRadioDefault1">
                 Smoothie</label>
            </div>
            <div class="mb-4 form-floating">
              <input class="form-check-input" type="radio"
                name="kind" id="" value="3"> <label
                class="form-check-label" for="flexRadioDefault1">
                snack </label>
            </div>
            <input type="hidden" name="image_file" value="${prd_info.image_file }">
									<input type="file" class="form-control" id="file" name="new_file" accept="image/png, image/jpeg, image/jpg, image/gif"> <label for="file">filename : ${prd_info.image_file }</label>
									<br>
									<button class="btn btn-warning" type="submit">Modfiy Up</button>
								</form>
								
								
								<!-- end of swiper-slide -->
								<!-- end of slide -->
							
						</div>
						<!-- end of swiper-wrapper -->

						<!-- Add Arrows -->
						<div class="swiper-button-next"></div>
						<div class="swiper-button-prev"></div>
						<!-- end of add arrows -->

					</div>
					<!-- end of swiper-container -->
				</div>
				<!-- end of slider-container -->
				<!-- end of card slider -->

			</div>
			<!-- end of col -->
		</div>
		<!-- end of row -->
	</div>
	<!-- end of container -->
</div>
<!-- end of slider-1 -->
<!-- end of testimonials -->

<jsp:include page="../footer.jsp" />