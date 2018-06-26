package cn.wyq.jdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import cn.wyq.pojo.Student;

import static org.junit.Assert.*;


public class JdbcTemplateImplTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("Start");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Over!");
    }
    Student s = new Student();
    JdbcTemplateImpl jdbcTemplate = new JdbcTemplateImpl();
    @Test
    public void testInsert() {
        s.setName("蓝");
        s.setSiblingId(5);
        s.setSiblingName("令狐冲");
        jdbcTemplate.insert(s);
    }

    @Test
    public void testUpdate() {
        s.setId(149);
        s.setName("蓝");
        s.setSiblingId(5);
        s.setSiblingName("令狐冲");
        jdbcTemplate.update(s);
    }

    @Test
    public void testDelete() {
        jdbcTemplate.delete(180);
    }

    @Test
    public void testGet() {
        jdbcTemplate.get(14800000);
    }

    @Test
    public void testListName(){
        jdbcTemplate.listname("j");
    }
}