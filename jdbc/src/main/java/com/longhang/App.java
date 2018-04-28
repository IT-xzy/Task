package com.longhang;
import org.apache.log4j.Logger;
import java.sql.*;

class Test
{
    private static Logger logger = Logger.getLogger(Test.class);
    private static Connection getConn() //私有封装方法
    { Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");//获取jdbc驱动器
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?characterEncoding=UTF-8", "root", "123456");//获取url本地数据库连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    private static int insert(Long id,String name,String qq,String wish ,long create_at)
    {
        Connection conn =getConn();
        int pste=0;
        String sql="insert into student(id,name,qq,wish,create_at)values(?,?,?,?,?)";
        PreparedStatement pst= null;//预编译sql对象  PreparedStatement
        try {
            pst = (PreparedStatement)conn.prepareStatement(sql);
            pst.setLong(1,id);
            pst.setString(2,name);
            pst.setString(3,qq);
            pst.setString(4,wish);
            pst.setLong(5,create_at);
            pste=pst.executeUpdate();
        }
        catch (SQLException e) {
        e.printStackTrace();
    }
        try {
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Long(id).intValue();
    }
    private static boolean update(int id,String wish) throws SQLException//根据id修改wish
    {
        Connection conn =getConn();
        int pstex=0;
        String sql= "update student set wish='"+wish+"'where id='"+id+"'";
        PreparedStatement psts=(PreparedStatement)conn.prepareStatement(sql);
        pstex=psts.executeUpdate();
        psts.close();
        conn.close();
        return (pstex>0);


    }
    private  static void select()throws SQLException
    {
        Connection conn = getConn();
        String sql = "select * from student";
        PreparedStatement pstm = (PreparedStatement)conn.prepareStatement(sql);
        ResultSet rs= pstm.executeQuery();
        while(rs.next())
        {
            int id=rs.getInt("id");
            String name=rs.getString("name");
            String qq=rs.getString("qq");
            String wish=rs.getString("wish");
            long create_at=rs.getLong("create_at");
            logger.info("id:"+id+"name:"+name+"qq:"+qq+"wish:"+wish+"create_at:"+create_at);

        }
    }
    private static boolean delete(int id)//根据id删除数据
    {
        Connection conn = getConn();
        int psex = 0;
        String sql = "delete from student where id='" + id + "'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            psex = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (psex>0);
    }

        public static void main(String[] args) throws SQLException {
        Test test= new Test();
       for(int x=1;x<10;x++)
        {
        test.insert(Long.valueOf(x),"大刘","12365487","我很帅",2015);}
        logger.info(test.insert(10L,"大刘","12365487","我很帅",2015));
        logger.info(test.delete(6));
//        test.update(3,"小鸡炖蘑菇");
        test.select();

    }
}



