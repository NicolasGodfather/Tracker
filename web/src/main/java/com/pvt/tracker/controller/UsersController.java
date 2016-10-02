package com.pvt.tracker.controller;

import com.pvt.tracker.beans.enums.UserType;
import com.pvt.tracker.services.IUserService;
import org.springframework.stereotype.Controller;

/**
 * Realization controller for work with users.
 *
 * @author Nicolas Asinovich.
 */
@Controller
public class UsersController extends MainController {

	private IUserService iUserService;
	private UserType[] userType;
		
	/**
	 * Метод для получения начальной страницы со списком всех пользователей.
	 */
//	public void index() {
//		param("usersView", true);
//		param("usersTree", getUsersTree());
//		forward(pagesLocation + "layout/" + getDefaultLayout());
//	}
	
	/**
	 * Метод для получения информации по запрошенному пользователю (по id).
	 */
//	public void info() {
//		User user = iUserService.getById(userType,super.getId());
//		param("userInfo", true);
//		param("user", user);
//		param("usersTree", getUsersTree());
//		param("usersView", true);
//		forward(pagesLocation + "layout/" + getDefaultLayout());
//	}
////
////	/**
////	 * Метод для получения страницы с формой для создания пользователя.
////	 */
////	public void create() {
////		param("userCreate", true);
////		param("userTypeList", userType.clone());
////		param("usersList", iUserService.getAll());
////		forward(super.pagesLocation + "layout/" + getDefaultLayout());
////	}
//
//	/**
//	 * Метод, обрабатывающий форму, пришедшей на сервер, для создания пользователя.
//	 */
//	public void doCreate() {
//		User user = new User();
//		user.setLogin(param("login"));
//		user.setPassword(param("password"));
//		user.setName(param("name"));
//		user.setSurname(param("surame"));
//		user.setEmail(param("email"));
//		user.setSkype(param("skype"));
//		String[] types = paramArray("types");
//		user.setId(iUserService.create(user));
//		for (String type : types) {
//			UserType[] userType = UserType.values();
//			user.setId(Integer.parseInt(type));
//			iUserService.assignType(user, userType);
//		}
//		redirect("/users/info/" + user.getId());
//	}
//
//	/**
//	 * Метод для получения страницы с формой для редактирования пользователя.
//	 */
//	public void update() {
//		User user = iUserService.getById(super.getId());
//		user.setUserType(UserType.list().get(0));
//		param("userUpdate", true);
//		param("userTypeList", UserType.list());
//		param("user", user);
//		forward(pagesLocation + "layout/" + getDefaultLayout());
//	}
//
//	/**
//	 * Метод, обрабатывающий форму, пришедшей на сервер, для редактирования пользователя.
//	 */
//	public void doUpdate() {
//		User user = iUserService.getById(Integer.parseInt(param("id")));
//		user.setLogin(param("login"));
//		user.setPassword(param("password"));
//		user.setName(param("name"));
//		user.setSurname(param("surame"));
//		user.setEmail(param("email"));
//		user.setSkype(param("skype"));
//		String[] types = paramArray("types");
//		iUserService.deleteById(user.getId());
//		for (String type : types) {
//			UserType[] userType = UserType.values();
//			user.setId(Integer.parseInt(type));
//			iUserService.assignType(user, userType);
//		}
//		iUserService.update(user);
//		redirect("/users/info/" + user.getId());
//	}
//
//	/**
//	 * Метод для удаления пользователя (по id).
//	 */
//	public void delete() {
//		User user = new User();
//		user.setId(getId());
//		iUserService.deleteById(user.getId());
//		param("usersTree", getUsersTree());
//		param("usersView", true);
//		redirect("/users");
//	}
//
//	private Map<UserType, List<User>> getUsersTree() {
//		Map<UserType, List<User>> usersTree = new HashMap<>();
//		List<UserType> userTypes = UserType.list();
//		for (UserType r : userTypes) {
//			usersTree.put(r, iUserService.findUsersByType(r));
//		}
//		return usersTree;
//	}
}
