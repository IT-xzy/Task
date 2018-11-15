package task6_redis.controlller.json;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import task6_redis.controlller.LoginController;
import task6_redis.pojo.User;
import task6_redis.service.UserService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/json")
public class LoginJsonController {
    private static Logger logger = Logger.getLogger(LoginController.class);
    @Resource(name = "userServiceImpl")
    private UserService userService;
    //注册返回json数据
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    public String register(@RequestBody User user){
        logger.info("进入register()");
        //加入注册的时间
        user.setCreatTime(System.currentTimeMillis());
        logger.info(user);
        //调用useService.register保存注册信息
        String str =userService.register(user);
        //绑定保存是否成功的信息返回到页面
        logger.info(str);
        return str;
    }
}
