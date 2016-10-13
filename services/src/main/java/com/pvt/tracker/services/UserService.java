package com.pvt.tracker.services;

import com.pvt.tracker.beans.User;
import com.pvt.tracker.beans.UserProfile;
import com.pvt.tracker.beans.enums.UserType;
import com.pvt.tracker.dao.IUserDao;
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
    public User findUserByLogin (String login) {
        return (User) userDao.findUserByLogin(login);
    }

    public User findUserByLoginAndPassword (String login, String password) {
        return (User) userDao.findUserByLogPass(login, password);
    }

    @SuppressWarnings ("unchecked")
    public List<User> findUsersByType(UserProfile userType) {
        return userDao.findUsersByType(userType);
    }

    @SuppressWarnings ("unchecked")
    public void removeType (User user) {
        userDao.removeType(user);
    }

    public User findByUserName (String userName) {
        return (User) userDao.findByUserName(userName);
    }

    @SuppressWarnings ("unchecked")
    public void assignType (User user, UserType[] userType) {
        userDao.assignType(user, userType);
    }
}