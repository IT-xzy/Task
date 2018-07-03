import cn.jnshu.zcm.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisTest {
    @Test
    public void findUserByIdTest() throws IOException {

        String resource = "SqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById", 1);
        System.out.println(user);
        sqlSession.close();
    }


    //一条条插入
//    @Test
//    public void insertUserTest()throws IOException {
//
//        //mybatis配置文件
//        String resource = "SqlMapConfig.xml";
//
//        //得到配置文件流
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//
//        //创建会话工厂，传入mybatis的配置文件信息
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//        //通过工厂得到SqlSession
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        long start = System.currentTimeMillis();
//
//        for (int i = 0; i <10; i++) {
//            User user = new User();
//            user.setId(i);
//            user.setUsername("庄"+i);
//
//            sqlSession.selectList("test.insertUser", user);
////            //提交事务
////            sqlSession.commit();
//            System.out.println(user.getId());
//
//        }
//
////        sqlSession.insert(statement,userList);
//        //提交事务
//        sqlSession.commit();
//        long end = System.currentTimeMillis();
//        System.out.println("插入10数据所需时间" + (end - start)+"ms"+"="+((end - start)/1000)+"s");
//        sqlSession.close();
//    }
//}


    @Test
    public void insertUserTest() throws IOException {

        //mybatis配置文件
        String resource = "SqlMapConfig.xml";

        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();


        long start = System.currentTimeMillis();
        List<User> userList = new ArrayList<User>();
        try{
        for (int l = 0; l <1; l++) {
            for (int i =0; i < 100001; i++) {
                User user = new User();
                user.setId(i);
                user.setUsername("庄" + i);
                userList.add(user);
                System.out.println(user.getId());
                if (i % 100000 == 0) {
                    sqlSession.selectList("test.insertUser", userList);
                    userList.clear();//清空list
                }
            }
        }
        //提交事务
        sqlSession.commit();
//        sqlSession.close();
        long end = System.currentTimeMillis();
        System.out.println("插入1000000数据所需时间" + (end - start) + "ms" + "=" + ((end - start) / 1000) + "s");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            sqlSession.close();
        }
    }

    }








//    @Test
//    public void insertUserTest() throws IOException {
//
//        //mybatis配置文件
//        String resource = "SqlMapConfig.xml";
//
//        //得到配置文件流
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//
//        //创建会话工厂，传入mybatis的配置文件信息
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//        //通过工厂得到SqlSession
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//
//        long start = System.currentTimeMillis();
//        List<User> userList = new ArrayList<User>();
//        try{
//                    sqlSession.close();//关闭数据库连接
//            for (int l = 0; l <1; l++) {
//                for (int i =0; i < 100001; i++) {
//                    User user = new User();
//                    user.setId(i);
//                    user.setUsername("庄" + i);
//                    userList.add(user);
//                    System.out.println(user.getId());
//                    if (i % 100000 == 0) {
//                        sqlSession.selectList("test.insertUser", userList);
//                        userList.clear();//清空list
//                    }
//                }
//            }
//            //提交事务
//            sqlSession.commit();
//
//            long end = System.currentTimeMillis();
//            System.out.println("插入1000000数据所需时间" + (end - start) + "ms" + "=" + ((end - start) / 1000) + "s");
//        }
//        catch (Exception e) {
//            System.out.println("数据库异常");
//            e.printStackTrace();
//        }
//        finally {
//            sqlSession.close();
//        }
//    }
//
//}

