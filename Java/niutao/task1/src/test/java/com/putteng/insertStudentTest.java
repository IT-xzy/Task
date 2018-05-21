package com.putteng;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class insertStudentTest {
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
    public void testinsert(){
        SqlSession session=null;
        try {
            //获取session对象
            session = factory.openSession();
            //创建映射代理
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            //创建Student对象
            Student oneStudent = new Student();
            oneStudent.setName("牛涛");
            oneStudent.setQq("304584817");
            oneStudent.setclassId(1);
            oneStudent.setgraduateSchool("成都工业学院");
            oneStudent.setolineNumber("java-0263");
            oneStudent.setLink("http://www.jnshu.com/school/19263/class");
            oneStudent.setWish("好好学习，天天向上");
            oneStudent.setbrotherId(1);
            System.out.println(oneStudent);
            //调用插入
            studentMapper.insertStuden(oneStudent);
            session.commit();
            //输出id
            System.out.println(oneStudent.getId());
        }catch (Exception e){
            System.out.println("Fales");
        }finally {
            //关闭资源
            session.close();

        }


    }
}
