package com.pvt.tracker.services.impl;

import com.pvt.tracker.dao.UserDao;
import com.pvt.tracker.model.User;
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

    public void create (User user) {
        this.userDao.create(user);
    }

    public void update (User user) {
        this.userDao.update(user);
    }

    public void deleteById (int id) {
        this.userDao.deleteById(id);
    }

    public User getById (int id) {
        return this.userDao.getById(id);
    }

    public List<User> getAll () {
        return this.userDao.getAll();
    }


}
