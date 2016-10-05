package com.pvt.tracker.controller;

import com.pvt.tracker.beans.User;
import com.pvt.tracker.beans.enums.UserType;
import com.pvt.tracker.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Realization controller for work with users.
 *
 * @author Nicolas Asinovich.
 */
@Controller
public class UsersController extends MainController {
	@Autowired
	private IUserService iUserService;
	private UserType[] userType;
	private static List<User> users = new ArrayList();


	/**
	 * Метод для получения начальной страницы со списком всех пользователей.
	 */
	@RequestMapping (value = "/main", method = RequestMethod.GET)
	public String mainPage(ModelMap model) {
		model.put("users", users);
		User user = new User();
		if (users.size() > 1)
			user = users.get(0);
		else {
			user = new User();
			user.setId(1);
			user.setName("New name");
		}
		model.put("user", user);
		return "user/main";
	}

	/**
	 * Метод для получения информации по запрошенному пользователю (по id).
	 */
	//@PreAuthorize("APP_ROLE")
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String userInfo() {
//		User user = iUserService.getById();

		return "user/info";
	}

	/**
	 * Метод для получения страницы с формой для создания пользователя.
	 */
	@RequestMapping(value = "/add-user", method = {RequestMethod.GET, RequestMethod.POST})
	public String createUser(ModelMap model, @ModelAttribute User user) {
		users.add(user);
		model.put("users", users);
		model.put("user", user);
		return "user/main";
	}

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
	/**
	 * Метод для получения страницы с формой для редактирования пользователя.
	 */
	public String updateUser(){
		return null;
	}
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
