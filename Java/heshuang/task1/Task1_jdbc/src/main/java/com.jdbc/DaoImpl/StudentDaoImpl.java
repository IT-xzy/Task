package com.jdbc.DaoImpl;
import com.jdbc.Dao.StudentDao;
import com.jdbc.Pojo.Student;
import com.jdbc.Utils.JdbcUtils;

import java.sql.*;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void addStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getConnection();
            connection.setAutoCommit(false);
            String sql = "insert into students(create_at,name,qq,professional,start_time,university,online_id," +
                    "daily_url,oath,counselor,city)values(?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,student.getCreate_at());
            preparedStatement.setString(2,student.getName());
            preparedStatement.setString(3,student.getQq());
            preparedStatement.setString(4,student.getProfessional());
            preparedStatement.setString(5,student.getStart_time());
            preparedStatement.setString(6,student.getUniversity());
            preparedStatement.setInt(7,student.getOnline_id());
            preparedStatement.setString(8,student.getDaily_url());
            preparedStatement.setString(9,student.getOath());
            preparedStatement.setString(10,student.getCounselor());
            preparedStatement.setString(11,student.getCity());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()){
                long generatedKeysLong = generatedKeys.getLong(1);
                System.out.println(generatedKeysLong);
            }
            connection.commit();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtils.Close(null,preparedStatement,connection);
        }
    }

    @Override
    public boolean deleteStudent(int id) {
        boolean flag = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getConnection();
            connection.setAutoCommit(false);
            String sql = "delete FROM students WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            int i = preparedStatement.getUpdateCount();
            if (i != 0){
                flag = true;
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtils.Close(null,preparedStatement,connection);
        }
        System.out.println(flag);
        return flag;
    }
    @Override
    public boolean updateStudent(int id) {
        boolean flag = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getConnection();
            connection.setAutoCommit(false);
            String sql = "update students set name='校长' where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            int i = preparedStatement.getUpdateCount();
            if (i != 0){
                flag = true;
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtils.Close(null,preparedStatement,connection);
        }
        System.out.println(flag);
        return flag;
    }
    @Override
    public ResultSet findStudent(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();
            connection.setAutoCommit(false);
            String sql = "select id,online_id,city from students where name =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            connection.commit();
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id")+"-----"+resultSet.getString("online_id")+
                        "-----"+resultSet.getString("city"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.Close(null, preparedStatement, connection);
        }
        return resultSet;
    }

    @Override
    public ResultSet findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();
            connection.setAutoCommit(false);
            String sql = "select * from students";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id")+"----"+ resultSet.getString("create_at")+
                        "---- " +resultSet.getString("name")+"----"+resultSet.getString("qq")+"----"
                        +resultSet.getString("professional")+"----" +resultSet.getString("start_time")+
                        "----"+resultSet.getString("university")+"----"+resultSet.getInt("online_id")+"----"
                        +resultSet.getString("daily_url")+"----"+resultSet.getString("oath")+"----"
                        +resultSet.getString("counselor")+"----" +resultSet.getString("city"));
            }connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtils.Close(resultSet,preparedStatement,connection);
        }
        return resultSet;
    }

    @Override
    public ResultSet findStudentByOlin_id(int online_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();
            connection.setAutoCommit(false);
            String sql = "select id,name,city from students where online_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,online_id);
            resultSet = preparedStatement.executeQuery();
            connection.commit();
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id")+"-----"+resultSet.getString("name")+"----"
                +resultSet.getString("city"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtils.Close(resultSet,preparedStatement,connection);
        }
        return resultSet;
    }
}
