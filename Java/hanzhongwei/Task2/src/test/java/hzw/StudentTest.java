package hzw;

import hzw.mapper.StudentMapper;
import hzw.model.Student;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentTest {
    private static Logger logger = Logger.getLogger(StudentTest.class);

    //对studentMapper进行标注，完成自动配装的工作
    @Autowired
    private StudentMapper studentMapper;

    //@Test
    //增
    public void addStu(){
        logger.info("测试添加=====================");
        Student student = new Student();
        student.setStuName("曹嘉懿");
        student.setStuQQ(847368124);
        student.setStuType("PM");
        student.setStuNum(521);
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        studentMapper.addStu(student);
        long id = student.getStuId();
        System.out.println("id===================="+id);
        logger.info(student.getStuId());
    }

    //@Test
    //删
    public void deleteStu(){
        logger.info("测试删除=====================");
        long stuId = 26;
        studentMapper.deleteStu(stuId);
    }

    //@Test
    //改
    public void updateStu(){
        logger.info("测试更新=====================");
        Student student = new Student();
        student.setStuId(94);
        student.setStuName("王梅梅");
        student.setStuQQ(87342978);
        student.setStuType("UI");
        student.setStuNum(161);
        student.setUpdate_at(System.currentTimeMillis());
        studentMapper.updateStu(student);
        logger.info("更新:"+student);
    }

    //@Test
    //查id
    public void getId(){
        logger.info("测试查询id=====================");
        long stuId = 97;
        Student student = studentMapper.getId(stuId);
        logger.info(student);
    }

    @Test
    //查所有
    public void getAll(){
        List<Student> stu = studentMapper.getAll();
        for(Student s:stu){
            logger.info(s.toString());
        }
    }

    //@Test
    //查name
    public void getName() {
        Student student = new Student();
        student.Student("李龙",587);
        List<Student> list = studentMapper.getName(student);
        for(Student s:list){
            logger.info(s.toString());
        }
    }
}
