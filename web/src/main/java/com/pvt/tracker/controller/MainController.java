package com.pvt.tracker.controller;

import com.pvt.tracker.beans.User;
import com.pvt.tracker.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {

	@Autowired
	private IUserService userService;

	@RequestMapping (value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("greeting", "Hello and welcome");
		return "welcome";
	}
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "admin";
	}
	@RequestMapping(value = "/access_denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "access-denied";
	}
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	@SuppressWarnings("unchecked")
	protected void fillModel(ModelMap model) {
		List<User> list = userService.getAll();
		model.put("users", list);
		User user = new User();
		if (list.size() > 1) {
			user = list.get(0);
		}
		model.put("user", user);
	}

//	@RequestMapping(value="/logout", method = RequestMethod.GET)
//	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if (auth != null){
//			new SecurityContextLogoutHandler().logout(request, response, auth);
//		}
//		return "redirect:/login?logout";
//	}

	//	@RequestMapping(value = "/login", method = RequestMethod.GET)
	//	public String loginPage() {
	//		return "login";
	//	}
}
