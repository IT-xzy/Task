package com.jnshu.interceptor;

import com.jnshu.tools.MemcacheUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 登陆拦截器 */
public class LoginSessionInterceptor implements HandlerInterceptor {
    //日志
    private static Logger logger = LoggerFactory.getLogger(HandlerInterceptor.class);

    @Autowired
    MemcacheUtils memcacheUtils;
    
    //Controller执行的全过程都在这里,可以用作执行时间日志
    //计算时间
    private Long timer = Long.valueOf(0);

    //执行Handler方法之前执行
    //用于身份认证、身份授权
    //比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //handler 开始时间
        this.timer = System.currentTimeMillis();
        //获取请求的url
        String url = httpServletRequest.getRequestURI();
        //判断url是否是公开地址(实际使用时将公开地址配置到配置文件中)

        //正则匹配url
        Pattern pattern = Pattern.compile("^.*login.action.*$|^.*rest\\/api\\/.*$|^.*home\\/.*$|^.*profession\\/.*$|^.*memcache\\/.*$");
        Matcher matcher = pattern.matcher(url);

        //可以导入一个配置文件,匹配其中的请求
        if (matcher.matches()){
            //如果要进行登陆提交,放行
            return true;
        }



        // 获取 session
        HttpSession session = httpServletRequest.getSession();
        // 从session中取出用户信息
        String username = (String)session.getAttribute("username");
        logger.debug("尝试登陆用户: " + username + "session_id:" + session.getId());
        logger.info(" memcached 拦截器确认时 : " + (String) memcacheUtils.get(session.getId()));

        // 登陆数据效验
        if(username !="" &&username!=null){
            String sessionName = (String) memcacheUtils.get(session.getId());
            logger.info("登陆用户名: " + username +  ", sessionName:" + sessionName + ", session.getId():" + session.getId());
            if(username.equals(sessionName)){
                //身份存在 放行
                logger.debug("身份存在 放行");
                return true;
            }
        }
        //执行到这里标识用户身份需要认证,跳转到登陆界面
        //跳转网址需要绝对路径,将当前请求重新映射到/WEB-INF/jsp/login.jsp,
        // WEB-INF/jsp/login.jsp访问的是原地址+WEB-INF/jsp/login.jsp
        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(httpServletRequest, httpServletResponse);
        logger.info("用户身份需要认证,跳转至登陆页面,执行Handler方法之前执行");
        //return false表示拦截，不向下执行 此时应计算页面结束时间
        this.timer = System.currentTimeMillis() - this.timer;
        logger.debug( "性能日志 页面生成时长 : " + this.timer + "ms" );
        //return true表示放行
        return false;
    }

    //进入Handler方法之后，返回modelAndView之前执行
    //应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里
    //传到视图，也可以在这里统一指定视图
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("LoginInterceptor postHandle 拦截器执行了,进入Handler方法之后，返回modelAndView之前执行");
        logger.info(" memcached 拦截器确认时 : " + (String) memcacheUtils.get(httpServletRequest.getSession().getId()));
    }

    //执行Handler完成执行此方法
    //应用场景：统一异常处理，统一日志处理
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //执行完毕时间
        this.timer = System.currentTimeMillis() - this.timer;
        logger.info("HandlerInterceptor1 afterCompletion 拦截器执行了,Handler运行完成后执行此方法");
        logger.info(" memcached 拦截器确认时 : " + (String) memcacheUtils.get(httpServletRequest.getSession().getId()));
        logger.debug("性能日志 页面生成时长 : " + this.timer + "ms");
    }
}
