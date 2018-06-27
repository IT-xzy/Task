package com.redis;


import com.RedisTest.RedisUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;


@Controller
@RequestMapping("")
public class MemberController {
    private  Logger logger = LoggerFactory.getLogger(MemberController.class);
    @Autowired
    private MemberService memberService;

     // 打开连接池
     private Jedis jedis = RedisUtil.getJedis();

    /*
     * 添加单个对象
     * @param request
     * @param response
     * @param modelMap
     * @return
     */
    @RequestMapping(value ="/add")
    public String add(HttpServletRequest request, HttpServletResponse response , ModelMap modelMap) {
        Member member = new Member();
        member.setId("5");
        member.setNickname("程序喵 - http://www.ibloger.net");
        memberService.addId(member);
        modelMap.addAttribute("member",member);
        logger.info("添加单个对象成功");
        return "redisTest";
    }

    /*
     * 添加集合对象
     * @param request
     * @param response
     * @param modelMap
     * @return
     */

    @RequestMapping(value ="/addList")
    @ResponseBody
    public Object addList() {

//logger.info("集合输出"+ list);
//modelMap.addAttribute("memberList",list);
//     return "redisTest";
        return memberService.findAll();

          }



    //根据 id查询
    @RequestMapping(value ="/query/{id}")
    public String query(@PathVariable("id") int id, ModelMap modelMap) {

        if ( jedis.get(String.valueOf(id))!= null) {
            modelMap.addAttribute("message", "查询Id=" + id + "的用户名为:" + jedis.get(String.valueOf(id)));
        } else {

            modelMap.addAttribute("message", "缓存没有查询到Id=" + id +  memberService.findById(id) +  "从数据库获取");
        }

        logger.info("查询对象成功");
        return "redisTest";
    }

   //删除-----根据 id删除       缓存中id 为 String的key
    @RequestMapping(value ="/delete/{id}")
    public String delete(@PathVariable("id") int id, ModelMap modelMap) {
        try {
            memberService.deleteId(id);
            modelMap.addAttribute("message", "删除Id为" + id + "的用户成功.");
            jedis.del(String.valueOf(id));
            logger.info("缓存删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.addAttribute("message", "删除Id为" + id + "的用户失败, " + e.getMessage());
        }
        logger.info("删除对象成功");
        return "redisTest";
    }



// 更新数据   set （key,value）方法来更改数据      然后清除缓存
@RequestMapping(value = "update/{id}")
    public String updateId(@PathVariable("id") int id , Model model, Member member){
       member.setId(String.valueOf(id));
       member.setNickname("hahaha");
        memberService.updateId(member);
        jedis.del(String.valueOf(id));
        logger.info("缓存清除");
        return "redirect:/query/1";
}

// 测试 list集合     lrange key star stop 来获取数据    lpush key [value,value]存入数据
@RequestMapping("/tts")
    public String   uu() {
        List<Member> m = memberService.findAllTwo();
        for(Member me : m){
    jedis.lpush("use",me.getId(),me.getNickname());
        }

        return "redisTest";
}
}




