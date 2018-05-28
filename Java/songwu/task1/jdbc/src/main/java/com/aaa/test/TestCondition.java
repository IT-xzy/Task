package com.aaa.test;

import com.aaa.model.User;
import com.aaa.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestCondition {
//    ≤È—Ø
    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();
            Connection connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            String sql = "select * from user1 where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 390867; i < 1390867; i++) {
                preparedStatement.setObject(1, i);
                ResultSet resultSet = preparedStatement.executeQuery();
                User user = new User();
                while (resultSet.next()) {
                    user.setId(resultSet.getInt(1));
                    user.setName(resultSet.getString(2));
                    user.setPassword(resultSet.getString(3));
                    user.setBirth(resultSet.getString(4));
                    System.out.println(user);
                }

            }
            System.out.println(System.currentTimeMillis() - start);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

