//import com.jnshu.DESUtil;
//import com.jnshu.model.Student;
//import com.jnshu.model.User;
//import com.jnshu.service.StudentService;
//import com.jnshu.service.UserService;
//import org.apache.ibatis.annotations.Param;
//import org.apache.log4j.Logger;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
//@ContextConfiguration("classpath:spring/applicationContext.xml")
//@RunWith(SpringJUnit4ClassRunner.class)
//public class UserTest {
//
//    @Autowired
//    private UserService userService;
//    Logger logger = Logger.getLogger(BannerTest.class);
//
//    @Test
//    public void select(){
//        User user= new User();
//        user.setName("王五");
//        user.setPassword("11111");
//        int users= userService.insert(user);
//        logger.info(users);
//
//
//    }
//}
