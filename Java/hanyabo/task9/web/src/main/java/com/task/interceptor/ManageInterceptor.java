package com.task.interceptor;

import com.task.entity.User;
import com.task.entity.UserToken;
import com.task.service.UserService;
import com.task.util.JwtUtil;
import com.task.util.TuscanyServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ManageInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(ManageInterceptor.class);

//    @Autowired
//    private UserService userServivce;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        UserService userService = new TuscanyServiceUtil().getUserService();
        //获取cookie
        Cookie[] cookies = request.getCookies();
        if(null != cookies){
            for(Cookie cookie : cookies){
                //获取token
                if(cookie.getName().equals("token")) {

                    String token = cookie.getValue();
//                    logger.info("token+++"+token);

                    UserToken userToken = JwtUtil.unsign(token, UserToken.class);

                    if(null!=userToken.getName() && null!=userToken.getPswd()){
                        //查找是否存在该用户
                        User user = userService.checkLogin(userToken.getName(), userToken.getPswd());
                        if(null != user){
                            //用户已经登录
                            logger.info("用户已登录");
                            return true;
                        }
                    }
                }

            }
        }

        logger.info("用户未登录");
        request.getRequestDispatcher("/user/session").forward(request, response);
        return false;
    }
}
