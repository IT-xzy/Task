package com.jnshu.czm.aop;

import com.jnshu.czm.model.User;
import com.jnshu.czm.service.UserService;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;

@Aspect
@Component
public class MemcacheService {

    private static Logger logger= LoggerFactory.getLogger(MemcacheService.class);

    @Autowired
    private MemcachedClient memcachedClient;

    @Autowired
    private UserService userService;

    @Pointcut("execution(* com.jnshu.czm.service.impl.UserServiceImpl.findUserById(..))")
    public void findUserById() {
    }


    @Around("findUserById()&&args(id)")
    public User aroudGetUserById(ProceedingJoinPoint joinPoint, int id)throws Exception{
        User user=null;
        System.out.println("进入aop\n"+"String.valueOf(id):"+String.valueOf(id));

        if ("".equals(memcachedClient.get(String.valueOf(id)))){
            logger.info("\n从缓存返回空值");
            return user;
        }
        try{
            if (memcachedClient.get(String.valueOf(id))!=null){
                user =memcachedClient.get(String.valueOf(id));
                logger.info("\n"+"从缓存中读取findUserById"+user);
            }else{
                try{
                    user=(User)joinPoint.proceed();
                    if (user !=null){
                        memcachedClient.set(String.valueOf(id),0,user);
                        logger.info("\n"+"存到缓存的值为user={},id={}",user,id);
                    }else {
                        memcachedClient.set(String.valueOf(id),1000,"");
                        logger.info("\n"+"将空值存到缓存");
                    }

                }catch (Throwable e){
                    e.printStackTrace();
                }
            }
        }catch (TimeoutException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch(InterruptedException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (MemcachedException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }



}
