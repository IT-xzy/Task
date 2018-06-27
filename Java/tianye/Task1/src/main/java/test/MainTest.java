package test;



import org.jnshuDB.dao.StudentDao;
import org.jnshuDB.entity.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MainTest {
    ClassPathXmlApplicationContext applicationContext;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext;
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        final StudentDao bean =     applicationContext.getBean(StudentDao.class);
        System.out.println(bean.findByS_id(3683));
    }

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void testSpringIoc() {
        final StudentDao bean = applicationContext.getBean(StudentDao.class);
        bean.delete(3686);
        System.out.println(bean.countAll());

    }

    @Test
    public void printAllBeanDefinitionNames() {
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void testSpringIoc1() {
        final StudentDao bean = applicationContext.getBean(StudentDao.class);
        System.out.println(bean.findByS_id(3683));
    }

    @Test
    public void testSpringIoc2() {
        final StudentDao bean = applicationContext.getBean(StudentDao.class);
        Student student = new Student();
        student.setS_id(3686);
        student.setS_brother("天宇");
        student.setS_know("知乎");
        student.setS_link("http://www.jnshu.com/daily/54552?dailyType=others&total=16&page=7&uid=22347&sort=0&orderBy=10");
        student.setS_name("李快80");
        student.setS_school("武汉学院");
        student.setS_qq(1116511561);
        student.setS_time("2018-05-10");
        student.setS_type("java工程师");
        student.setS_words("是这样的事");
        student.setCreate_at(new Date().getTime());
        student.setUpdate_at(new Date().getTime());
        bean.insert(student);
    }

    @Test
    public void testSpringIoc3() {
        final StudentDao bean = applicationContext.getBean(StudentDao.class);
        System.out.println(bean.selectAll());
    }

    @Test
    public void testSpringIoc4() {
        final StudentDao bean = applicationContext.getBean(StudentDao.class);
        Student student = bean.findByS_id(3683);
        student.setUpdate_at(new Date().getTime());
        student.setS_name("laoye3");
        bean.update(student);
    }
}