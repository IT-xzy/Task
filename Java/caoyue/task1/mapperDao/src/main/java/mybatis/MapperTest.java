/**
 * @author Arike
 * Create_at  2017/11/20 9:38
 *                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                            O\ = /O
//                        ____/`---'\____
//                      .   ' \\| |// `.
//                       / \\||| : |||// \
//                     / _||||| -:- |||||- \
//                       | | \\\ - /// | |
//                     | \_| ''\---/'' | |
//                      \ .-\__ `-` ___/-. /
//                   ___`. .' /--.--\ `. . __
//                ."" '< `.___\_<|>_/___.' >'"".
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |
//                 \ \ `-. \_ __\ /__ _/ .-` / /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//
//         .............................................
//                  佛祖保佑             永无BUG
//          佛曰:
//                  写字楼里写字间，写字间里程序员；
//                  程序人员写程序，又拿程序换酒钱。
//                  酒醒只在网上坐，酒醉还来网下眠；
//                  酒醉酒醒日复日，网上网下年复年。
//                  但愿老死电脑间，不愿鞠躬老板前；
//                  奔驰宝马贵者趣，公交自行程序员。
//                  别人笑我忒疯癫，我笑自己命太贱；
//                  不见满街漂亮妹，哪个归得程序员？
 */
//    private SqlSessionFactory sqlSessionFactory;
//
//    @Before //创建sqlSessionFactory
//    public void setUp() throws Exception {
//        String resource = "sqlMapConfig.xml"; //mybatis配置文件
//        //得到配置文件的流
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        //创建会话工厂SqlSessionFactory,要传入mybaits的配置文件的流
//        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//    }

//    @Test
//    public void testFindUserById() throws Exception {
//
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        User user = userMapper.findUserById(1);
//        System.out.println(user);
//    }

//    @Test
//    public void testFindUserByName() throws Exception {
//
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> list = userMapper.findUserByName("韩");
//        sqlSession.close();
//        System.out.println(list);
//    }

//    @Test
//    public void testDeleteUser() throws Exception {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        userMapper.deleteUser(10);
//        System.out.println("hello world");
//    }

//    @Test
//    public void testUpdateUser() throws Exception {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        User user = new User("倪升武");
//        user.setId(11);
//        sqlSession.update("mybatis.UserMapper.updateUser", user);
//        sqlSession.commit();//执行插入要先commit
//        sqlSession.close();
//    }
//
//    @Test
//    public void insertUser() throws Exception {
//        long start=System.currentTimeMillis();
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        for(int i = 0; i < 1000000; i++) {
//            User user=new User("韩");
//            sqlSession.insert("mybatis.UserMapper.insertUser",user);
//            sqlSession.commit();
//        }
//
//        sqlSession.close();
//        long end=System.currentTimeMillis();
//        System.out.println("程序运行时间： "+(end-start)/1000+"S");
//    }
package mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class MapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) throws IOException {
        long start=System.currentTimeMillis();
                String resource = "sqlMapConfig.xml"; //mybatis配置文件
        //得到配置文件的流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂SqlSessionFactory,要传入mybaits的配置文件的流
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user=new User("韩","梁家键","前端工程师");
//        int aa =  Integer.valueOf(args[0]);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你需要循环的次数：");
        int aa = sc.nextInt();
        for (int s=0;s<=aa;s++){
            sqlSession.insert("mybatis.UserMapper.insertUser",user);
            sqlSession.commit();
        }
        sqlSession.close();
        long end=System.currentTimeMillis();
        long a = user.getId();
        System.out.println(a);
        System.out.println("程序运行时间： "+(end-start)/1000+"S");
    }
}

