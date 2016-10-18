<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/css/dashboard.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap/bootstrap-theme.css"/>

    <tiles:insertAttribute  name="title"/>
    <c:if test="${not empty title}">
        <title><spring:message code="${title}"/></title>
    </c:if>
</head>
<body>

<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="body"/>
<tiles:insertAttribute name="footer"/>

</body>
</html>