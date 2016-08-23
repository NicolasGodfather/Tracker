package com.pvt.tracker.dao;

import java.util.List;

/**
 * Realization abstract dao layer
 *
 *
 * @author Nicolas Asinovich.
 */
public interface AbstractDao<T>{

    int create(T t);
    void update(T t);
    void deleteById(int id);
    T getById(int id);
    List<T> getAll();
}
