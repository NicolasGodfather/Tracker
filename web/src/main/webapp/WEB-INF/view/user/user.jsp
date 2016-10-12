<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="panel panel-info">
  <div class="panel-heading">
    <h3 class="panel-title">
    	<label class="label label-primary"><spring:message code="user.page.header"/> - ${user.name} ${user.surname}</label>
    </h3>
  </div>
  <div class="panel-body">
  	<div class="col-md-6">
    <table class="table table-hover">
    	<tbody>
    		<tr>
    			<th><spring:message code="user.attr.login"/></th>
    			<td>${user.login}</td>
    		</tr>
    		<tr>
    			<th><spring:message code="user.attr.name"/></th>
    			<td>${user.name}</td>
    		</tr>
    		<tr>
    			<th><spring:message code="user.attr.surname"/></th>
    			<td>${user.surname}</td>
    		</tr>
    		<tr>
    			<th><spring:message code="user.attr.email"/></th>
    			<td>${user.email}</td>
    		</tr>
    	</tbody>
    </table>
    </div>
    <div class="col-md-6">
    	<table class="table table-hover">
    		<tbody>
    			<tr>
    				<th><spring:message code="user.attr.created"/></th>
    				<td>${user.createdTime}</td>
    			</tr>
    			<tr>
    				<th><spring:message code="user.attr.updated"/></th>
    				<td>${user.updatedTime}</td>
    			</tr>
    		</tbody>
    	</table>
    </div>
  </div>
</div>