/*
package com.pvt.tracker;

import com.pvt.tracker.beans.User;
import com.pvt.tracker.dao.UserDao;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

*/
/**
 * Realization test for UserDao
 *
 * @author Nicolas Asinovich.
 *//*

@ContextConfiguration ("/testContext.xml")
@RunWith (SpringJUnit4ClassRunner.class)
@TransactionConfiguration (transactionManager = "txManager", defaultRollback = true)
@Transactional
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void createUser() {
        User nico = new User();
        nico.setId(0);
        nico.setName("Nikolay");
//        nico.setSurname("Asinovich");
        nico.setLogin("Nico");
        nico.setPassword("201290");
//        nico.setUserType(UserType.valueOf("DEVELOPER"));
        nico.setEmail("nicolas.asinovich@gmail.com");
//        nico.setState("ACTIVE");
        User createdUser = userDao.create(nico);
        assertNotNull(createdUser.getId());
        createdUser = userDao.get(createdUser.getId());
        assertEquals("User doesn't create", nico, createdUser);
    }

//    public void updateUser() {
//    }

    @After
    public void deleteUser() {
        List<User> list = userDao.getAll();
        int size = list.size();
        if (size > 0) {
            User createdUser = list.get(0);
            userDao.delete(createdUser);
            assertNotSame(userDao.getAll().size(), size);
        }
    }
}
*/
