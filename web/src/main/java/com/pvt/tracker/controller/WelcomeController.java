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
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
@Controller
@SessionAttributes ("login")
@RequestMapping ("/welcome")
public class WelcomeController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/signIn", method = {RequestMethod.POST, RequestMethod.GET})
    public String signIn(ModelMap modelMap, @Valid @ModelAttribute ("user") User user,
                         BindingResult bindingResult, HttpSession session) {
        if (!bindingResult.hasErrors()) {
            userService.findUserByLoginAndPassword(user.getLogin(), user.getPassword());
            return "redirect:welcome/";
        }
        return "index";
    }

    @RequestMapping(value = "/signOut", method = RequestMethod.GET)
    public String signOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:index";
    }

//    @RequestMapping (value = "/welcome", method = RequestMethod.GET)
////    public String welcomePage() {
////        User user = new User();
////        user.setLogin("login");
////        user.setPassword("password");
////        return "welcome";
////    }
//
////    @RequestMapping (value = "/login-fail", method = RequestMethod.GET)
////    @RequestWrapper
////    public String loginFail(ModelAndView model, @RequestParam (value = "login-fail") String error ) {
////        if ("error".equals(error)) {
////            model.addObject("error", "Authentication error");
////        }
////        return "welcome";
////    }
}
