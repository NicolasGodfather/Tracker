<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
<div class="container-fluid">
    <div class="row">
        <!-- SIDE MENU -->
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class='<c:if test="${tasksMain || taskCreate || taskInfo || taskUpdate}">active</c:if>'>
                    <a href="/tracker/model/main"><spring:message code="def.side.menu.all.tasks"/></a>
                </li>
                <!-- <li>
                    <%--<a href="#"><m:message message="def.side.menu.my.tasks"/></a>--%>
                </li> -->
            </ul>
            <ul class="nav nav-sidebar">
                <li class='<c:if test="${usersMain || userInfo || userCreate || userUpdate}">active</c:if>'>
                    <a href="/tracker/user/main"><spring:message code="def.side.menu.users"/></a>
                </li>
            </ul>
        </div>

        <!-- MAIN CONTENT -->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <c:if test="${tasksMain}">
                <jsp:include page="../model/main.jsp"/>
            </c:if>
            <c:if test="${taskCreate}">
                <jsp:include page="../model/create.jsp"/>
            </c:if>
            <c:if test="${taskUpdate}">
                <jsp:include page="../model/update.jsp"/>
            </c:if>
            <c:if test="${usersMain}">
                <jsp:include page="../user/main.jsp"/>
            </c:if>
            <c:if test="${userCreate}">
                <jsp:include page="../user/create.jsp"/>
            </c:if>
            <c:if test="${userUpdate}">
                <jsp:include page="../user/update.jsp"/>
            </c:if>
        </div>
    </div>
</div>
</body>
