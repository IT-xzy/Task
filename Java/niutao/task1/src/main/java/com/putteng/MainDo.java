package com.putteng;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.InputStream;

public class MainDo {
    public static void main(String[] args) {
        SqlSession session = null;
        try {
            //MyBatis的session工厂。
            SqlSessionFactory factory;

            //读取配置文件
            String resource = "mybatis-config.xml";
            //得到配置文件流
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //创建回话工厂，传入配置信息
            factory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取session对象
            session = factory.openSession();
            //创建映射代理
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            //调用查询
            Student student = studentMapper.findStudentById(1);
            System.out.println(student);
        } catch (Exception e) {
            System.out.println("错误结果" + e);
        } finally {
            //关闭资源
            assert session != null;
            session.close();
        }

    }
}
