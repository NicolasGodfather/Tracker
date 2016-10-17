//package com.pvt.tracker.controller;
//
////@Controller
//public class MainController {
//
////	@RequestMapping (value = { "/", "/home" }, method = RequestMethod.GET)
////	public String homePage() {
////		return "welcome";
////	}
////
////	@RequestMapping(value = "/user", method = RequestMethod.GET)
////	public String userPage(ModelMap model) {
////		model.addAttribute("user", getPrincipal());
////		return "users/main";
////	}
//
////	@RequestMapping(value = "/access_denied", method = RequestMethod.GET)
////	public String accessDeniedPage(ModelMap model) {
////		model.addAttribute("user", getPrincipal());
////		return "access-denied";
////	}
////
////	@RequestMapping(value="/logout", method = RequestMethod.GET)
////	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
////		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
////		if (auth != null){
////			new SecurityContextLogoutHandler().logout(request, response, auth);
////		}
////		return "redirect:/login?logout";
////	}
////
//
//}
