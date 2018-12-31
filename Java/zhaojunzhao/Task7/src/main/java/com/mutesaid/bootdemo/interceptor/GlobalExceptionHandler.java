package com.mutesaid.bootdemo.interceptor;

import com.mutesaid.bootdemo.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private static final int ERROR_CODE = -10000;

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response<String> errorHandler(HttpServletRequest request, Throwable t) {
        String requestURL = request.getRequestURL().toString();
        String message = t.getMessage();
        Response<String> r = new Response<>();
        r.setCode(ERROR_CODE);
        r.setMessage("系统错误");
        r.setData(requestURL);
        log.info("Global exception = {}", message);
        return r;
    }
}
