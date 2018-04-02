package com.task;

import com.task.model.Person;
import com.task.service.PersonService;
import com.task.service.PersonServiceImpl;
import org.apache.log4j.Logger;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws Exception{
        PersonService personService=new PersonServiceImpl();
        Logger logger= Logger.getLogger(Main.class);
        //程序开始的时间t1
        long t1=System.currentTimeMillis();
        Person person;
        //插入数据不要求返回主键
       try {
            for (int i=0;i<100;i++) {
                person = new Person(System.currentTimeMillis(), "lixunhuan" + i, 35, "4545454");
                personService.justAdd(person);
            }
      }catch (Exception e){
           System.out.println(e.getMessage());
           logger.error("插入数据重复");
       }
      //插入并筛选
        try {
            person = new Person(System.currentTimeMillis(), "wangsan", 13, "546546645");
            Map<String, Object> parms = new HashMap<>();
            parms.put("name", "w");
            List<Person> personList = personService.addAndList(person, parms);
            for (Person p1 : personList) {
                System.out.println(p1);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            logger.error("插入数据重复");
        }
        //修改数据

            try {
                for (int i=50;i<105;i++) {
                person = new Person(i,System.currentTimeMillis(), "libai" + i, 58, "454545");
                if (!(personService.justUpdate(person)) ){
                    logger.info("修改失败,第"+i+"条数据不存在");
                }
            }
        }catch (Exception e){
                System.out.println(e.getMessage());
                logger.error("数据有重复，请确认");
            }
        //删除数据
        for(int i=80;i<110;i++){
            if(!(personService.justDelete(i))){
                logger.info("删除失败，第"+i+"条数据不存在");
            }
        }
        //模糊查找
       try {
           Map<String, Object> parms = new HashMap<>();
           parms.put("name", "libai5");
           List<Person> personList = personService.justList(parms);
           for (Person p1 : personList) {
               System.out.println(p1);
           }
       }catch (Exception e){
           System.out.println(e.getMessage());
           logger.info("无此条记录，请确认");
       }
        //清空数据
      personService.deleteAll();


    long t2=System.currentTimeMillis();
        System.out.println("运行时间为"+(t2-t1)+"毫秒");
    }
}
