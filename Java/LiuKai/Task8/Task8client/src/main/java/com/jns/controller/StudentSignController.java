package com.jns.controller;

import com.aliyuncs.exceptions.ClientException;
import com.jns.pojo.Student;
import com.jns.service.CourseService;
import com.jns.service.RmiService;
import com.jns.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import util.aliSmsUtil.AliSmsUtil;
import util.redisUtil.GetNumUtil;
import util.redisUtil.RedisUtil;

/**
 * 用户注册页面
 */
@Controller
public class StudentSignController {


    // 工具类
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    GetNumUtil getNumUtil;


    // 阿里手机验证码
    @Autowired
    AliSmsUtil aliSmsUtil;

//
//    @Autowired
//    @Qualifier("studentRMIClientOne")
//    StudentService studentService;


    @Autowired
    RmiService rmiService;



    /**
     * @return 跳转至手机号填写页面
     * @Description 从主页跳转至手机验证码获取页面
     * @Param
     **/
    @RequestMapping("/signBegin")
    public ModelAndView signBegin() {
        ModelAndView mv = new ModelAndView("phoneCode");
        return mv;
    }

    /**
     * @return 返回异常页面   或  返回注册页面及验证码
     * @Description
     * @Param 传入手机号
     **/
    @RequestMapping(value = "/phoneCode", method = RequestMethod.POST)
    public ModelAndView phoneCode(String phoneNum) throws ClientException {
        ModelAndView mv = new ModelAndView();
        // 正则表达式判断手机号是否合理
        String phoneregex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
        //根据手机号获取学生数据
        Student student =rmiService.getStudentService().selectPhoneNum(phoneNum);
        // 生成验证码
        String regcode = String.valueOf((int) ((Math.random() + 1) * 1000));
        //判断手机验证码获取次数 已手机号+手机号为key
        if (getNumUtil.getRedisNum(phoneNum + phoneNum) > 3) {
            mv.setViewName("error");
            mv.addObject("exception", "验证码获取次数过多，请明天再试");
            return mv;
        }
        //手机号为空或不合理，返回phonecode页面
        if (phoneNum == null | phoneNum.matches(phoneregex) != true) {
            mv.setViewName("error");
            mv.addObject("exception", "手机号为空或非合理手机号");
            return mv;
            //判断手机号是否重复 重复返回phonecode页面
        }
        if (student != null) {
            mv.setViewName("error");
            mv.addObject("exception", "手机号重复");
            return mv;
        } else {
            //将手机号-验证码以key-value放入redis中用于验证,过期时间30分钟
            redisUtil.setRedis(phoneNum, 30, regcode);
                // 将手机号在注册页面显示
                mv.setViewName("signpage");
                mv.addObject("phoneNum", phoneNum);
            //    发送手机验证码
            aliSmsUtil.sendMesg(phoneNum, regcode);
//            mv.addObject("regCode", regcode);
                return mv;


            }

    }

    /**
     * @return 返回成功页面 或 停留本页
     * @Description
     * @Param 传入 学员姓名 密码 电话 验证码
     **/
    @RequestMapping(value = "student", method = RequestMethod.POST)
    public ModelAndView signStudent(String stuName, String passWord, String phoneNum, String regCode) {
        ModelAndView mv = new ModelAndView();
        // 判断传入数据是否为空，为空返回signpage注册页面
        if (stuName == null | passWord == null | phoneNum == null | regCode == null) {
            mv.setViewName("signpage");
            mv.addObject("exception", "不可为空");
            return mv;
            //判断用户名是否重复，重复返回signpage注册页面
        } else if (rmiService.getStudentService().selectStuName(stuName) != null) {
            mv.setViewName("signpage");
            mv.addObject("exception", "用户名重复");
            return mv;

            // 验证码获取为空，或验证码不匹配
        } else if (redisUtil.getRedis(phoneNum) == null | !regCode.equals(redisUtil.getRedis(phoneNum))) {
            mv.setViewName("signpage");
            mv.addObject("exception", "验证码错误或过期");
            return mv;
        }

        //通过测进行学员注册，此处可对password进行加密存储，先掠过完成注册逻辑实现
        rmiService.getStudentService().signUpStudent(stuName, passWord, phoneNum);
        mv.setViewName("success");
        return mv;
    }


}
