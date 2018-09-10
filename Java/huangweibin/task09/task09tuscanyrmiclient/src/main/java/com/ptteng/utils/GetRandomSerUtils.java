package com.ptteng.utils;

import com.ptteng.service.*;
import org.apache.commons.logging.*;
import org.springframework.stereotype.*;

import java.rmi.*;
import java.util.*;
@Component
public class GetRandomSerUtils {
    private static org.apache.commons.logging.Log logger = LogFactory.getLog(GetRandomSerUtils.class);

    public CategoryService getRandomServices() throws Exception {
        Random random=new Random();
        int i =  random.nextInt(2)+1;
        System.out.println(i);
        CategoryService categoryService;
        try {
            if (i == 1) {
                logger.info("启动server1");
                categoryService = (CategoryService) Naming.lookup("rmi://127.0.0.1:8998/TuscanyService");
            } else {
                logger.info("启动server2");
                categoryService = (CategoryService) Naming.lookup("rmi://127.0.0.1:8999/TuscanyService");
            }
        } catch (Exception e1) {
            if (i != 1) {
                logger.info("server2挂了,启动server1");
                categoryService = (CategoryService) Naming.lookup("rmi://127.0.0.1:8999/TuscanyService");
            } else {
                logger.info("server1挂了,启动server2");
                categoryService = (CategoryService) Naming.lookup("rmi://127.0.0.1:8998/TuscanyService");
            }
        }
        return categoryService;
    }

}
