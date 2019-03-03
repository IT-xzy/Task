/*
package com.jnshu.task5.validation;

import com.jnshu.task5.beans.Login;
import com.jnshu.task5.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Repository("LoginValidation")
public class LoginValidation implements Validator{
    @Autowired
    LoginService loginService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Login.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(@Nullable Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"loginName","null","用户名不能为空");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"pwd","null","密码不能为空");

//       loginService.selectLoginByName(login);
    }
}
*/
