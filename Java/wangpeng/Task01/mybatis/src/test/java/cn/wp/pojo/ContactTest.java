/**
 * Author：老王
 * Time：2019/3/28 19:06
 **/

package cn.wp.pojo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class ContactTest {

    //创建SqlSessionFactory对象
    private SqlSessionFactory sqlSessionFactory;

    //初始化方法，对于每一个测试方法都要执行一次（注意与BeforeClass区别，后者是对于所有方法执行一次）
    @Before
    public void init() throws Exception {
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //加载mybatis-config.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        //使用SqlSessionFactory对象返回配置文件中的加载内容
        this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    @Test
//    根据ID查找
    public void testQueryContactById() throws Exception {
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

       /* 执行SqlSession对象执行查询，获取Contact
         第一个参数是ContactMapper.xml的statement的id，第二个参数是执行sql需要的参数；*/

        Object Contact = sqlSession.selectOne("queryContactById", 1);

        //打印结果
        System.out.println(Contact);

        //释放资源
        sqlSession.close();
    }

    @Test
//    模糊查找
    public void testQueryContactByName() throws Exception {
        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //使用SqlSession对象执行查询，获取User
        List<Object> list = sqlSession.selectList("queryContactByGender", "女");

        //打印结果
        for (Object Contact : list) {
            System.out.println(Contact);
        }

        //释放资源
        sqlSession.close();
    }

    @Test
//    增
    public void testAddContact() throws Exception {
        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //使用SqlSession对象执行添加语句，创建需要保持的User对象
        Contact cat = new Contact();
        cat.setID(12);
        cat.setName("托尼");
        cat.setEmail("adhaui@udb.con");
        cat.setQQ(1111);
        cat.setGender("男");
        sqlSession.insert("addContact", cat);

        //打印结果
        System.out.println(cat);

        //进行事务提交
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    @Test
//    改
    public void testUpdateContact() throws Exception {
        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //使用SqlSession对象执行更改语句，创建需要更爱的Contact对象
        Contact cat = new Contact();
        cat.setID(2);
        cat.setName("MaiKe");
        cat.setEmail("abcd@efg.con");
        cat.setQQ(2222);
        cat.setGender("男");
        sqlSession.update("updateContact", cat);

        //打印结果
        System.out.println(cat);

        //进行事务提交
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    @Test
//    删
    public void testDeleteContact() throws Exception {
        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //使用SqlSession对象执行删除语句
        Object Contact = sqlSession.delete("deleteContactById", 2);

        //打印结果
        System.out.println(Contact);

        //进行事务提交
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }
}
