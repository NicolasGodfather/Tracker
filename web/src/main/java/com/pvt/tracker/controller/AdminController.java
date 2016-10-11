package com.pvt.tracker.controller;

import com.pvt.tracker.beans.User;
import com.pvt.tracker.services.IUserService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes ("login")
@RequestMapping ("/adminPage")
public class AdminController extends MainController {

    @Autowired
    private IUserService userService;

    @RequestMapping (value = "/", method = RequestMethod.GET)
    public String adminPage(ModelMap modelMap) {
        modelMap.addAttribute("login", getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/signUpPage", method = RequestMethod.GET)
    public String signUpPage(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "signUp";
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/signUpUser", method = RequestMethod.POST)
    public String signUpUser(ModelMap modelMap, @Valid @ModelAttribute ("user") User user, BindingResult bindingResult){
        if (!bindingResult.hasErrors()) {
            userService.create(user);
            modelMap.addAttribute("user", user);
            modelMap.addAttribute("sign_up_message", true);
            return "index";
        }
        return "admin";
    }


    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/delete-user", method = RequestMethod.POST)
    public String deleteUser(ModelMap model, User user) {
        if (user != null) {
            userService.delete(user);
            model.put("message", "User: " + user.getName() + " was deleted");
        }
        fillModel(model);
        return "users/main";
    }

    @RequestMapping(value = "/update-user/{id}", method = RequestMethod.POST)
    public String updateUser (@PathVariable ("id") int id, ModelMap model, User user){
        model.addAttribute("user", this.userService.getById(id));
        model.addAttribute("mainPage", this.userService.getAll());
        return "users/main";
    }


    @RequestMapping (value = "/getAllUsers", method = RequestMethod.GET)
    public String getAllUsers(ModelMap modelMap) throws ServiceException {

        List<User> allUsers = userService.getAll();

        if(allUsers.isEmpty()){
            modelMap.addAttribute("get_all_users_message", true);
        }
        modelMap.addAttribute("users", allUsers);
        return "admin";
    }


    private String getPrincipal(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = userDetails.getUsername();
        return login;
    }

//    @Transactional (readOnly = true)
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        User user = (User) userService.findUserByLogin(login);
//        logger.info("User : " + user);
//        if (user == null) {
//            logger.info("User not found");
//            throw new UsernameNotFoundException("Username not found");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
//                StateType.ACTIVE.getState().equals(user.getState()), true, true, true, getGrantedAuthorities(user));
//    }
//
//    private List<GrantedAuthority> getGrantedAuthorities(User user) {
//        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
////        for (UserProfile userProfile : user.getUserProfiles()) {
////            logger.info("UserProfile : " + userProfile);
////            authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
////        }
//        logger.info("authorities :" + authorities);
//        return authorities;
//    }
}
