package com.ptt.interceptor;

import com.ptt.pojo.PersistentLogins;
import com.ptt.pojo.User;
import com.ptt.service.ILoginService;
import com.ptt.service.IUserService;
import com.ptt.util.CookieUtil;
import com.ptt.util.DESUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName: UserInterceptor
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/31 19:50
 * @Version: 1.0
 */
@Component
public class UserInterceptor extends HandlerInterceptorAdapter{
    @Autowired
    private IUserService userService;
    @Autowired
    private ILoginService loginService;
    @Value("${cookieName}")
    private String cookieName;
    @Value("${salt}")
    private String salt;
    @Value("${sessionId}")
    private String sessionId;
    @Value("${loginName}")
    private String loginName;
    private Logger logger = Logger.getLogger(UserInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        boolean flag = false;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //如果会话未关闭
        if(null != user){
            logger.info("会话未关闭，可以继续访问");
            flag = true;
            return flag;
        } else {//是新的会话
            logger.info("是新会话，正在验证cookie...");
            Cookie cookie = CookieUtil.getCookieByName(request, cookieName);
            if(null != cookie) {//cookie存在
                logger.info("cookie存在");
                String cookieValue = CookieUtil.getCookieValue(request, cookieName);
                //通过cookieValue等到username和uuid
                String[] cookieValues = cookieValue.split(":");
                String usernameFromCookie = cookieValues[0];
                String uuidFromCookie = cookieValues[1];
                PersistentLogins login = loginService.selectByUsernameAndSeries(usernameFromCookie, uuidFromCookie);
                logger.info("验证是否保存有自动登录记录...");
                if(null != login){//有自动登录的记录
                    logger.info("存在自动登录记录");
                    logger.info("验证记录是否过期...");
                    Date validTimeSaved = login.getValidtime();//查询出记录中保存的过期时间
                    Date now = new Date();
                    if(now.before(validTimeSaved)){//未过期
                        logger.info("未过期");
                        logger.info("验证用户是否被删除...");
                        User user1 = userService.selectByName(usernameFromCookie);
                        if(null != user1){//并且用户未被删除
                            logger.info("用户存在");
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(validTimeSaved);
                            String timeString = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-"
                                    + calendar.get(Calendar.DAY_OF_MONTH) + "-" + calendar.get(Calendar.HOUR_OF_DAY)
                                    + "-" + calendar.get(Calendar.MINUTE) + "-" + calendar.get(Calendar.SECOND) + "-"
                                    + calendar.get(Calendar.MILLISECOND);
                            //重新加密生成token
                            String tokenNow = DESUtil.encrypt(user1.getName() + "-" + user1.getPassword()
                                    + "-" + timeString + "-" + salt);
                            logger.info("重新加密生成新token");
                            String tokenSaved = login.getToken();
                            logger.info("验证token是否被改变过...");
                            if(tokenNow.equals(tokenSaved)){//新旧token一样，说明密码没有修改过
                                logger.info("token未被改变过（未修改过密码）");
                                String uuidNow = UUID.randomUUID().toString();//重新生成uuid
                                String cookieValueNow =
                                        DESUtil.encrypt(user1.getName() + ":" + uuidNow);
                                //更新cookie
                                CookieUtil.editCookie(request, response, cookieName, cookieValueNow);
                                login.setSeries(uuidNow);
                                //更新自动登录记录
                                loginService.updatePersistentLoginsBySelective(login);
                                logger.info("更新自动登录记录");
                                logger.info("在session中添加标记，方便下次验证");
                                //将user设置的奥session，下次判定的时候如果存在user就直接return true
                                session.setAttribute(sessionId, user1.getId());
                                session.setAttribute(loginName, user1.getName());
                                session.setAttribute("user", user1);
                                //验证通过
                                logger.info("验证通过");
                                flag = true;
                                return flag;
                            } else {
                                //密码被修改
                                logger.info("token已被改变（修改过密码），删除cookie、自动登录记录");
                                CookieUtil.deleteCookie(response, cookie);
                                loginService.deletePersistentLoginsByPrimaryKey(login.getId());
                                return flag;
                            }
                        } else {
                            //信息已删除
                            logger.info("用户已被删除，删除cookie、自动登录记录");
                            CookieUtil.deleteCookie(response, cookie);
                            loginService.deletePersistentLoginsByPrimaryKey(login.getId());
                            return flag;
                        }
                    } else {
                        //自动登录记录已过期
                        logger.info("自动登录记录已过期，删除cookie、自动登录记录");
                        CookieUtil.deleteCookie(response, cookie);
                        loginService.deletePersistentLoginsByPrimaryKey(login.getId());
                        return flag;
                    }
                }
                logger.info("没有自动登录信息");
            }
            logger.info("是新session且没有cookie");
            response.sendRedirect(request.getContextPath() + "/it/login");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {

    }
}
