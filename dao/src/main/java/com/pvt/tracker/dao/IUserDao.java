package com.pvt.tracker.dao;

import com.pvt.tracker.beans.enums.UserType;

import java.util.List;

/**
 * Realization interface dao user's
 *
 * @author Nicolas Asinovich.
 */
public interface IUserDao<T> extends IDao<T> {

    T findByUserName(String userName);

    /**
     * Find a user by login.
     * @param login user's.
     * @return list user's.
     */
    T findUserByLogin(String login);

    /**
     * Find a user by login & password
     * @param login user's.
     * @param password user's.
     * @return list user's.
     */
    T findUserByLogPass(String login, String password);

    /**
     * Find a user by type
     * @param userType user's.
     * @return list user's.
     */
     List<T> findUsersByType(T userType);

    /**
     * Assign type user's.
     * @param user obj User.
     * @param userType obj enum UserType.
     */
    void assignType(T user, UserType[] userType);

    /**
     * Remove a user's type.
     * @param user obj User.
     */
    void removeType (T user);
}
