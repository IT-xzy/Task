import Entity.Signup;
import dao.signupDAO;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationcontext.xml"})
public class testjdbc {
//    private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationcontext.xml");
//    private signupDAO signupDao = (signupDAO) ctx.getBean("signupDAO");

    @Autowired
    private signupDAO signupDao;
    //日志
    Logger logger = Logger.getLogger(testjdbc.class);
    @Test
    public void selectTest(){
        String name =signupDao.FindSignupByID((long) 1);
        logger.info("ID为1的学生名字为："+name);
    }
    //增
    @Test
    public void InsertTest(){
        Signup signup = new Signup();
        signup.setName("西西");
        signup.setQq(9999999);
        try {
            signupDao.InsertSignup(signup);
            logger.info("测试插入数据成功");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    //改
    @Test
    public void UpdateTest(){
        try {
            signupDao.UpdateByName("小王");
            logger.info("修改西西为小王成功");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @Test
    public void DeleteTest(){
        try {
            signupDao.DeleteByName("小王");
            logger.info("测试删除操作成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
