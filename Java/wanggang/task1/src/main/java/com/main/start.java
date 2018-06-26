package com.main;

import com.entity.Student;
import com.service.StudentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class start {
    private static Logger logger = LogManager.getLogger(StudentServiceImpl.class.getName());

    public static void main(String[] args) {
        Student student = new Student();
        StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
        //模糊查询
        try {
            student.setName("1");
            List<Student> list = studentServiceImpl.findByLike(student);
            if (list != null) {
                for (Student s : list)
                    System.out.println(s.toString());
            }
        } catch (Exception e) {
            System.out.println("无符合要求");
            e.printStackTrace();
        }

        //列出所有
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
        //根据关键字查询
        try {
            student.setStudyName(8545);
            student = studentServiceImpl.findByName(student);
            if (student != null)
                System.out.println(student.toString());
            else
                System.out.println("查无此人");

        } catch (Exception e) {
            e.printStackTrace();
        }


        //批量插入
        Long start = System.currentTimeMillis();
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Student s = new Student("小龙虾4号", 845, "java", "20170223", "麻辣大龙虾大学", 64523, "www.longxia.com.cn", "吃", "大龙虾", "知乎");
            int qq = (int) (Math.random() * 100000000);
            int study = (int) (Math.random() * 10000);
            s.setName("龙虾" + i + "号");
            s.setQq(qq);
            s.setStudyName(study);
            list.add(s);
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
        //单例插入
        try {
            student = new Student("龙虾王", 17, "java", "20170223", "麻辣大龙虾大学", 64523, "www.longxia.com.cn", "吃", "大龙虾", "知乎");
            boolean b = studentServiceImpl.addStudent(student);
            System.out.println("已插入第" + student.getId() + "条数据。");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("插入失败");
            System.out.println("原因：" + e.getMessage());
        }

        //根据ID删除
        try {
            student.setId(100);
            Boolean b = studentServiceImpl.deleteById(student);
            if (b == true)
                System.out.println(b + "删除成功");
            else
                System.out.println(b + "删除失败");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //更新数据
        try {
            student.setId(101);
            student.setName("龙虾皇");
            Boolean b = studentServiceImpl.updateByName(student);
            if (b == true) {
                System.out.println(b + "更新成功");
            } else {
                System.out.println(b + "更新失败，检查数据是否存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

       // 删除所有数据
        try {
            studentServiceImpl.truncate();

            System.out.println("删除成功，啥米都没了");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除失败，检查是否正常");
        }


    }
}


