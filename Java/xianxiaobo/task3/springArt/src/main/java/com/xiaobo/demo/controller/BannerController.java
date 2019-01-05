package com.xiaobo.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xiaobo.demo.constant.Global;
import com.xiaobo.demo.pojo.Banner;
import com.xiaobo.demo.pojo.Response;
import com.xiaobo.demo.pojo.User;
import com.xiaobo.demo.service.BannerServiceImpl;
import com.xiaobo.demo.service.CommonServiceImpl;
import com.xiaobo.demo.service.UserServiceImpl;
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
public class BannerController {
    private static Logger log = Logger.getLogger(BannerController.class);
    @Autowired
    private BannerServiceImpl bannerService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private CommonServiceImpl commonService;
    @Autowired
    Response response;
    @Autowired
    User user;
    @Autowired
    HttpServletRequest request;
    //获取所有收藏
    @RequestMapping(value = "/u/banner", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getList(@RequestParam(value = "status",required = false) String status,
                                @RequestParam(value = "page",required = false,defaultValue = "1") String page,
                                @RequestParam(value = "size",required = false,defaultValue = "10") String size){
        // 处理User参数
        Banner banner = new Banner();

        if(status != null && status.length() != 0){
            banner.setStatus(new Integer(status));
        }
        // 处理page和sie
        Map<String,Object> pageData = new HashMap<>();
        pageData.put("offset",(new Integer(page) - 1)* new Integer(size));
        pageData.put("limit",new Integer(size));
        // 查询数据
        List<Banner> bannerList = bannerService.getList(banner,pageData);

        // 更换pageData
        pageData.put("offset",0);
        pageData.put("limit",1000000);
        //获取用户列表
        ArrayList usernameList = new ArrayList();
        for(Banner bannerItem:bannerList){
            Long id = bannerItem.getUpdate_by();
            User user = new User();
            user.setId(id);
            List<User> userList = userService.getList(user,pageData);

            if(userList != null&&userList.size()>=1){
                usernameList.add(userList.get(0).getUsername());
            }
        }

        //获取total
        Integer total = bannerService.getList(banner,pageData).size();
        // 拼装数据，返回结果
        ModelAndView modelAndView = new ModelAndView("bannerList");
        Response response = new Response(total);
        modelAndView.addObject("response",response);
        modelAndView.addObject("bannerList",bannerList);
        modelAndView.addObject("usernameList",usernameList);
        return modelAndView;
    }
    //新增
    @RequestMapping(value = "/u/banner",method = RequestMethod.POST, consumes={"application/json"},produces={"application/json"})
    @ResponseBody
    public ModelAndView add(@Valid @RequestBody Banner banner){
        Object userId = request.getSession().getAttribute(Global.USER_SESSION_KEY);
        banner.setCreate_by(new Long(userId.toString()));
        banner.setUpdate_by(new Long(userId.toString()));
        banner.setCreate_at(new Long(new Date().getTime()));
        banner.setUpdate_at(new Long(new Date().getTime()));
        banner.setStatus(2);
        banner.setSort(commonService.getTotal("banner")+1);
        Boolean result = bannerService.add(banner);
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
    @RequestMapping(value = "/u/banner/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public ModelAndView update(@Valid @RequestBody Banner banner,@PathVariable("id") Long id){
        Object userId = request.getSession().getAttribute(Global.USER_SESSION_KEY);
        banner.setId(id);
        banner.setUpdate_by(new Long(userId.toString()));
        banner.setUpdate_at(new Long(new Date().getTime()));
        Boolean result = bannerService.update(banner);
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
    @RequestMapping(value = "/u/banner/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ModelAndView delete(@PathVariable("id") Long id){
        Banner banner = new Banner();
        banner.setId(id);
        Boolean result = bannerService.delete(banner);
        System.out.println(result);
        Response response;
        if(result){
            response = new Response();
        }else{
            response = new Response(400,"操作失败");
        }
        return new ModelAndView("response","data",response);
    }
    //修改排序 (这种为在for循环中操作，不推荐）
    @RequestMapping(value = "/u/banner/sort2",method = RequestMethod.PUT)
    @ResponseBody
    public ModelAndView updateSort(@Valid @RequestBody JSONArray sortList){
        log.info("排序列表");
        log.info(sortList);
        Map<String,Object> pageData = new HashMap<>();
        pageData.put("offset",0);
        pageData.put("limit",1000000);
        Banner banner = new Banner();
        List<Banner> bannerList = bannerService.getList(banner,pageData);
        ArrayList bannerIdList = new ArrayList();
        for(Banner bannerItem:bannerList){
            bannerIdList.add(bannerItem.getId());
        }
        log.info("bannerID列表");
        log.info(bannerIdList);
        Response response;
        if(bannerIdList.size() == sortList.size()){
            response = new Response();
            for(int i=0;i<bannerIdList.size();i++){
                Banner banner1 = new Banner();
                banner1.setId(new Long(bannerIdList.get(i).toString()));
                banner1.setSort(new Integer(sortList.get(i).toString()));
                Boolean result = bannerService.update(banner1);
                if(!result){
                    response = new Response(400,"数据库操作失败" + banner1.getId());
                }
            }
        }else{
            response = new Response(400,"传入的长度与数据库中数量不一致");
        }
        return new ModelAndView("response","data",response);
    }
    //修改排序 (这种在xml文件中拼接，推荐）
    @RequestMapping(value = "/u/banner/sort",method = RequestMethod.PUT)
    @ResponseBody
    public ModelAndView updateSort2(@Valid @RequestBody JSONArray sortList){

        log.info(sortList);
        Map<String,Object> pageData = new HashMap<>();
        pageData.put("offset",0);
        pageData.put("limit",1000000);
        Banner banner = new Banner();
        List<Banner> bannerList = bannerService.getList(banner,pageData);
        ArrayList bannerIdList = new ArrayList();
        for(Banner bannerItem:bannerList){
            bannerIdList.add(bannerItem.getId());
        }
        log.info("bannerID列表");
        log.info(bannerIdList);
        Response response;

        ArrayList bannerSortList = new ArrayList();
        if(bannerIdList.size() == sortList.size()){

            response = new Response();
            for(int i=0;i<bannerIdList.size();i++){
                Banner banner1 = new Banner();
                banner1.setId(new Long(bannerIdList.get(i).toString()));
                banner1.setSort(new Integer(sortList.get(i).toString()));
                bannerSortList.add(banner1);
            }
            Integer result = bannerService.updateBatchSort(bannerSortList);
            if(result>0){
                response = new Response(400,"数据库操作修改条数"+result);
            }else{
                System.out.println("操作失败");
            }
        }else{
            response = new Response(400,"传入的长度与数据库中数量不一致");
        }
        return new ModelAndView("response","data",response);
    }
    //修改status (这种在xml文件中拼接，推荐）
    @RequestMapping(value = "/u/banner/batchStatus",method = RequestMethod.PUT)
    @ResponseBody
    public ModelAndView updateBatchStatus(@Valid @RequestBody JSONObject data){
        Object userId = request.getSession().getAttribute(Global.USER_SESSION_KEY);
        log.info("批量上下架");
        log.info(data);
        log.info(data.get("ids"));
        log.info(data.get("status"));
        ArrayList idList = new ArrayList(data.getJSONArray("ids"));
        Integer status = new Integer(data.get("status").toString());
        log.info(idList);
        log.info(status);

        Banner banner = new Banner();
        banner.setUpdate_by(new Long(userId.toString()));
        banner.setUpdate_at(new Long(new Date().getTime()));
        banner.setStatus(status);
        Integer result = bannerService.updateBatch(banner,idList);
        log.info(result);
        Response response = new Response(200,"修改了"+result+"条数据");

        return new ModelAndView("response","data",response);
    }
}
