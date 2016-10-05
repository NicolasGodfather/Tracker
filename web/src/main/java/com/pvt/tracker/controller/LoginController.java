//package com.pvt.tracker.controller;
//
//
//import com.pvt.tracker.beans.User;
//import com.pvt.tracker.beans.enums.UserType;
//import com.pvt.tracker.services.IUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
///**
// * Realization controller for authorization users.
// *
// * @author Nicolas Asinovich.
// */
//@Controller
//public class LoginController extends MainController {
//
//	@Autowired (required = true)
//	private IUserService iUserService;
//	private User userType;
//
//	/**
//	 * Check user if exist in system. If he does exist, that receipt obj user type
//	 * and put in session. If he doesn't exist, that redirect to index.jsp page.
//	 */
//	public void auth() {
//		User user = (User) iUserService.findUserByLogPass(param("login"), param("password"));
//		if (user == null) {
//			param("bad_auth", true);
//			forward("/index.jsp");
//		} else {
//			user.setUserType(UserType.valueOf(user.getName()));
//			session("logged_user", user);
//			redirect("/");
//		}
//	}
//
//	/**
//	 * Exit user from system (kill object in session).
//	 */
//	public void logout() {
//		session("logged_user", null);
//		redirect("/");
//	}
//
//}
