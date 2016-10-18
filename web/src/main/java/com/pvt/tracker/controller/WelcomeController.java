package com.pvt.tracker.controller;

import com.pvt.tracker.beans.User;
import com.pvt.tracker.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

/**
 * Realization first page login users
 *
 * @author Nicolas Asinovich.
 */
@Controller
public class WelcomeController{

    @Autowired
    private IUserService userService;

    /**
     * Start page application
     * @return welcome page
     */
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String showStartPage(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "welcome";
    }

    @RequestMapping(value = "/signIn", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(ModelMap modelMap, @Valid @ModelAttribute ("user") User user,
                         BindingResult bindingResult, HttpSession session) {
        if (!bindingResult.hasErrors()) {
            userService.findUserByLoginAndPassword(user.getLogin(), user.getPassword());
            return "redirect:/user/main";
        }
        return "welcome";
    }

    @RequestMapping(value = "/signOut", method = RequestMethod.GET)
    public String signOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:welcome";
    }

//    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
//	public String accessDeniedPage(ModelMap model) {
//		model.addAttribute("user", getPrincipal());
//		return "access-denied";
//	}
//
//	@RequestMapping(value="/logout", method = RequestMethod.GET)
//	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if (auth != null){
//			new SecurityContextLogoutHandler().logout(request, response, auth);
//		}
//		return "redirect:/login?logout";
//	}

}
