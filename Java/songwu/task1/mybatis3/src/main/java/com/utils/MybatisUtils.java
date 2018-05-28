package com.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    public static SqlSession getConnection() throws IOException {
       String   Resource="mybatis-config.xml";
        InputStream inputStream=Resources.getResourceAsStream(Resource);
        SqlSessionFactory  factory=new SqlSessionFactoryBuilder().build(inputStream);
        return factory.openSession();
    }
}
