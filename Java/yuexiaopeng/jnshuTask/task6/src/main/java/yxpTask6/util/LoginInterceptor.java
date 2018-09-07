package yxpTask6.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import yxpTask6.pojo.Login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements HandlerInterceptor
{
    @Autowired
    JwtUtils jwtUtils;
    static Logger logger=Logger.getLogger(LoginInterceptor.class);

    //实现抽象类的preHandle方法；
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        //获取请求的url
        String url = request.getContextPath();
        //从request中读取cookie
        Cookie cookies[]=request.getCookies();
        /*从request中读取发送的参数token；
        如果request中的cookie数量为0，则返回false；
        如果request中含有cookie，则进行判断；*/
        //request中包含cookies，进行判断；
        if(cookies!=null)
        {
            //cookie存在，对token进行验证
            //不使用for each而使用for是为了跳出循环方便；
            for(int i=0;i<cookies.length;i++)
            {
                 //遍历cookie，判断从cookie的value中取出的账户信息是否为空
                 String token = cookies[i].getValue();
                 Login login=jwtUtils.verifyToken(token);
                 if (login.getLoginAccount()!= null)
                     {
                         //验证成功，放行
//                         logger.info("....token验证成功");
//                         logger.info("token验证成功的账户为："+login.getLoginAccount());
                         return true;
                     }
                 else
                     {
                     //有cookie信息，但是解密后的token取得的账户名为空，跳转到提示信息登陆页面
                     response.sendRedirect(url+"/login/need");
//                     logger.info("....输入错误,token验证失败");
                     return false;
                     }
            }
        }

        //没有cookie信息，重定向到首页产生一个随机cookie，进行游客访问；
        response.sendRedirect(url+"/home");
//        logger.info("....输入错误，需要cookie信息；");
        return false;
    }
    //实现抽象类posthandle的方法
    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception
    {

//        logger.info("HandlerInterceptor1....postHandle");

    }
    //实现抽象类afterCompletion的方法
    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception
    {

//        logger.info("HandlerInterceptor1....afterCompletion");
    }
}
