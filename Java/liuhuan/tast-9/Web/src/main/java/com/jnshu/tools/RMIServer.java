package com.jnshu.tools;

import com.jnshu.service.ServiceDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: SSM_WEB
 * @description: RMI 服务选择
 * @author: Mr.xweiba
 * @create: 2018-06-18 02:48
 **/

public class RMIServer {
        private static final Logger LOGGER = LoggerFactory.getLogger(RMIServer.class);

    public static ServiceDao RMIServer() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-RMI-Client.xml");
        ServiceDao serviceDao;
        // Math.random() 获取0-1之间的随机数, 乘以2 最大值为2, 范围变为0-2之间, 加1, 范围到1-2之间, int强制转换后就只有两个值: 1 和 2
        int random = (int) (Math.random() * 2 + 1);
        if (random == 1) {
            try {
                LOGGER.debug("调用RMI服务端一的远程对象方法");
                serviceDao = context.getBean("serviceDao1", ServiceDao.class);
                LOGGER.debug("调用RMI服务端一远程对象方法成功");
                return serviceDao;
            } catch (Exception e) {
                LOGGER.debug("调用RMI服务端一失败，尝试调用RMI服务端二");
                serviceDao = context.getBean("serviceDao2", ServiceDao.class);
                LOGGER.debug("调用RMI服务端二远程对象方法成功");
                return serviceDao;
            }
        } else {
            try {
                LOGGER.debug("调用RMI服务端二的远程对象方法");
                serviceDao = context.getBean("StudentsService2", ServiceDao.class);
                LOGGER.debug("调用RMI服务端二远程对象方法成功");
                return serviceDao;
            } catch (Exception e) {
                LOGGER.debug("调用RMI服务端二失败，尝试调用RMI服务端一");
                serviceDao = context.getBean("StudentsService1", ServiceDao.class);
                LOGGER.debug("调用RMI服务端一远程对象方法成功");
                return serviceDao;
            }
        }
    }
}

