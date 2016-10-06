package com.pvt.tracker.services.impl;

import com.pvt.tracker.dao.IDao;
import com.pvt.tracker.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
@Transactional
public abstract class BaseService<T> implements IService<T> {
    @Autowired
    private IDao<T> dao;

    public BaseService () {
    }

    @Autowired
    public BaseService (IDao<T> dao) {
        this.dao = dao;
    }

    public void create (T t) {
        dao.create(t);
    }

    public void update (T t) {
        dao.update(t);
    }

    public void delete (T t) {
        dao.delete(t);
    }

    @Override
    public T getById (Serializable id) {
        return dao.get(id);
    }

    public List<T> getAll () {
        return dao.getAll();
    }
}
