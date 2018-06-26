package action;

import mybatis.mapper.PersonMapper;
import mybatis.service.C3p0_Conn;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/*
 *
 *
 * 测试task1 25 26
 * 25.测试一下不关闭连接池的时候，在Main函数里写1000个循环调用会出现什么情况。
 * 26.测试一下连接DB中断后TryCatch是否能正常处理。
 * test : testDB();
 * 使用@方式获取连接
 * main方法
 *
 */

//自动化 测试运行器 打包测试，可以看到全部的测试结果
@RunWith(SpringJUnit4ClassRunner.class)
//注解方式获取xml配置
@ContextConfiguration(locations = {"classpath*:mybatis/springmybatis.xml"})
public class MybatisActionB {

    static Logger logger = Logger.getLogger(MybatisActionB.class.getName());

    @Autowired
    private PersonMapper personMapper;

    @Test
    public void testAction(){
//        System.out.print(personMapper.selectById(1));
//        logger.debug(personMapper.selectById(1));


    }

//    查找
    @Test
    public void testDaoSuport(){
        logger.debug("\n \n" + personMapper.selectById(5) + "\n \n");
    }

//    查找全部
    @Test
    public void testFindAll(){
       List<mybatis.model.Person> list = personMapper.findAll();
       System.out.print("\nlist的长度为：" + list.size() + "\n" +list.toString() + "\n");

    }


//    以下使用数据池测试
//    测试不关闭连接池和关闭连接池的循环插入，异常抓取
    @Test
    public void testDB(){

        String sql = "select name from jnshu_user where id = ?";

        C3p0_Conn c3p0_conn = new C3p0_Conn();
        Connection conn = null;
        PreparedStatement pstmt = null;

        for (int i=0;i<1000;i++){
            try {

                conn = c3p0_conn.getConn();
//                System.out.print("\n测试 ==" + sql + "==测试\n");
                pstmt = conn.prepareStatement(sql);
//                pstmt = (PreparedStatement) c3p0_conn.getConn().prepareStatement(sql);
                pstmt.setInt(1,i);
                ResultSet resultSet = pstmt.executeQuery();
                while (resultSet.next()){
                    logger.info("\n第" + (i+1) + "次查询，名字为：" + resultSet.getString("name") + "\n");
                }

                pstmt.close();

                resultSet.close();

            } catch (SQLException e) {
                e.printStackTrace();
                logger.debug("\n查询数据库异常\n");
            }finally {
                if (conn != null){
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }


//    根据列名/属性查找 user表
    @Test
    public void testFindByName(){

        String sql = "update jnshu_user set stu_num = ? WHERE id = ?";

        String findbyid = "select * from jnshu_user where id = ? ";

        C3p0_Conn c3p0_conn = new C3p0_Conn();

        Connection conn = c3p0_conn.getConn();

        try {


            PreparedStatement ps = conn.prepareStatement(sql);

            PreparedStatement p2 = conn.prepareStatement(findbyid);

            ps.setInt(1,2235);
            ps.setInt(2,4);
            p2.setInt(1,4);

            ResultSet resultSet = p2.executeQuery();
            while (resultSet.next()){

                logger.info("\n=========\n" + resultSet.getString("name") + "，学号为 " + resultSet.getInt("stu_num") + "\n=========\n" );

            }
            ps.executeUpdate();

            resultSet = p2.executeQuery();

            while (resultSet.next()){
                logger.info("\n=========\n" + resultSet.getString("name") + "，学号为 " + resultSet.getInt("stu_num") + "\n=========\n" );
            }

            resultSet.close();
            ps.close();
            p2.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn!=null){
                c3p0_conn.closeConn(conn);
            }
        }


    }








}
