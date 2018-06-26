package service;

import action.JdbcAction;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import model.Student;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JdbcCurd {

    static Logger logger = Logger.getLogger(JdbcAction.class.getName());

    static String url = "jdbc:mysql://www.mydb.com/jnshu?useUnicode=true&characterEncoding=UTF-8&useSSL=false&rewriteBatchedStatements=true";
    static String user = "root";
    static String pwd = "root";

    static String driver = "com.mysql.jdbc.Driver";

    private Connection conn = null;
    private java.sql.PreparedStatement pstmt = null;
    private ResultSet rs = null;

    SimpleDateFormat stm = new SimpleDateFormat("yyyy年MM月dd日");

    public Student selectById(int id){

        String sql = "SELECT * from student where id = ?";

        Student student = new Student();

        try {

            conn = (Connection) DriverManager.getConnection(url,user,pwd);

            pstmt = (PreparedStatement) conn.prepareStatement(sql);

            pstmt.setInt(1,id);

            rs = pstmt.executeQuery();

            RandomStudent rStudent = new RandomStudent();

            while (rs.next()){
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setQq(rs.getLong("qq"));
                student.setType(rs.getInt("type"));
                student.setStartTime(rs.getString("start_time"));
                student.setSchool(rs.getString("school"));
                student.setStuNum(rs.getInt("stu_num"));
                student.setDailyLink(rs.getString("daily_link"));
                student.setPro(rs.getString("pro"));
                student.setBrother(rs.getString("brother"));
                logger.info("\n" +
                        "id :" + rs.getInt("id") + "\n" +
                        "姓名 :" + rs.getString("name") + "\n" +
                        "QQ :" + rs.getLong("qq") + "\n" +
                        "修真类型 :" + rStudent.getTypeString(rs.getInt("type")) + "\n" +
                        "开始时间 :" + rs.getString("start_time") + "\n" +
                        "毕业院校 :" + rs.getString("school") + "\n" +
                        "线上学号 :" + rs.getInt("stu_num") + "\n" +
                        "日报链接 :" + rs.getString("daily_link") + "\n" +
                        "立愿 :" + rs.getString("pro")  + "\n" +
                        "师兄 :" + rs.getString("brother") + "\n"
                );
            }

            pstmt.close();

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("查询错误！");
        }finally {
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

        return student;

    }

    public List<Student> findAll() {

        String sql = "SELECT * from student";

        List<Student> students = new ArrayList<>();

        try {

            conn = (Connection) DriverManager.getConnection(url,user,pwd);

            pstmt = (PreparedStatement) conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCont = rsmd.getColumnCount();
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setQq(rs.getLong("qq"));
                student.setType(rs.getInt("type"));
                student.setStartTime(rs.getString("start_time"));
                student.setSchool(rs.getString("school"));
                student.setStuNum(rs.getInt("stu_num"));
                student.setDailyLink(rs.getString("daily_link"));
                student.setPro(rs.getString("pro"));
                student.setBrother(rs.getString("brother"));
                students.add(student);
            }

            pstmt.close();

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }

        return students;
    }


    public List<Student> findByStudent(Student student){

        List<Student> students = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.delete(0,sql.length());
        sql.append("SELECT * from student where 1=1 ");
        if(student.getName()!=null && !student.getName().equals(""))sql.append("AND name LIKE '%" + student.getName() + "%'");
        if(student.getSchool()!=null && !student.getSchool().equals(""))sql.append("AND school LIKE '%" + student.getSchool() + "%'");
        if(student.getStuNum()!=0)sql.append("AND stu_num = " + student.getStuNum());
        if(student.getQq()!=0)sql.append("AND qq LIKE '%" + student.getQq() + "%'");
        if(student.getType()!=0)sql.append("AND stu_num = '%" + student.getType() + "%'");
        if(student.getStartTime()!=null && !student.getStartTime().equals(""))sql.append("AND start_time LIKE '%" + student.getStartTime() + "%'");
        if(student.getPro()!=null && !student.getPro().equals(""))sql.append("AND pro LIKE '%" + student.getPro() + "%'");
        if(student.getBrother()!=null && !student.getBrother().equals(""))sql.append("AND brother LIKE '%" + student.getBrother() + "%'");

        try {

            conn = (Connection) DriverManager.getConnection(url,user,pwd);

            pstmt = conn.prepareStatement(sql.toString());

            rs = pstmt.executeQuery();

            while (rs.next()){
                Student stu = new Student();
                stu.setId(rs.getInt("id"));
                stu.setName(rs.getString("name"));
                stu.setQq(rs.getLong("qq"));
                stu.setType(rs.getInt("type"));
                stu.setStartTime(rs.getString("start_time"));
                stu.setSchool(rs.getString("school"));
                stu.setStuNum(rs.getInt("stu_num"));
                stu.setDailyLink(rs.getString("daily_link"));
                stu.setPro(rs.getString("pro"));
                stu.setBrother(rs.getString("brother"));
                students.add(stu);
            }

            pstmt.close();

            rs.close();

            return students;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("查询错误！");
        }finally {
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

        return students;

    }



    public int insert(Student student){

        StringBuilder stuBuilder = new StringBuilder();

        int scu = 0;
        try {

            Class.forName("com.mysql.jdbc.Driver");

            conn = (Connection) DriverManager.getConnection(url,user,pwd);

            stuBuilder.delete(0,stuBuilder.length());
            stuBuilder.append("INSERT INTO student (name,create_at,update_at,qq,type,start_time,school,stu_num,daily_link,pro,brother) values ");

            stuBuilder.append("('" + student.getName()  + "'," +
                    student.getCreate_at() + "," +
                    student.getUpdate_at() + "," +
                    student.getQq() + "," +
                    student.getType() + ",'" +
                    student.getStartTime() + "','" +
                    student.getSchool() + "'," +
                    student.getStuNum() + ",'" +
                    student.getDailyLink() + "','" +
                    student.getPro() + "','" +
                    student.getBrother() + "')"
            );

            pstmt = conn.prepareStatement(stuBuilder.toString(),Statement.RETURN_GENERATED_KEYS);
            scu = pstmt.executeUpdate();

//            conn.commit();

            if(scu!=0){
                rs = pstmt.getGeneratedKeys();
                if(rs.next()){
                    logger.info("新插入的数据id：" + rs.getInt(1));
                }
                System.out.print("添加数据成功！执行" + scu + "条");
                rs.close();
            }else {
                System.out.print("添加失败！执行" + scu + "条");
            }

            if(pstmt!=null){
                pstmt.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("添加错误！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return scu;
    }



    public void insertList(){

        StringBuilder stuBuilder = new StringBuilder();
        RandomStudent ranStudent = new RandomStudent();

        try {

            Class.forName("com.mysql.jdbc.Driver");

            conn = (Connection) DriverManager.getConnection(url,user,pwd);

            stuBuilder.delete(0,stuBuilder.length());
            stuBuilder.append("INSERT INTO student (name,create_at,update_at,qq,type,start_time,school,stu_num,daily_link,pro,brother) values ");
            int xtime = 10;
            for(int i=0;i<xtime;i++){
                if(i>0)stuBuilder.append(",");
                stuBuilder.append("('" + ranStudent.getNameBuilder().toString() + "'," +
                        System.currentTimeMillis() + "," +
                        System.currentTimeMillis() + "," +
                        ranStudent.getQq() + "," +
                        ranStudent.getType() + ",'" +
                        stm.format(System.currentTimeMillis()) + "','" +
                        ranStudent.getSchool() + "'," +
                        ranStudent.getStuNum() + "," +
                        "'http://www.jnshu.com'" + ",'" +
                        ranStudent.getPro() + "','" +
                        ranStudent.getNameBuilder().toString() + "')"
                );
            }

            pstmt = (PreparedStatement) conn.prepareStatement(stuBuilder.toString());

            pstmt.executeUpdate();

//            conn.commit();

            if(pstmt!=null){
                pstmt.close();
            }
            if(rs!=null){
                rs.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("添加错误！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public int insertList(List<Student> list ) throws SQLException {

        StringBuilder stuBuilder = new StringBuilder();

        int scu = 0;
        try {

            Class.forName("com.mysql.jdbc.Driver");

            conn = (Connection) DriverManager.getConnection(url,user,pwd);

            stuBuilder.delete(0,stuBuilder.length());
            stuBuilder.append("INSERT INTO student (name,create_at,update_at,qq,type,start_time,school,stu_num,daily_link,pro,brother) values ");

            for(int i=0;i<list.size();i++){
                if(i>0)stuBuilder.append(",");
                stuBuilder.append("('" + list.get(i).getName() + "'," +
                        list.get(i).getName() + "," +
                        list.get(i).getCreate_at() + "," +
                        list.get(i).getUpdate_at() + "," +
                        list.get(i).getQq() + ",'" +
                        list.get(i).getType() + "','" +
                        list.get(i).getStartTime() + "'," +
                        list.get(i).getSchool() + "," +
                        list.get(i).getStuNum() + ",'" +
                        list.get(i).getDailyLink() + "','" +
                        list.get(i).getPro() + "','" +
                        list.get(i).getBrother() + "')"
                );
            }

            pstmt = conn.prepareStatement(stuBuilder.toString());

            scu = pstmt.executeUpdate();

            if(scu!=0){
                System.out.print("添加数据成功！执行" + scu + "条");
            }else {
                System.out.print("添加失败！执行" + scu + "条");
            }
//            conn.commit();

            if(pstmt!=null){
                pstmt.close();
            }
            if(rs!=null){
                rs.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("添加错误！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (conn!=null){
                conn.close();
            }
        }
        return scu;
    }


    public int update(Student student) throws SQLException {

        StringBuilder stuBuilder = new StringBuilder();
        int scu = 0;
        try {

            selectById(student.getId());

            conn = (Connection) DriverManager.getConnection(url,user,pwd);

            stuBuilder.delete(0,stuBuilder.length());

            stuBuilder.append("UPDATE student SET name='" +
                    student.getName() + "',update_at=" +
                    student.getUpdate_at() + ",qq=" +
                    student.getQq() + ",type=" +
                    student.getType() + ",start_time='" +
                    student.getStartTime() + "',school='" +
                    student.getSchool() + "',stu_num=" +
                    student.getStuNum() + ",daily_link=" +
                    student.getDailyLink() + ",pro='" +
                    student.getPro() + "',brother='" +
                    student.getBrother() + "'"
            );
            stuBuilder.append(" WHERE id=" + student.getId());

            pstmt = (PreparedStatement) conn.prepareStatement(stuBuilder.toString());

            scu = pstmt.executeUpdate();


            if(scu!=0){
                selectById(student.getId());
                System.out.print("修改成功！执行" + scu + "条");
            }else {
                System.out.print("修改失败！执行" + scu + "条");
            }

//            conn.commit();
            if(pstmt!=null){
                pstmt.close();
            }
            if(rs!=null){
                rs.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("修改错误！");
        } finally {
            if (conn!=null){
                conn.close();
            }
        }

        return student.getId();

    }


    public int delete(int id) throws SQLException {

        StringBuilder stuBuilder = new StringBuilder();
        int scu = 0;

        try {

            conn = (Connection) DriverManager.getConnection(url,user,pwd);

            stuBuilder.delete(0,stuBuilder.length());

            stuBuilder.append("DELETE FROM student WHERE id=" + id);

            pstmt = (PreparedStatement) conn.prepareStatement(stuBuilder.toString());

            scu = pstmt.executeUpdate();

            if(scu!=0){
                System.out.print("删除成功！执行" + scu + "条");
            }else {
                System.out.print("删除失败！执行" + scu + "条");
            }

//            conn.commit();

            if(pstmt!=null){
                pstmt.close();
            }
            if(rs!=null){
                rs.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("删除失败！");
        } finally {
            if (conn!=null){
                conn.close();
            }
        }
        return scu;
    }







}
