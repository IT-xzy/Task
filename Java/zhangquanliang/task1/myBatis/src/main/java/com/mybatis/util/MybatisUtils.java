package com.mybatis.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * mybatis连接数据库的工具类
 * @author suger
 * @date 2018-09-26
 */
public class MybatisUtils {

    /**
     * 获取SqlSessionFactory
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = MybatisUtils.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        return factory;
    }
    public static SqlSession getSession(){
        return getSqlSessionFactory().openSession();
    }
    /**
     * 获取SqlSession
     * @param isAutoCommit  true 自动提交  false 手动提交
     * @return SqlSession
     */
    public static SqlSession getSession(boolean isAutoCommit) {
        return getSqlSessionFactory().openSession(isAutoCommit);
    }

}
