package com.pvt.tracker.controller;

import com.pvt.tracker.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Realization controller for work with users.
 *
 * @author Nicolas Asinovich.
 */
@Controller
@SessionAttributes ("login")
@RequestMapping("/userPage")
public class UserController extends MainController {

	@Autowired
	private IUserService iUserService;
//	private UserType[] userType;

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

//	private Map<UserType, List<User>> getUsersTree() {
//		Map<UserType, List<User>> usersTree = new HashMap<>();
//		List<UserType> userTypes = UserType.list();
//		for (UserType r : userTypes) {
//			usersTree.put(r, iUserService.findUsersByType(r));
//		}
//		return usersTree;
//	}
}
