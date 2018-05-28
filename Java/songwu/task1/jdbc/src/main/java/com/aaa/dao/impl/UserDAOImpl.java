package com.aaa.dao.impl;

import com.aaa.dao.UserDAO;
import com.aaa.model.User;
import com.aaa.utils.C3p0Utils;

//import com.aaa.utils.JDBCUtils2;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;



//实现接口类
public class UserDAOImpl implements UserDAO {

//    需要学习的获得更改表的时间
//    s1.setUpdate_at(System.currentTimeMillis()/1000);


    //    初始化变量
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
//重写父类方法，实现insert具体操作


    public int insert(User user) {
        // TODO Auto-generated method stub
//        初始化返回行数
        int row = 0;// 影响的行数,返回0表示插入失败，返回1表示插入成功
//        try catch 方法用于捕获异常，和处理在解决范围的异常
        try {


//            建立与数据库的连接
            connection = C3p0Utils.getConnection();
            String sql = "INSERT INTO user1 VALUES(?,?,?,?)";
//        创建预编译执行语句，先编译再一起执行
            preparedStatement = connection.prepareStatement(sql);
//          通过调用，preparedStatement的set方法确定values后面具体的字段名，避免参数的混乱
            preparedStatement.setObject(1, user.getId());
            preparedStatement.setObject(2, user.getName());
            preparedStatement.setObject(3, user.getPassword());
            preparedStatement.setObject(4, user.getBirth());
//            executeUpdate方法会返回受影响行数，已确定是否插入成功
            row = preparedStatement.executeUpdate();

//如果不能建立连接就会catch异常，并打印到输出台中
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            C3p0Utils.free(resultSet, preparedStatement, connection);
        }


        return row;
    }

    //根据id查询
    public int update(User user) {
        // TODO Auto-generated method stub
        int row = 0;
        try {
            connection =  C3p0Utils.getConnection();
            String sql = "UPDATE user1 SET name = ?,password = ?, birth = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setObject(1, user.getName());
            preparedStatement.setObject(2, user.getPassword());
            preparedStatement.setObject(3, user.getBirth());
            preparedStatement.setObject(4, user.getId());

            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            C3p0Utils.free(resultSet, preparedStatement, connection);
        }

        return row;
    }

    //根据id删除
    public int delete(int userId) {
        // TODO Auto-generated method stub
        int row = 0;
        try {
            connection = C3p0Utils.getConnection();
            String sql = "DELETE FROM user1  WHERE id =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, userId);
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            C3p0Utils.free(resultSet, preparedStatement, connection);
        }
        return row;
    }

    //根据id查询
    public User queryById(int userId) {
        User user = new User();

        try {
            connection =  C3p0Utils.getConnection();
            String sql = "SELECT * FROM user1 WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, userId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setBirth(resultSet.getString(4));
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        finally {
            C3p0Utils.free(resultSet, preparedStatement, connection);
        }
        return user;
    }

    //查询整个表
    public List<User> queryAll() {
//        通过多态创建list类型的ArrayList对象实例
        List<User> users = new ArrayList<User>();
        User user = null;
        // TODO Auto-generated method stub
        try {
            connection = C3p0Utils.getConnection();
            String sql = "SELECT * FROM  user1";
            preparedStatement = connection.prepareStatement(sql);
//    executeQuery方法返回代表查询结果集的resultSet对象
            resultSet = preparedStatement.executeQuery();
//            遍历整个结果集
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setBirth(resultSet.getString(4));
//                对于每行结果集的列都通过集合方法添加进user对象
                users.add(user);
                //  System.out.println(users);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            C3p0Utils.free(resultSet, preparedStatement, connection);
        }
        return users;

    }
//批量插入
    public void insertBatch(User user) {
        try {
            connection =  C3p0Utils.getConnection();
            String sql = "insert into User1 values (?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            for (int i = 0; i < 30000000; i++) {
                preparedStatement.setObject(1, user.getId());
                preparedStatement.setObject(2, user.getName());
                preparedStatement.setObject(3, user.getPassword());
                preparedStatement.setObject(4, user.getBirth());
                preparedStatement.addBatch();

           if (i%1000==0){
                preparedStatement.executeBatch();}
            }
  preparedStatement.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            C3p0Utils.free(resultSet, preparedStatement, connection);
        }

    }

    public static void main(String[] args) {
        UserDAO userDAO=new UserDAOImpl();
        long start=System.currentTimeMillis();
        for (int i = 390867; i < 1390867; i++) {

            System.out.println(userDAO.queryById(i));
        }
        User user = new User();
        user.setName("晖");
        user.setPassword("qaq");
        user.setBirth("2000.1.1");
        userDAO.insertBatch(user);
        userDAO.insertBatch(user);
        long end=System.currentTimeMillis();
        System.out.println(end-start);

    }

}
