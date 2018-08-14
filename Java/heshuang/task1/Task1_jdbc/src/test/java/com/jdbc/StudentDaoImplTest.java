package com.jdbc;

import com.jdbc.DaoImpl.StudentDaoImpl;
import com.jdbc.Pojo.Student;

public class StudentDaoImplTest {
    @org.junit.Test
    public void addStudent() throws Exception {
        Student student = new Student();
        student.setCreate_at("1529117153");
        student.setName("张三");
        student.setQq("145896352");
        student.setProfessional("java");
        student.setStart_time("2018-04-16");
        student.setUniversity("郑州大学");
        student.setOnline_id(556);
        student.setDaily_url("http://www.jnshu.com/school/26079/daily");
        student.setOath("如果我不能在IT特 训营拼尽全力，为自己以后的修行道路上打好基础，就让我变胖10斤。");
        student.setCounselor("张亚强");
        student.setCity("郑州");
        StudentDaoImpl s = new StudentDaoImpl();
        s.addStudent(student);

        Student student1 = new Student();
        student1.setCreate_at("1529117153");
        student1.setName("王五");
        student1.setQq("145874123");
        student1.setProfessional("UI");
        student1.setStart_time("2018-04-20");
        student1.setUniversity("四川大学");
        student1.setOnline_id(255);
        student1.setDaily_url("http://www.jnshu.com/school/26079/daily");
        student1.setOath("如果我不能在IT特 训营拼尽全力，为自己以后的修行道路上打好基础，就让我变胖10斤。");
        student1.setCounselor("小强");
        student1.setCity("成都");
        s.addStudent(student1);
    }

    @org.junit.Test
    public void deleteStudent() throws Exception {
        StudentDaoImpl s = new StudentDaoImpl();
        s.deleteStudent(1);
    }

    @org.junit.Test
    public void updateStudent() throws Exception {
        StudentDaoImpl s = new StudentDaoImpl();
        s.updateStudent(10);
    }

    @org.junit.Test
    public void findStudent() throws Exception {
        StudentDaoImpl s = new StudentDaoImpl();
        s.findStudent("张三");
    }

    @org.junit.Test
    public void findAll() throws Exception {
        StudentDaoImpl s = new StudentDaoImpl();
        s.findAll();
    }

    @org.junit.Test
    public void findStudentByOlin_id() throws Exception {
        StudentDaoImpl s = new StudentDaoImpl();
        s.findStudentByOlin_id(255);
    }
    }


