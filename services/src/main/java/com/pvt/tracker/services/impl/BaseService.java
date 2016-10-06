package com.pvt.tracker.services.impl;

import com.pvt.tracker.dao.IDao;
import com.pvt.tracker.services.IService;

import java.io.Serializable;
import java.util.List;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
public abstract class BaseService<T> implements IService<T> {

    private IDao<T> dao;

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
