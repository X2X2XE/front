<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp" />
<c:set var="ssmvo" value="${ses }" scope="session" />
<!-- Header -->
<header class="ex-header">
	<div class="container">
		<div class="row">
			<div class="col-xl-10 offset-xl-1">
				<h1 class="text-center">Menu Add</h1>
			</div>
			<!-- end of col -->
		</div>
		<!-- end of row -->
	</div>
	<!-- end of container -->
</header>
<!-- end of ex-header -->
<!-- end of header -->


<!-- Basic -->
<div class="ex-form-1 pt-5 pb-5">
	<div class="container">
		<div class="row">
			<div class="col-xl-6 offset-xl-3">
				<div class="text-box mt-5 mb-5">
					<p class="mb-4">
						<a class="blue" href="#">Log In</a>
					</p>

					<!-- Register Form -->
					<form action="/cfme/add_menu" method="post"
						enctype="multipart/form-data">
						<div class="mb-4 form-floating">
							<input type="text" class="form-control" id="" name="name"
								placeholder="Menu Name"> <label for="">Menu Name</label>
						</div>
						<div class="mb-4 form-floating">
							<input type="text" class="form-control" id="" name="price"
								placeholder="Menu Price"> <label for="">Menu
								Price</label>
						</div>
						<div class="mb-4 form-floating">
							<input class="form-check-input" type="radio"
								name="kind" id="" value="1"> <label
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
						<div class="mb-4 form-floating">
							<input type="file" class="form-control" id="file"
								name="imageFile"
								accept="image/png, image/jpeg, image/jpg, image/gif"> <label
								for="file">Image File</label>
						</div>
						<button type="submit" class="form-control-submit-button btn btn-primary">Regster</button>
					</form>
					<!-- end of sign up form -->

				</div>
				<!-- end of text-box -->
			</div>
			<!-- end of col -->
		</div>
		<!-- end of row -->
	</div>
	<!-- end of container -->
</div>
<!-- end of ex-basic-1 -->
<!-- end of basic -->

<jsp:include page="../footer.jsp" />