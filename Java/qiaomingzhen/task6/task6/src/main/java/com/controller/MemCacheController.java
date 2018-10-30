package com.controller;
/*
 * @ClassName:CacheControllerM
 * @Description:TODO
 * @Author qiao
 * @Date 2018/8/17 19:22
 **/

import com.model.People;
import com.service.UserService;
import com.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.apache.log4j.Logger;

@Component
@Controller
public class MemCacheController {
    private static Logger logger = Logger.getLogger("CacheControllerM.class");

    @Autowired
//    @Qualifier("userServiceImpl")
    @Qualifier("userServiceMemImpl")
//    @Qualifier("userServiceRedisImpl")
    private UserService userService;

    /**
     * @param people
     * @return result
     * @mathodName addPeople
     * @Description 添加用户接口
     * @date 2018/8/14 20:19
     */
    @RequestMapping(value = "/people11", method = RequestMethod.POST)
    public ModelAndView addPeople11(ModelAndView modelAndView, People people, Result result) {

        logger.info("addPeople:People" + people.toString());
        //设置用户创建时间
        people.setCreatTime(System.currentTimeMillis());
        try {
            //添加用户信息
            userService.addUser(people);
            result.setMsg("添加用户成功");
            logger.info("缓存新增用户信息成功");
        } catch (Exception e) {
            logger.info("添加用户失败");
            result.setMsg("添加用户失败");
        }
        modelAndView.addObject("result", result);
        modelAndView.setViewName("updatePeople");

        logger.info("addPeople:result===" + result);
        return modelAndView;
    }

    /**
     * @param id
     * @return people
     * @mathodName selectPeopleById
     * @Description 根据id查询用户信息接口
     * @date 2018/8/14 20:20
     */
    @RequestMapping(value = "/people11", method = RequestMethod.GET)
    public ModelAndView selectPeopleById11(ModelAndView modelAndView, long id, Result result) {

        logger.info("selectPeopleById:id===" + id);
        try {
            //根据id查询用户信息
            People people = userService.selectById(id);
            //添加缓存
            modelAndView.addObject("people", people);
            logger.info("selectPeopleById:people===" + people.toString());
        } catch (Exception e) {
            e.getMessage();
            result.setMsg("用户不存在");
            modelAndView.addObject("result", result);
        }
        modelAndView.setViewName("showPeople");
        return modelAndView;
    }
}


