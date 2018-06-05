import com.zyq.domain.Student;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LinuxConnectTest {

    @Test
    public void testSelectAll(){
        Connection conn = getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();
        String sql = "select * from application";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getLong(1));
                student.setName(rs.getString("name"));
                student.setQq(rs.getInt(3));
                student.setProfession(rs.getString(4));
                student.setUniversity(rs.getString(5));
                student.setNumber(rs.getInt(6));
                student.setDaily(rs.getString(7));
                student.setSenior(rs.getString(8));
                student.setFrom(rs.getString(9));
                student.setCreateTime(rs.getLong(10));
                student.setUpdateTime(rs.getLong(11));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(conn,pst,rs);
        }
        for (Student student:list) {
            System.out.println(student);
        }
    }

    public  void close(Connection conn, PreparedStatement pst, ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pst!=null){
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection(){
        String URL = "jdbc:mysql://localhostLinux:3306/myjava?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
        String USER = "root";
        String PASSWORD = "314317";
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
