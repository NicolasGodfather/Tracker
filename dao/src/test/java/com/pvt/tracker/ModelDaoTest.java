/*
package com.pvt.tracker;

import com.pvt.tracker.beans.Model;
import com.pvt.tracker.dao.ModelDao;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;


*/
/**
 * Realization
 *
 * @author Nicolas Asinovich.
 *//*

@ContextConfiguration ("/testContext.xml")
@RunWith (SpringJUnit4ClassRunner.class)
@TransactionConfiguration (transactionManager = "txManager", defaultRollback = true)
@Transactional(propagation = Propagation.REQUIRED)
public class ModelDaoTest {

    @Autowired
    private ModelDao modelDao;

    @Test
    public void createModel() {
        Model task = new Model();
        task.setId(0);
        task.setName("Fix");
        Model createdModel = modelDao.create(task);
        assertNotNull(createdModel.getId());
        createdModel = modelDao.get(createdModel.getId());
        assertEquals("User doesn't create", task, createdModel);
    }

    @After
    public void deleteModel() {
        List<Model> list = modelDao.getAll();
        int size = list.size();
        if (size > 0) {
            Model createdModel = list.get(0);
            modelDao.delete(createdModel);
            assertNotSame(modelDao.getAll().size(), size);
        }
    }

}
*/
