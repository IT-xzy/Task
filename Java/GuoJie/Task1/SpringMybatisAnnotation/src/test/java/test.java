import SpringMybatis.User;
import SpringMybatis.dao.MyDao;
import SpringMybatis.service.MySevice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:MySpring.xml")
public class test {
    @Autowired
    private MySevice mySevice;
    @Autowired
    private MyDao myDao;
    @Test
    public void findById(){
        User user=mySevice.findById(2);
        System.out.println(user);
    }

    @Test
    public void  findAll(){
        List<User> user=mySevice.findAll();
        System.out.println(user);
    }
    @Test
    public void insertUser(){
        User user=new User();
        user.setId(15);
        user.setName("六娃");
        user.setEmail("EE@EE");
        mySevice.insertUser(user);
    }
}