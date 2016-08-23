package com.pvt.tracker.controllers;


import com.pvt.tracker.dao.UserDao;
import com.pvt.tracker.dao.impl.UserDaoImpl;
import com.pvt.tracker.model.User;
import com.pvt.tracker.model.enums.UserType;
import org.springframework.stereotype.Controller;

/**
 * Realization controller for authorization users.
 *
 * @author Nicolas Asinovich.
 */
@Controller
public class LoginController extends MainController {

	private UserDao userDao;
	private UserType userType;

	public LoginController() {
		userDao = UserDaoImpl.getUserDao();
		userType = UserType.getUserType();
	}
	
	/**
	 * Check user if exist in system. If he does exist, that receipt obj user type
	 * and put in session. If he doesn't exist, that redirect to index.jsp page.
	 */
	public void auth() {
		User user = userDao.findUserByLogPass(param("login"), param("password"));
		if (user == null) {
			param("bad_auth", true);
			forward("/index.jsp");
		} else {
			user.setUserType(UserType.getUserType());
			session("logged_user", user);
			redirect("/");
		}
	}
	
	/**
	 * Exit user from system (kill object in session).
	 */
	public void logout() {
		session("logged_user", null);
		redirect("/");
	}
	
}
