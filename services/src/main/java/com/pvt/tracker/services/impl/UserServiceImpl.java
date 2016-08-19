package com.pvt.tracker.services.impl;

import com.pvt.tracker.dao.UserDao;
import com.pvt.tracker.model.usertype.AbstractUser;
import com.pvt.tracker.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Realization user service layer
 *
 * @author Nicolas Asinovich.
 */
@Service
public class UserServiceImpl implements UserService {

    UserDao userDao;


    public void create (AbstractUser abstractUser) {
        this.userDao.create(abstractUser);
    }

    public void update (AbstractUser abstractUser) {
        this.userDao.update(abstractUser);
    }

    public void deleteById (int id) {
        this.userDao.deleteById(id);
    }

    public AbstractUser get (int id) {
        return this.userDao.get(id);
    }

    public List<AbstractUser> getAll () {
        return this.userDao.getAll();
    }
}
