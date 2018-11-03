package task4.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task4.pojo.Student;

import javax.annotation.Resource;

@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentDaoTest {
    @Resource(name = "studentDao")
    private StudentDao studentDao;

    @Test
    public void count() {
        Integer i=studentDao.count();
        System.out.println(i);
    }
    @Test
    public void countJob(){
        Integer i=studentDao.countJob();
        System.out.println(i);
    }

    @Test
    public void savaStudent() {
        Student s =new Student();
        s.setName("海清");
        s.setAge(21);
        s.setGender("男");
        s.setJob("前端工程师");
        s.setSchoolTime(System.currentTimeMillis());
        s.setGraduate("0");
        s.setTakingWork("0");
        s.setCreateTime(System.currentTimeMillis());
        s.setUpdateTime(System.currentTimeMillis());
        Integer i =studentDao.savaStudent(s);
        System.out.println(i);
    }
}