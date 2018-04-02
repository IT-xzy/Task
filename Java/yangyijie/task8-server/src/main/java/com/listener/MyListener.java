package com.listener;

import com.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: Arike
 * @program: task8-server
 * @description: 用于加载容器之后需要执行的代码, 只要容器加载完成之后就会加载.会比bean注解listener慢一点, 因为除非是懒加载, bean总是早于容器完成的.
 * @create: 2018/2/28 11:36
 */
@Component
public class MyListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    RedisUtil redisUtil;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            //root application context 没有parent，他就是老大.
            //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
            System.setProperty("java.rmi.server.hostname", "120.79.4.239");
            System.out.println("你好");
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    redisUtil.put("ServerA", "ServerA","ServerA", 1L);
                    System.out.println("添加A的缓存"+new Date());
                }
            }, 100, 1000);
        }
    }
}
