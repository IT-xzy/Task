package com.zyq.daoImpl;

import com.zyq.dao.StudentDao;
import com.zyq.domain.Student;
import org.junit.Test;

import java.util.List;

public class StudentDaoImplTemplateTest {
    private StudentDao sdiTemplate = new StudentDaoImplTemplate();
    private Student student = new Student();

    @Test
    public void testInsert(){
        student.setName("张焱赫");
        student.setQq(779672655);
        student.setProfession("JAVA工程师");
        student.setUniversity("北京北方工业大学土木工程学院");
        student.setNumber(3923);
        student.setDaily("http://www.jnshu.com/school/24817/daily");
        student.setSenior("乔宝");
        student.setFrom("知乎");
        student.setCreateTime(System.currentTimeMillis());
        student.setUpdateTime(System.currentTimeMillis());
        Long id = sdiTemplate.insert(student);
        System.out.println("您插入的数据ID为："+id+",请牢记。");
    }

    @Test
    public void testDeleteById(){
        student.setId(79L);
        boolean flag = sdiTemplate.deleteById(student);
        if (flag == false){
            System.out.println("删除失败，没有此行。");
        }else {
            System.out.println("删除成功");
        }
    }

    @Test
    public void testUpdate(){
//        设置要更新时间的学生姓名
        student.setName("张焱赫");
//        设置修改更新时间
        student.setUpdateTime(System.currentTimeMillis());
        boolean flag = sdiTemplate.update(student);
        if (flag == false){
            System.out.println("更新失败，没有此行。");
        }else {
            System.out.println("更新成功");
        }
    }

    @Test
    public void testSelectById(){
        Student student = sdiTemplate.selectById(25L);
        if (student==null){
            System.out.println("根据您输入的ID，查无此人，请确认是否输入错误");
        }else {
            System.out.println(student);
        }
    }

    @Test
    public void testSelectByNameAndNum(){
        List<Student> list = sdiTemplate.selectByNameAndNum("张焱赫",3923);
        if (list.size()!=0) {
            for (Student student : list) {
                System.out.println(student);
            }
        }else {
            System.out.println("根据您的条件，数据表中查无此人。");
        }
    }
}
