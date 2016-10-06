package com.pvt.tracker.dao;

import com.pvt.tracker.dao.impl.ModelDao;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
@ContextConfiguration ("/testContext.xml")
@RunWith (SpringJUnit4ClassRunner.class)
@TransactionConfiguration (transactionManager = "txManager", defaultRollback = true)
@Transactional
public class ModelDaoTest {

    @Autowired
    private ModelDao modelDao;
}
