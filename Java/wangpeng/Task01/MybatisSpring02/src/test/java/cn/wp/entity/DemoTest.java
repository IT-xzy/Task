/**
 * Author: 老王
 * Date: 2019/4/14 0:56
 */
package cn.wp.entity;

import cn.wp.dao.DemoDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ApplicationContext1.xml")
public class DemoTest {
    @Autowired
    DemoDao mapper;
    Demo de = new Demo();

    @Test
    public void add() {
        de.setId(5);
        de.setName("欧尔");
        de.setQq(222);
        de.setSchool("欧斯大学");
        mapper.add(de);
        System.out.println(de.getId());
    }

    @Test
    public void findById() {
        System.out.println(mapper.findById(1));
    }

    @Test
    public void findAll() {
        System.out.println(mapper.findAll());
    }
}
