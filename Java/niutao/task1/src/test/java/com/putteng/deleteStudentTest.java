package com.putteng;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class deleteStudentTest {
    //MyBatis的session工厂。
    private SqlSessionFactory factory;
    @Before
    //在初始化方法中配置文件，构建工厂
    public void init() throws IOException {
        //读取配置文件
        String resource = "mybatis-config.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建回话工厂，传入配置信息
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testdelete(){
        SqlSession session = null;
        try {
            //获取session对象
            session = factory.openSession();
            //创建映射代理
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            //调用删除
            studentMapper.deleteStudent(10);
            //提交事务
            session.commit();
        }catch(Exception e){
            System.out.println("Fales");
        }finally{
            //关闭资源
            session.close();
        }
    }
}
