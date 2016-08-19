package com.pvt.tracker.dao;

import java.util.List;

/**
 * Realization abstract layer DAO
 *
 *
 * @author Nicolas Asinovich.
 */
public interface AbstractDao<T>{

    void create(T t);
    void update(T t);
    void deleteById(int id);
    T get(int id);
    List<T> getAll();
}
