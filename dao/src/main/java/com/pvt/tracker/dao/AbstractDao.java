package com.pvt.tracker.dao;

/**
 * Realization layer DAO
 *
 * @author Nicolas Asinovich.
 */
public interface AbstractDao<T>{

    void create();
    void update();
    void delete();
    T get();
}
