package com.zyq.controller;

import com.zyq.pojo.Page;
import com.zyq.pojo.Student;
import com.zyq.service.StudentService;
import com.zyq.util.RedisUtil;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.softamis.cluster4spring.rmi.RmiUrlListProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/u")
public class StudentController {

    private static Logger logger = LogManager.getLogger(StudentController.class);

    @Autowired
    @Qualifier("studentService")
    private RmiUrlListProxyFactoryBean rmiProxyFactoryStudentBean;
    private StudentService studentService;

    @Autowired
    private RedisUtil redisUtil;

//    查询所有学生信息，上下页跳转使用
    @RequestMapping(value = "/studentS",method = RequestMethod.GET)
    public ModelAndView selectAllByPage(Integer currPage){
        studentService = (StudentService) rmiProxyFactoryStudentBean.getObject();
        logger.info("输入参数：当前页为"+currPage+"。");
        ModelAndView modelAndView = new ModelAndView("myView");
        Page<Student> page;
       if (redisUtil.hget("pageStudents","page"+currPage)==null){
            logger.info("缓存中没有第"+currPage+"页的page，我要查询了。。。");
            page = studentService.selectAllByPage(currPage);
            logger.info("共查询到"+page.getList().size()+"条记录");
            if (page.getTotalPage() >= currPage) {
                redisUtil.hset("pageStudents", "page" + currPage, page);
            }
        }else {
            logger.info("缓存中存在第"+currPage+"页的page页存在，我直接从缓存拿了。。。");
            page = (Page<Student>) redisUtil.hget("pageStudents","page"+currPage);
        }
        modelAndView.addObject("page",page);
        modelAndView.addObject("item","viewsBody");
        logger.info("***********************分割线***************************");
        return modelAndView;
    }

//    获取特定id学生信息，用于更新学生信息的过渡（查询所有学生信息）
    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public String update(@PathVariable Long id,Integer currPage, ModelMap modelMap){
        studentService = (StudentService) rmiProxyFactoryStudentBean.getObject();
        Page<Student> page = new Page<>();
        List<Student> list = new ArrayList<>();
        Student student = studentService.selectById(id);
        logger.info("需要修改的学生信息为："+student);
        list.add(student);
        page.setList(list);
        page.setCurrPage(currPage);
        modelMap.addAttribute("page",page);
        modelMap.addAttribute("item","updateBody");
        logger.info("***********************分割线***************************");
        return "myView";
    }

//    获取特定id学生信息，用于更新学生信息的过渡（模糊查询学生信息）
    @RequestMapping(value = "/Student/{id}",method = RequestMethod.GET)
    public String update(@PathVariable Long id,Integer currPage,String name,
                         Integer number, ModelMap modelMap){
        studentService = (StudentService) rmiProxyFactoryStudentBean.getObject();
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
        modelMap.addAttribute("item","update2Body");
        logger.info("***********************分割线***************************");
        return "myView";
    }

//    更新学生信息（查询所有学生信息）
    @RequestMapping(value = "/student/{id}",method = RequestMethod.PUT)
    public String updateById(Student student,Integer currPage){
        studentService = (StudentService) rmiProxyFactoryStudentBean.getObject();
        studentService.updateById(student);
        logger.info("学生信息修改完成，修改后的学生信息为:"+student);
        logger.info("第"+currPage+"页的学生信息更新了，我只能删除此页的缓存信息了");
        redisUtil.hdel("pageStudents","page"+currPage);
        logger.info("***********************分割线***************************");
        return "redirect:/u/studentS?currPage="+currPage;
    }

//    更新学生信息（模糊查询学生信息）
    @RequestMapping(value = "/Student/{id}",method = RequestMethod.PUT)
    public String updateById(Student student, Integer currPage, String name2, Integer number2,RedirectAttributes attr){
        studentService = (StudentService) rmiProxyFactoryStudentBean.getObject();
        studentService.updateById(student);
        logger.info("模糊查询学生信息更新了，没办法，只能删除所有学生信息列表的缓存了。。。");
        redisUtil.del("pageStudents");
        logger.info("学生信息修改完成，修改后的学生信息为:"+student);
        logger.info(name2);
        logger.info(number2);
        logger.info("***********************分割线***************************");
        attr.addAttribute("name",name2);
        attr.addAttribute("number",number2);
        attr.addAttribute("currPage",currPage);
        return "redirect:/u/Students/name/number";
    }

//    删除学生信息(查询所有学生信息)
    @RequestMapping(value = "/student/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id,Integer currPage,Integer totalPage,RedirectAttributes attr){
        studentService = (StudentService) rmiProxyFactoryStudentBean.getObject();
        logger.info("要删除的学员ID为"+id);
        studentService.deleteById(id);
        redisUtil.del("pageStudents");
        logger.info("***********************分割线***************************");
        attr.addAttribute("currPage",currPage);
        return "redirect:/u/studentS";
    }

//    删除学生信息(模糊查询学生信息)
    @RequestMapping(value = "/Student/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id, Integer currPage, String name, Integer number,RedirectAttributes attr){
        studentService = (StudentService) rmiProxyFactoryStudentBean.getObject();
        logger.info("要删除的学员ID为"+id);
        studentService.deleteById(id);
        logger.info("模糊查询有学生信息删除了，没办法，只能删除所有学生信息列表的缓存了。。。");
        redisUtil.del("pageStudents");
        attr.addAttribute("name",name);
        attr.addAttribute("number",number);
        attr.addAttribute("currPage",currPage);
        logger.info("***********************分割线***************************");
        return "redirect:/u/Students/name/number";
    }

//    添加学生信息
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public String post(Student student,Map map,Integer currPage,Integer totalPage){
        studentService = (StudentService) rmiProxyFactoryStudentBean.getObject();
        if (student.getName()!=null && student.getName().length()>0 && student.getQq()!=null && !"a  a".equals(student.getName())
                && student.getNumber() !=null && -1!=student.getNumber()){
            logger.info(student.getName());
            logger.info(student.getQq());
            Student student1 = studentService.insert(student);
            logger.info("插入后的学生信息为"+student);
            logger.info("既然重新添加了学生信息，我只能把第"+totalPage+"页学生信息的缓存删除了");
            redisUtil.hdel("pageStudents","page"+totalPage);
            JSONObject jsonObject = JSONObject.fromObject(student1);
            map.put("insertStudent",student1);
            map.put("currPage",currPage);
            map.put("jsonObject",jsonObject);
            map.put("item","insertBody");
            logger.info("***********************分割线***************************");
            return "myView";
        }else {
            logger.info("添加失败，返回当前页面，当前页面缓存肯定时存在的。。。");
            Page<Student> page = (Page<Student>) redisUtil.hget("pageStudents","page"+currPage);;
            map.put("page",page);
            map.put("item","viewsBody");
            map.put("msg","姓名,qq,学号不能为空,且姓名不能为'a  a'(a中间两个空格),学号不能为-1");
            return "myView";
        }
    }

//    模糊查询学生信息
    @RequestMapping(value = "/Students/{name}/{number}",method = RequestMethod.GET)
    public ModelAndView selectByNameAndNum( String name,Integer number,Integer currPage){
        studentService = (StudentService) rmiProxyFactoryStudentBean.getObject();
        ModelAndView modelAndView = new ModelAndView("myView");
        Page<Student> page;
        logger.info(name);
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
        modelAndView.addObject("item","viewsByNameAndNumBody");
        logger.info("查询到的相关学员信息共有"+page.getList().size()+"条。");
        logger.info("***********************分割线***************************");
        return modelAndView;
    }
}
