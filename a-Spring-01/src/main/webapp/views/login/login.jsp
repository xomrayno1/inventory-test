<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Đăng Nhập</title>

    <!-- Bootstrap -->
    <link href='<c:url value="/resources/vendors/bootstrap/dist/css/bootstrap.min.css"></c:url>' rel="stylesheet">
    <!-- Font Awesome -->
    <link href='<c:url value="/resources/vendors/font-awesome/css/font-awesome.min.css"></c:url>' rel="stylesheet">
    <!-- NProgress -->
    <link href='<c:url value="/resources/vendors/nprogress/nprogress.css"></c:url>' rel="stylesheet">
    <!-- Animate.css -->
    <link href='<c:url value="/resources/vendors/animate.css/animate.min.css"></c:url>' rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href='<c:url value="/resources/build/css/custom.min.css"></c:url>' rel="stylesheet">
  </head>

  <body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
           <c:url var="url" value="/processLogin"/>
          <form:form modelAttribute="loginForm" servletRelativeAction="${url}" method="POST">
              <h1>Đăng Nhập</h1>
              <div>                
               	 <form:input path="userName" cssClass="form-control" placeholder="Username"/>
                	<div class="has-error">
                		<form:errors path="userName" cssClass="help-block" />
                	</div>
              </div>
              <div>
                
                <form:password path="password" cssClass="form-control" placeholder="Password"/>
                <div class="has-error">
                		<form:errors path="password" cssClass="help-block" />
                	</div>
              </div>
              <div>
               
                <button class="btn btn-default submit" type="submit">Đăng Nhập</button>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> Inventory Manager System</h1>
                  <p>©2016 All Rights Reserved. Inventory Manager System</p>
                </div>
              </div>
           
            </form:form>
          </section>
        </div>

<!-- 

        <div id="register" class="animate form registration_form">
          <section class="login_content">
            <form>
              <h1>Create Account</h1>
              <div>
                <input type="text" class="form-control" placeholder="Username" required="" />
              </div>
              <div>
                <input type="email" class="form-control" placeholder="Email" required="" />
              </div>
              <div>
                <input type="password" class="form-control" placeholder="Password" required="" />
              </div>
              <div>
                <a class="btn btn-default submit" href="index.html">Submit</a>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">Already a member ?
                  <a href="#signin" class="to_register"> Log in </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> Gentelella Alela!</h1>
                  <p>©2016 All Rights Reserved. Gentelella Alela! is a Bootstrap 3 template. Privacy and Terms</p>
                </div>
              </div>
            </form>
          </section>
        </div>
 -->
        
        
      </div>
    </div>
  </body>
</html>
