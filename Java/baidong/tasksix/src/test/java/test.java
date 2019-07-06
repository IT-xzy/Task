import jnshu.controller.UserController;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:spring-mvc.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class test {

    //    @Resource(name = "UserServiceImp")
//    public UserService UserService;
    @Autowired
    UserController userController;
    Logger logger = Logger.getLogger(test.class);

    @Test
    public void task() {

//        UserController.selectById(1L);

//        List<Long> ids = UserService.selectAllIds();
//        logger.info("ids=====" + ids);


//        List<User> User = UserService.selectByIdList(ids);
//        logger.info("User=====" + User);

//        List<User> User=  UserService.selectAll();
    }


}