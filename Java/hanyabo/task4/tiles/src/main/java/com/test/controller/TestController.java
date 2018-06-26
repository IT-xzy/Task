package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/tiles")
public class TestController {

    @RequestMapping(value="/zero")
    public String getTest(HttpServletRequest request,Map<String,Object> map){

        long timeTemp=System.currentTimeMillis()/1000;
        map.put("currenttime", timeTemp);
        return "zero";//返回tiles定义中的name

    }

    @RequestMapping(value="/first")
    public String getTest1(HttpServletRequest request){

        return "first";//返回tiles定义中的name

    }

    @RequestMapping(value="/second")
    public String getTest2(HttpServletRequest request,Map<String,Object> map){

        //获取请求参数
        String time = request.getParameter("nowtime");
        System.out.println(time);
        map.put("nowtimea", time);

        return "second";//返回tiles定义中的name

    }
}