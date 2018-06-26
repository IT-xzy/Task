import dao.UserMapper;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.Md5Util;

public class UserMapperTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
    private UserMapper userMapper = (UserMapper) context.getBean("userMapper");
    private Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void addTest(){
        User user = new User();
        user.setName("xixixixxxx");
        user.setPassword("123456");
        try {
            userMapper.addUser(user);
            logger.info("添加成功");
        }catch (Exception e){
            logger.info("添加异常");
        }
    }

    @Test
    public void registerTest() throws Exception {
        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setName("wlg1");
        user.setPassword("password");
        user.setQq("123123123");
        user.setPhoneNum("13855158878");
        user.setEmail("li@qq.com");
        user.setCreatedAt(String.valueOf(System.currentTimeMillis()));
        if(userService.register(user)){
            try{
                String password = Md5Util.createSaltMd5(user.getPassword()); //MD5加盐加密
                user.setPassword(password);
                userMapper.addUser(user);
                logger.info("添加正常："+user);
            }catch (Exception e){
                logger.info("添加异常"+e);
            }
        }
    }

}