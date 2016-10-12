<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="page-header">
	<h3><spring:message code="user.update.page.header"/> <label class="label label-primary">${user.name} ${user.surname}</label></h3>
</div>

<form role="form" class="form-horizontal" action="/users/doUpdate" method="POST">
	<input type="hidden" name="id" value="${user.id}">
	<div class="form-group">
    	<label for="login" class="col-sm-2 control-label"><spring:message code="user.attr.login"/></label>
    	<div class="col-sm-4">
    		<input type="text" class="form-control" id="login" name="login" value="${user.login}" required="required">
    	</div>
  	</div>
  	<div class="form-group">
    	<label for="password" class="col-sm-2 control-label"><spring:message code="user.attr.password"/></label>
    	<div class="col-sm-4">
    		<input type="password" class="form-control" id="password" name="password" value="${user.password}" required="required">
    	</div>
  	</div>
  	<div class="form-group">
    	<label for="firstName" class="col-sm-2 control-label"><spring:message code="user.attr.name"/></label>
    	<div class="col-sm-4">
    		<input type="text" class="form-control" id="firstName" name="firstName" value="${user.name}" required="required">
    	</div>
  	</div>
  	<div class="form-group">
    	<label for="lastName" class="col-sm-2 control-label"><spring:message code="user.attr.surname"/></label>
    	<div class="col-sm-4">
    		<input type="text" class="form-control" id="lastName" name="lastName" value="${user.surname}" required="required">
    	</div>
  	</div>
  	<div class="form-group">
    	<label for="email" class="col-sm-2 control-label"><spring:message code="user.attr.email"/></label>
    	<div class="col-sm-4">
    		<input type="email" class="form-control" id="email" name="email" value="${user.email}">
    	</div>
  	</div>
  	<%--<div class="form-group">--%>
    	<%--<label for="phoneNumber" class="col-sm-2 control-label"><spring:message code="user.attr.phone"/></label>--%>
    	<%--<div class="col-sm-4">--%>
    		<%--<input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="${user.phoneNumber}">--%>
    	<%--</div>--%>
  	<%--</div>--%>
  	<div class="form-group">
    	<label for="role" class="col-sm-2 control-label"><spring:message code="user.attr.role"/></label>
    	<div class="col-sm-4">
    		<c:forEach items="${rolesList}" var="role">
    			<div class="checkbox">
					<label><input type="checkbox" name="role" value="${role.id}" <c:if test="${user.roles.contains(role)}">checked="checked"</c:if>>
						${role.name}
					</label>
				</div>
			</c:forEach>
    	</div>
  	</div>
  	<div class="form-group">
  		<div class="col-sm-4 col-sm-offset-2">
    		<button type="submit" class="btn btn-primary"><spring:message code="user.update.page.formbtn"/></button>
    	</div>
    </div>
</form>