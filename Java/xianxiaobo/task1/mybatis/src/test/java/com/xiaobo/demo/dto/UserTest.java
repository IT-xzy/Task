package com.xiaobo.demo.dto;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.xiaobo.demo.dto.User;

import java.io.IOException;
import java.io.Reader;


public class UserTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static void main(String[] args) {
        SqlSession session = sqlSessionFactory.openSession();
        try {

            session.selectOne("updateUserById",2);
            session.commit();
            User user = session.selectOne("selectUserById", 2);
            session.commit();
            System.out.println(user.getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
