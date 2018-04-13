package com.task;

import com.task.model.Person;
import com.task.service.Impl.PersonServiceImpl;
import com.task.service.PersonService;
import org.apache.log4j.Logger;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args)throws Exception {
        Person person;
        PersonService personService = new PersonServiceImpl();
        long t1=System.currentTimeMillis();
       //创建logger对象，方便使用log功能
        Logger logger=Logger.getLogger(Main.class);
      //先增加一条数据并返回结果
        try{
            person= new Person(System.currentTimeMillis(),"wangxia", 25, "20111555");
        Map<String,Object> parms=new HashMap<>();
        parms.put("name","wangxiao987654");
        List<Person> people=personService.addAndList(person,parms);
        for(Person p1:people){
            logger.info(p1);
        }
        System.out.println(personService);
        } catch (Exception e){
            System.out.println(e.getMessage());
            logger.info("操作失败，请确认插入和筛选的信息是否正确");
        }
     // 利用循环插入100条数据，因为唯一索引姓名不能重复，所以增加try-catch捕捉异常
        try{
            for(int i=0;i<100;i++){
                person=new Person(System.currentTimeMillis(),"wangxiao"+i,28,"2017777"+i);
                logger.debug(personService.justAdd(person));//执行插入并返回插入后id
            }
        }catch(Exception e){
            logger.info(e.getMessage());
            logger.error("插入失败,姓名有重复");
        }
        System.out.println(personService);
        //利用循环修改数据,因为修改数据涉及姓名所以也需要使用try-catch语句
        try{
            for (int i=0;i<105;i++){
                person=new Person(i,System.currentTimeMillis(),"lisi"+i,25,"2018"+i);
                if (personService.justUpdate(person)){
                    logger.debug("更新成功");
                }else
                    logger.info("修改失败，第"+i+"条信息不存在");
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            logger.error("修改失败，姓名重复");
        }
        //利用循环删除信息,并返回目前表的信息
        for (int i=5;i<105;i++){
            if (personService.justDelete(i)){
                logger.debug("第"+i+"条信息删除成功");
            }else
                logger.info("删除失败，第"+i+"条信息不存在，请查证后再删除");
        }
        //查找指定信息，找不到则抛出异常
       try{ Map parm=new HashMap();
        parm.put("name","lisi8");
        List<Person> list=personService.justList(parm);
        for(Person p1:list)    {
            System.out.println(p1);
        }
        System.out.println(personService);
        }catch (Exception e){
           System.out.println(e.getMessage());
           logger.info("未找到指定信息，请确认后重试");
       }
//        重置表格
       personService.deleteAll();
        long t2=System.currentTimeMillis();
        long t3=t2-t1;
        System.out.println("花费时间"+t3+"毫秒");
        System.out.println(personService);
        System.out.println("程序已运行结束");
    }
    }