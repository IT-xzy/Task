package cc.myhome.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StuDAO {
    private String url;
    private String user;
    private String passwd;             //数据库连接协议

    public StuDAO(String url, String user, String passwd) {
        this.url = url;
        this.user = user;
        this.passwd = passwd;

    }

    //实现增加一个条目方法
    public void add(Stu stu) {
        try (Connection conn = DriverManager.getConnection(url, user, passwd);
                /*Statement statement = conn.createStatement();*/ PreparedStatement statement2 = conn.prepareStatement(
                "INSERT INTO network1 (Name, QQ, Type, Enrolment_time, Graduate, Report_link, Wish," +
                        "Senior, How_know, Create_at, Update_at) VALUES (?,?,?,?,?,?,?,?,?,?,?)")) {
            statement2.setString(1, stu.getName());
            statement2.setString(2, stu.getQQ());
            statement2.setString(3, stu.getType());
            statement2.setString(4, stu.getTime());
            statement2.setString(5, stu.getSchool());
            statement2.setString(6, stu.getLink());
            statement2.setString(7, stu.getWish());
            statement2.setString(8, stu.getSenior());
            statement2.setString(9, stu.getHow());
            statement2.setLong(10, stu.getCreate());
            statement2.setLong(11, stu.getUpdate());
            statement2.executeUpdate();

           /* String sql = String.format("INSERT INTO network1 VALUES " +
                            "('%d','%s','%s','%s','%s','%s','%s','%s','%s','%s','%d','%d')",
                    stu.getLine_id(), stu.getName(), stu.getQQ(), stu.getType(), stu.getTime(), stu.getSchool(),
                    stu.getLink(), stu.getWish(), stu.getSenior(), stu.getHow(), stu.getCreate(), stu.getUpdate());
            statement.executeUpdate(sql);                                           //此处可以尝试取得返回的int类型   */
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


    //查询所有数据方法
    public List<Stu> getAll() {
        List<Stu> stus = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, passwd);
             Statement statement = conn.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * FROM network1");    //注意，不用加；
            while (result.next()) {
                Stu stu = toStu(result);
                stus.add(stu);

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);      //注意此处ex要加括号
        }
        return stus;
    }

    public Stu toStu(ResultSet result) throws SQLException {
        Stu stu = new Stu();
        stu.setLine_id(result.getLong("Line_id"));
        stu.setName(result.getString("Name"));
        stu.setQQ(result.getString(3));
        stu.setType(result.getString(4));
        stu.setTime(result.getString(5));
        stu.setSchool(result.getString(6));
        stu.setLink(result.getString(7));
        stu.setWish(result.getString(8));
        stu.setSenior(result.getString(9));
        stu.setHow(result.getString(10));
        stu.setCreate(result.getLong(11));
        stu.setUpdate(result.getLong(12));
        return stu;

    }

    //根据ID查询单个条目方法
    public Stu getById(long id) {
        Stu stu = new Stu();
        try(Connection conn = DriverManager.getConnection(url, user, passwd);
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM network1 WHERE Line_id = ?")){
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            result.next();                                                 //这句话非常重要！！！！
            stu = toStu(result);
            return stu;

        } catch(SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    //根据姓名查询结果方法
    public List<Stu> getByName(String name) {
        List<Stu> stus = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, passwd);
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM network1 WHERE Name = ?")) {
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Stu stu = toStu(result);
                stus.add(stu);

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return stus;
    }

}

