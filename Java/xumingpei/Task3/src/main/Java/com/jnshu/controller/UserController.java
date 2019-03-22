package com.jnshu.controller;

import com.jnshu.pojo.ResultBean;
import com.jnshu.pojo.User;
import com.jnshu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author pipiretrak
 * @date 2019/3/21 - 17:30
 */
@Controller
public class UserController {
    private static Logger logger = Logger.getLogger(String.valueOf(BannerController.class));
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public ResultBean selectByDynamic(@RequestParam(value = "name",required = false) String name,
                                      @RequestParam(value = "id", required = false) long id){
        logger.info(name+","+id);
        logger.info("-----查询被调用-----");
        ResultBean resultBean = new ResultBean();
        List<User> user = userService.selectByDynamic(name,id);
        if (user == null || user.size() == 0){
            resultBean.setCode(-1);
            resultBean.setMsg("查询全部失败");
            resultBean.setData("无法查找结果");
        }else {
            resultBean.setCode(200);
            resultBean.setMsg("查询全部成功");
            resultBean.setData(user);
        }
        logger.info("：查询结果"+user);
        return resultBean;
    }

    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public ResultBean insertBanner(User record) {
        logger.info("----添加被调用-----");
        logger.info("：添加的数据" + record);
        ResultBean resultBean = new ResultBean();
        int x = userService.insert(record);
        logger.info("结果" + x);
        if (x == 0) {
            resultBean.setCode(-1);
            resultBean.setMsg("添加失败");
        } else {
            resultBean.setCode(200);
            resultBean.setMsg("添加成功");
        }
        return resultBean;
    }

    @ResponseBody
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResultBean updateBanner(@RequestParam Long id, User record) {
        logger.info("----更新方法被调用-----");
        logger.info("：更新内容" + record);
        ResultBean resultBean = new ResultBean();
        int x = userService.updateByPrimaryKey(record);
        if (x == 0) {
            resultBean.setCode(-1);
            resultBean.setMsg("修改失败");
        } else {
            resultBean.setCode(200);
            resultBean.setMsg("修改成功");
        }
        return resultBean;
    }

    @ResponseBody
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResultBean deleteBanner(@PathVariable Long id) {
        logger.info("----删除方法被调用-----");
        logger.info("：删除数据的id为" + id);
        ResultBean resultBean = new ResultBean();
        int x = userService.deleteByPrimaryKey(id);
        if (x == 0) {
            resultBean.setCode(-1);
            resultBean.setMsg("删除失败");
        } else {
            resultBean.setCode(200);
            resultBean.setMsg("删除成功");
        }
        return resultBean;
    }

    @ResponseBody
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResultBean getId(@PathVariable Long id){
        logger.info("：获取传参id为："+id);
        ResultBean resultBean = new ResultBean();
        User record = userService.selectByPrimaryKey(id);
        logger.info("结果"+record);
        if (record == null){
            resultBean.setCode(-1);
            resultBean.setMsg("查询ID失败");

        } else {
            resultBean.setCode(200);
            resultBean.setMsg("查询ID成功");
            resultBean.setData(record);
        }
        return resultBean;
    }
}
