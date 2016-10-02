package com.pvt.tracker.services;

import com.pvt.tracker.beans.enums.UserType;

import java.util.List;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
public interface IUserService<T> extends IService<T> {

    List<T> findUserByLogin(String login);
    T findUserByLogPass(String login, String password);
    List<T> findUsersByType(T tType);
    void assignType(T user, UserType[] userType);
    void removeType (T user);
}
