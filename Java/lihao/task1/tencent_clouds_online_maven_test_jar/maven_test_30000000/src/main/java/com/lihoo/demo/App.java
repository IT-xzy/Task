package com.lihoo.demo;


import com.lihoo.demo.utils.C3P0Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;


/**
 * @author lihoo
 * @Title: com.lihoo.demo.test.App
 * @ProjectName maven_test_4
 * @Description: maven 测试用例
 * @date 2018/7/21-13:43
 */


public class App {
    private static Logger logger = LogManager.getLogger("DebugLogger");
    public static void main(String[] args) {

        App app = new App();
//        app.query_foo_1();
        app.add_foo_1();


    }





//    public void query_foo_1() {
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        long startTime = System.currentTimeMillis();
//
//        try {
//            /*
//              * 1. 连接数据库,给con赋值
//              * 2. 准备SQL语句
//              * 3. 调用 Connection对象的方法来得到PrepareStatement对象
//              * 4. 使用PrepareStatement对象给sql参数赋值
//              * 5. 使用PrepareStatement对象向数据库发送sql语句，并且返回ResultSet对象的结果集（就是一个表）
//              * 6. 调用ResultSet的boolean next()方法 遍历结果集的每行记录，方法返回的true和false代表光标指针所指的这一行有没有记录
//              * 7. 调用ResultSet的getXXX(第几列)/getXXX("列名字")方法  返回当前行记录的列数据。其中，getObject和getString 能够获得所有的类型
//              * 8. 关闭资源。 后创建的先关闭
//              */
//            int count = 0;
//            conn =C3P0Utils.getConnection();
//            String sql = "SELECT * FROM student WHERE username=?";
//            // 关闭自动提交事务
//            conn.setAutoCommit(false);          //启动事务处理
//
//            pstmt = conn.prepareStatement(sql);
//
//            logger.debug("#############调用开始##############");
//            for (int i = 0; i < 1000000; i++) {
//            logger.debug("循环调用_尝试开始第" + (i+1) + "次调用");
//                pstmt.setString(1,"玛里苟斯");
//
//
//                rs = pstmt.executeQuery();
//                while (rs.next()) {
//                    String name = rs.getString("username");
//                    String pwd = rs.getString("password");
//                    String email = rs.getString("email");
//                    String bio = rs.getString("bio");
//                    String fav = rs.getString("favourite_section");
//                    System.out.println("名字"+name+",密码"+pwd+",email"+email+",个人简历"+bio+",最爱"+fav);
////                    logger.debug(rs.getString("username"));
//
//                }
//                pstmt.addBatch();       //调用批处理:缓存起来,然后一次性执行
//                count++;
//                if (i%250000 == 0 && i>0) {
//                    pstmt.executeBatch();
//
//                    //如果不想出错后，完全没保留数据，则可以没执行一次提交一次，但得保证数据不会重复
//                    conn.commit();
//
////                    pstmt.clearBatch();
//                }
//                System.out.println("第"+(i+1)+"次循环查询");
//            }
//            pstmt.executeBatch();
//            pstmt.clearBatch();
//
//            conn.commit();
//
//            logger.debug("查询了"+count+"条数据");
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            C3P0Utils.releaseConnection(conn,pstmt,rs);
//        }
//
//        logger.debug("调用结束");
//
//        long endTime = System.currentTimeMillis();
//        logger.debug("耗时："+(endTime - startTime)/1000 +"秒");
//
//    }

    private  void add_foo_1() {
        /*
         * 增、删、改
         */
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        long startTime = System.currentTimeMillis();

        try {
            /*
             * 1. 连接数据库,给con赋值
             * 2. 准备SQL语句
             * 3. 调用 Connection对象的方法来得到PrepareStatement对象
             * 4. 使用PrepareStatement对象给sql参数赋值
             * 5. 使用PrepareStatement对象向数据库发送sql语句，并且返回影响记录的行数
             * 6. 关闭资源。 后创建的先关闭
             */
            int count = 0;
            conn = C3P0Utils.getConnection();
            String sql = "INSERT INTO addTest2(username,password,create_at,update_at) VALUES (?,?,?,?)";//sql语句中不加分号
//            String sql = "UPDATE author SET password=? WHERE username=?";
//            String sql = "DELETE FROM author WHERE username=?";

            // 关闭自动提交事务
            conn.setAutoCommit(false);

            pstmt = conn.prepareStatement(sql);

            logger.debug("#############调用开始##############");
            for (int i = 0; i < 30000000; i++) {
//                pstmt.setInt(1,i);
                pstmt.setString(1,"砰砰博士"+(i+1));
                pstmt.setString(2,"pwd"+(i+1));
                pstmt.setInt(3,i+1);
                pstmt.setInt(4,i+100);

                pstmt.addBatch();       //调用批处理:缓存起来,然后一次性执行
                count++;
                if (i%300000 == 0) {
                    pstmt.executeBatch();

                    //如果不想出错后，完全没保留数据，则可以没执行一次提交一次，但得保证数据不会重复
                    conn.commit();

                    pstmt.clearBatch();
                }
//                logger.debug("第"+(i+1)+"次循环插入");
                System.out.println("第"+(i+1)+"次循环插入");
            }
            pstmt.executeBatch();
            pstmt.clearBatch();
            conn.commit();
            logger.debug("添加了" + count + "条数据");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Utils.releaseConnection(conn,pstmt,rs);
        }


        long endTime = System.currentTimeMillis();
        logger.debug("耗时："+(endTime - startTime)/1000 +"秒");
    }


}

