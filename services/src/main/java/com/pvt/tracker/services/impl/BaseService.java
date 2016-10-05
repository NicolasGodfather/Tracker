package com.pvt.tracker.services.impl;

import com.pvt.tracker.dao.IDao;
import com.pvt.tracker.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
@Service
@Transactional (propagation = Propagation.REQUIRED)
public class BaseService<T> implements IService<T> {
    @Autowired
    private IDao<T> baseDao;

    public BaseService () {
    }

    @Autowired
    public BaseService (IDao<T> baseDao) {
        this.baseDao = baseDao;
    }

    public void create (T t) {
        baseDao.create(t);
    }

    public void update (T t) {
        baseDao.update(t);
    }

    public void delete (T t) {
        baseDao.delete(t);
    }

    @Override
    public T getById (Serializable id) {
        return baseDao.get(id);
    }

    public List<T> getAll () {
        return baseDao.getAll();
    }
}
