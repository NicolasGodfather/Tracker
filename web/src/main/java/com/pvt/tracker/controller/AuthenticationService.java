//package com.pvt.tracker.controller;
//
//import com.pvt.tracker.beans.User;
//import com.pvt.tracker.beans.UserProfile;
//import com.pvt.tracker.beans.enums.StateType;
//import com.pvt.tracker.services.IUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service ("authService")
//public class AuthenticationService implements UserDetailsService {
//
//    @Autowired
//    private IUserService userService;
//
//    @Transactional (readOnly = true)
//    public UserDetails loadUserByUsername(String userName)
//            throws UsernameNotFoundException {
//        User user = (User) userService.findUserByLogin(userName);
//        System.out.println("User : " + user);
//        if (user == null) {
//            System.out.println("User not found");
//            throw new UsernameNotFoundException("Username not found");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
//                StateType.ACTIVE.getState().equals(user.getState()), true, true, true, getGrantedAuthorities(user));
//    }
//
//
//    private List<GrantedAuthority> getGrantedAuthorities(User user) {
//        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//
//        for (UserProfile userProfile : user.getUserProfiles()) {
//            System.out.println("UserProfile : " + userProfile);
//            authorities.add(new SimpleGrantedAuthority(userProfile.getType()));
//        }
//        System.out.print("authorities :" + authorities);
//        return authorities;
//    }
//
//}
