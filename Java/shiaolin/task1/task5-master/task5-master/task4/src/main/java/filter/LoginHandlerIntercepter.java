package filter;

import cookie.CookieTool;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import pojo.User;
import service.UserService;
import token.TokenUtil;

import java.io.IOException;

public class LoginHandlerIntercepter implements HandlerInterceptor {
    @Autowired
    UserService userService;
    private static Logger logger = Logger.getLogger(LoginHandlerIntercepter.class);

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3) {
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1,
                             Object arg2) throws Exception {
        boolean beFilter = true;
        String requestURL = request.getRequestURI();
        /*不拦截页面*/
        String[] noFilters = new String[]{"login","index"};
        //判断是否处在登陆编辑页面
        for (String s : noFilters) {
            if (requestURL.indexOf(s) > 0) {
                logger.info("进入到拦截方法");
                return true;
            }
        }
        logger.info(beFilter + "!!!!!!!!!!!!!!!!!");
        //如果其他页面
        if (beFilter = true) {
            logger.info("进入方法！！！！！！！！！！！！！！！！");
            String path = request.getContextPath();
//            String basePath = request.getScheme() + "://" + request.getServletPath() + request.getServerPort() + path + "/";
//            logger.info(basePath+"1111111");
//            Cookie cokUserName = CookieTool.getCookieByName(request, "userName");
//            Cookie cokPassword = CookieTool.getCookieByName(request, "passWord");
            Cookie token = CookieTool.getCookieByName(request, "token");

            //如果前面保存了登陆信息
//            if (cokPassword != null && cokUserName != null && cokPassword.getValue() != null && cokUserName.getValue() != null) {
//                String username = cokUserName.getValue();
//                String password = cokPassword.getValue();
                //进行账户密码的验证
//                User user = userService.validateUser(username, password);
//                logger.info(user + "123123123213");
            if (token != null){
                logger.info(token.getValue()+"出来了。。。。。卧槽");
               //加密的token
                String tokeData = token.getValue();
                //解密
                String enTokenData = TokenUtil.enToken(tokeData);
                String[] strings = enTokenData.split("/");
                String id = strings[0];
                //String转换成long
                long l_id = Long.parseLong(id);
                logger.info(id+"id出来了");
                User user = userService.selectUserById(l_id);
                //如果这个人就是个黑户口
                if (user == null) {
//                    CookieTool.addCookie(arg1, "userName", null, 0);
//                    CookieTool.addCookie(arg1, "passWord", null, 0);
                    CookieTool.addCookie(arg1,"token",null,0);
                    try {
                        arg1.sendRedirect("localhost:8090/login");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    request.getSession().setAttribute("errorInfo", "请登录");
                    return false;
                }
                //如果存在此人
                else {
                    logger.info("存在此人");
//                    User sessionUser = (User) request.getSession().getAttribute("userName");
//                    if (sessionUser == null) {
//                        request.getSession().setAttribute("user", user);
//                    } else {//用户登陆后
//                        if (sessionUser.getUsername().equals(user.getUsername())) {
//                            request.getSession().setAttribute("user", user);
//                        } else {
//                            request.getSession().setAttribute("user", sessionUser);
//                        }
//                    }
                    return true;
                }
            } else {
                logger.info("token没有内容");
                User user = (User) request.getSession().getAttribute("user");
                if (user == null) {
                    request.getRequestDispatcher("WEB-INF/tiles/login.jsp").forward(request, arg1);
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}