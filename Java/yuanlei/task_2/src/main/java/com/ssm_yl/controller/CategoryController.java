package com.ssm_yl.controller;

import com.ssm_yl.category.Category;
import com.ssm_yl.service.CategoryService;
import com.ssm_yl.serviceImpl.ServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ssm")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/listStudent", method = RequestMethod.GET)
    public ModelAndView list() {
        List<Category> category = categoryService.list();
        ModelAndView mav = new ModelAndView("listStudent");
        mav.addObject("cs", category);
        return mav;
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public ModelAndView select(@RequestParam("id") int id) {
        Category category=categoryService.select( id);
        List<Category> categories = new ArrayList<Category>();
        if (null != category) {
            categories.add( category);
        }
        ModelAndView mav = new ModelAndView("listStudent");
        mav.addObject("cs",categories);
        return mav;
    }
    @RequestMapping(value = "/add")
    public String information() {
        return "profile";
    }

    @RequestMapping(value = "/add/student",method = RequestMethod.POST)
    public String insertCategory(@ModelAttribute("student")  Category category ){
        System.out.println(category);
        categoryService.insertCategory(category);
        return "redirect:/ssm/listStudent ";
    }

    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id ){
        categoryService.delete(id);
        return "redirect:/ssm/listStudent";
    }
    @RequestMapping(value ="/student/profile/{id}",method = RequestMethod.GET)
    public ModelAndView update1(@PathVariable("id") int id) {
        Category category = categoryService.select(id);
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("up", category);
        return modelAndView;
    }
    @RequestMapping(value = "/update/{id}" ,method =RequestMethod.GET)
    public String update( @PathVariable("id") int id,@ModelAttribute("sd") Category category) {
        category.setId(id);
        categoryService.update(category);

        return "redirect:/ssm/listStudent";
    }
}