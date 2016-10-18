package com.pvt.tracker.controller;

import com.pvt.tracker.beans.User;
import com.pvt.tracker.beans.enums.UserType;
import com.pvt.tracker.services.IUserService;
import com.pvt.tracker.services.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Realization controller for work with users.
 * @author Nicolas Asinovich.
 */
@Controller
@SessionAttributes ("userLogin")
@RequestMapping("/user")
public class UserController{

	private static final String PAGE_MAIN = "users/main";
	private static final String PAGE_INFO = "users/info";
	private static final String PAGE_CREATE = "users/create";
	private static final String PAGE_ERROR = "error";

	@Autowired
	private IUserService userService;

	@RequestMapping (value = "/main", method = RequestMethod.GET)
	public String mainPage(ModelMap model) throws ServiceException {
		User user = new User();
		model.addAttribute("usersMain", true);
		model.addAttribute("userLogin", user);
		model.addAttribute("usersTree", getUsersTree());
		return PAGE_MAIN;
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String userInfo(@PathVariable(value = "id") Long id, ModelMap model) {
		model.addAttribute("userInfo", userService.getById(id));
		return PAGE_INFO;
	}

	/**
	 * Only ADMIN can create some users
	 * @return admin/main
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showPageCreateUser(ModelMap modelMap) throws ServiceException {
		modelMap.addAttribute("userCreate", true);
		modelMap.addAttribute("createUser", new User());
		modelMap.addAttribute("usersList", userService.getAll());
		modelMap.addAttribute("typesList", getTypes(new User()));
		return PAGE_CREATE;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
//	@Secured("ADMIN")
	public String createUser(ModelMap modelMap, @Valid @ModelAttribute ("createUser") User user,
							 BindingResult bindingResult) throws ServiceException {
		if (bindingResult.hasErrors()) {
			return PAGE_CREATE;
		}
		User newUser;
		newUser = userService.createUser(user.getLogin(), user.getPassword(), user.getName(), user.getSurname(), user.getEmail());
		this.userService.create(newUser);
		this.userService.assignType(newUser, getTypes(user));
		modelMap.addAttribute("createUser", newUser);
		return "redirect:/";
	}

	/**
	 * Only ADMIN can create some users
	 * @return admin/main
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@Secured("ADMIN")
	public String deleteUser(@PathVariable ("id") long id, ModelMap model,@ModelAttribute ("user") User user) {
		if (user != null) {
			userService.delete(user);
			model.put("message", "User: " + user.getName() + " was deleted");
		}
		fillModel(model);
		return "redirect:/user/main";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String updateUser (@PathVariable ("id") long id, ModelMap model, User user){
		model.addAttribute("userLogin", this.userService.getById(id));
		model.addAttribute("mainPage", this.userService.getAll());
		return "redirect:/user/main";
	}

	@SuppressWarnings("unchecked")
	private Map<UserType, List<User>> getUsersTree() throws ServiceException {
		Map<UserType, List<User>> usersTree = new HashMap<>();
		List<UserType> userTypes = UserType.list();
		for (UserType userType : userTypes) {
			usersTree.put(userType, userService.findUsersByType(userType));
		}
		return usersTree;
	}

	@SuppressWarnings("unchecked")
	private void fillModel(ModelMap model) {
		List<User> list = userService.getAll();
		model.put("users", list);
		User user = new User();
		if (list.size() > 1) {
			user = list.get(0);
		}
		model.put("user", user);
	}

	private UserType getTypes(User user) {
		UserType[] roles = UserType.values();
		for (UserType role : roles) {
//			role = UserType.list().get(0);
			UserType type = UserType.valueOf(role.getType());
			userService.assignType(user, type);
		}
		return user.getUserType();
	}

}
