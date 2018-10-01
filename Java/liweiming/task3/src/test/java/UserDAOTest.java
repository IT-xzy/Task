import com.jnshu.ssm.entities.User;
import com.jnshu.ssm.mapping.UserDAO;
import org.apache.logging.log4j.LogManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserDAOTest {
    private static Logger logger =  LoggerFactory.getLogger(UserDAOTest.class);
    @Test
    public void getAllUser() throws Exception {
        logger.debug("debug level");
        logger.info("info level");
        logger.error("error level");
//        初始化容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        获取bean
        UserDAO userDAO = ctx.getBean(UserDAO.class);
//        访问数据库
        List<User> users = userDAO.getAllUser();
        for (User user:users){
            System.out.println(user);
        }

    }
/*    public static void main(String[] args) {


        logger.debug("debug level");
        logger.info("info level");
        logger.error("error level");

    }*/
}
