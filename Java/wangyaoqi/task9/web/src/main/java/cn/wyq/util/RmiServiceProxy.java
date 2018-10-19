package cn.wyq.util;

import cn.wyq.service.EngineerService;
import cn.wyq.service.OutstandingStudentService;
import cn.wyq.service.StudentService;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class RmiServiceProxy {
    ApplicationContext apc = new ClassPathXmlApplicationContext("applicationContext.xml");

    public StudentService getStudentService(){
        int rd = Math.random()>0.5?1:0;
        if (rd==0){
            try{
                return (StudentService) apc.getBean("rmiStudentClientA");
            }catch (BeanCreationException e){
                return (StudentService) apc.getBean("rmiStudentClientB");
            }
        }else {
            try{
                return (StudentService) apc.getBean("rmiStudentClientB");
            }catch (BeanCreationException e){
                return (StudentService) apc.getBean("rmiStudentClientA");
            }
        }
    }

    public OutstandingStudentService getOutstandingStudentService(){
        int rd = Math.random()>0.5?1:0;
        if (rd==0){
            try{
                return (OutstandingStudentService) apc.getBean("rmiOutstandingStudentClientA");
            }catch (BeanCreationException e){
                return (OutstandingStudentService) apc.getBean("rmiOutstandingStudentClientB");
            }
        }else {
            try{
                return (OutstandingStudentService) apc.getBean("rmiOutstandingStudentClientB");
            }catch (BeanCreationException e){
                return (OutstandingStudentService) apc.getBean("rmiOutstandingStudentClientA");
            }
        }
    }

    public EngineerService getEngineerService(){
        int rd = Math.random()>0.5?1:0;
        if (rd==0){
            try{
                return (EngineerService) apc.getBean("rmiEngineerClientA");
            }catch (BeanCreationException e){
                return (EngineerService) apc.getBean("rmiEngineerClientB");
            }
        }else {
            try{
                return (EngineerService) apc.getBean("rmiEngineerClientB");
            }catch (BeanCreationException e){
                return (EngineerService) apc.getBean("rmiEngineerClientA");
            }
        }
    }
}
