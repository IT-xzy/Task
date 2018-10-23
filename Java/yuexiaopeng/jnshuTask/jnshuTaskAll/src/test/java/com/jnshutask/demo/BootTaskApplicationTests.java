package com.jnshutask.demo;

import com.jnshutask.BootTaskApplication;
import com.jnshutask.pojo.TaStudent;
import com.jnshutask.service.TaStudentService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.StringAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Set;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes=BootTaskApplication.class)
public class BootTaskApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Autowired
    TaStudentService taStudentService;
    @Test
    public void student1() {
        TaStudent taStudent=taStudentService.selectById(null);
        log.info("测试查询的结果为{}",taStudent);
    }
    @Test
    public void student2() {
        int i=taStudentService.deleteById(26);
        log.info("测试删除的结果为{}",i);
    }
    @Test
    public void student3() {
        List<TaStudent> list=taStudentService.selectPage(1,4);
        for(TaStudent t:list) {
            log.info("测试分页查询的结果为{}", t);
        }
    }
    @Test
    public void student4() {
        TaStudent taStudent=new TaStudent();
        taStudent.setId(27);
        taStudent.setName("测试时是十四");
        TaStudent taStudent1=taStudentService.updateById(taStudent);
        log.info("更新后的数据结果为{}", taStudent1);
    }
    @Test
    public void student5() {
        TaStudent taStudent=new TaStudent();
        taStudent.setName("测试时是十四");
        TaStudent taStudent1=taStudentService.insertSelective(taStudent);
        log.info("插入后的数据结果为{}", taStudent1);
    }
    @Test
    public void student6() {
        TaStudent taStudent=new TaStudent();
        taStudent.setName("测试时是十四");
        try{
            Assert.notNull(taStudent.getId(),"student id is null");
        }catch (IllegalArgumentException e) {
            log.info(e.getMessage());
        }
    }

}
