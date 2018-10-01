package com.jnshu.controller;

import com.jnshu.exception.UserException;
import com.jnshu.model.User;
import com.jnshu.model.UserCustom;
import com.jnshu.model.UserQV;
import com.jnshu.service.UserService;
import com.jnshu.validation.ValidationInsert;
import com.jnshu.validation.ValidationUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/* 普通风格 */
/*响应规则
  功能      jsp文件          响应                         返回值
查询用户    userList      /userList.action      按条件查询数据,条件为空时返回所有用户数据
添加用户    userList      /rest/list            成功: redirect:userList.action,数据效验失败 forward:userList.action,进行数据回显
删除用户    userList      /userDelete.action    redirect:userList.action
编辑用户    userEdit      /userEdit.action      返回编辑用户信息,回显到userEdit
更新用户    userEdit      /userEditSubmit.actio 成功: redirect:userList.action 数据效验失败 forward:userEdit.action,进行数据回显*/


@Controller
public class UserController {
    //设置本类的log
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    //首页跳转到综合页面 这是被 springmvc_rest 拦截处理的
    @RequestMapping("/")
    public String test() {
        return "redirect:/rest/list";
    }
    //综合页面
    @RequestMapping("/userList.action")
    public String UserList(Model model, UserQV userQV) throws Exception {
        if (userQV != null) {
            logger.debug("userQV.getUserCustom(): " + userQV.getUserCustom());
            logger.debug("userQV.getUser(): " + userQV.getUser());
            logger.info("LogInfo 测试");
            logger.warn("Warn 测试");
        }
        List<UserCustom> userList = userService.findUserMore(userQV);
        //数据回显
        model.addAttribute("findUserCustom", userQV.getUserCustom());
        model.addAttribute("userList", userList);
        return "userList";
    }

    //将数据回显到编辑页面
    @RequestMapping("/userEdit.action")
    public String userEdit(Model model, Integer id) throws Exception {
        //查询用户信息
        UserCustom userCustom = userService.findUserById(id);
        //判断是否查询到数据,查询不到提示错误
        if(userCustom == null){
            //抛出异常信息
            throw new UserException("修改的用户id不存在!");
        }
        logger.debug("userCustom.toString(): " + userCustom.toString());

        model.addAttribute("userCustom", userCustom);
        return "userEdit";
    }

    //将更新数据写入数据库,返回用户列表页面
    @RequestMapping("/userEditSubmit.action")
    public String userEditSubmit(Model model, Integer id, @Validated(value = {ValidationUpdate.class}) UserCustom userCustom, BindingResult bindingResult) throws Exception {
        /* 效验输入信息 */
        if (bindingResult.hasErrors()) {
            //输出错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                //输出错误信息
                logger.error(objectError.getDefaultMessage());
            }
            //将错误传到页面
            model.addAttribute("allErrors", allErrors);
            //数据回显
            model.addAttribute("userCustom", userCustom);
            //出错之后要跳转的页面
            return "forward:userEdit.action";
        }
        logger.debug("提交信息: " + userCustom);
        /*userService.updateUser(userCustom, id);
        return "redirect:/userList.action";*/
        if (userService.updateUser(userCustom, id)) {
            logger.info("更新成功: " + userCustom.toString());
            // 插入成功返回列表页面并显示插入用户
            // model.addAttribute("findUserCustom",userCustom);
            return "redirect:userList.action";
        }
        //插入失败跳回编辑页面将数据回显
        logger.error("更新失败");
        return "forward:userEdit.action";
    }

    /* 添加用户 */
    @RequestMapping("/userAdd.action")
    public String userAdd(Model model, @Validated(value = {ValidationInsert.class}) User user, BindingResult bindingResult) throws Exception {
        /* 效验输入信息 */
        if (bindingResult.hasErrors()) {
            //输出错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                //输出错误信息
                logger.error(objectError.getDefaultMessage());
            }
            //将错误传到页面
            model.addAttribute("allErrors", allErrors);
            //数据回显
            model.addAttribute("userEcho", user);
            //出错之后要跳转的页面
            return "forward:userList.action";
        }
        userService.insertUser(user);
        return "redirect:userList.action";
    }

    /* 删除用户 */
    @RequestMapping("/userDelete.action")
    public String userDelete(Model model, Integer id) throws Exception {
        logger.debug("删除id: " + id);
        if (id > 0) {
            userService.deleteUser(id);
            return "redirect:userList.action";
        } else {
            String allErrors = "id必须大于0";
            model.addAttribute("allErrors", allErrors);
            return "forward:userList.action";
        }
    }
}
