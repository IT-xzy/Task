package com.jnshu;

import com.jnshu.MyBatis.StudentMapper;
import com.jnshu.model.Page;
import com.jnshu.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/springDao.xml")
public class AppTest {
    @Autowired
    StudentMapper studentMapper;

    @Test
    public void testAdd() {
        Student student = new Student();
        student.setName("试试");
        student.setQq(1234);
        student.setWish(12334);
        studentMapper.addStudent(student);
        System.out.println(student.getId());
    }

    @Test
    public void testDelete() {
        System.out.println(studentMapper.deleteStudent(74));
    }

    @Test
    public void testUpdate() {
        Student student = new Student();
        student.setName("我是谁");
        student.setQq(828391);
        student.setId(4);
        System.out.println(studentMapper.updateStudent(student));
    }

    @Test
    public void testFindById() {
        System.out.println(studentMapper.findById(71));
    }

    @Test
    public void testFindAll() {
        System.out.println(studentMapper.findAll());
    }

    @Test
    public void page() throws Exception {
        System.out.println(studentMapper.findUsers().size());
    }

    @Test
    public void pags() throws Exception {
        Page p = new Page();
        int currentPage;
        currentPage = p.getCurrentPage();
        p.setPageSize(10);
        p.setTotalUsers(studentMapper.findUsers().size());
        System.out.println("总记录行数" + p.getTotalUsers());
        //当前页

        //总页数
        p.setTotalPages(p.getTotalUsers() % p.getPageSize() == 0 ? p.getTotalUsers() / p.getPageSize() : p.getTotalUsers() / p.getPageSize() + 1);

        //查询表中的数据
        List<Student> list = studentMapper.findUsersByPage((currentPage - 1) * p.getPageSize(), p.getPageSize());
        //下一页
        if (currentPage < p.getTotalPages()) {

            p.setNextPage(currentPage + 1);
            currentPage = p.getNextPage();
            System.out.println("当前页是几"+currentPage);
        } else {
            p.setNextPage(currentPage);
        }
        //上一页
        if (p.getNextPage() > 1) {
            p.setPrefPage(currentPage - 2);
            currentPage = p.getPrefPage();

        } else {
            p.setPrefPage(currentPage);
        }
        System.out.println(list);
        System.out.println("当前页=" + currentPage);

        System.out.println("入参前" + p);

        System.out.println(p);

    }

}
