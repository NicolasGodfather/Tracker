<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link rel="stylesheet" href="../../../resources/css/datepicker3.css" type="text/css">
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
	<h3><spring:message code="task.update"/> <label class="label label-primary">${task.category.name} #${task.id} - ${task.title}</label></h3>
</div>

<form role="form" class="form-horizontal" action="../../../tasks/doUpdate" method="POST" accept-charset="utf-8">
	<input type="hidden" name="id" value="${task.id}">
	
	<div class="form-group">
    	<label for="title" class="col-sm-2 control-label"><spring:message code="task.page.title"/></label>
    	<div class="col-sm-4">
    		<input type="text" class="form-control" id="title" name="title" required="required" value="${task.title}">
    	</div>
  	</div>
  	<div class="form-group">
    	<label for="deadline" class="col-sm-2 control-label"><spring:message code="task.page.deadline"/></label>
    	<div class="col-sm-4">
    		<input type="date" class="form-control" id="deadline" name="deadline" required="required" value="${task.deadline}">
    	</div>
  	</div>
  	<div class="form-group">
    	<label for="statusId" class="col-sm-2 control-label"><spring:message code="task.page.statusType"/></label>
    	<div class="col-sm-4">
    		<select class="form-control" id="statusId" name="statusId">
  				<c:forEach items="${task.category.workflow.statuses}" var="statusType">
  					<option value="${statusType.id}" <c:if test="${task.statusId == statusType.id}">selected="selected"</c:if>>
  						${statusType.name}
  					</option>
  				</c:forEach>
			</select>
    	</div>
  	</div>
  	<div class="form-group">
    	<label for="creatorId" class="col-sm-2 control-label"><spring:message code="task.page.creator"/></label>
    	<div class="col-sm-4">
    		<input class="form-control" value="${task.creator.firstName} ${task.creator.lastName}" readonly="readonly">
    	</div>
  	</div>
  	<div class="form-group">
    	<label for="assigneeId" class="col-sm-2 control-label"><spring:message code="task.page.assignee"/></label>
    	<div class="col-sm-4">
    		<select class="form-control" id="assigneeId" name="assigneeId">
  				<c:forEach items="${usersList}" var="user">
  					<option value="${user.id}" <c:if test="${task.assigneeId == user.id}">selected="selected"</c:if>>
  						${user.firstName} ${user.lastName}
  					</option>
  				</c:forEach>
			</select>
    	</div>
  	</div>
  	<div class="form-group">
    	<label for="progress" class="col-sm-2 control-label"><spring:message code="task.page.progress"/></label>
    	<div class="col-sm-4">
    		<input class="form-control" id="progress" name="progress" value="${task.progress}">
    	</div>
  	</div>
  	<div class="form-group">
    	<label for="description" class="col-sm-2 control-label"><spring:message code="task.page.description"/></label>
    	<div class="col-sm-4">
    		<textarea class="form-control" id="description" name="description" required="required">${task.description}</textarea>
    	</div>
  	</div>
  	<div class="form-group">
    	<label for="comment" class="col-sm-2 control-label"><spring:message code="task.page.comment"/></label>
    	<div class="col-sm-4">
    		<textarea class="form-control" id="comment" name="comment" required="required"></textarea>
    	</div>
  	</div>
  	<div class="form-group">
  		<div class="col-sm-4 col-sm-offset-2">
    		<button type="submit" class="btn btn-primary"><spring:message code="task.update.def.btn"/></button>
    	</div>
    </div>
</form>