import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.User;
import service.UserService;

import java.util.Date;

public class UserDaoTest {
    private UserService userService;

    @Before
    public void before() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = (UserService) context.getBean("UserService");
    }

    @After
    public void after() throws Exception{

    }
    //查询id
    @Test
    public void getUserById() {
        try {
            System.out.println(userService.findUserById(1));
        }catch (Exception e) { System.out.println("错误:" + e);
        }
    }

    //插入数据
    @Test
    public void insertUser(){
        User user = new User();
        /*user.setId(3);*/
        user.setName("路飞");
        user.setQq("1003410156");
        user.setMajor("船长");
        user.setStartTime(new Date(System.currentTimeMillis()));
        user.setSchool("新大陆");
        user.setOnlint_id(66666);
        user.setDaily_linke("123123");
        user.setDesire("我是要成为海贼王的男人");
        user.setBre("蒙奇D路飞");
        user.setKnow_from("爱奇艺独播");
        user.setCreate_at(new Date(System.currentTimeMillis()));
        user.setUpdate_at(new Date(System.currentTimeMillis()));
        try{
            userService.insertUser(user);
        }catch (Exception e) {
            System.out.println("错误" + e);
        }
        System.out.println("当前插入的id"+ user.getId());
    }


    //删除
    @Test
    public void deleteId(){
        try{
            System.out.println(userService.deleteUser(2));
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //查询全部id
    @Test
    public void AllId(){
        try {
            System.out.println((userService.AllId()));
        }catch (Exception e){
            System.out.println(e);
        }
    }


    //更新数据
     @Test
    public void updateUser(){
        User user = new User();
        user.setId(7);
        user.setName("索隆");
        user.setQq("1003410156");
        user.setMajor("剑客");
        user.setStartTime(new Date(System.currentTimeMillis()));
        user.setSchool("教育机构");
        user.setOnlint_id(231111);
        user.setDaily_linke("66666");
        user.setDesire("要成为最强的剑客");
        user.setBre("鹰眼");
        user.setKnow_from("阿拉德大陆");
        user.setCreate_at(new Date(System.currentTimeMillis()));
        user.setUpdate_at(new Date(System.currentTimeMillis()));
        try{
            System.out.println(userService.updateUser(user));
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //根据特定值查询
    @Test
    public void findName() {
        User user = new User();
        user.setBre("鹰眼");
        user.setName("索隆");
        try{
            System.out.println(userService.findName(user));
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
