package cn.summerwaves.util;

import cn.summerwaves.dao.StudentDao;
import cn.summerwaves.model.Student;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class XMemcachedUtilTest {
    @Test
    public void addCache() throws Exception {
    }

    @Resource
    private XMemcachedUtil xMemcachedUtil;
    @Resource
    private StudentDao studentDao;

    @Autowired
    private MemcachedClient memcachedClient;

    @Test
    public void init() throws Exception {

 /*       List<Student> studentsFromDB = studentDao.selectAllStudent();
        xMemcachedUtil.addCache("students", 3600, "fuck");*/
        xMemcachedUtil.addCache("fuck",3600,"fucking");
        System.out.println((String) xMemcachedUtil.getCache("fuck"));

    }

    @Test
    public void memcached() throws InterruptedException, MemcachedException, TimeoutException {
        Student student1 = new Student();
        student1.setName("fuck you!");
        Student student2 = new Student();
        student2.setName("fuck you!");
        List<Student> studentList = new ArrayList<Student>(Arrays.asList(student1, student2));
        memcachedClient.set("test", 3600, studentList);
        System.out.println(memcachedClient.get("test"));
    }
}