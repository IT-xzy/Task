package com.xiaobo.demo.controller;

import com.xiaobo.demo.constant.Global;
import com.xiaobo.demo.pojo.*;
import com.xiaobo.demo.pojo.Collection;
import com.xiaobo.demo.service.CategoryServiceImpl;
import com.xiaobo.demo.service.WorkServiceImpl;
import com.xiaobo.demo.service.CollectionServiceImpl;
import com.xiaobo.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;
@Controller
@RequestMapping("/a")
public class WorkController {
    @Autowired
    private WorkServiceImpl workService;
    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private CollectionServiceImpl collectionService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    Work work;
    @Autowired
    Response response;
    @Autowired
    User user;
    @Autowired
    HttpServletRequest request;
    //获取所有work
    @RequestMapping(value = "/u/work", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getList(@RequestParam(value = "work_name",required = false) String work_name,
                                @RequestParam(value = "status",required = false) String status,
                                @RequestParam(value = "page",required = false,defaultValue = "1") String page,
                                @RequestParam(value = "size",required = false,defaultValue = "10") String size){
        // 处理User参数
        Work work = new Work();
        if(work_name != null && work_name.length() != 0){
            work.setWork_name(work_name);
        }
        if(status != null && status.length() != 0){
            work.setStatus(new Integer(status));
        }
        // 处理page和sie
        Map<String,Object> pageData = new HashMap<>();
        pageData.put("offset",(new Integer(page) - 1)* new Integer(size));
        pageData.put("limit",new Integer(size));

        // 查询数据
        List<Work> workList = workService.getList(work,pageData);
        // 更换pageData
        pageData.put("offset",0);
        pageData.put("limit",1000000);
        //获取用户列表,collection列表
        ArrayList usernameList = new ArrayList();
        ArrayList categoryNameList = new ArrayList();
        ArrayList collectionNameList = new ArrayList();
        for(Work workItem:workList){
            // 用户
            Long id = workItem.getUpdate_by();
            User user = new User();
            user.setId(id);
            List<User> userList = userService.getList(user,pageData);
            if(userList != null&&userList.size()>=1){
                usernameList.add(userList.get(0).getUsername());
            }
            // category
            Long category_id = workItem.getCategory_id();
            Category category = new Category();
            category.setId(category_id);
            List<Category> categoryList = categoryService.getList(category,pageData);
            if(categoryList != null && categoryList.size()>=1){
                categoryNameList.add(categoryList.get(0).getCategory_name());
            }
            // collection
            Long collection_id = categoryList.get(0).getCollection_id();
            Collection collection = new Collection();
            collection.setId(collection_id);
            List<Collection> collectionList = collectionService.getList(collection,pageData);
            if(collectionList != null && collectionList.size()>=1){
                collectionNameList.add(collectionList.get(0).getCollection_name());
            }
        }

        // 获取total
        Integer total = workService.getList(work,pageData).size();
        // 拼装数据，返回结果
        ModelAndView modelAndView = new ModelAndView("workList");
        Response response = new Response(total);
        modelAndView.addObject("response",response);
        modelAndView.addObject("workList",workList);
        modelAndView.addObject("usernameList",usernameList);
        modelAndView.addObject("categoryNameList",categoryNameList);
        modelAndView.addObject("collectionNameList",collectionNameList);
        return modelAndView;
    }
    //新增
    @RequestMapping(value = "/u/work",method = RequestMethod.POST, consumes={"application/json"},produces={"application/json"})
    @ResponseBody
    public ModelAndView add(@Valid @RequestBody Work work){
        Object userId = request.getSession().getAttribute(Global.USER_SESSION_KEY);
        work.setCreate_by(new Long(userId.toString()));
        work.setUpdate_by(new Long(userId.toString()));
        work.setCreate_at(new Long(new Date().getTime()));
        work.setUpdate_at(new Long(new Date().getTime()));
        work.setStatus(2);
        Boolean result = workService.add(work);
        System.out.println(result);
        Response response;
        if(result){
            response = new Response();
        }else{
            response = new Response(400,"参数错误");
        }
        return new ModelAndView("response","data",response);
    }
    //修改
    @RequestMapping(value = "/u/work/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public ModelAndView update(@Valid @RequestBody Work work,@PathVariable("id") Long id){
        Object userId = request.getSession().getAttribute(Global.USER_SESSION_KEY);
        work.setId(id);
        work.setUpdate_by(new Long(userId.toString()));
        work.setUpdate_at(new Long(new Date().getTime()));
        Boolean result = workService.update(work);
        System.out.println(result);
        Response response;
        if(result){
            response = new Response();
        }else{
            response = new Response(400,"操作失败");
        }
        return new ModelAndView("response","data",response);
    }
    //删除
    @RequestMapping(value = "/u/work/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ModelAndView delete(@PathVariable("id") Long id){
        Work work = new Work();
        work.setId(id);
        Boolean result = workService.delete(work);
        System.out.println(result);
        Response response;
        if(result){
            response = new Response();
        }else{
            response = new Response(400,"操作失败");
        }
        return new ModelAndView("response","data",response);
    }
}
