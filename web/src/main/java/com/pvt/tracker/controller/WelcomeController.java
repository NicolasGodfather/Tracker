package com.pvt.tracker.controller;

import com.pvt.tracker.beans.User;
import com.pvt.tracker.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
@Controller
@RequestMapping ("/welcome")
public class WelcomeController extends MainController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String main(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "login";
    }

//    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
//    public String signIn(ModelMap modelMap, @Valid @ModelAttribute ("user") User user,
//                         BindingResult bindingResult, HttpSession session) {
//        if (!bindingResult.hasErrors()) {
////            userService.findUserByLoginAndPassword(user.getLogin(), user.getPassword());
//            modelMap.addAttribute("user", getPrincipal());
//            return "redirect:users/main";
//        }
//        return "welcome";
//    }

//    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
//    public String signIn() {
//        return "welcome";
//    }

//    @RequestMapping(value = "/signOut", method = RequestMethod.GET)
//    public String signOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:welcome";
//    }


//    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
//    public ModelAndView main(ModelMap modelMap, @Valid @ModelAttribute ("user") User user,
//                             BindingResult bindingResult, HttpSession session) {
//        ModelAndView modelAndView = new ModelAndView();
//        if (!bindingResult.hasErrors()) {
//            modelAndView.addObject("user", new User());
//            userService.findUserByLoginAndPassword(user.getLogin(), user.getPassword());
//            modelAndView.setViewName("redirect:userPage/");
//            return modelAndView;
//        }
//        modelAndView.setViewName("welcome");
//        return modelAndView;
//    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView main(@ModelAttribute("user") User user) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("user", new User());
//        modelAndView.setViewName("welcome");
//        return modelAndView;
//    }
//
//    @ModelAttribute("user")
//    public User createUser() {
//        return new User();
//    }
//
//    @RequestMapping(value = "/signIn")
//    public ModelAndView checkUser(@ModelAttribute("user") User user) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("users/main");
//        modelAndView.addObject("user", user);
//        return modelAndView;
//    }
}
