<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/datepicker3.css" type="text/css">
<script type="text/javascript" src="../../../resources/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="../../../resources/js/bootstrap-datepicker.ru.js"></script>
<script type="text/javascript">
	$(function() {
		$('#deadline').datepicker({
			format: 'yyyy-mm-dd',
			language: '${curr_lang}'
		});
	});
</script>

<div class="page-header">
	<h3><spring:message code="task.create"/> ${category.name}</h3>
</div>

<form role="form" class="form-horizontal" action="/tasks/doCreate" method="POST" accept-charset="utf-8">
	<input type="hidden" name="parentId" value="${task.id}">
	<input type="hidden" name="workflowId" value="${category.workflow.id}">
	<input type="hidden" name="categoryId" value="${category.id}">
	
	<div class="form-group">
    	<label for="title" class="col-sm-2 control-label"><spring:message code="task.page.title"/></label>
    	<div class="col-sm-4">
    		<input type="text" class="form-control" id="title" name="title" required="required">
    	</div>
  	</div>
  	<div class="form-group">
    	<label for="deadline" class="col-sm-2 control-label"><spring:message code="task.page.deadline"/></label>
    	<div class="col-sm-4">
    		<input type="date" class="form-control" id="deadline" name="deadline" required="required">
    	</div>
  	</div>
  	<div class="form-group">
    	<label for="statusId" class="col-sm-2 control-label"><spring:message code="task.page.statusType"/></label>
    	<div class="col-sm-4">
    		<select class="form-control" id="statusId" name="statusId">
  				<c:forEach items="${category.workflow.statuses}" var="statusType">
  					<option value="${statusType.id}">${statusType.name}</option>
  				</c:forEach>
			</select>
    	</div>
  	</div>
  	<div class="form-group">
    	<%--<label for="creatorId" class="col-sm-2 control-label"><spring:message code="task.page.creator"/></label>--%>
    	<label class="col-sm-2 control-label"><spring:message code="task.page.creator"/></label>
    	<div class="col-sm-4">
    		<input class="form-control" value="${logged_user.firstName} ${logged_user.lastName}" readonly="readonly">
    	</div>
  	</div>
  	<div class="form-group">
    	<label for="assigneeId" class="col-sm-2 control-label"><spring:message code="task.page.assignee"/></label>
    	<div class="col-sm-4">
    		<select class="form-control" id="assigneeId" name="assigneeId">
  				<c:forEach items="${usersList}" var="user">
  					<option value="${user.id}">${user.firstName} ${user.lastName}</option>
  				</c:forEach>
			</select>
    	</div>
  	</div>
  	<div class="form-group">
    	<label for="description" class="col-sm-2 control-label"><spring:message code="task.page.description"/></label>
    	<div class="col-sm-4">
    		<textarea class="form-control" id="description" name="description" required="required"></textarea>
    	</div>
  	</div>
  	<div class="form-group">
  		<div class="col-sm-4 col-sm-offset-2">
    		<button type="submit" class="btn btn-primary"><spring:message code="task.create.def.btn"/></button>
    	</div>
    </div>
</form>