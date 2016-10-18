<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<link rel="stylesheet" type="text/css" href="../resources/css/bootstrap-combined.min.css">
<script type="text/javascript" src="../resources/js/bootstrap-tree.js"></script>

<div class="page-header">
    <spring:message code="user.index.page.header"/>
    <div class="pull-right">
        <%--<sec:authorize access="hasRole('ADMIN')">--%>
            <a href="create" role="button" class="btn btn-default">
                <img src="../resources/images/user.png"/> <spring:message code="user.create.user.btn"/>
            </a>
            <a href="delete/${user.id}" role="button" class="btn btn-default">
                <img src="../resources/images/delete.png"/> <spring:message code="user.delete.user.btn"/>
            </a>
        <%--</sec:authorize>--%>
        <c:if test="${userInfo}">
            <a href="update/${user.id}" type="button" role="button" class="btn btn-default">
                <img src="../resources/images/update.png"/> <spring:message code="user.update.user.btn"/>
            </a>
        </c:if>
    </div>
</div>

<div class="row-fluid">
    <section role="main" class="col-md-4">
        <div class="tree">
            <%--Dear <strong>${userLogin}</strong>, Welcome to Admin Page.--%>
            <ul>
                <li>
                    <span><i class="icon-folder-open"></i>Users</span>
                    <c:forEach items="${usersTree}" var="tree">
                        <ul>
                            <li>
                                <span><img src="../resources/images/circle.png"/></span> <label class="label label-primary"> ${tree.key.name}</label>
                                <ul>
                                    <c:forEach items="${tree.value}" var="user">
                                        <li>
                                            <a href="/users/info/${user.id}"><label class="label label-success">${user.name} ${user.surname}</label></a>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </li>
                        </ul>
                    </c:forEach>
                </li>
            </ul>
        </div>
    </section>
    <c:choose>
        <c:when test="${userInfo}">
            <section class="col-md-8">
                <jsp:include page="user.jsp"/>
            </section>
        </c:when>
        <c:otherwise>
            <section class="col-md-8">
                <div class="jumbotron">
                    <h1><spring:message code="no.users.chosen"/></h1>
                    <h2><small><spring:message code="choose.user.from.list"/></small></h2>
                </div>
            </section>
        </c:otherwise>
    </c:choose>
</div>