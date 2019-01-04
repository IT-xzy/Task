package com.xiaobo.demo.controller;


import com.xiaobo.demo.service.TuscanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TuscanyController {
    @Autowired
    TuscanyService tuscanyService;
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public String getTest(){
        return "It's a test";
    }
    @RequestMapping(value = "/tuscany",method = RequestMethod.GET)
    @ResponseBody
    public String getTuscany(@RequestParam(value="page",required = false,defaultValue = "1")Integer page,
                             @RequestParam(value = "size",required = false,defaultValue = "2")Integer size){
        tuscanyService.getCalculatorService().add(page,size);
        return String.valueOf(tuscanyService.getCalculatorService().add(page,size));
    }

}
