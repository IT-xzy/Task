package com.ev.manager;

import com.ev.DAO.GoodOneDAO;
import com.ev.entity.GoodOne;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * RedisCache Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>05/19/2018</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class RedisCacheTest {

    @Autowired
    RedisCache redisCache;

    @Autowired
    GoodOneDAO goodOneDAO;

    /**
     * Method: set(String key, String value)
     */
    @Test
    public void testSet() throws Exception {
    }

    /**
     * Method: get(String key)
     */
    @Test
    public void testGet() throws Exception {
        //TODO: Test goes here...
    }
}