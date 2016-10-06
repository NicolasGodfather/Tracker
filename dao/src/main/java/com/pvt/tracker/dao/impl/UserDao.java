package com.pvt.tracker.dao.impl;

import com.pvt.tracker.beans.User;
import com.pvt.tracker.beans.enums.UserType;
import com.pvt.tracker.dao.IUserDao;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Realization dao layer users
 *
 * @author Nicolas Asinovich.
 */
@Repository("userDao")
public class UserDao extends BaseDao<Long, User> implements IUserDao<User> {

    @Override
    public User findById (Long id) {
        return getByKey(id);
    }

    @Override
    public User findByUserName (String userName) {
        return (User) createEntityCriteria().add(Restrictions.eq("userName", userName)).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public User findUserByLogin(String login) {
        return (User) createEntityCriteria().add(Restrictions.eq("login", login)).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public User findUserByLogPass(String login, String password) {
        return (User) createEntityCriteria().add(Restrictions.disjunction().
                add(Restrictions.or(Restrictions.like("login", login + "%"),
                        Restrictions.like("password", password + "%"))));
    }

    @SuppressWarnings("unchecked")
    public List<User> findUsersByType(User userType) {
        return createEntityCriteria().add(Restrictions.disjunction().
                add(Restrictions.or(Restrictions.like("userType", userType + "%")))).list();
    }

    public void assignType (User user, UserType[] userType) {
    }

    public void removeType (User user) {
    }
}
