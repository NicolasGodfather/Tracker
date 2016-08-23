package com.pvt.tracker.dao.impl;

import com.pvt.tracker.dao.DAOException;
import com.pvt.tracker.dao.UserDao;
import com.pvt.tracker.model.User;
import com.pvt.tracker.model.enums.UserType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Realization dao layer users
 *
 * @author Nicolas Asinovich.
 */
@Component
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    @Resource
    SessionFactory sessionFactory;

    private static UserDao userDao = new UserDaoImpl();

    public static UserDao getUserDao() {
        return userDao;
    }

    /**
     * Create a user.
     * @param user
     */
    public int create (User user) {
        try {
        Session session = this.sessionFactory.getCurrentSession();
        user.setCreatedAt(new Timestamp(new Date().getTime()));
        user.setUpdatedAt(new Timestamp(new Date().getTime()));
        session.save(user);
//            UserType type = UserType.valueOf("A")
        logger.info("User successfully created. User details: " + user);
        return user.getId();
        } catch (Exception e) {
            throw new DAOException(String.format("Creating user by id %s", user.getId() ), e);
        }
    }

    /**
     * Update a user.
     * @param user
     */
    public void update (User user) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            user.setUpdatedAt(new Timestamp(new Date().getTime()));
            session.update(user);
            logger.info("User successfully updated. User details: " + user);
        } catch (Exception e) {
            throw new DAOException(String.format("Updating user by id %s", user.getId() ), e);
        }
    }

    /**
     * Delete a user by id.
     * @param id user's.
     */
    public void deleteById (int id) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            User user = (User) session.load(User.class, new Integer(id));
            if (user != null) {
                session.delete(user);
            }
            logger.info("User successfully deleted. User details: " + user);
        } catch (Exception e) {
            throw new DAOException(String.format("Deleting user by id %s", id ), e);
        }
    }

    /**
     * Receipt a user by id.
     * @param id user's.
     * @return a user.
     */
    public User getById(int id) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            User user = (User) session.load(User.class, new Integer(id));
            logger.info("User successfully deleted. User details: " + user);
            return user;
        } catch (Exception e) {
            throw new DAOException(String.format("Get user by id %s", id ), e);
        }
    }

    /**
     * Receipt all users.
     * @return List<User>.
     */
    @SuppressWarnings("unchecked")
    public List<User> getAll () {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            List<User> userList = session.createQuery("from AbstractUser").list();
            for (User user : userList) {
                logger.info("User list: " + user);
            }
            return userList;
        } catch (Exception e) {
            throw new DAOException(String.format("Get list all users"), e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<User>findUserByLogin(String login) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria searchCriteria = session.createCriteria(User.class).
                add(Restrictions.disjunction().add(Restrictions.or(Restrictions.like("login", login + "%"))));
        return searchCriteria.list();
    }

    @SuppressWarnings("unchecked")
    public User findUserByLogPass(String login, String password) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria searchCriteria =  session.createCriteria(User.class).
                add(Restrictions.disjunction().add(Restrictions.or(Restrictions.like("login", login + "%"),
                        Restrictions.like("password", password + "%"))));
        return (User) searchCriteria;
    }

    @SuppressWarnings("unchecked")
    public List<User> findUsersByType(UserType userType) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria searchCriteria = session.createCriteria(User.class).
                add(Restrictions.disjunction().add(Restrictions.or(Restrictions.like("userType", userType + "%"))));
        return searchCriteria.list();
    }

    public void assignType(User user, UserType userType) {
    }

    public void removeType (User user) {
    }

}
