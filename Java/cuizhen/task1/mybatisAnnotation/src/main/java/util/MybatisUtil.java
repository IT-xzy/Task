package util;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisUtil {
    public static SqlSessionFactory getFactory(){
        String resource="mybatis-config.xml";
        //加载mybatis 的配置文件（它也加载关联的映射文件）
        InputStream inputStream=MybatisUtil.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession 的工厂
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
}
