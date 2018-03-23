package com.controller;

import com.mapper.StudentMapper;
import com.pojo.Student;
import com.service.GetCollege;
import com.service.SelectOOS;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.concurrent.TimeoutException;

@Controller
public class PageController {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    GetCollege getCollege;
    @Autowired
    MemcachedClient memcachedClient;
    @Autowired
    SelectOOS selectOOS;

//    @RequestMapping("/u/t10")
//    public String index10(ModelMap map) {
//        StringJson stringJson = new StringJson();
//        int learnNum = 0;
//        int workNum = 0;
//        Map<Integer, String> collegemap;
//        //在缓存中查找数据，如果没有，查询数据库，并写入缓存。
//        try {
//            if (memcachedClient.get("learnNum") == null) {
//                learnNum = studentMapper.selectByStatus(1);
//                memcachedClient.set("learnNum", 0, learnNum);
//            }
//            if (memcachedClient.get("workNum") == null) {
//                workNum = studentMapper.selectByStatus(0);
//                memcachedClient.set("workNum", 0, workNum);
//            }
//            if (memcachedClient.get("collegemap") == null) {
//                collegemap = getCollege.GetCollegeMap();
//                String jsonMap = stringJson.MapToJson(collegemap);
//                memcachedClient.set("collegemap", 0, jsonMap);
//                //在缓存中，则直接取缓存中的内容。
//            } else {
//                learnNum = memcachedClient.get("learnNum");
//                workNum = memcachedClient.get("workNum");
//                String jsonMap = memcachedClient.get("collegemap");
//                collegemap = stringJson.JsonToMap(jsonMap);
//                //加入属性
//                map.addAttribute("learner", learnNum);
//                map.addAttribute("worker", workNum);
//                map.addAttribute("name0", collegemap.get(0));
//                map.addAttribute("name1", collegemap.get(1));
//                map.addAttribute("name2", collegemap.get(2));
//                map.addAttribute("name3", collegemap.get(3));
//            }
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (MemcachedException e) {
//            e.printStackTrace();
//        }
//        return "t10";
//    }

    @RequestMapping("/u/t10")
    public String index10(Model model) {
                int learnNum = studentMapper.selectByStatus(1);
                int workNum = studentMapper.selectByStatus(0);
                List<Student> collegeList = getCollege.GetCollegeList();
                //加入属性值
                System.out.println(collegeList);
                model.addAttribute("learner", learnNum);
                model.addAttribute("worker", workNum);
                model.addAttribute("college0",collegeList.get(0));
                model.addAttribute("college1",collegeList.get(1));
                model.addAttribute("college2",collegeList.get(2));
                model.addAttribute("college3",collegeList.get(3));
                model.addAttribute("url",selectOOS.geturl());
                return "t10";
    }


    @RequestMapping("/t11")
    public String index11(ModelMap map) {
        int classnumqianduan = 0;
        try {
            if (memcachedClient.get("learnnum") == null) {
                classnumqianduan = studentMapper.selectByclass("前端");
                memcachedClient.set("learnnum", 0, classnumqianduan);
            } else {
                classnumqianduan = memcachedClient.get("learnnum");
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        map.addAttribute("learnnum", classnumqianduan);
        return "t11";
    }
}



    //redis jsp 接口
//    @RequestMapping("/jsp")
//    public String jsp(ModelMap map){
//        Map<Integer, String> collegemap = getCollege.GetCollegeMap();
//        map.addAttribute("name0", collegemap.get(0));
//        map.addAttribute("name1", collegemap.get(1));
//        map.addAttribute("name2", collegemap.get(2));
//        map.addAttribute("name3", collegemap.get(3));
//        return "t10";
//    }
//
//    @RequestMapping("/cachejsp")
//    public String cachejsp(ModelMap map){
//        final String ipAddr = "127.0.0.1";
//        final int port = 6379;
//        Jedis jedis = new Jedis(ipAddr,port);
//        Map<String, String> collegemap =null;
//        if(jedis.hlen("collegemap")==0){
//            System.out.println("无缓存调用");
//            collegemap = getCollegeStringMap.GetCollegeMap();
//            jedis.hmset("collegemap",collegemap);
//            map.addAttribute("name0", collegemap.get(0));
//            map.addAttribute("name1", collegemap.get(1));
//            map.addAttribute("name2", collegemap.get(2));
//            map.addAttribute("name3", collegemap.get(3));
//        }else{
//            System.out.println("有缓存调用");
//            //有缓存调用
//            collegemap =  jedis.hgetAll("collegemap");
//            map.addAttribute("name0", collegemap.get("0"));
//            map.addAttribute("name1", collegemap.get("1"));
//            map.addAttribute("name2", collegemap.get("2"));
//            map.addAttribute("name3", collegemap.get("3"));
//        }
//        return "t10";
//    }

    //redis json接口
//    @RequestMapping("/json")
//    public ModelAndView json(){
//        Map<Integer, String> collegemap = getCollege.GetCollegeMap();
//        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
//        mav.addObject(collegemap);
//        return mav;
//    }
//
//    @RequestMapping("/cachejson")
//    public ModelAndView cachejson(){
//        final String ipAddr = "127.0.0.1";
//        final int port = 6379;
//        Jedis jedis = new Jedis(ipAddr,port);
//        Map<String, String> collegemap =null;
//        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
//        //如果缓存中没有key
//        if(jedis.hlen("collegemap")==0){
//            System.out.println("无缓存调用");
//            collegemap = getCollegeStringMap.GetCollegeMap();
//            //缓存穿透问题，没有缓存，数据库也没有，缓存中写入一个null。
//            if(collegemap == null){
//                jedis.hmset("collegemap",null);
//                //设置一个过期时间，避免被恶意使用，占大量缓存空间。
//                jedis.expire("collegemap",300);
//            }else {
//                jedis.hmset("collegemap", collegemap);
//                mav.addObject(collegemap);
//            }
//         //缓存中有key
//        }else{
//            System.out.println("有缓存调用");
//            //有缓存调用
//            collegemap =  jedis.hgetAll("collegemap");
//            mav.addObject(collegemap);
//        }
//        return mav;
//    }
//}
