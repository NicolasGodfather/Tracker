package com.pvt.tracker.dao;

import com.pvt.tracker.beans.User;
import com.pvt.tracker.beans.enums.UserType;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Realization dao layer users
 *
 * @author Nicolas Asinovich.
 */
@Repository
public class UserDao extends BaseDao<User> implements IUserDao {

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
        String hql = "from User";
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    @Override
    public User findByUserName (String userName) {
        return (User) getCriteria().add(Restrictions.eq("userName", userName)).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public User findUserByLogin(String login) {
        return (User) getCriteria().add(Restrictions.eq("login", login)).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public User findUserByLogPass(String login, String password) {
        return (User) getCriteria().add(Restrictions.disjunction().
                add(Restrictions.or(Restrictions.like("login", login + "%"),
                        Restrictions.like("password", password + "%"))));
    }

    @SuppressWarnings("unchecked")
    public List<User> findUsersByType(User userType) {
        return getCriteria().add(Restrictions.disjunction().
                add(Restrictions.or(Restrictions.like("userType", userType + "%")))).list();
    }

    public void assignType (User user, UserType[] userType) {
    }

    public void removeType (User user) {
    }
}