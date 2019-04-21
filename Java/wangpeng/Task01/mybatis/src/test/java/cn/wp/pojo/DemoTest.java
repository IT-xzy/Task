/**
 * Author: 老王
 * Date: 2019/4/13 23:17
 */
package cn.wp.pojo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class DemoTest {
    //创建SqlSessionFactory对象
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws Exception {
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //加载mybatis-config.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config1.xml");

        //使用SqlSessionFactory对象返回配置文件中的加载内容
        this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    @Test
//    根据ID查找
    public void testQueryDemoById() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Object Demo = sqlSession.selectOne("queryDemoById", 2);

        System.out.println(Demo);

        sqlSession.close();
    }

    @Test
    public void findAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        

        System.out.println();
        sqlSession.commit();

        sqlSession.close();
    }
    @Test
//    增
    public void add() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Demo de = new Demo();
        de.setId(4);
        de.setName("托尼");
        de.setQq(111);
        de.setSchool("师范学院");

        sqlSession.insert("add", de);

        System.out.println(de);

        sqlSession.commit();

        sqlSession.close();
    }
}
