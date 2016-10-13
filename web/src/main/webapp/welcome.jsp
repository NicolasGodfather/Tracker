<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome to Tracker</title>
	<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css" type="text/css" media="all" >
</head>
<body>
    <div class="container">
		<div class="row">
			<div class="col-xs-6 col-sm-6 col-md-6 col-xs-offset-2 col-sm-offset-2 col-md-offset-2">
				<div class="page-header">
  					<h1>
						<spring:message code="title"/>
						<div style="float: right;">
							<a href="?locale=ru" style="padding:5px">RU</a> | <a href="?locale=en" style="padding:5px">EN</a>
						</div>
  					</h1>
        		</div>

				<c:url var="signInUrl" value="/signIn" />
				<form class="form-horizontal" role="form" action="${signInUrl}" modelAttribute="user" method="POST">
        			<h3 class="form-signin-heading"><spring:message code="auth.header"/></h3>

        			<%--<c:if test="${not empty bad_auth}">--%>
        				<%--<div class="alert alert-danger" role="alert">--%>
        					<%--<spring:message code="bad.auth"/>--%>
        				<%--</div>--%>
        			<%--</c:if>--%>

        			<div class="form-group">
        				<label class="col-xs-2 col-sm-2 col-md-2 control-label" for="login"><spring:message code="login"/></label>
        				<div class="col-xs-6 col-sm-6 col-md-6">
        					<input type="text" class="form-control" id="login" name="login" placeholder="Login" required autofocus>
        				</div>
        			</div>
        			<div class="form-group">
        				<label class="col-xs-2 col-sm-2 col-md-2 control-label"><spring:message code="password"/></label>
        				<div class="col-xs-6 col-sm-6 col-md-6">
        					<input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
        				</div>
        			</div>
        			<div class="form-group">
        				<div class="col-xs-6 col-sm-6 col-md-6">
        	    			<button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="auth.submit"/></button>
        	    		</div>
        	    	</div>
      			</form>
      		</div>
		</div>
    </div>
  </body>
</html>
