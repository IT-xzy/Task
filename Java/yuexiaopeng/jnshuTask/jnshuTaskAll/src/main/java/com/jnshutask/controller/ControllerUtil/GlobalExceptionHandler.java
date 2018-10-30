package com.jnshutask.controller.ControllerUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebResult;
import javax.servlet.http.HttpServletRequest;
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseBody
//    public ResponseBo handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
//        log.error(e.getMessage(), e);
//        ResponseBo responseBo=ResponseBo.error();
//        responseBo.put("msg",e.getMessage());
////        responseBo.put("msg",e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
//        return responseBo;
//    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseBo bindException(BindException e){
        log.error(e.getMessage(), e);
        ResponseBo responseBo=ResponseBo.error();
        responseBo.put("msg",e.getFieldErrors());
//        responseBo.put("msg",e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return responseBo;
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseBo errorHandler(HttpServletRequest request, Exception e)  {
        ResponseBo responseBo=ResponseBo.error();
        responseBo.put("code","500");
        responseBo.put("msg",e.getMessage());
        log.error("**调用controller出错;前端得到的信息:{};具体信息为:{},出错的请求地址为:{}**"
                ,responseBo,e.getClass().getName(),request.getRequestURL().toString());
        return responseBo;
    }


}
