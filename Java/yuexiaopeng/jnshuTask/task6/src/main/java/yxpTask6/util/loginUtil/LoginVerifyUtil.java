package yxpTask6.util.loginUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yxpTask6.pojo.Login;
import yxpTask6.service.LoginService;


@Component
public class LoginVerifyUtil
{
    @Autowired
    private Md5Salt md5Salt;
    @Autowired
    private LoginService loginService;
    @Autowired
    private LoginAccountRegex loginAccountRegex;

    /*登录验证，需要账户名和密码；
    * 1.验证账号和密码是否为空
    * 2.验证账号是否存在
    * 3.取出盐值，验证密码
    * */
    public Boolean loginVerify(String account,String password)
    {
        Boolean boo = false;
        //账户和密码都不为空，进行验证，为空直接返回false；
        if(account!=null&&password!=null)
        {
            //首先进行账号的验证，通过数据库；
            Login login1 = loginService.selectLogin(account);
            // 账号在数据库中，进行账号的验证；
            if(login1!=null)
            {
                //不进行判断，直接验证密码的值，不符合就返回错误页面；
                String salt=login1.getLoginSalt();
                String passwordDb=login1.getLoginPassword();
                //进行账号md5验证，
                boo = md5Salt.decrypt(password,salt,passwordDb);
                return boo;
            }
            //账号不存在
            return boo;
        }
        //账号密码格式不对，存在空值
        return boo;
    }
    /*注册验证
    *1.需要输入账户名和密码；空不符合要求，
    *2.符合要求后进行数据库判断；
    *3，使用者根据验证后的结果，决定跟进不进行数据库操作；
    *  */
    public Boolean loginRegisterVerify(String account,String password)
    {
        Boolean boo = false;
        //账户和密码都不为空，进行验证，为空直接返回false；
        if(account!=null&&password!=null)
        {
            //首先进行账号的验证；如果账号不存在，
            Login login1 = loginService.selectLogin(account);
            // 账号不在数据库中，进行账号的格式验证；
            if(login1==null)
            {
                //验证账号和密码的位数及格式；正则验证；符合则返回true；
                boo=loginAccountRegex.getLoign(account,password);
                //账号不存在，且符合格式要求；
                return boo;
            }
            //账号存在
            return boo;
        }
        //账号或密码有空值；
        return boo;
    }
    /*
    * 账号修改的验证
    * 1.单纯修改密码
    * 2.修改密码和其他信息
    * 3.验证跟其他信息的匹配度
    * */
    public Boolean loginUpdateVerify(String account,String password)
    {
        Boolean boo = false;
        //账户和密码都不为空，进行验证，为空直接返回false；
        if(account!=null&&password!=null)
        {
            //首先进行账号存在数据库的验证；
            Login login1 = loginService.selectLogin(account);
            // 账号在数据库中，进行账号和密码的格式验证；
            if(login1!=null)
            {
                //验证账号和密码的位数及格式；正则验证；符合则返回true；
                boo=loginAccountRegex.getLoign(account,password);
                //账号不存在，且符合格式要求；
                return boo;
            }
            //账号不存在数据库；
            return boo;
        }
        //账号或密码有空值；
        return boo;
    }
}
