package com.pvt.tracker.dao;

import java.util.List;

/**
 * Realization interface dao beans
 *
 * @author Nicolas Asinovich.
 */
public interface IModelDao<T> extends IDao<T> {
    /**
     * @param t will be comment
     * @return list comment
     */
    List<T> getTaskComments(T t);

}
