package com.longhang.util;

import com.longhang.stuService.StuService;
import com.longhang.stuService.UserService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetBean {
    private Logger logger=Logger.getLogger("GetBean.class");
    private StuService stu;
    ApplicationContext applicationContext;
    public GetBean() {
    }

    public UserService getUserSe(){

         UserService userSe=null;
          if(this.getRandom()) {
              try{
                   applicationContext= new ClassPathXmlApplicationContext("rmiClient.xml");
              userSe=  applicationContext.getBean("myRMIClient1",UserService.class);
              logger.info("************myRMIClient1连接成功************");
              } catch (Exception e){
                  applicationContext= new ClassPathXmlApplicationContext("rmiClient3.xml");
                  userSe=applicationContext.getBean("myRMIClient3",UserService.class);
                  logger.info("************myRMIClient3连接成功************");
              }
             return userSe;
          } else {
             try{
                 applicationContext= new ClassPathXmlApplicationContext("rmiClient3.xml");
                 userSe=applicationContext.getBean("myRMIClient3",UserService.class);
                 logger.info("************myRMIClient3连接成功************");
             } catch (Exception e){
                 applicationContext= new ClassPathXmlApplicationContext("rmiClient1.xml");
                 userSe=  applicationContext.getBean("myRMIClient1",UserService.class);
                 logger.info("************myRMIClient1连接成功************");
             }
             return userSe;
          }
    }
    public StuService getStu()
        {
            StuService stu=null;
            if(this.getRandom()) {
                try{
                    applicationContext= new ClassPathXmlApplicationContext("rmiClient.xml");
                    stu=  applicationContext.getBean("myRMIClient",StuService.class);
                    logger.info("************myRMIClient************连接成功");
                } catch (Exception e){
                    applicationContext= new ClassPathXmlApplicationContext("rmiClient2.xml");
                    stu=applicationContext.getBean("myRMIClient2",StuService.class);
                    logger.info("************myRMIClient2连接成功************");
                }
                return stu;
            } else {
                try{
                    applicationContext= new ClassPathXmlApplicationContext("rmiClient2.xml");
                    stu=applicationContext.getBean("myRMIClient2",StuService.class);
                    logger.info("************myRMIClient2连接成功************");
                } catch (Exception e){
                    applicationContext= new ClassPathXmlApplicationContext("rmiClient.xml");
                    stu=  applicationContext.getBean("myRMIClient",StuService.class);
                    logger.info("************myRMIClient连接成功************");
                }
                return stu;
            }
        }


    public boolean getRandom(){
        return (Math.random()-0.5)>0;
    }

}
