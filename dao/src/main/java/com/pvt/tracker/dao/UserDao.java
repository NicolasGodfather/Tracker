package com.pvt.tracker.dao;

import com.pvt.tracker.model.User;
import com.pvt.tracker.model.enums.UserType;

import java.util.List;

/**
 * Realization interface dao user's
 *
 * @author Nicolas Asinovich.
 */
public interface UserDao extends AbstractDao<User> {

    /**
     * Find a user by login.
     * @param login user's.
     * @return list user's.
     */
    List<User>findUserByLogin(String login);

    /**
     * Find a user by login & password
     * @param login user's.
     * @param password user's.
     * @return list user's.
     */
    User findUserByLogPass(String login, String password);

    /**
     * Find a user by type
     * @param userType user's.
     * @return list user's.
     */
     List<User> findUsersByType(UserType userType);

    /**
     * Assign type user's.
     * @param user obj User.
     * @param userType obj enum UserType.
     */
    void assignType(User user, UserType userType);

    /**
     * Remove a user's type.
     * @param user obj User.
     */
    void removeType (User user);
}
