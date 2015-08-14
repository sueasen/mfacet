<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <title>mfacet sample input</title>

        <!-- Bootstrap -->
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/css/todc-bootstrap.min.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/css/signin.css" />">

    </head>

    <body>
        <div class="container">
            <h1>Input Sample</h1>
            <hr>

            <label>button</label><br>
            <button type="button" class="btn btn-default">Default</button>
            <button type="button" class="btn btn-primary">Primary</button>
            <button type="button" class="btn btn-success">Success</button>
            <button type="button" class="btn btn-info">Info</button>
            <button type="button" class="btn btn-warning">Warning</button>
            <button type="button" class="btn btn-danger">Danger</button>
            <button type="button" class="btn btn-link">Link</button>
            <button type="button" class="btn btn-primary btn-lg">Large button</button>
            <button type="button" class="btn btn-default btn-lg">Large button</button>
            <hr>

            <form:form action="${pageContext.request.contextPath}/sample/inputsample" method="post" modelAttribute="inputDto" >

                <form:errors path="*" element="div" cssClass="text-danger" />

                <label>text</label>
                <form:input path="text" cssClass="form-control" placeholder="Text" />
                <form:errors path="text" cssClass="text-danger"/>
                <br/>
                <label>textarea</label>
                <form:textarea path="textarea" cssClass="form-control" placeholder="Textarea" />
                <form:errors path="textarea" cssClass="text-danger"/>
                <br/>
                <label>checkbox</label><br>
                <form:checkbox path="checkbox" />test
                <form:errors path="checkbox" cssClass="text-danger"/>
                <br/><br/>
                <label>checkboxes</label><br/>
                <form:checkboxes path="checkboxes" items="${checkBoxItems}" delimiter="&nbsp;&nbsp;&nbsp;" />
                <form:errors path="checkboxes" cssClass="text-danger"/>
                <br/><br/>
                <label>radiobutton</label><br/>
                <form:radiobuttons path="radiobutton" items="${radiobuttonItems}" delimiter="&nbsp;&nbsp;&nbsp;" />
                <form:errors path="radiobutton" cssClass="text-danger"/>
                <br/><br/>
                <label>select</label>
                <form:select path="select" items="${selectItems}" cssClass="form-control" />
                <form:errors path="select" cssClass="text-danger"/>
                <br/>
                <label>selects</label>
                <form:select path="selects" items="${selectItems}" cssClass="form-control" multiple="true" size="3" />
                <form:errors path="selects" cssClass="text-danger"/>
                <br/>

<!-- password -->
<div class="form-group">
    <label class="control-label">password</label>
    <input type="password" class="form-control" placeholder="Password" />
</div>
<!-- date -->
<div class="form-group">
    <label class="control-label">date</label>
    <input type="date" class="form-control"/>
</div>
<!-- time -->
<div class="form-group">
    <label class="control-label">time</label>
    <input type="time" class="form-control"/>
</div>
<!-- week -->
<div class="form-group">
    <label class="control-label">week</label>
    <input type="week" class="form-control"/>
</div>
<!-- number -->
<div class="form-group">
    <label class="control-label">number</label>
    <input type="number" class="form-control"/>
</div>
<!-- email -->
<div class="form-group">
    <label class="control-label">email</label>
    <input type="email" class="form-control"/>
</div>
<!-- color -->
<div class="form-group">
    <label class="control-label">color</label>
    <input type="color" class="form-control"/>
</div>
<!-- range -->
<div class="form-group">
    <label class="control-label">range</label>
    <input type="range" class="form-control"/>
</div>

                <hr>
            </form:form>
        </div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    </body>

</html>