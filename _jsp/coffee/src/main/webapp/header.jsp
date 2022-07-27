<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Shop Homepage - Start Bootstrap Template</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="/assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/css/styles.css" rel="stylesheet" />
</head>
<body>
  <c:set var="sscfmvo" value="${ses }" scope="session"/>
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-light bg-danger nav_head ">
    <div class="container px-4 px-lg-5">
      <a class="navbar-brand text-light" href="/">COFFEE ORDER </a>
      <button class="navbar-toggler " type="button"
        data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false"
        aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4 ">
         
          <c:if test="${sscfmvo.grade eq 1 }">
          <li class="nav-item dropdown"><a
            class="nav-link dropdown-toggle text-light" id="navbarDropdown" href="#"
            role="button" data-bs-toggle="dropdown" aria-expanded="false">Host Menu</a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li><a class="dropdown-item" href="#!">All Products</a></li>
              <li><hr class="dropdown-divider" /></li>
              <li><a class="dropdown-item" href="/cfme/add">Add_Item</a></li>
              <li><a class="dropdown-item" href="/cfme/list_page">Item_List(Modify)</a></li>
              <li><a class="dropdown-item" href="/cfo/host_order_list">Order_List(Host)</a></li>
            </ul></li>
           </c:if>
           <c:if test="${sscfmvo.grade eq 2 }">
            <li class="nav-item dropdown"><a
            class="nav-link dropdown-toggle text-light" id="navbarDropdown" href="#"
            role="button" data-bs-toggle="dropdown" aria-expanded="false">User Menu</a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li><a class="dropdown-item" href="#!">All Products</a></li>
              <li><hr class="dropdown-divider" /></li>
              <li><a class="dropdown-item" href="/cfm/detail?id=${sscfmvo.id}">User_Info</a></li>
              <li><a class="dropdown-item" href="/cfo/order_list">Order_List</a></li>
            </ul></li>
           </c:if>
        </ul>
        <form class="d-flex"   >
          
          <c:if test="${sscfmvo eq null }">
          <a href="/cfm/join" class="btn btn-success" >Sign Up</a>
          <a href="/cfm/login" class="btn btn-outline-dark">Login</a>
          </c:if>
          
        </form>
        <c:if test="${sscfmvo ne null }">
          <c:choose>
          <c:when test="${sscfmvo.grade eq 2 }">
            <a class="btn btn-outline-light" href="/cfo/cart_list?id=${sscfmvo.id }">
              <i class="bi-cart-fill me-1"></i> Cart <span
                class="badge bg-dark text-white ms-1 rounded-pill">Go</span>
            </a>
          </c:when>
          </c:choose>
          <form method="post" action="/cfm/detail">
            <input type="hidden" value="${sscfmvo.id}" name="id">
            <button class="btn btn-success" type="submit" >${sscfmvo.id }</button>
          </form>
          <a class="btn btn-dark" href="/cfm/logout">Log_Out</a>
        </c:if>
      </div>
    </div>
  </nav>