package Task4;

import Task4.mapper.PositionMapper;
import Task4.mapper.UserMapper;
import Task4.pojo.Position;
import Task4.pojo.User;
import Task4.service.PositionService;
import Task4.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) //加载配置文件
public class test4 {

    //引入spring的配置文件获取上下文
//    private static ApplicationContext context =new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    //通过上下文和bean的名字获取userMapper实例
//    private static UserMapper userMapper=context.getBean(UserMapper.class);
    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PositionService positionService;

    @Autowired
    PositionMapper positionMapper;


    @Test
    public void findByStudy0(){
        System.out.println(userService.findByStudy());
    }
    @Test
    public void findByLastone1(){
        System.out.println(userService.findAll());
    }
    @Test
    public void add() throws Exception {
        User user =new User();

        user.setName("小王");
        user.setIntroduce("我也是这么觉得");
        user.setMajor("java");
        user.setSex("男");
        user.setUsername("555");
        user.setPassword("555");
        user.setEmail("345345");
        user.setQQ("7456645");
        user.setStatus("work");

        for(int i = 0; i < 20; i++){
            userService.add(user);
        }

    }
    @Test
    public void findbyname() throws Exception{
        Position position =positionService.findByClass("JAVA");
        System.out.println(position);
    }
    @Test
    public void list() {
        List<Position> position= positionService.list();
        System.out.println(position);
    }

    @Test
    public void List(){
        ArrayList list =new ArrayList<>(10);
        for (int i = 1;i <= positionService.findAll();i++){
            list.add(positionService.findById(i));

        }
        System.out.println(list.get(0));
    }
    @Test
    public void all(){
        System.out.println(positionService.findAll());
    }
    @Test
    public void findbyid(){
        System.out.println(positionService.findById(2));
    }
    @Test
    public void test2(){
    String str = "bunanpo2";
    String pattern = "^[a-zA-Z0-9]{8,16}$";
    ///^\w+@\w+(\.\w+)+$/ 邮箱
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(str);
    boolean confirm = m.matches();
//    System.out.println(confirm);
    if(confirm){
        System.out.println(1);
    }else {
        System.out.println(2);
    }
    System.out.println(confirm);
    }
    @Test
    public void findbyusername() throws Exception {
        System.out.println(userService.findByUsername("luojiachao111"));
    }
//    @Test
//    public void test23() {
//        //任何除数不能为0 ArithmeticException
//     User user=userService.findByUsername("ssdasd");
//    }
    @Test
    public void test22()  {
        //任何除数不能为0 ArithmeticException
//        int i =2/0;

        //下标越界 ArrayIndexOutOfBoundsException
//        int t[]=new int[5];
//        t[10]=10;

        //空指针异常 NullPointerException
        String str = null;
        str.length();
    }
    @Test
    public void tt() throws Exception {
        User user=userMapper.findByPhone("15058434942");
        System.out.println(user);
    }

    }



