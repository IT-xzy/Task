package com.ptteng.controller;

import com.ptteng.entity.Profession;

import com.ptteng.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//  返回json格式的数据

@Controller
public class JsonProfessionController {
    @Autowired
    private ProfessionService professionService;

//    先查询id序列，然后在缓存中查找
    @RequestMapping(value = "/json/profession/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Profession> getProfession(Integer page, Integer size) {
        List<Profession> professionList = professionService.findProfession(page, size);
        return professionList;
    }

    //   不走缓存，查询列表
    @RequestMapping(value = "/test/profession/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Profession> findAll(Integer page, Integer size) {
        List<Profession> professionList = professionService.findAll(page, size);
        return professionList;
    }


}
