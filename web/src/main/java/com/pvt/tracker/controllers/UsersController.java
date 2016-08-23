package com.pvt.tracker.controllers;

import com.pvt.tracker.dao.UserDao;
import com.pvt.tracker.dao.impl.UserDaoImpl;
import com.pvt.tracker.model.User;
import com.pvt.tracker.model.enums.UserType;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Realization controller for work with users.
 *
 * @author Nicolas Asinovich.
 */
@Controller
public class UsersController extends MainController {

	private UserDao usersDao;
	private UserType userType;
		
	public UsersController() {
		usersDao = UserDaoImpl.getUserDao();
		userType = UserType.getUserType(); // Singletone instance
	}
	
	/**
	 * Метод для получения начальной страницы со списком всех пользователей.
	 */
	public void index() {
		param("usersView", true);
		param("usersTree", getUsersTree());
		forward(pagesLocation + "layout/" + getDefaultLayout());
	}
	
	/**
	 * Метод для получения информации по запрошенному пользователю (по id).
	 */
	public void info() {
		User user = usersDao.getById(super.getId());
		param("userInfo", true);
		param("user", user);
		param("usersTree", getUsersTree());
		param("usersView", true);
		forward(pagesLocation + "layout/" + getDefaultLayout());
	}
	
	/**
	 * Метод для получения страницы с формой для создания пользователя.
	 */
	public void create() {
		param("userCreate", true);
		param("userTypeList", userType.list());
		param("usersList", usersDao.getAll());
		forward(super.pagesLocation + "layout/" + getDefaultLayout());
	}
	
	/**
	 * Метод, обрабатывающий форму, пришедшей на сервер, для создания пользователя.
	 */
	public void doCreate() {
		User user = new User();
		user.setLogin(param("login"));
		user.setPassword(param("password"));
		user.setName(param("name"));
		user.setSurname(param("surame"));
		user.setEmail(param("email"));
		user.setSkype(param("skype"));
		String[] types = paramArray("types");
		user.setId(usersDao.create(user));
		for (String type : types) {
			UserType userType = UserType.getUserType();
			user.setId(Integer.parseInt(type));
			usersDao.assignType(user, userType);
		}
		redirect("/users/info/" + user.getId());
	}
	
	/**
	 * Метод для получения страницы с формой для редактирования пользователя.
	 */
	public void update() {
		User user = usersDao.getById(super.getId());
		user.setUserType(UserType.getUserType());
		param("userUpdate", true);
		param("userTypeList", UserType.list());
		param("user", user);
		forward(pagesLocation + "layout/" + getDefaultLayout());
	}
	
	/**
	 * Метод, обрабатывающий форму, пришедшей на сервер, для редактирования пользователя.
	 */
	public void doUpdate() {
		User user = usersDao.getById(Integer.parseInt(param("id")));
		user.setLogin(param("login"));
		user.setPassword(param("password"));
		user.setName(param("name"));
		user.setSurname(param("surame"));
		user.setEmail(param("email"));
		user.setSkype(param("skype"));
		String[] types = paramArray("types");
		usersDao.deleteById(user.getId());
		for (String type : types) {
			UserType userType = UserType.getUserType();
			user.setId(Integer.parseInt(type));
			usersDao.assignType(user, userType);
		}
		usersDao.update(user);
		redirect("/users/info/" + user.getId());
	}
	
	/**
	 * Метод для удаления пользователя (по id).
	 */
	public void delete() {
		User user = new User();
		user.setId(getId());
		usersDao.deleteById(user.getId());
		param("usersTree", getUsersTree());
		param("usersView", true);
		redirect("/users");
	}
	
	private Map<UserType, List<User>> getUsersTree() {
		Map<UserType, List<User>> usersTree = new HashMap<>();
		List<UserType> userTypes = UserType.list();
		for (UserType r : userTypes) {
			usersTree.put(r, usersDao.findUsersByType(r));
		}
		return usersTree;
	}
}
