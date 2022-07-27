<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"/>


<div class="ex-form-1 pt-5 pb-5">
  <div class="container">
    <div class="row">
      <div class="col-xl-6 offset-xl-3">
        <div class="text-box mt-5 mb-5">
          <p class="mb-4">
            You don't have a password? Then please <a class="blue"
              href="/cfm/join">Sign Up</a>
          </p>

          <!-- Log In Form -->
          <form action="/cfm/login_auth" method="post">
            <div class="mb-4 form-floating">
              <input type="text" class="form-control" id="floatingInput" name="id"
                > <label
                for="IDInput">ID</label>
            </div>
            <div class="mb-4 form-floating">
              <input type="password" class="form-control" id="floatingPassword" name="pwd"
                placeholder="Password"> <label for="floatingPassword">Password</label>
            </div>            
            <button type="submit" class="form-control-submit-button btn btn-outline-primary">Log
              in</button>
          </form>
          <!-- end of log in form -->

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

<jsp:include page="../footer.jsp"/>