package fourth.imple;

import fourth.com.*;
import fourth.Dao.studentDao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;

public class createStudent implements studentDao{
    @Override
    public int addStudent(student student) {
        Connection conn = null;
        PreparedStatement ps = null;
        int i= 0;
        try {
            conn = (Connection) mysqlConnect.getconnection();
            String sql = "insert into student values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            ps = (PreparedStatement) conn.prepareStatement(sql);

            ps.setInt(1,student.getId());
            ps.setString(2,student.getCreate_at());
            ps.setString(3,student.getUpdate_at());
            ps.setString(4,student.getName());
            ps.setString(5,student.getDailyLink());
            ps.setInt(6,student.getQQ());
            ps.setString(7,student.getOnlineNumber());
            ps.setString(8,student.getMail());
            ps.setInt(9,student.getPhone());
            ps.setString(10,student.getEnrollmentTime());
            ps.setString(11,student.getProfessionType());
            ps.setString(12,student.getBrotherName());
            ps.setString(13,student.getPromise());

            i = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mysqlConnect.free(null,ps, conn);
            System.out.println("close mysqlConnection");
        }
        return i;
    }

    @Override
    public int updateStudent(String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        int i = 0;
        try {
            conn = (Connection) mysqlConnect.getconnection();
            String sql = "update student set promise = '一姐最胖' where name=?";
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1,name);

            i = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mysqlConnect.free(null,ps, conn);
            System.out.println("close mysqlConnection");
        }
        return i;
    }

    @Override
    public int deleteStudent(String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        int i = 0;
        try {
            conn = (Connection) mysqlConnect.getconnection();
            String sql = "delete from student where name=?";

            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1,name);
            i = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mysqlConnect.free(null,ps,conn);
            System.out.println("close mysqlConnection");
        }
        return i;
    }

    @Override
    public student findStudent(student student) {
        Connection conn = null;
        PreparedStatement ps = null;
        student stu = null;
        ResultSet rs = null;
        try {
            conn = (Connection) mysqlConnect.getconnection();
            String sql = "select * from student where ID=? ";
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1,student.getId());
            rs = ps.executeQuery() ;
            stu = new student();
            while (rs.next()){
                stu.setId(rs.getInt(1));
                stu.setCreate_at(rs.getString(2));
                stu.setUpdate_at(rs.getString(3));
                stu.setName(rs.getString(4));
                stu.setDailyLink(rs.getString(5));
                stu.setQQ(rs.getInt(6));
                stu.setOnlineNumber(rs.getString(7));
                stu.setMail(rs.getString(8));
                stu.setPhone(rs.getInt(9));
                stu.setEnrollmentTime(rs.getString(10));
                stu.setProfessionType(rs.getString(11));
                stu.setBrotherName(rs.getString(12));
                stu.setPromise(rs.getString(13));

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mysqlConnect.free(null,ps,conn);
        }
        return student;
    }

}
