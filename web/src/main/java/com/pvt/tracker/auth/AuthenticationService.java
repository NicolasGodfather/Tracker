package com.pvt.tracker.auth;

import com.pvt.tracker.beans.User;
import com.pvt.tracker.beans.UserProfile;
import com.pvt.tracker.beans.enums.StateType;
import com.pvt.tracker.dao.impl.UserDao;
import com.pvt.tracker.services.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service ("authService")
public class AuthenticationService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    private IUserService userService;

    @Transactional (readOnly = true)
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        User user = (User) userService.findByUserName(userName);
        logger.info("User : " + user);
        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
                StateType.ACTIVE.getState().equals(user.getState()), true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserProfile userProfile : user.getUserProfiles()) {
            System.out.println("UserProfile : " + userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
        }
        System.out.print("authorities :" + authorities);
        return authorities;
    }

}
