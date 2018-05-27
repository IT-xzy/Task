package com.ssm_yl.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm_yl.pojo.Category;
import com.ssm_yl.page.Page;
import com.ssm_yl.service.CategoryService;
//import com.ssm_yl.util.XmemcachedUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("ssm")
public class CategoryController {
    private static Logger logger = LoggerFactory.getLogger(CategoryController.class);
     private static ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
      private static CategoryService categoryService ;
//    @Autowired
//    XmemcachedUtil xmemcachedUtil;

//     @Autowired
//    RedisUtil redisUtil;

     private static int flagA=0;
     private static int flagB=0;

     @Scheduled(cron="0 0/30 * * * ?")
     static void print() {
          flagA=0;
          flagB=0;
         System.out.println("将A,B服务器状态重新定义为可用状态");
     }

//    @Autowired
//    CategoryService categoryService;

    private static CategoryService selectServer() throws RemoteException, NotBoundException, MalformedURLException {
         if(Math.random()>0.5&&flagA==0){
            try {
                categoryService = (CategoryService) Naming.lookup("//127.0.0.1:8099/CategoryServiceRMI");
                categoryService.select(1);
                System.out.println("正在使用server1");
            }catch (Exception e){
                flagA = 1;
                categoryService = (CategoryService) Naming.lookup("//127.0.0.1:8098/CategoryServiceRMI");
                System.out.println("server1已经挂掉,正在尝试连接server2");
            }

         }
         else if (flagB==0){
             try{
                 categoryService = (CategoryService) Naming.lookup("//127.0.0.1:8098/CategoryServiceRMI");
                 categoryService.select(1);
                 System.out.println("正在使用server2");
             }catch (Exception e){
                 flagB=1;
                 categoryService = (CategoryService) Naming.lookup("//127.0.0.1:8099/CategoryServiceRMI");
                 System.out.println("server2已经挂掉,正在尝试连接server1");
             }
         }
         else if (flagA==1&&flagB==1){
             System.out.println("服务器全都挂掉,请尽快修理");
         }
            return categoryService;
     }

    @RequestMapping(value = "/listStudent", method = RequestMethod.GET)
    public ModelAndView list( @RequestParam(required=true,defaultValue="1") Integer pageNum) throws RemoteException, NotBoundException, MalformedURLException {
         categoryService = selectServer();
         PageInfo page= categoryService.page(pageNum);
        ModelAndView mav = new ModelAndView("listStudent");
        mav.addObject("cs", page.getList());
        mav.addObject("page",page);
        return mav;
    }

    @RequestMapping(value = "/student/students", method = RequestMethod.GET)
    public ModelAndView select(@RequestParam("id") int id) throws RemoteException, NotBoundException, MalformedURLException {
        categoryService = selectServer();
         Category category=categoryService.select( id);
        List<Category> categories = new ArrayList<Category>();
        if (null != category) {
            categories.add( category);
        }
        ModelAndView mav = new ModelAndView("listStudent");
        mav.addObject("cs",categories);
        return mav;
    }
    @RequestMapping(value = "/student/user")
    public String information() {
        return "profile";
    }

    @RequestMapping(value = "/student/users",method = RequestMethod.POST)
    public String insertCategory(@ModelAttribute("student")  Category category ) throws RemoteException, NotBoundException, MalformedURLException {
        categoryService = selectServer();
         categoryService.insertCategory(category);
        return "redirect:/ssm/listStudent ";
    }
    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id ) throws RemoteException, NotBoundException, MalformedURLException {
        categoryService = selectServer();
         categoryService.delete(id);
        return "redirect:/ssm/listStudent";
    }
    @RequestMapping(value ="/student/profile/{id}",method = RequestMethod.GET)
    public ModelAndView update1(@PathVariable("id") int id) throws RemoteException, NotBoundException, MalformedURLException {
        categoryService = selectServer();
         Category category = categoryService.select(id);
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("up", category);
        return modelAndView;
    }
    @RequestMapping(value = "/student/{id}" ,method =RequestMethod.POST)
    public String update( @PathVariable("id") int id,@ModelAttribute("sd") Category category) throws RemoteException, NotBoundException, MalformedURLException {
        categoryService = selectServer();
         category.setId(id);
        categoryService.update(category);

        return "redirect:/ssm/listStudent";
    }
    //json-taglib
//    @RequestMapping(value = "/json/students2", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
//    public String jsonListAllStudents2(Model model) throws RemoteException, NotBoundException, MalformedURLException {
        /*
使用Memcached缓存M
List<Category> students;
//        if(xmemcachedUtil.get("JsonList")==null){
//            xmemcachedUtil.set("JsonList",0,categoryService.list());
//             students = xmemcachedUtil.get("JsonList");
//        }
//        else students = xmemcachedUtil.get("JsonList");
//           model.addAttribute("list", students);
使用Redis缓存
List<Category> students;
if(redisUtil.get("RedisJsonList")==null){
redisUtil.set("RedisJsonList",categoryService.list());
students = (List<Category>) redisUtil.get("RedisJsonList");
}
else students = (List<Category>) redisUtil.get("RedisJsonList");
model.addAttribute("list",students);
不使用缓存
*/

//        categoryService = selectServer();
//        List<Category> students =  categoryService.list();
//        model.addAttribute("list", students);
//           return "students2";
//    }
}