package com.task;


import com.task.model.Person;
import com.task.service.PersonService;
import com.task.service.PersonServiceImpl;
import org.apache.log4j.Logger;

import java.util.List;

public class Main {
    public static void main(String[] args){
        Person p1;
        PersonService personService=new PersonServiceImpl();
        Logger logger=Logger.getLogger(Main.class);
        //标记初始时间
        long t1=System.currentTimeMillis();
      //插入100条数据
       try{
           for(int i=0;i<100;i++) {
               p1 = new Person("lixunhuan" +i, 58, "45454");
               personService.add(p1);
           }
       }catch (Exception e){
           System.out.println(e.getMessage());
           logger.error("插入数据重复，请确认后重新插入");
       }
      //修改数据,其中后五条为空，修改失败提示
       try {
           for(int i=50;i<105;i++) {
               p1 = new Person(i, "libai"+i, 58, "45454");
               if (personService.update(p1) > 0) {
                   logger.debug("修改成功");
               }else {
                   logger.info("修改失败，第"+i+"条信息不存在");
               }
          }
       }catch (Exception e){
           System.out.println(e.getMessage());
           logger.error("修改的姓名与原数据库有重复，请确认后再修改");
     }
       //删除数据，其中后五条数据为空，删除失败提示
       for(int i=20;i<105;i++){
        if(personService.delete(i)>0){
            logger.debug("删除成功");
       }else {
            logger.info("删除失败第"+i+"条信息不存在");
         }
       }
       //查找全部
        List<Person> personList= personService.listAll();
        for (Person p:personList){
            System.out.println(p);
        }
       //按照id查找，当找不到时抛出错误
       try{Person person=personService.selectId(40);
        System.out.println(person);
        }catch (Exception e){
           System.out.println(e.getMessage());
           logger.info("未找到指定ID，请确认后重试");
       }
       //按照姓名查找，当找不到时抛出错误
        try{Person person1=personService.selectName("lixunhuan2");
        System.out.println(person1);
        }catch(Exception e){
            System.out.println(e.getMessage());
            logger.info("未查到指定姓名，请确认后重试");
        }
         //清空数据表
        personService.clear();
        long t2=System.currentTimeMillis();
        System.out.println("此次程序花费时间为"+(t2-t1));
    }
}
