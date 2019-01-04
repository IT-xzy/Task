package com.xiaobo.demo.controller;

import com.xiaobo.demo.constant.Global;
import com.xiaobo.demo.pojo.Collection;
import com.xiaobo.demo.pojo.Login;
import com.xiaobo.demo.pojo.Response;
import com.xiaobo.demo.pojo.User;
import com.xiaobo.demo.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/a")
public class CollectionController {
    private static Logger log = Logger.getLogger(CollectionController.class);
    @Autowired
    private CollectionServiceImpl collectionService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    Collection collection;
    @Autowired
    Response response;
    @Autowired
    User user;
    @Autowired
    HttpServletRequest request;
    //获取所有收藏
    @RequestMapping(value = "/u/collection", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getList(@RequestParam(value = "collection_name",required = false) String collection_name,
                                @RequestParam(value = "status",required = false) String status,
                                @RequestParam(value = "page",required = false,defaultValue = "1") String page,
                                @RequestParam(value = "size",required = false,defaultValue = "10") String size){
        // 处理User参数
        Collection collection = new Collection();
        if(collection_name != null && collection_name.length() != 0){
            collection.setCollection_name(collection_name);
        }
        if(status != null && status.length() != 0){
            collection.setStatus(new Integer(status));
        }
        // 处理page和sie
        Map<String,Object> pageData = new HashMap<>();
        pageData.put("offset",(new Integer(page) - 1)* new Integer(size));
        pageData.put("limit",new Integer(size));
        // 查询数据
        List<Collection> collectionList = collectionService.getList(collection,pageData);

        // 更换pageData
        pageData.put("offset",0);
        pageData.put("limit",1000000);
        //获取用户列表
        ArrayList usernameList = new ArrayList();
        for(Collection collectionItem:collectionList){
            Long id = collectionItem.getUpdate_by();
            User user = new User();
            user.setId(id);
            List<User> userList = userService.getList(user,pageData);

            if(userList != null&&userList.size()>=1){
                usernameList.add(userList.get(0).getUsername());
            }
        }

        //获取total
        Integer total = collectionService.getList(collection,pageData).size();
        // 拼装数据，返回结果
        ModelAndView modelAndView = new ModelAndView("collectionList");
        Response response = new Response(total);
        modelAndView.addObject("response",response);
        modelAndView.addObject("collectionList",collectionList);
        modelAndView.addObject("usernameList",usernameList);
        return modelAndView;
    }
    //新增
    @RequestMapping(value = "/u/collection",method = RequestMethod.POST, consumes={"application/json"},produces={"application/json"})
    @ResponseBody
    public ModelAndView add(@Valid @RequestBody Collection collection){
        Object userId = request.getSession().getAttribute(Global.USER_SESSION_KEY);
        collection.setCreate_by(new Long(userId.toString()));
        collection.setUpdate_by(new Long(userId.toString()));
        collection.setCreate_at(new Long(new Date().getTime()));
        collection.setUpdate_at(new Long(new Date().getTime()));
        collection.setStatus(2);
        Boolean result = collectionService.add(collection);
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
    @RequestMapping(value = "/u/collection/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public ModelAndView update(@Valid @RequestBody Collection collection,@PathVariable("id") Long id){
        Object userId = request.getSession().getAttribute(Global.USER_SESSION_KEY);
        collection.setId(id);
        collection.setUpdate_by(new Long(userId.toString()));
        collection.setUpdate_at(new Long(new Date().getTime()));
        Boolean result = collectionService.update(collection);
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
    @RequestMapping(value = "/u/collection/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ModelAndView delete(@PathVariable("id") Long id){
        Collection collection = new Collection();
        collection.setId(id);
        Boolean result = collectionService.delete(collection);
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
