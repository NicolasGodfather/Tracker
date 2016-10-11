<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<%--<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Error Page</title>
    <link href="css/first.css" rel="stylesheet">
</head>
<body>

<b><a href="?locale=ru"><spring:message code="global_change_language.ru"/></a></b>
<b><a href="?locale=en"><spring:message code="global_change_language.en"/></a></b>
<b><a href="signOut"><spring:message code="global_sign_out"/></a></b>

<br/><br/>--%>

<c:if test="${errorServiceException}">
    <i><spring:message code="error_error_message"/></i>
</c:if>


</body>
</html>