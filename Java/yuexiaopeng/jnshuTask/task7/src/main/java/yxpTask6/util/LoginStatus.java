package yxpTask6.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yxpTask6.pojo.Login;
import yxpTask6.service.LoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
public class LoginStatus
{
    /*登录状态的方法
    1.检查cookies中的信息，查询是否有验证过的账户；
    2.将验证过的账户及设置选项显示出来；
    3，没有账户信息，显示登录及注册按钮；
     * */
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private LoginService loginService;
    /*
    * 返回值说明：
    * status[0],status[1]代表转态信息；
    * status[2],status[3]代表转态链接；
    * status[4]为账户信息；
    * */
    public String[] status(HttpServletRequest request)
    {
        String status[]={"注册","登录","login/reg","login/log","account"};

        Cookie cookies []=request.getCookies();
        if(cookies!=null)
        {
            //遍历cookie，产看账户信息；
            for(int i=0;i<cookies.length;i++)
            {
                String token=cookies[i].getValue();
                //对token进行解密
                Login login=jwtUtils.verifyToken(token);
                //对解密后的返回值login.account进行判断，不存在账户信息就跳出；
                if(login.getLoginAccount()!=null)
                    {
                        //存在账户信息，然后通过数据库查到账户昵称
                        String account=login.getLoginAccount();
                        login=loginService.selectLogin(account);
                        status[0]=login.getLoginName();
                        status[1]="设置";
                        status[2]="login/det";
                        status[3]="login/set";
                        status[4]=login.getLoginAccount();
                        break;
                    }


            }
            //for循环完毕返回string的值；
            return status;
        }
        //cookie为空
        return status;
    }
}
