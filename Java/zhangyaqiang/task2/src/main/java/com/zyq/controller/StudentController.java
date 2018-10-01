package com.zyq.controller;

import com.zyq.pojo.Page;
import com.zyq.pojo.Student;
import com.zyq.service.StudentService;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class StudentController {

    private static Logger logger = LogManager.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

//    查询所有学生信息，首页跳转而来
    @RequestMapping(value = "/students",method = RequestMethod.GET)
    public ModelAndView selectAllByPage(Integer currPage,Integer pageSize){
        logger.info("进入首页了。。。。");
        if (pageSize==null || pageSize<=0){
            ModelAndView modelAndView = new ModelAndView("index");
            modelAndView.addObject("msg","不能为空,且必须为0以上的自然数");
            return modelAndView;
        }else {
            logger.info("输入参数：当前页为"+currPage+",一个页面显示数目为"+pageSize+"。");
            ModelAndView modelAndView = new ModelAndView("views");
            Page<Student> page = studentService.selectAllByPage(currPage,pageSize);
            logger.info("共查询到"+page.getList().size()+"条记录，"+"如下所示：");
            for (Student student:page.getList()) {
                logger.info(student);
            }
            modelAndView.addObject("page",page);
            logger.info("***********************分割线***************************");
            return modelAndView;
        }
    }

//    查询所有学生信息，上下页跳转使用
    @RequestMapping(value = "/studentS",method = RequestMethod.GET)
    public ModelAndView selectAllByPage(Integer currPage){
        logger.info("输入参数：当前页为"+currPage+"。");
        ModelAndView modelAndView = new ModelAndView("views");
        Page<Student> page = studentService.selectAllByPage(currPage);
        logger.info("共查询到"+page.getList().size()+"条记录，"+"如下所示：");
        for (Student student:page.getList()) {
            logger.info(student);
        }
        modelAndView.addObject("page",page);
        logger.info("***********************分割线***************************");
        return modelAndView;
    }

//    获取特定id学生信息，用于更新学生信息的过渡（查询所有学生信息）
    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public String update(@PathVariable Long id,Integer currPage, ModelMap modelMap){
        Page<Student> page = new Page<>();
        List<Student> list = new ArrayList<>();
        Student student = studentService.selectById(id);
        logger.info("需要修改的学生信息为："+student);
        list.add(student);
        page.setList(list);
        page.setCurrPage(currPage);
        modelMap.addAttribute("page",page);
        logger.info("***********************分割线***************************");
        return "update";
    }

//    获取特定id学生信息，用于更新学生信息的过渡（模糊查询学生信息）
    @RequestMapping(value = "/Student/{id}",method = RequestMethod.GET)
    public String update(@PathVariable Long id,Integer currPage,String name,
                         Integer number, ModelMap modelMap){
        Page<Student> page = new Page<>();
        List<Student> list = new ArrayList<>();
        Student student = studentService.selectById(id);
        logger.info("需要修改的学生信息为："+student);
        list.add(student);
        page.setList(list);
        page.setCurrPage(currPage);
        modelMap.addAttribute("page",page);
        modelMap.addAttribute("name",name);
        modelMap.addAttribute("number",number);
        logger.info("***********************分割线***************************");
        return "update2";
    }

//    更新学生信息（查询所有学生信息）
    @RequestMapping(value = "/student/{id}",method = RequestMethod.PUT)
    public ModelAndView updateById(Student student,Integer currPage){
        studentService.updateById(student);
        logger.info("学生信息修改完成，修改后的学生信息为:"+student);
        ModelAndView modelAndView = new ModelAndView("views");
        Page<Student> page = studentService.selectAllByPage(currPage);
        modelAndView.addObject("page",page);
        logger.info("***********************分割线***************************");
        return modelAndView;
    }

//    更新学生信息（模糊查询学生信息）
    @RequestMapping(value = "/Student/{id}",method = RequestMethod.PUT)
    public ModelAndView updateById(Student student,Integer currPage,String name2,Integer number2){
        studentService.updateById(student);
        logger.info("学生信息修改完成，修改后的学生信息为:"+student);
        ModelAndView modelAndView = new ModelAndView("viewsByNameAndNum");
        Page<Student> page;
        if ("a  a".equals(name2) && number2 !=-1){
            page = studentService.selectByNum(number2,currPage);
        }else if (!"a  a".equals(name2) && number2 == -1){
            page = studentService.selectByName(name2,currPage);
        }else {
            page = studentService.selectByNameAndNum(name2,number2,currPage);
        }
        modelAndView.addObject("page",page);
        modelAndView.addObject("name",name2);
        modelAndView.addObject("number",number2);
        logger.info("***********************分割线***************************");
        return modelAndView;
    }

//    删除学生信息(查询所有学生信息)
    @RequestMapping(value = "/student/{id}",method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable Long id,Integer currPage){
        studentService.deleteById(id);
        logger.info("要删除的学员ID为"+id);
        ModelAndView modelAndView = new ModelAndView("views");
        Page<Student> page = studentService.selectAllByPage(currPage);
        modelAndView.addObject("page",page);
        logger.info("***********************分割线***************************");
        return modelAndView;
    }

//    删除学生信息(模糊查询学生信息)
    @RequestMapping(value = "/Student/{id}",method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable Long id,Integer currPage,String name,Integer number){
        logger.info("要删除的学员ID为"+id);
        studentService.deleteById(id);
        ModelAndView modelAndView = new ModelAndView("viewsByNameAndNum");
        Page<Student> page;
        if ("a  a".equals(name) && number !=-1){
            page = studentService.selectByNum(number,currPage);
        }else if (!"a  a".equals(name) && number == -1){
            page = studentService.selectByName(name,currPage);
        }else {
            page = studentService.selectByNameAndNum(name,number,currPage);
        }
        modelAndView.addObject("page",page);
        modelAndView.addObject("name",name);
        modelAndView.addObject("number",number);
        logger.info("***********************分割线***************************");
        return modelAndView;
    }

//    添加学生信息
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public String post(Student student,Map map,Integer currPage){
        if (student.getName()!=null && student.getName().length()>0 && student.getQq()!=null && !"a  a".equals(student.getName())
                && student.getNumber() !=null && -1!=student.getNumber()){
            logger.info(student.getName());
            logger.info(student.getQq());
            Student student1 = studentService.insert(student);
            logger.info("插入后的学生信息为"+student);
            JSONObject jsonObject = JSONObject.fromObject(student1);
            map.put("insertStudent",student1);
            map.put("currPage",currPage);
            map.put("jsonObject",jsonObject);
            logger.info("***********************分割线***************************");
            return "insert";
        }else {
            Page<Student> page = studentService.selectAllByPage(currPage);
            map.put("page",page);
            map.put("msg","姓名,qq,学号不能为空,且姓名不能为'a  a'(a中间两个空格),学号不能为-1");
            return "views";
        }
    }

//    模糊查询学生信息
    @RequestMapping(value = "/Students/{name}/{number}",method = RequestMethod.GET)
    public ModelAndView selectByNameAndNum(@PathVariable String name ,@PathVariable Integer number,Integer currPage){
        ModelAndView modelAndView = new ModelAndView("viewsByNameAndNum");
        Page<Student> page;
        if("a  a".equals(name) && number !=-1){
            logger.info("模糊查询信息为：qq，"+number);
            page = studentService.selectByNum(number,currPage);
        }else if (!"a  a".equals(name) && number == -1){
            logger.info("模糊查询信息为：姓名，"+name);
            page = studentService.selectByName(name,currPage);
        }else {
            logger.info("模糊查询信息为：姓名，"+name+",学号"+number);
            page = studentService.selectByNameAndNum(name,number,currPage);
        }
        modelAndView.addObject("page",page);
        modelAndView.addObject("name",name);
        modelAndView.addObject("number",number);
        logger.info("查询到的相关学员信息共有"+page.getList().size()+"条。");
        logger.info("***********************分割线***************************");
        return modelAndView;
    }
}
