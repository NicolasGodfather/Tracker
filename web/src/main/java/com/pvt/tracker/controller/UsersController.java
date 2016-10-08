package com.pvt.tracker.controller;

import com.pvt.tracker.beans.User;
import com.pvt.tracker.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Realization controller for work with users.
 *
 * @author Nicolas Asinovich.
 */
@Controller
@RequestMapping("/user")
public class UsersController extends MainController {

	@Autowired
	private IUserService iUserService;
//	private UserType[] userType;

	/**
	 * Page with all users.
	 */
	@RequestMapping (value = "/users", method = RequestMethod.GET)
	public String mainPage(ModelMap model) {
		fillModel(model);
		return "users/main";
	}


	//@PreAuthorize("APP_ROLE")
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String userInfo() {
		return "users/info";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String addUser(ModelMap model, User user) {
		if (user.getId() == 0) {
			this.iUserService.create(user);
		} else {
			this.iUserService.update(user);
		}
		model.put("users", iUserService.getAll());
		return "users/main";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/delete-user", method = RequestMethod.POST)
	public String deleteUser(ModelMap model, User user) {
		if (user != null) {
			iUserService.delete(user);
			model.put("message", "User: " + user.getName() + " was deleted");
		}
		fillModel(model);
		return "users/main";
	}

	@RequestMapping(value = "/update-user/{id}", method = RequestMethod.POST)
	public String updateUser (@PathVariable ("id") int id,ModelMap model, User user){
		model.addAttribute("user", this.iUserService.getById(id));
		model.addAttribute("mainPage", this.iUserService.getAll());
		return "users/main";
	}

	@SuppressWarnings("unchecked")
	private void fillModel(ModelMap model) {
		List<User> list = iUserService.getAll();
		model.put("users", list);
		User user = new User();
		if (list.size() > 1) {
			user = list.get(0);
		}
		model.put("user", user);
	}


//	private Map<UserType, List<User>> getUsersTree() {
//		Map<UserType, List<User>> usersTree = new HashMap<>();
//		List<UserType> userTypes = UserType.list();
//		for (UserType r : userTypes) {
//			usersTree.put(r, iUserService.findUsersByType(r));
//		}
//		return usersTree;
//	}
}
