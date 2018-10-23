package com.jnshutask.service;

import com.jnshutask.pojo.TaStudent;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.Valid;
import java.util.List;

public class TestValition {

    public String test222(@Valid TaStudent taStudent)  {
        String test = "haha";
        System.out.println(taStudent);
//        if (bindingResult.hasErrors()) {
//            List<FieldError> allErrors = bindingResult.getFieldErrors();
//            for (FieldError objectError : allErrors) {
//                System.out.println(objectError.getDefaultMessage());
//
//            }
//            test="failed";
//        }

        return test;
    }
}
