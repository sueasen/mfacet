<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
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
        <title>mfacet error</title>

        <!-- Bootstrap -->
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/css/todc-bootstrap.min.css" />">

    </head>
    <body>
        <div class="container">
            <h1>error page</h1>
            <h5><a href="${pageContext.request.contextPath}/">Top page</a></h5>
            <h5><a href="${pageContext.request.contextPath}/sample/loginsample">Sample login page</a></h5>
            <hr>

            <p class="text-danger"><c:out value="<%= exception.getMessage() %>"/></p>

        </div> <!-- /container -->

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

    </body>
</html>
