import com.jdbctemplate.pojo.Person;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/*
 *
 * 纯粹练习
 *
 */
public class TestPractice {


    public static void main(String[] args){

        Logger logger = Logger.getLogger(TestPractice.class.getName());

        Connection conn;

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://119.29.17.188/jnshu";
        String user = "root";
        String password = "root";
        String sql = "select * from person";

        try {

            conn = (Connection) DriverManager.getConnection(url,user,password);

            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Person> list = new ArrayList<Person>();

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
                System.out.print(person.toString() + "\n");
                list.add(person);
            }

            logger.debug(list);

            conn.close();
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



    //    时间相关测试
    @Test
    public void testDate(){

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        //获取系统当前年份
        int year=calendar.get(Calendar.YEAR);
        //获取系统当前月份
        int month = calendar.get(Calendar.MONTH) + 1;
        //获取系统当然日期
        int day = calendar.get(Calendar.DATE);
        //获取系统当前小时
        int hour = calendar.get(Calendar.HOUR);
        //获取系统当然分钟
        int minute = calendar.get(Calendar.MINUTE);
        //获取系统当前秒数
        int second = calendar.get(Calendar.SECOND);

//        获取毫秒数的时间戳 13位
        System.out.print("\n" + date.getTime() + "\n");
//        获取当前时间
        System.out.print("\n" + df.format(date) + "\n");
//        转化时间戳
        System.out.print("\n" + df.format(date.getTime()) + "\n");

        Date now = new Date();
        long strNow = now.getTime();
        long strSystem =  System.currentTimeMillis();
        SimpleDateFormat stm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.print(strNow + "\n");
        System.out.print(strSystem + "\n");

        String str1 = stm.format(now);
        String str2 = stm.format(strNow);

        System.out.print( now + "\n");
        System.out.print( str1 + "\n");
        System.out.print( str2 + "\n");

    }
}
