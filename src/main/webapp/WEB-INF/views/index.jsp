<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        <title>mfacet top</title>

        <!-- Bootstrap -->
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/css/todc-bootstrap.min.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/css/carousel.css" />">

    </head>
    <body>
        <div class="container">
            <!-- Navbar ================================================== -->
            <%@ include file="navbar.jsp" %>

            <!-- Carousel ================================================== -->
            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class=""></li>
                    <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="2" class=""></li>
                    <li data-target="#myCarousel" data-slide-to="3" class=""></li>
                </ol>
                <div class="carousel-inner" role="listbox">
                    <div class="item">
                        <img class="first-slide" src="<c:url value="/resources/img/img9.jpg" />" alt="First slide">
                        <div class="container">
                            <div class="carousel-caption">
                                <h2>First slide top.</h2>
                                <p><a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}" role="button">Top</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="item active">
                        <img class="Secound-slide" src="<c:url value="/resources/img/avatar.png" />" alt="Secound slide">
                        <div class="container">
                            <div class="carousel-caption">
                                <h2>Second slide sample.</h2>
                                <p><a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/sample/loginsample" role="button">Sample</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <img class="third-slide" src="<c:url value="/resources/img/input.jpg" />" alt="Third slide">
                        <div class="container">
                            <div class="carousel-caption">
                                <h2>Third slide input-sample.</h2>
                                <p><a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/sample/inputsample" role="button">Sample Input</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <img class="fourth-slide" src="" alt="Fourth slide">
                        <div class="container">
                            <div class="carousel-caption">
                                <h2>Fourth slide blank.</h2>
                                <p><a class="btn btn-lg btn-primary" href="#" role="button">Blank</a></p>
                            </div>
                        </div>
                    </div>
                </div>
                <a class="left carousel-control" href="./#myCarousel" role="button" data-slide="prev">
                    <span class="icon-prev" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="./#myCarousel" role="button" data-slide="next">
                    <span class="icon-next" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>

            <!-- Under ================================================== -->
            <div class="container marketing">
                <div class="row">
                    <div class="col-lg-3">
                        <img class="img-circle" src="<c:url value="/resources/img/img9.jpg" />" width="140" height="140">
                        <h2>Top</h2>
                        <p><a class="btn btn-default" href="${pageContext.request.contextPath}" role="button">Top</a></p>
                    </div>
                    <div class="col-lg-3">
                        <img class="img-circle" src="<c:url value="/resources/img/avatar.png" />" width="140" height="140">
                        <h2>Sample</h2>
                        <p><a class="btn btn-default" href="${pageContext.request.contextPath}/sample/loginsample" role="button">Sample</a></p>
                    </div>
                    <div class="col-lg-3">
                        <img class="img-circle" src="<c:url value="/resources/img/input.jpg" />" width="140" height="140">
                        <h2>Input Sample</h2>
                        <p><a class="btn btn-default" href="${pageContext.request.contextPath}/sample/inputsample" role="button">Sample Input</a></p>
                    </div>
                    <div class="col-lg-3">
                        <img class="img-circle" src="<c:url value="" />" width="140" height="140">
                        <h2>Blank</h2>
                        <p><a class="btn btn-default" href="#" role="button">Blank</a></p>
                    </div>
                </div>
            </div>

        </div><!-- container -->


        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

    </body>
</html>
