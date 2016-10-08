package com.pvt.tracker.controller;

import com.pvt.tracker.services.IModelService;
import com.pvt.tracker.services.IUserService;
import com.pvt.tracker.services.IWorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// * Контроллер для работы с моделями.
@Controller
@RequestMapping ("/model")
public class ModelController extends MainController {

	@Autowired (required = true)
	private IUserService userService;
	@Autowired (required = true)
	private IModelService modelService;
	@Autowired (required = true)
	private IWorkflowService workflowService;

//	 * Метод для получения начальной страницы со списком всех задач.
//	public void index() {
//		param("tasksView", true);
//		param("tasksTree", getTasksTree(modelService.getAll()));
//		forward(pagesLocation + "layout/" + getDefaultLayout());
//	}
	
//	 * Метод для получения информации по запрошенной пользователем задаче (по id).
//	public void info() {
//		Model task = modelService.getById();
////		task.setComments(tasksDao.getTaskComments(task));
//		param("tasksView", true);
//		param("taskInfo", true);
//		param("task", task);
//		param("tasksTree", getTasksTree(IModelDao.getAll()));
//		forward(pagesLocation + "layout/" + getDefaultLayout());
//	}
	
//	 * Метод для получения страницы с формой создания задачи.

//	public void create() {
//		Model beans = IModelDao.getById(Integer.parseInt(param("id")));
//		beans.getWorkflow().setStatusTypes(workflowService.getStatuses(beans.getWorkflow()));
//		if (beans.getId() == 1) {
//			Model parent = new Model();
//			parent.setId(0);
//			param("ModelType.TASK", ModelType.TASK);
//			param("taskCreate", true);
//			param("task", parent);
//			param("usersList", usersDao.getAll());
//			forward(pagesLocation + "layout/" + getDefaultLayout());
//		} *//*else if (beans.getId() == 2 || category.getId() == 3) {
//			Task parent = tasksDao.findTaskById(Integer.parseInt(param("parentId")));
//			if (parent.getCategory().getId() != 1) {
//				param("tasksView", true);
//				param("taskInfo", true);
//				param("tasksTree", getTasksTree(tasksDao.getAllTasks()));
//				param("task", parent);
//				param("error", ((MessagesBundle) session("messages")).message("error.create.task.wrong.parent"));
//				forward(pagesLocation + "layout/" + getDefaultLayout());
//			} else {
//				param("task", parent);
//				param("category", category);
//				param("taskCreate", true);
//				param("usersList", usersDao.getAllUsers());
//				forward(pagesLocation + "layout/" + getDefaultLayout());
//			}
//		}
//	}
//
////	 * Метод, обрабатывающий форму, пришедшей на сервер, для создания задачи.
//
//	public void doCreate() {
//		Task task = new Task();
//		User user = (User) session("logged_user");
//		task.setTitle(param("title"));
//		task.setDescription(param("description"));
//		task.setAssigneeId(Integer.parseInt(param("assigneeId")));
//		task.setCreatorId(user.getId());
//		task.setParentId(Integer.parseInt(param("parentId")));
//		task.setStatusId(Integer.parseInt(param("statusId")));
//		task.setCategoryId(Integer.parseInt(param("categoryId")));
//		task.setWorkflowId(Integer.parseInt(param("workflowId")));
//		task.setDeadline(new Timestamp(getDateFromString(param("deadline")).getTime()));
//		task.setId(tasksDao.createTask(task));
//
//		new Thread(new Mailer(user.getEmail(), "Updated [" + task.getId() + "] - " + task.getTitle(), task.getDescription())).start();
//		new Thread(new Mailer(usersDao.findUserById(task.getAssigneeId()).getEmail(), "Updated [" + task.getId() + "] - " + task.getTitle(), task.getDescription())).start();
//
//		redirect("/tasks/info/" + task.getId());
//	}
//
///// Метод для получения страницы с формой редактирования существующей задачи.
//
//
//
//	public void update() {
//		Task task = tasksDao.findTaskById(getId());
//		Workflow w = categoriesDao.getWorkflow(task.getCategory());
//		w.setStatuses(workflowsDao.getStatuses(w));
//		task.getCategory().setWorkflow(w);
//		param("taskUpdate", true);
//		param("task", task);
//		param("usersList", usersDao.getAllUsers());
//		forward(pagesLocation + "layout/" + getDefaultLayout());
//	}
//
//// * Метод, обрабатывающий форму, пришедшей на сервер, для редактирования задачи.
//
//
//	public void doUpdate() {
//		User user = (User) session("logged_user");
//		Task task = tasksDao.findTaskById(Integer.parseInt(param("id")));
//		task.setTitle(param("title"));
//		task.setDescription(param("description"));
//		task.setStatusId(Integer.parseInt(param("statusId")));
//		task.setDeadline(new Timestamp(getDateFromString(param("deadline")).getTime()));
//		task.setAssigneeId(Integer.parseInt(param("assigneeId")));
//		task.setProgress(Integer.parseInt(param("progress")));
//		tasksDao.updateTask(task);
//
//		Comment comment = new Comment();
//		comment.setComment(param("comment"));
//		comment.setTaskId(task.getId());
//		comment.setUserId(user.getId());
//		commentsDao.createComment(comment);
//
//		new Thread(new Mailer(user.getEmail(), "Updated [" + task.getId() + "] - " + task.getTitle(), task.getDescription())).start();
//		new Thread(new Mailer(usersDao.findUserById(task.getAssigneeId()).getEmail(), "Updated [" + task.getId() + "] - " + task.getTitle(), task.getDescription())).start();
//
//		redirect("/tasks/info/" + task.getId());
//	}
//
////	 * Метод для удаления задачи (по id).
//
//	public void delete() {
//		Task task = new Task();
//		task.setId(getId());
//		tasksDao.deleteTask(task);
//		param("tasksTree", getTasksTree(tasksDao.getAllTasks()));
//		param("tasksView", true);
//		forward(pagesLocation + "layout/" + getDefaultLayout());
//	}
//
//	private Map<Model, List<Model>> getTasksTree(List<Model> tasks) {
//		Map<Model, List<Model>> tree = new HashMap<>();
//		for(Model task : tasks) {
////			if (task..getParentId() == 0) {
//				List<ModelType> subTasks = new ArrayList<>();
////				for (ModelType.values() subTask : tasks) {
////					if (subTask.getParentId() == task.getId()) {
////						subTasks.add(subTask);
////					}
////				}
//				tree.put(task, subTasks);
////			}
//		}
//		return tree;
//	}

	private Date getDateFromString(String dateStr) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = formatter.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
