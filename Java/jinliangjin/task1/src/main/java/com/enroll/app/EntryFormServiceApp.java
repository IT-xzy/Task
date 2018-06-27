package com.enroll.app;

import com.enroll.service.EntryFormService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ProjectName: task1
 * @Package: com.enroll.service
 * @ClassName: EntryFormServiceApp
 * @Description: Insert i time(s) EntryForm to the entryform table and return one list of this table.
 * @Author: Jin
 * @CreateDate: 2018/4/29 10:34
 * @UpdateUser:
 * @UpdateDate: 2018/4/29 10:34
 * @UpdateRemark:
 * @Version: 1.0
 */
public class EntryFormServiceApp {

    public static void main(String[] args) {

//        List<EntryForm> list = getServiceBean().deleteEntryForm(151);
//        System.out.println(list);
        Boolean insert = getServiceBean().batchInsert(Integer.parseInt(args[0]));
//        Boolean insert = getServiceBean().batchInsert(10000);
        if(insert==true){
            System.out.println("\n插入" +Integer.parseInt(args[0]) +"条数据成功！");
        }else {
            System.out.println("\n插入数据失败！");
        }
/*        for(int i = 1000; i < 2000; i++){
            getServiceBean().deleteEntryForm(i);
        }*/

    }
    public static EntryFormService getServiceBean(){
        AbstractApplicationContext aac;
        aac = new ClassPathXmlApplicationContext("com.enroll/spring-config.xml");
        EntryFormService entryFormService = (EntryFormService) aac.getBean("entryFormService");
        System.out.println("实例bean。");
        return entryFormService;
    }
}
