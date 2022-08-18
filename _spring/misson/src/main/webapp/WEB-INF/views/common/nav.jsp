<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
								<li><a class="dropdown-item" href="#">${ses.email }</a></li>								
								
								<li><hr class="dropdown-divider"></li>
								<li><a class="nav-link btn-danger" href="/user/logout">Logout</a></li>
							</ul></li>

					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/user/register">Sign Up</a></li>
						<li class="nav-item"><a class="nav-link" href="/user/login">Sign in</a>
						</li>
					</c:otherwise>

				</c:choose>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							지식인! </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="/board/list?category=1">교육, 학문</a></li>
							<li><a class="dropdown-item" href="/board/list?category=2">컴퓨터통신</a></li>
							<li><a class="dropdown-item" href="/board/list?category=3">게임</a></li>
							<li><a class="dropdown-item" href="/board/list?category=4">엔터테이먼트, 예술</a></li>
						</ul></li>
				
				</li>
			</ul>
			
		</div>
	</div>
</nav>