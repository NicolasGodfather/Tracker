package com.pvt.tracker.dao.impl;

import com.pvt.tracker.dao.ModelDao;
import com.pvt.tracker.model.Model;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Realization dao layer model
 *
 * @author Nicolas Asinovich.
 */
@Component
public class ModelDaoImpl implements ModelDao {

    public int create (Model model) {
        return 0;
    }

    public void update (Model model) {

    }

    public void deleteById (int id) {

    }

    public Model getById (int id) {
        return null;
    }

    public List<Model> getAll () {
        return null;
    }
}
