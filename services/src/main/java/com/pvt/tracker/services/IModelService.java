package com.pvt.tracker.services;

import com.pvt.tracker.beans.Model;

import java.util.List;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
public interface IModelService<T> extends IService<T> {

    public List<Model> getTaskComments (Model modelType);
}
