package cn.wyq.jdbc;

import cn.wyq.pojo.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;


public class JdbcImplTest {
        @Before
        public void setUp() throws Exception {
            System.out.println("Start");
        }

        @After
        public void tearDown() throws Exception {
            System.out.println("Over!");
        }

        @Test
        public void testInsert() throws Exception{
            Student s = new Student();
            s.setSiblingId(5);
            s.setSiblingName("任我行");
            s.setName("resin");

            JdbcImpl jdbc = new JdbcImpl();
            jdbc.insert(s);
        }

        @Test
        public void testUpdate() {
            Student s = new Student();
            s.setId(12000000);
            s.setName("Mcray");
            s.setSiblingName("任我行");
            s.setSiblingId(6);
            JdbcImpl j = new JdbcImpl();
            j.update(s);
        }

        @Test
        public void testDelete() {
            JdbcImpl j = new JdbcImpl();
            j.delete(147);
        }

        @Test
        public void testGet() {
            JdbcImpl j = new JdbcImpl();
            j.get(148);
        }

        @Test
        public void testListName(){
            JdbcImpl j = new JdbcImpl();
            j.listname("resin");
        }
}