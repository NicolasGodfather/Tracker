package com.pvt.tracker.controller;

import com.pvt.tracker.beans.User;
import com.pvt.tracker.beans.enums.StateType;
import com.pvt.tracker.dao.UserDao;
import com.pvt.tracker.services.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("authService")
public class AuthenticationService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
    @Autowired
    private IUserService userService;

    @Transactional (readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = (User) userService.findUserByLogin(login);
        logger.info("User : " + user);
        if (user == null) {
            logger.info("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
                StateType.ACTIVE.getState().equals(user.getState()), true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        for (UserProfile userProfile : user.getUserProfiles()) {
//            logger.info("UserProfile : " + userProfile);
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
//        }
        logger.info("authorities :" + authorities);
        return authorities;
    }

//    @RequestMapping (value = "/welcome", method = RequestMethod.GET)
//    public String welcomePage() {
//        User user = new User();
//        user.setLogin("login");
//        user.setPassword("password");
//        return "welcome";
//    }

//    @RequestMapping (value = "/login-fail", method = RequestMethod.GET)
//    @RequestWrapper
//    public String loginFail(ModelAndView model, @RequestParam (value = "login-fail") String error ) {
//        if ("error".equals(error)) {
//            model.addObject("error", "Authentication error");
//        }
//        return "welcome";
//    }

}
