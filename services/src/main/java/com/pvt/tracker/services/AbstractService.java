package com.pvt.tracker.services;

import java.util.List;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
public interface AbstractService<T> {
    void create(T t);
    void update(T t);
    void deleteById(int id);
    T getById(int id);
    List<T> getAll();
}
