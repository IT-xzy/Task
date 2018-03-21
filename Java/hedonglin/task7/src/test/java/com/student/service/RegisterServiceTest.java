package com.student.service;

import com.student.model.Register;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class RegisterServiceTest {

    @Resource
    private RegisterService registerService;

    @Test
    public void deleteByPrimaryKey() {
        registerService.deleteByPrimaryKey(1L);
    }

    @Test
    public void insert() {
        Register register = new Register();
        register.setCellphone("123");
        register.setCode("123456");
        register.setCreateAt(System.currentTimeMillis());
        register.setUpdateAt(System.currentTimeMillis());
        register.setEmail("3245321@qq.com");
        registerService.insert(register);
        System.out.println(register);
    }


    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
        Register register=registerService.selectByPrimaryKey(1L);
        System.out.println(register);
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
        Register register = new Register();
        register.setId(1L);
        register.setCode("11111111111");
        register.setEmail("22222222222");
        register.setCellphone("33333333333");
        registerService.updateByPrimaryKey(register);


    }

    @Test
    public void selectFinalCodeByCellphone() {
        Register register = registerService.selectFinalCodeByCellphone("13215274013");
        String code=register.getCode();
        System.out.println(code);
    }

    @Test
    public void selectCellphoneSize() {
        System.out.println(registerService.selectCellphoneSize("13215274013"));
    }

    @Test
    public void getAllRegister() {
        System.out.println(registerService.getAllRegister());
    }

    @Test
    public void getEmailCodeByEmail() {
        String emailCode=registerService.getEmailCodeByEmail("3245321@qq.com");
        System.out.println(emailCode);
    }
}