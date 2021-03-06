<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link rel="stylesheet" href="../../../resources/css/bootstrap-combined.min.css" type="text/css">
<script type="text/javascript" src="../../../resources/js/bootstrap-tree.js"></script>

<div class="page-header">
	<h3><spring:message code="task.index.header"/>
		<div class="pull-right">
			<p:permission rule="create_project">
				<a href="tasks/create?categoryId=1" type="button" role="button" class="btn btn-default">
					<img src="../../../resources/images/project.png"/> <spring:message code="task.create.project.btn"/>
				</a>
			</p:permission>
			<c:if test="${taskInfo}">
				<p:permission rule="create_task">
					<a href="tasks/create?categoryId=2&parentId=${task.id}" type="button" role="button" class="btn btn-default">
  						<img src="../../../resources/images/task.png"/> <spring:message code="task.create.task.btn"/>
  					</a>
				</p:permission>
  				<p:permission rule="create_bug">
  					<a href="tasks/create?categoryId=3&parentId=${task.id}" type="button" role="button" class="btn btn-default">
  						<img src="../../../resources/images/bug.png"/> <spring:message code="task.create.bug.btn"/>
  					</a>
  				</p:permission>
  				<p:permission rule="delete_task">
  					<a href="/tasks/delete/${task.id}" type="button" role="button" class="btn btn-default">
  						<img src="../../../resources/images/delete.png"/> <spring:message code="task.delete.def.btn"/>
  					</a>
  				</p:permission>
  				<p:permission rule="update_task">
  					<a href="/tasks/update/${task.id}" type="button" role="button" class="btn btn-default">
  						<img src="../../../resources/images/update.png"/> <spring:message code="task.update.def.btn"/>
  					</a>
  				</p:permission>
  			</c:if>  			
  		</div>
	</h3>	
</div>

<div class="row-fluid">
	<c:if test="${not empty error}">
		<div class="alert alert-danger" role="alert">${error}</div>
	</c:if>
	<section role="main" class="col-md-4">
		<div class="tree">
			<ul>
				<li>
					<span><i class="icon-folder-open"></i>Projects</span>
					<c:forEach items="${tasksTree}" var="tree">
						<ul>
							<li>
								<span><img src="../../../resources/images/circle.png"/></span> <a href="/tasks/info/${tree.key.id}"><label class="label label-primary"> ${tree.key.title}</label></a>
								<ul>
									<c:forEach items="${tree.value}" var="subTask">
										<li>
											<span><i class="icon-time"></i>#${subTask.id}</span> &ndash; 
											<c:choose>
												<c:when test="${subTask.category.id == 2}">
													<label class="label label-success">${subTask.category.name}</label>
												</c:when>
												<c:otherwise>
													<label class="label label-danger">${subTask.category.name}</label>
												</c:otherwise>
											</c:choose> &ndash; <a href="/tasks/info/${subTask.id}"><label class="label label-warning">${subTask.title}</label></a>
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
		<c:when test="${taskInfo}">
			<section class="col-md-8">
				<jsp:include page="task.jsp"/>
			</section>
		</c:when>
		<c:otherwise>
			<section class="col-md-8">
				<div class="jumbotron">
  					<h1><spring:message code="no.tasks.chosen"/></h1>
  					<h2><small><spring:message code="choose.task.from.list"/></small></h2>
				</div>
			</section>
		</c:otherwise>
	</c:choose>
</div>