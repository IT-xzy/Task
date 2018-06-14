package com.task.interceptor;

import com.task.rmi.RmiDispatcher;
import com.task.service.UserService;
import com.task.utils.DESUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor extends HandlerInterceptorAdapter{
    @Autowired
    RmiDispatcher rmiDispatcher;
//    private UserService userService=rmiDispatcher.getUserService();
    private Logger logger = Logger.getLogger(UserInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
        logger.info("进入user拦截器");
        UserService userService=rmiDispatcher.getUserService();
        DESUtil desUtil=new DESUtil();//创建解密工具类对象
        boolean flag=isExist(request);//判断是否存在uid和lid
        if(flag){
            String str[]=getCookie(request);//将uid和lid取出来存进str[]中
            String username=desUtil.decrypt(str[0]);
            long loginTime=desUtil.decryptToLong(str[1]);
            long currentTime=System.currentTimeMillis();
            long pastTime=currentTime-loginTime;//当前时间与上次登陆时间差，注意单位是毫秒
            //将解密生成的loginTime和系统中username中的对比，相同则返回true
            if(loginTime==userService.listByName(username).getLoginTime()&&pastTime<(5*24*60*60*1000)&&pastTime>0){
                logger.info("验证成功，放行");
                return true;
            }
            else{
                response.sendRedirect("../login.jsp");
                //这里需要注意如果不过不加../就会重定向到localhost:8080/u/login.jsp
                logger.info("验证失败，禁止");
                return false;
            }
        }
        else{
            response.sendRedirect("../login.jsp");
            logger.info("验证失败，禁止");
            return false;
        }
    }



    /**
     * 获取cookie中的值
     * @param request
     * @return
     */
    public String[] getCookie(HttpServletRequest request) {
        String[] strs = new String[2];
        Cookie[] cs = request.getCookies();
        if (cs != null) {
            for (Cookie c : cs) {
                if (c.getName().equals("uid")) {
                    // 获取加密过的用户名uid
                    strs[0] = c.getValue();
                }
                if (c.getName().equals("lid")) {
                    // 获取加密过的登录时间lid
                    strs[1] = c.getValue();
                }
            }
        }
        return strs;
    }

    /**
     * 判断要求携带的两个cookie是否存在
     * @param request
     * @return
     */
    public boolean isExist(HttpServletRequest request)throws Exception {
         // 不存在的
        boolean flag = false;
        Cookie[] cs = request.getCookies();
        int count = 0;// 记录比较次数

        for (Cookie c : cs) {
            if (c.getName().equals("uid")) {
                count++;
            }
            if (c.getName().equals("lid")) {
                count++;
            }
        }
        if (count == 2) {
            flag = true;
        }
        return flag;
    }
}
