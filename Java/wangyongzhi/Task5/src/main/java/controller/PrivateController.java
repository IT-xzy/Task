package controller;


import model.Prof;
import model.Users;
import net.rubyeye.xmemcached.MemcachedClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.ProfService;
import service.utils.GetUserUtil;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/u")//此controller都带前缀/u，进入之前会被拦截器拦截
public class PrivateController {
    private Logger logger = LogManager.getLogger(PrivateController.class);

    @Autowired
    ProfService profService;

    @Autowired
    GetUserUtil getUserUtil;

    //原版不使用缓存
    @RequestMapping(value = "/profession", method = RequestMethod.GET)
    public ModelAndView listProf(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        //增加检查cookie并展示用户名模块
        Users user = getUserUtil.getUser(request);
        mav.addObject("user", user);

        mav.addObject("prof", profService.getByProf("java后端工程师"));
        mav.setViewName("profession");
        return mav;
    }

}
