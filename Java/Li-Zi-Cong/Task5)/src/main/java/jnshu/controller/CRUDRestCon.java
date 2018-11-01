package jnshu.controller;

import com.alibaba.fastjson.JSON;
import jnshu.pojo.Admin;
import jnshu.pojo.StudentInfo;
import jnshu.pojo.User;

import jnshu.service.CompoundService;
import jnshu.service.impl.CompoundServiceImpl;
import jnshu.util.SerializeUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class CRUDRestCon {
    static List<StudentInfo>upList;

    @Autowired
    CompoundServiceImpl studentInfoimpl;
//    public void execute(String flag, Integer id, StudentInfo studentInfo) {
//        try {
//                Jedis redis = new Jedis("localhost", 6379);
//                redis.set("student".getBytes(),SerializeUtil.serializeList(studentInfoimpl.listStudent()));
//                logger.error("增删时插入更新缓存"+ new Date());
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.debug("ID: " + id + " 发生异常的操作: " + flag + "\n" +
//                    "\t异常内容:" + studentInfo.toString() + "\n" +
//                    "异常代码信息:" + e);
//        }
//    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String insertSTU(StudentInfo studentInfo) throws Exception {
        return studentInfoimpl.insertStudent();
    }
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public String deleteSTU(Integer id) throws Exception{
        return studentInfoimpl.deleteStudentbyID();
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String querySTU(Integer id, Model model,Integer pageCount) throws Exception {
        model.addAttribute("", studentInfoimpl.findByStudentID(,));
        return "";
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String updateSTU(Model model,StudentInfo studentInfo,HttpServletResponse response,HttpServletRequest request ) throws Exception {
        List list = studentInfoimpl.updateStudent(studentInfo,studentInfo.getPageCount());
        model.addAttribute("",list.get());
        return (String) list.get();
    }
    //分页
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String lastPage(Integer pageCount, Model model) throws Exception{
        List list = studentInfoimpl.listInfo("");
        model.addAttribute("",list.get());
        model.addAttribute("", list.get());
        model.addAttribute("", list.get());
        return "";
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String nextPage(Integer pageCount, Model model) throws Exception{
        List list = studentInfoimpl.listInfo("",pageCount);
        model.addAttribute("",list.get(0));
        model.addAttribute("", list.get(0));
        model.addAttribute("", list.get(0));
        return "";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listInfo(Model model)throws Exception {
        model.addAttribute("", studentInfoimpl.listInfo("",null));
        return "";
    }

}
