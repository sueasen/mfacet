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
        <title>mfacet sample LoginSample List</title>

        <!-- Bootstrap -->
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/todc-bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/custom.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">

    </head>
    <body>

        <div class="container">

            <!-- Navbar ================================================== -->
            <%@ include file="../../navbar.jsp" %>
            <hr>

            <h2 class="form-signin-heading">sample LoginSample List</h2>
            <hr>

<!--
            <form:form action="/mfacet/sample/loginSampleInsert" method="get" >
                <input type="submit" class="btn btn-lg btn-primary" name="insert" value="Insert" />
            </form:form>
            <hr>
 -->
            <table class="table table-bordered table-hover">

                <thead>
                    <tr class="info">
                        <th>ID</th>
                        <th>Password</th>
                        <th>Version</th>
                        <td></td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${loginSamples}" var="loginSample">
                        <tr>
                            <td><c:out value="${loginSample.id}"/></td>
                            <td><c:out value="${loginSample.password}"/></td>
                            <td><c:out value="${loginSample.version}"/></td>
                            <td>
                                <c:url value="/sample/loginSample/${loginSample.id}" var="url"/>
                                <a href="${url}">編集</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div> <!-- /container -->

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

    </body>
</html>

