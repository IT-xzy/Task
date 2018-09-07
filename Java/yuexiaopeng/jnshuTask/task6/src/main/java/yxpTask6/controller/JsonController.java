package yxpTask6.controller;

import atg.taglib.json.util.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import yxpTask6.pojo.Login;
import yxpTask6.pojo.Student;
import yxpTask6.service.StudentService;
import yxpTask6.util.JsonUtil;
import yxpTask6.util.TaskMemcachedUtil;
import yxpTask6.util.TaskRedisUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Vector;

//返回jason数据的controller
@Controller
public class JsonController
{
    @Autowired
    StudentService studentService;
    @Autowired
    TaskRedisUtil taskRedisUtil;
    @Autowired
    TaskMemcachedUtil taskMemcachedUtil;
    @Autowired
    JsonUtil jsonUtil;
    //@RequestBody用来接受前端传来的json数据；
    @RequestMapping("student/json")
    @ResponseBody
    public Map<String,Object> studentJsonController(HttpServletRequest request,
                                             @RequestBody Map<String,Object> map, Model model)
    {

        Map map1=jsonUtil.studentJson(map);
        return map1;
    }
    @RequestMapping("redis/json")
    @ResponseBody
    public Map<String,Object> redisJsonController(HttpServletRequest request,
                                             @RequestBody Map<String,Object> map, Model model)
    {
        Map map1=jsonUtil.redisJson(map);
        return map1;
    }
    @RequestMapping("memcached/json")
    @ResponseBody
    public Map<String,Object> memcachedJsonController(HttpServletRequest request,
                                             @RequestBody Map<String,Object> map, Model model)
    {
        Map map1=jsonUtil.memcachedJson(map);
        return map1;
    }
}
