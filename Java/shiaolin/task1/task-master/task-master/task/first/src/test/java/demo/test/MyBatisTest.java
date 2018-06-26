package demo.test;

import com.elements.user.model.User;

import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;


/** 
* Main Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 25, 2018</pre> 
* @version 1.0 
*/
public class MyBatisTest {
        private UserService userService;
    @Before
            public  void before() {
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String("applicationContext.xml"));
        userService = (UserService)ac.getBean("userServiceI");
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: main(String[]args)
    *
    //*/
    //根据id查询数据
    @Test
        public void queryUser()throws Exception{
            try {
                User user = userService.queryUser(1);
                System.out.println(user);
            }catch (Exception e){
                System.out.println("错误："+e);
            }

    }
    //添加数据
    @Test
        public void addUser() throws Exception{
        User user = new User();
        user.setId(485);
        user.setName("雅马哈");
        user.setQq(1023452369);
        user.setNumber(123456785);
        user.setLearning_type("Java");
        try{
        userService.addUser(user);
        }catch (Exception e){System.out.println("错误："+e);
        }

        if (user != null){
            System.out.println(user.getId());
        }
    }
    //根据Id删除数据
    @Test
        public void deleteUser(){
        try {
            System.out.println(userService.deleteUser(11));
        }catch (Exception e){System.out.println("错误："+e);
            }
        }

    //    根据id更新数据
    @Test
        public void updataUser(){
        User user = new User();
        user.setId(145);
        user.setName("草");
        user.setQq(14523654);
        try {
            System.out.println(userService.updataUser(user));
        }catch (Exception e){System.out.println("错误："+e);
            }
        }

    //    根据姓名，学号查询数据表
    @Test
        public void queryName(){
        User user = new User();
        user.setName("草");
        user.setNumber(123456785);
        try {
        User result = userService.queryName(user);
        System.out.println(result);
            }catch (Exception e) {
            System.out.println("错误：" + e);
                }
        }

}


