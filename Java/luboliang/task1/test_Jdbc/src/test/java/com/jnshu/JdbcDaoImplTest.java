package com.jnshu;

import org.junit.Test;

public class JdbcDaoImplTest {
    JdbcDaoImpl j = new JdbcDaoImpl();

    @Test
    public void addTest() {
        Student student = new Student();
        student.setId(2);
        student.setName("金石开");
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        student.setQq(1050376715);
        student.setCourse_type("产品经理");
        student.setEntrance_time(18273123);
        student.setGraduate_school("北京师范大学");
        student.setWish(4487);
        student.setDaily_link("www.jnshu.com/school/28015/daily.");
        student.setSet_to("变胖两斤");
        student.setBrother("李天宇");
        student.setLearn("朋友推荐");
        System.out.println(j.add(student));
    }

    @Test
    public void deleteTest() {

        System.out.println(j.delete(16));



    }

    @Test
    public void updateTest() {
        Student student = new Student();
        student.setId(2);
        student.setName("金石开");
        student.setUpdate_at(System.currentTimeMillis());
        student.setQq(1050376715);
        student.setCourse_type("产品经理");
        student.setEntrance_time(18273123);
        student.setGraduate_school("北京师范大学");
        student.setWish(4487);
        student.setDaily_link("www.jnshu.com/school/28015/daily.");
        student.setSet_to("变胖两斤");
        student.setBrother("李天宇");
        student.setLearn("朋友推荐");
        System.out.println(j.update(student));
    }

    @Test
    public void selectTest() {
        System.out.println(j.select(23));
    }

    @Test
    public void students() {
        System.out.println(j.findStudents());
    }
}
