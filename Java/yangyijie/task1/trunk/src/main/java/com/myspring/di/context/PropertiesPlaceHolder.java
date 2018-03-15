package com.myspring.di.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Arike
 * Create_at 2017/11/30 14:35
 */

public class PropertiesPlaceHolder {
    public static void main(String[] args)throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/myspring/di/context/mybatis-spring.xml");
        DataSource ds = ctx.getBean("druid", DataSource.class);
        Connection con =ds.getConnection();
        String sql = "SELECT * FROM t_student";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Student> list = new ArrayList<>();
        while (rs.next()){
            Student s = new Student(rs.getLong("id"),rs.getString("name"),rs.getInt("age"));
            list.add(s);
        }
        System.out.println(list);
    }
}
