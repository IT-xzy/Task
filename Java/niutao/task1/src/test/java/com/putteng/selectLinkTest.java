package com.putteng;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class selectLinkTest {
    //MyBatis的session工厂。
    private SqlSessionFactory factory;

    @Before
    //再初始化方法中配置文件，构建工厂
    public void init() throws IOException {
        //读取配置文件
        String resource = "mybatis-config.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建回话工厂，传入配置信息
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testselectlink() throws Exception {
        //获取session对象
        SqlSession session = factory.openSession();
        //创建映射代理
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        //调用查询
        //String link = studentMapper.fingdLinkById(1);
        String link = studentMapper.fingdLinkByName("牛涛");

        //关闭资源
        session.close();
        System.out.println(link);
    }
}
