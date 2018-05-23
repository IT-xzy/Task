package com.controller;

import com.POJO.ChangeType;
import com.POJO.DateTypeChange1;
import com.POJO.PageBean;
import com.POJO.Student;
import com.service.StudentService;
import com.alibaba.fastjson.JSON;
import net.rubyeye.xmemcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 曹樾
 * @program: task6-module
 * @description: 一个控制器测试使用
 * @create: 2018/5/16 上午10:37
 */

@Controller
public class StudentController {
    @Autowired
    private StudentService studentServiceImpl;
//    @Autowired
//    private MemcachedClient memcachedClient;
    @RequestMapping("/user/student")
    public String gotosearch() {
        return "search";
    }
    /**
     * 根据ID查询信息
     *
     * */
    @RequestMapping(value = "/user/list",method = RequestMethod.GET)
    public String select( Integer ID, Model model){
//        try {
//             student = memcachedClient.get("student");
//            if (student == null) {
//                student = studentServiceImpl.findUserById(ID);
//                //将查询出来的结果，放入缓存中。
//                memcachedClient.set("stu",3000,student);
//                return student;
//            }
//            return student;
//        }catch (TimeoutException e) {
//            e.printStackTrace();
//        }
        Student student = studentServiceImpl.findUserById(ID);
        List<DateTypeChange1> list2=new ArrayList<DateTypeChange1>();
        list2.add(ChangeType.dateTypeChange1(student));
        model.addAttribute("lists",student);
        return "list";
    }
    
    /**
     * 删除用户
     */
    @RequestMapping(value = "/user/student/{ID}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("ID") int ID, Model model) throws Exception {
        int a = studentServiceImpl.deleteUser(ID);
        model.addAttribute("a", a);
        model.addAttribute("ID",ID);
        return "redirect:/studentresult";
    }
    @RequestMapping(value = "/studentresult")
    public String studentDeletRedirect(@RequestParam("a")int a, @RequestParam("ID") int ID, Model model){
        String message;
        message = (a ==1) ? ("数据添加成功"):( "数据添加失败");
        model.addAttribute("message", message+ID);
        return "result";
    }
    
    /**
     * 修改用户
     */
    @RequestMapping(value = "/user/student/",method = RequestMethod.GET)
    public String selectOne(Integer ID, Model model) throws Exception {
        Student student = studentServiceImpl.findUserById(ID);
        DateTypeChange1 newstu =  ChangeType.dateTypeChange1(student);
        model.addAttribute("student", newstu);
        return "change";
    }
    
    
    @RequestMapping(value = "/student/{ID}",method = RequestMethod.PUT)
    public String updateUser( @PathVariable("ID") Long ID,DateTypeChange1 newstu,Model model) throws Exception {
        Student student=ChangeType.LongTypeChange(newstu);
        int b=studentServiceImpl.updateUser(student);
        return "redirect:/user/sturesult/"+b;
    }
    
    
    @RequestMapping(value = "/user/sturesult/{b}",method = RequestMethod.GET)
    public String studentUpdateRedirect(@PathVariable int b ,Model model) throws IOException {
        String message;
        message = (b ==1 ) ? ("数据添加成功"):( "数据添加失败");
        model.addAttribute("message",message);
        return "result";
    }
    
    /**
     * 根据姓名模糊查询
     */
    @RequestMapping(value = "/user/nameList")
    public String selectByName(@RequestParam(value = "currentPage",defaultValue ="1",required = false)int currentPage,
                               @RequestParam(value ="name" ) String name,Model model)
            throws IOException {
        PageBean<DateTypeChange1> list =studentServiceImpl.findUserByName(currentPage,name);
        String n = name;
        model.addAttribute("pagesmg",list);//回显分页数据
        model.addAttribute("name", n);
        return "list";
    }
    
    /**
     * 新增用户
     */
    @RequestMapping("/user/new")
    public String turntoinsert(){
        return "insert";
    }
    @RequestMapping(value = "/user/result", method = RequestMethod.POST)
    public String insert(DateTypeChange1 newStudent,Model model) throws Exception {
        Student newstu1 = ChangeType.LongTypeChange(newStudent);
        int s = studentServiceImpl.insertUser(newstu1);
        Integer a = newstu1.getID();
        String message;
        message = (s ==1 ) ? ("数据添加成功"):( "数据添加失败");
        model.addAttribute("message",message);
        return "result";
    }
    /**
     * 测试返回json字符串
     * @return
     */
    @RequestMapping(value = "/json",produces ={"application/json;charset=UTF-8"})
    public @ResponseBody String testjson (){
        String jsons;
        List<Student> studentlist = studentServiceImpl.testJson();
        jsons = JSON.toJSONString(studentlist);
        return jsons;
    }
    
}
