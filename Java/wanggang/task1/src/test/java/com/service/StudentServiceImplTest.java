package com.service;

import com.entity.Student;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StudentServiceImplTest {
    private static Logger logger = LogManager.getLogger(StudentServiceImpl.class.getName());
    Student student = new Student();
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl();

    @Test
    public void addStudent() {
        try {
            student = new Student("小龙虾4号", 17, "java", "20170223", "麻辣大龙虾大学", 64523, "www.longxia.com.cn", "吃", "大龙虾", "知乎");
            boolean b = studentServiceImpl.addStudent(student);
            System.out.println("已插入第" + student.getId() + "数据。");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("插入失败");
            System.out.println("原因：" + e.getMessage());
        }

    }

    @Test
    public void insertBatch() {

            Long start = System.currentTimeMillis();
            List<Student> list = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                Student student = new Student("小龙虾4号", 17, "java", "20170223", "麻辣大龙虾大学", 64523, "www.longxia.com.cn", "吃", "大龙虾", "知乎");
                int qq = (int) (Math.random() * 100);
                int study = (int) (Math.random() * 10000);
                student.setName("龙虾" + i + "号");
                student.setQq(qq);
                student.setStudyName(study);
                list.add(student);
            }
        try {
            int a = studentServiceImpl.insertBatch(list);
            Long end = System.currentTimeMillis();
            System.out.println("插入" + a + "行");
            System.out.println("耗时" + (end - start) + "毫秒");
        } catch (Exception e) {
            System.out.println("插入失败");
            System.out.println("原因：" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void deleteById() throws Exception {
        student.setId(212);
        Boolean b = studentServiceImpl.deleteById(student);
        if (b == true) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败，检查数据是否存在");
        }
    }

    @Test
    public void updateByName() throws Exception {
        student.setId(219);
        student.setName("龙虾王");
        Boolean b = studentServiceImpl.updateByName(student);
        if (b == true) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败，检查数据是否存在");
        }

    }

    @Test
    public void findAll() {
        try {
            List<Student> list = studentServiceImpl.findAll();
            for (Student s : list
                    ) {
                System.out.println(s.toString());

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询失败，原因：" + e.getMessage());
        }

    }

    @Test
    public void findByName() throws Exception {
        student.setStudyName(5246778);
        System.out.println(student);
        student = studentServiceImpl.findByName(student);
        if (student != null)
            System.out.println(student.toString());
        else
            System.out.println("查无此人");

    }

    @Test
    public void findByLike() throws Exception {
        student.setName("9");
        student.setStudyName(68);
        List<Student> list = studentServiceImpl.findByLike(student);
        if (list != null) {
            for (Student s : list) {
                System.out.println(s.toString());
            }
        } else {
            System.out.println("无符合要求");
        }

    }


}
