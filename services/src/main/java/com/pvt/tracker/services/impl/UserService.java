package com.pvt.tracker.services.impl;

import com.pvt.tracker.beans.User;
import com.pvt.tracker.beans.enums.UserType;
import com.pvt.tracker.dao.IUserDao;
import com.pvt.tracker.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Realization user service layer
 *
 * @author Nicolas Asinovich.
 */

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserService extends BaseService<User> implements IUserService<User> {
    @Autowired
    private IUserDao userDao;

    @SuppressWarnings ("unchecked")
    public List<User> findUserByLogin (String login) {
        return userDao.findUserByLogin(login);
    }

    public User findUserByLogPass (String login, String password) {
        return (User) userDao.findUserByLogPass(login, password);
    }

    @SuppressWarnings ("unchecked")
    public List<User> findUsersByType(User userType) {
        return userDao.findUsersByType(userType);
    }

    public void assignType (User user, UserType[] userType) {

    }

    public void removeType (User user) {

    }
}