package task05.util.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import task05.pojo.UserLogin;
import task05.services.UserLoginServices;
import task05.util.des.DesUtil;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.nio.charset.Charset;
import java.util.Arrays;


public class LoginInterceptor implements HandlerInterceptor {
    @Resource
    private UserLoginServices userLoginServices;
    private static final Charset CHARSET = Charset.forName("gb2312");

//    拦截器
    /**
     * preHandle方法是进行处理器拦截用的，该方法将在Controller处理之前进行调用，SpringMVC中的Interceptor拦截器是链式的，可以同时存在
     * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在
     * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返
     * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String loginCookieIdTime;
        String userLoginName = null;

        Cookie[] cookies =request.getCookies();
        if (cookies != null){
            System.out.println(cookies.length);
            for (Cookie cookie :cookies) {
                if ("userName".equals(cookie.getName())){
                System.out.println("--------------- token0 ----------------");
//                    获取用户登录所使用的账户名
                userLoginName =cookie.getValue();
                System.out.println("userLoginName："+userLoginName);}
            }

            for (Cookie cookie :cookies){
                if ("name".equals(cookie.getName())){
                    loginCookieIdTime = cookie.getValue();
                    String userId;
                    String time;
//                    获取 HttpServletRequest 中的账号和密码
//                    String username = request.getParameter("name"); //这个方法无效

                    System.out.println("--------------- token1 ----------------");

//                    根据用户名获取在数据库中相应的信息
                    System.out.println("userLoginName:" + userLoginName);
                    UserLogin userLoginDatabase= userLoginServices.queryByName(userLoginName);
                    System.out.println(userLoginDatabase.toString());
                    String key = userLoginDatabase.getDespassword();
//                    对拦截到的  token 进行解密
                    loginCookieIdTime = DesUtil.decrypt(loginCookieIdTime,CHARSET,key);
//                    解密后的字符串,打印
                    System.out.println("-----------打印解密后的 token -------------");
                    System.out.println(loginCookieIdTime.toString());
//                    分割token
                    String [] tokenBase =loginCookieIdTime.split("[,]+");
                    System.out.println("---------- 分割后的 token ------------");
                    System.out.println("loginCookieIdTime:" + loginCookieIdTime);
                    System.out.println(Arrays.toString(tokenBase));
                    userId = tokenBase[0];

                    time = tokenBase[1];
                    System.out.println("userId：" + userId);
                    System.out.println("time：" + time);
//                    转换创建时间并进行比较
                    long oldTime =Long.parseLong(time);
                    long nowTime =System.currentTimeMillis();
                    System.out.println("oldTime:" + oldTime);
                    System.out.println("nowTime:" + nowTime);

//                     取出 session 的用户名和密码，再解码对比
                    HttpSession session = request.getSession();
                    String sessionUser = (String) session.getAttribute("userName");
                    String sessionPassword = (String) session.getAttribute("password");
                    System.out.println("---------------- session -----------------------");
                    System.out.println("sessionUser:" + sessionUser);
                    System.out.println("sessionPassword:" + sessionPassword);


                    if (nowTime - oldTime < 30*30*24|| nowTime - oldTime >0 || sessionUser.equals(userLoginDatabase.getName())){
                        System.out.println("符合有效时长");
                        if (userId.equals(String.valueOf(userLoginDatabase.getId()))){
                            System.out.println("ID 一致");
                            return true;

                        }
                    }
                }
            }
        }
        response.sendRedirect(request.getContextPath() + "/login");
        return false;
    }

    /**
     * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之
     * 后，也就是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行，也就是说在这个方法中你可以对ModelAndView进行操
     * 作。这个方法的链式结构跟正常访问的方向是相反的，也就是说先声明的Interceptor拦截器该方法反而会后调用，这跟Struts2里面的拦截器的执行过程有点像，
     * 只是Struts2里面的intercept方法中要手动的调用ActionInvocation的invoke方法，Struts2中调用ActionInvocation的invoke方法就是调用下一个Interceptor
     * 或者是调用action，然后要在Interceptor之前调用的内容都写在调用invoke之前，要在Interceptor之后调用的内容都写在调用invoke方法之后。
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行，
     * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。
     */
    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
