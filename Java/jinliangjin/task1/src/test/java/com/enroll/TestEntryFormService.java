/*
package com.enroll;

import com.enroll.POJO.EntryForm;
import com.enroll.service.EntryFormService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

*/
/**
 * @ProjectName: task1
 * @Package: com.enroll
 * @ClassName: TestEntryFormService
 * @Description: Test EntryFormService
 * @Author: Jin
 * @CreateDate: 2018/4/27 17:52
 * @UpdateUser:
 * @UpdateDate: 2018/4/27 17:52
 * @UpdateRemark:
 * @Version: 1.0*//*



public class TestEntryFormService {
    AbstractApplicationContext aac;
    EntryFormService entryFormService;
    List<EntryForm> list;
    @Before
    public void before(){
        aac = new ClassPathXmlApplicationContext("com.enroll/spring-config.xml");
        entryFormService = (EntryFormService) aac.getBean("entryFormService");
        System.out.println("实例bean。");
    }

    @After
    public void after(){
        System.out.println("摧毁bean。");
        aac.close();

    }
    @Test
    public void updateAndSelectAllTest(){
        EntryForm e= new EntryForm();
        e.setId(1);
        e.setName("万全林");
        list= entryFormService.updateAndSelectAll(e);
        for(EntryForm entryForm:list)
            System.out.println(entryForm);
//        System.out.println(list);
    }
    @Test
    public void batchInsertTest(){
        entryFormService.batchInsert(5);
    }
    @Test
    public void getEntryFormTest(){
        list = entryFormService.getEntryForm(5);
        for(EntryForm entryForm:list)
            System.out.println(entryForm);
    }
    @Test
    public void deleteEntryFormTest(){
        list = entryFormService.deleteEntryForm(15,16,158);
        System.out.println("以下信息被删除：");
        for(EntryForm entryForm:list)
            System.out.println(entryForm);
    }
}
*/
