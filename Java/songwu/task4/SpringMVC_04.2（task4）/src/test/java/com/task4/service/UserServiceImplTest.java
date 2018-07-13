package com.task4.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * UserServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>六月 26, 2018</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: selectAll()
     */
    @Test
    public void testSelectAll() throws Exception {
        System.out.println(userService.selectAll());
    }


}
