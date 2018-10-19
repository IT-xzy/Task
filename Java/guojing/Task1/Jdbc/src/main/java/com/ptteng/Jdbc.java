package com.ptteng;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Jdbc {
    //定义一个方法，获取数据库连接
    public Connection getConn() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/renwuyi?characterEncoding=utf-8";
        String user = "root";
        String password = "123456";
//        通过反射加载驱动
        Class.forName(driver);
//        通过数据库信息（地址，用户名，密码）获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
//        返回连接
        return conn;
    }


    public long insertUser(User user) throws SQLException, ClassNotFoundException {
//          应用占位符问号的方式写SQL语句
        String sql = "insert into student (name,QQ,wish,createAt,updateAt) values (?,?,?,?,?)";
//        预编译SqL语句，并设置返回主键
        PreparedStatement ps = getConn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//       对占位符设置值，1,2，3代表占位符的位置，后面的参数是占位符的值
        ps.setString(1, user.getName());
        ps.setLong(2, user.getQQ());
        ps.setString(3, user.getWish());
        ps.setLong(4, user.getCreateAt());
        ps.setLong(5, user.getUpdateAt());
//        执行插入操作
        ps.executeUpdate();
//      获取生成的主键
        ResultSet rst = ps.getGeneratedKeys();
        long id = 0;
        while (rst.next()) {
//           获取新插入主键id，1代表返回主键，2代表不返回主键
            id = rst.getLong(1);
        }
//  关闭结果集，关闭预编译，关闭理解
        rst.close();
        ps.close();
        getConn().close();
        return id;
    }


    public List<User> findAll() throws SQLException, ClassNotFoundException {
        String sql = "select * from student";
        PreparedStatement ps = getConn().prepareStatement(sql);
        ResultSet rst = ps.executeQuery();
        List<User> users = new ArrayList<>();
        while (rst.next()) {
            User user = new User();
//          将查询的结果按照列信息设置为实体类的值
            user.setName(rst.getString("name"));
            user.setQQ(rst.getLong("QQ"));
            user.setWish(rst.getString("wish"));
            user.setCreateAt(rst.getLong("createAt"));
            user.setUpdateAt(rst.getLong("updateAt"));
            user.setId(rst.getLong("id"));
//          将从结果集获取的信息整合为一个数组
            users.add(user);
        }
        ps.close();
        getConn().close();
        return users;
    }


    public List<User> findById(long id) throws SQLException, ClassNotFoundException {
        String sql = "select * from student where id=?";
        PreparedStatement ps = getConn().prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rst = ps.executeQuery();
        List<User> users = new ArrayList<>();
        while (rst.next()) {
            User user = new User();
            user.setName(rst.getString("name"));
            user.setQQ(rst.getLong("QQ"));
            user.setWish(rst.getString("wish"));
            user.setUpdateAt(rst.getLong("createAt"));
            user.setUpdateAt(rst.getLong("updateAt"));
            user.setId(rst.getLong("id"));
            users.add(user);
        }
        ps.close();
        getConn().close();
        return users;
    }


    public boolean updateUser(User user) throws SQLException, ClassNotFoundException {
        String sql = "update student set name=?,QQ=?,wish=?,createAt=?,updateAt=? where id=?";
        PreparedStatement ps = getConn().prepareStatement(sql);
        ps.setString(1, user.getName());
        ps.setLong(2, user.getQQ());
        ps.setString(3, user.getWish());
        ps.setLong(4, user.getCreateAt());
        ps.setLong(5, user.getUpdateAt());
        ps.setLong(6, user.getId());
        boolean row = false;
        int i = ps.executeUpdate();
        if (i == 1) {
            row = true;
        } else {
            row = false;
        }
        ps.close();
        getConn().close();
        return row;
    }


    public boolean deleteUser(long id) throws SQLException, ClassNotFoundException {
        String sql = "delete from student where id=?";
        PreparedStatement ps = getConn().prepareStatement(sql);
        ps.setLong(1, id);
        boolean row = false;
        int i = ps.executeUpdate();
        if (i == 1) {
            row = true;
        } else {
            row = false;
        }
        ps.close();
        getConn().close();
        return row;
    }
}
