<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <%--<script type="text/javascript" src="../../resources/js/utils.js"><jsp:text/></script>--%>
    <%--<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.js"></script>--%>
    <%--<script type="text/javascript" src="../../resources/js/bootstrap.js"></script>--%>
    <link rel="stylesheet" href="../../../resources/css/bootstrap/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="../../../resources/css/dashboard.css" type="text/css">
    <link rel="stylesheet" href="../../../resources/css/bootstrap/bootstrap-theme.css" type="text/css">

    <%--<link href="css/second.css" rel="stylesheet"/>--%>

    <tiles:insertAttribute  name="title"/>
    <c:if test="${not empty title}">
        <title><spring:message code="${title}"/></title>
    </c:if>

</head>
<body>
<!--<div style="float: right;">-->
<!--<a href="?locale=ru" style="padding: 5px">RU</a>-->
<!--<a href="?locale=en" style="padding: 5px">EN</a>-->
<!--</div>-->
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="body"/>
</body>
<tiles:insertAttribute name="footer"/>
</html>