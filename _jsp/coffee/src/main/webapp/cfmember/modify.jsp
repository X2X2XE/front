<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp" />

<!-- Testimonials -->
<div class="slider-1 bg-gray">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="h2-heading">User Modify</h2>
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
								<form action="/cfm/modify_up" method="post">
									<input type="text" class="form-control" placeholder="ID : ${cfmvo.id }"  name="id" value="${cfmvo.id }" readonly>
									<input type="text" class="form-control" placeholder="Tel : ${cfmvo.tel }" name="tel">
									<input type="text" class="form-control" placeholder="grade : ${cfmvo.grade==2 ? '사용자' : '관리자' }" readonly>
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