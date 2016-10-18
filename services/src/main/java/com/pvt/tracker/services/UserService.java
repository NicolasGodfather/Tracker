package com.pvt.tracker.services;

import com.pvt.tracker.beans.User;
import com.pvt.tracker.beans.enums.UserType;
import com.pvt.tracker.dao.IUserDao;
import com.pvt.tracker.dao.exception.DAOException;
import com.pvt.tracker.services.exception.ServiceException;
import org.hibernate.HibernateException;
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
public class UserService extends BaseService<User> implements IUserService {

    @Autowired
    private IUserDao userDao;

    @SuppressWarnings ("unchecked")
    public User findUserByLogin (String login) {
        return (User) userDao.findUserByLogin(login);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User findUserByLoginAndPassword (String login, String password) {
        User user;
        try{
            user = userDao.findUserByLogPass(login, password);
            return user;
        } catch (HibernateException | DAOException e) {
            throw new SecurityException("Exception in service layer in method 'findUserByLoginAndPassword'", e);
        }
    }

    @Override
    public List<User> findUsersByType (UserType userType) {
        return userDao.findUsersByType(userType);
    }

//    @SuppressWarnings ("unchecked")
//    public List<User> findUsersByType(UserProfile userType) {
//        return userDao.findUsersByType(userType);
//    }

    @SuppressWarnings ("unchecked")
    public void removeType (User user) {
        userDao.removeType(user);
    }

    @Override
    public List<User> getAll () {
        return userDao.getAll();
    }

    @Override
    public List<UserType> getAllType () throws ServiceException {
        try{
            return userDao.getAllType();
        } catch (DAOException | HibernateException e) {
            throw new ServiceException("Error while transaction of getAllUsers");
        }
    }

    @Override
    public User createUser (String login, String password, String name, String surname, String email) throws ServiceException {
        try {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setName(name);
            user.setSurname(surname);
            user.setEmail(email);
            userDao.create(user);
            return user;
        } catch (DAOException | HibernateException e) {
            throw new ServiceException("Error while transaction of createUser");
        }
    }

    public User findByUserName (String userName) {
        return (User) userDao.findByUserName(userName);
    }

    @SuppressWarnings ("unchecked")
    public void assignType (User user, UserType userType) {
        userDao.assignType(user, userType);
    }
}