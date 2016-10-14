<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="resources/css/dashboard.css" type="text/css">
    <link rel="stylesheet" href="resources/css/bootstrap/bootstrap-theme.css" type="text/css">

    <tiles:insertAttribute  name="title"/>
    <c:if test="${not empty title}">
        <title><spring:message code="${title}"/></title>
    </c:if>
</head>

<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="body"/>
<tiles:insertAttribute name="footer"/>
</html>