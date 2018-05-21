import service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;
import service.UserServiceImpl;

import java.util.List;

public class MybatisCRUDTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
    UserService userService =context.getBean(UserServiceImpl.class);

//    添加数据
    @Test
    public void insertTest() {
        User user=new User();
        user.setName("微信");
        user.setPassword("123465");
        userService.insert(user);
        System.out.println(user.getId());
    }

//    通过id删除数据
    @Test
    public void deleteTest(){
       int count= userService.delete(6);
        System.out.println(count>0);
    }

//    通过id查找数据
    @Test
    public void selectTest(){
        User user = userService.select(1);
        System.out.println(user.getName());
    }

//    模糊查询。通过name查询数据
    @Test
    public void selectByNameTest(){
        List<User> users = userService.selectByName("小米");
        for(User user:users){
            System.out.println(user.getId());
        }
    }

//    更新数据
    @Test
    public void updateTest(){
        User user =new User();
        user.setId(1);
        user.setName("淘宝");
        user.setPassword("123465");
        int count= userService.update(user);
        System.out.println(count>0);
    }


}
