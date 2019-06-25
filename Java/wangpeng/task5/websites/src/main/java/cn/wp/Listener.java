package cn.wp;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @ClassName:
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/24 17:24
 * @Version: 1.0
 */
public class Listener implements HttpSessionListener {
    public static int count = 0;

    /**
     * session创建时执行
     */
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

        System.out.println("新建会话===============================");
        count++;
        httpSessionEvent.getSession().setAttribute("count", count);

    }

    /**
     * session销毁时执行
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        count--;
        httpSessionEvent.getSession().setAttribute("count", count);

    }

    /**
     * 获取活动的session个数(在线人数)
     */
    public static int getActiveSessions() {
        return count;

    }
}
