package com.pvt.tracker.dao.impl;

import com.pvt.tracker.dao.DAOException;
import com.pvt.tracker.dao.UserDao;
import com.pvt.tracker.model.usertype.AbstractUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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

    static UserDaoImpl userDao = null;

    public static UserDaoImpl getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    public void create (AbstractUser abstractUser) {
        try {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(abstractUser);
//        session.persist(abstractUser); // отличия
        logger.info("User successfully created. User details: " + abstractUser);
        } catch (Exception e) {
            throw new DAOException(String.format("Creating user by id %s", abstractUser.getId() ), e);
        }
    }

    public void update (AbstractUser abstractUser) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.update(abstractUser);
            logger.info("User successfully updated. User details: " + abstractUser);
        } catch (Exception e) {
            throw new DAOException(String.format("Updating user by id %s", abstractUser.getId() ), e);
        }
    }

    public void deleteById (int id) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            AbstractUser abstractUser = (AbstractUser) session.load(AbstractUser.class, new Integer(id));
            if (abstractUser != null) {
                session.delete(abstractUser);
            }
            logger.info("User successfully deleted. User details: " + abstractUser);
        } catch (Exception e) {
            throw new DAOException(String.format("Deleting user by id %s", id ), e);
        }
    }

    public AbstractUser get (int id) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            AbstractUser abstractUser = (AbstractUser) session.load(AbstractUser.class, new Integer(id));
            logger.info("User successfully deleted. User details: " + abstractUser);
            return abstractUser;
        } catch (Exception e) {
            throw new DAOException(String.format("Get user by id %s", id ), e);
        }
    }

    public List<AbstractUser> getAll () {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            List<AbstractUser> userList = session.createQuery("from AbstractUser").list();
            for (AbstractUser abstractUser : userList) {
                logger.info("User list: " + abstractUser);
            }
            return userList;
        } catch (Exception e) {
            throw new DAOException(String.format("Get list all users"), e);
        }
    }
}
