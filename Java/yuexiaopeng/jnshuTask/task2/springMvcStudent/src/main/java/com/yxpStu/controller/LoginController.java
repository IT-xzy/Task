package com.yxpStu.controller;

import com.yxpStu.pojo.Login;
import com.yxpStu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController
{
    @Autowired
    private LoginService loginService;

    //登陆确认
    @RequestMapping("loginVerify")
    public ModelAndView loginVerify(Login login)
    {

        if(login.getLoginId()!=null)
        {
            Login login1=loginService.selectLogin(login);
            if(login1==null)//账号有id，但是数据库不存在id
            {

                ModelAndView modelAndView=new ModelAndView("loginNotExist");
                return modelAndView;
            }
            else if(login1.getLoginPassword().equals(login.getLoginPassword()))
            {
            //id不为空，且id在数据库中，查询密码判断是否一致，一致则登录成功
                ModelAndView modelAndView=new ModelAndView("loginSuccess");
                return modelAndView;
            }
            else
            {
                //id不为空，且id在数据库中，查询密码判断是否一致，一致则登录成功
                ModelAndView modelAndView=new ModelAndView("loginFailed");
                return modelAndView;
            }
        }
        else
        {
        //id为空，账号不存在，重新登陆或注册
            ModelAndView modelAndView=new ModelAndView("loginNotExist");
            return modelAndView;
        }
    }

    //注册确认
    @RequestMapping("loginRegisterVerify")
    public ModelAndView loginRegisterVerify(Login login)
    {
        if(login.getLoginId()!=null)
        {
            Login login1=loginService.selectLogin(login);
            if(login1!=null)
            {
            // id不为空，查询密码是否存在，存在则账号存在，注册失败

                ModelAndView modelAndView=new ModelAndView("loginRegisterFailed");
                return modelAndView;
            }
            else
            {//判断一个字符串里含不含有空格，包括未输入任何字符的情况；
                String s=login.getLoginPassword();int len=s.length();int count=0;
                for(int i=0;i<len;i++){char tem=s.charAt(i);if(tem==' ') count++;}

                if(count>=0&&len==0)
                {//id不为空且不存在，判断字符中是否含有空格，有空格则失败或没有任何输入值
                    ModelAndView modelAndView=new ModelAndView("loginRegisterFailed");
                    return modelAndView;
                }
                else
                {
                    //剩余最后的情况就是符合标准的格式
                    loginService.insertLogin(login);
                    ModelAndView modelAndView=new ModelAndView("loginRegisterSuccess");
                    return modelAndView;
                }
            }
        }
        else
        {
        // id为空，注册失败，重新注册
            ModelAndView modelAndView=new ModelAndView("loginRegisterFailed");
            return modelAndView;
        }
    }

    // 密码修改确认类
    @RequestMapping("loginUpdateVerify")
    public ModelAndView loginUpdateVerify(Login login)
    {
        if(login.getLoginId()!=null)
        {
            //   id不为空，密码不为空
            Login login1=loginService.selectLogin(login);

            if(login1==null)
            {
            //id不为空，但是id不存在数据库
            ModelAndView modelAndView=new ModelAndView("loginUpdateFailed");
                return modelAndView;
            }

             else
            {//   id不为空，id存在，但是password含有空字符或没有字符(包括空格）
                String s=login.getLoginPassword();int len=s.length();int count=0;
                for(int i=0;i<len;i++){char tem=s.charAt(i);if(tem==' ') count++;}
                if(count>=0&&len==0)
                {
                    ModelAndView modelAndView=new ModelAndView("loginUpdateFailed");
                return modelAndView;
                }
                else
                {
                //   id不为空，id不存在，且password不含任何空字符
                loginService.updateLogin(login);
                ModelAndView modelAndView=new ModelAndView("loginUpdateSuccess");
                return modelAndView;
                }
            }
        }
        else
        {
            //   id为空，修改失败,重新提交
            ModelAndView modelAndView=new ModelAndView("loginUpdateFailed");
            return modelAndView;
        }
    }

    //账号注册跳转页面
    @RequestMapping("loginRegister")
    public ModelAndView loginRegister(Login login)
    {
        ModelAndView modelAndView=new ModelAndView("loginRegisterVerify");
        return modelAndView;
    }

    //修改密码跳转页面
    @RequestMapping("loginUpdate")
    public ModelAndView loginUpdate(Login login)
    {
        ModelAndView modelAndView=new ModelAndView("loginUpdateVerify");
        return modelAndView;
    }

    //账号登陆跳转页面
    @RequestMapping("login")
    public ModelAndView login(Login login)
    {
        ModelAndView modelAndView=new ModelAndView("loginVerify");
        return modelAndView;
    }
}
