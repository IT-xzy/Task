package interceptor;

import exercise.DesUtilTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import service.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    UsersService usersService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        boolean flag = isExist(request);

        if (flag) {
            String[] str = getCookie(request);

            //取出用户名并解密
            String username = DesUtilTest.decrypt(str[1]);

            //将时间取出解密并转换为long格式
            String time = DesUtilTest.decrypt(str[0]);
            long loginTime = DesUtilTest.stringFormLong(time);
            long currentTime = System.currentTimeMillis();
            long pastTime = currentTime - loginTime;

            long time1 = usersService.getByName(username).getLoginTime();

            if ((loginTime == usersService.getByName(username).getLoginTime() && pastTime < (5 * 24 * 60 * 60 * 1000) && pastTime > 0)) {
                return true;
            } else {
                response.sendRedirect("../login");
                return false;
            }
        } else {
            response.sendRedirect("../login");
            return false;
        }

    }

    /**
     * 获取cookie中的值
     *
     * @param request
     * @return
     */

    public String[] getCookie(HttpServletRequest request) {
        String[] strs = new String[2];
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("time")) {
                    strs[0] = cookie.getValue();
                }
                if (cookie.getName().equals("username")) {
                    strs[1] = cookie.getValue();
                }
            }
        }
        return strs;
    }

    /**
     * * 判断要求携带的两个cookie是否存在
     *
     * @param request
     * @return
     */

    public boolean isExist(HttpServletRequest request) throws Exception {
        boolean flag = false;

        Cookie[] cookies = request.getCookies();
        //记录比较的次数
        int count = 0;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("time")) {
                count++;
            }
            if (cookie.getName().equals("username")) {
                count++;
            }
        }

        if (count == 2) {
            flag = true;
        }

        return flag;
    }


}
