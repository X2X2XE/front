<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="/">HOME</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">

				<c:choose>
					<c:when test="${ses.email ne null && ses.email ne '' }">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								User_info </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="/member/detail?email=${ses.email}">${ses.nickName }(${ses.email })</a></li>
								<li><a class="dropdown-item" href="#">${ses.lastLogin }</a></li>
								<c:if test="${ses.grade eq 1 }">
									<li><a class="dropdown-item" href="/member/list">Member_List</a></li>
								</c:if>

								<li><hr class="dropdown-divider"></li>

								<li><a class="nav-link btn-danger" href="/member/logout">Logout</a></li>
							</ul></li>

					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/member/register">Member Register</a></li>
						<li class="nav-item"><a class="nav-link" href="/member/login">Login</a>
						</li>
					</c:otherwise>

				</c:choose>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Product_Menu </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
				<c:if test="${ses.email ne null && ses.email ne '' }">
							<li><a class="dropdown-item" href="/product/register">Product_register</a></li>
				</c:if>
							<li><a class="dropdown-item" href="/product/list">Product_list</a></li>
						</ul></li>
				<li class="nav-item"><a class="nav-link disabled">Disabled</a>
				</li>
			</ul>
			
		</div>
	</div>
</nav>