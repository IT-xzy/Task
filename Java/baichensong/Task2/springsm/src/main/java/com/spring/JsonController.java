package com.spring;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pojo.Pojo;
import com.pojo.User;
import com.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

// json 的练习test 1/2/3  与项目无关连 -----------------controller
@Controller
@RequestMapping("")
public class JsonController {
    @Autowired
    private UserService userService;
    @RequestMapping("/test1")    //拦截 url
    @ResponseBody   // 用@ResponseBody 来 接 json提交的数据。    不会再 返回到view处理器 而是直接返回到body。。。
   public String test1(Model model){
        //JSON提供的对象 --JSONObject   可以直接在Java里面使用。
        JSONObject ao = new JSONObject();
        ao.put("id",66);
        ao.put("name","baichensong");

        JSONObject bo = new JSONObject();
        bo.put("id",88);
        bo.put("name","name");

        // 数组
        JSONArray co = new JSONArray();
        co.add(ao);
        co.add(bo);

        return co.toString();

    }



@RequestMapping("/test2")
//用 @ResponseBody 直接将 java 对象 转为 json、类型 。
    public @ResponseBody Object test2(){
            Pojo a = new Pojo();
            a.setId(1);
            a.setName("name");
            Pojo b = new Pojo();
            return a;
}


//用  json-taglib标签
@RequestMapping("/test3")
    public String test3(Model model){
        Pojo a = new Pojo();
        a.setId(2);
        a.setName("hello");
        Pojo b = new Pojo();
        b.setId(3);
        b.setName("world");

        List<Pojo> c = new ArrayList<>();
        c.add(a);
        c.add(b);
        model.addAttribute("json",c);
        System.out.println(c);
        return "/Taglib";
}



// axja用-------返回控制
@RequestMapping(value = "/sumbit")
    public String nihao(){
        return "JSONform";
}



//axja----表单数据
@RequestMapping(value ="test/send")
    @ResponseBody
    public String send(User user){
        userService.insertUser(user);
        System.out.println(user);
return "ok";
}


}

