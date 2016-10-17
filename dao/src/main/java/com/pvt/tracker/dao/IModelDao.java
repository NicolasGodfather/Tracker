package com.pvt.tracker.dao;

import com.pvt.tracker.beans.Model;

import java.util.List;

/**
 * Realization interface dao beans
 *
 * @author Nicolas Asinovich.
 */
public interface IModelDao extends IDao<Model> {
    /**
     * @param t will be comment
     * @return list comment
     */
    List getTaskComments(Model t);

    List<Model> getAll ();
}
