package com.xiaobo.demo.util;

import com.xiaobo.demo.pojo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ParamsInterceptor {
    @Autowired
    Response response;
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ModelAndView bindException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String errorMessage = "";
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMessage += fieldError.getDefaultMessage() + ", ";
        }
        System.out.println(errorMessage);
        Response response = new Response(400,errorMessage);
        return new ModelAndView("response","data",response);
    }
}
