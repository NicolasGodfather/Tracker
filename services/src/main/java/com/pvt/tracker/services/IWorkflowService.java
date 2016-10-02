package com.pvt.tracker.services;

import com.pvt.tracker.beans.Status;

import java.util.List;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
public interface IWorkflowService<T> extends IService<T>{

    List<Status> getStatuses(T t);
}
