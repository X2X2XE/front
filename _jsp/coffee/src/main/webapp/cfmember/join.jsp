<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp" />



<!-- Header -->
<header class="ex-header">
<c:set var="join" value="${msg_join }"/>
	<div class="container">
		<div class="row">
			<div class="col-xl-10 offset-xl-1">
				<br> <br>
				<h1 class="text-center">Sign Up</h1>
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
						Fill out the form below to sign up for the service. Already signed
						up? Then just <a class="blue" href="/cfm/login">Log In</a>
					</p>

					<!-- Sign Up Form -->
					<form action="/cfm/register" method="post">
						<div class="mb-4 form-floating">
							<input type="text" class="form-control id_input" id="id_input"
								placeholder="name@example.com" name="id" required> <label
								for="floatingInput">ID</label>
								<button type="button" class="btn btn-danger check" id="check">ID check</button>
						</div>
						<div class="mb-4 form-floating">
							<input type="password" class="form-control" id="floatingPassword"
								placeholder="Password" name="pwd" required> <label
								for="floatingPassword">Password</label>
						</div>
						<div class="mb-4 form-floating">
							<input type="text" class="form-control" id="floatingInput"
								name="tel" required> <label
								for="floatingInput">Tel : (-)을 제외하고 입력</label>
						</div>
						
						<button type="submit" class="btn btn-outline-primary">Sign
							up</button>
						
					
            
            
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
<script src="../js/cfmember.js"></script>

<jsp:include page="../footer.jsp" />