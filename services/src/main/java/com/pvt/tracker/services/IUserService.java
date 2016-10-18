package com.pvt.tracker.services;

import com.pvt.tracker.beans.User;
import com.pvt.tracker.beans.enums.UserType;
import com.pvt.tracker.services.exception.ServiceException;

import java.util.List;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
public interface IUserService extends IService<User> {

    User createUser(String login, String password, String name, String surname, String email) throws ServiceException;
    User findByUserName(String userName);
    User findUserByLogin(String login);
    User findUserByLoginAndPassword (String login, String password);
//    List<T> findUsersByType(T tType);
    List<User> findUsersByType(UserType tType);
    void assignType(User user, UserType userType);
    void removeType (User user);
    List<User> getAll();
    List<UserType> getAllType() throws ServiceException;

}
