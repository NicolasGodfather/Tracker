package com.pvt.tracker.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {

	@RequestMapping (value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage() {
		return "welcome";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "users/main";
	}

	@RequestMapping(value = "/access_denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "access-denied";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
//	private String getPrincipal(){
//		UserDetails userDetails = (UserDetails)
//				SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		return userDetails.getUsername();
//	}


	/*First method on start application*/
//	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
//	public ModelAndView main(@ModelAttribute ("user") User user) {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("user", new User());
//		modelAndView.setViewName("welcome");
//		return modelAndView;
//	}
//
//	@ModelAttribute("user")
//	public User createUser() {
//		return new User();
//	}

	/*как только на main.jsp подтвердится форма
    <spring:form method="post"  modelAttribute="userJSP" action="check-user">,
    то попадем вот сюда
     */
//	@RequestMapping(value = "/signIn")
//	public ModelAndView checkUser(@ModelAttribute("user") User user) {
//		ModelAndView modelAndView = new ModelAndView();
//		//имя представления, куда нужно будет перейти
//		modelAndView.setViewName("users/main");
//		//записываем в атрибут userJSP (используется на странице *.jsp) объект user
//		modelAndView.addObject("user", user);
//		return modelAndView; //после уйдем на представление, указанное чуть выше, если оно будет найдено.
//	}



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
