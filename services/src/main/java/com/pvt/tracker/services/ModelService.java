package com.pvt.tracker.services;

import com.pvt.tracker.beans.Model;
import com.pvt.tracker.dao.IModelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ModelService extends BaseService<Model> implements IModelService<Model> {

    @Autowired
    IModelDao modelDao;

    @SuppressWarnings ("unchecked")
    public List<Model> getTaskComments (Model modelType) {
        return modelDao.getTaskComments(modelType);
    }

    @Override
    public List<Model> getAll () {
        return modelDao.getAll();
    }
}
