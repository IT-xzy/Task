package com.jnshu.controller;

import com.jnshu.model.UserCustom;
import com.jnshu.tools.MemcacheUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


/**
 * @program: taskTwo
 * @description: MemCache 缓存接口
 * @author: Mr.xweiba
 * @create: 2018-05-19 00:06
 **/

@Controller
@RequestMapping("/memcache")
public class MemCacheController {
    @Autowired
    MemcacheUtils memcacheUtils;
    private static Logger logger = LoggerFactory.getLogger(MemCacheController.class);

    /**
    * @Description: 获取key为id的user缓存
    * @Param: [key]
    * @return: java.lang.Object
    * @Author: Mr.Wang
    * @Date: 2018/5/19
    */
    @RequestMapping(value = "/api/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object findByKey(@RequestBody @PathVariable("id") String key){
        if(StringUtils.isEmpty(key)){
            return "key must not be empty or null!";
        }
        return memcacheUtils.get("user" + key);
    }

    /**
    * @Description: 缓存更新接口 当key不存在时取消更新
    * @Param: [key, userCustom] 键. 值
    * @return: boolean
    * @Author: Mr.Wang
    * @Date: 2018/5/19
    */
    @RequestMapping(value = "/api/{id}", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public boolean updateByKey(@PathVariable("id") String key, @RequestBody UserCustom userCustom){
        userCustom.setId(Integer.valueOf(key));
        if(StringUtils.isEmpty(key)){
            return false;
        }
        return memcacheUtils.replace("user" + key, userCustom);
    }
    
    /** 
    * @Description: 增加缓存数据 当键存在时取消存入
    * @Param: [key, userCustom] 键, 值 
    * @return: java.lang.Boolean 
    * @Author: Mr.Wang 
    * @Date: 2018/5/19 
    */
    @RequestMapping(value = "/api/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Boolean insert(@PathVariable("id") String key, @RequestBody UserCustom userCustom){
        System.out.println(userCustom.toString());
        userCustom.setId(Integer.valueOf(key));
        if(StringUtils.isEmpty(key)){
            return false;
        }
        return memcacheUtils.add("user" + key, userCustom);
    }
    
    /** 
    * @Description: 删除指定key 
    * @Param: [key] 
    * @return: java.lang.Boolean 
    * @Author: Mr.Wang 
    * @Date: 2018/5/19 
    */ 
    @RequestMapping(value = "/api/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Boolean deleteByKey(@PathVariable("id") String key){
        if(StringUtils.isEmpty(key)){
            return false;
        }
        return memcacheUtils.delete("user" + key);
    }
    /**
     * @Description: 清除缓存中的所有键值对
     * @Param: []
     * @return: boolean
     * @Author: Mr.Wang
     * @Date: 2018/5/19
     */
    @RequestMapping(value = "/api/all", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean flashAll() throws Exception {
        logger.info("mem缓存已清除");
        return memcacheUtils.flashAll();
    }
}
