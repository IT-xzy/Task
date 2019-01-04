package jnshu.controller;
import com.alibaba.fastjson.JSON;
import jnshu.aspect.ControllerLog;
import jnshu.pojo.Student;
import jnshu.service.CompoundService;
import jnshu.service.impl.StudentServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class JsonCon {

    @Autowired
    private CompoundService compoundService;

    Logger logger = Logger.getLogger(JsonCon.class);

    @RequestMapping(value="/",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> hello(HttpServletResponse response) throws Exception{
        System.out.println("  ");
        try {
            Student student=compoundService.jsonPage();
            String jsonString = JSON.toJSONString(student);
            java.util.Map<String,String> map=new HashMap<String, String>();
            map.put("",jsonString);
            return map;
            }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }
}
