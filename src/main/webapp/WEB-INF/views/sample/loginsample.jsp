<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>mfacet sample loginSample</title>

        <!-- Bootstrap -->
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/css/todc-bootstrap.min.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/css/signin.css" />" >
        <link rel="stylesheet" href="<c:url value="/resources/css/custom.css" />">

    </head>
    <body>

        <div class="container">
            <h2 class="form-signin-heading text-center">Sample Sign in with your Account</h2>

            <div class="card card-signin">
                <img class="img-circle profile-img" src="<c:url value="/resources/img/avatar.png" />" alt="">

                <form:form action="${pageContext.request.contextPath}/sample/loginsample" method="post" modelAttribute="loginDto" cssClass="form-signin">

                    <label for="id" class="sr-only">ID: </label>
                    <form:input path="id" id="id" cssClass="form-control" placeholder="User ID" />
                    <form:errors path="id" cssClass="error"/>
                    <br/>

                    <label for="id" class="sr-only">パスワード: </label>
                    <form:password path="password" id="password" cssClass="form-control" placeholder="Password" />
                    <form:errors path="password" cssClass="error"/>
                    <br/>

                    <input type="submit" class="btn btn-lg btn-primary btn-block" name="" value="Sign in" />

                    <form:errors cssClass="error"/>

                </form:form>
            </div>
            <p class="text-center">
                <a href="${pageContext.request.contextPath}/sample/loginSampleInsert">Create an account</a>
            </p>
            <p class="text-center">
                <a href="${pageContext.request.contextPath}/">Top page</a>
            </p>

        </div> <!-- /container -->

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

    </body>
</html>
