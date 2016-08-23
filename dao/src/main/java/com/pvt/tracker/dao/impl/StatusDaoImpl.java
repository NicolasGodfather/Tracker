package com.pvt.tracker.dao.impl;

import com.pvt.tracker.dao.StatusDao;
import com.pvt.tracker.model.Status;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Realization dao layer status
 *
 * @author Nicolas Asinovich.
 */
@Component
public class StatusDaoImpl implements StatusDao{


    public int create (Status status) {
        return 0;
    }

    public void update (Status status) {

    }

    public void deleteById (int id) {

    }

    public Status getById (int id) {
        return null;
    }

    public List<Status> getAll () {
        return null;
    }
}
