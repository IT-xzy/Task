package com.ptteng.controller;


import com.ptteng.entity.Collection;
import com.ptteng.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
public class CollectionController {

    @Autowired
    private CollectionService service;

//    查询列表模块
    @RequestMapping(value = "/a/u/collection/list", method = RequestMethod.GET)
    public ModelAndView getCollection(Integer page, Integer size, String keyword) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println("page===" + page + "size===" + size + "keyword===" + keyword);
//        给page和size设置初值
        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 10;
        }
        try {
            List<Collection> collectionList = service.findPageCollection(page, size, keyword);
            System.out.println(collectionList);
            modelAndView.addObject("data", collectionList);
            modelAndView.addObject("code", 0);
        } catch (Exception e) {
            modelAndView.addObject("code", -1);
        }
        long total = service.countCollection();
        modelAndView.addObject("total", total);
        modelAndView.addObject("page", page);
        modelAndView.setViewName("collection");
        return modelAndView;
    }

//   查询单条信息
    @RequestMapping(value = "/a/u/collection/{id}", method = RequestMethod.GET)
    public ModelAndView findById(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println(id);
        Collection collection = service.findById(id);
        System.out.println(collection);
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("star", collection);
        System.out.println(hashMap);
        modelAndView.addObject("data", hashMap);
        if (collection == null) {
            modelAndView.addObject("code", -1);
        } else {
            modelAndView.addObject("code", 0);
        }
        modelAndView.setViewName("collection");

        return modelAndView;
    }

    @RequestMapping(value = "/a/u/collection/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteById(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println(id);
        Boolean row = service.deleteById(id);
        if (row = true) {
            modelAndView.addObject("code", 0);
        } else {
            modelAndView.addObject("code", -1);
        }
        modelAndView.setViewName("collection");
        return modelAndView;
    }

    @RequestMapping(value = "/a/u/collection", method = RequestMethod.PUT)
    public ModelAndView updateCollection(Collection collection) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println(collection);
        Boolean row = service.updateCollection(collection);
        if (row = true) {
            modelAndView.addObject("code", 0);
        } else {
            modelAndView.addObject("code", -1);
        }
        modelAndView.setViewName("collection");
        return modelAndView;
    }

    @RequestMapping(value = "/a/u/collection", method = RequestMethod.POST)
    public ModelAndView insertCollection(Collection collection) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("哈哈哈！我来了");
        System.out.println(collection);
        try {
            service.insertCollection(collection);
            modelAndView.addObject("code", 0);
        } catch (Exception e) {
            modelAndView.addObject("code", -1);
        }
        modelAndView.setViewName("collection");
        return modelAndView;
    }


}



