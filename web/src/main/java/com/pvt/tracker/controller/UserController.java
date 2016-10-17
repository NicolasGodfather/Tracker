package com.pvt.tracker.controller;

import com.pvt.tracker.beans.User;
import com.pvt.tracker.beans.UserProfile;
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
@RequestMapping("/userPage")
public class UserController{

	@Autowired
	private IUserService userService;
	private UserType[] userType;

	@RequestMapping (value = "/", method = RequestMethod.GET)
	public String mainPage(ModelMap model) {
//		model.addAttribute("userLogin", getPrincipal());
//		model.addAttribute("users", this.userService.getAll());
//		model.addAttribute("usersView", true);
//		model.addAttribute("usersTree", getUsersTree());
//		model.addAttribute("usersList", this.userService.getAll());
		return "users/main";
	}


	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String userInfo() {
		return "users/info";
	}

	/**
	 * Only ADMIN can create some users
	 * @return admin/main
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/users/create", method = RequestMethod.POST)
	@Secured("ADMIN")
	public String createUser(ModelMap modelMap, @Valid @ModelAttribute ("userLogin") User user,
							 BindingResult bindingResult){
		if (!bindingResult.hasErrors()) {
			userService.create(user);
			modelMap.addAttribute("userLogin", user);
//			modelMap.addAttribute("create_message", true);
			return "users/create";
		}
		return "redirect:users/main";
	}

	/**
	 * Only ADMIN can create some users
	 * @return admin/main
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/delete-user", method = RequestMethod.POST)
	@Secured("ADMIN")
	public String deleteUser(ModelMap model, User user) {
		if (user != null) {
			userService.delete(user);
			model.put("message", "User: " + user.getName() + " was deleted");
		}
		fillModel(model);
		return "redirect:users/main";
	}

	@RequestMapping(value = "/update-user/{id}", method = RequestMethod.POST)
	public String updateUser (@PathVariable ("id") int id, ModelMap model, User user){
		model.addAttribute("userLogin", this.userService.getById(id));
		model.addAttribute("mainPage", this.userService.getAll());
		return "redirect:users/main";
	}

//	@SuppressWarnings("unchecked")
//	private Map<UserType, List<User>> getUsersTree() {
//		Map<UserType, List<User>> usersTree = new HashMap<>();
//		List<UserType> userTypes = UserType.list();
//		for (UserType type : userTypes) {
//			usersTree.put(type, userService.findUsersByType(type));
//		}
//		return usersTree;
//	}

	@SuppressWarnings("unchecked")
	private Map<UserProfile, List<User>> getUsersTree() throws ServiceException {
		Map<UserProfile, List<User>> usersTree = new HashMap<>();
		List<UserProfile> userProfiles = userService.getAllProfile();
		for (UserProfile userProfile : userProfiles) {
			usersTree.put(userProfile, userService.findUsersByType(userProfile));
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

//	private String getPrincipal (){
//		String userName = null;
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		if (principal instanceof UserDetails) {
//			userName = ((UserDetails)principal).getUsername();
//		} else {
//			userName = principal.toString();
//		}
//		return userName;
//	}
//
//	private String getPrincipal(){
//		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		String login = userDetails.getUsername();
//		return login;
//	}

//	@SuppressWarnings("unchecked")
//	@RequestMapping (value = "/getAllUsers", method = RequestMethod.GET)
//	public String getAllUsers(ModelMap modelMap) throws ServiceException {
//		List<User> allUsers = userService.getAll();
//		if(allUsers.isEmpty()){
//			modelMap.addAttribute("get_all_users_message", true);
//		}
//		modelMap.addAttribute("users", allUsers);
//		return "users/main";
//	}
}
