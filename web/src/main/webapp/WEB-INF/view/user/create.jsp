<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="page-header">
	<h3><spring:message code="user.create.page.header"/></h3>
</div>

<form:form role="form" class="form-horizontal" action="/createUser" method="POST" commandName="createUser">
	<form:input class="form-control" id="id" path="id" value="${createUser.id}" type="hidden"/>
	<div class="form-group">
    	<label for="login" class="col-sm-2 control-label"><spring:message code="user.attr.login"/></label>
    	<div class="col-sm-4">
    		<input type="text" class="form-control" id="login" name="login" required="required">
    	</div>
  	</div>
  	<div class="form-group">
    	<label for="password" class="col-sm-2 control-label"><spring:message code="user.attr.password"/></label>
    	<div class="col-sm-4">
    		<input type="password" class="form-control" id="password" name="password" required="required">
    	</div>
  	</div>
  	<div class="form-group">
    	<label for="name" class="col-sm-2 control-label"><spring:message code="user.attr.name"/></label>
    	<div class="col-sm-4">
    		<input type="text" class="form-control" id="name" name="name" required="required">
    	</div>
  	</div>
  	<div class="form-group">
    	<label for="surname" class="col-sm-2 control-label"><spring:message code="user.attr.surname"/></label>
    	<div class="col-sm-4">
    		<input type="text" class="form-control" id="surname" name="surname" required="required">
    	</div>
  	</div>
  	<div class="form-group">
    	<label for="email" class="col-sm-2 control-label"><spring:message code="user.attr.email"/></label>
    	<div class="col-sm-4">
    		<input type="email" class="form-control" id="email" name="email">
    	</div>
  	</div>

  	<div class="form-group">
    	<label for="type" class="col-sm-2 control-label"><spring:message code="user.attr.role"/></label>
    	<div class="col-sm-4">
    		<c:forEach items="${typesList}" var="type">
				<div class="checkbox">
					<label><input type="checkbox" name="type" value="${type.type}">${type.name}</label>
				</div>
			</c:forEach>
    	</div>
  	</div>
  	<div class="form-group">
  		<div class="col-sm-4 col-sm-offset-2">
    		<button type="submit" class="btn btn-primary"><spring:message code="user.create.page.formbtn"/></button>
    	</div>
    </div>
</form:form>