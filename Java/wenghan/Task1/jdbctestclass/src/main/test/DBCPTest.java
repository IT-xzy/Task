

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCPTest {
    //测试,每写一条数据前,就新建一个连接
    @Test
    public void testWriteDBByEveryConn() throws Exception{
        for(int i = 0; i < 1000; i++){//循环2000次
            writeDBByEveryConn(i);//不使用连接池，创建一个连接，使用后关闭连接
        }
        System.out.println("DONE");//循环结束后输出完成
    }

    //测试,使用连接池,每写一条数据前,从连接池中获取一个连接
    @Test
    public void testWriteDBByDBCP() throws Exception{
        Connection con=null;
        for(int i = 0; i <1000000; i++){//循环2000次
            writeDBByDBCP(i,con);//将循环整数传入函数作为记录的字段
        }
        System.out.println("DONE");//循环结束后输出完成
    }

    //测试,只建一条连接,写入所有数据
    @Test
    public void testWriteDBByOneConn() throws Exception{
        Connection conn = DBConn.getConnection();//获得一个不使用连接池管理的连接
        Statement stat = conn.createStatement();//通过连接获得操作数据库的对象
        for(int i = 0; i < 1000000; i++){//循环2000次
            writeDBByOneConn(i, stat);//将循环整数传入函数作为记录的字段，同时传入一个操作数据库对象
        }
        conn.close();//关闭连接
        System.out.println("DONE");//循环结束后输出完成
    }

    //测试使用连接池，获得1000个连接，不释放连接的情况
    @Test
    public void testGetManyConnectio()throws Exception{
        for (int i=0;i<1000;i++){
            KCYDBCPUtil.getConnection();
        }
    }

    //不使用连接池写数据库,每写一条数据创建一个连接
    public void writeDBByEveryConn(int data){
        String sql = "insert into student (create_at) values (" + data + ")";//sql语句
        Connection conn = DBConn.getConnection();//通过java自带数据源生成连接
        try{
            Statement stat = conn.createStatement();//通过连接生成数据库操作对象
            stat.executeUpdate(sql);//导入操作对象，进行添加操作
        }catch(Exception e){
            e.printStackTrace() ;
        }finally{
            try {
                conn.close();//关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    //不使用连接池写数据库,只用一个连接,写所有数据
    public void writeDBByOneConn(int data, Statement stat){//使用传入的操作数据库对象来操作数据库
        String sql = "insert into student (create_at) values (" + data + ")";
        try{
            stat.executeUpdate(sql);//通过数据库操作对象执行添加操作
        }catch(Exception e){
            e.printStackTrace() ;
        }
    }

    //通过DBCP连接池写数据库
    public void writeDBByDBCP(int data,Connection con ){
        String sqlinsert = "insert into student (create_at) values (" + data + ")";
        String sqlupdate = "UPDATE student SET create_at = (" + data + ") WHERE create_at = (" + data + ")";
        String sqlselct = "SELECT create_at FROM student";
        String sqldelete = "DELETE FROM student WHERE create_at = (" + data + ")";
        try {
                con = KCYDBCPUtil.getConnection();//通过连接池类获得被连接池管理的连接
                Statement stat = con.createStatement();//通过连接获得操作数据库的对象
                stat.executeUpdate(sqlupdate);//通过操作对象执行添加记录操作
                con.commit();//提交事务
                con.close();//释放连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
