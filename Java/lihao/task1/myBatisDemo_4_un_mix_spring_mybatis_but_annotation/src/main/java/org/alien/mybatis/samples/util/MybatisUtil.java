package org.alien.mybatis.samples.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lihoo
 * @Title: MybatisUtil
 * @ProjectName myBatisDemo_4
 * @Description: TODO
 * @date 2018/7/1112:53
 */


public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSessionFactory getSqlSessionFactory() {
        String mybatisConfigPath = "config.mybatis/mybatis.xml";

        try {
            InputStream inputStream = Resources.getResourceAsStream(mybatisConfigPath);
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sqlSessionFactory;
    }

    /**
     * Open a SqlSession via SqlSessionFactory.
     * By the way, you should close the SqlSession in your code.
     *
     * @return SqlSession sqlSession instance.
     */

    public static SqlSession getSqlSession() {
        return MybatisUtil.getSqlSessionFactory().openSession();
    }

}
