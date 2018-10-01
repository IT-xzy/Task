import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yxp.pojo.Login;
import yxp.service.LoginService;
import yxp.util.loginUtil.LoginAccountRegex;
import yxp.util.loginUtil.Md5Salt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestLogin
{
    @Autowired
    private LoginService loginService;
    @Autowired
    private LoginAccountRegex loginAccountRegex;
    @Autowired
    private Md5Salt md5Salt;
    @Test
    public void testInsert()
    {
        long create_at=System.currentTimeMillis();
        long update_at=System.currentTimeMillis();
        Login login1=new Login(create_at,update_at,"2","yue3456789",
                "123456789","feifei","/img/","salt");
        //进行账户名及密码的位数验证
        Boolean boo=loginAccountRegex.getLoign(login1.getLoginAccount(),login1.getLoginPassword());
        if(boo)
        {
            //验证成功后，进行密码的加盐，此处使用用户名称作为salt
            String encyptPassword=md5Salt.encrypt(login1.getLoginPassword(),login1.getLoginSalt());
            //加密后的密码赋值给password
            login1.setLoginPassword(encyptPassword);
            //注册账号
            loginService.registerLogin(login1);
        }
        else
        {
            System.out.println("账户名错误");
        }
        System.out.println(login1);
    }
    @Test
    public void testSelect()
    {
        Login login1=new Login();
        login1.setLoginAccount("yue");
        Login login=loginService.selectLogin("yue23456789");
        System.out.println(login);
    }
//    修改账户信息
    @Test
    public void testUpdate()
    {
        Login login1=new Login();
        String loginAccount="yue12345678";
        login1.setLoginAccount(loginAccount);
        //原始账户的信息,主要用来获取盐值；
        Login login=loginService.selectLogin(loginAccount);

        login1.setUpdateAt(System.currentTimeMillis());
        login1.setLoginName("sun wukong");
        login1.setLoginPicture("/img/wokong.img");
        //输入新的原始密码
        login1.setLoginPassword("12345678");

        //进行账户名及密码的位数验证，成功则进行修改；
        Boolean boo=loginAccountRegex.getLoign(login1.getLoginAccount(),login1.getLoginPassword());
        if(boo)
        {
            //对新密码进行加盐
            String encryptedPassword=md5Salt.encrypt(login1.getLoginPassword(),login.getLoginSalt());
            //录入新密码；
            login1.setLoginPassword(encryptedPassword);
            //修改密码
            loginService.updateLogin(login1);
        }
        else
        {
            System.out.println("密码格式错误");
        }
        long update=System.currentTimeMillis();
        System.out.println(update);
    }
//    修改账户密码
    @Test
    public void testUpdatePassword()
    {
        Login login1=new Login();
        String loginAccount="yue3456789";
        //原始账户的信息,主要用来获取盐值；
        Login login=loginService.selectLogin(loginAccount);

        login1.setLoginAccount(loginAccount);

        login1.setUpdateAt(System.currentTimeMillis());
        //输入新密码
        login1.setLoginPassword("12345678");
        //进行账户名及密码的位数验证，成功则进行修改；
        Boolean boo=loginAccountRegex.getLoign(login1.getLoginAccount(),login1.getLoginPassword());
        if(boo)
        {
            //对新密码进行加盐
            String encryptedPassword=md5Salt.encrypt(login1.getLoginPassword(),login.getLoginSalt());
            //录入新密码；
            login1.setLoginPassword(encryptedPassword);
            //修改密码
            loginService.updatePassword(login1);
        }
        else
        {
            System.out.println("密码格式错误");
        }
    }
}
