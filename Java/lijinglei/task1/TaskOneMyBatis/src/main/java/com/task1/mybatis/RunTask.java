package com.task1.mybatis;

import com.task1.mybatis.dao.Dao;
import com.task1.mybatis.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Iterator;
import java.util.List;

public class RunTask {
    static ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");

    public static void main(String args[]) {
        //新建一个User对象user，其属性会通过公共接口userDao传递到mysql语句中
        Dao userDao = (Dao)ctx.getBean("userMapper");
        User user = new User();
        //执行插入操作
        try {
            user.setName("152");
            user.setQq("");
            user.setStudy_type("");
            user.setEnrollment("");
            user.setGraduate_school("");
            user.setStudent_num("");
            user.setDaily_link("");
            user.setWish("");
            user.setCheck_bro("");
            userDao.insert(user);
            System.out.println("最新更新"+user.getId());

        } catch (Exception e) {
            System.out.println("插入失败"+e.getMessage());
        }
        //执行查询操作
        try {
            User rsid = userDao.lookupId(2);
            sk(rsid);
        } catch (Exception e) {
            System.out.println("查询失败");
        }
        //执行删除操作
        try {
            System.out.print("删除结果：");
            System.out.println(userDao.delete(6));
        } catch (Exception e) {
            System.out.println("删除失败");
        }
        //执行更新操作
        try {
            System.out.print("更新结果：");
            System.out.println(userDao.update(15, "1653"));
        } catch (Exception e) {
            System.out.println("更新失败"+e.getMessage());
        }
        //根据姓名查询
        try {
            User rsName = userDao.lookupName("4");
            sk(rsName);
        } catch (Exception e) {
            System.out.println("查询失败");
        }
        //根据学号查询
        try {
            User rsNum = userDao.lookupNum("3762");
            sk(rsNum);
        } catch (Exception e) {
            System.out.println("查询失败");
        }

        List<User> users = userDao.selectAll();
        Iterator<User> iter = users.iterator();
        while (iter.hasNext()) {
            User u = iter.next();
            sk(u);
        }
        System.out.println("记录条数：" + userDao.countAll());
        }
        static void sk(User u){
            System.out.println("ID:"+ u.getId());
            System.out.println("姓名:"+ u.getName());
            System.out.println("QQ:"+ u.getQq());
            System.out.println("修真类型："+ u.getStudy_type());
            System.out.println("入学时间："+ u.getEnrollment());
            System.out.println("毕业学校："+ u.getGraduate_school());
            System.out.println("线上学号：" + u.getStudent_num());
            System.out.println("日报链接：" + u.getDaily_link());
            System.out.println("立愿：" + u.getWish());
            System.out.println("审核师兄：" + u.getCheck_bro());
    }
    }

