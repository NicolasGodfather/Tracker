package com.pvt.tracker.services;

import java.io.Serializable;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
public interface IService<T> {

    void create(T t);
    void update(T t);
    void delete(T t);
    T getById(Serializable id);
}
