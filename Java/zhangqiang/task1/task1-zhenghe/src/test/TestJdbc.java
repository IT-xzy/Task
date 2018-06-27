import com.jdbctemplate.pojo.Person;
import com.jdbctemplate.pojo.User;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/*
 * jdbc的增改查询
 *
 *  未使用spring
 *  只用了pojo类
 *  26.测试一下连接DB中断后TryCatch是否能正常处理。
 *  测试db断开的异常抓取 testDBClose()
 *
 */

public class TestJdbc {

    static Logger logger = Logger.getLogger(TestJdbc.class.getName());

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://119.29.17.188/jnshu?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private static String user = "root";
    private static String password = "root";

//    private static Connection conn = null;

    public static void main(String[] args) throws SQLException {

        Connection conn = null;

        String sql = "select * from person";

        try {

            Class.forName(driver);

            conn = DriverManager.getConnection(url,user,password);

//            PreparedStatement preparedStatement = (PreparedStatement) conn.createStatement();
            Statement preparedStatement = conn.createStatement();

            ResultSet resultSet =  preparedStatement.executeQuery(sql);

            while (resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setSex(resultSet.getInt("sex"));
                person.setEmail(resultSet.getString("email"));
                person.setPro(resultSet.getString("pro"));
                person.setQq(resultSet.getInt("qq"));
                person.setTell(resultSet.getInt("tell"));
                person.setStu_num(resultSet.getInt("stu_num"));

                System.out.print(person.toString() + "\n");
            }

            preparedStatement.close();

            resultSet.close();

        } catch (SQLException e) {

            System.out.print("\nSQL异常\n");
            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            System.out.print("\nClassNotFoundException,Class未找到异常\n");
            e.printStackTrace();

        }finally {

            if (conn != null){
                conn.close();
            }
        }


    }


//  查询全部
    @Test
    public void select() throws SQLException {

//        List<Person> list = new ArrayList<Person>();

        Connection conn = null;

        PreparedStatement pstmt = null;

        String sql = "select * from person";

        try {

            conn = DriverManager.getConnection(url,user,password);
            pstmt = conn.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setSex(resultSet.getInt("sex"));
                person.setEmail(resultSet.getString("email"));
                person.setPro(resultSet.getString("pro"));
                person.setQq(resultSet.getInt("qq"));
                person.setTell(resultSet.getInt("tell"));
                person.setStu_num(resultSet.getInt("stu_num"));

//                list.add(person);
                System.out.print("\n" +
                        "id :" + resultSet.getInt("id") + "," +
                        "name :" + resultSet.getString("name") + "," +
                        "age :" + resultSet.getInt("age") + "," +
                        "sex :" + resultSet.getInt("sex") + "," +
                        "email :" + resultSet.getString("email") + "," +
                        "pro :" + resultSet.getString("pro") + "," +
                        "qq :" + resultSet.getInt("qq") + "," +
                        "tell :" + resultSet.getInt("tell") + "," +
                        "stu_num :" + resultSet.getInt("stu_num") + "\n"
                );
            }

            pstmt.close();

            resultSet.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn!=null){
                conn.close();
            }
        }

    }



//    测试插入数据
    @Test
    public void insert() throws SQLException {


        Connection conn = null;

        PreparedStatement preparedStatement;

        String sql = "INSERT INTO person (name,age,sex,pro,tell,qq,email,stu_num) values (?,?,?,?,?,?,?,?) ";

        Person p = new Person();
//        借用传参 测试插入
        p.setName("jdbc插入数据");
        p.setQq(5123);
        p.setAge(25);
        p.setEmail("835@35.com");
        p.setPro("jdbc插入数据");
        p.setSex(1);
        p.setTell(186000);
        p.setStu_num(9865);

        try {

            conn = DriverManager.getConnection(url,user,password);

            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1,p.getName());
            preparedStatement.setInt(2,p.getAge());
            preparedStatement.setInt(3,p.getSex());
            preparedStatement.setString(4,p.getPro());
            preparedStatement.setInt(5,p.getTell());
            preparedStatement.setInt(6,p.getQq());
            preparedStatement.setString(7,p.getEmail());
            preparedStatement.setInt(8,p.getStu_num());

            preparedStatement.executeUpdate();

            preparedStatement.close();

//            select();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn!=null){
                conn.close();
            }
        }
    }


//    删除数据
    @Test
    public void delete() throws SQLException {

        int id = 43;

        Connection conn = null;

        PreparedStatement preparedStatement;

        String sql = "delete from person where id=?";

        try {

            conn = DriverManager.getConnection(url,user,password);

            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();

            preparedStatement.close();

//            select();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("\n删除数据失败\n");
        }finally {
            if (conn!=null){
                conn.close();
            }
        }


    }

//  修改数据
    @Test
    public void update() throws SQLException {

        int id = 42;

        Connection conn = null;

        PreparedStatement preparedStatement = null;

        String sql = "UPDATE person SET name=?,age=?,sex=?,pro=?,tell=?,qq=?,email=?,stu_num=? WHERE id=?";

        Person p = new Person();
        //            借用传递的参数 修改属性测试
        p.setId(id); //修改时的where条件
        p.setName("jdbc修改的");
        p.setQq(87523);
        p.setAge(25);
        p.setEmail("8749@12.com");
        p.setPro("我也是jdbc修改的数据");
        p.setSex(1);
        p.setTell(186000);
        p.setStu_num(9876);

        try {

            conn = DriverManager.getConnection(url,user,password);

            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1,p.getName());
            preparedStatement.setInt(2,p.getAge());
            preparedStatement.setInt(3,p.getSex());
            preparedStatement.setString(4,p.getPro());
            preparedStatement.setInt(5,p.getTell());
            preparedStatement.setInt(6,p.getQq());
            preparedStatement.setString(7,p.getEmail());
            preparedStatement.setInt(8,p.getStu_num());
            preparedStatement.setInt(9,p.getId());

    //            执行修改
            preparedStatement.executeUpdate();

            preparedStatement.close();

            select();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("\n插入数据失败\n");
        }finally {
            if (conn!=null){
                conn.close();
            }
        }

    }

//    测试关闭连接的异常抓取
    @Test
    public void testDBClose(){

        Connection connection = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2= null;
        ResultSet resultSet = null;

        String sql = "insert into person (name,age,sex,pro) values (?,?,?,?)";
        String sqlselect = "select * from person ";

        try {

            Class.forName(driver);
            connection = DriverManager.getConnection(url,user,password);
            pstmt = connection.prepareStatement(sql);
            pstmt2=connection.prepareStatement(sqlselect);

            for(int i=0;i<5;i++){

                User us1 = new User();

                us1.setName( i + "师兄");
                us1.setAge(i);
                us1.setSex(1);
                us1.setPro((i+1) + "师兄");

                pstmt.setString(1,us1.getName());
                pstmt.setInt(2,us1.getAge());
                pstmt.setInt(3,us1.getSex());
                pstmt.setString(4,us1.getPro());

                logger.info(String.valueOf(pstmt.executeUpdate()));

                resultSet = pstmt2.executeQuery();

                while (resultSet.next()){

                    logger.info("\n" + resultSet.getString("name") + "\n");
                }

//                测试断开db连接
                if (i==3){
                    connection.close();
                }

            }

            if (connection != null){
                connection.close();
            }

            pstmt.close();

            resultSet.close();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();
            System.err.print("\nClassNotFound异常\n");

        } catch (SQLException e) {

            e.printStackTrace();
            System.err.print("\n数据库断开连接\n");
        }


    }


















}
