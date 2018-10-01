package mapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.text.SimpleDateFormat;
import java.util.Date;

public class main {


    public static void main(String[] args)throws Exception {

        ApplicationContext context =
        new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper =(UserMapper) context.getBean("userMapper");

        //这是第一种方法,字段类型为datetime类型,对应实体类中String型,直接获取的当前时间
   /*     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        User user = new User("杨腾东","18",date,date);*/



        //这是第二种方法,字段类型为bigint类型,对应实体类中long型,直接获取的当前时间戳
        User user =new User("杨腾东","12",System.currentTimeMillis(),System.currentTimeMillis());

        userMapper.Insert(user);
        System.out.println(user);
    }

}
