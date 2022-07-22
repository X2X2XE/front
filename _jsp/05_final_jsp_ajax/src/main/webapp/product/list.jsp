<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"/>
<br>
<br>
<br>
<br>
<br>

<div class="container mt-3">
  <h2>Product List <a href="/pd/register" class="btn btn-outline-primary">Register</a></h2>
  

  <table class="table table-hover">
    <thead>
      <tr>
        <th>Pno</th>
        <th>Pname</th>
        <th>Regdate</th>
      </tr>
    </thead>
    <tbody> 
      <c:forEach var="pvo" items="${list }">
      <tr>
        <td>${pvo.pno }</td>
        <td><a href="/pd/detail?pno=${pvo.pno }">${pvo.pname }</a></td>
        <td>${pvo.regdate }</td>
      </tr>
      </c:forEach>      
    </tbody>
  </table>
</div>

<jsp:include page="../footer.jsp"/>