package com.pvt.tracker.dao.impl;

import com.pvt.tracker.beans.Model;
import com.pvt.tracker.dao.IModelDao;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Realization dao layer beans
 *
 * @author Nicolas Asinovich.
 */
@Repository()
public class ModelDao extends BaseDao<Model> implements IModelDao {

    @Autowired
    public ModelDao (SessionFactory sessionFactory){
        super(sessionFactory);
    }

    public List<Model> getTaskComments (Model modelType) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Model> getAll () {
        String hql = "from Model";
        Query query = getSession().createQuery(hql);
        return query.list();
    }
}
