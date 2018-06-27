package cn.wyq.jdbc;

import cn.wyq.log.HelloLog4j;
import cn.wyq.pojo.Student;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;

public class JdbcImpl implements StudentDao{
    Logger logger = Logger.getLogger(JdbcImpl.class);
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sqltest?characterEncoding=UTF-8", "root",
                "password");
    }
    @Override
    public void insert(Student s) {
//        PropertyConfigurator.configure("D:\\ideaproject\\myproject\\src\\main\\resources\\log4j.properties");
        String sql = "insert into student values(null,?,?,?,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {

            ps.setString(1, s.name);
            ps.setString(2, s.type);
            ps.setString(3, s.school);
            ps.setString(4,s.pledge);
            ps.setInt(5,s.createTime);
            ps.setInt(6,s.updateTime);
            ps.setInt(7,s.siblingId);
            ps.setString(8,s.siblingName);

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            logger.info("输出信息：");
            if (rs.next()) {
                int id = rs.getInt(1);
                s.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(s);
    }

    @Override
    public void update(Student s) {
        String sql = "update student set name= ?,type= ?, school= ?, pledge= ?, create_at= ?, update_at= ?, " +
                "sibling_id= ?, sibling_name= ? where id = ? ";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {

            ps.setString(1, s.name);
            ps.setString(2, s.type);
            ps.setString(3, s.school);
            ps.setString(4, s.pledge);
            ps.setInt(5, s.createTime);
            ps.setInt(6, s.updateTime);
            ps.setInt(7, s.siblingId);
            ps.setString(8,s.siblingName);
            ps.setInt(9,s.id);

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            logger.info("输出信息：");
            if (rs.next()) {
                int id = rs.getInt(1);
                s.id = id;
            }
            System.out.println(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
//        PropertyConfigurator.configure("D:\\ideaproject\\myproject\\src\\main\\resources\\log4j.properties");
        try (Connection c = getConnection(); Statement s = c.createStatement();) {

            String sql = "delete from student where id = " + id;

//            s.execute(sql);
            boolean i = s.execute(sql);
            logger.info("输出信息：");
            if(i==true){
                System.out.println("删除成功！");
            }else{
                System.out.println("删除失败，您删除的数据不存在！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student get(int id) {
        PropertyConfigurator.configure("D:\\ideaproject\\myproject\\src\\main\\resources\\log4j.properties");
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        Student s = (Student) context.getBean("s");
        try (Connection c = getConnection(); Statement statement = c.createStatement();) {

            String sql = "select * from student where id = " + id;

            ResultSet rs = statement.executeQuery(sql);
            logger.info("输出信息：");
            if (rs.next()) {
//                s = new Student();
                String name = rs.getString(2);
                String type = rs.getString(3);
                String school = rs.getString(4);
                String pledge = rs.getString(5);
                int createTime = rs.getInt(6);
                int updateTime = rs.getInt(7);
                int siblingId = rs.getInt(8);
                String siblingName = rs.getString(9);
                s.name = name;
                s.type = type;
                s.school = school;
                s.pledge = pledge;
                s.createTime = createTime;
                s.updateTime = updateTime;
                s.siblingId = siblingId;
                s.siblingName = siblingName;
            }
            System.out.printf("%d\t%s\t%s\t%s\t%s\t%d\t%d\t%d\t%s%n",
                    s.id,s.name,s.type,s.school,s.pledge,s.createTime,s.updateTime,s.siblingId,s.siblingName);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public List<Student> listname(String name) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        Student s = (Student) context.getBean("s");
        List<Student> list = new ArrayList<Student>();
        try (Connection c = getConnection(); Statement statement = c.createStatement();) {

            String sql = "select * from student where name = " + "'"+name+"'";

            ResultSet rs = statement.executeQuery(sql);
            logger.info("输出信息：");
            if (rs.next()) {
//                s = new Student();
                int id = rs.getInt(1);
                String type = rs.getString(3);
                String school = rs.getString(4);
                String pledge = rs.getString(5);
                int createTime = rs.getInt(6);
                int updateTime = rs.getInt(7);
                int siblingId = rs.getInt(8);
                String siblingName = rs.getString(9);
                s.id = id;
                s.type = type;
                s.school = school;
                s.pledge = pledge;
                s.createTime = createTime;
                s.updateTime = updateTime;
                s.siblingId = siblingId;
                s.siblingName = siblingName;
                list.add(s);
            }
//            System.out.printf("%d\t%s\t%s\t%s\t%s\t%d\t%d\t%d\t%s%n",
//                    s.id,s.name,s.type,s.school,s.pledge,s.createTime,s.updateTime,s.siblingId,s.siblingName);
            if(null == list||list.size()==0) {
                System.out.println("您输入的数据不存在，请确认后再输入！");
            }else {
                System.out.println(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
