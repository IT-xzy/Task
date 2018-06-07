package utils;

import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.OtherPageService;


/**
 * @author: 曹樾
 * @program: task8newclient
 * @description: randomly select a server
 * @create: 2018/6/7 下午2:55
 */

public class SelectRMI {
    private static final org.slf4j.Logger log= LoggerFactory.getLogger(SelectRMI.class);
    public static OtherPageService selectRMI(){
        ApplicationContext context=new ClassPathXmlApplicationContext("client.xml");
        OtherPageService otherPageService;
        int random=(int) (Math.random()*2+1);
        if(random==1){
            try{
                log.info("调用端口8081内的远程对象方法");
                otherPageService=context.getBean("OtherPageRMIServer1",OtherPageService.class);
                log.info("成功调用8081端口远程对象方法");
                return otherPageService;
            }catch (Exception e){
                log.info("调用端口8082内的远程对象方法");
                otherPageService=context.getBean("OtherPageRMIServer2",OtherPageService.class);
                log.info("成功调用8082端口远程对象方法");
                return otherPageService;
            }
        }else {
            try{
                log.info("调用端口8999内的远程对象方法");
                otherPageService=context.getBean("OtherPageRMIServer2",OtherPageService.class);
                log.info("成功调用8999端口远程对象方法");
                return otherPageService;
            }catch (Exception e){
                log.info("调用端口8999内的远程对象方法");
                otherPageService=context.getBean("OtherPageRMIServer1",OtherPageService.class);
                log.info("成功调用8999端口远程对象方法");
                return otherPageService;
            }
        }
    }
}
