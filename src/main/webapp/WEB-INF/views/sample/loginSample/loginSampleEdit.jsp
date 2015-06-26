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
        <title>mfacet sample LoginSample Edit</title>

        <!-- Bootstrap -->
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/todc-bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/custom.css" />" rel="stylesheet">

    </head>
    <body>

        <div class="container">

            <h2 class="form-signin-heading text-center">sample LoginSample Edit</h2>

            <div class="card card-signin">
                <img class="img-circle profile-img" src="<c:url value="/resources/img/avatar.png" />" alt="">

                <form:form action="/mfacet/sample/loginSampleEdit" method="post" modelAttribute="loginSampleDto" cssClass="form-signin">

                    <label for="id" class="sr-only">ID: </label>
                    <form:input path="id" id="id" cssClass="form-control" placeholder="User ID" readonly="true" />
                    <form:errors path="id" cssClass="error"/>
                    <br/>

                    <label for="id" class="sr-only">パスワード: </label>
                    <form:input path="password" id="password" cssClass="form-control" placeholder="Password" />
                    <form:errors path="password" cssClass="error"/>
                    <br/>

                    <form:hidden path="version" />
                    <p class="text-muted">UpdateTime : <c:out value="${loginSampleDto.version}"/></p>
                    <br/>

                    <input type="submit" class="btn btn-lg btn-primary btn-block" name="update" value="Update" />
                    <input type="submit" class="btn btn-lg btn-warning btn-block" name="delete" value="Delete" />

                </form:form>
                <form:form action="/mfacet/sample/loginSampleList" method="get" cssClass="form-signin">
                    <input type="submit" class="btn btn-lg btn-info btn-block" name="" value="Back" />
                </form:form>
            </div>

        </div> <!-- /container -->

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

    </body>
</html>

