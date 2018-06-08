package Task4;

import Task4.mapper.PositionMapper;
import Task4.mapper.UserMapper;
import Task4.pojo.Position;
import Task4.pojo.User;
import Task4.service.PositionService;
import Task4.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) //加载配置文件
public class test4 {
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
        user.setQQ(7456645);
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
}

