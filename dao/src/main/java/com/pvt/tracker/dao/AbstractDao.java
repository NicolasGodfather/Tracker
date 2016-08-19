package com.pvt.tracker.dao;

import java.util.List;

/**
 * Realization abstract layer DAO
 *
 * @author Nicolas Asinovich.
 */
public interface AbstractDao<T>{

    void create(T t);
    void update(T t);
    void deleteById(T t);
    T get();
    List<T> getAll();
}
