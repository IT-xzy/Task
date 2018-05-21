package com.tasktwo.controller;

import com.tasktwo.model.Student;
import com.tasktwo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 面对前台进行增删改查的类
 * Created by Administrator on 24/7/2017.
 */

//标记这是一个控制器
@Controller
//所有的程序的第一接口
@RequestMapping("/task2")
public class HomeController {
    private static Logger loggerController = Logger.getLogger(HomeController.class);

    //自动配装StudentService
    @Autowired
    private StudentService studyService;

    /*
     * 对某个指定用户查询
     * 链接为http://localhost:8081/task2/a/student/select/具体数据
     */
    @RequestMapping(value="/a/student/select/{userId}",method = RequestMethod.GET)
    public String detail(HttpServletRequest request, HttpServletResponse response, Model model, @PathVariable String userId) {
       if(userId!=null) {
           try {
               loggerController.info("查找当前的用户信息");
               loggerController.info("userId " + userId);
               Student study = this.studyService.getUserId(userId);
               loggerController.info("学生信息： "+ study);
               //将数据绑定到model上，可以传入jsp页面
               model.addAttribute("study", study);
           } catch (Exception e) {
               e.printStackTrace();
               loggerController.error("查询失败" + e.getMessage());
               return "common/errorJson";
           }
           return "student/studentDataliJson";
       }
       else {
           loggerController.info("userId " + userId);
           return "common/errorParameterJson";
       }
    }


    /*
     * 添加用户信息
     * 链接为http://localhost:8081/task2/a/student/insert
     * 格式为application/json
     */
    @RequestMapping(value = "/a/student/insert",method = RequestMethod.POST)
    public String insert(HttpServletRequest request, HttpServletResponse response, Model model,@RequestBody Student study ) {
        //当没有输入userid时，提示传入参数出错
        if (study.getUserId()!=null) {
            try {
                loggerController.info("添加用户信息");
                int i = studyService.studyInsert(study);
                loggerController.info("study ：" + study);
                loggerController.info("添加信息的行数" + i);
                if(i == -1){
                    loggerController.info("用户信息已经存在");
                    return "error-data/errorDataExistsJson";
                }
            } catch (Exception e) {
                e.printStackTrace();
                loggerController.error("添加出错" + e.getMessage());
                return "common/errorJson";
            }
            return "common/successJson";
        }
        else {
            loggerController.info("study  :  " + study);
            return "common/errorParameterJson";
        }
    }

    /*
     * 对用户名字进行修改，
     * http://localhost:8081/task2/a/student/update
     * 格式为application/x-www-form-urlencoded
     */

    @RequestMapping(value = "/a/student/update",method = RequestMethod.PUT)
    public String update(HttpServletRequest request, HttpServletResponse response,Model model, @RequestBody Student study){
        //当没有输入userid时，提示传入参数出错
        if(study.getUserId()!=null) {
            try {
                loggerController.info("修改用户信息");
                loggerController.info("name  :  " + study.getName());
                loggerController.info("userId  :  " + study.getUserId());
                int i = studyService.studyUpdate(study);
                loggerController.info("返回修改行数" + i);
                if(i == -1){
                    loggerController.info("用户信息不存在");
                    return "error-data/errorDataExistsJson";
                }
                else {
                    loggerController.info("用户信息存在");
                    return "common/successJson";
                }
            } catch (Exception e) {
                e.printStackTrace();
                loggerController.error("修改出错" + e.getMessage());
                return "common/errorJson";
            }

        }
        else {
            loggerController.info("userId  :  " + study.getUserId());
            loggerController.info("name  :  " + study.getName());
            return "common/errorParameterJson";
        }
    }


    /*
     * 删除用户信息
     * http://localhost:8081/task2/a/student/delete/JAVA-4433
     */
    @RequestMapping(value = "/a/student/delete/{userId}",method = RequestMethod.DELETE)
    public String delete(HttpServletRequest request, HttpServletResponse response,Model model,@PathVariable("userId") String userId){
        if (userId!= null) {
            try {
                loggerController.info("删除用户信息");
                loggerController.info("userId  :  " + userId);
                int i = studyService.studyDelete(userId);
                loggerController.info("返回影响行数" + i);
            } catch (Exception e) {
                e.printStackTrace();
                loggerController.error("" + e.getMessage());
                return "common/errorJson";
            }
            return "common/successJson";
        }
        else {
            loggerController.info("userId  :  " + userId);
            return "common/errorParameterJson";
        }
    }



    /*
     * 查询表中所有用户信息
     * http://localhost:8081/task2/a/student/all
     */
    @RequestMapping(value = "/a/student/all",method = RequestMethod.GET)
    public String all(HttpServletRequest request, HttpServletResponse response,Model model){
        try {
            loggerController.info("查询全部学生信息");
            List<Student> study = studyService.studentAll();
            loggerController.info("studylist ： " + study);
            int i = study.size();
            loggerController.info("返回用户数量" + i);
            model.addAttribute("study",study);
        }catch(Exception e){
            e.printStackTrace();
            loggerController.error("查询错误" + e.getMessage());
            return "common/errorJson";
        }
        return "student/studentListJson";
    }

}