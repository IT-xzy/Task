package com.annotation.untils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUntils {
    public static SqlSessionFactory getFactory() throws IOException {
        String resource = "mybatis-cfg.xml";
        InputStream inputStream = org.apache.ibatis.io.Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
}
