package com.hzw.mapper;

import com.hzw.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentMapperTest {

    //对studentMapper进行标注，完成自动配装的工作
    /*使用Spring注解方式测试，拿到注入的StudentMapper对象，
    当调用add方法的时候，会自动去找StudentMapper.xml里id="add"的sql语句。 */
    @Autowired
    private StudentMapper studentMapper;

    //@Test
    public void addStu() {

        Student stu = new Student();
        stu.setS_name("曹嘉懿");
        stu.setS_qq(847368124);
        stu.setS_type("PM");
        stu.setS_num(666);
        stu.setCreate_at(System.currentTimeMillis());
        stu.setUpdate_at(System.currentTimeMillis());
        studentMapper.addStu(stu);
        long id = stu.getS_id();
        System.out.println("id===================="+id);
    }

    @Test
    public void deleteStu() {
        long s_id = 35;
        studentMapper.deleteStu(s_id);
    }

    //@Test
    public void updateStu(){
        Student stu = new Student();
        stu.setS_id(3);
        stu.setS_name("刘亦菲");
        stu.setS_qq(343454676);
        stu.setS_type("QA");
        stu.setS_num(999);
        stu.setUpdate_at(System.currentTimeMillis());
        studentMapper.updateStu(stu);
    }

    @Test
    public void getId(){
        long s_id = 35;
        Student stu;
        stu = studentMapper.getId(s_id);
        System.out.println(stu);
    }

    //@Test
    public void getName(){
        List<Student> list;
        Student stu = new Student();
        stu.Student("刘亦菲",999);
        list = studentMapper.getName(stu);
        for (Student s:list){
            System.out.println(s);
        }
    }

    @Test
    public void getAll(){
        List<Student> list;
        list = studentMapper.getAll();
        for (Student s:list){
            System.out.println(s.toString());
        }
    }

}
