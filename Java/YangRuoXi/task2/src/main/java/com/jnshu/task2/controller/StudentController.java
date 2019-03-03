package com.jnshu.task2.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jnshu.task2.beans.Student;
import com.jnshu.task2.service.StudentService;
import com.jnshu.task2.validator.StudentValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class StudentController {
    Logger logger = LogManager.getLogger(StudentController.class);


    /**
     * 使用postman测试接口用Put方法
     * @param map 接收传值
     * @return 返回学生对象
     */
    @ResponseBody
    @RequestMapping(value = "/testUpdate",method = RequestMethod.PUT)
    public Student updateStu(Map<String, Object> map) {
        Student student = null;
        try {
            student = new Student();
            student.setId(3);
            student.setName("tesput");
            student.setQq(123123);
            map.put("student",student);
            logger.info(student);
            logger.info("测试更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("测试更新失败");
        }
        return student;
    }

    /**
     * 测试postman接口,用post方法
     * @param map 用于接收数据
     * @return 返回student对象
     */
    @ResponseBody
    @RequestMapping(value = "/testAdd" , method = RequestMethod.POST)
    public Student add(Map<String, Object> map) {
        Student student = null;
        try {
            student = new Student();
            student.setName("adddddd");
            student.setQq(123432543);
            map.put("student",student);
            logger.info(student);
            logger.info("测试添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("测试添加方法失败");
        }
        return student;

    }



    /**
     * 用于通过id查询单个学生方法
     * @param id 学生id
     * @param map 接收传值
     * @param student 接收student
     * @return 返回学生信息
     */
    @ResponseBody
    @RequestMapping(value = "/stus/{id}" , method = RequestMethod.GET)
    public Student selectStu(@PathVariable("id")Integer id, Map<String,Object> map,Student student) {
        try {
            student = studentService.selectStuById(id);
            map.put("student",student);
            logger.info(student);
            logger.info("查询方法成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询方法失败");
        }
        return student;
    }



    @Autowired
    private StudentService studentService;


//    /**
//     *  前往所有学生列表-
//     * @param map 接收数据
//     * @return 返回到List.jsp页面
//     */
//    @RequestMapping(value = "/stus")
//    public String toStuListPage(Map<String,Object> map){
//        try {
//            map.put("stuList",studentService.selectStuAll());
//            logger.info("去往学生列表");
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error("获取学生列表失败");
//        }
//        return "list";
//    }


    // 去往添加页面-返回视图

    /**
     *  去往添加学生页面
     * @return 返回视图对象,跳转到input.jsp页面
     */

    @RequestMapping(value = "/stu", method = RequestMethod.GET)
    public String toAddStuPage(){
        return "input";
    }

//    //分页-返回视图

    /**
     * 使用分页
     * @param pn 起始页码
     * @param map
     * @return 返回list.jsp页面
     */
    @RequestMapping(value = "/stus", method = RequestMethod.GET)
    public String selectStuByPage(@RequestParam(required = true,defaultValue = "1")Integer pn,Map<String,Object> map){

        try {
            PageHelper.startPage(pn,5);
            List<Student> stuList = studentService.selectStuAll();
            PageInfo<Student> pageInfo = new PageInfo<>(stuList,5);
            map.put("pageInfo",pageInfo);
            logger.info("分页列表成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("去往分页列表失败");
        }
        return "list";
    }

    @Autowired
    private StudentValidator studentValidator;

    // 实现添加操作-string
    @Validated
    @RequestMapping(value = "/stu",method = RequestMethod.POST)
    public String saveStu(@Validated Student student,Errors errors){
        try {
            logger.info(student);
            studentValidator.validate(student,errors);
            if (errors.hasErrors()){
                return "input";
            } else {
                studentService.addStu(student);
                JSON.toJSON(student);
            }
            logger.info("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("添加失败");
        }
        return "redirect:/stus";
    }


    // 携带用户信息去往更新页面
    @RequestMapping(value = "/stu/{id}",method = RequestMethod.GET)
    public String toUpdatePage(@PathVariable("id") Integer id,Map<String ,Object> map) {
        try {
            Student student = studentService.selectStuById(id);
            map.put("student",student);
            logger.info("去往更新页面成功!");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("更新页面失败");
        }
        return "update";
    }

    //更新方法-返回string
    @RequestMapping(value = "/stu/{id}",method = RequestMethod.PUT)
    public String updateStu(@PathVariable("id") Integer id,Map map,Student student) {

        try {
            studentService.updateStuTypeById(id, student);
            map.put("stu",student);
            logger.info("更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("更新失败");
        }
        return "redirect:/stus";
    }


    //删除方法-返回视图
    @ResponseBody
    @RequestMapping(value = "/stu/{id}",method = RequestMethod.DELETE)
    public ModelAndView delStu(@PathVariable("id") Integer id) {
        ModelAndView mav = null;
        try {
           boolean b = studentService.delStuById(id);
           logger.info(b);
           mav = new ModelAndView("redirect:/stus");
           logger.info("update success");
        } catch (Exception e) {
            e.printStackTrace();
            mav = new ModelAndView("error");
            logger.error("错误");
        }
        return  mav;

    }




    //返回json字符串
    //查询方法
    @RequestMapping(value = "/textjson/{id}" ,method = RequestMethod.GET)
    @ResponseBody
    public Student selectStu(@PathVariable("id")Integer id) {
        Student student = null;
        try {
            logger.info("start select");
            student = studentService.selectStuById(id);
            Map map = new HashMap();

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("select error");
        }

        return student;
    }

    //更新方法
    @ResponseBody
    @RequestMapping(value = "/testjson/{id}", method = RequestMethod.PUT)
    public Student updateStuById(@PathVariable("id")Integer id){
        Student student = null;
        try {
            student = new Student();
            student.setName("6666");
            boolean b = studentService.updateStuTypeById(id,student);
            Map map = new HashMap();
            map.put("code",b);
            map.put("student",student);

            String json = JSON.toJSONString(map);
            logger.info("测试json成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("测试json失败");
        }
        return student;
    }

    @ResponseBody
    @RequestMapping(value = "/testjson",method = RequestMethod.POST)
    public Student addStu() {
        Student student = null;
        try {
            student = new Student();
            student.setName("testjson");
            student.setQq(123321);
            studentService.addStu(student);
            Map map = new HashMap();
            map.put("code",true);
            map.put("student",student);
            String json = JSON.toJSONString(map);
            logger.info("测试jsonAdd成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("测试jsonAdd失败");
        }
        return student;
    }

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {
        String message = e.getMessage();
        String error = messageSource.getMessage(message,null, null);
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("error", error);
        return mav;
    }

}
