package com.controller;

import com.mapper.UserMapper;
import com.model.Page;
import com.model.Result;
import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/*
 * @ClassName:UserController
 * @Description:
 * @Author qiao
 * @Date 2018/7/04 19:42
 **/
@Controller
public class UserController {
    private static Logger logger = Logger.getLogger("UserController.class");
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    /**
     * @param {count}
     * @return list
     * @mathodName selectAll
     * @Description 查询，分页显示
     * @date 2018/7/14 14:38
     */
    @RequestMapping(value = "/userList")
    public ModelAndView selectAll(Page page, ModelAndView modelAndView) {

        logger.info("selectList:page" + page.toString());

//        page.setCount(10);
        List<User> list = new ArrayList<>();
        page.calculateLast(userService.total());
        list = userService.selectAll(page);

        logger.info("selectList:list" + list.size());

        modelAndView.addObject("list", list);
        modelAndView.setViewName("listUser");
        return modelAndView;
    }

    /**
     * @param user
     * @return result&user
     * @mathodName addUser
     * @Description 新增用户信息
     * @date 2018/7/14 14:40
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ModelAndView addUser(User user, ModelAndView modelAndView, Result result) {

        logger.info("addUser:user" + user.toString());

        if (user.getName() != null) {
            //新增成功{"code":0,"message":"新增成功"} {"id":104848,"name":"小猪佩奇","type":"java"}
            userService.addUser(user);
            result.setCode(0);
            result.setMsg("新增成功");
            modelAndView.addObject("user", user);
        } else {
            // 新增失败{"code":1,"message":"信息不完整"} {"id":"","name":"","type":"java"}
            result.setCode(1);
            result.setMsg("信息不完整");
        }

        logger.info("addUser:result" + result + "user" + user);

        modelAndView.setViewName("/showUser");
        modelAndView.addObject("result", result);
        return modelAndView;
    }

    /**
     * @param {id}
     * @return result&user
     * @mathodName selectUser
     * @Description 根据id查询
     * @date 2018/7/14 14:41
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ModelAndView selectUser(User user, ModelAndView modelAndView, Result result) {

        logger.info("selectUser:id" + user.getId());

        user = userService.selectById(user);
        try {
            // 成功返回值{"code":0,"message":"查询成功"} {"id":1,"name":"程荣强","type":"web工程师"}
            if (user.getName() != null) {
                result.setCode(0);
                result.setMsg("查询成功");
            }
        } catch (Exception e) {
            // 失败返回值{"code":1,"message":"用户不存在"} {"id":"","name":"","type":""}
            result.setCode(1);
            result.setMsg("用户不存在");
        }

        logger.info("selectUser:result" + result.toString() + "" + "user" + user.toString());

        modelAndView.setViewName("showUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    /**
     * @param {id}
     * @return result
     * @mathodName deleteUser
     * @Description 根据id删除
     * @date 2018/7/14 14:42
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteUser(User user, ModelAndView modelAndView, Result result) {

        logger.info("deleteUser:id" + user.getId());

        try {
            //删除成功返回值{"code":0,"message":"删除成功"}
            userService.deleteById(user);
            result.setCode(0);
            result.setMsg("删除成功");
        } catch (Exception e) {
            result.setCode(1);
            result.setMsg("删除失败");
        }

        logger.info("deleteUser:result" + result.toString());

        modelAndView.addObject("result", result);
        modelAndView.setViewName("change");
        return modelAndView;
    }

    /**
     * @param {name}
     * @return result
     * @mathodName updateUser
     * @Description 根据name更改信息
     * @date 2018/7/14 14:43
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ModelAndView updateUser(User user, ModelAndView modelAndView, Result result) {

        logger.info("updateUser:user" + user.toString());

        int i = userService.updateTypeByName(user);
        if (i > 0) {
            //更新成功返回值{"code":0,"message":"更新成功"}
            result.setCode(0);
            result.setMsg("更新成功");
        } else {
            //更新失败返回值{"code":1,"message":"用户不存在"}
            result.setCode(1);
            result.setMsg("用户不存在");
        }

        logger.info("updateUser:result" + result.toString());

        modelAndView.addObject("result", result);
        modelAndView.setViewName("change");
        return modelAndView;
    }
}
