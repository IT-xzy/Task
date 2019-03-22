package com.jnshu.task2.validator;

import com.jnshu.task2.beans.Student;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Repository("StudentValidator")
public class StudentValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Student.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(@Nullable Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","null","姓名不能为空");
        Student student = (Student) o;
        if(student.getName().length() > 10){
            errors.rejectValue("name",null,"用户名长度不能超过10");
        }
    }

















}
