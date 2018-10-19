package com.controller;

import com.model.Code;
import com.model.People;
import com.service.UserService;
import com.util.task7.NoteUtil;
import com.util.Result;
import com.whalin.MemCached.MemCachedClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/*
 * @ClassName:NoteController
 * @Description:手机号绑定
 * @Author qiao
 * @Date 2018/8/25 20:15
 **/
@Component
@Controller
public class NoteController {
    private static Logger logger = Logger.getLogger("NoteController.class");
    @Autowired
    private UserService userService;
    @Autowired
    private NoteUtil noteUtil;

    /**
     * @param people, request, result
     * @return org.springframework.web.servlet.ModelAndView
     * @mathodName addTel
     * @Description 验证randCode，更新数据库
     * @date 2018/8/25 14:41
     */
    @RequestMapping(value = "/peopleTel", method = RequestMethod.POST)
    public String addTel(People people, HttpServletRequest request, Result result) {
        long tel = Long.valueOf(request.getParameter("tel"));
        String name=(String)request.getSession().getAttribute("name");
        logger.info("addTel：参数people：" + people.toString());
        logger.info("addTel：参数randCode：" + request.getParameter("rand_Code")+"tel"+tel+"name"+name);

        //查询数据库，验证码对比
        logger.info(noteUtil.checkRandCode(request.getParameter("rand_Code"), tel));
        if (noteUtil.checkRandCode(request.getParameter("rand_Code"), tel)) {
            people.setUpdateTime(System.currentTimeMillis());
            people.setTel(tel);
            people.setName(name);
            //更新数据库
            userService.updatePeople(people);
            result.setCode(0);
            result.setMsg("绑定成功");
        } else {
            result.setCode(-103);
            result.setMsg("绑定失败");
        }
        return "json";
    }

    /**
     * @param modelAndView, name, result
     * @return org.springframework.web.servlet.ModelAndView
     * @mathodName skipTel
     * @Description 手机跳转页
     * @date 2018/8/25 14:43
     */
    @RequestMapping(value = "/tel")
    public ModelAndView skipTel(ModelAndView modelAndView, String name, Result result) {
        modelAndView.setViewName("tel");
        return modelAndView;
    }
}
