package com.pvt.tracker.dao;

import com.pvt.tracker.dao.exception.DAOException;
import com.pvt.tracker.beans.BaseEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Realization BaseDao
 *
 * @author Nicolas Asinovich.
 */
@Repository
public class BaseDao<T> implements IDao<T> {

    private static final Logger logger = LoggerFactory.getLogger(BaseDao.class);
    private SessionFactory sessionFactory;

    @Autowired
    public BaseDao (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession (){
        return this.sessionFactory.getCurrentSession();
    }

    public T create (T t) {
        BaseEntity baseEntity = (BaseEntity) t;
        try {
            baseEntity.getCreatedTime(new Timestamp(new Date().getTime()));
            getSession().saveOrUpdate(t);
            logger.info("Created. Details: " + t);
            return t;
        } catch (Exception e) {
            throw new DAOException(String.format("Creating %s", t ), e);
        }
    }

    public void update (T t) {
        BaseEntity baseEntity = (BaseEntity) t;
        try {
            baseEntity.setUpdatedTime(new Timestamp(new Date().getTime()));
            getSession().update(t);
            logger.info("Updated. Details: " + t);
        } catch (Exception e) {
            throw new DAOException(String.format("Updating %s", t ), e);
        }
    }

    @SuppressWarnings("unchecked")
    public T get (Serializable id) {
        logger.info("Get:" + id);
        return (T) getSession().get(BaseEntity.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll () {
        String hql = "from T";
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    public void delete (T t) {
        logger.info("Deleted:" + t);
        getSession().delete(t);
    }

}
