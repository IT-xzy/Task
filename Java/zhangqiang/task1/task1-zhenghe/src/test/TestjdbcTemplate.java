import com.jdbctemplate.daoservice.UserDaoImpl;
import com.jdbctemplate.pojo.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 *  Spring JdbcTemplate 测试类
 *
 *  类：java/com.jdbctemplate
 *
 *  xml:resource/jdbctemplate/applicationtext.xml
 *
 *  表:jnshu_user
 *
 */

public class TestjdbcTemplate {

        static Logger logger = Logger.getLogger(TestjdbcTemplate.class.getName());

//        private static ApplicationContext context = new ClassPathXmlApplicationContext("jdbctemplate/applicationcontext.xml");
//        UserDaoImpl userDaoimp = (UserDaoImpl) context.getBean("userService");

        public static void main(String[] args){

                try {

                        ApplicationContext conn = new ClassPathXmlApplicationContext("jdbctemplate/applicationcontext.xml");

                        UserDaoImpl userDaoimp = (UserDaoImpl) conn.getBean("userService");

                        logger.info("\n" + userDaoimp.findAll() + "\n");

                        logger.info("\n 总数据：" + userDaoimp.selectCount() + " 条\n");

                }catch (Exception e){

                        logger.debug("\n\n  main error execption e \n\n");

                        e.fillInStackTrace();
                }
        }

//      改/删 并查询总数 jnshu_user表
        @Test
        public void testTemlpalte(){

                ApplicationContext conn = new ClassPathXmlApplicationContext("jdbctemplate/applicationcontext.xml");
//                applicationcontext.xml里定义的bean ，不使用注解扫描自动注册就需要在xml里注册
                UserDaoImpl userDaoimp = (UserDaoImpl) conn.getBean("userService");

                logger.info( "\n未修改前:\n" + userDaoimp.selectById(99) + "\n\n");
                logger.info("\n总数据：" + userDaoimp.selectCount() + "条\n");

                long time = new Date().getTime();

//                User user = new User();
//                user.setId(99);
//                user.setName("王大锤");
//                user.setUpdate_at(time);
//                user.setAge(1);
//                user.setPro("我已经走上人生巅峰！！");
//                user.setBrother("我兄弟是赵日天！！");
//                userDaoimp.updateUser(user);
//                logger.info( "\n修改后:  " + userDaoimp.selectById(99) + "\n");
//
//                userDaoimp.delectUser(99);

                logger.info("\n总数据：" + userDaoimp.selectCount() + "条\n");


        }

//        查询
        @Test
        public void select(){

                int id = 66;

                ApplicationContext context = new ClassPathXmlApplicationContext("jdbctemplate/applicationcontext.xml");

                UserDaoImpl userDaoimp = (UserDaoImpl) context.getBean("userService");

                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");

                User u = userDaoimp.selectById(id);

                System.out.print("\n" +
                        " id :" + u.getId() + "," +
                        " 姓名 :" + u.getName() + "," +
                        " 毕业院校 :" + u.getSchool() + "," +
                        " 修真学号 :" + u.getStu_num() + "," +
                        " 修真类型 :" + u.getType() + "," +
                        " qq :" + u.getQq() + "," +
                        " 年龄 :" + u.getAge() + "," +
                        " 性别 :" + u.getSex() + "," +
                        " 宣言 :" + u.getPro() + "," +
                        " 日志链接 :" + u.getDaily_link() + "," +
                        " 师兄 :" + u.getBrother() + "," +
                        " 入学时间 :" + u.getStart_time() + "\n" +
                        " 创建时间 :" + dateFormat.format(u.getCreate_at()) + "\n" +
                        " 上次修改 :" + dateFormat.format(u.getUpdate_at()) + "\n"
                );

        }

//        插入数据
        @Test
        public void insert(){

                ApplicationContext context = new ClassPathXmlApplicationContext("jdbctemplate/applicationcontext.xml");

                UserDaoImpl userDaoimpl = (UserDaoImpl) context.getBean("userService");

                Date now = new Date();

                long times = now.getTime();

                User user = new User();
                user.setName("jdbcTemplate插入的数据");
                user.setSchool("spring科技学院");
                user.setCreate_at(times);
                user.setUpdate_at(times);
                user.setStu_num(2222);
                user.setType(3);
                user.setQq(5128423);
                user.setAge(22);
                user.setSex(1);
                user.setPro("jdbc老大哥");
                user.setDaily_link("没有!");
                user.setBrother("我兄弟是大橘子！！");
                user.setStart_time("不知道!");

                int backKey = userDaoimpl.insertUser(user);
//                返回参数(id值)
                logger.info(backKey);
        }

//        批量插入数据
        @Test
        public void insertLiset(){

                ApplicationContext context = new ClassPathXmlApplicationContext("jdbctemplate/applicationcontext.xml");

                UserDaoImpl userDaoimpl = (UserDaoImpl) context.getBean("userService");

                Date date = new Date();

                List<User> users = new ArrayList<>();
                for(int j=0;j<5;j++){
                        for(int i=0;i<5;i++){
                                User u = new User();
                                u.setName("第" + j + "次第" + i + "号");
                                u.setCreate_at(date.getTime());
                                u.setUpdate_at(date.getTime());
                                u.setSex(1);
                                u.setAge(20);
                                users.add(u);
                        }
                }

                userDaoimpl.insertList(users);

        }
//        修改
        @Test
        public void update(){

                ApplicationContext context = new ClassPathXmlApplicationContext("jdbctemplate/applicationcontext.xml");

                UserDaoImpl userDaoimpl = (UserDaoImpl) context.getBean("userService");

                Date now = new Date();

                User user = new User();
                user.setId(66);
                user.setName("王大锤");
                user.setUpdate_at(now.getTime());
                user.setSchool("锤子科技学院");
                user.setStu_num(4675);
                user.setType(5);
                user.setQq(51275123);
                user.setAge(21);
                user.setSex(1);
                user.setPro("我已经走上人生巅峰！！");
                user.setDaily_link("没有!");
                user.setBrother("我兄弟是赵日天！！");
                user.setStart_time("不知道!");

                userDaoimpl.updateUser(user);

                select();
        }


//        删除
        @Test
        public void delete(){

                int id = 66;

                ApplicationContext context = new ClassPathXmlApplicationContext("jdbctemplate/applicationcontext.xml");

                UserDaoImpl userDaoimpl = (UserDaoImpl) context.getBean("userService");

                userDaoimpl.delectUser(id);

        }



}
