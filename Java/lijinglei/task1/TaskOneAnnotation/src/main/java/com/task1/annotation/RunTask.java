package com.task1.annotation;

import com.task1.annotation.entity.User;
import com.task1.annotation.mapper.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class RunTask {
//    ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//    Mapper userMapper = (Mapper) context.getBean("userMapper");
    User user = new User();
    @Autowired
    private Mapper userMapper;
    @Test
    public void insert() {
        try {
            System.out.print("插入结果：");
            user.setName("138");
            user.setQq("");
            user.setStudy_type("");
            user.setEnrollment("");
            user.setGraduate_school("");
            user.setStudent_num("");
            user.setDaily_link("");
            user.setWish("");
            user.setCheck_bro("");
            userMapper.insert(user);
            System.out.println("最新插入" +user.getId());
        } catch (Exception var2) {
            System.out.println("插入失败" + var2.getMessage());
        }
    }

    @Test
    public void lookupId() {
        try {
            System.out.println("id查询结果：");
            User rsid = userMapper.lookupId(1);
            sk(rsid);
        } catch (Exception var2) {
            System.out.println("查询失败"+var2.getMessage());
        }
    }

    @Test
    public void delete() {
        try {
            System.out.print("删除结果：");
            System.out.println(userMapper.delete(6));
        } catch (Exception var2) {
            System.out.println("删除失败");
        }
    }

    @Test
    public void update() {
        try {
            System.out.print("更新结果：");
            System.out.println(userMapper.update(5, "1653"));
        } catch (Exception var2) {
            System.out.println("更新失败" + var2.getMessage());
        }
    }

    @Test
    public void lookupName() {
        try {
            System.out.println("姓名查询结果：");
            User rsName = userMapper.lookupName("4");
            sk(rsName);
        } catch (Exception var2) {
            System.out.println("查询失败");
        }
    }

    @Test
    public void lookupNum() {
        try {
            System.out.println("学号查询结果：");
            User rsNum = userMapper.lookupNum("3762");
            sk(rsNum);
        } catch (Exception var2) {
            System.out.println("查询失败");
        }
    }

    @Test
    public void selectAll() {
        System.out.println("所有数据：");
        List<User> users = userMapper.selectAll();
        Iterator iter = users.iterator();

        while(iter.hasNext()) {
            User u = (User)iter.next();
            sk(u);
        }
        System.out.println("记录条数：" + userMapper.countAll());
    }

    static void sk(User u) {
        System.out.print("ID:" + u.getId());
        System.out.print("姓名:" + u.getName());
        System.out.print("QQ:" + u.getQq());
        System.out.print("修真类型：" + u.getStudy_type());
        System.out.print("入学时间：" + u.getEnrollment());
        System.out.print("毕业学校：" + u.getGraduate_school());
        System.out.print("线上学号：" + u.getStudent_num());
        System.out.print("日报链接：" + u.getDaily_link());
        System.out.print("立愿：" + u.getWish());
        System.out.println("审核师兄：" + u.getCheck_bro());
    }
}

