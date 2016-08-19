package com.pvt.tracker.dao;

import com.pvt.tracker.model.usertype.AbstractUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    @Resource
    SessionFactory sessionFactory;

    public void create (AbstractUser abstractUser) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(abstractUser);
//        session.persist(abstractUser); // каковы отличия?
    }

    public void update (AbstractUser abstractUser) {

    }

    public void deleteById (AbstractUser abstractUser) {

    }

    public AbstractUser get () {
        return null;
    }

    public List<AbstractUser> getAll () {
        return null;
    }

}
