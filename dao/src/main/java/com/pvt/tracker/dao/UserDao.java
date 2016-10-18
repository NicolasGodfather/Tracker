package com.pvt.tracker.dao;

import com.pvt.tracker.beans.User;
import com.pvt.tracker.beans.enums.UserType;
import com.pvt.tracker.dao.exception.DAOException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Realization dao layer users
 *
 * @author Nicolas Asinovich.
 */
@Repository
public class UserDao extends BaseDao<User> implements IUserDao {

    private Query query = null;
    private String hql = null;
    private final String ERROR_MESSAGE = "Hibernate query error ";

    @Autowired
    public UserDao (SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    private Criteria getCriteria() {
        return super.getSession().createCriteria(User.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll () {
        hql = "from User";
        query = getSession().createQuery(hql);
        return query.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UserType> getAllType () {
//        hql = "from User where userType=?";
        hql = "select userType from User where userType=:userType";
        query = getSession().createQuery(hql);
        return query.list();
    }

    //    @SuppressWarnings("unchecked")
//    public List<User> findUsersByType(User userType) {
//        try {
//            hql = "FROM User WHERE userProfiles=?";
//            query = getSession().createQuery(hql);
//            query.setParameter(0, userType);
//            return query.list();
//        } catch (HibernateException e) {
//            throw new DAOException(ERROR_MESSAGE + "in method 'findUserByType'", e);
//        }
//    }
//    @SuppressWarnings("unchecked")
//    public List<User> findUsersByType(User userType) {
//        return getCriteria().add(Restrictions.disjunction().
//                add(Restrictions.or(Restrictions.like("userType", userType + "%")))).list();
    public void assignType (User user, UserType userType) {
        try {
            hql = "INSERT INTO User (userType)" + "select userType from User where id=:id";
            query = getSession().createQuery(hql);
            query.setParameter("id", user);
            query.setParameter("id", userType);
        } catch (HibernateException e) {
            throw new DAOException(ERROR_MESSAGE + "in method 'assignType'", e);
        }
    }
//
//    public void assignRole(User user, Role role) {
//        execute("INSERT INTO users_roles (user_id, role_id) VALUES (" + user.getId() + ", " + role.getId() + ")");
//    }

    @SuppressWarnings("unchecked")
    public User findUserByLogPass(String login, String password) {
        try {
            hql = "FROM User WHERE login=? AND password=?";
            query = getSession().createQuery(hql);
            query.setParameter(0, login);
            query.setParameter(1, password);
            return (User) query.uniqueResult();
        } catch (HibernateException e) {
            throw new DAOException(ERROR_MESSAGE + "in method 'findUserByLogPass'", e);
        }
    }

    @Override
    public User findByUserName (String userName) {
        return (User) getCriteria().add(Restrictions.eq("userName", userName)).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public User findUserByLogin(String login) {
        return (User) getCriteria().add(Restrictions.eq("login", login)).uniqueResult();
    }
    //    @SuppressWarnings("unchecked")
//    public User findUserByLogPass(String login, String password) {
//        return (User) getCriteria().add(Restrictions.disjunction().
//                add(Restrictions.or(Restrictions.like("login", login + "%"),
//                        Restrictions.like("password", password + "%"))));
//    }
    @SuppressWarnings("unchecked")
//    public List<User> findUsersByType(UserProfile userType) {
//        try {
//            hql = "FROM User WHERE userProfiles=?";
//            query = getSession().createQuery(hql);
//            query.setParameter(0, userType);
//            return query.list();
//        } catch (HibernateException e) {
//            throw new DAOException(ERROR_MESSAGE + "in method 'findUserByType'", e);
//        }
//    }


    @Override
    public List<User> findUsersByType (UserType userType) {
        try {
            hql = "FROM User WHERE userType=?";
            query = getSession().createQuery(hql);
            query.setParameter(0, userType);
            return query.list();
        } catch (HibernateException e) {
            throw new DAOException(ERROR_MESSAGE + "in method 'findUserByType'", e);
        }
    }

//    }

    public void removeType (User user) {
    }

    @Override
    public User create (User user) {
        user.setCreatedTime(new Timestamp(new Date().getTime()));
        user.setUpdatedTime(new Timestamp(new Date().getTime()));
        return create(user);
    }
}
