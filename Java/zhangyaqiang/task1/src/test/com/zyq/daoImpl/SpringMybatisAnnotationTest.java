package com.zyq.daoImpl;

import com.zyq.dao.StudentMapper;
import com.zyq.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringMybatisAnnotationTest {
    @Autowired
    private StudentMapper studentMapper;
    Student student = new Student();

    @Test
    public void testInsert2(){
        student.setName("朱士峰");
        student.setQq(1694942998);
        student.setProfession("前端工程师");
        student.setUniversity("登云学院");
        student.setNumber(5914);
        student.setDaily("http://www.jnshu.com/daily/61433?dailyType=others&total=19&page=1&uid=20336&sort=0&orderBy=3");
        student.setSenior("晋良金");
        student.setFrom("知乎");
        student.setCreateTime(System.currentTimeMillis());
        student.setUpdateTime(System.currentTimeMillis());
        studentMapper.insert2(student);
        System.out.println("您插入的数据ID为："+student.getId()+",请牢记。");
    }

    @Test
    public void testDeleteById2(){
        student.setId(82L);
        boolean flag = studentMapper.deleteById2(student);
        if (flag == false){
            System.out.println("删除失败，没有此行。");
        }else {
            System.out.println("删除成功");
        }
    }

    @Test
    public void testUpdate2(){
        student.setName("朱士峰");
        student.setUpdateTime(System.currentTimeMillis());
        boolean flag = studentMapper.update2(student);
        if (flag == false){
            System.out.println("更新失败，没有此行。");
        }else {
            System.out.println("更新成功");
        }
    }

    @Test
    public void testSelectById(){
        student = studentMapper.selectById2(58L);
        if (student==null){
            System.out.println("根据您输入的ID，查无此人，请确认是否输入错误");
        }else {
            System.out.println(student);
        }
    }

    @Test
    public void selectByNameAndNum(){
        List<Student> list = studentMapper.selectByNameAndNum2("朱士峰",5914);
        if (list.size()!=0) {
            for (Student student : list) {
                System.out.println(student);
            }
        }else {
            System.out.println("根据您的条件，数据表中查无此人。");
        }
    }
}
