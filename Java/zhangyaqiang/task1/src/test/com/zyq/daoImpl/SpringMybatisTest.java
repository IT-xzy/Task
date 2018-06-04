package com.zyq.daoImpl;


import com.zyq.dao.StudentDao;
import com.zyq.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringMybatisTest {

    @Autowired
    private StudentDao studentDao;
    Student student = new Student();

    @Test
    public void testInsert(){
        student.setName("顾配如");
        student.setQq(759859479);
        student.setProfession("前端工程师");
        student.setUniversity("盐城工学院 ");
        student.setNumber(5865);
        student.setDaily("http://www.jnshu.com/daily/58481?dailyType=others&total=15&page=4&uid=23447&sort=0&orderBy=3");
        student.setSenior("张乾");
        student.setFrom("知乎");
        student.setCreateTime(System.currentTimeMillis());
        student.setUpdateTime(System.currentTimeMillis());
        studentDao.insert(student);
        System.out.println("您插入的数据ID为："+student.getId()+",请牢记。");
    }

    @Test
    public void testDeleteById(){
        student.setId(80L);
        boolean flag = studentDao.deleteById(student);
        if (flag == false){
            System.out.println("删除失败，没有此行。");
        }else {
            System.out.println("删除成功");
        }
    }

    @Test
    public void testUpdate(){
        student.setName("顾配如");
        student.setUpdateTime(System.currentTimeMillis());
        boolean flag = studentDao.update(student);
        if (flag == false){
            System.out.println("更新失败，没有此行。");
        }else {
            System.out.println("更新成功");
        }
    }

    @Test
    public void testSelectById(){
        student = studentDao.selectById(60L);
        if (student==null){
            System.out.println("根据您输入的ID，查无此人，请确认是否输入错误");
        }else {
            System.out.println(student);
        }
    }
    @Test
    public void selectByNameAndNum(){
        List<Student> list = studentDao.selectByNameAndNum("顾配如",5865);
        if (list.size()!=0) {
            for (Student student : list) {
                System.out.println(student);
            }
        }else {
            System.out.println("根据您的条件，数据表中查无此人。");
        }
    }
}
