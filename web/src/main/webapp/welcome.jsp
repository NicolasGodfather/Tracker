<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>

<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Welcome to Tracker</title>--%>
	<%--<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css" type="text/css" media="all" >--%>
<%--</head>--%>
<%--<body>--%>
    <%--<div class="container">--%>
		<%--<div class="row">--%>
			<%--<div class="col-xs-6 col-sm-6 col-md-6 col-xs-offset-2 col-sm-offset-2 col-md-offset-2">--%>
				<%--<div class="page-header">--%>
  					<%--<h1>--%>
						<%--<spring:message code="title"/>--%>
						<%--<div style="float: right;">--%>
							<%--<a href="?locale=ru" style="padding:5px">RU</a> | <a href="?locale=en" style="padding:5px">EN</a>--%>
						<%--</div>--%>
  					<%--</h1>--%>
        		<%--</div>--%>
				<%--&lt;%&ndash;<form action="/j_spring_security_check" method="POST" autocomplete="off">&ndash;%&gt;--%>
					<%--&lt;%&ndash;<input placeholder='Username' name="j_username" type='text'>&ndash;%&gt;--%>
					<%--&lt;%&ndash;<input placeholder='Password' name="j_password" type='password'>&ndash;%&gt;--%>
					<%--&lt;%&ndash;<button type="submit">Login</button>&ndash;%&gt;--%>
				<%--&lt;%&ndash;</form>&ndash;%&gt;--%>

				<%--<c:url var="signInUrl" value="/login" />--%>
				<%--<form class="form-horizontal" role="form" action="${signInUrl}" method="POST">--%>
        			<%--<h3 class="form-signin-heading"><spring:message code="auth.header"/></h3>--%>

        			<%--&lt;%&ndash;<c:if test="${not empty bad_auth}">&ndash;%&gt;--%>
        				<%--&lt;%&ndash;<div class="alert alert-danger" role="alert">&ndash;%&gt;--%>
        					<%--&lt;%&ndash;<spring:message code="bad.auth"/>&ndash;%&gt;--%>
        				<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        			<%--&lt;%&ndash;</c:if>&ndash;%&gt;--%>

        			<%--<div class="form-group">--%>
        				<%--<label class="col-xs-2 col-sm-2 col-md-2 control-label" for="login"><spring:message code="login"/></label>--%>
        				<%--<div class="col-xs-6 col-sm-6 col-md-6">--%>
        					<%--<input type="text" class="form-control" id="login" name="j_username" placeholder="Login" required autofocus>--%>
        				<%--</div>--%>
        			<%--</div>--%>
        			<%--<div class="form-group">--%>
        				<%--<label class="col-xs-2 col-sm-2 col-md-2 control-label"><spring:message code="password"/></label>--%>
        				<%--<div class="col-xs-6 col-sm-6 col-md-6">--%>
        					<%--<input type="password" class="form-control" id="password" name="j_password" placeholder="Password" required>--%>
        				<%--</div>--%>
        			<%--</div>--%>
        			<%--<div class="form-group">--%>
        				<%--<div class="col-xs-6 col-sm-6 col-md-6">--%>
        	    			<%--<button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="auth.submit"/></button>--%>
        	    		<%--</div>--%>
        	    	<%--</div>--%>

					<%--&lt;%&ndash;<div class="login-link-container">&ndash;%&gt;--%>
						<%--&lt;%&ndash;<sec:authorize access="isAnonymous()">&ndash;%&gt;--%>
							<%--&lt;%&ndash;<p>&ndash;%&gt;--%>
								<%--&lt;%&ndash;<input type="button" value="Sign In" onClick='location.href="/login"'>&ndash;%&gt;--%>
							<%--&lt;%&ndash;</p>&ndash;%&gt;--%>
						<%--&lt;%&ndash;</sec:authorize>&ndash;%&gt;--%>
						<%--&lt;%&ndash;<sec:authorize access="isAuthenticated()">&ndash;%&gt;--%>
							<%--&lt;%&ndash;<c:url var="logoutUrl" value="/j_spring_security_logout"/>&ndash;%&gt;--%>
							<%--&lt;%&ndash;<form action="${logoutUrl}" method="post">&ndash;%&gt;--%>
								<%--&lt;%&ndash;<input type="submit" value="Log out" />&ndash;%&gt;--%>
								<%--&lt;%&ndash;<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>&ndash;%&gt;--%>
							<%--&lt;%&ndash;</form>&ndash;%&gt;--%>
						<%--&lt;%&ndash;</sec:authorize>&ndash;%&gt;--%>
					<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
      			<%--</form>--%>

      		<%--</div>--%>
		<%--</div>--%>
    <%--</div>--%>
  <%--</body>--%>
<%--</html>--%>
