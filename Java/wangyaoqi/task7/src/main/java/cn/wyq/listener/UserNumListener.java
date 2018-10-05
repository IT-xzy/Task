package cn.wyq.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class UserNumListener implements HttpSessionListener {
    private int userNumber = 0;

    public void sessionCreated(HttpSessionEvent arg0){
        userNumber++;
        arg0.getSession().setAttribute("userNumber",userNumber);
    }

    public void sessionDestroyed(HttpSessionEvent arg0){
        userNumber--;
        arg0.getSession().setAttribute("userNumber",userNumber);
    }
}
