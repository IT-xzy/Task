package cn.wp.entity;

import cn.wp.dao.ContactDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ApplicationContext.xml")

public class ContactTest {
    @Autowired
    ContactDao mapper;
    Contact cat = new Contact();

    @Test
    public void add() {
        cat.setName("小倩");
        cat.setEmail("ni@uu.com");
        cat.setQQ(666);
        cat.setGender("女");
        mapper.add(cat);
        System.out.println(cat.getID());
    }

    @Test
    public void delete() {

        System.out.println(mapper.delete(14));

    }

    @Test
    public void update() {
        cat.setID(10);
        cat.setName("撒娇女人最好命");
        cat.setEmail("wp.cn");
        cat.setQQ(4321);
        cat.setGender("男");
        System.out.println(mapper.update(cat));
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

