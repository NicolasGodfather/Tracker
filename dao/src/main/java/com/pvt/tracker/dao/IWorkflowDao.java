package com.pvt.tracker.dao;

import com.pvt.tracker.beans.Status;

import java.util.List;

/**
 * Realization interface dao workflow
 *
 * @author Nicolas Asinovich.
 */
public interface IWorkflowDao<T> extends IDao<T> {

    List<Status> getStatuses(T t);
}
