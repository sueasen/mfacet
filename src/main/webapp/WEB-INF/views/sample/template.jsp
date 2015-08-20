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
        <title>${param.title}</title>

        <!-- Bootstrap -->
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/css/todc-bootstrap.min.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/css/signin.css" />" >
        <link rel="stylesheet" href="<c:url value="/resources/css/custom.css" />">

    </head>
    <body>
<!--
        <jsp:include page="header.jsp"/>
        <jsp:include page="navigation.jsp"/>
 -->
        <div class="container">${param.content}</div>
<!--
        <jsp:include page="footer.jsp"/>
 -->

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    </body>
</html>
