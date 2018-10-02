package jnshu.controller;
import com.alibaba.fastjson.JSON;
import jnshu.aspect.ControllerLog;
import jnshu.pojo.Student;
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
    private StudentServiceImpl studentService;

    Logger logger = Logger.getLogger(JsonCon.class);

    @RequestMapping(value="/json",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> hello(HttpServletResponse response) throws Exception{
        System.out.println("JSON Controller Working");
        try {
            Student student=studentService.findByStudentID(5);
            java.util.Map<String,Student> map=new HashMap<String, Student>();
            map.put("哇哇哇哇哇", student);
            String jsonString = JSON.toJSONString(map);
            System.out.println("22222222222222222"+jsonString.toString());

            java.util.Map<String,String> map2=new HashMap<String, String>();
            map2.put("修改", jsonString);

            return map2;
            }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }
}
