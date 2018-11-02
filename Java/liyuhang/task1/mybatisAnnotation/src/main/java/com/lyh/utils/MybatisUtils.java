package com.lyh.utils;


import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisUtils {
    public static SqlSessionFactory getFactory(){
        String resources="conf.xml";

        //加载mybatis 的配置文件（它也加载关联的映射文件）
        InputStream is=MybatisUtils.class.getClassLoader().getResourceAsStream(resources);

        //构建sqlSession 的工厂
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        return factory;
    }
}