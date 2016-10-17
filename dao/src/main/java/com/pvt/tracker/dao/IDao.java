package com.pvt.tracker.dao;

import java.io.Serializable;

/**
 * Realization abstract dao layer
 *
 *
 * @author Nicolas Asinovich.
 */
public interface IDao<T>{

    T create(T t);
    T get(Serializable id);
//    List<T> getAll();
    void update(T t);
    void delete(T t);
}
