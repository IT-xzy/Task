package com.xiaobo.demo.controller;

import com.xiaobo.demo.constant.Global;
import com.xiaobo.demo.pojo.Category;
import com.xiaobo.demo.pojo.Collection;
import com.xiaobo.demo.pojo.Response;
import com.xiaobo.demo.pojo.User;
import com.xiaobo.demo.service.CategoryServiceImpl;
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
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private CollectionServiceImpl collectionService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    Category category;
    @Autowired
    Response response;
    @Autowired
    User user;
    @Autowired
    HttpServletRequest request;
    //获取所有收藏
    @RequestMapping(value = "/u/category", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getList(@RequestParam(value = "category_name",required = false) String category_name,
                                @RequestParam(value = "status",required = false) String status,
                                @RequestParam(value = "page",required = false,defaultValue = "1") String page,
                                @RequestParam(value = "size",required = false,defaultValue = "10") String size){
        // 处理User参数
        Category category = new Category();
        if(category_name != null && category_name.length() != 0){
            category.setCategory_name(category_name);
        }
        if(status != null && status.length() != 0){
            category.setStatus(new Integer(status));
        }
        // 处理page和sie
        Map<String,Object> pageData = new HashMap<>();
        pageData.put("offset",(new Integer(page) - 1)* new Integer(size));
        pageData.put("limit",new Integer(size));

        // 查询数据
        List<Category> categoryList = categoryService.getList(category,pageData);
        // 更换pageData
        pageData.put("offset",0);
        pageData.put("limit",1000000);
        //获取用户列表,collection列表
        ArrayList usernameList = new ArrayList();
        ArrayList collectionNameList = new ArrayList();
        for(Category categoryItem:categoryList){
            // 用户
            Long id = categoryItem.getUpdate_by();
            User user = new User();
            user.setId(id);
            List<User> userList = userService.getList(user,pageData);
            if(userList != null&&userList.size()>=1){
                usernameList.add(userList.get(0).getUsername());
            }
            // collection
            Long collection_id = categoryItem.getCollection_id();
            Collection collection = new Collection();
            collection.setId(collection_id);
            List<Collection> collectionList = collectionService.getList(collection,pageData);
            if(collectionList != null && collectionList.size()>=1){
                collectionNameList.add(collectionList.get(0).getCollection_name());
            }
        }

        // 获取total
        Integer total = categoryService.getList(category,pageData).size();
        // 拼装数据，返回结果
        ModelAndView modelAndView = new ModelAndView("categoryList");
        Response response = new Response(total);
        modelAndView.addObject("response",response);
        modelAndView.addObject("categoryList",categoryList);
        modelAndView.addObject("usernameList",usernameList);
        modelAndView.addObject("collectionNameList",collectionNameList);
        return modelAndView;
    }
    //新增
    @RequestMapping(value = "/u/category",method = RequestMethod.POST, consumes={"application/json"},produces={"application/json"})
    @ResponseBody
    public ModelAndView add(@Valid @RequestBody Category category){
        Object userId = request.getSession().getAttribute(Global.USER_SESSION_KEY);
        category.setCreate_by(new Long(userId.toString()));
        category.setUpdate_by(new Long(userId.toString()));
        category.setCreate_at(new Long(new Date().getTime()));
        category.setUpdate_at(new Long(new Date().getTime()));
        category.setStatus(2);
        Boolean result = categoryService.add(category);
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
    @RequestMapping(value = "/u/category/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public ModelAndView update(@Valid @RequestBody Category category,@PathVariable("id") Long id){
        Object userId = request.getSession().getAttribute(Global.USER_SESSION_KEY);
        category.setId(id);
        category.setUpdate_by(new Long(userId.toString()));
        category.setUpdate_at(new Long(new Date().getTime()));
        Boolean result = categoryService.update(category);
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
    @RequestMapping(value = "/u/category/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ModelAndView delete(@PathVariable("id") Long id){
        Category category = new Category();
        category.setId(id);
        Boolean result = categoryService.delete(category);
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
